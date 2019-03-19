package startGame;

import functions.Windows;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class StartGameController {

    @FXML
    void gameComputer(ActionEvent event) {
        try {
            Windows.changeScene(event, "../game/Computer.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gamePlayer(ActionEvent event) {
        try {
            Windows.changeScene(event, "../game/Player.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back(ActionEvent event) {
        try {
            Windows.changeScene(event, "../mainMenu/MainMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
