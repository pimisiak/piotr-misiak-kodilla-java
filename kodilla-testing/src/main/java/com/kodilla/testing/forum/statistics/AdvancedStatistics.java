package com.kodilla.testing.forum.statistics;

import com.google.common.base.Preconditions;

public class AdvancedStatistics {
    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double averageNumberOfPostsPerUser;
    private double averageNumberOfCommentsPerUser;
    private double averageNumberOfCommentsPerPost;

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public double getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public double getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }

    public void calculateAdvStatistics(final Statistics statistics) {
        validateArgument(statistics);
        storeSimpleStats(statistics);
        calculateAdvStats();
    }

    private void validateArgument(final Statistics statistics) {
        Preconditions.checkArgument(statistics.usersNames().size() >= 0);
        Preconditions.checkArgument(statistics.postsCount() >= 0);
        Preconditions.checkArgument(statistics.commentsCount() >= 0);
    }

    private void storeSimpleStats(final Statistics statistics) {
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();
    }

    private void calculateAdvStats() {
        if (numberOfUsers == 0) {
            averageNumberOfPostsPerUser = 0;
            averageNumberOfCommentsPerUser = 0;
        } else {
            averageNumberOfPostsPerUser = (double) numberOfPosts / numberOfUsers;
            averageNumberOfCommentsPerUser = (double) numberOfComments / numberOfUsers;
        }

        if (numberOfPosts == 0) {
            averageNumberOfCommentsPerPost = 0;
        } else {
            averageNumberOfCommentsPerPost = (double) numberOfComments / numberOfPosts;
        }
    }
}
