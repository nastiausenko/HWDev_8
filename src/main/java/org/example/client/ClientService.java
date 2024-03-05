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
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;
    private PreparedStatement getSt;

    public ClientService(Connection connection) {
        try{
            createSt = connection.prepareStatement("INSERT INTO client (name) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS);
            readSt = connection.prepareStatement("SELECT name FROM client WHERE id = ?");
            updateSt = connection.prepareStatement("UPDATE client SET name = (?) WHERE id = (?)");
            deleteSt = connection.prepareStatement("DELETE FROM client WHERE id = ?");
            getSt = connection.prepareStatement("SELECT * FROM client");
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

    public void setName(long id, String name) {
        if (name.length() < 2 || name.length() > 1000) {
            throw new IllegalArgumentException("Invalid name");
        }

        try {
            updateSt.setString(1, name);
            updateSt.setLong(2, id);
            updateSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(long id) {
        try {
            deleteSt.setLong(1, id);
            deleteSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> listAll() {
        List<Client> clients = new ArrayList<>();
        try {
            ResultSet resultSet = getSt.executeQuery();
            while (resultSet.next()) {
                clients.add(new Client(resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
            if (clients.isEmpty()) {
                System.out.println("Table is empty");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }


}
