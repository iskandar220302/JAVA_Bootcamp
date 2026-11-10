package org.example;

import java.util.Locale;

public class Dog extends Animal {

    public Dog(String name, int age, double weight) {
        super(name, age, weight);
    }

    public String toString() {
        return "Dog name = " + getName()
                + ", age = " + getAge()
                + ", mass = " + String.format(Locale.US, "%.2f", getWeight())
                + ", feed = " + String.format(Locale.US, "%.2f", getFeedInfoKg());
    }

    public double getFeedInfoKg() {
        return getWeight() * 0.3;
    }
}
