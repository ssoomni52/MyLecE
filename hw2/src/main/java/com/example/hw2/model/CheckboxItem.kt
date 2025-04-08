package com.example.hw2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CheckboxItem(
    val img: Int,
    val label: String,
    var isChecked: Boolean
): Parcelable


