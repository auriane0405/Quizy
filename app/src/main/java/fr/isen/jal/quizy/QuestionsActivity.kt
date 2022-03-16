package fr.isen.jal.quizy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import fr.isen.jal.quizy.databinding.ActivityQuestionsBinding


class QuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionsBinding
    lateinit var buttonPrecedent: Button
    lateinit var buttonSuivant: Button
    private var nombreQuestion = 2
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
      //  if(verifieInformation(question, true_question, wrong_answer_1, wrong_answer_2)) {
            buttonSuivant = findViewById(R.id.buttonSuivant)
            buttonSuivant.setOnClickListener {
                if (currentPosition < nombreQuestion - 1) {
                    val fragment = questionsFragmentList[currentPosition]
                    questionList.add(fragment.getAnsweredQuestion())
                    currentPosition++
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragmentContainerQuestions,
                        questionsFragmentList[currentPosition]
                    ).commit()
                } else {
                    val intentSuivant: Intent = Intent(this, EnregistreActivity::class.java)
                    intentSuivant.putExtra("questionsList", questionList)
                    buttonSuivant.setOnClickListener {
                        startActivity(intentSuivant)
                    }
                }
            }
      //  } else {
        //    Toast(this, "ca marche pas")
       // }

    }
    private fun verifieInformation( question: String?,
                                     true_question: String?,
                                     wrong_answer_1: String?,
                                     wrong_answer_2: String?):Boolean {
        var verified = (question?.isNotEmpty() == true &&
                true_question?.isNotEmpty() == true &&
                wrong_answer_1?.isNotEmpty() == true &&
                wrong_answer_2?.isNotEmpty() == true)
        return verified
    }
}
