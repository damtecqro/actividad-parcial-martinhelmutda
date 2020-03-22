package com.test.pokedex.Activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.test.pokedex.R

class ActivitySplashscreen : AppCompatActivity() {

    lateinit var handler: Handler
    val SPLASHCREEN_DURATION:Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splaschscreen)

        handler = Handler()
        handler.postDelayed(Runnable {
            var intent: Intent = Intent(this,
                ActivityList::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    or Intent.FLAG_ACTIVITY_NEW_TASK
                    or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            intent.putExtra("USERNAME","pokedex")
            intent.putExtra("PASSWORD","pokedex")

            finish()

            this.startActivity(intent)
        },SPLASHCREEN_DURATION)

    }
}







