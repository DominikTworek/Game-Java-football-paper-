package game;

import com.jfoenix.controls.JFXTextField;
import functions.Windows;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NickNameController implements Initializable {

    @FXML
    private JFXTextField player1;

    @FXML
    private JFXTextField player2;

    private static Boolean sprComputer = false;

    public static void setSprComputer(Boolean sprComputer) {
        NickNameController.sprComputer = sprComputer;
    }


    private static String player1_name;

    public static String getPlayer1_name() {
        return player1_name;
    }

    public void setPlayer1_name(String player1_name) {
        this.player1_name = player1_name;
    }

    public static String getPlayer2_name() {
        return player2_name;
    }

    public void setPlayer2_name(String player2_name) {
        this.player2_name = player2_name;
    }

    private static String player2_name;

    @FXML
    void startGame(ActionEvent event) {
        try {
            player1_name = player1.getText();
            player2_name = player2.getText();
            Windows.changeScene(event, "../game/Player.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void test(ActionEvent event) {
        try {
            player1_name = player1.getText();
            player2_name = player2.getText();
            Windows.changeScene(event, "../game/ComputerTest.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(sprComputer.equals(true)){
            player2.setDisable(true);
        }
        else
            player2.setDisable(false);
    }
}
