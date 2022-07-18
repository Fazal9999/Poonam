package com.poonam.dua.model
import com.google.gson.annotations.SerializedName

data class QuizGeneral(@field:SerializedName("question")
                  var question: String, @field:SerializedName("answer1")
                  var answer1: String, @field:SerializedName("answer2")
                  var answer2: String, @field:SerializedName("answer3")
                  var answer3: String, @field:SerializedName("answer4")
                  var answer4: String, @field:SerializedName("answer5")
                  var answer5: String, @field:SerializedName("correct_answer")
                  var correctAnswer: String,
                  @field:SerializedName("image")
                  var image: String) {

    @SerializedName("selected_answer")
    var selectedAnswer: Int = 0
}
