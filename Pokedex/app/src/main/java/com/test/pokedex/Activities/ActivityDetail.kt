package com.test.pokedex.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.koushikdutta.ion.Ion
import com.test.pokedex.Adapters.AdapterList
import com.test.pokedex.R
import kotlinx.android.synthetic.main.activity_detail.*

import kotlinx.android.synthetic.main.activity_list.fab
import kotlinx.android.synthetic.main.activity_list.toolbar

class ActivityDetail : AppCompatActivity() {

    private lateinit var linearLayoutManager:LinearLayoutManager
    private lateinit var adapter:AdapterList
    private var url: String? = null
    private lateinit var movimientos: TextView
    private lateinit var name: TextView
    private lateinit var tipos: TextView
    private lateinit var velocidad: TextView
    private lateinit var ataque: TextView
    private lateinit var defensa: TextView
    private lateinit var ataque_es: TextView
    private lateinit var defensa_es: TextView
    private lateinit var hp: TextView

    private lateinit var data: JsonArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        var intent: Intent = getIntent()
        url = intent.getStringExtra("url")

        name = findViewById(R.id.pokemon_name)
        tipos = findViewById(R.id.pokemon_tipos)
        movimientos = findViewById(R.id.pokemon_moves)
        velocidad = findViewById(R.id.pokemon_stat_speed)
        ataque = findViewById(R.id.pokemon_stat_attack)
        defensa = findViewById(R.id.pokemon_stat_defense)
        ataque_es = findViewById(R.id.pokemon_stat_sa)
        defensa_es = findViewById(R.id.pokemon_stat_sd)
        hp = findViewById(R.id.pokemon_stat_hp)

        val topBar = supportActionBar
        topBar!!.title = "Detalles"
        topBar.setDisplayHomeAsUpEnabled(true)

        initializeComponents()
        initializeData()
    }

    override fun onResume() {
        super.onResume()
    }

    fun initializeComponents(){

    }

    fun initializeData(){
        Ion.with(this)
            .load(url)
            .asJsonObject()
            .done { e, result ->
                if(e == null){
                    val actionbar = supportActionBar
                    //Eliminamos el slash
                    var nameTmp = result.get("name").toString().replace("\"","")
                    actionbar!!.title = nameTmp.capitalize()
                    name.text = "No." + result.get("id").toString() + " - " + nameTmp.capitalize()
                    tipos.text= getPokemonTypes(result.get("types").asJsonArray)

                    var stat = result.get("stats").asJsonArray
                    velocidad.text = stat[0].asJsonObject.get("base_stat").toString()
                    defensa_es.text = stat[1].asJsonObject.get("base_stat").toString()
                    ataque_es.text = stat[2].asJsonObject.get("base_stat").toString()
                    defensa.text = stat[3].asJsonObject.get("base_stat").toString()
                    ataque.text = stat[4].asJsonObject.get("base_stat").toString()
                    hp.text = stat[5].asJsonObject.get("base_stat").toString()

                    movimientos.text = getPokemonMoves(result.get("moves").asJsonArray)

                    //AdapterList Function
                    if(!result.get("sprites").isJsonNull){
                        if(result.get("sprites").asJsonObject.get("front_default") != null){
                            Glide
                                .with(this)
                                .load(result.get("sprites").asJsonObject.get("front_default").asString)
                                .placeholder(R.drawable.pokemon_logo_min)
                                .error(R.drawable.pokemon_logo_min)
                                .into(pokemon_view);

                        }else{
                            pokemon_view.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.pokemon_logo_min))
                        }

                    }else{
                        pokemon_view.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.pokemon_logo_min))
                    }
                }
            }
    }

    fun getPokemonTypes(types: JsonArray):String{
        var types_list:String =""
        var start = false
        for(i in types){
            if (start) types_list += ", "
            else start = true
            var type: JsonObject = i.asJsonObject.getAsJsonObject("type")
            types_list += type.get("name").asString.capitalize()
        }
        return types_list
    }

    fun getPokemonMoves(moves: JsonArray):String{
        var moves_list:String =""
        for(i in moves){
            var move: JsonObject = i.asJsonObject.getAsJsonObject("move")
            moves_list += move.get("name").asString.replace("-"," ").capitalize() + "\n "
        }
        return moves_list
    }
}

