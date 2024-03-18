package pingPongGame.controller;

import java.util.ArrayList;

import pingPongGame.controller.layout.TopBarController;
import pingPongGame.view.MainView;

/**
 * Controller responsible for managing the main flow of the game.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class MainController {

    /*
     * The singleton instance of the MainController.
     */
    public static MainController selfInstance = new MainController();

    // Enumeration representing the possible states of the main controller
    public enum MainState {
        WELCOME, RUNNING, SCORED, PAUSED, SETTINGS, GAMEOVER
    }

    /*
     * The current state of the main controller.
     */
    public MainState mainState;

    /*
     * The history of the main state.
     */
    public ArrayList<MainState> mainStateHistory = new ArrayList<MainState>();

    /**
     * The controller for the settings.
     */
    public SettingsController settingsController;

    /**
     * The controller for the top bar.
     */
    public TopBarController topBarController;

    // Constructor
    private MainController() {
        this.init();
    }

    /**
     * Initializes the main controller.
     */
    public void init() {
        settingsController = new SettingsController();
        topBarController = new TopBarController();

        // Display the welcome view
        MainView.getInstance().displayWelcome();
        this.setMainState(MainState.WELCOME);
    }

    /**
     * Resets the main controller to its initial state.
     */
    public void fullReset() {
        mainStateHistory.clear();
        GameController.getInstance().fullReset();

        // Display the welcome view
        MainView.getInstance().displayWelcome();
        this.setMainState(MainState.WELCOME);
    }

    /**
     * Starts the game.
     */
    public void startGame() {
        GameController.getInstance().initView();
        MainView.getInstance().displayGame();
    }

    /**
     * Handles the game over scenario.
     * 
     * @param winnerName The name of the winner.
     * @param looserName The name of the loser.
     */
    public void gameOver(String winnerName, String looserName) {
        MainView.getInstance().hideGame();
        MainView.getInstance().displayEnd(winnerName, looserName);
        this.setMainState(MainState.GAMEOVER);
    }

    /**
     * Displays the settings view.
     * 
     * @param type The type of settings to be displayed.
     */
    public void displaySettings(String type) {
        // Remove the current view
        switch (this.getMainState()) {
            case WELCOME:
                MainView.getInstance().hideWelcome();
                break;
            case SETTINGS:
                MainView.getInstance().hideSettings();
                break;
            default:
                break;
        }

        MainView.getInstance().displaySettings(type);
        this.setMainState(MainState.SETTINGS);
    }

    /**
     * Hides the settings view.
     */
    public void hideSettings() {
        // Remove the settings view
        MainView.getInstance().hideSettings();
        this.displayLastViewBeforeSettings();
    }

    /**
     * Displays the last view before the settings view was shown.
     */
    private void displayLastViewBeforeSettings() {
        // Get the last state before settings
        MainState lastState = MainState.SETTINGS;
        int count = mainStateHistory.size() - 1;

        while (mainStateHistory.get(count) == MainState.SETTINGS) {
            lastState = mainStateHistory.get(count - 1);
            count--;
        }

        // Display the last view before settings
        switch (lastState) {
            case WELCOME:
                MainView.getInstance().displayWelcome();
                break;
            default:
                break;
        }

        this.setMainState(lastState);
    }

    /**
     * Gets the last recorded main state.
     * 
     * @return The last main state.
     */
    public MainState getLastMainState() {
        return mainStateHistory.get(mainStateHistory.size() - 1);
    }

    /**
     * Gets the current main state.
     * 
     * @return The current main state.
     */
    public MainState getMainState() {
        return mainState;
    }

    /**
     * Sets the current main state and adds it to the history.
     * 
     * @param state The new main state.
     */
    public void setMainState(MainState state) {
        switch (state) {
            case SETTINGS:
                mainState = MainState.SETTINGS;
                break;
            case WELCOME:
                mainState = MainState.WELCOME;
                break;
            case RUNNING:
                mainState = MainState.RUNNING;
                break;
            case PAUSED:
                mainState = MainState.PAUSED;
                break;
            case SCORED:
                mainState = MainState.SCORED;
                break;
            case GAMEOVER:
                mainState = MainState.GAMEOVER;
                break;
            default:
                break;
        }

        // Add the state to the history
        mainStateHistory.add(mainState);
    }

    /**
     * Gets the singleton instance of the MainController.
     * 
     * @return The MainController instance.
     */
    public static MainController getInstance() {
        return selfInstance; // Singleton
    }
}
