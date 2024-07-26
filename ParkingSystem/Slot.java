public class Slot {
    private String type;
    private Vehicle vehicle;
    private String  ticketId;

    public Slot(String type, Vehicle vehicle, String ticketId){
        this.type = type;
        this.vehicle = vehicle;
        this.ticketId = ticketId;
    }

    public Slot(String type){
        this.type = type;
    }
    //getter methods
    public String getType() {
        return type;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public String getTicketId() {
        return ticketId;
    }

    //setter methods
    public void setType(String type) {
        this.type = type;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
