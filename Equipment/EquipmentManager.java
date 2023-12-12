package Main.Equipment;
public class EquipmentManager {
    private static final int MAX_EQUIPMENT = 100;
    private Equipment[] equipmentList;
    private int size;

    public EquipmentManager() {
        this.equipmentList = new Equipment[MAX_EQUIPMENT];
        this.size = 0;
    }

    public void addEquipment(Equipment equipment) {
        if (size < MAX_EQUIPMENT) {
            equipmentList[size++] = equipment;
        } else {
            System.out.println("Equipment storage is full");
        }
    }

    public Equipment findEquipmentById(String equipmentId) {
        for (int i = 0; i < size; i++) {
            if (equipmentList[i].getEquipmentId().equals(equipmentId)) {
                return equipmentList[i];
            }
        }
        return null; // Equipment not found
    }
    // []  Equipment ka array return hoga type 
    public Equipment[] getEquipmentList() {
        return equipmentList;
    }
    //getter
    public int getSize() {
        return size;
    }
}
