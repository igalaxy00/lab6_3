package com.example.lab6_3

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainViewModel: ViewModel() {
    val bitmapData = MutableLiveData<Bitmap>()

    fun loadImage() {
        viewModelScope.launch(Dispatchers.IO) {
            URL("https://images-ext-2.discordapp.net/external/nd_xyZ_HZ2L38OfAWNkS2tlqpIKcstQ5yxTpgV61I5Y/https/i.ibb.co/BPDWVhj/unnamed.jpg")
            .openConnection().getInputStream()
            .use {
                val bitmap = BitmapFactory.decodeStream(it)
                bitmapData.postValue(bitmap)
            }
        }
    }
}