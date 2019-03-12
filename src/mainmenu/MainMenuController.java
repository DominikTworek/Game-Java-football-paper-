package mainmenu;

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

}
