/*
MIT License

Copyright (c) 2021 Dipjyoti Metia

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package com.db;

import com.api.rest.ApiActions;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class DataActions extends ApiActions {

    // Update the PostgreSQL JDBC URL, username, and password as needed
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/your_database";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    /**
     * Establishes a connection to the PostgreSQL database, retrieves data from it,
     * and logs the results using the given query.
     */
    private void getDbConnection() {
        ResultSet rs = null;
        Connection connObj = null;
        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver"); // Update the driver class name
            connObj = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD); // Provide username and password
            if (connObj != null) {
                statement = connObj.createStatement();
                String queryString = "SELECT * FROM your_table LIMIT 10;"; // Update the SQL query
                rs = statement.executeQuery(queryString);
                while (rs.next()) {
                    log.info(rs.getString(2));
                }
            }
        } catch (Exception sqlException) {
            log.error(sqlException.getMessage());
        } finally {
            finallyBlock(rs, connObj, statement);
        }
    }

    /**
     * Executes the given SQL query and returns the result as a string.
     *
     * @param query the SQL query to execute
     * @return the result of the query as a string
     */
    private String executeQuery(String query) {
        String resultValue = "";
        String columnName = "";
        try {
            Class.forName("org.postgresql.Driver"); // Update the driver class name
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        }
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) { // Provide username and password
            try (Statement stmt = connection.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        for (int i = 1; i <= columnCount; i++) {
                            try {
                                rs.getString(i);
                            } catch (NullPointerException e) {
                                resultValue = "NULL";
                                log.info("column name:" + columnName + "|" + "Column value:" + resultValue);
                                continue;
                            }
                            columnName = rsmd.getColumnName(i);
                            resultValue = rs.getString(i);
                            log.info("column name:" + columnName + "|" + "Column value:" + resultValue);
                        }
                    }
                }
                connection.close();
            } catch (SQLException sq) {
                log.error(sq.getMessage());
            }
        } catch (SQLException sq) {
            log.error(sq.getMessage());
        }
        return resultValue;
    }

    /**
     * Displays the values of a specific column from the ResultSet.
     *
     * @param title the name of the column to display
     * @param rs    the ResultSet containing the data
     */
    private void displayRow(String title, ResultSet rs) {
        try {
            while (rs.next()) {
                log.info(rs.getString(title));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Closes the ResultSet, Connection, and Statement objects.
     *
     * @param rs      the ResultSet to close
     * @param connObj the Connection to close
     * @param stmt    the Statement to close
     */
    private void finallyBlock(ResultSet rs, Connection connObj, Statement stmt) {
        if (rs != null) try {
            rs.close();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        if (connObj != null) try {
            connObj.close();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        if (stmt != null) try {
            stmt.close();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Executes the given SQL query and returns the result as a ResultSet.
     *
     * @param query the SQL query to execute
     * @return the result of the query as a ResultSet
     */
    private ResultSet query(String query) {
        Connection connObj = null;
        try {
            Class.forName("org.postgresql.Driver"); // Update the driver class name
            connObj = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD); // Provide username and password
            if (connObj != null) {
                Statement statement = connObj.createStatement();
                return statement.executeQuery(query);
            }
        } catch (Exception sqlException) {
            log.error(sqlException.getMessage());
        }
        return null;
    }
}
