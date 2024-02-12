package src.view.layout;

import javafx.scene.layout.VBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;

import src.controller.PlayerController;

public class TopBarView extends VBox {
    public BorderPane playersContainer;
    public PlayerController playerLeftController;
    public PlayerController playerRightController;
    public MenuBar menuBar;
    public Menu gameSettings;
    public Menu playersName;
    public Menu rackets;
    public MenuItem exit;
    public MenuItem endingScore;
    public MenuItem racketsSize;
    public MenuItem ballSpeed;
    public MenuItem increaseRate;
    public MenuItem player1;
    public MenuItem player2;

    public TopBarView() {
        // Adding players names/scores
        playersContainer = new BorderPane();
        playersContainer.setPadding(new Insets(50));
        playerLeftController = new PlayerController("Player1", 0);
        playerRightController = new PlayerController("Player2", 0);
        playersContainer.setLeft(playerLeftController.playerView);
        playersContainer.setRight(playerRightController.playerView);

        // Menu
        menuBar = new MenuBar();

        // Items
        gameSettings = new Menu("Game");
        playersName = new Menu("Players settings");

        // subItems
        endingScore = new MenuItem("Set ending score");
        racketsSize = new MenuItem("Set rackets size");
        ballSpeed = new MenuItem("Set ball speed");
        increaseRate = new MenuItem("Set speed increase rate");
        exit = new MenuItem("Exit");
        player1 = new MenuItem(playerLeftController.playerModel.getName());
        player2 = new MenuItem(playerRightController.playerModel.getName());

        // Adding to the menu items
        gameSettings.getItems().addAll(endingScore, racketsSize, ballSpeed, increaseRate, exit);
        playersName.getItems().addAll(player1, player2);
        menuBar.getMenus().addAll(gameSettings, playersName);

        // Adding to the top bar
        this.getChildren().add(menuBar);
        this.getChildren().add(playersContainer);
    }
}
