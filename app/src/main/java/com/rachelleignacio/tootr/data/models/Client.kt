package com.rachelleignacio.tootr.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Client(val name: String? = null, val numPackagesBought: Int = -1) : Parcelable