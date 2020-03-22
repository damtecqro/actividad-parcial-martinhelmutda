package com.test.pokedex.Activities

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.koushikdutta.ion.Ion
import com.test.pokedex.Adapters.AdapterList
import com.test.pokedex.R

import kotlinx.android.synthetic.main.activity_list.*
import org.json.JSONArray
import org.json.JSONObject

class ActivityList : AppCompatActivity() {

    private lateinit var linearLayoutManager:LinearLayoutManager
    private lateinit var adapter:AdapterList

    private lateinit var data: JsonArray
    private lateinit var dataNoUso: JSONArray

    private lateinit var json1: JsonObject
    private lateinit var json2: JSONObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)

        initializeComponents()
        initializeListeners()
        initializeData()
    }

    override fun onResume() {
        super.onResume()
    }

    fun initializeComponents(){

    }

    fun initializeListeners(){
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    fun initializeData(){
        Ion.with(this)
            .load("https://pokeapi.co/api/v2/pokemon/?offset=0&limit=964")
            .asJsonObject()
            .done { e, result ->
                if(e == null){
                    Log.i("Salida", result.getAsJsonArray("results").size().toString())
                    data = result.getAsJsonArray("results")
                    initializeList()
                }
            }
    }

    fun initializeList(){
        linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        linearLayoutManager.scrollToPosition(0)

        adapter = AdapterList()
        adapter.AdapterList(this,data)

        recycler_view_list.layoutManager = linearLayoutManager
        recycler_view_list.adapter = adapter
        recycler_view_list.itemAnimator = DefaultItemAnimator()


    }

}
