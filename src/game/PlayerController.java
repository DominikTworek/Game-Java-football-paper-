package game;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static game.NickNameController.getPlayer1_name;
import static game.NickNameController.getPlayer2_name;

public class PlayerController implements Initializable {

    @FXML
    private AnchorPane mainWindow;

    @FXML
    private AnchorPane test;

    @FXML
    private ImageView gracz1aktywnosc;

    @FXML
    private ImageView gracz2aktywnosc;

    @FXML
    private JFXTextField player1_name;

    @FXML
    private JFXTextField player2_name;

    @FXML
    private AnchorPane mainGame;

    @FXML
    private Circle Point32;

    @FXML
    private Circle Point33;

    @FXML
    private Circle Point34;

    @FXML
    private Circle Point35;

    @FXML
    private Circle Point36;

    @FXML
    private Circle Point37;

    @FXML
    private Circle Point38;

    @FXML
    private Circle Point39;

    @FXML
    private Circle Point310;

    @FXML
    private Circle Point311;

    @FXML
    private Circle Point22;

    @FXML
    private Circle Point12;

    @FXML
    private Circle Point42;

    @FXML
    private Circle Point52;

    @FXML
    private Circle Point62;

    @FXML
    private Circle Point72;

    @FXML
    private Circle Point82;

    @FXML
    private Circle Point92;

    @FXML
    private Circle Point31;

    @FXML
    private Circle Point21;

    @FXML
    private Circle Point41;

    @FXML
    private Circle Point51;

    @FXML
    private Circle Point61;

    @FXML
    private Circle Point71;

    @FXML
    private Circle Point81;

    @FXML
    private Circle Point23;

    @FXML
    private Circle Point13;

    @FXML
    private Circle Point43;

    @FXML
    private Circle Point53;

    @FXML
    private Circle Point63;

    @FXML
    private Circle Point73;

    @FXML
    private Circle Point83;

    @FXML
    private Circle Point93;

    @FXML
    private Circle Point24;

    @FXML
    private Circle Point14;

    @FXML
    private Circle Point44;

    @FXML
    private Circle Point54;

    @FXML
    private Circle Point64;

    @FXML
    private Circle Point74;

    @FXML
    private Circle Point84;

    @FXML
    private Circle Point94;

    @FXML
    private Circle Point25;

    @FXML
    private Circle Point15;

    @FXML
    private Circle Point45;

    @FXML
    private Circle Point55;

    @FXML
    private Circle Point65;

    @FXML
    private Circle Point75;

    @FXML
    private Circle Point85;

    @FXML
    private Circle Point95;

    @FXML
    private Circle Point56;

    @FXML
    private Circle Point26;

    @FXML
    private Circle Point16;

    @FXML
    private Circle Point46;

    @FXML
    private Circle Point66;

    @FXML
    private Circle Point76;

    @FXML
    private Circle Point86;

    @FXML
    private Circle Point96;

    @FXML
    private Circle Point27;

    @FXML
    private Circle Point17;

    @FXML
    private Circle Point47;

    @FXML
    private Circle Point57;

    @FXML
    private Circle Point67;

    @FXML
    private Circle Point77;

    @FXML
    private Circle Point87;

    @FXML
    private Circle Point97;

    @FXML
    private Circle Point28;

    @FXML
    private Circle Point18;

    @FXML
    private Circle Point48;

    @FXML
    private Circle Point58;

    @FXML
    private Circle Point68;

    @FXML
    private Circle Point78;

    @FXML
    private Circle Point88;

    @FXML
    private Circle Point98;

    @FXML
    private Circle Point29;

    @FXML
    private Circle Point19;

    @FXML
    private Circle Point49;

    @FXML
    private Circle Point59;

    @FXML
    private Circle Point69;

    @FXML
    private Circle Point79;

    @FXML
    private Circle Point89;

    @FXML
    private Circle Point99;

    @FXML
    private Circle Point210;

    @FXML
    private Circle Point110;

    @FXML
    private Circle Point410;

    @FXML
    private Circle Point510;

    @FXML
    private Circle Point610;

    @FXML
    private Circle Point710;

    @FXML
    private Circle Point810;

    @FXML
    private Circle Point910;

    @FXML
    private Circle Point211;

    @FXML
    private Circle Point411;

    @FXML
    private Circle Point511;

    @FXML
    private Circle Point611;

    @FXML
    private Circle Point711;

    @FXML
    private Circle Point811;

    @FXML
    private Circle Bramka1;

    @FXML
    private Circle Bramka2;


    //punkty X1-10  Y1-12
    //1 - aktywne
    int[][] aktywnosci = new int[11][13];
    int[][] dostepnosci = new int[11][13];
    int[][] odwiedzone = new int[11][13];
    int[][] laczenie_pionowe = new int[11][13];
    int[][] laczenie_poziome = new int[11][13];
    int[][] laczenie_skosne_lewe = new int[11][13];
    int[][] laczenie_skosne_prawe = new int[11][13];

    Boolean player1 = true;
    Boolean player2 = false;


    Boolean sprawdzenieLaczeniaPionowego(int X, int Y) {
        if (laczenie_pionowe[X][Y] == 1) {
            return false;
        } else
            return true;
    }

    Boolean sprawdzenieLaczeniaPoziomego(int X, int Y) {
        if (laczenie_poziome[X][Y] == 1) {
            return false;
        } else
            return true;
    }

    Boolean sprawdzenieLaczeniaSkosneLewe(int X, int Y) {
        if (laczenie_skosne_lewe[X][Y] == 1) {
            return false;
        } else
            return true;
    }

    Boolean sprawdzenieLaczeniaSkosnePrawe(int X, int Y) {
        if (laczenie_skosne_prawe[X][Y] == 1) {
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
        dostepnosc(aktywnosci, dostepnosci);
    }

    static void dostepnosc(int[][] aktywnosci, int[][] dostepnosci) {
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
                player1 = false;
                player2 = true;
                gracz1aktywnosc.setVisible(false);
                gracz2aktywnosc.setVisible(true);
            } else {
                player1 = true;
                player2 = false;
                gracz1aktywnosc.setVisible(true);
                gracz2aktywnosc.setVisible(false);
            }
        }
    }

    static void line(Circle circle, Circle circle2, Boolean player1, AnchorPane mainGame) {
        Line line = new Line();
        line.setStartX(circle.getLayoutX());
        line.setStartY(circle.getLayoutY());
        line.setEndX(circle2.getLayoutX());
        line.setEndY(circle2.getLayoutY());
        line.toBack();
        if (player1.equals(true))
            line.setStyle("-fx-stroke: #43ff04");
        else
            line.setStyle("-fx-stroke: #0efffc");
        mainGame.getChildren().add(line);
    }

    void reset_gry(){
        for(int i=0; i<= 10; i++){
            for(int j =0; j <=12; j++){
                aktywnosci[i][j] = 0;
                dostepnosci[i][j] = 0;
                odwiedzone[i][j] = 0;
                laczenie_pionowe[i][j] = 0;
                laczenie_poziome[i][j] = 0;
                laczenie_skosne_lewe[i][j] = 0;
                laczenie_skosne_prawe[i][j] = 0;
            }
        }
        test.getChildren().clear();
        ustawianie_wstepne();
    }

    void drawLine2(Circle circle, int X, int Y) {
        line2(circle, X, Y, player1, test);
    }

    static void line2(Circle circle, int X, int Y, Boolean player1, AnchorPane mainGame) {
        Line line = new Line();
        line.setStartX(circle.getLayoutX());
        line.setStartY(circle.getLayoutY());
        line.setEndX(circle.getLayoutX() + X);
        line.setEndY(circle.getLayoutY() + Y);
        if (player1.equals(true))
            line.setStyle("-fx-stroke: #43ff04");
        else
            line.setStyle("-fx-stroke: #0efffc");
        mainGame.getChildren().add(line);
    }

    void alert(String Title, String Text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(Title);
        ButtonType buttonTypeOne = new ButtonType("Graj");
        ButtonType buttonTypeTwo = new ButtonType("Wyjdź");
        if(aktywnosci[5][0] == 1) {
            alert.setHeaderText("Gratulacje!! Gracz " + getPlayer2_name() + " wygrał grę");
        }else
            alert.setHeaderText("Gratulacje!! Gracz " + getPlayer1_name() + " wygrał grę");
        alert.setResizable(false);
        alert.setContentText(Text);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("../resources/winner.png").toString()));
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("../functions/loyout.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        Optional<ButtonType> result = alert.showAndWait();
        ButtonType button = result.orElse(ButtonType.OK);
        if (result.get() == buttonTypeOne) {
            reset_gry();
        }
        else {
            System.exit(0);
        }
    }

    void danePunktu(int X, int Y) {
        aktywnosci[X][Y] = 1;
        zmianaGracza(X, Y);
        odwiedzone[X][Y] = 1;
        zmianaDostepnosci();
        if (aktywnosci[5][0] == 1) {
            alert("Wygrana!", "Wygrał Gracz2, Gratulacje!");
        }
        if (aktywnosci[5][12] == 1) {
            alert("Wygrana!", "Wygrał Gracz1, Gratulacje!");
        }
    }

    void engine(Circle circle, int X, int Y) {
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaPionowego(X, Y) && aktywnosci[X][Y + 1] == 1) {
            aktywnosci[X][Y + 1] = 0;
            drawLine2(circle, 0, +42);
            drawLine2(circle, 0, +42);
            laczenie_pionowe[X][Y] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaPionowego(X, Y - 1) && aktywnosci[X][Y - 1] == 1) {
            aktywnosci[X][Y - 1] = 0;
            drawLine2(circle, 0, -42);
            drawLine2(circle, 0, -42);
            laczenie_pionowe[X][Y - 1] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaPoziomego(X - 1, Y) && aktywnosci[X - 1][Y] == 1) {
            aktywnosci[X - 1][Y] = 0;
            drawLine2(circle, -51, 0);
            drawLine2(circle, -51, 0);
            laczenie_poziome[X - 1][Y] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaPoziomego(X, Y) && aktywnosci[X + 1][Y] == 1) {
            aktywnosci[X + 1][Y] = 0;
            drawLine2(circle, +51, 0);
            drawLine2(circle, +51, 0);
            laczenie_poziome[X][Y] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosneLewe(X - 1, Y - 1) && aktywnosci[X - 1][Y - 1] == 1) {
            aktywnosci[X - 1][Y - 1] = 0;
            drawLine2(circle, -50, -42);
            drawLine2(circle, -50, -42);
            laczenie_skosne_lewe[X - 1][Y - 1] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosneLewe(X, Y) && aktywnosci[X + 1][Y + 1] == 1) {
            aktywnosci[X + 1][Y + 1] = 0;
            drawLine2(circle, +50, +42);
            drawLine2(circle, +50, +42);
            laczenie_skosne_lewe[X][Y] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosnePrawe(X - 1, Y) && aktywnosci[X - 1][Y + 1] == 1) {
            aktywnosci[X - 1][Y + 1] = 0;
            drawLine2(circle, -50, +42);
            drawLine2(circle, -50, +42);
            laczenie_skosne_prawe[X - 1][Y] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosnePrawe(X, Y - 1) && aktywnosci[X + 1][Y - 1] == 1) {
            aktywnosci[X + 1][Y - 1] = 0;
            drawLine2(circle, +50, -42);
            drawLine2(circle, +50, -42);
            laczenie_skosne_prawe[X][Y - 1] = 1;
            danePunktu(X, Y);
        }
    }

    void engine_poziome(Circle circle, int X, int Y) {
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaPionowego(X, Y) && aktywnosci[X][Y + 1] == 1) {
            aktywnosci[X][Y + 1] = 0;
            drawLine2(circle, 0, +42);
            drawLine2(circle, 0, +42);
            laczenie_pionowe[X][Y] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaPionowego(X, Y - 1) && aktywnosci[X][Y - 1] == 1) {
            aktywnosci[X][Y - 1] = 0;
            drawLine2(circle, 0, -42);
            drawLine2(circle, 0, -42);
            laczenie_pionowe[X][Y - 1] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaPoziomego(X - 1, Y) && aktywnosci[X - 1][Y] == 1) {
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaPoziomego(X, Y) && aktywnosci[X + 1][Y] == 1) {
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosneLewe(X - 1, Y - 1) && aktywnosci[X - 1][Y - 1] == 1) {
            aktywnosci[X - 1][Y - 1] = 0;
            drawLine2(circle, -50, -42);
            drawLine2(circle, -50, -42);
            laczenie_skosne_lewe[X - 1][Y - 1] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosneLewe(X, Y) && aktywnosci[X + 1][Y + 1] == 1) {
            aktywnosci[X + 1][Y + 1] = 0;
            drawLine2(circle, +50, +42);
            drawLine2(circle, +50, +42);
            laczenie_skosne_lewe[X][Y] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosnePrawe(X - 1, Y) && aktywnosci[X - 1][Y + 1] == 1) {
            aktywnosci[X - 1][Y + 1] = 0;
            drawLine2(circle, -50, +42);
            drawLine2(circle, -50, +42);
            laczenie_skosne_prawe[X - 1][Y] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosnePrawe(X, Y - 1) && aktywnosci[X + 1][Y - 1] == 1) {
            aktywnosci[X + 1][Y - 1] = 0;
            drawLine2(circle, +50, -42);
            drawLine2(circle, +50, -42);
            laczenie_skosne_prawe[X][Y - 1] = 1;
            danePunktu(X, Y);
        }
    }

    void engine_pionowe(Circle circle, int X, int Y) {
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaPionowego(X, Y) && aktywnosci[X][Y + 1] == 1) {
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaPionowego(X, Y - 1) && aktywnosci[X][Y - 1] == 1) {
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaPoziomego(X - 1, Y) && aktywnosci[X - 1][Y] == 1) {
            aktywnosci[X - 1][Y] = 0;
            drawLine2(circle, -51, 0);
            drawLine2(circle, -51, 0);
            laczenie_poziome[X - 1][Y] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaPoziomego(X, Y) && aktywnosci[X + 1][Y] == 1) {
            aktywnosci[X + 1][Y] = 0;
            drawLine2(circle, +51, 0);
            drawLine2(circle, +51, 0);
            laczenie_poziome[X][Y] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosneLewe(X - 1, Y - 1) && aktywnosci[X - 1][Y - 1] == 1) {
            aktywnosci[X - 1][Y - 1] = 0;
            drawLine2(circle, -50, -42);
            drawLine2(circle, -50, -42);
            laczenie_skosne_lewe[X - 1][Y - 1] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosneLewe(X, Y) && aktywnosci[X + 1][Y + 1] == 1) {
            aktywnosci[X + 1][Y + 1] = 0;
            drawLine2(circle, +50, +42);
            drawLine2(circle, +50, +42);
            laczenie_skosne_lewe[X][Y] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosnePrawe(X - 1, Y) && aktywnosci[X - 1][Y + 1] == 1) {
            aktywnosci[X - 1][Y + 1] = 0;
            drawLine2(circle, -50, +42);
            drawLine2(circle, -50, +42);
            laczenie_skosne_prawe[X - 1][Y] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosnePrawe(X, Y - 1) && aktywnosci[X + 1][Y - 1] == 1) {
            aktywnosci[X + 1][Y - 1] = 0;
            drawLine2(circle, +50, -42);
            drawLine2(circle, +50, -42);
            laczenie_skosne_prawe[X][Y - 1] = 1;
            danePunktu(X, Y);
        }
    }

    void engine_bramka1(Circle circle, int X, int Y) {
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaPionowego(X, Y) && aktywnosci[X][Y + 1] == 1) {
            aktywnosci[X][Y + 1] = 0;
            drawLine2(circle, 0, +42);
            drawLine2(circle, 0, +42);
            laczenie_pionowe[X][Y] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosneLewe(X, Y) && aktywnosci[X + 1][Y + 1] == 1) {
            aktywnosci[X + 1][Y + 1] = 0;
            drawLine2(circle, +50, +42);
            drawLine2(circle, +50, +42);
            laczenie_skosne_lewe[X][Y] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosnePrawe(X - 1, Y) && aktywnosci[X - 1][Y + 1] == 1) {
            aktywnosci[X - 1][Y + 1] = 0;
            drawLine2(circle, -50, +42);
            drawLine2(circle, -50, +42);
            laczenie_skosne_prawe[X - 1][Y] = 1;
            danePunktu(X, Y);
        }
    }

    void engine_bramka2(Circle circle, int X, int Y) {
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaPionowego(X, Y - 1) && aktywnosci[X][Y - 1] == 1) {
            aktywnosci[X][Y - 1] = 0;
            drawLine2(circle, 0, -42);
            drawLine2(circle, 0, -42);
            laczenie_pionowe[X][Y - 1] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosneLewe(X - 1, Y - 1) && aktywnosci[X - 1][Y - 1] == 1) {
            aktywnosci[X - 1][Y - 1] = 0;
            drawLine2(circle, -50, -42);
            drawLine2(circle, -50, -42);
            laczenie_skosne_lewe[X - 1][Y - 1] = 1;
            danePunktu(X, Y);
        }
        if (sprawdzenieDostepnosci(X, Y) && sprawdzenieLaczeniaSkosnePrawe(X, Y - 1) && aktywnosci[X + 1][Y - 1] == 1) {
            aktywnosci[X + 1][Y - 1] = 0;
            drawLine2(circle, +50, -42);
            drawLine2(circle, +50, -42);
            laczenie_skosne_prawe[X][Y - 1] = 1;
            danePunktu(X, Y);
        }
    }

    @FXML
    void Point110Click(MouseEvent event) {
        engine_pionowe(Point110, 1, 10);
    }

    @FXML
    void Point12Click(MouseEvent event) {
        engine_pionowe(Point12, 1, 2);
    }

    @FXML
    void Point13Click(MouseEvent event) {
        engine_pionowe(Point13, 1, 3);
    }

    @FXML
    void Point14Click(MouseEvent event) {
        engine_pionowe(Point14, 1, 4);
    }

    @FXML
    void Point15Click(MouseEvent event) {
        engine_pionowe(Point15, 1, 5);
    }

    @FXML
    void Point16Click(MouseEvent event) {
        engine_pionowe(Point16, 1, 6);
    }

    @FXML
    void Point17Click(MouseEvent event) {
        engine_pionowe(Point17, 1, 7);
    }

    @FXML
    void Point18Click(MouseEvent event) {
        engine_pionowe(Point18, 1, 8);
    }

    @FXML
    void Point19Click(MouseEvent event) {
        engine_pionowe(Point19, 1, 9);
    }

    @FXML
    void Point210Click(MouseEvent event) {
        engine(Point210, 2, 10);
    }

    @FXML
    void Point211Click(MouseEvent event) {
        engine_poziome(Point211, 2, 11);
    }

    @FXML
    void Point21Click(MouseEvent event) {
        engine_poziome(Point21, 2, 1);
    }

    @FXML
    void Point22Click(MouseEvent event) {
        engine(Point22, 2, 2);
    }

    @FXML
    void Point23Click(MouseEvent event) {
        engine(Point23, 2, 3);
    }

    @FXML
    void Point24Click(MouseEvent event) {
        engine(Point24, 2, 4);
    }

    @FXML
    void Point25Click(MouseEvent event) {
        engine(Point25, 2, 5);
    }

    @FXML
    void Point26Click(MouseEvent event) {
        engine(Point26, 2, 6);
    }

    @FXML
    void Point27Click(MouseEvent event) {
        engine(Point27, 2, 7);
    }

    @FXML
    void Point28Click(MouseEvent event) {
        engine(Point28, 2, 8);
    }

    @FXML
    void Point29Click(MouseEvent event) {
        engine(Point29, 2, 9);
    }

    @FXML
    void Point310Click(MouseEvent event) {
        engine_poziome(Point310, 3, 10);
    }

    @FXML
    void Point311Click(MouseEvent event) {
        engine_poziome(Point311, 3, 11);
    }

    @FXML
    void Point31Click(MouseEvent event) {
        engine(Point31, 3, 1);
    }

    @FXML
    void Point32Click(MouseEvent event) {
        engine(Point32, 3, 2);
    }

    @FXML
    void Point33Click(MouseEvent event) {
        engine(Point33, 3, 3);
    }

    @FXML
    void Point34Click(MouseEvent event) {
        engine(Point34, 3, 4);
    }

    @FXML
    void Point35Click(MouseEvent event) {
        engine(Point35, 3, 5);
    }

    @FXML
    void Point36Click(MouseEvent event) {
        engine(Point36, 3, 6);
    }

    @FXML
    void Point37Click(MouseEvent event) {
        engine(Point37, 3, 7);
    }

    @FXML
    void Point38Click(MouseEvent event) {
        engine(Point38, 3, 8);
    }

    @FXML
    void Point39Click(MouseEvent event) {
        engine(Point39, 3, 9);
    }

    @FXML
    void Point410Click(MouseEvent event) {
        engine(Point410, 4, 10);
    }

    @FXML
    void Point411Click(MouseEvent event) {
        engine_poziome(Point411, 4, 11);
    }

    @FXML
    void Point41Click(MouseEvent event) {
        engine_poziome(Point41, 4, 1);
    }

    @FXML
    void Point42Click(MouseEvent event) {
        engine(Point42, 4, 2);
    }

    @FXML
    void Point43Click(MouseEvent event) {
        engine(Point43, 4, 3);
    }

    @FXML
    void Point44Click(MouseEvent event) {
        engine(Point44, 4, 4);
    }

    @FXML
    void Point45Click(MouseEvent event) {
        engine(Point45, 4, 5);
    }

    @FXML
    void Point46Click(MouseEvent event) {
        engine(Point46, 4, 6);
    }

    @FXML
    void Point47Click(MouseEvent event) {
        engine(Point47, 4, 7);
    }

    @FXML
    void Point48Click(MouseEvent event) {
        engine(Point48, 4, 8);
    }

    @FXML
    void Point49Click(MouseEvent event) {
        engine(Point49, 4, 9);
    }

    @FXML
    void Point510Click(MouseEvent event) {
        engine(Point510, 5, 10);
    }

    @FXML
    void Point511Click(MouseEvent event) {
        engine_poziome(Point511, 5, 11);
    }

    @FXML
    void Point51Click(MouseEvent event) {
        engine_poziome(Point51, 5, 1);
    }

    @FXML
    void Point52Click(MouseEvent event) {
        engine(Point52, 5, 2);
    }

    @FXML
    void Point53Click(MouseEvent event) {
        engine(Point53, 5, 3);
    }

    @FXML
    void Point54Click(MouseEvent event) {
        engine(Point54, 5, 4);
    }

    @FXML
    void Point55Click(MouseEvent event) {
        engine(Point55, 5, 5);
    }

    @FXML
    void Point56Click(MouseEvent event) {
        engine(Point56, 5, 6);
    }

    @FXML
    void Point57Click(MouseEvent event) {
        engine(Point57, 5, 7);
    }

    @FXML
    void Point58Click(MouseEvent event) {
        engine(Point58, 5, 8);
    }

    @FXML
    void Point59Click(MouseEvent event) {
        engine(Point59, 5, 9);
    }

    @FXML
    void Point610Click(MouseEvent event) {
        engine(Point610, 6, 10);
    }

    @FXML
    void Point611Click(MouseEvent event) {
        engine_poziome(Point611, 6, 11);
    }

    @FXML
    void Point61Click(MouseEvent event) {
        engine_poziome(Point61, 6, 1);
    }

    @FXML
    void Point62Click(MouseEvent event) {
        engine(Point62, 6, 2);
    }

    @FXML
    void Point63Click(MouseEvent event) {
        engine(Point63, 6, 3);
    }

    @FXML
    void Point64Click(MouseEvent event) {
        engine(Point64, 6, 4);
    }

    @FXML
    void Point65Click(MouseEvent event) {
        engine(Point65, 6, 5);
    }

    @FXML
    void Point66Click(MouseEvent event) {
        engine(Point66, 6, 6);
    }

    @FXML
    void Point67Click(MouseEvent event) {
        engine(Point67, 6, 7);
    }

    @FXML
    void Point68Click(MouseEvent event) {
        engine(Point68, 6, 8);
    }

    @FXML
    void Point69Click(MouseEvent event) {
        engine(Point69, 6, 9);
    }

    @FXML
    void Point710Click(MouseEvent event) {
        engine(Point710, 7, 10);
    }

    @FXML
    void Point711Click(MouseEvent event) {
        engine_poziome(Point711, 7, 11);
    }

    @FXML
    void Point71Click(MouseEvent event) {
        engine_poziome(Point71, 7, 1);
    }

    @FXML
    void Point72Click(MouseEvent event) {
        engine(Point72, 7, 2);
    }

    @FXML
    void Point73Click(MouseEvent event) {
        engine(Point73, 7, 3);
    }

    @FXML
    void Point74Click(MouseEvent event) {
        engine(Point74, 7, 4);
    }

    @FXML
    void Point75Click(MouseEvent event) {
        engine(Point75, 7, 5);
    }

    @FXML
    void Point76Click(MouseEvent event) {
        engine(Point76, 7, 6);
    }

    @FXML
    void Point77Click(MouseEvent event) {
        engine(Point77, 7, 7);
    }

    @FXML
    void Point78Click(MouseEvent event) {
        engine(Point78, 7, 8);
    }

    @FXML
    void Point79Click(MouseEvent event) {
        engine(Point79, 7, 9);
    }

    @FXML
    void Point810Click(MouseEvent event) {
        engine(Point810, 8, 10);
    }

    @FXML
    void Point811Click(MouseEvent event) {
        engine_poziome(Point811, 8, 11);
    }

    @FXML
    void Point81Click(MouseEvent event) {
        engine_poziome(Point81, 8, 1);
    }

    @FXML
    void Point82Click(MouseEvent event) {
        engine(Point82, 8, 2);
    }

    @FXML
    void Point83Click(MouseEvent event) {
        engine(Point83, 8, 3);
    }

    @FXML
    void Point84Click(MouseEvent event) {
        engine(Point84, 8, 4);
    }

    @FXML
    void Point85Click(MouseEvent event) {
        engine(Point85, 8, 5);
    }

    @FXML
    void Point86Click(MouseEvent event) {
        engine(Point86, 8, 6);
    }

    @FXML
    void Point87Click(MouseEvent event) {
        engine(Point87, 8, 7);
    }

    @FXML
    void Point88Click(MouseEvent event) {
        engine(Point88, 8, 8);
    }

    @FXML
    void Point89Click(MouseEvent event) {
        engine(Point89, 8, 9);
    }

    @FXML
    void Point910Click(MouseEvent event) {
        engine_pionowe(Point910, 9, 10);
    }

    @FXML
    void Point92Click(MouseEvent event) {
        engine_pionowe(Point92, 9, 2);
    }

    @FXML
    void Point93Click(MouseEvent event) {
        engine_pionowe(Point93, 9, 3);
    }

    @FXML
    void Point94Click(MouseEvent event) {
        engine_pionowe(Point94, 9, 4);
    }

    @FXML
    void Point95Click(MouseEvent event) {
        engine_pionowe(Point95, 9, 5);
    }

    @FXML
    void Point96Click(MouseEvent event) {
        engine_pionowe(Point96, 9, 6);
    }

    @FXML
    void Point97Click(MouseEvent event) {
        engine_pionowe(Point97, 9, 7);
    }

    @FXML
    void Point98Click(MouseEvent event) {
        engine_pionowe(Point98, 9, 8);
    }

    @FXML
    void Point99Click(MouseEvent event) {
        engine_pionowe(Point99, 9, 9);
    }

    @FXML
    void Bramka1Click(MouseEvent event) {
        engine_bramka1(Bramka1, 5, 0);
    }

    @FXML
    void Bramka2Click(MouseEvent event) {
        engine_bramka2(Bramka2, 5, 12);
    }

    void ustawianie_wstepne(){
        aktywnosci[5][6] = 1;
        odwiedzone[5][6] = 1;
        odwiedzone[1][2] = 1;
        odwiedzone[1][3] = 1;
        odwiedzone[1][4] = 1;
        odwiedzone[1][5] = 1;
        odwiedzone[1][6] = 1;
        odwiedzone[1][7] = 1;
        odwiedzone[1][8] = 1;
        odwiedzone[1][9] = 1;
        odwiedzone[1][10] = 1;
        odwiedzone[9][2] = 1;
        odwiedzone[9][3] = 1;
        odwiedzone[9][4] = 1;
        odwiedzone[9][5] = 1;
        odwiedzone[9][6] = 1;
        odwiedzone[9][7] = 1;
        odwiedzone[9][8] = 1;
        odwiedzone[9][9] = 1;
        odwiedzone[9][10] = 1;
        odwiedzone[2][1] = 1;
        odwiedzone[3][1] = 1;
        odwiedzone[4][1] = 1;
        odwiedzone[6][1] = 1;
        odwiedzone[7][1] = 1;
        odwiedzone[8][1] = 1;
        odwiedzone[2][11] = 1;
        odwiedzone[3][11] = 1;
        odwiedzone[4][11] = 1;
        odwiedzone[6][11] = 1;
        odwiedzone[7][11] = 1;
        odwiedzone[8][11] = 1;
        zmianaDostepnosci();
        gracz1aktywnosc.setVisible(true);
        gracz2aktywnosc.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ustawianie_wstepne();
        player1_name.setText(getPlayer1_name());
        player2_name.setText(getPlayer2_name());
    }


}
