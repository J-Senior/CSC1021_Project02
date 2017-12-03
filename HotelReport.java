
public class HotelReport {

    private Hotel currentHotel;

    public HotelReport(Hotel currentHotel) {
        this.currentHotel = currentHotel;
    }

    public void displayHotel() {
        printName();
        printRoomDetails();
        printTotalOccupancy();
    }

    public void printName() {
        System.out.println("\n--------------------------------------------------\n");
        System.out.println("Name: " + currentHotel.getHotelName());
    }

    public void printRoomDetails() {
        System.out.println("\nTotal rooms: " + currentHotel.getHotelTotalRooms());
        for (int i = 0; i < currentHotel.getHotelTotalRooms(); i++) {
            Room currentRoom = currentHotel.getRoomDetails().get(i);
            System.out.println("\nRoom " + (i + 1) + " contains " + currentRoom.getBedCount() + " beds: ");

            for (int j = 0; j < currentRoom.getBedCount(); j++) {
                Bed bedType = currentRoom.getBedTypes().get(j);
                System.out.println("Bed " + (j + 1) + ": " + bedType.getBedType());
            }
        }
    }

    public void printTotalOccupancy() {
        System.out.println("\nTotal guest capacity: " + currentHotel.getTotalOccupancy());
    }
}
