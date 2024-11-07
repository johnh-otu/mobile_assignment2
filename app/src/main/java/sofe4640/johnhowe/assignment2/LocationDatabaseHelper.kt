package sofe4640.johnhowe.assignment2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi


class LocationDatabaseHelper(
    context: Context?,
    name: String?,
    version: Int,
    factory: SQLiteDatabase.CursorFactory?
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        //create locations table
        db?.execSQL("CREATE TABLE IF NOT EXISTS " +
                "Locations (ID INTEGER PRIMARY KEY AUTOINCREMENT, ADDRESS TEXT, LATITUDE REAL, LONGITUDE REAL)")
        db?.close()


        val ls : MutableList<Location> = mutableListOf()

        //toronto locations
        ls.add(Location("CN Tower, 301 Front St W, Toronto, ON M5V 2T6", 43.6426, -79.3871))
        ls.add(Location("Royal Ontario Museum, 100 Queens Park, Toronto, ON M5S 2C6", 43.6677, -79.3948))
        ls.add(Location("Toronto Zoo, 2000 Meadowvale Rd, Toronto, ON M1B 5K7", 43.8177, -79.1859))
        ls.add(Location("High Park, 1873 Bloor St W, Toronto, ON M6R 2Z3", 43.6465, -79.4637))
        ls.add(Location("Ripley's Aquarium of Canada, 288 Bremner Blvd, Toronto, ON M5V 3L9", 43.6424, -79.3860))
        ls.add(Location("Casa Loma, 1 Austin Terrace, Toronto, ON M5R 1X8", 43.6780, -79.4094))
        ls.add(Location("Art Gallery of Ontario, 317 Dundas St W, Toronto, ON M5T 1G4", 43.6536, -79.3925))
        ls.add(Location("Toronto Islands, Toronto, ON M5J 2E9", 43.6205, -79.3783))
        ls.add(Location("Distillery District, 55 Mill St, Toronto, ON M5A 3C4", 43.6503, -79.3596))
        ls.add(Location("St. Lawrence Market, 93 Front St E, Toronto, ON M5E 1C3", 43.6487, -79.3716))
        ls.add(Location("Ontario Science Centre, 770 Don Mills Rd, Toronto, ON M3C 1T3", 43.7167, -79.3385))
        ls.add(Location("Toronto Eaton Centre, 220 Yonge St, Toronto, ON M5B 2H1", 43.6544, -79.3807))
        ls.add(Location("Nathan Phillips Square, 100 Queen St W, Toronto, ON M5H 2N1", 43.6525, -79.3839))
        ls.add(Location("Humber Bay Park, 100 Humber Bay Park Rd W, Toronto, ON M8V 3X7", 43.6204, -79.4781))
        ls.add(Location("Scarborough Bluffs, 1 Brimley Rd S, Toronto, ON M1M 1T9", 43.7054, -79.2354))
        ls.add(Location("Toronto Botanical Garden, 777 Lawrence Ave E, North York, ON M3C 1P2", 43.7340, -79.3590))
        ls.add(Location("Edwards Gardens, 755 Lawrence Ave E, North York, ON M3C 1P2", 43.7340, -79.3590))
        ls.add(Location("Kensington Market, Toronto, ON M5T 2L9", 43.6543, -79.4000))
        ls.add(Location("Chinatown, Toronto, ON M5T 1H1", 43.6532, -79.3984))
        ls.add(Location("Yonge-Dundas Square, 1 Dundas St E, Toronto, ON M5B 2R8", 43.6561, -79.3802))
        ls.add(Location("Toronto Music Garden, 479 Queens Quay W, Toronto, ON M5V 2Y3", 43.6366, -79.3966))
        ls.add(Location("Toronto City Hall, 100 Queen St W, Toronto, ON M5H 2N1", 43.6532, -79.3832))
        ls.add(Location("Bata Shoe Museum, 327 Bloor St W, Toronto, ON M5S 1W7", 43.6675, -79.4003))
        ls.add(Location("Fort York National Historic Site, 250 Fort York Blvd, Toronto, ON M5V 3K9", 43.6393, -79.4064))
        ls.add(Location("Toronto Waterfront, Toronto, ON M5J 2G8", 43.6408, -79.3802))
        ls.add(Location("Toronto Public Library, 789 Yonge St, Toronto, ON M4W 2G8", 43.6712, -79.3860))
        ls.add(Location("Toronto Old City Hall, 60 Queen St W, Toronto, ON M5H 2M3", 43.6525, -79.3817))
        ls.add(Location("Toronto Harbourfront, 235 Queens Quay W, Toronto, ON M5J 2G8", 43.6383, -79.3807))
        ls.add(Location("Toronto Railway Museum, 255 Bremner Blvd, Toronto, ON M5V 3M9", 43.6413, -79.3853))
        ls.add(Location("Toronto Sculpture Garden, 115 King St E, Toronto, ON M5C 1G6", 43.6505, -79.3733))
        ls.add(Location("Toronto Police Museum, 40 College St, Toronto, ON M5G 2J3", 43.6600, -79.3846))
        ls.add(Location("Toronto Islands Ferry Terminal, 9 Queens Quay W, Toronto, ON M5J 2H3", 43.6405, -79.3762))
        ls.add(Location("Toronto Dominion Centre, 66 Wellington St W, Toronto, ON M5K 1A1", 43.6473, -79.3806))
        ls.add(Location("Toronto Financial District, Toronto, ON M5H 2N2", 43.6486, -79.3815))
        ls.add(Location("Toronto Entertainment District, Toronto, ON M5V 1J3", 43.6465, -79.3921))
        ls.add(Location("Toronto Fashion District, Toronto, ON M5V 1K4", 43.6440, -79.4010))
        ls.add(Location("Toronto Discovery District, Toronto, ON M5G 1L7", 43.6596, -79.3895))
        ls.add(Location("Toronto Beaches, Toronto, ON M4E 1C7", 43.6687, -79.2965))
        ls.add(Location("Toronto Islands Park, Toronto, ON M5J 2E9", 43.6205, -79.3783))
        ls.add(Location("Toronto Waterfront Trail, Toronto, ON M5J 2G8", 43.6408, -79.3802))
        ls.add(Location("Aga Khan Museum, 77 Wynford Dr, North York, ON M3C 1K1", 43.7258, -79.3387))
        ls.add(Location("Black Creek Pioneer Village, 1000 Murray Ross Pkwy, North York, ON M3J 2P3", 43.7735, -79.5071))
        ls.add(Location("Ontario Place, 955 Lake Shore Blvd W, Toronto, ON M6K 3B9", 43.6289, -79.4145))
        ls.add(Location("Woodbine Beach, 1675 Lake Shore Blvd E, Toronto, ON M4L 3W6", 43.6629, -79.3117))
        ls.add(Location("Evergreen Brick Works, 550 Bayview Ave, Toronto, ON M4W 3X8", 43.6845, -79.3654))
        ls.add(Location("Guild Park and Gardens, 201 Guildwood Pkwy, Scarborough, ON M1E 1P5", 43.7433, -79.1962))
        ls.add(Location("Rouge National Urban Park, 1749 Meadowvale Rd, Toronto, ON M1B 5W8", 43.8054, -79.1740))

        //cities and towns
        ls.add(Location("Ajax, ON", 43.8509, -79.0204))
        ls.add(Location("Aurora, ON", 44.0065, -79.4504))
        ls.add(Location("Brampton, ON", 43.7315, -79.7624))
        ls.add(Location("Brock, ON", 44.2810, -79.1997))
        ls.add(Location("Burlington, ON", 43.3255, -79.7990))
        ls.add(Location("Caledon, ON", 43.8420, -79.8745))
        ls.add(Location("Clarington, ON", 43.9350, -78.6080))
        ls.add(Location("East Gwillimbury, ON", 44.1000, -79.4167))
        ls.add(Location("Georgina, ON", 44.3001, -79.4333))
        ls.add(Location("Halton Hills, ON", 43.6300, -79.9500))
        ls.add(Location("King, ON", 43.9550, -79.6100))
        ls.add(Location("Markham, ON", 43.8561, -79.3370))
        ls.add(Location("Milton, ON", 43.5183, -79.8774))
        ls.add(Location("Mississauga, ON", 43.5890, -79.6441))
        ls.add(Location("Newmarket, ON", 44.0500, -79.4667))
        ls.add(Location("Oakville, ON", 43.4675, -79.6877))
        ls.add(Location("Oshawa, ON", 43.8971, -78.8658))
        ls.add(Location("Pickering, ON", 43.8353, -79.0890))
        ls.add(Location("Richmond Hill, ON", 43.8828, -79.4403))
        ls.add(Location("Whitby, ON", 43.8975, -78.9429))

        //universities and colleges
        ls.add(Location("University of Toronto, 27 King's College Cir, Toronto, ON M5S 1A1", 43.6629, -79.3957))
        ls.add(Location("York University, 4700 Keele St, Toronto, ON M3J 1P3", 43.7735, -79.5019))
        ls.add(Location("Toronto Metropolitan University, 350 Victoria St, Toronto, ON M5B 2K3", 43.6577, -79.3788))
        ls.add(Location("Humber College, 205 Humber College Blvd, Etobicoke, ON M9W 5L7", 43.7296, -79.6070))
        ls.add(Location("Seneca College, 1750 Finch Ave E, North York, ON M2J 2X5", 43.7955, -79.3496))
        ls.add(Location("George Brown College, 160 Kendal Ave, Toronto, ON M5R 1M3", 43.6761, -79.4105))
        ls.add(Location("OCAD University, 100 McCaul St, Toronto, ON M5T 1W1", 43.6536, -79.3925))
        ls.add(Location("Centennial College, 941 Progress Ave, Scarborough, ON M1G 3T8", 43.7854, -79.2269))
        ls.add(Location("University of Toronto Scarborough, 1265 Military Trail, Scarborough, ON M1C 1A4", 43.7845, -79.1869))
        ls.add(Location("University of Toronto Mississauga, 3359 Mississauga Rd, Mississauga, ON L5L 1C6", 43.5483, -79.6627))
        ls.add(Location("Sheridan College, 1430 Trafalgar Rd, Oakville, ON L6H 2L1", 43.4696, -79.7004))
        ls.add(Location("Tyndale University, 3377 Bayview Ave, North York, ON M2M 3S4", 43.7942, -79.3841))
        ls.add(Location("Victoria University, 73 Queen's Park Crescent E, Toronto, ON M5S 1K7", 43.6661, -79.3922))
        ls.add(Location("Massey College, 4 Devonshire Place, Toronto, ON M5S 2E1", 43.6646, -79.3972))
        ls.add(Location("Trent University Durham, 55 Thornton Rd S, Oshawa, ON L1J 5Y1", 43.8777, -78.8761))
        ls.add(Location("Durham College, 2000 Simcoe St N, Oshawa, ON L1G 0C5", 43.8985, -78.8641))
        ls.add(Location("The Michener Institute, 222 St Patrick St, Toronto, ON M5T 1V4", 43.6555, -79.3892))
        ls.add(Location("Royal Conservatory of Music, 273 Bloor St W, Toronto, ON M5S 1W2", 43.6677, -79.3984))
        ls.add(Location("Toronto School of Management, 22 College St, Toronto, ON M5G 1K2", 43.6610, -79.3856))
        ls.add(Location("Canadian Memorial Chiropractic College, 6100 Leslie St, North York, ON M2H 3J1", 43.7854, -79.3626))
        ls.add(Location("Ontario Tech University, 31 Avenue of Champions, Oshawa, ON L1G 0C5", 43.9445, -78.8963))
        ls.add(Location("St. Michael's College, 81 St Mary St, Toronto, ON M5S 1J4", 43.6629, -79.3899))
        ls.add(Location("University of Guelph-Humber, 207 Humber College Blvd, Etobicoke, ON M9W 5L7", 43.7296, -79.6070))
        ls.add(Location("Toronto Film School, 10 Dundas St E, Toronto, ON M5B 2G9", 43.6561, -79.3802))
        ls.add(Location("Evergreen College, 67 Yonge St #402, Toronto, ON M5E 1J8", 43.6487, -79.3766))

        //vaughan locations
        ls.add(Location("Canada's Wonderland, 1 Canada's Wonderland Drive, Vaughan, ON L6A 1S6", 43.8430, -79.5390))
        ls.add(Location("Vaughan Mills, 1 Bass Pro Mills Drive, Vaughan, ON L4K 5W4", 43.8256, -79.5367))
        ls.add(Location("LEGOLAND Discovery Centre, 1 Bass Pro Mills Drive, Vaughan, ON L4K 5W4", 43.8256, -79.5367))
        ls.add(Location("Kortright Centre for Conservation, 9550 Pine Valley Drive, Vaughan, ON L4L 1A6", 43.8372, -79.5950))
        ls.add(Location("McMichael Canadian Art Collection, 10365 Islington Avenue, Kleinburg, ON L0J 1C0", 43.8438, -79.6239))
        ls.add(Location("Boyd Conservation Area, 8739 Islington Avenue, Vaughan, ON L4L 1A6", 43.7943, -79.5871))

        //mississauga locations
        ls.add(Location("Square One Shopping Centre, 100 City Centre Drive, Mississauga, ON L5B 2C9", 43.5934, -79.6448))
        ls.add(Location("Port Credit, Mississauga, ON L5G 4N8", 43.5515, -79.5860))
        ls.add(Location("Rattray Marsh Conservation Area, 660 Bexhill Road, Mississauga, ON L5H 3L1", 43.5189, -79.6174))
        ls.add(Location("Living Arts Centre, 4141 Living Arts Drive, Mississauga, ON L5B 4B8", 43.5890, -79.6441))
        ls.add(Location("Jack Darling Memorial Park, 1180 Lakeshore Road West, Mississauga, ON L5H 1A1", 43.5281, -79.6154))
        ls.add(Location("Erindale Park, 1695 Dundas Street West, Mississauga, ON L5C 1E3", 43.5485, -79.6743))

        for (location in ls) {
            addLocation(location)
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun addLocation(location: Location) {
        val db = writableDatabase
        val values = ContentValues()
        values.put("ADDRESS", location.getAddress())
        values.put("LATITUDE", location.getLatitude())
        values.put("LONGITUDE", location.getLongitude())

        db.insert("Locations", null, values)
        db.close()
    }

    fun deleteNote(id: Int): Boolean {
        val db = writableDatabase
        val result = db.delete("Locations", "ID = $id", null)
        db.close()
        return result > 0
    }

    fun getAllLocations(): MutableList<Location> {
        val db = readableDatabase
        val locationList: MutableList<Location> = mutableListOf()
        val selectQuery = "SELECT * FROM Locations"

        val cursor = db.rawQuery(selectQuery, null)

        val iId = cursor!!.getColumnIndex("ID")
        val iAddress = cursor.getColumnIndex("ADDRESS")
        val iLatitude = cursor.getColumnIndex("LATITUDE")
        val iLongitude = cursor.getColumnIndex("LONGITUDE")

        if (cursor.moveToFirst()) {
            do {
                val loc = Location(
                    cursor.getInt(iId),
                    cursor.getString(iAddress),
                    cursor.getDouble(iLatitude),
                    cursor.getDouble(iLongitude)
                )
                locationList.add(loc)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return locationList
    }

    fun searchByAddress(address: String) : MutableList<Location> {
        val db = readableDatabase
        val query = "SELECT * FROM Locations WHERE Locations.ADDRESS LIKE '%$address%';"

        val results = db.rawQuery(query, null)

        val iId = results!!.getColumnIndex("ID")
        val iAddress = results.getColumnIndex("ADDRESS")
        val iLatitude = results.getColumnIndex("LATITUDE")
        val iLongitude = results.getColumnIndex("LONGITUDE")

        var currentId : Int
        var currentAddress : String
        var currentLatitude : Double
        var currentLongitude : Double

        val output = mutableListOf<Location>()

        while (results.moveToNext()) { //loop through each result
            currentId = results.getInt(iId)
            currentAddress = results.getString(iAddress)
            currentLatitude = results.getDouble(iLatitude)
            currentLongitude = results.getDouble(iLongitude)

            //add result to output list
            output.add(Location(currentId, currentAddress, currentLatitude, currentLongitude))
        }

        results.close()
        db.close()
        return output
    }

    fun getLocation(id : Int) : Location? {
        val db = readableDatabase
        val query = "SELECT * FROM Locations WHERE Locations.ID = '$id';"

        val results = db.rawQuery(query, null)

        val iId = results!!.getColumnIndex("ID")
        val iAddress = results.getColumnIndex("ADDRESS")
        val iLatitude = results.getColumnIndex("LATITUDE")
        val iLongitude = results.getColumnIndex("LONGITUDE")

        val currentId : Int
        val currentAddress : String
        val currentLatitude : Double
        val currentLongitude : Double

        var output: Location? = null

        if (results.moveToFirst()) {
            currentId = results.getInt(iId)
            currentAddress = results.getString(iAddress)
            currentLatitude = results.getDouble(iLatitude)
            currentLongitude = results.getDouble(iLongitude)

            output = Location(currentId, currentAddress, currentLatitude, currentLongitude)
        }

        results.close()
        db.close()
        return output
    }

    fun editLocation(id: Int, location: Location): Boolean {
        if (getLocation(id) == null) {
            return false
        }

        val db = writableDatabase

        val values = ContentValues()

        values.put("ADDRESS", location.getAddress())
        values.put("LATITUDE", location.getLatitude())
        values.put("LONGITUDE", location.getLongitude())

        db.update(
            "Locations",
            values,
            "ID = $id",
            null
        )

        db.close()
        return true
    }

}