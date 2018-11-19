package com.sky.video.streaming;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {


    @Mock
    private List mockList;


    @Test
    public void listDoesWorkWithMocks() {
        given(mockList.size()).willReturn(10);

        final int sizeOfTheList = mockList.size();

        assertThat(sizeOfTheList).isEqualTo(10);
    }
}
