package com.example.lab6_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView

import android.graphics.BitmapFactory
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle

import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image = findViewById<ImageView>(R.id.imageView)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                withContext(Dispatchers.IO) {
                    val bitmap = BitmapFactory.decodeStream(
                        URL("https://images-ext-2.discordapp.net/external/nd_xyZ_HZ2L38OfAWNkS2tlqpIKcstQ5yxTpgV61I5Y/https/i.ibb.co/BPDWVhj/unnamed.jpg")
                            .openConnection().inputStream
                    )
                    withContext(Dispatchers.Main) {
                        image.setImageBitmap(bitmap)
                    }
                }
            }
        }
    }
}