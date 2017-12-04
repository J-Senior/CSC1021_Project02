import java.util.ArrayList;
import java.util.List;

public class Hotel {                                            // Class of type Hotel

    private String hotelName = "Empty";                         // Field containing the name of the hotel
    private List<Room> roomDetails = new ArrayList<Room>();     // Field containing room details in the form of a list containing room objects
    private boolean hasVacancies = true;
    
    public Hotel(String hotelName, List<Room> roomDetails) {    // Constructor used when making Hotel objects
        this.hotelName = hotelName;
        this.roomDetails = roomDetails;
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
        List<Room> hotelTotalRooms = getRoomDetails();          // List used to hold the current hotel's room details
        List<Bed> hotelTotalBeds = new ArrayList<Bed>();        // List used to hold the current hotel's bed details
        int occupancy = 0;

        for (int i = 0; i < hotelTotalRooms.size(); i++) {            // Loops through for the total number of rooms
            Room currentRoom = hotelTotalRooms.get(i);                // Holds current room's details in a Room object
            for (int j = 0; j < currentRoom.getBedCount(); j++) {     // Loops through for the total number of beds in the
                                                                      // current room
                hotelTotalBeds.add(currentRoom.getBedTypes().get(j)); // Adds the current rooms beds to the list of
                                                                      // total beds
            }
        }

        for (int k = 0; k < hotelTotalBeds.size(); k++) {
            Bed currentBed = hotelTotalBeds.get(k);
            String currentBedSize = currentBed.getBedType();

            if (currentBedSize.equals("Single")) {
                occupancy += 1;
            } else {
                occupancy += 2;
            }
        }

        return occupancy;
    }

    
    public boolean isHasVacancies() {
        return hasVacancies;
    }
    

    public void setHasVacancies(boolean hasVacancies) {
        this.hasVacancies = hasVacancies;
    }
}
