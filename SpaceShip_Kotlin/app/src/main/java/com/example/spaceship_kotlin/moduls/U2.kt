package com.example.spaceship_kotlin.moduls

class U2: Rocket() {
    init {
        cost = 120
        weight = 18000
        maxWeight = 29000
        currentWeight = weight
    }

    override fun land(): Boolean {
        val random = (Math.random() * 100 + 1).toInt()
        return 8.0 * (currentWeight - weight) / (maxWeight - weight) <= random
    }

    override fun launch(): Boolean {
        val random = (Math.random() * 100 + 1).toInt()
        return 4.0 * (currentWeight - weight) / (maxWeight - weight) <= random
    }
}