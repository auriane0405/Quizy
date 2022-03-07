package fr.isen.jal.quizy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChoixActivity : AppCompatActivity() {
    lateinit var buttonQuestionnaire: Button
    lateinit var buttonEmoji: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choix)

        buttonQuestionnaire = findViewById(R.id.buttonQuestionnaire)
        val IntentQuestionnaire : Intent =  Intent(this,ExempleQuestionnaireActivity::class.java)
        buttonQuestionnaire.setOnClickListener {
            startActivity(IntentQuestionnaire)
        }

        buttonEmoji = findViewById(R.id.buttonEmoji)
        val IntentEmoji : Intent =  Intent(this,ExempleEmojiQuizActivity::class.java)
        buttonEmoji.setOnClickListener {
            startActivity(IntentEmoji)
        }
    }
}
