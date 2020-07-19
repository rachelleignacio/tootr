package com.rachelleignacio.tootr.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class SessionPackage(val id: String? = null,
                          val numSessions: Int = -1,
                          val sessionsUsed: Int = -1,
                          val dateCompleted: Date? = null
) : Parcelable