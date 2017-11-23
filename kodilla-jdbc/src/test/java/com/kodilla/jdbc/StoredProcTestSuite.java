package com.kodilla.jdbc;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class StoredProcTestSuite {
    @Test
    public void testUpdatedVipLevel() throws SQLException {
        //Given
        final DbManager dbManager = DbManager.INSTANCE;
        final String sqlUpdate = "UPDATE readers SET vip_level = \"Not set\"";
        final String sqlProcedureCall = "CALL sp_updateVipLevels";
        final String sqlCheckTable = "SELECT COUNT(*) AS how_many FROM readers WHERE vip_level=\"Not set\"";
        int howMany = -1;
        try (final Statement statement = dbManager.getConnection().createStatement()) {
            statement.executeUpdate(sqlUpdate);
            //When
            statement.execute(sqlProcedureCall);
            //Then
            try (final ResultSet rs = statement.executeQuery(sqlCheckTable)){
                if (rs.next()) {
                    howMany = rs.getInt("how_many");
                }
            }
        }
        assertEquals(0, howMany);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        //Given
        final DbManager dbManager = DbManager.INSTANCE;
        final String sqlUpdate = "UPDATE books SET bestseller = false";
        final String sqlProcedureCall = "CALL sp_updateBestsellers";
        final String sqlCheckTable = "SELECT bestseller AS updated FROM books WHERE book_id = 5";
        int updated = 0;
        try (final Statement statement = dbManager.getConnection().createStatement()) {
            statement.executeUpdate(sqlUpdate);
            //When
            statement.execute(sqlProcedureCall);
            //Then
            try (final ResultSet rs = statement.executeQuery(sqlCheckTable)) {
                if (rs.next()) {
                    updated = rs.getInt("updated");
                }
            }
        }
        assertEquals(1, updated);
    }
}
