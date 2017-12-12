/* Filename:        HotelTest.java
 * Date:            2017-12-12
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * HotelTest is a class used to randomly generate
 * information about a hotel. It requires the Hotel,
 * Room, Bed, and HotelReport classes to function.
 * -------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HotelTest {                                    // Class of type HotelTest

    public static void main(String[] args) {

        HotelTest h = new HotelTest();

        String name = h.setName();                                      // Sets the name of the hotel
        List<Room> hotelRooms = h.setRooms();                           // Sets the room details of the hotel
        boolean vacancies = h.setVacancy(hotelRooms);
        Hotel currentHotel = new Hotel(name, hotelRooms, vacancies);    // Constructs a new Hotel object containing the data from the
                                                                        // HotelTest object

        h.displayInfo(currentHotel);                                    // Displays the data of the current hotel
    }

    public String setName() {                               // Sets the name of the hotel
        String name = "Hotel California";
        return name;
    }

    public List<Room> setRooms() {                          // Sets the room details of the hotel
        List<Room> hotelRooms = new ArrayList<Room>();
        int totalRooms = ThreadLocalRandom.current().nextInt(1, 6);                 // Randomises number of rooms less then 6

        for (int i = 0; i < totalRooms; i++) {
            boolean roomOccupancy = true;
            int occupancyRandomiser = ThreadLocalRandom.current().nextInt(0, 2);    // Randomises room occupancy
            HotelTest h = new HotelTest();
            List<Bed> bedType = h.setBedType(i + 1);
            int totalBeds = bedType.size();

            if(occupancyRandomiser == 1) {
                roomOccupancy = false;
            }

            Room hotelRoom = new Room(bedType, totalBeds, roomOccupancy);
            hotelRooms.add(hotelRoom);
        }

        return hotelRooms;
    }

    public List<Bed> setBedType(int roomNumber) {           // Sets the bed types within a room
        List<Bed> bedType = new ArrayList<Bed>();
        int totalBeds = ThreadLocalRandom.current().nextInt(1, 5);                  // Randomises the number of beds in a room
        int singleBeds = ThreadLocalRandom.current().nextInt(0, (totalBeds + 1));   // Randomises the number of single beds in a room
        int doubleBeds = totalBeds - singleBeds;

        for (int i = 0; i < singleBeds; i++) {
            Bed addSingleBed = new Bed("Single");
            bedType.add(addSingleBed);
        }

        if (doubleBeds > 0) {
            for (int i = 0; i < doubleBeds; i++) {
                Bed addDoubleBed = new Bed("Double");
                bedType.add(addDoubleBed);
            }
        }
        return bedType;
    }
    
    public boolean setVacancy(List<Room> hotelRooms) {      // Calculates the hotel occupancy
        boolean hotelVacancy = false;
        int counter = 0;
        
        for(int i=0; i < hotelRooms.size(); i++) {
            if(!hotelRooms.get(i).isRoomOccupancy()) {
                counter++;
            }
        }
        if(counter > 0) {
            hotelVacancy = true;
        }
        return hotelVacancy;
    }

    public void displayInfo(Hotel currentHotel) {           // Displays the details of the hotel
        HotelReport hr = new HotelReport(currentHotel);
        hr.displayHotel();
    }
}
