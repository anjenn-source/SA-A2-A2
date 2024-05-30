package com.example.project136.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.example.project136.Activities.DetailActivity
import com.example.project136.Domains.PopularDomain
import com.example.project136.R
import android.net.Uri
import androidx.appcompat.widget.AppCompatButton



class PupolarAdapter (var items: ArrayList<PopularDomain>) :
    RecyclerView.Adapter<PupolarAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_popular, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTxt.text = items[position].title
        holder.locationTxt.text = items[position].location
        holder.scoreTxt.text = "" + items[position].score
        val drawableResId = holder.itemView.resources.getIdentifier(
            items[position].pic,
            "drawable", holder.itemView.context.packageName
        )
        Glide.with(holder.itemView.context)
            .load(drawableResId)
            .transform(CenterCrop(), GranularRoundedCorners(40f, 40f, 40f, 40f))
            .into(holder.pic)
        holder.itemView.setOnClickListener { v: View? ->
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("object", items[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTxt: TextView
        var locationTxt: TextView
        var scoreTxt: TextView
        var pic: ImageView

        init {
            titleTxt = itemView.findViewById(R.id.titleTxt)
            locationTxt = itemView.findViewById(R.id.locationTxt)
            scoreTxt = itemView.findViewById(R.id.scoreTxt)
            pic = itemView.findViewById(R.id.picImg)

    }
}}
