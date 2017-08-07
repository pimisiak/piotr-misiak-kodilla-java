package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdvancedStatisticsTestSuite {
    private static int testNumber = 0;
    private Statistics statistics;
    private AdvancedStatistics advStatistics;

    @BeforeClass
    public static void beforeTests() {
        System.out.println("Tests: start");
    }

    @AfterClass
    public static void afterTests() {
        System.out.println("Tests: end");
    }

    @Before
    public void beforeTest() {
        testNumber++;
        statistics = mock(Statistics.class);
        advStatistics = new AdvancedStatistics();
        System.out.printf("Test #%d start%n", testNumber);
    }

    @After
    public void afterTest() {
        System.out.printf("Test #%d end%n", testNumber);
    }

    @Test
    public void testCalculateAdvStatisticsNoUsers() {
        //Given
        when(statistics.commentsCount()).thenReturn(100);
        when(statistics.postsCount()).thenReturn(100);
        when(statistics.usersNames()).thenReturn(Collections.emptyList());
        //When
        advStatistics.calculateAdvStatistics(statistics);
        //Then
        System.out.println("Test calculateAdvStatistics with no users.");
        Assert.assertEquals(0, advStatistics.getAverageNumberOfPostsPerUser(), 2);
        Assert.assertEquals(0, advStatistics.getAverageNumberOfCommentsPerUser(), 2);
        Assert.assertEquals(1, advStatistics.getAverageNumberOfCommentsPerPost(), 2);
    }

    @Test
    public void testCalculateAdvStatisticsNoComments() {
        //Given
        final List<String> users = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            users.add(String.format("user%d", i));
        }
        when(statistics.commentsCount()).thenReturn(0);
        when(statistics.postsCount()).thenReturn(100);
        when(statistics.usersNames()).thenReturn(users);
        //When
        advStatistics.calculateAdvStatistics(statistics);
        //Then
        System.out.println("Test calculateAdvStatistics with no comments.");
        Assert.assertEquals(1, advStatistics.getAverageNumberOfPostsPerUser(), 2);
        Assert.assertEquals(0, advStatistics.getAverageNumberOfCommentsPerUser(), 2);
        Assert.assertEquals(0, advStatistics.getAverageNumberOfCommentsPerPost(), 2);
    }

    @Test
    public void testCalculateAdvStatisticsNoPosts() {
        //Given
        final List<String> users = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            users.add(String.format("user%d", i));
        }
        when(statistics.commentsCount()).thenReturn(100);
        when(statistics.postsCount()).thenReturn(0);
        when(statistics.usersNames()).thenReturn(users);
        //When
        advStatistics.calculateAdvStatistics(statistics);
        //Then
        System.out.println("Test calculateAdvStatistics with no posts.");
        Assert.assertEquals(0, advStatistics.getAverageNumberOfPostsPerUser(), 2);
        Assert.assertEquals(1, advStatistics.getAverageNumberOfCommentsPerUser(), 2);
        Assert.assertEquals(0, advStatistics.getAverageNumberOfCommentsPerPost(), 2);
    }

    @Test
    public void testCalculateAdvStatisticsMoreComments() {
        //Given
        final List<String> users = new ArrayList<String>();
        for (int i = 0; i < 150; i++) {
            users.add(String.format("user%d", i));
        }
        when(statistics.commentsCount()).thenReturn(100);
        when(statistics.postsCount()).thenReturn(200);
        when(statistics.usersNames()).thenReturn(users);
        //When
        advStatistics.calculateAdvStatistics(statistics);
        //Then
        System.out.println("Test calculateAdvStatistics with more comments than posts.");
        Assert.assertEquals(1.33, advStatistics.getAverageNumberOfPostsPerUser(), 2);
        Assert.assertEquals(0.67, advStatistics.getAverageNumberOfCommentsPerUser(), 2);
        Assert.assertEquals(0.5, advStatistics.getAverageNumberOfCommentsPerPost(), 2);
    }

    @Test
    public void testCalculateAdvStatisticsMorePosts() {
        //Given
        final List<String> users = new ArrayList<String>();
        for (int i = 0; i < 1500; i++) {
            users.add(String.format("user%d", i));
        }
        when(statistics.commentsCount()).thenReturn(2000);
        when(statistics.postsCount()).thenReturn(1000);
        when(statistics.usersNames()).thenReturn(users);
        //When
        advStatistics.calculateAdvStatistics(statistics);
        //Then
        System.out.println("Test calculateAdvStatistics with more posts than comments.");
        Assert.assertEquals(0.67, advStatistics.getAverageNumberOfPostsPerUser(), 2);
        Assert.assertEquals(1.33, advStatistics.getAverageNumberOfCommentsPerUser(), 2);
        Assert.assertEquals(2, advStatistics.getAverageNumberOfCommentsPerPost(), 2);
    }
}
