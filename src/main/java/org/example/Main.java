package org.example;

import org.example.client.ClientService;


public class Main {
    public static void main(String[] args) {
        new DatabaseInitService().initDatabase();
        ClientService clientService = new ClientService(Database.getInstance().getConnection());

        System.out.println("Client {id = " + clientService.create("Nastia") + ", name = \'Nastia\'}");
        System.out.println(clientService.getById(12));
    }
}
