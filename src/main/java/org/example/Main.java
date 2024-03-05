package org.example;

import org.example.client.Client;
import org.example.client.ClientService;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        new DatabaseInitService().initDatabase();
        ClientService clientService = new ClientService(Database.getInstance().getConnection());

        System.out.println("Client {id = " + clientService.create("Nastia") + ", name = \'Nastia\'}");
        System.out.println(clientService.getById(2));
        clientService.setName(4, "Sofia");
        clientService.deleteById(3);


        List<Client> clients = clientService.listAll();
        for (Client client : clients) {
            System.out.println(client);
        }
    }
}
