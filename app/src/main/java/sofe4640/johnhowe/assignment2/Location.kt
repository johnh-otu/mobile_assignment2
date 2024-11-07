package sofe4640.johnhowe.assignment2


class Location (val id : Int, private val address : String, private val latitude : Double, private val longitude : Double) {

    constructor(address : String, latitude : Double, longitude: Double) : this(-1, address, latitude, longitude)

    fun getID() : Int { return id; }
    fun getAddress() : String { return address; }
    fun getLatitude() : Double { return latitude; }
    fun getLongitude() : Double { return longitude; }

}