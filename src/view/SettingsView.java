package src.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import src.controller.layout.TopBarController;

public class SettingsView extends BorderPane {
    public VBox mainContainer;
    public HBox buttonsContainer;
    public Button backBtn, saveBtn;
    public Slider endGameScoreSlider, widthSlider, heightSlider;
    public TextField newPlayerName;

    public SettingsView() {
        // Set Top Bar
        this.setTop(TopBarController.getInstance().getView());

        // Main Container
        mainContainer = new VBox();
        mainContainer.setSpacing(20);
        mainContainer.getStyleClass().add("main-container");
        this.setCenter(mainContainer);

        // Back Button
        backBtn = new Button("Back");
        backBtn.getStyleClass().addAll("btn", "red-btn");

        // Save Button
        saveBtn = new Button("Save");
        saveBtn.getStyleClass().addAll("btn", "orange-btn");

        // Buttons Container
        buttonsContainer = new HBox(backBtn, saveBtn);
        buttonsContainer.setSpacing(20);
        buttonsContainer.getStyleClass().add("btn-container");

        // Bottom Balance
        VBox bottom = new VBox();
        bottom.setMinHeight(80);
        this.setBottom(bottom);
    }

    /*
     * Display settings with endGameScoreView
     */
    public void endGameScoreView(double currentScore) {
        // Text End Game Score
        Text textEndGameScore = new Text("Select the end game score");
        textEndGameScore.getStyleClass().add("setting-title"); // Add CSS

        // End Game Score Slider
        endGameScoreSlider = new Slider(5, 20, currentScore);
        endGameScoreSlider.setMajorTickUnit(5);
        endGameScoreSlider.setMinorTickCount(1);
        endGameScoreSlider.setSnapToTicks(true);
        endGameScoreSlider.setShowTickLabels(true);
        endGameScoreSlider.setShowTickMarks(true);
        endGameScoreSlider.setBlockIncrement(5);
        endGameScoreSlider.setPrefWidth(300);
        endGameScoreSlider.setMaxWidth(300);
        endGameScoreSlider.getStyleClass().add("slider"); // Add CSS

        // Add both to a VBox
        mainContainer.getChildren().addAll(textEndGameScore, endGameScoreSlider, buttonsContainer);
    }

    /*
     * Display settings with racketSizeView
     */
    public void racketSizeView(double currentWidth, double currentHeight) {
        // Text Rackets's Width
        Text textWidth = new Text("Select the rackets's width");
        textWidth.getStyleClass().add("setting-title"); // Add CSS

        // Width Slider
        widthSlider = new Slider(10, 30, currentWidth);
        widthSlider.setMajorTickUnit(10);
        widthSlider.setMinorTickCount(1);
        widthSlider.setSnapToTicks(true);
        widthSlider.setShowTickLabels(true);
        widthSlider.setShowTickMarks(true);
        widthSlider.setBlockIncrement(5);
        widthSlider.setPrefWidth(300);
        widthSlider.setMaxWidth(300);
        widthSlider.getStyleClass().add("slider"); // Add CSS

        // Text Rackets's Height
        Text textHeight = new Text("Select the rackets's height");
        textHeight.getStyleClass().add("setting-title"); // Add CSS

        // Height Slider
        heightSlider = new Slider(100, 140, currentHeight);
        heightSlider.setMajorTickUnit(10);
        heightSlider.setMinorTickCount(1);
        heightSlider.setSnapToTicks(true);
        heightSlider.setShowTickLabels(true);
        heightSlider.setShowTickMarks(true);
        heightSlider.setBlockIncrement(5);
        heightSlider.setPrefWidth(300);
        heightSlider.setMaxWidth(300);
        heightSlider.getStyleClass().add("slider"); // Add CSS

        // Add both to a VBox
        mainContainer.getChildren().addAll(textWidth, widthSlider, textHeight, heightSlider, buttonsContainer);
    }

    /*
     * Display settings with playerNameView
     */
    public void playerNameView() {
        // Text
        Text text = new Text("Enter a new name");
        text.getStyleClass().add("setting-title"); // Add CSS

        // Textfield
        newPlayerName = new TextField();
        newPlayerName.setPadding(new Insets(15));
        newPlayerName.getStyleClass().add("text-field"); // Add CSS

        // Add both to a VBox
        mainContainer.getChildren().addAll(text, newPlayerName, buttonsContainer);
    }
}
