package com.example.spaceship_kotlin.moduls

interface SpaceShip {
    fun launch(): Boolean
    fun land(): Boolean
    fun canCarry(item: Item?): Boolean
    fun carry(item: Item?): Int
}