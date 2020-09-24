package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity lets the user roll a dice and view the result on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        // Toast.makeText(this, "Dice rolled!", Toast.LENGTH_LONG).show()
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val myDice = Dice(6)
        val diceRoll = myDice.roll()

        // Find the ImageView in the layout
        val diceImageView: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val diceImage = when (diceRoll) {
            1 ->   R.drawable.dice_1
            2 ->   R.drawable.dice_2
            3 ->   R.drawable.dice_3
            4 ->   R.drawable.dice_4
            5 ->   R.drawable.dice_5
            else ->   R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImageView.setImageResource(diceImage)

        // Update the content description
        diceImageView.contentDescription = diceRoll.toString()
    }
}
/**
 * This class lets the user generate a dice and assign a random number as the result
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}