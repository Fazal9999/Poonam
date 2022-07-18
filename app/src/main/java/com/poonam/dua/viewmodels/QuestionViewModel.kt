package com.poonam.dua.viewmodels
import androidx.lifecycle.ViewModel
import com.poonam.dua.di.modules.CONTEXT_APP
import com.poonam.dua.di.modules.TypeOfContext
import com.poonam.dua.model.QuizGeneral
import com.poonam.dua.repo.Repository
import com.poonam.dua.utils.SharedPreferencesHelper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
class QuestionViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    //lazy-system instantiate it when it needed
    //val questions by lazy { MutableLiveData<List<QuizGeneral>>() }
    private var currentResult: List<QuizGeneral>? = null

//    @Inject
//    @TypeOfContext(CONTEXT_APP)
//    lateinit var prefs: SharedPreferencesHelper
    private var questions: Flow<QuizGeneral>? = null

    fun getQuiz(): List<QuizGeneral> {
         val newResult: List<QuizGeneral> =
            repository.quizGeneralList
        currentResult = newResult
        return newResult
    }
}