public class Vehicle {
    String type;
    String registration;
    String color;
    public Vehicle(String type, String registration, String color) {
        this.type = type;
        this.registration = registration;
        this.color = color;
    }
    public String getRegistration() {
        return registration;
    }
    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setColor(String color) {
        this.color = color;
    }
}

