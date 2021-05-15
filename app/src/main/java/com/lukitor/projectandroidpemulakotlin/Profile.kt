package com.lukitor.projectandroidpemulakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.setTitle("Profile")
        val img: ImageView = findViewById(R.id.fotoku)
        val namaku: TextView = findViewById(R.id.txtNama)
        val emailku: TextView = findViewById(R.id.txtemail)
        val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.imganim)
        //img.startAnimation(anim)
        //namaku.startAnimation(anim)
        //emailku.startAnimation(anim)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.list,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_list){
            val intent = Intent(this, Load::class.java)
            intent.putExtra("tipe","1")
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}