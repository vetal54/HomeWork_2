package com.example.homework_2;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.homework_2.models.Item;
import com.example.homework_2.models.Rocket;
import com.example.homework_2.models.U1;
import com.example.homework_2.models.U2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    private final Context context;

    public Simulation(Context context) {
        this.context = context;
    }

    public ArrayList<Item> loadItems(String fileName) throws IOException{
        AssetManager assManeger = context.getAssets();
        ArrayList<Item> loadManifest = new ArrayList();

        Scanner filescanner = new Scanner(assManeger.open(fileName));

        while (filescanner.hasNextLine()) {
            Item newItem = new Item();
            String[] tokens = filescanner.nextLine().split("=");
            newItem.name = tokens[0];
            newItem.weight = Integer.parseInt(tokens[tokens.length-1]);
            loadManifest.add(newItem);
        }

        return loadManifest;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> list) {
        ArrayList<Rocket> rocketListOne = new ArrayList<>();
        Rocket rocketOne = new U1();

        for (Item i : list) {
            if (rocketOne.canCarry(i)) {
                rocketOne.carry(i);
            } else {
                rocketListOne.add(rocketOne);
                rocketOne = new U1();
                rocketOne.carry(i);
            }
        }
        rocketListOne.add(rocketOne);

        return rocketListOne;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> list) {

        ArrayList<Rocket> rocketListTwo = new ArrayList();
        Rocket rocketTwo = new U2();

        for (Item i : list) {
            if (rocketTwo.canCarry(i)) {
                rocketTwo.carry(i);
            } else {
                rocketListTwo.add(rocketTwo);
                rocketTwo = new U2();
                rocketTwo.carry(i);
            }
        }
        rocketListTwo.add(rocketTwo);

        return rocketListTwo;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {

        int totalCost = 0;

        for (Rocket currentRocket : rockets) {
            totalCost += currentRocket.getCost();

            while (!currentRocket.launch() || !currentRocket.land()){
                totalCost += currentRocket.getCost();
            }
        }
        return totalCost;
    }

}
