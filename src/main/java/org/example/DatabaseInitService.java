package org.example;

import org.flywaydb.core.Flyway;


public class DatabaseInitService {
    public void initDatabase() {
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:h2:~/test", "sa", "")
                .load();
        flyway.migrate();
    }
}