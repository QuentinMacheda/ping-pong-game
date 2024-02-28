package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    public RadioButton optSlowBallSpeed, optNormalBallSpeed, optFastBallSpeed, optSlowBallSpeedIR, optNormalBallSpeedIR,
            optFastBallSpeedIR;

    public SettingsView() {
        // Set Top Bar
        TopBarController.getInstance().initView();
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
    }

    /*
     * Display settings with endGameScoreView
     */
    public void endGameScoreView(double currentScore) {
        // Text End Game Score
        Text titleText = new Text("Select the end game score");
        titleText.getStyleClass().add("setting-title"); // Add CSS

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
        mainContainer.getChildren().addAll(titleText, endGameScoreSlider, buttonsContainer);
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
     * Display settings with ballSpeedView
     */
    public void ballSpeedView(String optSelected) {
        // Text End Game Score
        Text titleText = new Text("Select the ball speed");
        titleText.getStyleClass().add("setting-title"); // Add CSS

        // Radio Buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        optSlowBallSpeed = new RadioButton("Slow");
        optNormalBallSpeed = new RadioButton("Normal");
        optFastBallSpeed = new RadioButton("Fast");

        optSlowBallSpeed.setToggleGroup(toggleGroup);
        optNormalBallSpeed.setToggleGroup(toggleGroup);
        optFastBallSpeed.setToggleGroup(toggleGroup);

        // Set the current selected option
        if (optSelected == "slow")
            optSlowBallSpeed.setSelected(true);
        else if (optSelected == "fast")
            optFastBallSpeed.setSelected(true);
        else
            optNormalBallSpeed.setSelected(true);

        HBox optionsContainer = new HBox(new VBox(10, optSlowBallSpeed, optNormalBallSpeed, optFastBallSpeed));
        optionsContainer.setAlignment(Pos.CENTER);

        // Add both to a VBox
        mainContainer.getChildren().addAll(titleText, optionsContainer, buttonsContainer);
    }

    /*
     * Display settings with ballSpeedIncreaseRateView
     */
    public void ballSpeedIRView(String optSelected) {
        // Text End Game Score
        Text titleText = new Text("Select the ball speed increase rate");
        titleText.getStyleClass().add("setting-title"); // Add CSS

        // Radio Buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        optSlowBallSpeedIR = new RadioButton("Slow");
        optNormalBallSpeedIR = new RadioButton("Normal");
        optFastBallSpeedIR = new RadioButton("Fast");

        optSlowBallSpeedIR.setToggleGroup(toggleGroup);
        optNormalBallSpeedIR.setToggleGroup(toggleGroup);
        optFastBallSpeedIR.setToggleGroup(toggleGroup);

        // Set the current selected option
        if (optSelected == "slow")
            optSlowBallSpeedIR.setSelected(true);
        else if (optSelected == "fast")
            optFastBallSpeedIR.setSelected(true);
        else
            optNormalBallSpeedIR.setSelected(true);

        HBox optionsContainer = new HBox(new VBox(10, optSlowBallSpeedIR, optNormalBallSpeedIR, optFastBallSpeedIR));
        optionsContainer.setAlignment(Pos.CENTER);

        // Add both to a VBox
        mainContainer.getChildren().addAll(titleText, optionsContainer, buttonsContainer);
    }

    /*
     * Display settings with playerNameView
     */
    public void playerNameView(String currentPlayerName) {
        // Text
        Text titleText = new Text("Enter a new name for " + currentPlayerName);
        titleText.getStyleClass().add("setting-title"); // Add CSS

        // Textfield
        newPlayerName = new TextField();
        newPlayerName.setPadding(new Insets(15));
        newPlayerName.getStyleClass().add("text-field"); // Add CSS

        // Add both to a VBox
        mainContainer.getChildren().addAll(titleText, newPlayerName, buttonsContainer);
    }
}
