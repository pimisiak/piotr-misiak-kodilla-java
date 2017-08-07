package com.kodilla.testing.library;

public class LibraryUser {
    private String firstName;
    private String lastName;
    private String peselId;

    public LibraryUser(final String firstName, final String lastName, final String peselId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselId = peselId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPeselId() {
        return peselId;
    }

    @Override
    public String toString() {
        return "LibraryUser{firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", peselId='" + peselId + '\'' + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LibraryUser that = (LibraryUser) o;
        return firstName.equals(that.firstName) && lastName.equals(that.lastName) && peselId.equals(that.peselId);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + peselId.hashCode();
        return result;
    }
}
