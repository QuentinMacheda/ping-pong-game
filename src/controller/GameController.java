package src.controller;

import src.view.*;

public class GameController {
    private enum GameState {
        WELCOME, RUNNING, PAUSED, GAMEOVER
    }

    public GameView gameView;
    private GameState gameState;

    // Constructor
    public GameController(GameView gameView) {
        this.gameView = gameView;
        this.gameState = GameState.WELCOME;
    }

    // Get the game state
    public GameState getGameState() {
        return this.gameState;
    }

    // Set the game state
    public void setGameState(String state) {
        switch (state) {
            case "RUNNING":
                this.gameState = GameState.RUNNING;
                break;
            case "PAUSED":
                this.gameState = GameState.PAUSED;
                break;
            case "GAMEOVER":
                this.gameState = GameState.GAMEOVER;
                break;
            default:
                this.gameState = GameState.WELCOME;
                break;
        }
    }

    // Start the game
    public void startGame() {
        this.setGameState("RUNNING");
        gameView.setGameComponents();
    }
}
