package com.example.bandhan.tictactoe

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }
    fun btnclicked(view: View){
        val btnSelected = view as Button
        var cellId=0
        when(btnSelected.id){
            R.id.btn1 -> cellId=1
            R.id.btn2 -> cellId=2
            R.id.btn3 -> cellId=3
            R.id.btn4 -> cellId=4
            R.id.btn5 -> cellId=5
            R.id.btn6 -> cellId=6
            R.id.btn7 -> cellId=7
            R.id.btn8 -> cellId=8
            R.id.btn9 -> cellId=9

        }
        playgame(cellId,btnSelected)
    }
    val player1 = ArrayList<Int>()
    val player2 = ArrayList<Int>()
    var ActivePlayer=1
    fun playgame(cellId : Int,btnSelected : Button){

        if(ActivePlayer==1){
            btnSelected.setBackgroundColor(Color.RED)
            btnSelected.setText("*")
            player1.add(cellId)
            ActivePlayer=2
            val auto = intent.getIntExtra("player",2)
           // Toast.makeText(this,"$auto",Toast.LENGTH_SHORT).show()
            if(auto == 1) {
                autoplay()
            }
        }else{
            btnSelected.setBackgroundColor(Color.GREEN)
            btnSelected.setText("0")
            player2.add(cellId)
            ActivePlayer=1
        }
        btnSelected.isEnabled=false
        findWinner()
    }
    fun findWinner(){
        var winner=0
        if((player1.contains(1) && player1.contains(2) && player1.contains(3)) ||
                (player1.contains(4) && player1.contains(5) && player1.contains(6)) ||
                (player1.contains(7) && player1.contains(8) && player1.contains(9)))
        {
            winner=1
        }
        if((player2.contains(1) && player2.contains(2) && player2.contains(3)) ||
                (player2.contains(4) && player2.contains(5) && player2.contains(6)) ||
                (player2.contains(7) && player2.contains(8) && player2.contains(9)))
        {
            winner=2
        }

        if((player1.contains(1) && player1.contains(4) && player1.contains(7)) ||
                (player1.contains(2) && player1.contains(5) && player1.contains(8)) ||
                (player1.contains(3) && player1.contains(6) && player1.contains(9)))
        {
            winner=1
        }
        if((player2.contains(1) && player2.contains(4) && player2.contains(7)) ||
                (player2.contains(2) && player2.contains(5) && player2.contains(8)) ||
                (player2.contains(3) && player2.contains(6) && player2.contains(9)))
        {
            winner=2
        }
        if((player1.contains(1) && player1.contains(5) && player1.contains(9)) ||
                (player1.contains(3) && player1.contains(5) && player1.contains(7)))
        {
            winner=1
        }
        if((player2.contains(1) && player2.contains(5) && player2.contains(9)) ||
                (player2.contains(3) && player2.contains(5) && player2.contains(7)))
        {
            winner=2
        }

        if(winner==1){
            Toast.makeText(this,"Player 1 wins ", Toast.LENGTH_LONG).show()
            changeactivity()
        }
        if(winner==2){
            Toast.makeText(this,"Player 2 wins ", Toast.LENGTH_LONG).show()
            changeactivity()
        }
    }
    fun changeactivity(){
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun autoplay(){
        val emptycell = ArrayList<Int>()
        for(cellId in 1..9){
            if(!(player1.contains(cellId) || player2.contains(cellId))){
                emptycell.add(cellId)
            }
        }
        val r = Random()
        val ranIndex = r.nextInt(emptycell.size-0)+0

        val cellId = emptycell[ranIndex]
        var btnSelected : Button?
        when(cellId){
            1-> btnSelected=btn1
            2-> btnSelected=btn2
            3-> btnSelected=btn3
            4-> btnSelected=btn4
            5-> btnSelected=btn5
            6-> btnSelected=btn6
            7-> btnSelected=btn7
            8-> btnSelected=btn8
            9-> btnSelected=btn9
            else ->{
                btnSelected=btn1
            }
        }
        playgame(cellId,btnSelected)
    }
}
