package Main.Equipment;
public class Equipment {
    private String equipmentId;
    private String name;
    private int totalQuantity;
    private int availableQuantity;
    private double price;
 // constructor
    public Equipment(String equipmentId, String name, int totalQuantity, double price) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.totalQuantity = totalQuantity;
        this.availableQuantity = totalQuantity;
        this.price = price;
    }
  //Getter
    public String getEquipmentId() {
        return equipmentId;
    }

    public String getName() {
        return name;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public double getPrice() {
        return price;
    }
 // normal method
    public void updateQuantity(int quantity) {
        if (quantity <= availableQuantity) {
            availableQuantity -= quantity;
        } 
    }
}