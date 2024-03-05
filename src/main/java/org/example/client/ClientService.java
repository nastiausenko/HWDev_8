package org.example.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private PreparedStatement createSt;
    private PreparedStatement readSt;

    public ClientService(Connection connection) {
        try{
            createSt = connection.prepareStatement("INSERT INTO client (name) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS);
            readSt = connection.prepareStatement("SELECT name FROM client WHERE id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long create(String name)  {
        if (name.length() < 2 || name.length() > 1000) {
            throw new IllegalArgumentException("Invalid name");
        }

        long id = -1;
        try {
            createSt.setString(1, name);
            createSt.executeUpdate();

            ResultSet generatedKeys = createSt.getGeneratedKeys();
            generatedKeys.next();
            id = generatedKeys.getLong("id");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public String getById(long id) {
        try {
            readSt.setLong(1, id);
            ResultSet resultSet = readSt.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Client not found";
    }
}
