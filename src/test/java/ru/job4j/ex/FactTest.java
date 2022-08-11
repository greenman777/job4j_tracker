package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

class FactTest {

    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Fact().calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
    }
}