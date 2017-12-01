package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;

import java.time.LocalDate;

public class FacebookTestingApp {

    public static void main(final String[] args) {
        final FacebookAccountBot facebookAccountBot = new FacebookAccountBotImpl(WebDriverConfig.getDriver(WebDriverConfig.CHROME));
        facebookAccountBot.createAccount(new FacebookUserImpl.UserBuilder()
                .birthday(LocalDate.of(1956, 12, 21))
                .firstName("John")
                .lastName("Smith")
                .gender(Gender.MALE)
                .build());
    }
}
