package com.example.reserbus21.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reserbus21.BanderasTel
import com.example.reserbus21.R

class BanderasViewHolder(view: View): RecyclerView.ViewHolder(view){

    val banderasImagen = view.findViewById<ImageView>(R.id.ivBanderas)
    val banderasTexto = view.findViewById<TextView>(R.id.tvBanderas)


    fun render(banderitas: BanderasTel){
        banderasTexto.text = banderitas.bandera

    }
}