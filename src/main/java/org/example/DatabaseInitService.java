package org.example;

import org.flywaydb.core.Flyway;

import static org.example.Database.*;

public class DatabaseInitService {
    public void initDatabase() {
        Flyway flyway = Flyway
                .configure()
                .dataSource(DB_URL, DB_USER, null)
                .load();
        flyway.migrate();
    }
}