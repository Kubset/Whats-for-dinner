package DAO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {
    private static String path = "src/main/resources";

    private static final String DB_PROPERTIES_FILE;
    private static final Properties DB_CONNECTION_PROPERTIES;

    private static String DB_URL;
    private static String DB_USERNAME;
    private static String DB_PASSWORD;

    private static Connection connection;

    static {
        DB_PROPERTIES_FILE = "database.properties";
        DB_CONNECTION_PROPERTIES = new Properties();
    }

    private static void loadData() {
        try {
            Path propertiesFilePath = Paths.get(path, DB_PROPERTIES_FILE);
            DB_CONNECTION_PROPERTIES.load(Files.newInputStream(propertiesFilePath));

            DB_URL = DB_CONNECTION_PROPERTIES.getProperty("javabase.jdbc.url");
            DB_USERNAME = DB_CONNECTION_PROPERTIES.getProperty("javabase.jdbc.username");
            DB_PASSWORD = DB_CONNECTION_PROPERTIES.getProperty("javabase.jdbc.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                loadData();
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            } catch (SQLException e) {
                System.err.println("Can't get connection to the database");
            }
        }
        return connection;
    }

    public static void setPropertiesPath(String path) {
       ConnectionProvider.path = path;
    }
}
