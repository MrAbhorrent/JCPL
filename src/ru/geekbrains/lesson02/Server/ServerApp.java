package ru.geekbrains.lesson02.Server;

public class ServerApp {
    public static void main(String[] args) {
        AuthService authService = (AuthService) new DBAuthService();
        new MyServer(authService);
    }
}
