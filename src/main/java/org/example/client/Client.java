package org.example.client;

public class Client {
    private String name;
    private int id;

    public Client(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
