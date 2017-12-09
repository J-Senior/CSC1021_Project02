
public class HotelReport {

    private Hotel currentHotel;

    public HotelReport(Hotel currentHotel) {        // Constructor used when making HotelReport objects
        this.currentHotel = currentHotel;
    }

    public void displayHotel() {                    // Method used to display the current hotel details
        printHeader();
        printName();
        printRoomDetails();
        printTotalOccupancy();
        printHotelVacancy();
    }
    
    public void printHeader() {                     // Method used to print a header for aesthetics
        System.out.println("\n--------------------------------------------------");
        System.out.println("\t\tHotel Report");
        System.out.println("--------------------------------------------------\n");
    }

    public void printName() {                       // Method used to print the hotel name
        System.out.println("Hotel Name: " + currentHotel.getHotelName());
    }

    public void printRoomDetails() {                // Method used o print the hotel's room details
        System.out.println("\nTotal Rooms in Hotel: " + currentHotel.getHotelTotalRooms());
        for (int i = 0; i < currentHotel.getHotelTotalRooms(); i++) {
            Room currentRoom = currentHotel.getRoomDetails().get(i);
            String a = "beds";
            
            
            if(currentRoom.getBedCount() == 1) {
                a = "bed";
            }
            System.out.println("\nRoom " + (i + 1) + " contains " + currentRoom.getBedCount() + " " + a + ": ");
            for (int j = 0; j < currentRoom.getBedCount(); j++) {
                Bed bedType = currentRoom.getBedTypes().get(j);
                System.out.println("\tBed " + (j + 1) + ": " + bedType.getBedType());
            }
            if(currentRoom.isRoomOccupancy()) {
                System.out.println("\tCurrently occupied");
            } else {
                System.out.println("\tCurrently vacant");
            }
        }
    }

    public void printTotalOccupancy() {	            // Method used to display the total capacity of the hotel
        System.out.println("\nTotal Guest Capacity: " + currentHotel.getTotalOccupancy());
    }
    
    public void printHotelVacancy() {               // Method used to state whether or not there is an empty room
        if(currentHotel.isHasVacancies()) {
            System.out.println("This Hotel has a Vacant Room.");
        } else {
            System.out.println("This Hotel has no Vacant Rooms.");
        }
    }
    
}
