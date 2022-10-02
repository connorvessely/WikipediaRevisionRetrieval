package edu.bsu.cs222;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui extends Application {

    Text sceneTitle;
    Label description;
    TextField titleToCheck;
    Button checkButton;
    Text redirects;
    Text revisions;

    @Override
    public void start(Stage stage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        sceneTitle = new Text("Wikipedia Revision Checker");
        sceneTitle.setFont(Font.font("Consolas", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);
        description = new Label("Enter Wikipedia Title: ");
        description.setFont(Font.font("Consolas", FontWeight.NORMAL, 12));
        grid.add(description, 0, 1);
        titleToCheck = new TextField();
        grid.add(titleToCheck, 1, 1);
        checkButton = new Button("Get Revisions");
        checkButton.setFont(Font.font("Consolas"));
        grid.add(checkButton, 1, 4);
        redirects = new Text();
        grid.add(redirects, 1, 6);
        revisions = new Text();
        grid.add(revisions,1,7);

        checkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleButtonClick();
            }
        });
        Scene scene = new Scene(grid, 440, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void handleButtonClick() {
        String userEntry = titleToCheck.getText();
    }



}
