package fr.isen.jal.quizy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import fr.isen.jal.quizy.databinding.ActivityQuestionsBinding


class QuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionsBinding
    lateinit var buttonPrecedent: Button
    lateinit var buttonSuivant: Button
    private var nombreQuestion = 10
    private var currentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val questionsFragmentList = arrayListOf<QuestionsFragment>()
        repeat(nombreQuestion) {
            questionsFragmentList.add(QuestionsFragment())
        }
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerQuestions, questionsFragmentList[currentPosition]).commit()

        buttonPrecedent = findViewById(R.id.buttonPrecedent)
        val IntentPrecedent: Intent = Intent(this, PrincipalActivity::class.java)
        buttonPrecedent.setOnClickListener {
            startActivity(IntentPrecedent)
        }
        buttonSuivant = findViewById(R.id.buttonSuivant)
        buttonSuivant.setOnClickListener {
            val fragment = questionsFragmentList[currentPosition]
            //on récupère les réponses du frag
            //on stoque dans notre liste de question
            currentPosition++
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerQuestions,questionsFragmentList[currentPosition]).commit()
        }
    }
}