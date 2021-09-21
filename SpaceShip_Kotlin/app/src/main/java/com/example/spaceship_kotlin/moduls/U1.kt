package com.example.spaceship_kotlin.moduls

class U1: Rocket() {
    init {
        cost = 100
        weight = 10000
        maxWeight =18000
        currentWeight = weight
    }

    override fun land(): Boolean{
        val random = (Math.random() * 100 + 1).toInt()
        return 1.0 * (currentWeight - weight) / (maxWeight - weight) <= random
    }

    override fun launch(): Boolean {
        val random = (Math.random() * 100 + 1).toInt()
        return 5.0 * (currentWeight - weight) / (maxWeight - weight) <= random
    }


}
