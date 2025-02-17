package com.abadock.probafirebase.Recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abadock.probafirebase.R

class MobleAdapter(private val mList: List<MobleModel>, ) : RecyclerView.Adapter<MobleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.moble_recycler, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val MobleModel = mList[position]

        holder.nom.text = MobleModel.nom
        holder.preu.text = MobleModel.preu.toString()

        holder.layoutRecycler.setOnClickListener{

        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val nom: TextView = itemView.findViewById(R.id.nom)
        val preu: TextView = itemView.findViewById(R.id.preu)
        val layoutRecycler: LinearLayout = itemView.findViewById(R.id.recycler_layout)
    }
}