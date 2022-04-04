package fr.isen.jal.quizy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import fr.isen.jal.quizy.databinding.ActivityJouerBinding
import fr.isen.jal.quizy.databinding.ActivityQuestionsBinding

class JouerActivity : AppCompatActivity() {
    lateinit var buttonValider: Button
    private lateinit var binding: ActivityJouerBinding
    private var currentPosition = 0
    private var nombreQuestion = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // binding = ActivityJouerBinding.inflate(LayoutInflater)
        setContentView(binding.root)
        val jouerFragmentList = arrayListOf<JouerFragment>()

        buttonValider = findViewById(R.id.buttonValider)
        buttonValider.setOnClickListener {
            if (currentPosition < nombreQuestion - 1) {
                val fragment = jouerFragmentList[currentPosition]
              //  questionList.add(fragment.getAnsweredQuestion())
                currentPosition++
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragmentContainerQuestions,
                    jouerFragmentList[currentPosition]
                ).commit()
            } else {
                val intentValider: Intent = Intent(this, ResultatsActivity::class.java)
              //  intentValider.putExtra("questionsList", questionList)
                buttonValider.setOnClickListener {
                    startActivity(intentValider)
                }
            }
        }
    }
}