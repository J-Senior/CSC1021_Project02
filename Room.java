import java.util.ArrayList;
import java.util.List;

public class Room {											//Class of type Room
	
	private List<Bed> bedTypes = new ArrayList<Bed>();		//Field containing bed details in the form of a list containing bed objects
	private int bedCount = 0;								//Field containing the number of beds in a room
	private int roomSize = 0;								//Field containing the number of guests who can stay in a room
	
	public Room(List<Bed> bedTypes, int bedCount) {			//Constructor used when making room objects
		this.bedTypes = bedTypes;
		this.bedCount = bedCount;
	}
	
	public List<Bed> getBedTypes() {						//Method used to access the types of beds in a room
		return bedTypes;
	}
	
	public void setBedTypes(List<Bed> roomBeds) {			//Method used to set the types of beds in a room
		this.bedTypes = roomBeds;
	}
	
	public int getBedCount() {								//Method used to access the number of beds in a room
		return bedCount;
	}
	
	public void setBedCount(int bedCount) {					//Method used to set the number of beds in a room
		this.bedCount = bedCount;
	}

	
	public int getRoomSize() {								//Method used to access the number of guests who can stay in a room
		return roomSize;
	}

	public void setRoomSize(int roomSize) {					//Method used to set the number of guests who can stay in a room
		
		this.roomSize = roomSize;
	}
}
