import java.util.ArrayList;
import java.util.List;

public class HotelTest {

    public static void main(String[] args) {

        HotelTest h = new HotelTest();

        String name = h.setName();
        List<Room> hotelRooms = h.setRooms();
        boolean vacancies = h.setVacancy(hotelRooms);
        Hotel currentHotel = new Hotel(name, hotelRooms, vacancies);

        h.displayInfo(currentHotel);
    }

    public String setName() {
        String name = "Test";
        return name;
    }

    public List<Room> setRooms() {
        List<Room> hotelRooms = new ArrayList<Room>();
        int totalRooms = 3;

        for (int i = 0; i < totalRooms; i++) {
            boolean roomOccupancy = true;
            String roomOccupancyInput = "Yes";
            HotelTest h = new HotelTest();
            List<Bed> bedType = h.setBedType(i + 1);
            int totalBeds = bedType.size();

            if(roomOccupancyInput.equals("No")) {
                roomOccupancy = false;
            }

            Room hotelRoom = new Room(bedType, totalBeds, roomOccupancy);
            hotelRooms.add(hotelRoom);
        }

        return hotelRooms;
    }

    public List<Bed> setBedType(int roomNumber) {
        List<Bed> bedType = new ArrayList<Bed>();
        int totalBeds = 3;
        int singleBeds = 1;
        int doubleBeds = totalBeds - singleBeds;

        for (int i = 0; i < singleBeds; i++) {
            Bed addSingleBed = new Bed("Single");
            bedType.add(addSingleBed);
        }

        if (doubleBeds > 0) {
            for (int i = 0; i < doubleBeds; i++) {
                Bed addDoubleBed = new Bed("Double");
                bedType.add(addDoubleBed);
            }
        }
        return bedType;
    }
    
    public boolean setVacancy(List<Room> hotelRooms) {
        boolean hotelVacancy = false;
        int counter = 0;
        
        for(int i=0; i < hotelRooms.size(); i++) {
            if(!hotelRooms.get(i).isRoomOccupancy()) {
                counter++;
            }
        }
        if(counter > 0) {
            hotelVacancy = true;
        }
        return hotelVacancy;
    }

    public void displayInfo(Hotel currentHotel) {
        HotelReport hr = new HotelReport(currentHotel);
        hr.displayHotel();
    }
}
