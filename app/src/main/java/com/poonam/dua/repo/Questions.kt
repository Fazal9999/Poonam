package com.poonam.dua.repo

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.poonam.dua.model.QuizGeneral

object Questions {

    val quizGeneralList: List<QuizGeneral>
        get() = Gson().fromJson<List<QuizGeneral>>(json, object : TypeToken<List<QuizGeneral>>() {

        }.type)

    private val json = "[\n" +
            "  {\n" +
            "    \"question\":\"Gender\",\n" +
            "    \"answer1\":\"Lorem ipsum\",\n" +
            "    \"answer2\":\"Curabitur molestie\",\n" +
            "    \"answer3\":\"Etiam convallis\",\n" +
            "    \"answer4\":\"Proin auctor\",\n" +
            "    \"answer5\":\"Vivamus mattis\",\n" +
            "    \"correct_answer\":\"3\",\n" +
            "    \"image\":\"gallery_bird_6\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"question\":\"WEIGHT\",\n" +
            "    \"answer1\":\"Etiam non\",\n" +
            "    \"answer2\":\"Ut pretium\",\n" +
            "    \"answer3\":\"Sed fringilla\",\n" +
            "    \"answer4\":\"Nulla at dolor\",\n" +
            "    \"answer5\":\"Nam euismod\",\n" +
            "    \"correct_answer\":\"1\",\n" +
            "    \"image\":\"gallery_tiger_3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"question\":\"AGE \",\n" +
            "    \"answer1\":\"Cras maximus\",\n" +
            "    \"answer2\":\"Vivamus hendrerit\",\n" +
            "    \"answer3\":\"Phasellus\",\n" +
            "    \"answer4\":\"Etiam luctus\",\n" +
            "    \"answer5\":\"Nulla ornare\",\n" +
            "    \"correct_answer\":\"2\",\n" +
            "    \"image\":\"dir_cat_3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"question\":\"HEIGHT\",\n" +
            "    \"answer1\":\"Lorem ipsum\",\n" +
            "    \"answer2\":\"Curabitur molestie\",\n" +
            "    \"answer3\":\"Etiam convallis\",\n" +
            "    \"answer4\":\"Proin auctor\",\n" +
            "    \"answer5\":\"Vivamus mattis\",\n" +
            "    \"correct_answer\":\"5\",\n" +
            "    \"image\":\"cafe4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"question\":\"AGE\",\n" +
            "    \"answer1\":\"Etiam non\",\n" +
            "    \"answer2\":\"Ut pretium\",\n" +
            "    \"answer3\":\"Sed fringilla\",\n" +
            "    \"answer4\":\"Nulla at dolor\",\n" +
            "    \"answer5\":\"Nam euismod\",\n" +
            "    \"correct_answer\":\"2\",\n" +
            "    \"image\":\"menu_restaurant_vintage_table\"\n" +
            "  }\n" +
            "]"



}