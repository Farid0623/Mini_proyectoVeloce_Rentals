package database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private static String url;
    private static String user;
    private static String password;

    private DatabaseConnection() {
        // Constructor privado para evitar instanciación directa
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                    initialize();
                }
            }
        }
        return instance;
    }

    private static void initialize() {
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("database.veloce")) {
            Properties prop = new Properties();
            if (input == null) {
                throw new RuntimeException("Unable to find database.veloce");
            }
            prop.load(input);
            url = prop.getProperty("db.url");
            user = prop.getProperty("db.user");
            password = prop.getProperty("db.password");
        } catch (Exception ex) {
            throw new RuntimeException("Error loading database properties", ex);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
