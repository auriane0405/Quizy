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
        val questionList = arrayListOf<Question>()
        repeat(nombreQuestion) {
            questionsFragmentList.add(QuestionsFragment())
        }
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerQuestions, questionsFragmentList[currentPosition]).commit()

        buttonPrecedent = findViewById(R.id.buttonPrecedent)
        buttonPrecedent.setOnClickListener {
            val fragment = questionsFragmentList[currentPosition]
            questionList.add(fragment.getAnsweredQuestion())
            currentPosition--
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerQuestions,questionsFragmentList[currentPosition]).commit()
        }

        buttonSuivant = findViewById(R.id.buttonSuivant)
        buttonSuivant.setOnClickListener {
            if(currentPosition<9) {
                val fragment = questionsFragmentList[currentPosition]
                questionList.add(fragment.getAnsweredQuestion())
                currentPosition++
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragmentContainerQuestions,
                    questionsFragmentList[currentPosition]
                ).commit()
            } else {
                val IntentSuivant: Intent = Intent(this, EnregistreActivity::class.java)
                buttonSuivant.setOnClickListener {
                    startActivity(IntentSuivant)
                }
            }
        }
    }
}
