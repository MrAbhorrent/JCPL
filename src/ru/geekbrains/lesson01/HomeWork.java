package ru.geekbrains.lesson01;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork {


    public static void swap(Object[] arr, int i, int j) {
        // Меняем i-ый и j-ый элементы массива местами
        Object swap = arr[j];
        arr[j] = arr[i];
        arr[i] = swap;
    }

    public static void main(String[] args) {
        int i, j;
        // 01. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа)
        String[] arr1 = {"A", "B", "C", "D", "E"};
        Integer[] arr2 = {1, 2, 3, 4, 5, 6};
        System.out.println("Первый массив");
        System.out.println(Arrays.toString(arr1));
        i = 1; j = 4;
        System.out.println("Меняем местами элементы " + i + " и " + j);
        swap(arr1, 1, 4);
        System.out.println(Arrays.toString(arr1));
        System.out.println("Второй массив");
        System.out.println(Arrays.toString(arr2));
        i = 2; j = 0;
        System.out.println("Меняем местами элементы " + i + " и " + j);
        swap(arr2, i, j);
        System.out.println(Arrays.toString(arr2));

        // 02. Написать метод, который преобразует массив в ArrayList;
        String[] asArray = {"первый", "второй", "третий", "четвертый"};
        System.out.println(Arrays.toString(asArray));
        System.out.println("Преобразование в лист");
        ArrayList<String> asList = convertToList(asArray);
        System.out.println(asList.toString());


        // 03. Большая задача:
        //a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
        //b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
        // нельзя сложить и яблоки, и апельсины;
        //c. Для хранения фруктов внутри коробки можете использовать ArrayList;
        //d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока
        // - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
        //e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут
        // в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем
        //  сравнивать с коробками с апельсинами);
        //f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
        // фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
        //  а в другую перекидываются объекты, которые были в этой коробке;
        //g. Не забываем про метод добавления фрукта в коробку.

        System.out.println("Создаем коробки с orangeBox1, orangeBox2 и ");
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        System.out.println("Добавляем фрукты: ");
        int value1 = 10, value2 = 7, value3 = 9, value4 = 12;
        orangeBox1.addFruit(new Orange(),value1);
        orangeBox2.addFruit(new Orange(),value2);
        appleBox1.addFruit(new Apple(),value3);
        appleBox2.addFruit(new Apple(),value4);
        System.out.println("Коробка 1 (аппельсинов - " + value1 + "): " + orangeBox1.getWeight());
        System.out.println("Коробка 2 (аппельсинов - " + value2 + "): " + orangeBox2.getWeight());
        System.out.println("Коробка 3 (яблок - " + value3 + "): " + appleBox1.getWeight());
        System.out.println("Коробка 4 (яблок - " + value4 + "): " + appleBox2.getWeight());
        System.out.println("Сравниваем: ");
        System.out.println("Коробка 1 равна коробке 3?: " + orangeBox1.compareTo(appleBox1));
        System.out.println("Коробка 2 равна коробке 4?: " + orangeBox2.compareTo(appleBox2));
        System.out.println("Пересыпаем фрукты: ");
        orangeBox1.pourTo(orangeBox2);
        appleBox1.pourTo(appleBox2);
        System.out.println("Смотрим вес: ");
        System.out.println("Коробка 1: " + orangeBox1.getWeight());
        System.out.println("Коробка 2: " + orangeBox2.getWeight());
        System.out.println("Коробка 3: " + appleBox1.getWeight());
        System.out.println("Коробка 4: " + appleBox2.getWeight());

    }

    public static <T> ArrayList<T> convertToList(T[] arr) {
        ArrayList<T> list = new ArrayList<>(Arrays.asList(arr));
        return list;
    }

}
