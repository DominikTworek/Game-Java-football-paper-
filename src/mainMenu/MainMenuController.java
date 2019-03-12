package mainMenu;

import functions.Windows;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainMenuController {

    @FXML
    void clickInstruction(ActionEvent event) {
        try {
            Windows.changeScene(event, "../instruction/Instruction.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    public void startGame(ActionEvent event) {
        try {
            Windows.changeScene(event, "../startGame/StartGame.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void back(ActionEvent event) {
        try {
            Windows.changeScene(event, "../mainMenu/MainMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gamePlayer(ActionEvent event) {
    }

    public void gameComputer(ActionEvent event) {
    }
}
