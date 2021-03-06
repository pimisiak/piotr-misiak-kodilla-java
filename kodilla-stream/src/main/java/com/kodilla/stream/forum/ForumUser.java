package com.kodilla.stream.forum;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class ForumUser {
    private final String username;
    private final String realName;
    private final String location;
    private final Set<ForumUser> friends = new HashSet<>();

    ForumUser(final String username, final String realName, final String location) {
        this.username = username;
        this.realName = realName;
        this.location = location;
    }

    void addFriend(final ForumUser user) {
        friends.add(user);
    }

    boolean removeFriend(final ForumUser user) {
        return friends.remove(user);
    }

    Set<String> getLocationsOfFriends() {
        return friends.stream().map(ForumUser::getLocation).collect(Collectors.toSet());
    }

    Set<String> getLocationsOfFriendsOfFriends() {
        return friends.stream()
                .flatMap(user -> user.getFriends().stream())
                .filter(user -> user != this)
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }

    String getUsername() {
        return username;
    }

    String getRealName() {
        return realName;
    }

    String getLocation() {
        return location;
    }

    Set<ForumUser> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "ForumUser{" + "username='" + username + '\'' + ", realName='" + realName + '\'' + ", location='" + location + '\'' + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ForumUser forumUser = (ForumUser) o;
        return username.equals(forumUser.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
