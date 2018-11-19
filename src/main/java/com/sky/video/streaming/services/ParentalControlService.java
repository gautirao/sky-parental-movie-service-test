package com.sky.video.streaming.services;

import com.sky.video.streaming.services.exceptions.TechnicalFailureException;
import com.sky.video.streaming.services.exceptions.TitleNotFoundException;

public interface ParentalControlService {
    boolean isAllowedToWatch(String movieId, String userParentalControlLevelPreference) throws TechnicalFailureException, TitleNotFoundException;

}
