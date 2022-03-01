package fr.isen.jal.quizy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PrincipalActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityPrincipalBinding
    lateinit var retour: Button
    lateinit var buttonCreer: Button
    lateinit var buttonJouer: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_principal)

        retour = findViewById(R.id.retour)
        val Intentretour : Intent =  Intent(this,HomeActivity::class.java)
        retour.setOnClickListener {
            startActivity(Intentretour)
        }

        buttonCreer = findViewById(R.id.buttonCreer)
        val IntentCreer : Intent =  Intent(this,CreationQuizActivity::class.java)
        buttonCreer.setOnClickListener {
            startActivity(IntentCreer)
        }

        buttonJouer = findViewById(R.id.buttonJouer)
        val IntentJouer : Intent =  Intent(this,JouerActivity::class.java)
        buttonJouer.setOnClickListener {
            startActivity(IntentJouer)
        }
    }
}