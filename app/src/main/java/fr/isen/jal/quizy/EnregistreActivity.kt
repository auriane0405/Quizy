package fr.isen.jal.quizy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class EnregistreActivity: AppCompatActivity() {
    //lateinit var questionList: AbstractList
    lateinit var database: DatabaseReference
    lateinit var buttonRetour: Button
    lateinit var buttonEnregistrer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enregistre)


        val questionList = intent.getSerializableExtra("questionList")

        database= Firebase.database.reference
        buttonRetour = findViewById(R.id.buttonRetour)
        buttonRetour.setOnClickListener {
            val IntentRetour : Intent =  Intent(this,QuestionsActivity::class.java)
            startActivity(IntentRetour)
        }
        buttonEnregistrer = findViewById(R.id.buttonEnregistrer)
        buttonEnregistrer.setOnClickListener {
            val database = Firebase.database
            val myQuestions = database.getReference("message")
            myQuestions.setValue(questionList)

            val IntentEnregistrer : Intent =  Intent(this,QRCodeActivity::class.java)
            startActivity(IntentEnregistrer)
        }
    }
}