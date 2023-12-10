package com.example.five_spotify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recycular: RecyclerView
    lateinit var myAdapter: myAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycular=findViewById(R.id.recycular)
        val retrofitBuilder=Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiInterface::class.java)
        val retrofitData=retrofitBuilder.getData("eminem")
        retrofitData.enqueue(object : Callback<music_data?> {
            override fun onResponse(
                call: Call<music_data?>, response: Response<music_data?>
            ) {
                val dataList= response.body()?.data!!
//                val textView= findViewById<TextView>(R.id.helloText)
//                textView.text=dataList.toString()
                myAdapter=myAdapter(this@MainActivity,dataList)
                recycular.adapter=myAdapter
                recycular.layoutManager=LinearLayoutManager(this@MainActivity)
                Log.d("TAG: onResponse", "onResponse: "+response.body())
            }

            override fun onFailure(call: Call<music_data?>, t: Throwable) {
                Log.d("TAG: onFailure", "onFailure: "+t.message)
            }
        })
    }
}
