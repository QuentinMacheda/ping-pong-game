package src.controller;

import java.util.ArrayList;

import src.view.MainView;

public class MainController {
    public static MainController selfInstance = new MainController(); // Singleton
    public SettingsController settingsController;

    public enum MainState {
        WELCOME, RUNNING, PAUSED, SETTINGS, GAMEOVER
    }

    public MainState mainState;
    public ArrayList<MainState> mainStateHistory = new ArrayList<MainState>();

    // Constructor
    private MainController() {
        this.fullReset();
    }

    public void fullReset() {
        mainStateHistory.clear();
        GameController.getInstance().fullReset();
        settingsController = new SettingsController();

        // Display welcome view
        MainView.getInstance().displayWelcome();
        this.setMainState(MainState.WELCOME);
    }

    // Start the game
    public void startGame() {
        GameController.getInstance().initView();
        MainView.getInstance().displayGame();
        this.setMainState(MainState.RUNNING);
    }

    // Game over
    public void gameOver(String winnerName, String looserName) {
        MainView.getInstance().hideGame();
        MainView.getInstance().displayEnd(winnerName, looserName);
        this.setMainState(MainState.GAMEOVER);
    }

    // Display settings
    public void displaySettings(String type) {
        // Remove the current view
        switch (this.getMainState()) {
            case WELCOME:
                MainView.getInstance().hideWelcome();
                break;
            case RUNNING:
                MainView.getInstance().hideGame();
                break;
            case PAUSED:
                MainView.getInstance().hideGame();
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

    // Hide settings
    public void hideSettings() {
        // Remove the settings view
        MainView.getInstance().hideSettings();
        this.displayLastViewBeforeSettings();
    }

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
            case RUNNING:
                MainView.getInstance().displayGame();
                break;
            case PAUSED:
                MainView.getInstance().displayGame();
                break;
            default:
                break;
        }

        this.setMainState(lastState);
    }

    // Get the last game state
    public MainState getLastMainState() {
        return mainStateHistory.get(mainStateHistory.size() - 1);
    }

    // Get the game state
    public MainState getMainState() {
        return mainState;
    }

    // Set the game state
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
            case GAMEOVER:
                mainState = MainState.GAMEOVER;
                break;
            default:
                break;
        }

        // Add the state to the history
        mainStateHistory.add(mainState);
    }

    public static MainController getInstance() {
        return selfInstance; // Singleton
    }
}
