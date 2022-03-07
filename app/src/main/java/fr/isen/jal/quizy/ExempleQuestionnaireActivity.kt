package fr.isen.jal.quizy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ExempleQuestionnaireActivity : AppCompatActivity() {
    lateinit var buttonCommencerQuestionnaire: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exemple_questionnaire)

        buttonCommencerQuestionnaire = findViewById(R.id.buttonCommencerQuestionnaire)
        val IntentCommencerQuestionnaire : Intent =  Intent(this,PrincipalActivity::class.java) //a modifier
        buttonCommencerQuestionnaire.setOnClickListener {
            startActivity(IntentCommencerQuestionnaire)
        }
    }
}