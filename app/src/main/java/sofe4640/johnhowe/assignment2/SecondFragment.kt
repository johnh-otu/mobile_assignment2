package sofe4640.johnhowe.assignment2

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import sofe4640.johnhowe.assignment2.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private var _db: LocationDatabaseHelper? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _db = LocationDatabaseHelper(activity, "locationdb", 1, null)

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener {

            var address: String? = null
            var latitude: Double? = null
            var longitude: Double? = null

            try {
                address = binding.addressInput.text.toString()
                latitude = binding.latitudeViewAdd.text.toString().toDouble()
                longitude = binding.longitudeViewAdd.text.toString().toDouble()

                val newloc = Location(address, latitude, longitude)
                _db!!.addLocation(newloc)

                Toast.makeText(activity, "Location Added Successfully!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            } catch (e : Exception) {
                if (address == "") {
                    Toast.makeText(activity, "You need to provide an address first.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (latitude == null || longitude == null) {
                    Toast.makeText(activity, "Please provide decimal number values for latitude and longitude.", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                if (latitude > 90 || latitude < -90 || longitude > 90 || longitude < -90) {
                    Toast.makeText(activity, "Please provide values between -90 and 90 for latitude and longitude.", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                Toast.makeText(activity, "Hmm.... Looks like something went wrong when trying to add the location.", Toast.LENGTH_LONG).show()
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}