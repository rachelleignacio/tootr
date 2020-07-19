package com.rachelleignacio.tootr.mvi

import android.os.Parcelable
import com.rachelleignacio.tootr.data.models.Client
import com.rachelleignacio.tootr.data.models.SessionPackage
import kotlinx.android.parcel.Parcelize

sealed class ViewState {

    val error: String? = null

    @Parcelize
    data class Main(val clients: ClientList? = null,
                    val clientDetail: ClientDetail? = null,
                    val packagesInProgress: PackagesInProgress? = null
    ) : ViewState(), Parcelable

    @Parcelize
    data class ClientList(val clients: Set<Client>? = null) : ViewState(), Parcelable

    @Parcelize
    data class ClientDetail(val client: Client? = null,
                            val openPackages: Set<SessionPackage>? = null,
                            val completedPackages: Set<SessionPackage>? = null
    ) : ViewState(), Parcelable

    @Parcelize
    data class PackagesInProgress(val packagesInProgress: Set<SessionPackage>? = null) : ViewState(), Parcelable
}