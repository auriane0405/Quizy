package fr.isen.jal.quizy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ResultatsActivity : AppCompatActivity() {
    lateinit var buttonMenu: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultats)

        buttonMenu = findViewById(R.id.buttonMenu)
        val IntentMenu: Intent = Intent(this, PrincipalActivity::class.java)
        buttonMenu.setOnClickListener {
            startActivity(IntentMenu)
        }
    }
}