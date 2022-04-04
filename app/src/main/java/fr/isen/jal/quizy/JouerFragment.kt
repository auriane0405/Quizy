package fr.isen.jal.quizy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.isen.jal.quizy.databinding.FragmentJouerBinding
import fr.isen.jal.quizy.databinding.FragmentQuestionsBinding

class JouerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentJouerBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jouer, container, false)
    }


}