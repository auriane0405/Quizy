package fr.isen.jal.quizy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import fr.isen.jal.quizy.tuto.TutoAdapter

class ExempleQuestionnaireActivity : AppCompatActivity() {
    lateinit var buttonCommencerQuestionnaire: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exemple_questionnaire)

        val viewPagerTuto = findViewById<ViewPager>(R.id.viewPagerTuto)
        viewPagerTuto.adapter = TutoAdapter(supportFragmentManager)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPagerTuto)

        buttonCommencerQuestionnaire = findViewById(R.id.buttonCommencerQuestionnaire)
        val IntentStart : Intent =  Intent(this,QuestionsActivity::class.java)
        buttonCommencerQuestionnaire.setOnClickListener {
            startActivity(IntentStart)
        }
    }
}