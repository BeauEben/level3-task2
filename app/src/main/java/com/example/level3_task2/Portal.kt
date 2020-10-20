package com.example.level3_task2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.w3c.dom.Text
import java.net.URL

@Parcelize
data class Portal (
    var titleText: String,
    var urlText: String
) : Parcelable