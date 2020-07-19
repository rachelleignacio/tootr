package com.rachelleignacio.tootr.mvi

import android.util.Log
import com.rachelleignacio.tootr.data.models.Client
import java.lang.IllegalArgumentException

sealed class Intent {

    fun toAction(): Action {
        Log.d("RIStuff", "Intent toAction()")
        return when(this) {
            is ViewClientList -> Action.GetClientList()
            else -> throw IllegalArgumentException("Intent.toAction() not yet implemented")
        }
    }

    class ViewClientList : Intent()

    class ViewPackagesInProgress : Intent()

    data class ViewClient(val client: Client) : Intent()

    data class AddClient(val newClient: Client) : Intent()

    data class AddPackage(val forClient: Client) : Intent()
}
