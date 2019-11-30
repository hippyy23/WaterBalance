package waterbalance;

import java.util.HashMap;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 *
 * @author Adrian
 */
public class ScreenController {

    // class variables
    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;

    /**
     * sets screen controller
     *
     * @param main
     */
    public ScreenController(Scene main) {
        this.main = main;
    }

    /**
     * adds screen
     *
     * @param name
     * @param pane
     */
    protected void addScreen(String name, Pane pane) {
        screenMap.put(name, pane);
    }

    /**
     * removes screen
     *
     * @param name
     */
    protected void removeScreen(String name) {
        screenMap.remove(name);
    }

    /**
     * activates screen
     *
     * @param name
     */
    protected void activate(String name) {
        main.setRoot(screenMap.get(name));
    }
}
