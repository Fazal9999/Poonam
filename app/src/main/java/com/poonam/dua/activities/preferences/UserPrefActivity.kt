package com.poonam.dua.activities.preferences
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.poonam.dua.R
import com.poonam.dua.activities.dashboard.DashboardActivity
import com.poonam.dua.activities.main.MainActivity
import com.poonam.dua.base.BindingActivity
import com.poonam.dua.databinding.ActivityUserPrefBinding
import com.poonam.dua.fragments.quiz.FeatureStepperQuizStepperFragment
import com.poonam.dua.model.QuizGeneral
import com.poonam.dua.viewmodels.QuestionViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
@AndroidEntryPoint
class UserPrefActivity : BindingActivity<ActivityUserPrefBinding>(), FeatureStepperQuizStepperFragment.OnItemClickListener{
    private var position = 1
    private var maxPosition = 15
    private var job: Job? = null
    private val viewModel by viewModels<QuestionViewModel>()


    private lateinit var quizGeneralList: List<QuizGeneral>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getQuizes()
        initUI()
        initDataBinding()
    }

    private fun initDataBinding() {

    }

    private fun initUI() {
        updatePositionTextView()

        setupFragment(FeatureStepperQuizStepperFragment.newInstance(quizGeneralList[position - 1], position - 1))

    }
    private fun setupFragment(fragment: Fragment) {
        try {
            this.supportFragmentManager.beginTransaction()
                .replace(R.id.contentLayout, fragment)
                .commitAllowingStateLoss()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun updatePositionTextView() {
        binding.imageNoTextView.text = "$position of $maxPosition"
//        if (position == 1) {
//            prevButton.visibility = View.GONE
//        } else if (position == maxPosition) {
//            nextButton.visibility = View.GONE
//        } else {
//            prevButton.visibility = View.VISIBLE
//            nextButton.visibility = View.VISIBLE
//        }
    }


    private fun getQuizes() {
        job?.cancel()
        job = lifecycleScope.launch {
             quizGeneralList = viewModel.getQuiz()
            maxPosition = quizGeneralList.size
            }

        }

    override fun onItemClick(position: Int, selectedAnswer: Int) {
        quizGeneralList[position].selectedAnswer = selectedAnswer
        if (this.position < maxPosition) {
            this.position++
            updatePositionTextView()
            setupFragment(FeatureStepperQuizStepperFragment.newInstance(quizGeneralList[this.position - 1], this.position - 1))
        } else {
           // Toast.makeText(this, "No More Step.", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@UserPrefActivity, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(
                intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
            finish()
        }


    }
}
