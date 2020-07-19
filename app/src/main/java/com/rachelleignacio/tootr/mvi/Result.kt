package com.rachelleignacio.tootr.mvi

import android.util.Log
import com.rachelleignacio.tootr.data.models.Client

sealed class Result {

    fun toViewState(): ViewState.Main {
        Log.d("RIStuff", "Intent toViewState()")
        return when (this) {
            is ClientList -> ViewState.Main(clients = ViewState.ClientList(clientList))
            is ClientDetail -> ViewState.Main(clientDetail = ViewState.ClientDetail())
        }
    }

    data class ClientList(val clientList: Set<Client>) : Result()

    data class ClientDetail(val client: Client) : Result()
}