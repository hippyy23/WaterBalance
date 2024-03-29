package waterbalance;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Adrian
 */
public class Entry implements Serializable {

    // class variables
    private String user;
    private int millilitersCurrent;
    private int millilitersGoal;
    private LocalDate date;

    /**
     * constructor
     *
     * @param user
     * @param millilitersCurrent
     * @param millilitersGoal
     * @param date
     */
    public Entry(String user, int millilitersCurrent, int millilitersGoal, LocalDate date) {
        this.user = user;
        this.millilitersCurrent = millilitersCurrent;
        this.millilitersGoal = millilitersGoal;
        this.date = date;
    }

    /**
     * get String user
     *
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * set user
     *
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * get int milliliters current
     *
     * @return milliliters current
     */
    public int getMillilitersCurrent() {
        return millilitersCurrent;
    }

    /**
     * set milliliters current
     *
     * @param millilitersCurrent
     */
    public void setMillilitersCurrent(int millilitersCurrent) {
        this.millilitersCurrent = millilitersCurrent;
    }

    /**
     * get LocalDate date
     *
     * @return date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * set date
     *
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * get int milliliters goal
     *
     * @return milliliters goal
     */
    public int getMillilitersGoal() {
        return millilitersGoal;
    }

    /**
     * set milliliters goal
     *
     * @param millilitersGoal
     */
    public void setMillilitersGoal(int millilitersGoal) {
        this.millilitersGoal = millilitersGoal;
    }

}
