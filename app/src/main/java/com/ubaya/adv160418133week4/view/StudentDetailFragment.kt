package com.ubaya.adv160418133week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ubaya.adv160418133week4.R
import com.ubaya.adv160418133week4.viewmodel.DetailListModel
import kotlinx.android.synthetic.main.fragment_student_detail.*

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailListModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        viewModel = ViewModelProvider(this).get(DetailListModel::class.java)
        viewModel.fetch()

        val v = viewModel.studentLD.value

        txtId.setText(v?.id)
        txtName.setText(v?.name)
        txtBod.setText(v?.bod)
        txtPhone.setText(v?.phone)

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {

        })
    }

}