package fr.isen.jal.quizy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityHomeBinding
    lateinit var buttonCommencer: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)

        buttonCommencer = findViewById(R.id.buttonCommencerQuestionnaire)
        val IntentCommencer : Intent =  Intent(this,PrincipalActivity::class.java)
        buttonCommencer.setOnClickListener {
            startActivity(IntentCommencer)
        }
    }
}

