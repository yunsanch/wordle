package com.example.wordle

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var wordToGuess : String
    private var countRound = 0
    private var Streak = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_UNSPECIFIED)
        wordToGuess = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord()

        val Button = findViewById<Button>(R.id.GuessButton)
        val Guess1 = findViewById<TextView>(R.id.FirstGuessTextView1)
        val Guess2 = findViewById<TextView>(R.id.secondGuessTextView5)
        val Guess3 = findViewById<TextView>(R.id.ThirdGuessTextView9)
        val guessCheckuno = findViewById<TextView>(R.id.Guesscheck1TextView3)
        val guessCheckdos = findViewById<TextView>(R.id.Guesscheck2TextView7)
        val guessChecktres = findViewById<TextView>(R.id.Guesscheck3TextView11)
        val worduno = findViewById<TextView>(R.id.word1TextView2)
        val wordunocheck = findViewById<TextView>(R.id.word1checkTextView4)
        val worddos = findViewById<TextView>(R.id.word2TextView6)
        val worddoscheck = findViewById<TextView>(R.id.word2checkTextView8)
        val wordtres = findViewById<TextView>(R.id.word3TextView10)
        val wordtresCheck = findViewById<TextView>(R.id.word3checkTextView12)
        val WordtoguessTextview = findViewById<TextView>(R.id.WordToGuessTextview13)
        val simpleEditText = findViewById<EditText>(R.id.inputGuess)
        val btnReseter = findViewById<Button>(R.id.btnPlayAgain)

        Button.setOnClickListener {
            it.hideKeyboard()
            val strValue = simpleEditText.text.toString().uppercase()
//            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            counter ++
            WordtoguessTextview.text = wordToGuess
            if (counter == 1) {
                worduno.text = strValue
                worduno.visibility = View.VISIBLE
                Guess1.visibility = View.VISIBLE
                guessCheckuno.visibility = View.VISIBLE
                wordunocheck.visibility = View.VISIBLE
                wordunocheck.text = worduno.toString()
                wordunocheck.text = checkGuess(strValue)
                simpleEditText.text.clear()
            }
            if (counter == 2) {
                worddos.text = strValue
                worddos.visibility = View.VISIBLE
                Guess2.visibility = View.VISIBLE
                worddoscheck.visibility = View.VISIBLE
                guessCheckdos.visibility =View.VISIBLE
                worddoscheck.text = worddos.toString()
                worddoscheck.text = checkGuess(strValue)
                simpleEditText.text.clear()
            }
            if (counter == 3) {
                wordtres.text = strValue
                wordtres.visibility = View.VISIBLE
                Guess3.visibility = View.VISIBLE
                wordtresCheck.visibility = View.VISIBLE
                guessChecktres.visibility = View.VISIBLE
                wordtresCheck.text = wordtres.toString()
                wordtresCheck.text = checkGuess(strValue)
//                Toast.makeText(this, "Max attends is 3", Toast.LENGTH_SHORT).show()
                WordtoguessTextview.visibility = View.VISIBLE
                Button.setBackgroundColor(Color.GRAY)
                Button.isClickable = false

                btnReseter.visibility = View.VISIBLE
                btnReseter.setOnClickListener {
                    it.hideKeyboard()
                    btnReseter.text = "Re-Start"
                    btnReseter.setOnClickListener {
                        counter = 0
                        simpleEditText.text.clear()

                        worduno.visibility = View.INVISIBLE
                        Guess1.visibility = View.INVISIBLE
                        wordunocheck.visibility = View.INVISIBLE
                        guessCheckuno.visibility = View.INVISIBLE

                        worddos.visibility = View.INVISIBLE
                        Guess2.visibility = View.INVISIBLE
                        worddoscheck.visibility = View.INVISIBLE
                        guessCheckdos.visibility = View.INVISIBLE

                        wordtres.visibility = View.INVISIBLE
                        Guess3.visibility = View.INVISIBLE
                        wordtresCheck.visibility = View.INVISIBLE
                        guessChecktres.visibility = View.INVISIBLE

                        btnReseter.visibility = View.INVISIBLE
                        wordToGuess = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord()
                        WordtoguessTextview.text = wordToGuess
                        WordtoguessTextview.visibility = View.INVISIBLE
                        Button.setBackgroundColor(Color.BLUE)

                        Button.isClickable = true
                    }

                }
            }

        }


    }
    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result

    }

    var counter = 0
//

}