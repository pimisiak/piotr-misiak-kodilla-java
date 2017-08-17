package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int idNumber;
    private final String userName;
    private final char sex;
    private final LocalDate birthday;
    private final int numberOfPosts;

    private ForumUser(final ForumUserBuilder builder) {
        this.idNumber = builder.idNumber;
        this.userName = builder.userName;
        this.sex = builder.sex;
        this.birthday = builder.birthday;
        this.numberOfPosts = builder.numberOfPosts;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" + "idNumber=" + idNumber + ", userName='" + userName + '\'' + ", sex=" + sex + ", birthday=" + birthday
                + ", numberOfPosts=" + numberOfPosts + '}';
    }

    static class ForumUserBuilder {
        private final int idNumber;
        private final String userName;
        private char sex;
        private LocalDate birthday;
        private int numberOfPosts;

        ForumUserBuilder(final int idNumber, final String userName) {
            this.idNumber = idNumber;
            this.userName = userName;
        }

        ForumUserBuilder sex(final char sex) {
            this.sex = sex;
            return this;
        }

        ForumUserBuilder birthday(final LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        ForumUserBuilder numberOfPosts(final int numberOfPosts) {
            this.numberOfPosts = numberOfPosts;
            return this;
        }

        ForumUser build() {
            return new ForumUser(this);
        }
    }
}
