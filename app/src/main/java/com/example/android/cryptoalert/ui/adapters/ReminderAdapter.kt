package com.example.android.cryptoalert.ui.adapters

import com.example.android.cryptoalert.BR
import com.example.android.cryptoalert.R
import com.example.android.cryptoalert.model.Reminder
import com.example.android.cryptoalert.ui.base.BaseRecyclerViewAdapter

class ReminderAdapter (callback: (selectedReminder: Reminder) -> Unit):
    BaseRecyclerViewAdapter<Reminder>(callback) {
    override fun getDataBindingVariable() = BR.reminder
    override fun getLayoutRes(viewType: Int) = R.layout.item_reminder
}