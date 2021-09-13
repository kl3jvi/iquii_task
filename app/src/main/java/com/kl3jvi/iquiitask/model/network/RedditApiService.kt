package com.kl3jvi.iquiitask.model.network

import com.kl3jvi.iquiitask.model.entities.RedditApiResponse
import com.kl3jvi.iquiitask.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RedditApiService {
    private val api = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RedditApi::class.java)

    suspend fun getResponse(query: String): RedditApiResponse {
        return api.getSubreddits(
            query = query
        )
    }
}