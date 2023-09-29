package com.example.reserbus21.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reserbus21.BanderasTel
import com.example.reserbus21.R

class BanderasAdapter(private val banderasList:List<BanderasTel>) : RecyclerView.Adapter<BanderasViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BanderasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BanderasViewHolder(layoutInflater.inflate(R.layout.item_banderas, parent, false))
    }

    override fun onBindViewHolder(holder: BanderasViewHolder, position: Int) {
        val item = banderasList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = banderasList.size
}