package com.kodilla.testing2.facebook;

import java.time.LocalDate;

public interface FacebookUser {
    String getFirstName();
    String getLastName();
    LocalDate getBirthday();
    String getMobile();
    String getPassword();
    Gender getGender();
}
