package com.sky.video.streaming.services;

import com.sky.video.streaming.services.exceptions.TechnicalFailureException;
import com.sky.video.streaming.services.exceptions.TitleNotFoundException;

import java.util.Optional;
import java.util.logging.Logger;

import static com.sky.video.streaming.services.utitilty.MovieHelper.getParentalControlLevelValue;

public class ParentalControlServiceImpl implements ParentalControlService {

    private static final Logger LOG = Logger.getLogger((ParentalControlServiceImpl.class.getName()));

    private MovieService movieService;

    public ParentalControlServiceImpl() {
    }

    public ParentalControlServiceImpl(MovieService movieService) throws TechnicalFailureException {

        if (movieService == null) {
            // log information here
            throw new TechnicalFailureException("Movie service is unavailable ");
        }
        this.movieService = movieService;
    }

    @Override
    public boolean isAllowedToWatch(String movieId, String userParentalControlLevelPreference) throws TechnicalFailureException, TitleNotFoundException {

        String movieParentalControlLevel = getParentalControlLevel(movieId);

        return getParentalControlLevelValue(movieParentalControlLevel) <= getParentalControlLevelValue(userParentalControlLevelPreference);
    }

    private String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException {
        try {
            String controlLevel =Optional.ofNullable(movieService.getParentalControlLevel(movieId))
                    .map(o -> o)
                    .orElseThrow(() -> new TechnicalFailureException("unable to fetch control level from movie service"));

            return controlLevel;
        } catch (TechnicalFailureException | TitleNotFoundException ex) {
            //Log exception here
            throw ex;
        } catch (Exception ex) {
            //RuntimeExceptions being thrown from MovieService
            //Log exception here
            throw new TechnicalFailureException("There is some problem with Movie Service");
        }


    }

    public MovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
}
