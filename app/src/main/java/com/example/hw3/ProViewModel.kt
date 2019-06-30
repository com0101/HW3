package com.example.hw3

import android.app.Application
import androidx.lifecycle.AndroidViewModel


class ProViewModel(
    val database : ContentDAO,
    application: Application): AndroidViewModel(application) {

}