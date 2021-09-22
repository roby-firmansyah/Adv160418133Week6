package com.ubaya.adv160418133week4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.adv160418133week4.model.Student

class DetailListModel: ViewModel() {
    val studentLD = MutableLiveData<Student>()

    fun fetch()
    {
        val student1 =
            Student("29-7346075","Loni","1983-08-11","4387287239","http://dummyimage.com/100x75.png/dddddd/000000")
        studentLD.value = student1
    }

}