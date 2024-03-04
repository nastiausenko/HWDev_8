package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();

        System.out.println("\nLongest Project\n---------------");
        for (LongestProject project: databaseQueryService.findLongestProject()) {
            System.out.println(project.getId() + " | " + project.getMonthDiff());
        }

        System.out.println("\nMax projects client\n-------------------");
        for (MaxProjectCountClient client: databaseQueryService.findMaxProjectsClient()) {
            System.out.println(client.getName() + " | " + client.getProjectCount());
        }

        System.out.println("\nMax salary worker\n-----------------");
        for (MaxSalaryWorker worker: databaseQueryService.findMaxSalaryWorker()) {
            System.out.println(worker.getName() + " | " + worker.getSalary());
        }

        System.out.println("\nYoungest and eldest workers\n---------------------------");
        for (YoungestEldestWorkers worker: databaseQueryService.findYoungestEldestWorkers()) {
            System.out.println(worker.getType() + " | " + worker.getName() +" | " + worker.getBirthday());
        }

        System.out.println("\nProject prices\n--------------");
        for (ProjectPrices project: databaseQueryService.printProjectPrices()) {
            System.out.println(project.getId() + " | " + project.getPrice());
        }
    }
}
