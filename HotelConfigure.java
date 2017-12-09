import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("resource")

public class HotelConfigure {                               // Class used to allow user input values of a hotel object
    
    private int attempt = 0;
    private int maxAttempts = 3;

    public static void main(String[] args) {

        HotelConfigure h = new HotelConfigure();                        // Constructs a new HotelConfigure object to be used when receiving
                                                                        // user input values

        String name = h.setName();                                      // Sets the name of the HotelConfigure object
        List<Room> hotelRooms = h.setRooms();                           // Sets the room details of the HotelConfigure object
        boolean vacancies = h.setVacancy(hotelRooms);
        Hotel currentHotel = new Hotel(name, hotelRooms, vacancies);    // Constructs a new Hotel object containing the data from the
                                                                        // ConfigureHotel object

        h.displayInfo(currentHotel);                                    // Displays the data within the currentHotel object
    }

    public String setName() {                               // Method used to receive the hotel name from the user
        Scanner s = new Scanner(System.in);
        String name = "Empty";

        System.out.print("Please enter the hotel name: ");
        name = s.nextLine();

        return name;
    }

    public List<Room> setRooms() {                          // Method used to receive the room details from the user
        List<Room> hotelRooms = new ArrayList<Room>();      // Declare a list of rooms to hold the user's input
        int totalRooms = 0;
        Scanner s = new Scanner(System.in);

        System.out.print("Please enter the number of rooms in the hotel: ");
        while( true ) {
            try {
                totalRooms = s.nextInt();
                if(totalRooms > 0) {
                    break;
                } if( attempt < maxAttempts ) {
                    if ( attempt == (maxAttempts - 1) ) {
                        throw new IllegalArgumentException("The user has entered too many incorrect inputs");
                    }
                    attempt++;
                    System.out.print("Please enter an integer greater than 0: ");
                }
            } catch (Exception a) {
                if ( attempt == (maxAttempts - 1) ) {
                    throw new IllegalArgumentException("The user has entered too many incorrect inputs");
                }
                attempt++;
                System.out.print("Please enter an integer greater than 0: ");
                s.next();
            }
        }
        attempt = 0;

        for ( int i = 0; i < totalRooms; i++ ) {              // A loop to allow the user to input the details of each room
            boolean roomOccupancy = true;
            String roomOccupancyInput = "Yes";
            HotelConfigure h = new HotelConfigure();        // Construct a HotelConfigure object to allow use of the setBedType method
            List<Bed> bedType = h.setBedType(i + 1);        // Declare a list of beds and fill it using the setBedType method
            int totalBeds = bedType.size();                 // Set the number of beds in the room using the bed list
            
            
            System.out.print("Is this room occupied? Please enter (Yes/No): ");
            roomOccupancyInput = s.nextLine();
            while( true ) {
                try {
                    roomOccupancyInput = s.nextLine();
                    if( roomOccupancyInput.equals("No") || roomOccupancyInput.equals("Yes") ) {
                        break;
                    } if( attempt < maxAttempts ) {
                        if ( attempt == (maxAttempts - 1) ) {
                            throw new IllegalArgumentException("The user has entered too many incorrect inputs");
                        }
                        attempt++;
                        System.out.print("Please enter either Yes or No: ");
                    }
                } catch (Exception a) {
                    if ( attempt == (maxAttempts - 1) ) {
                        throw new IllegalArgumentException("The user has entered too many incorrect inputs");
                    }
                    attempt++;
                    System.out.print("Please enter either Yes or No: ");
                    roomOccupancyInput = s.nextLine();
                }
            }
            attempt = 0;
            
            if( roomOccupancyInput.equals("No") ) {           // If the current room was stated to be empty
                roomOccupancy = false;                      // Set the status as false
            }

            Room currentRoom = new Room(bedType, totalBeds, roomOccupancy);   // Construct a room object with the inputed values
            hotelRooms.add(currentRoom);                                      // Add the room to the list of rooms
        }

        return hotelRooms;
    }

    public List<Bed> setBedType(int roomNumber) {           // Method used to receive the types of beds in a room from the user
        List<Bed> bedType = new ArrayList<Bed>();           // Declare a list of beds to be filled by the user
        int totalBeds = 0;
        int singleBeds = 0;
        Scanner s = new Scanner(System.in);

        System.out.print("\nPlease enter the number beds in room " + roomNumber + ": ");
        while( true ) {
            try {
                totalBeds = s.nextInt();
                if( totalBeds > 0 ) {
                    break;
                } if( attempt < maxAttempts ) {
                    if ( attempt == (maxAttempts - 1) ) {
                        throw new IllegalArgumentException("The user has entered too many incorrect inputs");
                    }
                    attempt++;
                    System.out.print("Please enter an integer greater than 0: ");
                }
            } catch (Exception a) {
                if ( attempt == (maxAttempts - 1) ) {
                    throw new IllegalArgumentException("The user has entered too many incorrect inputs");
                }
                attempt++;
                System.out.print("Please enter an integer greater than 0: ");
                s.next();
            }
        }
        attempt = 0;

        System.out.print("Please enter the number single beds in the room: ");
        while( true ) {
            try {
                singleBeds = s.nextInt();
                if((singleBeds >= 0) && (singleBeds <= totalBeds)) {
                    break;
                } if( attempt < maxAttempts ) {
                    if ( attempt == (maxAttempts - 1) ) {
                        throw new IllegalArgumentException("The user has entered too many incorrect inputs");
                    }
                    attempt++;
                    if( singleBeds < 0 ) {
                        System.out.print("Please enter an integer greater than or equal to 0: ");
                    }
                    if( singleBeds > totalBeds ) {
                        System.out.print("Please enter an integer less than or equal to " + totalBeds + ": ");
                    }
                    
                }
            } catch (Exception a) {
                if (attempt == (maxAttempts - 1)) {
                    throw new IllegalArgumentException("The user has entered too many incorrect inputs");
                }
                attempt++;
                System.out.print("Please enter an integer: ");
                s.next();
            }
        }
        attempt = 0;

        int doubleBeds = totalBeds - singleBeds;

        for (int i = 0; i < singleBeds; i++) {
            Bed addSingleBed = new Bed("Single");           // Construct a Bed object to add to the bedType list
            bedType.add(addSingleBed);                      // Adds a single bed to the bedType list
        }

        if (doubleBeds > 0) {
            for (int j = 0; j < doubleBeds; j++) {
                Bed addDoubleBed = new Bed("Double");       // Construct a bed object to add to the bedType list
                bedType.add(addDoubleBed);                  // Adds a double bed to the bedType list
            }
        }
        return bedType;
    }
    
    public boolean setVacancy(List<Room> hotelRooms) {      // Method used to determine the hotel vacancy status
        boolean hotelVacancy = false;
        int counter = 0;
        
        for(int i=0; i < hotelRooms.size(); i++) {          // Loops through for the number of rooms in the hotel
            if(!hotelRooms.get(i).isRoomOccupancy()) {      // If the current room is not occupied
                counter++;
            }
        }
        if(counter > 0) {
            hotelVacancy = true;
        }
        return hotelVacancy;
    }

    public void displayInfo(Hotel currentHotel) {           // Method used to display the hotel information
        HotelReport hr = new HotelReport(currentHotel);     // Construct a HotelReport object to allow use of the displayHotel method
        hr.displayHotel();
    }
}
