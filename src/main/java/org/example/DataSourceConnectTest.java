package org.example;
import javax.sql.DataSource;
import java.sql.Connection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class DataSourceConnectTest implements CommandLineRunner {
    private final DataSource dataSource;

    public DataSourceConnectTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("DataSource: " + dataSource.getClass());
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connection Successful: " + connection.isValid(5));
            System.out.println("Database: " + connection.getCatalog());
        }
    }  
}
