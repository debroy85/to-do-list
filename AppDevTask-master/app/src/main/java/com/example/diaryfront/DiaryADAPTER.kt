package com.example.diaryfront

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class DiaryADAPTER(val context: Context,
                   val clickDelInterface: ClickDelInterface
):RecyclerView.Adapter<DiaryADAPTER.ViewHolder>() {


     private var allEntries  = emptyList<Diary>()

     class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val Dtime = itemview.findViewById<TextView>(R.id.time_)
        val Dtitle = itemview.findViewById<TextView>(R.id.title_)
        val Ddel = itemview.findViewById<ImageView>(R.id.del_)
        val Dbody = itemview.findViewById<TextView>(R.id.entry_body)
         fun bind(diary: Diary){
             Dtitle.setText(diary.DiaryTitle)
             Dbody.setText(diary.Diary_des)
             Dtime.setText(diary.time_stamp)
         }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
         LayoutInflater.from(parent.context).inflate(R.layout.diary_card,parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

     when(holder){
         is ViewHolder ->{
             holder.bind(allEntries[position])
         }
     }


        holder.Ddel.setOnClickListener{
            clickDelInterface.OnclickDelete(allEntries.get(position))
        }

    }
    fun setData(entry: List<Diary>){
        this.allEntries = entry
        notifyDataSetChanged()
    }



    override fun getItemCount(): Int {
        return allEntries.size
    }


}
interface ClickDelInterface {
    fun OnclickDelete(diary: Diary)

}
