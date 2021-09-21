package com.example.spaceship_kotlin.moduls

open class Rocket : SpaceShip {
    internal var cost: Int = 0
    var weight: Int = 0
    var maxWeight: Int = 0
    var currentWeight: Int = 0

    override fun launch(): Boolean = true

    override fun land(): Boolean = true

    override fun canCarry(item: Item?): Boolean{
        return this.currentWeight + item!!.weight <= maxWeight
    }

    override fun carry(item: Item?): Int{
        this.currentWeight +=item!!.weight
        return this.currentWeight
    }

    fun getCost(): Int{ return this.cost }
}