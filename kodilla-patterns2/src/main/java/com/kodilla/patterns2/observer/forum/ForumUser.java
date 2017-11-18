package com.kodilla.patterns2.observer.forum;

public class ForumUser implements Observer {
    private final String username;
    private int updateCount;

    public ForumUser(final String username) {
        this.username = username;
    }

    @Override
    public void update(final ForumTopic forumTopic) {
        System.out.println(String.format("%s: New messages in topic %s%n(total: %d messages)",
                username, forumTopic.getName(), forumTopic.getMessages().size()));
        updateCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
