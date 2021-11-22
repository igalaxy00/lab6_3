package com.example.lab6_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import java.util.concurrent.ExecutorService

class MainActivity : AppCompatActivity() {
    private lateinit var executor: ExecutorService
    private lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView  = findViewById(R.id.imageView)
        val viewModel = MainViewModel()

        if (imageView.drawable == null) {
            viewModel.loadImage()
        }

        viewModel.bitmapData.observe(this) {
            if (it != null) {
                runOnUiThread {
                    imageView.setImageBitmap(it)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        executor.shutdown()
    }
}