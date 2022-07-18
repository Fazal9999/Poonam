package com.poonam.dua.activities.preferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.poonam.dua.R
import com.poonam.dua.base.BindingActivity
import com.poonam.dua.databinding.ActivityMainBinding
import com.poonam.dua.databinding.ActivityUserPrefBinding
import com.poonam.dua.model.QuizGeneral
import com.poonam.dua.viewmodels.QuestionViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserPrefActivity : BindingActivity<ActivityUserPrefBinding>(){
    private var position = 1
    private var maxPosition = 15
    private var job: Job? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: QuestionViewModel by viewModels {
        viewModelFactory
    }


    private lateinit var quizGeneralList: List<QuizGeneral>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getQuizes()

    }

    private fun getQuizes() {
        job?.cancel()
        job = lifecycleScope.launch {
          Log.i("quizes",viewModel.getQuiz().toString())
            }

        }
    }
