package waterbalance;

import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class UserContainer {
    
    // class variables
    private ArrayList<String> userArray;
    
    /**
     * constructor
     */
    public UserContainer() {
        userArray = new ArrayList<>();
    }
    
    /**
     * method add a user to array list
     * 
     * @param user 
     */
    public void addUser(String user) {
        userArray.add(user);
    }
    
}
