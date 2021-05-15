package com.lukitor.projectandroidpemulakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class LoadDetail : AppCompatActivity() {
    var listData: ArrayList<Novel> = ArrayList<Novel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_detail)
        val img: ImageView = findViewById(R.id.imageLoadDetail)
        Glide.with(this)
            .load(R.drawable.load1)
            .into(img);

        Handler().postDelayed({
            val tipe = intent.getStringExtra("tipe")
            if (tipe == "1"){
                startActivity(Intent(this, ListNovel::class.java))
                finish()
            }
            else{
                val inte = Intent(this, DetailNovel::class.java)
                val judul = intent.getStringExtra("judul")
                val harga = intent.getStringExtra("harga")
                val desc = intent.getStringExtra("desc")
                val rating = intent.getStringExtra("rating")
                val foto = intent.getIntExtra("foto",0)
                inte.putExtra("judul", judul)
                inte.putExtra("harga", harga)
                inte.putExtra("desc", desc)
                inte.putExtra("rating", rating)
                inte.putExtra("foto", foto)
                startActivity(inte)
                finish()
            }
        }, 2000)
    }
}