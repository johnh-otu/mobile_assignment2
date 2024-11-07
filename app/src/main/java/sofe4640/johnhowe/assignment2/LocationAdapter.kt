package sofe4640.johnhowe.assignment2

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class LocationAdapter(locationList: MutableList<Location>?, fragment: Fragment) : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {
    private var locationsList: MutableList<Location>? = locationList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.location_display, parent, false) // Ensure this matches your XML filename
        return LocationViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location: Location = locationsList!![position]
        holder.id = location.getID()
        holder.addressView.text = location.getAddress()
        holder.latitudeView.text = location.getLatitude().toString()
        holder.longitudeView.text = location.getLongitude().toString()

        holder.deleteBtn.setOnClickListener(View.OnClickListener { view ->
            val adapterPosition: Int = holder.getAdapterPosition()
            val dbHelper = LocationDatabaseHelper(view.context, "locationdb", 1, null)

            val transactionResult: Boolean = dbHelper.deleteNote(location.getID())
            if (transactionResult) {
                locationsList!!.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
                Toast.makeText(view.context, "Location deleted !", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(view.context, "Error in deletion !", Toast.LENGTH_LONG).show()
            }
        })

        holder.editBtn.setOnClickListener(View.OnClickListener { view ->
            val bundle = Bundle()
            bundle.putInt("locationid", holder.id)
            Navigation.findNavController(holder.addressView).navigate(R.id.action_FirstFragment_to_EditFragment, bundle)
        })
    }

    override fun getItemCount(): Int {
        return locationsList!!.size
    }

    @SuppressLint("NotifyDataSetChanged") //entire dataset can change
    fun updateList(newList: MutableList<Location>?) {
        locationsList = newList
        notifyDataSetChanged()
    }

    class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id: Int = 0
        var addressView: TextView = itemView.findViewById(R.id.locationAddressView)
        var latitudeView: TextView = itemView.findViewById(R.id.latitudeView)
        var longitudeView: TextView = itemView.findViewById(R.id.longitudeView)

        var deleteBtn: ImageButton = itemView.findViewById(R.id.deleteButton)
        var editBtn: ImageButton = itemView.findViewById(R.id.editButton)
    }
}
