package ru.geekbrains.lesson01;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> box;
    private float weight;

    public Box() {
        this.box = new ArrayList<>();
        this.weight = 0f;
    }

    public float getWeight() {
        return this.weight;
    }

    public boolean compareTo(Box anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.000001;
    }

    public void addFruit(T fruit, int amount) {
        for (int i = 0; i < amount; i++) {
            this.box.add(fruit);
            this.weight += fruit.getWeight();
        }
    }

    public void pourTo(Box <T> anotherBox) {
        anotherBox.box.addAll(this.box);
        anotherBox.weight += this.weight;
        this.box.clear();
        this.weight = 0f;
    }


}
