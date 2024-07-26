import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    String parkingLotId;
    //List of slots available in each floor
    List<List<Slot>> slots;

    public ParkingLot(String parkingLotId, int nfloors, int noOfSlotsPerFloor){
        this.parkingLotId = parkingLotId;
        
        //creating slots
        slots = new ArrayList<>();
        //loop for adding first three slots in each floor
        for(int i = 0; i<nfloors; i++){
            //adding a new arraylist representing slots in each floor to slots arraylist
            slots.add(new ArrayList<>());
            //getting the newly created slots arraylist to add slots
            List<Slot> floorSlots = slots.get(i);
            floorSlots.add(new Slot("truck"));
            floorSlots.add(new Slot("bike"));
            floorSlots.add(new Slot("bike"));

            //loop for assigning the rest of the slots with car type
            //starting from 3 since first three slots already taken 
            for(int j = 3; j<noOfSlotsPerFloor; j++){
                //getting slot list for each floor and adding car slots for all the slots left
                slots.get(i).add(new Slot("car"));
            }
        }
    }

    //method that performs the parking operation
    public String parkVehicle(String type, String registration, String color){
        //creating a new instance of a vehicle
        Vehicle vehicle = new Vehicle(type, registration, color);

        //iterating for each floor to check for empty slots
        for (int i = 0; i<slots.size(); i++){
            //for each slot in a floor for empty slots
            for(int j = 0; i<slots.get(i).size(); j++){
                //creating a slot object to check space on the slot position
                Slot slot = slots.get(i).get(j);
                //if the type matches and the slot is empty, the slot is assigned
                if(slot.getType() == type && slot.getVehicle() == null){
                    //setting the vehicle and ticket Id
                    slot.setVehicle(vehicle);
                    slot.setTicketId(generateTicketId(i+1, j+1));
                    return slot.getTicketId();
                }
            }
        }
        //when the if conditions above is not met for any floors
        System.out.println("Sorry! No Parking Slots Available.");
        return null;   
    } 

    private String generateTicketId(int floor, int slotNo){
        return parkingLotId + "_" + floor + "_" + slotNo;
    }

    public void unPark(String ticketId){
        
    }

}
