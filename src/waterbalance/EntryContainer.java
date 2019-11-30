package waterbalance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class EntryContainer {

    // class variables
    static ArrayList<Entry> entryArray;

    /**
     * constructor
     */
    public EntryContainer() {
        entryArray = new ArrayList<>();
    }

    /**
     * sets new user
     *
     * @param user
     */
    public void setNewUser(User user) {
        entryArray.add(new Entry(user.getUsername(), 0, 0, user.getDate()));
    }

    /**
     * sets current water
     *
     * @param user
     * @param addValue
     */
    public void setCurrentWater(User user, int addValue) {
        for (Entry e : entryArray) {
            if (e.getUser().equals(user.getUsername())) {
                e.setMillilitersCurrent(e.getMillilitersCurrent() + addValue);
            }
        }
    }

    /**
     * sets water goal
     *
     * @param user
     * @param goal
     */
    public void setWaterGoal(User user, int goal) {
        for (Entry e : entryArray) {
            if (e.getUser().equals(user.getUsername())) {
                e.setMillilitersGoal(goal);
            }
        }
    }

    /**
     * returns int water goal
     *
     * @param user
     * @return water goal
     */
    public int getWaterGoal(User user) {
        for (Entry e : entryArray) {
            if (e.getUser().equals(user.getUsername())) {
                return e.getMillilitersGoal();
            }
        }
        return 0;
    }

    /**
     * returns int current water
     *
     * @param user
     * @return current water
     */
    public int getCurrenWater(User user) {
        for (Entry e : entryArray) {
            if (e.getUser().equals(user.getUsername())) {
                return e.getMillilitersCurrent();
            }
        }
        return 0;
    }

    /**
     * returns boolean user exists
     *
     * @param user
     * @return user exists
     */
    public boolean userExists(User user) {

        for (Entry e : entryArray) {
            if (e.getUser().equals(user.getUsername())
                    && e.getDate().equals(user.getDate())) {
                return true;
            }
        }
        return false;

    }

    /**
     * returns boolean array is empty
     *
     * @return is empty
     */
    public boolean isEmpty() {
        return entryArray.isEmpty();
    }

    /**
     * serialize entry array
     *
     * @throws java.io.IOException
     */
    public void serializeEntry() throws java.io.IOException {
        try (FileOutputStream file = new FileOutputStream("./data/entry.bin")) {
            ObjectOutputStream stream = new ObjectOutputStream(file);

            stream.writeObject(entryArray);
            stream.close();
        }
    }

    /**
     * de-serialize entry array
     *
     * @throws java.io.IOException
     */
    public void deserializeEntry() throws java.io.IOException {
        FileInputStream file = new FileInputStream("./data/entry.bin");
        try (ObjectInputStream stream = new ObjectInputStream(file)) {
            entryArray = (ArrayList) stream.readObject();
        } catch (ClassNotFoundException | FileNotFoundException ex) {
        } finally {
            file.close();
        }
    }
}
