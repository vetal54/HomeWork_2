package com.example.spaceship_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var SumU1: TextView? = null
    private var SumU2: TextView? = null
    private var simulation = Simulation(this)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SumU1 = findViewById(R.id.sum_U1)
        SumU2 = findViewById(R.id.sum_U2)
    }

    @SuppressLint("SetTextI18n")
    fun runTheSimulation(view: View){
       var totalBudget = simulation.runSimulation(simulation.loadU1(simulation.loadItems("Phase-1.txt")))
        totalBudget += simulation.runSimulation(simulation.loadU1(simulation.loadItems("Phase-2.txt")))
        SumU1!!.text = "$totalBudget million $"

       totalBudget = simulation.runSimulation(simulation.loadU2(simulation.loadItems("Phase-1.txt")))
        totalBudget += simulation.runSimulation(simulation.loadU2(simulation.loadItems("Phase-2.txt")))
        SumU2!!.text = "$totalBudget million $"
    }
}