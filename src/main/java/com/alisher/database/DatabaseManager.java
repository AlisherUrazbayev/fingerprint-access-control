package com.alisher.database;

import com.alisher.model.User;

import java.sql.*;

public class DatabaseManager {

    private Connection connection;

    private DatabaseManager() {
        System.out.println("Establishing database connection...");
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:biometric.db");
            createTable();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Holder {

            private static final DatabaseManager INSTANCE = new DatabaseManager();

    }

    public static DatabaseManager getInstance() {
        return Holder.INSTANCE;
    }

    //Initializes the User table in the database
    private void createTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS users ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " finger_id INTEGER ,"
                + " fullname TEXT ,"
                + " created TEXT ,"
                + " last_access TEXT"
                + ")";

        try(Statement statement = this.connection.createStatement()) {
            statement.executeUpdate(createTable);
            System.out.println("Database initialized and 'user' table is ready to use");
        } catch (SQLException e) {
            System.err.println("Database(SQLite) error: " + e.getMessage());
        }
    }

    //Inserts User object into database
    public void insertUser(User user) {
        String insertQuery = "INSERT INTO users(finger_id, fullname, created, last_access)" +
                " VALUES(?, ?, ? ,?)";

        try(PreparedStatement statement = this.connection.prepareStatement(insertQuery)) {
            //Set finger ID
            statement.setInt(1,user.getFingerId());
            //Set full name
            statement.setString(2, user.getFullName());
            //Set created at
            statement.setString(3, user.getCreatedAt().toString());
            //Set last accessed
            statement.setString(4, user.getCreatedAt().toString());
            System.out.println("User is successfully added");
        } catch (SQLException e) {
            System.err.println("Database(SQLite) error: " + e.getMessage());
        }
    }

    //Finds user in the table by finger id
    public boolean findUserByFingerId(String fingerId) {
        return false;
    }

    //Kills the connection with the database
    public void close() throws SQLException {
        if(this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
        }
    }
}
