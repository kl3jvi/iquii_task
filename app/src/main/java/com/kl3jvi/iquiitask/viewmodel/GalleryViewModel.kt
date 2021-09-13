package com.kl3jvi.iquiitask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kl3jvi.iquiitask.model.entities.RedditApiResponse
import com.kl3jvi.iquiitask.model.network.RedditApiService
import kotlinx.coroutines.launch

class GalleryViewModel : ViewModel() {
    private val redditApiService = RedditApiService()
    val subredditResponse = MutableLiveData<RedditApiResponse>()

    fun getApiResponse(searchQuery: String) {
        viewModelScope.launch {
            subredditResponse.value = redditApiService.getResponse(searchQuery)
        }
    }
}