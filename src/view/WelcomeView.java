package src.view;

import javafx.scene.layout.BorderPane;
import javafx.scene.text.*;

public class WelcomeView extends BorderPane {
    Text welcomeText;

    // Constructor
    public WelcomeView() {
        welcomeText = new Text();
        welcomeText.setText("Welcome to Ping Pong Game !");
        welcomeText.setFont(Font.font("Verdana", 20));
        this.setCenter(welcomeText);
    }
}
