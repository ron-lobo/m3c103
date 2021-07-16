package org.ron.m3.spring.example2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class HWHelperTest {

    @Mock
    private GreetingService greetingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sayHi() {
        Mockito.when(greetingService.makeGreeting(Mockito.anyString())).thenReturn(123).thenReturn(321).thenReturn(999).thenThrow(new RuntimeException("bad call"));

        HWHelper hwHelper = new HWHelper(greetingService);
        hwHelper.sayHi();

        Mockito.verify(greetingService, Mockito.times(1)).makeGreeting("hi");
    }
}