package com.jims_workshop.recycler_view_app


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class CustomAdapter(context: Context) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    // We can't directly use Constructor in Kotlin
    var context: Context = context
    // Constructor Initilization
    init {

    }

    //Names and No. of Images must be same else the App will crash
    val names =
        arrayOf(
            "NPAV",
            "GEHLOT",
            "NPAV",
            "GEHLOT",
            "NPAV",
            "GEHLOT",
            "NPAV",
            "GEHLOT",
            "NPAV",
            "GEHLOT"
        )
    val images =
        intArrayOf(
            R.drawable.npav,
            R.drawable.gehlot_icon,
            R.drawable.npav,
            R.drawable.gehlot_icon,
            R.drawable.npav,
            R.drawable.gehlot_icon,
            R.drawable.npav,
            R.drawable.gehlot_icon,
            R.drawable.npav,
            R.drawable.gehlot_icon
        )

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var customAdapter=CustomAdapter(context = itemView.context)
        var Text: TextView
        var Image: CircleImageView

        init {
            Image = itemView.findViewById(R.id.imageView)
            Text = itemView.findViewById(R.id.viewText)
            itemView.setOnClickListener {
                //Have to use itemView.context when this will not work and Start Child Acticity
                val intent = Intent(itemView.context, DisplayData::class.java)

                //Parsing Data From One Activity to Child Activity
                intent.putExtra("dataName", Text.text.toString().trim())
                intent.putExtra("dataImage",customAdapter.images[adapterPosition])
                itemView.context.startActivity(intent)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return names.count()
    }

    override fun onBindViewHolder(holder: CustomAdapter.MyViewHolder, position: Int) {
        holder.Text.text = names[position]
        holder.Image.setImageResource(images[position])

    }


}
