package com.example.homework_2.models;

public class U1 extends Rocket{

    public U1 (){
        setCost(100);
        setWeight(10000);
        setMaxWeight(18000);
        setCurrentWeight(getWeight());
    }

    @Override
    public boolean land(){
        int random = (int)(Math.random() * 100 + 1);
        return 1.0 * (getCurrentWeight() - getWeight()) / (getMaxWeight() - getWeight()) <= random;
    }

    @Override
    public boolean launch(){
        int random = (int)(Math.random() * 100 + 1);
        return 5.0 * (getCurrentWeight() - getWeight()) / (getMaxWeight() - getWeight()) <= random;
    }
}
