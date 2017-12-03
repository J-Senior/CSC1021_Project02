import java.util.ArrayList;
import java.util.List;

public class Hotel {											//Class of type Hotel
	
	private String hotelName = "Empty";							//Field containing the name of the hotel
	private List<Room> roomDetails = new ArrayList<Room>();		//Field containing room details in the form of a list containing room objects
	private boolean hasVacancies = true;
	
	
	public Hotel(String hotelName, List<Room> roomDetails) {	//Constructor used when making Hotel objects
		this.hotelName = hotelName;
		this.roomDetails = roomDetails;
	}
	
	public String getHotelName() {								//Method used to access the hotel name
		return hotelName;
	}
	
	public void setHotelName(String hotelName) {				//Method used to set the hotel name
		this.hotelName = hotelName;
	}

	public List<Room> getRoomDetails() {						//Method used to access the room details
		return roomDetails;
	}

	public void setRoomDetails(List<Room> roomDetails) {		//Method used to set the room details
		this.roomDetails = roomDetails;
	}
	
	public int getHotelTotalRooms() {							//Method used to access the total number of rooms in the hotel
		return roomDetails.size();
	}

	public boolean isHasVacancies() {							//Method used to access the vacancy state
		return hasVacancies;
	}

	public void setHasVacancies(boolean hasVacancies) {			//Method used to determine whether the hotel has vacant rooms
		
		this.hasVacancies = hasVacancies;
	}
}

