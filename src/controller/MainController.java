package src.controller;

import src.view.MainView;

public class MainController {
    public enum MainState {
        WELCOME, RUNNING, PAUSED, GAMEOVER
    }

    public MainState mainState;
    public MainView mainView;

    // Constructor
    public MainController(MainView mainView) {
        // Display welcome view
        mainView.welcome();
        setMainState("WELCOME");
    }

    // Get the game state
    public MainState getMainState() {
        return mainState;
    }

    // Set the game state
    public void setMainState(String state) {
        switch (state) {
            case "RUNNING":
                mainState = MainState.RUNNING;
                break;
            case "PAUSED":
                mainState = MainState.PAUSED;
                break;
            case "GAMEOVER":
                mainState = MainState.GAMEOVER;
                break;
            default:
                mainState = MainState.WELCOME;
                break;
        }
    }

    // Start the game
    public void startGame() {
        mainView.startGame();
        setMainState("RUNNING");
    }
}
