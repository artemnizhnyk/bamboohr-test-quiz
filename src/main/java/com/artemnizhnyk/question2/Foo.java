package com.artemnizhnyk.question2;

import java.sql.*;

public class Foo {
    public static final String JDBC_MYSQL_URL = "jdbc:mysql://localhost:3306/db";
    public static final String JDBC_ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    public static final String JDBC_POSTGRESQL_URL = "jdbc:postgresql://localhost:5432/db";

    public int selectFromDatabase(DbType dbType) throws SQLException {
        DatabaseHandler dbHandler;

        return switch (dbType) {
            case MYSQL -> {
                dbHandler = new DatabaseHandler(JDBC_MYSQL_URL, "login", "password");
                yield dbHandler.executeQuery("SELECT 1");
            }
            case ORACLE -> {
                dbHandler = new DatabaseHandler(JDBC_ORACLE_URL, "login", "password");
                yield dbHandler.executeQuery("SELECT 1 FROM DUAL");
            }
            case POSTGRES -> {
                dbHandler = new DatabaseHandler(JDBC_POSTGRESQL_URL, "login", "password");
                yield  dbHandler.executeQuery("SELECT 1");
            }

            default -> throw new IllegalArgumentException("Database " + dbType.name() + " not implemented");
        };
    }
    public enum DbType {MYSQL, ORACLE, POSTGRES}
}
