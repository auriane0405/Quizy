package fr.isen.jal.quizy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ExempleEmojiQuizActivity : AppCompatActivity() {
    lateinit var buttonCommencerEmoji: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exemple_emoji_quiz)

        buttonCommencerEmoji = findViewById(R.id.buttonCommencerEmoji)
        val IntentCommencerEmoji : Intent =  Intent(this,QuestionsActivity::class.java) //a modifier
        buttonCommencerEmoji.setOnClickListener {
            startActivity(IntentCommencerEmoji)
        }
    }
}

