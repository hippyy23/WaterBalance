package waterbalance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class DayContainer {

    // class variables
    static ArrayList<Day> dayArray;

    /**
     * constructor
     */
    public DayContainer() {
        dayArray = new ArrayList<>();
    }

    /**
     * sets new user
     *
     * @param user
     */
    public void setNewUser(User user) {
        dayArray.add(new Day(user.getUsername(), user.getDate(), 0, 0));
    }

    /**
     * sets water goal
     *
     * @param user
     * @param value
     */
    public void setWaterGoal(User user, int value) {
        for (Day d : dayArray) {
            if (d.getUser().equals(user.getUsername())) {
                d.setMillilitersGoal(value);
            }
        }
    }

    /**
     * sets water achieved
     *
     * @param user
     * @param value
     */
    public void setWaterAchieved(User user, int value) {
        for (Day d : dayArray) {
            if (d.getUser().equals(user.getUsername())) {
                d.setMillilitersAchieved(d.getMillilitersAchieved() + value);
            }
        }
    }

    /**
     * returns int water achieved
     *
     * @param user
     * @param date
     * @return water achieved
     */
    public int getWaterAchieved(User user, LocalDate date) {
        for (Day d : dayArray) {
            if (d.getUser().equals(user.getUsername())
                    && d.getDate().equals(date)) {
                return d.getMillilitersAchieved();
            }
        }
        return 0;
    }

    /**
     * returns int water goal
     *
     * @param user
     * @param date
     * @return water goal
     */
    public int getWaterGoal(User user, LocalDate date) {
        for (Day d : dayArray) {
            if (d.getUser().equals(user.getUsername())
                    && d.getDate().equals(date)) {
                return d.getMillilitersGoal();
            }
        }
        return 0;
    }

    /**
     * return boolean if array is empty
     *
     * @return is empty
     */
    public boolean isEmpty() {
        return dayArray.isEmpty();
    }

    /**
     * serialize array day
     *
     * @throws java.io.IOException
     */
    public void serializeDay() throws java.io.IOException {
        try (FileOutputStream file = new FileOutputStream("./data/day.bin")) {
            ObjectOutputStream stream = new ObjectOutputStream(file);

            stream.writeObject(dayArray);
            stream.close();
        }
    }

    /**
     * de-serialize array day
     *
     * @throws java.io.IOException
     */
    public void deserializeDay() throws java.io.IOException {
        FileInputStream file = new FileInputStream("./data/day.bin");
        try (ObjectInputStream stream = new ObjectInputStream(file)) {
            dayArray = (ArrayList) stream.readObject();
        } catch (ClassNotFoundException | FileNotFoundException ex) {
        } finally {
            file.close();
        }
    }

}
