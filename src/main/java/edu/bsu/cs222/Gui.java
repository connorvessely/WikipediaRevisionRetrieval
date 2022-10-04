package edu.bsu.cs222;

import javafx.application.Application;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Gui extends Application {

    Text sceneTitle;
    Label description;
    TextField titleToCheck;
    Button checkButton;
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
        revisions = new Text();
        grid.add(revisions,1,7);

        checkButton.setOnAction(actionEvent -> {
            try {
                handleButtonClick();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
        Scene scene = new Scene(grid, 440, 240);
        stage.setMaximized(true);
        stage.setTitle("Wikipedia Revision Checker");
        stage.setScene(scene);
        stage.show();
    }

    private void handleButtonClick() throws IOException {
        String userEntry = titleToCheck.getText();
        URL wikiUrl = WikipediaRevisionReader.encodeURL(userEntry);
        InputStream wikiStream = null;
        try {
            wikiStream = WikipediaRevisionReader.getWikiStream(wikiUrl);
        }
        catch (IOException e) {
            revisions.setText("Try again when connected to the internet.");
            displayNetworkErrorDialog();
        }
        JSONArray wiki = WikipediaRevisionParser.parseJSON(wikiStream);
        if (userEntry.isEmpty()) {
            revisions.setText("No Value was entered.");
        }
        else if (WikipediaRevisionParser.parseRevisions(wiki).length==0) {
            revisions.setText("No Wikipedia page for that title was found.");
        }
        else {
            revisions.setText(WikipediaRevisionFormatter.formatter(wiki));
        }
    }

    private void displayNetworkErrorDialog(){
        Stage stage = new Stage();
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid);
        Text error = new Text("Network Connection Error");
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(error, 0, 0, 2, 1);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}
