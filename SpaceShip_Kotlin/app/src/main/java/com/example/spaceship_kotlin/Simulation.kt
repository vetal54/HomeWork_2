package com.example.spaceship_kotlin

import android.content.Context
import android.content.res.AssetManager
import com.example.spaceship_kotlin.moduls.Item
import com.example.spaceship_kotlin.moduls.Rocket
import com.example.spaceship_kotlin.moduls.U1
import com.example.spaceship_kotlin.moduls.U2
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class Simulation(private var context: Context) {

    @Throws(IOException::class)
    fun loadItems(fileName: String): ArrayList<Item>{
        val assManeger: AssetManager = context.assets
        val loadManifest: ArrayList<Item> = ArrayList()

        val filescanner = Scanner(assManeger.open(fileName))

        while (filescanner.hasNextLine()) {
            val newItem = Item()
            val tokens = filescanner.nextLine().split("=").toTypedArray()
            newItem.name = tokens[0]
            newItem.weight = tokens[tokens.size - 1].toInt()
            loadManifest.add(newItem)
        }

        return loadManifest
    }

    fun loadU1(list: ArrayList<Item>): ArrayList<Rocket>{
        val rocketsListOne : ArrayList<Rocket> = ArrayList()
        var rocketOne: Rocket = U1()

        for (i in list) {
            if (rocketOne.canCarry(i)) {
                rocketOne.carry(i)
            } else {
                rocketsListOne.add(rocketOne)
                rocketOne = U1()
                rocketOne.carry(i)
            }
        }
        rocketsListOne.add(rocketOne)

        return rocketsListOne
    }

    fun loadU2(list: ArrayList<Item>): ArrayList<Rocket>{
        val rocketsListTwo: ArrayList<Rocket> = ArrayList()
        var rocketTwo: Rocket = U2()

        for (i in list) {
            if (rocketTwo.canCarry(i)) {
                rocketTwo.carry(i)
            } else {
                rocketsListTwo.add(rocketTwo)
                rocketTwo = U2()
                rocketTwo.carry(i)
            }
        }
        rocketsListTwo.add(rocketTwo)

        return rocketsListTwo
    }

    fun runSimulation(rockets: ArrayList<Rocket>): Int{
        var totalCost = 0

        for (currentRocket in rockets) {
            totalCost += currentRocket.getCost()

            while (!currentRocket.launch() || !currentRocket.land()) {
                totalCost += currentRocket.getCost()
            }
        }
        return totalCost
    }
}