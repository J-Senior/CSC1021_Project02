/* Filename:        Hotel.java
 * Date:            2017-12-12
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * Hotel is a class used to hold information about a 
 * hotel such as a name, list of rooms, the hotel's max
 * occupancy, and the hotel's vacancy status.
 * -------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.List;

public class Hotel {                                            // Class of type Hotel

    private String hotelName = "Empty";                         // Field containing the name of the hotel
    private List<Room> roomDetails = new ArrayList<Room>();     // Field containing room details in the form of a list containing room objects
    private boolean hasVacancies = true;                        // Field used to hold the hotel vacancy status
    
    public Hotel(String hotelName, List<Room> roomDetails, boolean hasVacancies) {    // Constructor used when making Hotel objects
        this.hotelName = hotelName;
        this.roomDetails = roomDetails;
        this.hasVacancies = hasVacancies;
    }

    public String getHotelName() {                              // Method used to access the hotel name
        return hotelName;
    }

    public void setHotelName(String hotelName) {                // Method used to set the hotel name
        this.hotelName = hotelName;
    }

    public List<Room> getRoomDetails() {                        // Method used to access the room details
        return roomDetails;
    }

    public void setRoomDetails(List<Room> roomDetails) {        // Method used to set the room details
        this.roomDetails = roomDetails;
    }

    public int getHotelTotalRooms() {                           // Method used to access the total number of rooms in the hotel
        return roomDetails.size();
    }

    public int getTotalOccupancy() {                            // Method used to set and access the max number of guests in the hotel
        int occupancy = 0;

        for (Room currentRoom : getRoomDetails()) {                 // Loops through for the total number of rooms and sets
                                                                    // currentRoom with the room details
            for ( Bed currentBed : currentRoom.getBedTypes()) {     // Loops through for the total number of beds in the
                                                                    // current room and sets currentBed with the bed size
                if (currentBed.getBedType().equals("Single")) {     // If the string in currentBed is "Single"
                    occupancy += 1;
                } else {
                    occupancy += 2;
                }
            }
        }

        return occupancy;
    }

    public boolean isHasVacancies() {                           // Method used to access the hotel occupancy status
        return hasVacancies;
    }
    
    public void setHasVacancies(boolean hasVacancies) {	        // Method used to set the hotel vacancy status
        this.hasVacancies = hasVacancies;
    }
}
