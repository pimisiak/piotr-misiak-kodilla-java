package com.kodilla.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        final DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectedUsers() throws SQLException {
        //Given
        final DbManager dbManager = DbManager.getInstance();
        //When
        final String sqlQuery = "select * from users";
        final Statement statement = dbManager.getConnection().createStatement();
        final ResultSet resultSet = statement.executeQuery(sqlQuery);
        int counter = 0;
        while (resultSet.next()) {
            System.out.printf("%d, %s, %s%n", resultSet.getInt("ID"), resultSet.getString("firstname"), resultSet.getString("lastname"));
            counter++;
        }
        resultSet.close();
        statement.close();
        //Then
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //Given
        final DbManager dbManager = DbManager.getInstance();
        //When
        final String sqlQuery = "select count(*) num_of_posts, firstname, lastname\n" +
                "from posts p inner join users u on p.user_id = u.id\n" +
                "group by firstname, lastname\n" +
                "having count(*) >= 2;";
        final Statement statement = dbManager.getConnection().createStatement();
        final ResultSet resultSet = statement.executeQuery(sqlQuery);
        int counter = 0;
        while (resultSet.next()) {
            counter++;
        }
        resultSet.close();
        statement.close();
        //Then
        Assert.assertEquals(2, counter);
    }
}
