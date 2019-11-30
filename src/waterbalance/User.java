package waterbalance;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Adrian
 */
public class User implements Serializable {

    // class variables
    LocalDate date;
    String username;

    /**
     * constructor
     *
     * @param user
     * @param date
     */
    public User(String user, LocalDate date) {
        this.username = user;
        this.date = date;
    }

    /**
     * get String username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
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
     * sets date
     *
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

}
