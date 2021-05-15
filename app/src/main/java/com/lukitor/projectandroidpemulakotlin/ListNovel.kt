package com.lukitor.projectandroidpemulakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list_novel.*

class ListNovel : AppCompatActivity() {
    val listData: ArrayList<Novel> = ArrayList<Novel>()
    private lateinit var rvHeroes: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_novel)
        rvHeroes = findViewById(R.id.rvList)
        rvHeroes.setHasFixedSize(true)
        supportActionBar?.setTitle("List Novel")
        supportActionBar?.setSubtitle("Daftar Seluruh Novel")
        val judul = resources.getStringArray(R.array.judulnovel)
        val rating = resources.getStringArray(R.array.ratingnovel)
        val harga = resources.getStringArray(R.array.harganovel)
        val desc = resources.getStringArray(R.array.descnovel)
        val gambar = resources.getStringArray(R.array.datafoto)

        for (i in 0..(judul.size - 1)){
            val temp = Novel()
            temp.judul = judul[i]
            temp.rating = rating[i]
            temp.harga = harga[i]
            temp.deskripsi = desc[i]
            val tempgambar = resources.getIdentifier(gambar[i],"drawable", packageName)
            temp.foto = tempgambar
            listData.add(temp)
        }

        showRecyclerCardView()
    }

    private fun showRecyclerCardView() {
        rvList.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter: CardViewHeroAdapter = CardViewHeroAdapter(listData)
        rvList.adapter = cardViewHeroAdapter

        val inte = Intent(this, LoadDetail::class.java)
        cardViewHeroAdapter.setOnItemClickCallback(object: CardViewHeroAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Novel) {
                inte.putExtra("judul", data.judul)
                inte.putExtra("harga", data.harga)
                inte.putExtra("desc", data.deskripsi)
                inte.putExtra("rating", data.rating)
                inte.putExtra("foto", data.foto)
                inte.putExtra("tipe","2")
                startActivity(inte)
                finish()
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profilee,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_profile){
            val intent = Intent(this, Load::class.java)
            intent.putExtra("tipe","2")
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}