package com.example.homework_2.models;

public class Rocket implements SpaceShip{

   private int cost;
   private int weight;
   private int maxWeight;
   private int currentWeight;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return this.currentWeight + item.weight <= maxWeight;
    }

    public int carry(Item item) {
        return this.currentWeight += item.weight;
    }

    public int getCost() {
        return cost;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getWeight() {
        return weight;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }
}
