package com.system.fridges.repositories;

import java.sql.*;
import java.sql.Connection;

public class UserConnection {


    public static String getUserPassword(String email) throws SQLException {
        Statement state = null;
        String password = null;
        try {
            state = java.sql.Connection.connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query = "SELECT password FROM user WHERE email = '"+ email + "'";
        ResultSet resultSet = null;
        try {
            resultSet = state.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (resultSet.next()) {
            password = resultSet.getString("password");
        }
        return password;

    }

    public static String getUserType(String email) throws SQLException {
        Statement state = null;
        String typeUser = null;
        try {
            state = Connection.connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query = "SELECT value\n" +
                "FROM user\n" +
                "LEFT JOIN constant ON user.constant_id = constant.constant_id\n" +
                "WHERE user.email = \"" + email +"\";";
        ResultSet resultSet = null;
        try {
            resultSet = state.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (resultSet.next()) {
            typeUser = resultSet.getString("value");
        }
        return typeUser;

    }
}
