package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import server.MyServer;

import java.io.IOException;

public class Controller {

    @FXML
    public Button send;

    @FXML
    public Button button2;
    public TextArea textArea;


    MyServer client = new MyServer();
    public Controller() throws IOException {
        client.startConnection("127.0.0.1", 7777);
    }

    public void click(ActionEvent actionEvent) throws IOException {
        String message = textArea.getText();
        String response = client.echoMessage(message);
        textArea.appendText(response);


    }

    public void click1(ActionEvent actionEvent) throws IOException {
        //button2.setDisable(true);
        String response = client.sendMessage("hello server");
        textArea.setText(response);
    }
}
