package instruction;

import functions.Windows;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class InstructionController {
    @FXML
    void back(ActionEvent event) {
        try {
            Windows.changeScene(event, "../mainMenu/MainMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
