package game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerController implements Initializable {

    @FXML
    private AnchorPane mainWindow;

    @FXML
    private AnchorPane mainGame;

    @FXML
    private AnchorPane gra;

    @FXML
    private ImageView gracz1aktywnosc;

    @FXML
    private ImageView gracz2aktywnosc;

    @FXML
    private AnchorPane tab01;

    @FXML
    private Line line;

    @FXML
    private Circle Point53;

    @FXML
    private Circle Point54;

    @FXML
    private Circle Point55;

    @FXML
    private Circle Point56;


    @FXML
    void Point56Click(MouseEvent event) {

    }


    //punkty X1-10  Y1-12
    //1 - aktywne
    int[][] aktywnosci = new int[11][13];
    int[][] dostepnosci = new int[11][13];
    int[][] odwiedzone = new int[11][13];
    int[][] laczenie_pionowe = new int[11][13];
    int[][] laczenie_poziome = new int[11][13];
    int[][] laczenie_skośne_lewe = new int[11][13];
    int[][] laczenie_skośne_prawe = new int[11][13];

    Boolean player1 = true;
    Boolean player2 = false;


    Boolean sprawdzenieLaczenia(int X, int Y) {
        if (laczenie_pionowe[X][Y] == 1) {
            return false;
        } else
            return true;
    }


    Boolean sprawdzenieDostepnosci(int X, int Y) {
        if (dostepnosci[X][Y] == 1) {
            return true;
        } else
            return false;
    }

    Boolean sprawdzenieAktywnosci(int X, int Y) {
        if (aktywnosci[X][Y] == 1) {
            return true;
        } else
            return false;
    }


    void zmianaDostepnosci() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 11; j++) {
                if (aktywnosci[i][j] == 1) {
                    dostepnosci[i][j + 1] = 1;
                    dostepnosci[i][j - 1] = 1;
                    dostepnosci[i + 1][j] = 1;
                    dostepnosci[i - 1][j] = 1;
                    dostepnosci[i + 1][j + 1] = 1;
                    dostepnosci[i - 1][j - 1] = 1;
                    dostepnosci[i - 1][j + 1] = 1;
                    dostepnosci[i + 1][j - 1] = 1;
                }
            }
        }
    }

    void zmianaGracza(int X, int Y) {
        if (player1.equals(true)) {
            if (odwiedzone[X][Y] == 1) {
                player1 = true;
                player2 = false;
                gracz1aktywnosc.setVisible(true);
                gracz2aktywnosc.setVisible(false);
            } else {
                player1 = false;
                player2 = true;
                gracz1aktywnosc.setVisible(false);
                gracz2aktywnosc.setVisible(true);
            }
        } else {
            if (odwiedzone[X][Y] == 1) {
                player2 = true;
                player1 = false;
                gracz1aktywnosc.setVisible(false);
                gracz2aktywnosc.setVisible(true);
            } else {
                player2 = false;
                player1 = true;
                gracz1aktywnosc.setVisible(true);
                gracz2aktywnosc.setVisible(false);
            }
        }
    }

    void drawLine(Circle circle, Circle circle2) {
        Line line = new Line();
        line.setStartX(circle.getLayoutX());
        line.setStartY(circle.getLayoutY());
        line.setEndX(circle2.getLayoutX());
        line.setEndY(circle2.getLayoutY());
        if (player1.equals(true))
            line.setStyle("-fx-stroke: #43ff04");
        else
            line.setStyle("-fx-stroke: #0efffc");
        mainGame.getChildren().add(line);
    }

    void danePunktu(int X, int Y) {
        aktywnosci[X][Y] = 1;
        zmianaGracza(X, Y);
        odwiedzone[X][Y] = 1;
        zmianaDostepnosci();
    }

    @FXML
    void Point55Click(MouseEvent event) {
        if (sprawdzenieDostepnosci(5, 5) && sprawdzenieLaczenia(5, 5) && aktywnosci[5][6] == 1) {
            aktywnosci[5][6] = 0;
            danePunktu(5, 5);
            drawLine(Point55, Point56);
            drawLine(Point55, Point56);
            laczenie_pionowe[5][5] = 1;
        }
        if (sprawdzenieDostepnosci(5, 5) && sprawdzenieLaczenia(5, 4) && aktywnosci[5][4] == 1) {
            aktywnosci[5][4] = 0;
            danePunktu(5, 5);
            drawLine(Point55, Point54);
            drawLine(Point55, Point54);
            laczenie_pionowe[5][4] = 1;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        aktywnosci[5][6] = 1;
        zmianaDostepnosci();
        gracz1aktywnosc.setVisible(true);
        gracz2aktywnosc.setVisible(false);

    }

    public void Point54Click(MouseEvent mouseEvent) {
        if (sprawdzenieDostepnosci(5, 4) && sprawdzenieLaczenia(5, 4) && aktywnosci[5][5] == 1) {
            aktywnosci[5][5] = 0;
            danePunktu(5, 4);
            drawLine(Point54, Point55);
            drawLine(Point54, Point55);
            laczenie_pionowe[5][4] = 1;
        }
        if (sprawdzenieDostepnosci(5, 4) && sprawdzenieLaczenia(5, 3) && aktywnosci[5][3] == 1) {
            aktywnosci[5][3] = 0;
            danePunktu(5, 4);
            drawLine(Point54, Point53);
            drawLine(Point54, Point53);
            laczenie_pionowe[5][4] = 1;
        }
    }

    public void Point53Click(MouseEvent mouseEvent) {
    }

}
