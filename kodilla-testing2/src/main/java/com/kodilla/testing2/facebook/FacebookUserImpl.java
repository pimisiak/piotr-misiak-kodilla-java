package com.kodilla.testing2.facebook;

import java.time.LocalDate;
import java.util.Random;

public class FacebookUserImpl implements FacebookUser {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;
    private final String mobile;
    private final String password;
    private final Gender gender;

    private FacebookUserImpl(final UserBuilder builder) {
        this.birthday = builder.birthday;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.mobile = generateMobile();
        this.gender = builder.gender;
        this.password = generatePassword();
    }

    private String generateMobile() {
        final Random generator = new Random();
        return String.format("%03d%03d%03d", 500 + generator.nextInt(500), generator.nextInt(1000), generator.nextInt(1000));
    }

    private String generatePassword() {
        return String.format("%s%s%s", String.valueOf(hashCode()), firstName, lastName);
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String getMobile() {
        return mobile;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final FacebookUserImpl that = (FacebookUserImpl) o;
        return firstName.equals(that.firstName) && lastName.equals(that.lastName) && birthday.equals(that.birthday)
                && mobile.equals(that.mobile) && gender == that.gender;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + gender.hashCode();
        return result;
    }

    public static class UserBuilder {
        private LocalDate birthday;
        private String firstName;
        private String lastName;
        private Gender gender;

        UserBuilder birthday(final LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        UserBuilder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        UserBuilder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        UserBuilder gender(final Gender gender) {
            this.gender = gender;
            return this;
        }

        FacebookUserImpl build() {
            return new FacebookUserImpl(this);
        }
    }
}
