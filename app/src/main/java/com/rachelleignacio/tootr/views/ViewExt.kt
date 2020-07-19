package com.rachelleignacio.tootr.views

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment

fun Fragment.withArg(key: String, value: Parcelable) = apply {
    arguments = Bundle(1).apply { putParcelable(key, value) }
}