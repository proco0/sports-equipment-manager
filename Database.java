package Main;
import java.sql.*;

import Main.User.User;
import Main.User.UserManager;
public class Database {
    String url = "jdbc:mysql://localhost:3306/SportsEquipment";
    String user = "root";
    String password = "SwapnadipNandi@2023";
    Statement stml = null;
    Connection c = null;
    public Database() {
        try {
            c = DriverManager.getConnection(url, user, password);
            stml = c.createStatement();
            c.setAutoCommit(false);
            stml = c.createStatement();
        } catch (Exception e) {
            c = null;
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(1);
        }
    }
    private String getId() {
        int id = 10001;
        try {
            ResultSet values = stml.executeQuery("SELECT * FROM USER;");
            while (values.next()) {
                id += 1;
            }
            return Integer.toString(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(1);
            return null;
        }
    }
    public  UserManager addUser(UserManager userManager,String username, String password, String department, String rollNumber, int maxReservations) {
        try {
            String id = this.getId();
            String query = String.format("Insert into user values('%s','%s','%s','%s','%s','%s');", id,  username,  password,  department,  rollNumber, Integer.toString(maxReservations));
            stml.executeUpdate(query);
            c.commit();
            userManager.addUser(new User(id,username,password,  department,  rollNumber, maxReservations));
            return userManager;
        } catch (SQLException e) {
            return null;
        }
    }
    public  UserManager initialze(UserManager userManager) {
        try {
            String query = String.format("Select * from user;");
            ResultSet res = stml.executeQuery(query);
            while (res.next()) {
                userManager.addUser( new User(
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    Integer.parseInt(res.getString(6)))
                );
            }
            return userManager;
        } catch (SQLException e) {
            return null;
        }
    }
}