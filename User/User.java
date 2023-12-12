package Main.User;
import Main.Equipment.EquipmentReservation;

public class User {
    private String userId;
    private String username;
    private String password;
    private String department;
    private String rollNumber;
    private EquipmentReservation[] reservations;
    private int reservationSize;

    public User(String userId, String username, String password, String department, String rollNumber, int maxReservations) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.department = department;
        this.rollNumber = rollNumber;
        this.reservations = new EquipmentReservation[maxReservations];
        this.reservationSize = 0;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getDepartment() {
        return department;
    }

    public String getRollNumber() {
        return rollNumber;
    }
}