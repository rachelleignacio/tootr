package com.rachelleignacio.tootr.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.rachelleignacio.tootr.R
import com.rachelleignacio.tootr.mvi.ViewState
import com.rachelleignacio.tootr.views.adapters.ClientListAdapter
import com.rachelleignacio.tootr.views.withArg

private const val CURRENT_CLIENT_LIST_VM = "currentClientListViewModel"

fun newClientListFragment(clientList: ViewState.ClientList) = ClientListFragment().withArg(CURRENT_CLIENT_LIST_VM, clientList)

class ClientListFragment : Fragment() {

    private val clientListAdapter = ClientListAdapter()
    private var clientList: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_client_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}