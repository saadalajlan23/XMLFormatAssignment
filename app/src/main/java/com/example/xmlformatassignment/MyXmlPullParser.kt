package com.example.xmlformatassignment

import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class MyXmlPullParserHandler {
    private val student_details = ArrayList<StudentDetails>()
    private var text = ""
    private var studentId= 0
    private var studentName = ""
    private var studentScore = 0f

    fun parse(inputStream: InputStream): List<StudentDetails> {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("id",true)-> {
                            studentId = text.toInt()
                        }
                        tagName.equals("name", true) -> {
                            studentName = text.toString()
                        }
                        tagName.equals("score", ignoreCase = true) -> {
                            studentScore = text.toFloat()
                        }
                        else -> student_details.add(StudentDetails(studentId,studentName, studentScore))
                    }

                    else -> {
                    }
                }
                eventType = parser.next()
            }

        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return student_details
    }
}