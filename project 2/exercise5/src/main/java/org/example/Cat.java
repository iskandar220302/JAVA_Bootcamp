package org.example;

import java.util.concurrent.TimeUnit;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Cat name = " + getName() + ", age = " + getAge();
    }

    @Override
    public double goToWalk() throws InterruptedException {
        double walkTime = getAge() * 0.25;

        TimeUnit.MILLISECONDS.sleep((long) (walkTime * 1000));

        return walkTime;
    }
}