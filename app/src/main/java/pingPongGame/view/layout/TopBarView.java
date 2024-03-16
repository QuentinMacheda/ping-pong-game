package pingPongGame.view.layout;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import pingPongGame.controller.GameController;
import pingPongGame.controller.MainController;
import pingPongGame.controller.layout.TopBarController;
import pingPongGame.view.components.PlayerView;

/**
 * The top bar view containing menus for game and player settings.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class TopBarView extends VBox {
    /** The controller for the top bar. */
    public TopBarController topBarController;

    /** The menu bar for game and player settings. */
    public MenuBar menuBar;

    /** Menu for game and players settings. */
    public Menu gameSettings, playersName;

    /** All the menu items */
    public MenuItem endGameScore, exit, racketSize, ballSpeed, ballSpeedIncreaseRate, player1, player2;

    /** Container holding player views. */
    public BorderPane playersContainer;

    /** The view for the left and right player. */
    public PlayerView playerLeftView, playerRightView;

    /**
     * Constructs the TopBarView, initializes the menu bar and handles button
     * actions.
     */
    public TopBarView() {
        displayMenu();
        handleButtonsActions();
    }

    /**
     * Initializes the settings menu view for the top bar.
     */
    private void displayMenu() {
        // Menu
        menuBar = new MenuBar();

        // Items
        gameSettings = new Menu("Game settings");
        playersName = new Menu("Players settings");

        // Sub-items
        endGameScore = new MenuItem("End game score");
        racketSize = new MenuItem("Rackets size");
        ballSpeed = new MenuItem("Ball speed");
        ballSpeedIncreaseRate = new MenuItem("Speed increase rate");
        exit = new MenuItem("Exit");
        player1 = new MenuItem(GameController.getInstance().playerLeftController.getName());
        player2 = new MenuItem(GameController.getInstance().playerRightController.getName());

        // Adding to the menu items
        gameSettings.getItems().addAll(endGameScore, racketSize, ballSpeed, ballSpeedIncreaseRate, exit);
        playersName.getItems().addAll(player1, player2);
        menuBar.getMenus().addAll(gameSettings, playersName);

        this.getChildren().add(menuBar);
    }

    /**
     * Handles the actions for menu items.
     */
    private void handleButtonsActions() {
        // Set End Game Score
        this.endGameScore.setOnAction(e -> {
            MainController.getInstance().displaySettings("endGameScore");
        });

        // Set Racket Size
        this.racketSize.setOnAction(e -> {
            MainController.getInstance().displaySettings("racketSize");
        });

        // Set Ball Speed
        this.ballSpeed.setOnAction(e -> {
            MainController.getInstance().displaySettings("ballSpeed");
        });

        // Set Ball Speed Increase Rate
        this.ballSpeedIncreaseRate.setOnAction(e -> {
            MainController.getInstance().displaySettings("ballSpeedIR");
        });

        // Exit Game
        this.exit.setOnAction(e -> System.exit(0));

        // Change Players Name
        this.player1.setOnAction(e -> {
            MainController.getInstance().displaySettings("player1");
        });
        this.player2.setOnAction(e -> {
            MainController.getInstance().displaySettings("player2");
        });
    }
}
