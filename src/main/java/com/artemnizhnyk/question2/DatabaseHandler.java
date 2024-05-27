package com.artemnizhnyk.question2;

import java.sql.*;

public class DatabaseHandler {
    private final String url;
    private final String user;
    private final String password;

    public DatabaseHandler(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public int executeQuery(String query) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            throw new SQLException("No results returned from query");
        }
    }
}