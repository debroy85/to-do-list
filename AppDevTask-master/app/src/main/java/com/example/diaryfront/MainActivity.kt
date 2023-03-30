package com.example.diaryfront

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.ArrayList
import javax.sql.DataSource



class MainActivity : AppCompatActivity(), ClickDelInterface {

    lateinit var viewModel: DiaryViewModel
    lateinit var add: FloatingActionButton
    lateinit var diaryEnt: RecyclerView
    lateinit var diaryadp : DiaryADAPTER
    val numberlist: MutableList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title = "YourEntries!!"

        add = findViewById(R.id.addButton)
        diaryEnt = findViewById(R.id.recycler)
        diaryEnt.layoutManager = LinearLayoutManager(this@MainActivity)
        diaryadp = DiaryADAPTER(this,this)
        diaryEnt.adapter = diaryadp


        viewModel = ViewModelProvider(this).get(DiaryViewModel::class.java)
        viewModel.allEntries.observe(this, Observer { Diary->
            diaryadp.setData(Diary)
        })

        add.setOnClickListener{
            val intent = Intent(this@MainActivity,AddEntry::class.java)
            startActivity(intent)
            this.finish()
        }

    }

    override fun OnclickDelete(diary: Diary) {
        viewModel.deleteEntry(diary)
        Toast.makeText(this,"Entry Deleted", Toast.LENGTH_SHORT).show()
    }

}
