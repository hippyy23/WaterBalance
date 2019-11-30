package waterbalance;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Adrian
 */
public class Day implements Serializable {

    // class variables
    private String user;
    private LocalDate date;
    private int millilitersGoal;
    private int millilitersAchieved;

    /**
     * constructor
     *
     * @param user
     * @param date
     * @param millilitersGoal
     * @param millilitersAchieved
     */
    public Day(String user, LocalDate date, int millilitersGoal, int millilitersAchieved) {
        this.user = user;
        this.date = date;
        this.millilitersGoal = millilitersGoal;
        this.millilitersAchieved = millilitersAchieved;
    }

    /**
     * returns String username
     *
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * sets String username
     *
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * returns LocalDate date
     *
     * @return date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * sets LocalDate date
     *
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * returns int milliliters goal
     *
     * @return milliliters goal
     */
    public int getMillilitersGoal() {
        return millilitersGoal;
    }

    /**
     * sets int milliliters goal
     *
     * @param millilitersGoal
     */
    public void setMillilitersGoal(int millilitersGoal) {
        this.millilitersGoal = millilitersGoal;
    }

    /**
     * returns int milliliters achieved
     *
     * @return milliliters achieved
     */
    public int getMillilitersAchieved() {
        return millilitersAchieved;
    }

    /**
     * sets int milliliters achieved
     *
     * @param millilitersAchieved
     */
    public void setMillilitersAchieved(int millilitersAchieved) {
        this.millilitersAchieved = millilitersAchieved;
    }

}
