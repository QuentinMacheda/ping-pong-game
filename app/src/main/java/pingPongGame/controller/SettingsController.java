package pingPongGame.controller;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import pingPongGame.controller.layout.TopBarController;
import pingPongGame.model.GameModel;
import pingPongGame.view.SettingsView;

/**
 * Controller responsible for handling game settings.
 */
public class SettingsController {
    /**
     * The view for game settings.
     */
    public SettingsView settingsView;

    /**
     * The controller for the top bar.
     */
    public TopBarController topBarController;

    /**
     * The current width of the racket.
     */
    private double racketCurrentWidth;

    /**
     * The current height of the racket.
     */
    private double racketCurrentHeight;

    /**
     * Default constructor for the SettingsController.
     */
    public SettingsController() {
    }

    /**
     * Initializes the settings view based on the specified type.
     *
     * @param type The type of settings to be displayed.
     */
    public void initView(String type) {
        settingsView = new SettingsView();
        racketCurrentWidth = GameController.getInstance().racketLeftController.getWidth();
        racketCurrentHeight = GameController.getInstance().racketLeftController.getHeight();

        /*
         * Display the right setting view
         */
        switch (type) {
            case "endGameScore":
                settingsView.endGameScoreView(GameModel.getInstance().getEndGameScore());
                enterKeyPressed(type, settingsView.endGameScoreSlider);
                break;
            case "racketSize":
                settingsView.racketSizeView(racketCurrentWidth, racketCurrentHeight);
                enterKeyPressed(type, settingsView.widthSlider);
                break;
            case "ballSpeed":
                settingsView.ballSpeedView(GameController.getInstance().ballController.getSpeed());
                break;
            case "ballSpeedIR":
                settingsView.ballSpeedIRView(GameController.getInstance().ballController.getSpeedIR());
                break;
            case "player1":
                settingsView.playerNameView(GameController.getInstance().playerLeftController.getName());
                enterKeyPressed(type, settingsView.newPlayerName);
                break;
            case "player2":
                settingsView
                        .playerNameView(GameController.getInstance().playerRightController.getName());
                enterKeyPressed(type, settingsView.newPlayerName);
                break;
            default:
                break;
        }

        // Call save() function onclick save button
        settingsView.saveBtn.setOnAction(e -> save(type));
        settingsView.backBtn.setOnAction(e -> back());
    }

    /*
     * Save settings (change the values)
     */
    private void save(String type) {
        switch (type) {
            case "endGameScore":
                GameModel.getInstance().updateEndGameScore((int) settingsView.endGameScoreSlider.getValue());
                break;
            case "racketSize":
                GameController.getInstance().racketLeftController.updateSize(
                        settingsView.widthSlider.getValue(),
                        settingsView.heightSlider.getValue());
                GameController.getInstance().racketRightController.updateSize(
                        settingsView.widthSlider.getValue(),
                        settingsView.heightSlider.getValue());
                break;
            case "ballSpeed":
                if (settingsView.optSlowBallSpeed.isSelected()) {
                    GameController.getInstance().ballController.setSpeed("slow");
                } else if (settingsView.optFastBallSpeed.isSelected()) {
                    GameController.getInstance().ballController.setSpeed("fast");
                } else {
                    GameController.getInstance().ballController.setSpeed("normal");
                }
                break;
            case "ballSpeedIR":
                if (settingsView.optSlowBallSpeedIR.isSelected()) {
                    GameController.getInstance().ballController.setSpeedIR("slow");
                } else if (settingsView.optFastBallSpeedIR.isSelected()) {
                    GameController.getInstance().ballController.setSpeedIR("fast");
                } else {
                    GameController.getInstance().ballController.setSpeedIR("normal");
                }
                break;
            case "player1":
                if (settingsView.newPlayerName.getText().length() > 0) {
                    GameController.getInstance().playerLeftController
                            .updateName(settingsView.newPlayerName.getText());
                }
                break;
            case "player2":
                if (settingsView.newPlayerName.getText().length() > 0) {
                    GameController.getInstance().playerRightController
                            .updateName(settingsView.newPlayerName.getText());
                }
                break;
            default:
                break;
        }

        MainController.getInstance().hideSettings();
    }

    /*
     * Do not save the settings and go back
     */
    private void back() {
        MainController.getInstance().hideSettings();
    }

    /*
     * Call save() function if key pressed ENTER for uiElement
     */
    private <T extends Node> void enterKeyPressed(String type, T uiElement) {
        // Call save() function if key pressed ENTER
        uiElement.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                save(type);
            }
        });
    }
}
