package org.example;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException  {
        final String user = "postgres";
        final String password = "polkiklopov12";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password)) {

            System.out.println("Соединение установлено!");

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }
}