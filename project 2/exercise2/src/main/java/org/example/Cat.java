package org.example;

import java.util.Locale;

public class Cat extends Animal {

    public Cat(String name, int age, double weight) {
        super(name, age,  weight);
    }

    public String toString() {
        return "Cat name = " + getName()
                + ", age = " + getAge()
                + ", mass = " + String.format(Locale.US, "%.2f", getWeight())
                + ", feed = " + String.format(Locale.US, "%.2f", getFeedInfoKg());
    }

    public double getFeedInfoKg() {
        return getWeight() * 0.1;
    }
}
