package com.example.lab6_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView: ImageView = findViewById(R.id.imageView)
        if (imageView.drawable == null) {
            viewModel.mutableLiveData.observe(this){
                if (it != null) {
                    imageView.setImageBitmap(it)
                }
            }
            viewModel.downloadImage()
        }
    }
}