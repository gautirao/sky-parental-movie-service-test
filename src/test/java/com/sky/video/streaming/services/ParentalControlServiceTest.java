package com.sky.video.streaming.services;

import com.sky.video.streaming.services.exceptions.TechnicalFailureException;
import com.sky.video.streaming.services.exceptions.TitleNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {


    @Mock
    private MovieService movieService;

    @InjectMocks
    private ParentalControlServiceImpl parentalControlService;


    @Test(expected = TechnicalFailureException.class)
    public void nullMovieServiceShouldThrowTechnicalFailureException() throws Exception {
        new ParentalControlServiceImpl(null);
    }

    @Test(expected = TitleNotFoundException.class)
    public void shouldThrowExceptionWhenMovieNotFound() throws Exception {
        when(movieService.getParentalControlLevel(anyString())).thenThrow(TitleNotFoundException.class);
        parentalControlService.isAllowedToWatch("123", "PG");
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenInvalidParentalLevelSpecified() throws Exception {
        parentalControlService.isAllowedToWatch("123", "UNKNOWN_PARENTAL_LEVEL");
    }

    @Test
    public void shouldReturnTrueWhenLevelSameAsPreferred() throws Exception{

        when(movieService.getParentalControlLevel(anyString())).thenReturn("U");
        assertThat(parentalControlService.isAllowedToWatch("1234","U")).isTrue();

    }
    @Test
    public void shouldReturnTrueWhenLevelHigherThanPreferred() throws Exception{

        when(movieService.getParentalControlLevel(anyString())).thenReturn("U");
        assertThat(parentalControlService.isAllowedToWatch("1234","18")).isTrue();

    }
    @Test
    public void shouldReturnFalseWhenLevelLowerThanPreferred() throws Exception{

        when(movieService.getParentalControlLevel(anyString())).thenReturn("18");
        assertThat(parentalControlService.isAllowedToWatch("1234","U")).isFalse();

    }
    @Test
    public void shouldThrowTechnicalFailureForNullLevel() throws Exception{

        when(movieService.getParentalControlLevel(anyString())).thenReturn(null);
        assertThatExceptionOfType(TechnicalFailureException.class)
                .isThrownBy( () -> {
                    parentalControlService.isAllowedToWatch("1234","U");
                        }
                );

    }
}
