package sofe4640.johnhowe.assignment2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import sofe4640.johnhowe.assignment2.databinding.FragmentSecondBinding

// the fragment initialization parameters
private const val ARG_ID = "locationid"

/**
 * A simple [Fragment] subclass.
 * Use the [EditFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditFragment : Fragment() {

    private var _id: Int? = null
    private var _binding: FragmentSecondBinding? = null
    private var _db: LocationDatabaseHelper? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var location : Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            _id = it.getInt(ARG_ID)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _db = LocationDatabaseHelper(activity, "locationdb", 1, null)
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        location = _db!!.getLocation(_id!!)

        _binding!!.addressInput.setText(location!!.getAddress())
        _binding!!.latitudeViewAdd.setText(location!!.getLatitude().toString())
        _binding!!.longitudeViewAdd.setText(location!!.getLongitude().toString())

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
                _db!!.editLocation(_id!!, newloc)

                Toast.makeText(activity, "Changes Made Successfully!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_EditFragment_to_FirstFragment)
            } catch (e : Exception) {
                if (address == "") {
                    Toast.makeText(activity, "You need to provide an address first.", Toast.LENGTH_LONG).show()
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
                Toast.makeText(activity, "Hmm.... Looks like something went wrong.", Toast.LENGTH_LONG).show()
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}