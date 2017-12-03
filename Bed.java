
public class Bed {									//Class of type bed
	
	private String bedType = "Empty";				//Field containing the type of bed as a string

	public Bed(String bedType) {					//Constructor used when making bed objects
		this.bedType = bedType;
	}
	
	public String getBedType() {					//Method used to access the current bed type
		return bedType;
	}

	public void setBedType(String bedType) {		//Method used to set the current bed type
		this.bedType = bedType;
	}
}
