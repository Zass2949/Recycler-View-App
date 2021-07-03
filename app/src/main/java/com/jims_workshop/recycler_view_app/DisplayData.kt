package com.jims_workshop.recycler_view_app

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView

class DisplayData : AppCompatActivity() {
    lateinit var name: TextView
    lateinit var image: CircleImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_data)
        //Init of Name and Image to be displayed and get the data here

        name = findViewById(R.id.dataText)
        image = findViewById(R.id.dataImage)
        //Getting data here from intent should be same as putExtra entity
        name.text=intent.getStringExtra("dataName")
        image.setImageResource(intent.getIntExtra("dataImage",R.mipmap.ic_launcher))

        name.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("This Is Dialog Box")
                .setIcon(R.drawable.ic_create)
                .setPositiveButton("Yes"){ dialog, which ->
                    Toast.makeText(this, "This is "  +name.text+ " recycler Item", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No") { dialog, which ->
                    Log.i("Negative Tag", "Button Clicked")
                }
                .setNeutralButton("Cancel"){
                    dialog, which ->  dialog.dismiss()
                }
                .show()
        }

    }
}