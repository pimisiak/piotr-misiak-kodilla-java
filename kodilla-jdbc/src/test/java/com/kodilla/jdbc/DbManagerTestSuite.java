package com.kodilla.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;

import static java.util.Optional.ofNullable;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        //Given
        //DbManager
        //When
        //DbManager
        //Then
        Assert.assertNotNull(DbManager.INSTANCE.getConnection());
    }

    @Test
    public void testSelectedUsers() throws SQLException {
        //Given
        final String sqlQuery = "select * from users";
        //When
        try (final Statement statement = DbManager.INSTANCE.getConnection().createStatement();
             final ResultSet resultSet = statement.executeQuery(sqlQuery)) {
            //Then
            Assert.assertEquals(5, countResultSet(resultSet));
        }
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //Given
        final String sqlQuery =
                "select count(*) num_of_posts, firstname, lastname\n" +
                "from posts p inner join users u on p.user_id = u.id\n" +
                "group by firstname, lastname\n" +
                "having count(*) >= 2;";
        //When
        try (final Statement statement = DbManager.INSTANCE.getConnection().createStatement();
             final ResultSet resultSet = statement.executeQuery(sqlQuery)) {
            //Then
            Assert.assertEquals(2, countResultSet(resultSet));
        }
    }

    @Test
    public void testSelectUsersAndTasks() throws SQLException {
        //Given
        final String sqlQuery =
                "select firstname, lastname, summary, description\n" +
                "from users u\n" +
                "inner join tasksNotUsed t\n" +
                "on t.user_id = u.id\n" +
                "where firstname = ?\n" +
                "and tasklist_id = ?;";
        //When
        try (final PreparedStatement preparedStatement = DbManager.INSTANCE.getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, "John");
            preparedStatement.setInt(2, 1);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                Assert.assertEquals(2, countResultSet(resultSet));
            }
        }
    }

    private int countResultSet(final ResultSet resultSet) throws SQLException {
        int counter = 0;
        while (resultSet.next()) {
            counter++;
        }
        return counter;
    }
}
