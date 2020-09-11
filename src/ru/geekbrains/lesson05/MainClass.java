package ru.geekbrains.lesson05;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT + 1);
        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cyclicBarrier, countDownLatch);
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
        try {
            cyclicBarrier.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            countDownLatch.await();
        } catch (Exception ex) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Произошла непоправимая ошибка\n" + ex.getMessage());
        } finally {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }

    }
}
