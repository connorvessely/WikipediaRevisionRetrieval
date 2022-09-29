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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    Text sceneTitle;
    Label description;
    TextField titleToCheck;
    Button checkButton;
    Text answer;
    Text counting;
    Text negative;

    @Override
    public void start(Stage stage) throws IOException {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //set up contents of the scene (interior of the window) inside the grid
        sceneTitle = new Text("Wikipedia Revision Checker");
        sceneTitle.setFont(Font.font("Consolas", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1); // Column 0, Row 0, span 2 cols, span 1 row
        description = new Label("Enter Wikipedia Title: ");
        description.setFont(Font.font("Consolas", FontWeight.NORMAL, 12));
        grid.add(description, 0, 1); // col 0, row 1
        titleToCheck = new TextField();
        grid.add(titleToCheck, 1, 1);
        checkButton = new Button("Get Revisions");
        checkButton.setFont(Font.font("Consolas")); // changes the font of the button
        grid.add(checkButton, 1, 4);
        answer = new Text();
        grid.add(answer, 1, 6);
        counting = new Text();
        grid.add(counting,1,7);
        negative = new Text();
        grid.add(negative,1,8);

        // Tie the button to an Action
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

        if (checkIf42.didGuess42(userNum)){
            answer.setFill(Color.GREEN);
            answer.setText("You Got it, Pal!");
            counting.setText(checkIf42.countTo(userNum));
            if (checkIf42.isNegative(userNum)){
                negative.setText("Your Guess is Negative!");
            }else{
                negative.setText("Your Guess is Positive!");
            }
        } else {
            answer.setFill(Color.FIREBRICK);
            answer.setText("That ain't it, Guy!");
            counting.setText(checkIf42.countTo(userNum));
            if (checkIf42.isNegative(userNum)){
                negative.setText("Your Guess is Negative!");
            }else{
                negative.setText("Your Guess is Positive!");
            }
        }

    }

}
