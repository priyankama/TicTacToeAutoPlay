package com.example.bandhan.tictactoe

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

 fun btnOneClicked(view: View){
     val intent=Intent(this,HomeActivity::class.java)
     intent.putExtra("player",1)
     startActivity(intent)
     finish()
 }
    fun btnTwoClicked(view: View){
        val intent=Intent(this,HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
