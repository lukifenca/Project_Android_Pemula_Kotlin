package com.lukitor.projectandroidpemulakotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val img: ImageView = findViewById(R.id.imageView2)
        Glide.with(this)
                .load(R.drawable.book)
                .into(img);

        Handler().postDelayed({
            startActivity(Intent(this, ListNovel::class.java))
            finish()
        }, 9000)

    }
}