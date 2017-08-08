package com.kodilla.testing.forum;

public class ForumComment {
    private final ForumPost forumPost;
    private final String commentBody;
    private final String author;

    /**
     * Constructor of class ForumComment.
     *
     * @param forumPost Post
     * @param commentBody Comment Body of the specified Post
     * @param author Author of the Comment
     */
    public ForumComment(final ForumPost forumPost, final String commentBody, final String author) {
        this.forumPost = forumPost;
        this.commentBody = commentBody;
        this.author = author;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ForumComment that = (ForumComment) o;
        return forumPost.equals(that.forumPost) && commentBody.equals(that.commentBody) && author.equals(that.author);
    }

    @Override
    public int hashCode() {
        int result = forumPost.hashCode();
        result = 31 * result + commentBody.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ForumComment{forumPost='" + forumPost + "', commentBody='" + commentBody + "', author='" + author + "'}";
    }
}
