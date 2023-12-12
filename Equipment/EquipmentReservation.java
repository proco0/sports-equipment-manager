package Main.Equipment;
import Main.User.User;

public class EquipmentReservation {
    private String reservationId;
    private User user;
    private Equipment equipment;
    private int hours;
    private boolean collected; // kitnae equipment 

    public EquipmentReservation() {
        // Default constructor
    }

    public String getReservationId() {
        return reservationId;
    }

    public User getUser() {
        return user;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public int getHours() {
        return hours;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public void collectEquipment() {
        this.collected = true;
        System.out.println("Equipment collected by: " + user.getUsername());
    }
}
