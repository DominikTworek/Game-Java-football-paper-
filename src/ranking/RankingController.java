package ranking;

import functions.Windows;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class RankingController {



    @FXML
    public void ComputerRanking(ActionEvent event) {
        try {
            Windows.changeScene(event, "../ranking/RankingView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        RankingViewController.setSprComputer(true);
    }

    @FXML
    public void PlayerRanking(ActionEvent event) {
        try {
            Windows.changeScene(event, "../ranking/RankingView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
