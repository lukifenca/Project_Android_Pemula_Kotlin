package com.lukitor.projectandroidpemulakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailNovel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_novel)
        val judul = intent.getStringExtra("judul")
        val harga = intent.getStringExtra("harga")
        val desc = intent.getStringExtra("desc")
        val rating = intent.getStringExtra("rating")
        val foto = intent.getIntExtra("foto",0)
        val ratingg: ImageView = findViewById(R.id.gambarratingdetail)
        val gambarg: ImageView = findViewById(R.id.gambar_detail)
        val judulg: TextView = findViewById(R.id.judul_detail)
        val hargag: TextView = findViewById(R.id.judul_detail2)
        val descg: TextView = findViewById(R.id.synopsis)
        judulg.text = judul
        hargag.text = harga
        descg.text = desc
        if (rating == "1") {
            ratingg.setImageResource(R.drawable.star1)
        }
        else if (rating == "2"){
            ratingg.setImageResource(R.drawable.star2)
        }
        else if (rating == "3"){
            ratingg.setImageResource(R.drawable.star3)
        }
        else if (rating == "4"){
            ratingg.setImageResource(R.drawable.star4)
        }
        else if (rating == "5"){
            ratingg.setImageResource(R.drawable.star5)
        }
        gambarg.setImageResource(foto)
        val btn: Button = findViewById(R.id.btnMenu)
        btn.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent(this, LoadDetail::class.java)
            intent.putExtra("tipe","1")
            startActivity(intent)
            finish()
        })
    }
}