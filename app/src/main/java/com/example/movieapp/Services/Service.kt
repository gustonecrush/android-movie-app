package com.example.movieapp.Services

object Service {

    fun date(date: String?): String {
        val m = date?.subSequence(5,7)
        val d = date?.subSequence(8,10)
        val y = date?.subSequence(0,4)

        var monthName: String? = ""

        when(m) {
            "01" -> monthName = "Jan"
            "02" -> monthName = "Feb"
            "03" -> monthName = "Mar"
            "04" -> monthName = "Apr"
            "05" -> monthName = "May"
            "06" -> monthName = "Jun"
            "07" -> monthName = "Jul"
            "08" -> monthName = "Aug"
            "09" -> monthName = "Sep"
            "10" -> monthName = "Oct"
            "11" -> monthName = "Nov"
            "12" -> monthName = "Dec"
        }

        return "$monthName $y"

    }

}