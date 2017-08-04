package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.*;

public class ForumTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.printf("Preparing to execute test #%s%n", testCounter);
    }

    @Test
    public void testAddPost() {
        //Given
        final ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        //When
        forumUser.addPost("mrsmith","Hello everyone, this is my first contribution here!");
        //Then
        Assert.assertEquals(1, forumUser.getPostsQuantity());
    }

    @Test
    public void testAddComment() {
        //Given
        final ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        final ForumPost post = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        //When
        forumUser.addComment(post, "mrsmith", "Thank you for all good words!");
        //Then
        Assert.assertEquals(1, forumUser.getCommentsQuantity());
    }

    @Test
    public void testGetPost() {
        //Given
        final ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        final ForumPost post = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        forumUser.addPost(post.getAuthor(), post.getPostBody());
        //When
        final ForumPost retrievedPost = forumUser.getPost(0);
        //Then
        Assert.assertEquals(post, retrievedPost);
    }

    @Test
    public void testGetComment() {
        //Given
        final ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        final ForumPost post = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        final ForumComment comment = new ForumComment(post, "mrsmith","Thank you for all good words!");
        forumUser.addComment(post, comment.getAuthor(), comment.getCommentBody());
        //When
        final ForumComment retrievedComment = forumUser.getComment(0);
        //Then
        Assert.assertEquals(comment, retrievedComment);
    }

    @Test
    public void testRemovePostNotExisting() {
        //Given
        final ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        final ForumPost post = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        //When
        final boolean result = forumUser.removePost(post);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveCommentNotExisting() {
        //Given
        final ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        final ForumPost post = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        final ForumComment comment = new ForumComment(post, "mrsmith","Thank you for all good words!");
        //When
        final boolean result = forumUser.removeComment(comment);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemovePost() {
        //Given
        final ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        final ForumPost post = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        forumUser.addPost(post.getAuthor(), post.getPostBody());
        //When
        final boolean result = forumUser.removePost(post);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getPostsQuantity());
    }

    @Test
    public void testRemoveComment() {
        //Given
        final ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        final ForumPost post = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        final ForumComment comment = new ForumComment(post, "mrsmith","Thank you for all good words!");
        forumUser.addComment(post, comment.getAuthor(), comment.getCommentBody());
        //When
        final boolean result = forumUser.removeComment(comment);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getCommentsQuantity());
    }
}
