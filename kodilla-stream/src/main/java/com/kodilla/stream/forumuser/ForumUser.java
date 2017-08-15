package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int idNumber;
    private final String userName;
    private final char sex;
    private final LocalDate birthday;
    private final int numberOfPosts;

    ForumUser(final int idNumber, final String userName, final char sex, final LocalDate birthday, final int numberOfPosts) {
        this.idNumber = idNumber;
        this.userName = userName;
        this.sex = sex;
        this.birthday = birthday;
        this.numberOfPosts = numberOfPosts;
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
}
