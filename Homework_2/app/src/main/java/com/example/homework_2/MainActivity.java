package com.example.homework_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   private TextView SumU1;
   private TextView SumU2;
   private final Simulation simulation = new Simulation(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SumU1 = findViewById(R.id.sum_U1);
        SumU2 = findViewById(R.id.sum_U2);
    }

    @SuppressLint("SetTextI18n")
    public void runTheSimulation(View view) throws Exception {
        int total_Budget = simulation.runSimulation(simulation.loadU1(simulation.loadItems("Phase-1.txt")));
        total_Budget += simulation.runSimulation(simulation.loadU1(simulation.loadItems("Phase-2.txt")));
        SumU1.setText(total_Budget + " million $");

        total_Budget = simulation.runSimulation(simulation.loadU2(simulation.loadItems("Phase-1.txt")));
        total_Budget += simulation.runSimulation(simulation.loadU2(simulation.loadItems("Phase-2.txt")));
        SumU2.setText(total_Budget + " million $");

    }
}