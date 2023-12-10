package com.example.five_spotify

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class myAdapter(val context:Activity, val dataList:List<Data>):
    RecyclerView.Adapter<myAdapter.myViewHolder>() {

    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView
        val title: TextView
        val play: ImageButton
        val pluse: ImageButton

        init {
            image=itemView.findViewById(R.id.music_image)
            title=itemView.findViewById(R.id.music_name)
            play=itemView.findViewById(R.id.play)
            pluse=itemView.findViewById(R.id.pluse)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        // create the view in case the layout manager fails to create the view for data
        val itemView=LayoutInflater.from(context).inflate(R.layout.each_item,parent,false)
        return  myViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        //populates the data into the view
        val currentdata=dataList[position]

        val mediaplayer=MediaPlayer.create(context,currentdata.preview.toUri())

        holder.title.text=currentdata.title

        Picasso.get().load(currentdata.album.cover).into(holder.image);

        holder.play.setOnClickListener{
            mediaplayer.start()
        }
        holder.pluse.setOnClickListener {
            mediaplayer.stop()
        }
    }
}