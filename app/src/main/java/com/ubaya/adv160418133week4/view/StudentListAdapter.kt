package com.ubaya.adv160418133week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.adv160418133week4.R
import com.ubaya.adv160418133week4.model.Student
import com.ubaya.adv160418133week4.util.loadImage
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studentList:ArrayList<Student>):RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {
    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateStudentList(newStudentList: List<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.student_list_item, parent, false)

        return StudentViewHolder(v)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.txtId.text = studentList[position].id
        holder.view.txtName.text = studentList[position].name
        holder.view.imageView2.loadImage(studentList[position].photoUrl.toString(), holder.view.progressBar)

        holder.view.btnDetail.setOnClickListener{
            val action = StudentListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}