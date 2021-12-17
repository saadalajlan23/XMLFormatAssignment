package com.example.xmlformatassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.student_row.view.*


class RecyclerViewAdapter(private var students: List<StudentDetails>): RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder (itemView:View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.student_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = students[position]

        holder.itemView.apply {

            tvName.text = user.name
            tvScore.text = user.score.toString()

        }
    }

    override fun getItemCount() = students.size
    fun update(students: List<StudentDetails>){
        this.students = students
        notifyDataSetChanged()
    }
}
