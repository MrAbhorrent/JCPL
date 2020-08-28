package ru.geekbrains.lesson02.Client;

@FunctionalInterface
public interface Callback {
    void callback(String... args);
}
