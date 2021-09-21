package com.example.homework_2.models;

public class U2 extends Rocket{
    public U2 (){
        setCost(120);
        setWeight(18000);
        setMaxWeight(29000);
        setCurrentWeight(getWeight());
    }

    public boolean launch() {
        int random = (int)(Math.random() * 100 + 1);
        return 4.0 * (getCurrentWeight() - getWeight()) / (getMaxWeight() - getWeight()) <= random;
    }

    public boolean land() {
        int random = (int)(Math.random() * 100 + 1);
        return 8.0 * (getCurrentWeight() - getWeight()) / (getMaxWeight() - getWeight()) <= random;
    }
}
