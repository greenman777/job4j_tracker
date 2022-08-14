package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.InstanceOfAssertFactories.stream;
import static org.junit.Assert.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

class PasswordValidatorTest {

    @Test
    public void whenNullValue() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(null);
                });
        assertThat(exception.getMessage()).isEqualTo("Passport must not be null");
    }

    @Test
    public void whenLengthPasswordNotMatchLess() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("Test");
                });
        assertThat(exception.getMessage()).isEqualTo("Password length must be in the range [8, 32]");
    }

    @Test
    public void whenLengthPasswordNotMatchLarge() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("TestTestTestTestTestTestTestTestTestTestTestTest");
                });
        assertThat(exception.getMessage()).isEqualTo("Password length must be in the range [8, 32]");
    }

    @Test
    public void whenMissingSymbolUpper() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("testtesttest");
                });
        assertThat(exception.getMessage()).isEqualTo("Password must contain at least one uppercase character");
    }

    @Test
    public void whenMissingSymbolLower() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("TESTTESTTEST");
                });
        assertThat(exception.getMessage()).isEqualTo("Password must contain at least one lowercase character");
    }

    @Test
    public void whenMissingSymbolDigital() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("TESTtestTEST");
                });
        assertThat(exception.getMessage()).isEqualTo("Password must contain at least one number");
    }

    @Test
    public void whenMissingSymbolSpecial() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("TESTtest123");
                });
        assertThat(exception.getMessage()).isEqualTo("Password must contain at least one special character");
    }

    @Test
    public void whenStringBan() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("TESTtest12345$");
                });
        assertThat(exception.getMessage()).isEqualTo("Password must not contain words: \"qwerty\", \"12345\", \"password\", \"admin\", \"user\"");
        exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("TESTtestQWerty1$");
                });
        assertThat(exception.getMessage()).isEqualTo("Password must not contain words: \"qwerty\", \"12345\", \"password\", \"admin\", \"user\"");
        exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("TESTtestPassword2$");
                });
        assertThat(exception.getMessage()).isEqualTo("Password must not contain words: \"qwerty\", \"12345\", \"password\", \"admin\", \"user\"");
        exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("TESTtestadmiN3$");
                });
        assertThat(exception.getMessage()).isEqualTo("Password must not contain words: \"qwerty\", \"12345\", \"password\", \"admin\", \"user\"");
        exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("TESTtestUSER4$");
                });
        assertThat(exception.getMessage()).isEqualTo("Password must not contain words: \"qwerty\", \"12345\", \"password\", \"admin\", \"user\"");
    }

    @Test
    public void whenSuccessfully() {
        String password = "Test123$";
        String result = PasswordValidator.validate("Test123$");
        assertThat(result).isEqualTo(password);
    }
}