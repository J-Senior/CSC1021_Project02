import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("resource")

public class HotelConfigure {							//Class used to allow user input values of a hotel object

	public static void main(String[] args) {
		
		HotelConfigure h = new HotelConfigure();			//Constructs a new HotelConfigure object to be used when receiving user input values
		
		String name = h.setName();							//Sets the name of the HotelConfigure object
		List<Room> hotelRooms = h.setRooms();				//Sets the room details of the HotelConfigure object
		Hotel currentHotel = new Hotel(name, hotelRooms);	//Constructs a new Hotel object containing the data from the ConfigureHotel object
		
		h.displayInfo(currentHotel);						//Displays the data within the currentHotel object
	}
	
	public String setName() {
		Scanner s = new Scanner(System.in);
		String name = "Empty";
		
		System.out.print("Please enter the hotel name: ");
		name = s.next();
		
		return name;
	}
	
	public List<Room> setRooms(){
		List<Room> hotelRooms = new ArrayList<Room>();
		int totalRooms = 0;
		Scanner s = new Scanner(System.in);
		
		System.out.print("Please enter the number of rooms in the hotel: ");
		totalRooms = s.nextInt();
		
		for(int i=0; i < totalRooms; i++) {
			HotelConfigure h = new HotelConfigure();
			List<Bed> bedType = h.setBedType(i+1);
			int totalBeds = bedType.size();
			
			Room hotelRoom = new Room(bedType, totalBeds);
			hotelRooms.add(hotelRoom);
		}
		
		return hotelRooms;
	}
	
	public List<Bed> setBedType(int roomNumber) {		//Method used to receive the types of beds in a room from the user
		List<Bed> bedType = new ArrayList<Bed>();
		int totalBeds = 0;
		int singleBeds = 0;
		Scanner s = new Scanner(System.in);
		
		System.out.print("\nPlease enter the number beds in room " + roomNumber + ": ");
		totalBeds = s.nextInt();
		
		System.out.print("Please enter the number single beds in the room: ");
		singleBeds = s.nextInt();
		
		int doubleBeds = totalBeds - singleBeds;
		
		for(int i=0; i < singleBeds; i++) {
			Bed addSingleBed = new Bed("Single");
			bedType.add(addSingleBed);
		}
		
		if(doubleBeds > 0) {
			for(int i=0; i < doubleBeds; i++) {
				Bed addDoubleBed = new Bed("Double");
				bedType.add(addDoubleBed);
			}
		}
		return bedType;
	}
	
	public int maxOccupancy() {
		int maxOccupancy = 0;
		
		
		return maxOccupancy;
	}
	
	public void displayInfo(Hotel currentHotel) {
		HotelReport hr = new HotelReport(currentHotel);
		hr.displayHotel();
	}
}
