package ru.geekbrains.lesson02.Server;

public interface AuthService {
    void start();

    String getNickByLoginPass(String login, String pass);

    void stop();
}
