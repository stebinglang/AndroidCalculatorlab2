package com.cs407.calculator

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

        println("abc")

        val num1 = findViewById<EditText>(R.id.editTextText)

        val num2 = findViewById<EditText>(R.id.editTextText2)


        val plusButton = findViewById<Button>(R.id.button)
        val minusButton = findViewById<Button>(R.id.button2)
        val multButton = findViewById<Button>(R.id.button3)
        val divButton = findViewById<Button>(R.id.button4)

        plusButton.setOnClickListener {
            //no way to turn Editable into int. must turn into string then int.
            //turn val to float in event listener or else it processes before user inputs stuff
            val str1 = num1.text.toString()
            val val1 = str1.toFloat()

            val str2= num2.text.toString()
            val val2 = str2.toFloat()

            val intent = Intent(this, ResultActivity::class.java)
            //passes text from myTextField to new activity
            intent.putExtra("EXTRA_MESSAGE", val1+val2)
            //start other activity:
            startActivity(intent)
        }

        minusButton.setOnClickListener {
            //no way to turn Editable into int. must turn into string then int.
            //turn val to float in event listener or else it processes before user inputs stuff
            val str1 = num1.text.toString()
            val val1 = str1.toFloat()

            val str2= num2.text.toString()
            val val2 = str2.toFloat()

            val intent = Intent(this, ResultActivity::class.java)
            //passes text from myTextField to new activity
            intent.putExtra("EXTRA_MESSAGE", val1-val2)
            //start other activity:
            startActivity(intent)
        }

        multButton.setOnClickListener {
            //no way to turn Editable into int. must turn into string then int.
            //turn val to float in event listener or else it processes before user inputs stuff
            val str1 = num1.text.toString()
            val val1 = str1.toFloat()

            val str2= num2.text.toString()
            val val2 = str2.toFloat()

            val intent = Intent(this, ResultActivity::class.java)
            //passes text from myTextField to new activity
            intent.putExtra("EXTRA_MESSAGE", val1*val2)
            //start other activity:
            startActivity(intent)
        }

        divButton.setOnClickListener {
            //no way to turn Editable into int. must turn into string then int.
            //turn val to float in event listener or else it processes before user inputs stuff
            val str1 = num1.text.toString()
            val val1 = str1.toFloat()

            val str2= num2.text.toString()
            val val2 = str2.toFloat()
            if (val2 == 0.0f) {
                Toast.makeText(this, "Cant divide by 0!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ResultActivity::class.java)
            //passes text from myTextField to new activity
            intent.putExtra("EXTRA_MESSAGE", val1 / val2)
            //start other activity:
            startActivity(intent)
        }


    }
}