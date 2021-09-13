package com.kl3jvi.iquiitask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kl3jvi.iquiitask.model.entities.RedditApiResponse
import com.kl3jvi.iquiitask.model.network.RedditApiService
import com.kl3jvi.iquiitask.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class GalleryViewModel : ViewModel() {
    private val redditApiService = RedditApiService()
    val subredditResponse = MutableLiveData<RedditApiResponse>()

    fun getApiResponse(searchQuery: String) {
        viewModelScope.launch {
            try {
                Resource.Success(redditApiService.getResponse(searchQuery))
                subredditResponse.value = redditApiService.getResponse(searchQuery)
            } catch (e: IOException) {
                Resource.Error(e.localizedMessage, "")
            } catch (e: HttpException) {
                Resource.Error(e.localizedMessage, "")
            }

        }
    }
}