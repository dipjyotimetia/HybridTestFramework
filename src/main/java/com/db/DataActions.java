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

import com.api.ApiActions;
import lombok.extern.slf4j.Slf4j;

import java.sql.DriverManager;
import java.sql.*;

/**
 * @author Dipjyoti Metia
 */
@Slf4j
public class DataActions<T> extends ApiActions<T> {

    private static final String JDBC_URL = "jdbc:sqlserver://databaseserver;databaseName=Database;integratedSecurity=true";

    /**
     * Get DB connection
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
     * Execute query
     *
     * @param query query
     * @return result
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
                            resultValue = rs.getString(i).toString();
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

    private void displayRow(String title, ResultSet rs) {
        try {
            while (rs.next()) {
                log.info(rs.getString(title));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

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
     * Query executer
     *
     * @param query query
     * @return resultset
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

