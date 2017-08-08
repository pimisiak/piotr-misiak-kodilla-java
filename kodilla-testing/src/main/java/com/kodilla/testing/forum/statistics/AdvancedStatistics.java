package com.kodilla.testing.forum.statistics;

import com.google.common.base.Preconditions;

class AdvancedStatistics {
    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double averageNumberOfPostsPerUser;
    private double averageNumberOfCommentsPerUser;
    private double averageNumberOfCommentsPerPost;

    double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    double getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    double getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }

    void calculateAdvStatistics(final Statistics statistics) {
        validateArgument(statistics);
        storeSimpleStats(statistics);
        calculateAdvStats();
    }

    private void validateArgument(final Statistics statistics) {
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
