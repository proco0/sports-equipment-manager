package Main.User;
public class UserManager {
    private static final int MAX_USERS = 100;
    private User[] userList;
    private int size;

    public UserManager() {
        this.userList = new User[MAX_USERS];
        this.size = 0;
    }

    public void addUser(User user) {
        if (size < MAX_USERS) {
            userList[size++] = user;
        } else {
            System.out.println("User storage is full");
        }
    }

    public User authenticateUser(String username, String password) {
        for (int i = 0; i < size; i++) {
            if (userList[i].getUsername().equals(username) && userList[i].getPassword().equals(password)) {
                return userList[i];
            }
        }
        return null; // User not found or invalid credentials
    }
}

