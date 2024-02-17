package src.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import src.controller.layout.TopBarController;

public class SettingsView extends BorderPane {
    public Button saveBtn;
    public TextField newPlayerName;

    public SettingsView() {
        // Set Top Bar
        this.setTop(TopBarController.getInstance().getView());
    }

    public void updatePlayerName() {
        // Text
        Text text = new Text("Enter a new name");
        text.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 20));
        text.setFill(Color.web("#F1E9DA"));

        // Textfield
        newPlayerName = new TextField();
        newPlayerName.setPadding(new Insets(15));
        newPlayerName.setStyle(
                "-fx-background-color: transparent; -fx-text-fill: #F1E9DA; -fx-border-color: #FF910A; -fx-border-width: 2px; -fx-border-radius: 5px;");
        newPlayerName.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 20));
        newPlayerName.setPrefWidth(250);
        newPlayerName.setMaxWidth(250);

        // Button
        saveBtn = new Button("Save");
        saveBtn.setPadding(new Insets(15));
        saveBtn.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        saveBtn.setTextFill(Color.web("#1B1B1E"));
        saveBtn.setStyle("-fx-background-color: #FF910A");

        // Add both to a VBox
        VBox container = new VBox(text, newPlayerName, saveBtn);
        container.setSpacing(20);
        container.setStyle("-fx-alignment: center; -fx-padding: 20px;");

        this.setCenter(container);
    }
}
