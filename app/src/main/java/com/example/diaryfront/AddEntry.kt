package com.example.diaryfront

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import java.text.SimpleDateFormat
import java.util.*

class AddEntry : AppCompatActivity() {
     lateinit var diarytitle: EditText
     lateinit var diaryentry :EditText
     lateinit var add: Button
     lateinit var viewModel: DiaryViewModel
     var  ID = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_entry)
        diarytitle = findViewById(R.id.new_title)
        diaryentry = findViewById(R.id.description)
        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(DiaryViewModel::class.java)
        add = findViewById(R.id.button)


        val entrytype = intent.getStringExtra("entrytype")
        val actionbar = supportActionBar
        actionbar!!.title = "Add Entry !!"
       actionbar.setDisplayHomeAsUpEnabled(true)




        add.setOnClickListener {

                val stringtitle = diarytitle.text.toString()
                val stringdesc = diaryentry.text.toString()

                if (stringtitle.isNotEmpty() && stringdesc.isNotEmpty()) {
                    val sdf = SimpleDateFormat("HH:mm -dd MM yyyy")
                    val currDate: String = sdf.format(Date())
                    viewModel.addEntry(Diary(stringtitle, stringdesc, currDate))
                    Toast.makeText(this, "Entry Added Successfully :) ", Toast.LENGTH_LONG).show()
                }


            startActivity(Intent(applicationContext, MainActivity::class.java))
            this.finish()
        }
    }

    override fun onSupportNavigateUp():Boolean {
        onBackPressed()
         startActivity(Intent(applicationContext, MainActivity::class.java))
        this.finish()
        return true
    }
}