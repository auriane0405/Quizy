package fr.isen.jal.quizy

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button

class EnregistreActivity: AppCompatActivity() {
    lateinit var buttonRetour: Button
    lateinit var buttonEnregistrer: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enregistre)

        buttonRetour = findViewById(R.id.buttonRetour)
        val IntentRetour : Intent =  Intent(this,QuestionsActivity::class.java)
        buttonRetour.setOnClickListener {
            startActivity(IntentRetour)
        }
        buttonEnregistrer = findViewById(R.id.buttonEnregistrer)
        val IntentEnregistrer : Intent =  Intent(this,QRCodeActivity::class.java)
        buttonEnregistrer.setOnClickListener {
            startActivity(IntentEnregistrer)
        }
    }
}