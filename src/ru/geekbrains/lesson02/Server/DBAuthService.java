package ru.geekbrains.lesson02.Server;

import java.sql.*;
import java.util.List;

public class DBAuthService implements  AuthService {
    private static Connection connection;
    private static Statement statement;
    private List<Entry> entries;

    public static void main(String[] args) {

        try {
            connect();
            System.out.println("Подключились к базе");
            ResultSet resultSet = statement.executeQuery("SELECT nick FROM users WHERE login ");
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

    }

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации остановлен");
    }

    private static void disconnect() {
        try {
            statement.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:authDB.db");
        statement = connection.createStatement();
    }

    @Override
    public String getNickByLoginPass(String login, String pass) {
        for (DBAuthService.Entry o : entries) {
            if (o.login.equals(login) && o.pass.equals(pass)) return o.nick;
        }
        return null;
    }

    private static class Entry {
        private String login;
        private String pass;
        private String nick;

        public Entry(String login, String pass, String nick) {
            this.login = login;
            this.pass = pass;
            this.nick = nick;
        }
    }
}
