package com.poonam.dua.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
  import com.poonam.dua.model.QuizGeneral
import com.poonam.dua.utils.LOAD_SIZE
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor() {

//    fun searchImage(query: String, orderBy: String) = Pager(
//        config = PagingConfig(enablePlaceholders = false, pageSize = LOAD_SIZE),
//        pagingSourceFactory = {
//            SearchDataSource(unSplashService, query, orderBy)
//        }
//    ).flow
//
//    suspend fun sendDownload(id: String) {
//        unSplashService.downloadImage(id)
//    }

    val quizGeneralList: List<QuizGeneral>
        get() = Gson().fromJson<List<QuizGeneral>>(json, object : TypeToken<List<QuizGeneral>>() {

        }.type)

    private val json = "[\n" +
            "  {\n" +
            "    \"question\":\"GENDER\",\n" +
            "    \"answer1\":\"Lorem ipsum\",\n" +
            "    \"answer2\":\"Curabitur molestie\",\n" +
            "    \"answer3\":\"Etiam convallis\",\n" +
            "    \"answer4\":\"Proin auctor\",\n" +
            "    \"answer5\":\"Vivamus mattis\",\n" +
            "    \"correct_answer\":\"3\",\n" +
            "    \"image\":\"gallery_bird_6\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"question\":\"WEIGHT.\",\n" +
            "    \"answer1\":\"Etiam non\",\n" +
            "    \"answer2\":\"Ut pretium\",\n" +
            "    \"answer3\":\"Sed fringilla\",\n" +
            "    \"answer4\":\"Nulla at dolor\",\n" +
            "    \"answer5\":\"Nam euismod\",\n" +
            "    \"correct_answer\":\"1\",\n" +
            "    \"image\":\"gallery_tiger_3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"question\":\"AGE. \",\n" +
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