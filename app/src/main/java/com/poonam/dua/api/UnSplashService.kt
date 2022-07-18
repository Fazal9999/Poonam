package com.poonam.dua.api

import com.poonam.dua.model.ImagesResponse
import com.poonam.dua.model.QuizGeneral
import com.poonam.dua.repo.Questions
import retrofit2.http.GET
import retrofit2.http.Query

interface UnSplashService {
    @GET("photos")
    suspend fun getImages(
        @Query("order_by") orderBy: String,
        @Query("page") page: Int,
        @Query("per_page") limit: Int
    ): List<ImagesResponse>
}