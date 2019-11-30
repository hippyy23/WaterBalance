package waterbalance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author Adrian
 */
public class UserContainer {

    // class variables
    static ArrayList<User> userArray;

    /**
     * constructor
     */
    public UserContainer() {
        userArray = new ArrayList<>();
    }

    /**
     * method add a user to array list
     *
     * @param username
     */
    public void addUser(String username) {
        for (User u : userArray) {
            if (u.getUsername().equals(username)
                    && u.getDate().equals(LocalDate.now())) {
                return;
            }
        }
        userArray.add(new User(username, LocalDate.now()));
    }

    /**
     * returns User current user
     *
     * @param username
     * @return username
     */
    public User getCurrentUser(String username) {
        for (User u : userArray) {
            if (u.getUsername().equals(username)
                    && u.getDate().equals(LocalDate.now())) {
                return u;
            }
        }
        return null;
    }

    /**
     * serialize user array
     *
     * @throws java.io.IOException
     */
    public void serializeUser() throws java.io.IOException {
        try (FileOutputStream file = new FileOutputStream("./data/user.bin")) {
            ObjectOutputStream stream = new ObjectOutputStream(file);

            stream.writeObject(userArray);
            stream.close();
        }
    }

    /**
     * de-serialize user array
     *
     * @throws java.io.IOException
     */
    public void deserializeUser() throws java.io.IOException {
        FileInputStream file = new FileInputStream("./data/user.bin");
        try (ObjectInputStream stream = new ObjectInputStream(file)) {
            userArray = (ArrayList) stream.readObject();
        } catch (ClassNotFoundException | FileNotFoundException ex) {
        } finally {
            file.close();
        }
    }
}
