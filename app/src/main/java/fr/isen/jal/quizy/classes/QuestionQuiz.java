package fr.isen.jal.quizy.classes

import com.google.gson.annotations.SerializedName
import java.io.serializable
import java.util.List;

class QuestionQuiz(
    @SerializedName("question") val question:List<String>,
): Serializable {}
