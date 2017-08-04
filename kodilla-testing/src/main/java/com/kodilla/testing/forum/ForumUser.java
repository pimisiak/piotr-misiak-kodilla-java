package com.kodilla.testing.forum;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForumUser {
    private final String name;
    private final String realName;
    private final List<ForumPost> posts = new ArrayList<ForumPost>();
    private final List<ForumComment> comments = new LinkedList<ForumComment>();

    public ForumUser(final String name, final String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(final String author, final String postBody) {
        final ForumPost post = new ForumPost(postBody, author);
        posts.add(post);
    }

    public void addComment(final ForumPost post, final String author, final String commentBody) {
        final ForumComment comment = new ForumComment(post, commentBody, author);
        comments.add(comment);
    }

    public int getPostsQuantity() {
        return posts.size();
    }

    public int getCommentsQuantity() {
        return comments.size();
    }

    public ForumPost getPost(final int postNumber) {
        Preconditions.checkArgument(postNumber >= 0 && postNumber < posts.size());
        return posts.get(postNumber);
    }

    public ForumComment getComment(final int commentNumber) {
        Preconditions.checkArgument(commentNumber >= 0 && commentNumber < comments.size());
        return comments.get(commentNumber);
    }

    public boolean removePost(final ForumPost post) {
        Preconditions.checkNotNull(post);
        if (posts.contains(post)) {
            posts.remove(post);
            return true;
        }
        return false;
    }

    public boolean removeComment(final ForumComment comment) {
        Preconditions.checkNotNull(comment);
        if (comments.contains(comment)) {
            comments.remove(comment);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
