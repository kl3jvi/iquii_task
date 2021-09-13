package com.kl3jvi.iquiitask.viewmodel

import androidx.lifecycle.*
import com.kl3jvi.iquiitask.model.database.FavoriteImageRepository
import com.kl3jvi.iquiitask.model.entities.FavoriteImage
import com.kl3jvi.iquiitask.model.entities.RedditApiResponse
import com.kl3jvi.iquiitask.model.network.RedditApiService
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class GalleryViewModel(private val repository: FavoriteImageRepository) : ViewModel() {
    private val redditApiService = RedditApiService()
    val subredditResponse = MutableLiveData<RedditApiResponse>()

    fun insert(image: FavoriteImage) = viewModelScope.launch {
        repository.insertImage(image)
    }

    val favoriteImagesList: LiveData<List<FavoriteImage>> = repository.favoriteImages.asLiveData()

    fun getApiResponse(searchQuery: String) {
        viewModelScope.launch {
            try {
                subredditResponse.value = redditApiService.getResponse(searchQuery)
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: HttpException) {
                e.printStackTrace()
            }
        }
    }
}

class FavImageViewModelFactory(private val repository: FavoriteImageRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GalleryViewModel::class.java)) {
            return GalleryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}