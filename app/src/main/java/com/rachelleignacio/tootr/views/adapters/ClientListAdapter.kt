package com.rachelleignacio.tootr.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rachelleignacio.tootr.R
import com.rachelleignacio.tootr.data.models.Client
import kotlinx.android.synthetic.main.client_list_item.view.*

class ClientListAdapter : RecyclerView.Adapter<ClientViewHolder>() {
    private val clients = mutableListOf<Client>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ClientViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.client_list_item, parent, false))

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        holder.clientName.text = String.format(holder.itemView.resources.getString(R.string.list_item_bullet), clients[position].name)
    }

    override fun getItemCount() = clients.size
}

class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val clientName: TextView = itemView.client_name
}