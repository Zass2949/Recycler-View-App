package com.jims_workshop.recycler_view_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recycler_view:RecyclerView
    lateinit var customAdapter:CustomAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view=findViewById(R.id.recyclerView)
        //Initlization
        customAdapter= CustomAdapter(this)
        linearLayoutManager=LinearLayoutManager(this)
        recycler_view.adapter=customAdapter
        recycler_view.layoutManager=linearLayoutManager

    }
}