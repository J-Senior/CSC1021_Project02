
public class HotelReport {

    private Hotel currentHotel;

    public HotelReport(Hotel currentHotel) {
        this.currentHotel = currentHotel;
    }

    public void displayHotel() {
        printHeader();
        printName();
        printRoomDetails();
        printTotalOccupancy();
    }
    
    public void printHeader() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("\t\tHotel Report");
        System.out.println("--------------------------------------------------\n");
    }

    public void printName() {
        System.out.println("Hotel Name: " + currentHotel.getHotelName());
    }

    public void printRoomDetails() {
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

    public void printTotalOccupancy() {
        System.out.println("\nTotal Guest Capacity: " + currentHotel.getTotalOccupancy());
    }
}
