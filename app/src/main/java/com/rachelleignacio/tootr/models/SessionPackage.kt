package com.rachelleignacio.tootr.models

import java.util.*

data class SessionPackage(val id: String? = null,
                          val numSessions: Int = -1,
                          val sessionsUsed: Int = -1,
                          val dateCompleted: Date? = null
)