package com.kodilla.good.patterns.challenges.order;

final class User {
    private final String userName;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String email;

    private User(final UserBuilder builder) {
        this.userName = builder.userName;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.email = builder.email;
    }

    String getUserName() {
        return userName;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    String getAddress() {
        return address;
    }

    String getEmail() {
        return email;
    }

    static class UserBuilder {
        private final String userName;
        private String firstName;
        private String lastName;
        private String address;
        private String email;

        UserBuilder(final String userName) {
            this.userName = userName;
        }

        UserBuilder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        UserBuilder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        UserBuilder address(final String address) {
            this.address = address;
            return this;
        }

        UserBuilder email(final String email) {
            this.email = email;
            return this;
        }

        User build() {
            return new User(this);
        }
    }
}
