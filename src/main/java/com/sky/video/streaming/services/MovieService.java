package com.sky.video.streaming.services;

import com.sky.video.streaming.services.exceptions.TechnicalFailureException;
import com.sky.video.streaming.services.exceptions.TitleNotFoundException;

public interface MovieService {
    String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException;
}
