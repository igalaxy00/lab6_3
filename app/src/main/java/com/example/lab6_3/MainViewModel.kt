package com.example.lab6_3
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainViewModel : ViewModel(){

    val mutableLiveData = MutableLiveData<Bitmap>()

    fun downloadImage() {
        viewModelScope.launch(Dispatchers.IO) {
            val stream = URL(URL).openConnection().getInputStream()
            val bitmap = BitmapFactory.decodeStream(stream)
            withContext(Dispatchers.Main) {
                mutableLiveData.value = bitmap
            }
        }
    }
    companion object {
        private const val URL = "https://images-ext-2.discordapp.net/external/nd_xyZ_HZ2L38OfAWNkS2tlqpIKcstQ5yxTpgV61I5Y/https/i.ibb.co/BPDWVhj/unnamed.jpg"
    }
}