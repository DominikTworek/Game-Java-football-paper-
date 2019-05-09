package startGame;

import functions.Windows;
import game.NickNameController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartGameController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    void gameComputer(ActionEvent event) {
        try {
            NickNameController.setSprComputer(true);
            Windows.changeScene(event, "../game/NickName.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gamePlayer(ActionEvent event) {
        try {
            Windows.changeScene(event, "../game/NickName.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gameOnline(ActionEvent event) {
        try {
            Windows.changeScene(event, "../game/Online.fxml");
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
