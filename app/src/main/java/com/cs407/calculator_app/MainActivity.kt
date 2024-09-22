package com.cs407.calculator_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Operations buttons
        val add = findViewById<Button>(R.id.add)
        val subtract = findViewById<Button>(R.id.subtract)
        val multiply = findViewById<Button>(R.id.multiply)
        val divide = findViewById<Button>(R.id.divide)

        // Numeric user inputs
        val num1 = findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)

        // Button logic
        add.setOnClickListener {
            val userInput1 = num1.text.toString().toDouble()
            val userInput2 = num2.text.toString().toDouble()

            val result = userInput1 + userInput2

            val intent = Intent(this, Calculator_Result::class.java)
            intent.putExtra("RESULT_MESSAGE", result)
            startActivity(intent)
        }

        subtract.setOnClickListener {
            val userInput1 = num1.text.toString().toDouble()
            val userInput2 = num2.text.toString().toDouble()

            val result = userInput1 - userInput2

            val intent = Intent(this, Calculator_Result::class.java)
            intent.putExtra("RESULT_MESSAGE", result)
            startActivity(intent)
        }

        multiply.setOnClickListener {
            val userInput1 = num1.text.toString().toDouble()
            val userInput2 = num2.text.toString().toDouble()

            val result = userInput1 * userInput2

            val intent = Intent(this, Calculator_Result::class.java)
            intent.putExtra("RESULT_MESSAGE", result)
            startActivity(intent)
        }

        divide.setOnClickListener {
            val userInput1 = num1.text.toString().toDouble()
            val userInput2 = num2.text.toString().toDouble()

            val result = userInput1 / userInput2

            if (userInput2 != 0.0){
                val intent = Intent(this, Calculator_Result::class.java)
                intent.putExtra("RESULT_MESSAGE", result)
                startActivity(intent)
            }

            else {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_LONG).show()
            }
        }
    }
}