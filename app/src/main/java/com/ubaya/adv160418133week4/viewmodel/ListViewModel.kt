package com.ubaya.adv160418133week4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.adv160418133week4.model.Student

class ListViewModel(application: Application): AndroidViewModel(application) {
    val studentsLD = MutableLiveData<List<Student>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
//    val loadingDoneLD = MutableLiveData<Boolean>()

    private var TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh() {
//        val student1 =
//            Student("29-7346075","Loni","1983-08-11","4387287239","http://dummyimage.com/100x75.png/dddddd/000000")
//        val student2 =
//            Student("25-2223397","Ashley","1953-11-25","3818143583","http://dummyimage.com/100x75.png/ff4444/ffffff")
//        val student3 =
//            Student("52-2712075","Cammi","1957-08-12","3319401761","http://dummyimage.com/100x75.png/cc0000/ffffff")
//
//        val studentList:ArrayList<Student> = arrayListOf<Student>(student1, student2, student3)
//        studentsLD.value = studentList
//        loadingErrorLD.value = false
//        loadingDoneLD.value = true

        loadingErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val sType = object : TypeToken<List<Student>>() { }.type
                val result = Gson().fromJson<List<Student>>(response, sType)
                studentsLD.value = result

                loadingLD.value = false
                Log.d("showvoley", response.toString())

            },
            {
                loadingErrorLD.value = true
                loadingLD.value = false
                Log.d("showvoley", it.toString())

            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}