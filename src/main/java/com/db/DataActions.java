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

/**
 * This class contains methods to interact with a database using JDBC.
 * <p>
 * It is used for establishing a database connection, executing queries, and handling result sets.
 *
 * @author Dipjyoti Metia
 */
@Slf4j
public class DataActions extends ApiActions {

    private static final String JDBC_URL = "jdbc:sqlserver://databaseserver;databaseName=Database;integratedSecurity=true";

    /**
     * Establishes a connection to the database, retrieves data from it,
     * and logs the results using the given query.
     */
    private void getDbConnection() {
        ResultSet rs = null;
        Connection connObj = null;
        Statement statement = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connObj = DriverManager.getConnection(JDBC_URL);
            if (connObj != null) {
                statement = connObj.createStatement();
                String queryString = "select TOP 10 * from ;";
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
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        }
        try (Connection connection = java.sql.DriverManager.getConnection(JDBC_URL)) {
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
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connObj = DriverManager.getConnection(JDBC_URL);
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

