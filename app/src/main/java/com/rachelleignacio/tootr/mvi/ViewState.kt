package com.rachelleignacio.tootr.mvi

import com.rachelleignacio.tootr.models.Client
import com.rachelleignacio.tootr.models.SessionPackage

sealed class ViewState {

    val error: String? = null

    data class Main(val clients: ClientList? = null,
                    val clientDetail: ClientDetail? = null,
                    val packagesInProgress: PackagesInProgress? = null)

    data class ClientList(val clients: Set<Client>? = null) : ViewState()

    data class ClientDetail(val client: Client? = null,
                            val openPackages: Set<SessionPackage>? = null,
                            val completedPackages: Set<SessionPackage>)

    data class PackagesInProgress(val packagesInProgress: Set<SessionPackage>? = null)
}