package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        Button myButton = new Button("My Button");
        StackPane stackPane = new StackPane(myButton);

        Scene scene = new Scene(stackPane, 800, 600);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();


        //Equivalent code using an inner class instead of EventHandler.
        myButton.setOnAction((ActionEvent a) -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
                primaryStage.setScene(new Scene(root));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
//                frame.toFront();
        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
