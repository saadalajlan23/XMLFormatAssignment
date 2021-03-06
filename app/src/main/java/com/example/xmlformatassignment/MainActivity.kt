package com.example.xmlformatassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var rvMain: RecyclerView
    private lateinit var rvAdapter: RecyclerViewAdapter

    private lateinit var students: List<StudentDetails>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        students = listOf()
        rvMain = findViewById(R.id.rvMain)
        rvAdapter = RecyclerViewAdapter(students)
        rvMain.adapter = rvAdapter
        rvMain.layoutManager = LinearLayoutManager(this)

        parseXML()
    }

    private fun parseXML(){
        try{
            val parser = MyXmlPullParserHandler()
            val iStream = assets.open("student_details.xml")
            students = parser.parse(iStream)
            rvAdapter.update(students)
        }catch(e: IOException){
            println("ISSUE: $e")
        }
    }
}