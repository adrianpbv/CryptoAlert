package com.example.android.cryptoalert.model

class Reminder {
    private lateinit var id: String
    private lateinit var currency_from: String
    private lateinit var currency_to: String
    private lateinit var time: String
    private var is_enable: Boolean = false
    private var vabration: Boolean = false
    private val days = BooleanArray(7)

    private lateinit var last_updated: String

    private var amount: Double = 1.0
    private var rate: Double = 1.0

    private var sound: String = ""
    private var sound_uri: String = ""

    /**
     * Verify that all days of the week are true or none is false
     * The user has enabled the reminder for the entire week
     */
    fun isEnableAllDays() = days.asSequence().none { !it }

    /**
     * Verify that all days are not set for reminder
     * The user hasn't selected any day yet
     */
    fun isDisableAllDays() = days.asSequence().none { it }


    fun getRepeatText(): String{
        if (isEnableAllDays())
            return "Every Day"
        if(isDisableAllDays())
            return "Not Repeat"

        var result = ""
        when{
            days[0] -> result += "Sun, "
            days[1] -> result += "Mon, "
            days[2] -> result += "Tue, "
            days[3] -> result += "Wes, "
            days[4] -> result += "Thu, "
            days[5] -> result += "Fri, "
            days[6] -> result += "Sat, "

        }

        result = result.substring(0, result.length - 2)
        return result
    }
}