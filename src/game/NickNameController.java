package game;

import com.jfoenix.controls.JFXTextField;
import functions.Windows;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class NickNameController {

    @FXML
    private JFXTextField player1;

    @FXML
    private JFXTextField player2;

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
}
