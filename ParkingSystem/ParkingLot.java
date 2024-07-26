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

        boolean isParked = false;
        //iterating for each floor to check for empty slots
        for (int i = 0; i<slots.size(); i++){
            //for each slot in a floor for empty slots
            for(int j = 0; j<slots.get(i).size(); j++){
                //creating a slot object to check space on the slot position
                Slot slot = slots.get(i).get(j);
                //if the type matches and the slot is empty, the slot is assigned
                if(slot.getType() == type && slot.getVehicle() == null){
                    isParked = true;
                    //setting the vehicle and ticket Id
                    slot.setVehicle(vehicle);
                    slot.setTicketId(generateTicketId(i+1, j+1));
                    return slot.getTicketId();
                }
            }
        }
        
        if(!isParked){//when the if conditions above is not met for any floors
        System.out.println("Sorry! No Parking Slots Available.");
        }
        return null;   
    } 

    private String generateTicketId(int floor, int slotNo){
        return parkingLotId + "_" + floor + "_" + slotNo;
    }

    public void unPark(String ticketId){
        //in case the user provides with invalid/wrong ticket id
        try{
            //getting the slot and floor index from ticketId
            String [] extraction = ticketId.split("_");
            if (extraction.length<3){
                throw new IllegalArgumentException("Invalid ticket Id format.");
            }

            int flrIndex = Integer.parseInt(extraction[1])-1;
            int slotIndex = Integer.parseInt(extraction[2])-1;

            //iteration for finding the position of the slot where the vehicle with the provided ticket is parked
            for(int i = 0; i<slots.size(); i++){
                for (int j = 0; j<slots.get(i).size(); j++){
                    //if the slot position matches that according to the ticket
                    if (i == flrIndex && j == slotIndex){
                        //setting the position as available/ null
                        Slot slot = slots.get(i).get(j);
                        slot.setTicketId(null);
                        slot.setVehicle(null);
                        System.out.println("Vehicle successfully unparked!");
                    }
                }
            }
        }catch(NumberFormatException e) {
            // Handle cases where parsing the integer fails
            System.out.println("Error: Invalid number format in ticketId. ");
        } catch (IllegalArgumentException e) {
            // Handle cases where ticketId does not match expected format
            System.out.println("Error");
        } catch (Exception e) {
            // Handle any other unexpected exceptions
            System.out.println("Unexpected error: ");
        }

    }

    //to see the number of open slots for a vehicle type
    int getNoOfOpenSlots(String type){
        int count = 0;
        //iterating the outer list where each nested list represents a floor
        for(List<Slot> floors: slots){
            //iterating over each floors list items to find empty of the same type
            for(Slot slot: floors){
                if (slot.getVehicle() == null && slot.getType()== type){
                    count++;
                }
            }
        }
        return count;
    }

    //to display all open slots for a vehicle type
    void displayOpenSlots(String type){
        boolean foundSlots= false;
        //for each floors
        for(int i = 0; i<slots.size(); i++){
            //for each slots in each floor
            for (int j = 0; j<slots.get(i).size(); j++ ){
                Slot slot = slots.get(i).get(j);
                //for the slots that are empty of a type
                if (slot.getVehicle()==null && slot.getType()==type){
                    foundSlots = true;
                    System.out.println("Floor:" + (i+1) + "Slot:" + (j+1));
                }
            }
        }

        if(!foundSlots){
            System.out.println("No open slots");
        }
    }

    //displaying all the occupied slots for a vehicle type    
    void displayOccupiedSlots(String type){
        boolean foundSlots = false;
        for(int i = 0; i<slots.size(); i++){
            for(int j = 0; j<slots.get(i).size(); j++){
                Slot slot = slots.get(i).get(j);
                if(slot.getVehicle() != null && slot.getType()==type){
                    foundSlots = true;
                    System.out.println("Floor:" + (i+1) + "Slot:" + (j+1));
                }
            }
        }
        if(!foundSlots){
            System.out.println("No occupied slots!");
        }


    }


    //The Main method
    public static void main(String[] args) {
        int floors = 1;
        int slotsPerFloor = 5;
        //creating an instance of a parkinglot with given parameters
        ParkingLot parkingLot = new ParkingLot("P1234", floors, slotsPerFloor);
        
        parkingLot.getNoOfOpenSlots("car");
        parkingLot.displayOpenSlots("bike");

        String ticket1 = parkingLot.parkVehicle("car", "PH_1", "black");
        String ticket2 = parkingLot.parkVehicle("bike", "B01", "white");
        String ticket3 = parkingLot.parkVehicle("car","PH_2" , "red");
        String ticket4 = parkingLot.parkVehicle("truck","TR_2" , "red");
        String ticket5 = parkingLot.parkVehicle("bike","B02" , "red");

        parkingLot.displayOpenSlots("bike");
        parkingLot.displayOccupiedSlots("car");
        String ticket6 = parkingLot.parkVehicle("bike","B02" , "red");
        parkingLot.unPark(ticket1);
        parkingLot.displayOccupiedSlots("car");
        parkingLot.displayOpenSlots("car");

    }
}
