package fr.isen.jal.quizy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.isen.jal.quizy.databinding.FragmentQuestionsBinding


class QuestionsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentQuestionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuestionsBinding.inflate(inflater,container,false)
        return binding.root
    }


    fun getAnsweredQuestion(): Question {
        val question = Question(
            titre = binding.question.text.toString(),
            reponses = arrayListOf(binding.trueQuestion.text.toString(),
                binding.wrongAnswer1.text.toString(), binding.wrongAnswer2.text.toString(),)
        )
        return question
    }

    fun verifieInformation(
        question: String?,
        true_question: String?,
        wrong_answer_1: String?,
        wrong_answer_2: String?
    ):Boolean {
        var verified = (question?.isNotEmpty() == true &&
                true_question?.isNotEmpty() == true &&
                wrong_answer_1?.isNotEmpty() == true &&
                wrong_answer_2?.isNotEmpty() == true)
        return verified
    }

}