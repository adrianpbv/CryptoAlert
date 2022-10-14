package com.example.android.cryptoalert.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminder_table")
data class ReminderEntity (
    @PrimaryKey
    private val id: Long = -1,

    @ColumnInfo(name = "currency_from")
    var currency_from: String = "",

    @ColumnInfo(name = "currency_to")
    var currency_to: String= "",

    @ColumnInfo(name = "time")
    var time: String = "",

    @ColumnInfo(name = "is_enabled")
    var is_enabled: Boolean = false,

    @ColumnInfo(name = "is_vibrate")
    var is_vibrate: Boolean = false,

    @ColumnInfo(name = "last_update")
    var last_update : String= "",

    @ColumnInfo(name = "last_update_time")
    var last_update_time: Long = -1,

    @ColumnInfo(name = "amount")
    var amount: Double = 1.0,

    @ColumnInfo(name = "rate")
    var rate: Double = 0.0,

    @ColumnInfo(name = "day_0")
    var day_0: Int = 0,

    @ColumnInfo(name = "day_1")
    var day_1: Int = 0,

    @ColumnInfo(name = "day_2")
    var day_2: Int = 0,

    @ColumnInfo(name = "day_3")
    var day_3: Int = 0,

    @ColumnInfo(name = "day_4")
    var day_4: Int = 0,

    @ColumnInfo(name = "day_5")
    var day_5: Int = 0,

    @ColumnInfo(name = "day_6")
    var day_6: Int = 0,

    @ColumnInfo(name = "sound_name")
    var sound_name: String = "",

    @ColumnInfo(name = "sound_url")
    var sound_url: String = ""
)