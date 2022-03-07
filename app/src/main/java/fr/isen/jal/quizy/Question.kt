package fr.isen.jal.quizy

import java.io.Serializable

data class Question(val titre: String,val reponses: ArrayList<String>): Serializable