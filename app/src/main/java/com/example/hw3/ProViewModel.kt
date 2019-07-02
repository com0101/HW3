package com.example.hw3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import android.provider.SyncStateContract.Helpers.insert
import android.provider.SyncStateContract.Helpers.update
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope


class ProViewModel(
    val database : ContentDAO,
    application: Application): AndroidViewModel(application) {
    private var viewModelJob = Job()
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)
    private var content = MutableLiveData<ContentData?>()
    private val contents = database.getContents()

    init {
        initializeContent()
    }
    private fun initializeContent() {
        uiScope.launch {
            content.value = getContentFromDatabase()
        }
    }

    private suspend fun getContentFromDatabase():  ContentData? {
        return withContext(Dispatchers.IO) {
            var ct = database.getContent()
            /*if (ct?.endTimeMilli != ct?.startTimeMilli) {
                ct = null
            }*/
            ct
        }
    }

    fun onStartWriting() {
        uiScope.launch {
            val newContent = ContentData( )
            insert(newContent)
            content.value = getContentFromDatabase()
        }
    }
    private suspend fun insert(content: ContentData){
        withContext(Dispatchers.IO) {
            database.insert(content)
        }
    }
    fun onSaveWriting() {
        uiScope.launch {
            val oldNight = content.value ?: return@launch
            //oldNight.endTimeMilli = System.currentTimeMillis()
            update(oldNight)
        }
    }
    private suspend fun update(content: ContentData) {
        withContext(Dispatchers.IO) {
            database.update(content)
        }
    }
}