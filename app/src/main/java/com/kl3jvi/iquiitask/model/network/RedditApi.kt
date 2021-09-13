package com.kl3jvi.iquiitask.model.network

import com.kl3jvi.iquiitask.model.entities.RedditApiResponse
import com.kl3jvi.iquiitask.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path

interface RedditApi {
    @GET(Constants.API_ENDPOINT)
    suspend fun getSubreddits(
        @Path(Constants.KEYWORD) query: String
    ): RedditApiResponse
}