package game;

import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import static game.NickNameController.getPlayer1_name;
import static game.NickNameController.getPlayer2_name;

public class ComputerTest implements Initializable {

    @FXML
    public JFXTextField player1_name;
    @FXML
    public JFXTextField player2_name;
    @FXML
    public ImageView gracz1aktywnosc;
    @FXML
    public ImageView gracz2aktywnosc;
    @FXML
    public AnchorPane mainGame;
    @FXML
    public AnchorPane test;

    private Line line = null;

    private Boolean turnComputer = false;

    private String circleLastID = "45";
    private String circleActualID = "";

    List<String> listLine = new ArrayList<String>();
    List<String> listVisited = new ArrayList<String>();

    private Boolean gameStatus = true;


    void restart_game(){
        listVisited.clear();
        listVisited.clear();
        mainGame.getChildren().clear();
        CircleEngine();
        setStartTurn();
    }

    void alert(String Title, String Text, Boolean Computer){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(Title);
        ButtonType buttonTypeOne = new ButtonType("Graj");
        ButtonType buttonTypeTwo = new ButtonType("Wyjdź");
        alert.setResizable(false);
        alert.setContentText(Text);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
        if(Computer){
            alert.setHeaderText("Gratulacje!! " + getPlayer2_name() + " wygrał grę");
        }else{
            alert.setHeaderText("Gratulacje!! " + getPlayer1_name() + " wygrał grę");
        }
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("../resources/winner.png").toString()));
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("../functions/loyout.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        Optional<ButtonType> result = alert.showAndWait();
        ButtonType button = result.orElse(ButtonType.OK);
        if (result.get() == buttonTypeOne) {
            restart_game();
        }
        else {
            System.exit(0);
        }

    }

    void drawline(Circle currentCircle, Circle lastCircle) {
        line = new Line();
        line.setStartX(currentCircle.getCenterX());
        line.setStartY(currentCircle.getCenterY());
        line.setEndX(lastCircle.getCenterX());
        line.setEndY(lastCircle.getCenterY());
        if (Integer.valueOf(currentCircle.getId()) < Integer.valueOf(lastCircle.getId())) {
            listLine.add(currentCircle.getId() + lastCircle.getId());
            line.setId(currentCircle.getId() + lastCircle.getId());

        } else {
            line.setId(lastCircle.getId() + currentCircle.getId());
            listLine.add(lastCircle.getId() + currentCircle.getId());
        }
        if (turnComputer.equals(true))
            line.setStyle("-fx-stroke: #0efffc");
        else
            line.setStyle("-fx-stroke: #43ff04");
        test.getChildren().add(line);
    }


    void colorPoint(int x, int y, Circle circle) {
        if (x == 0 && y == 0 || x == 8 && y == 10 || x == 0 && y == 10 || x == 8 && y == 0) {
            circle.setDisable(true);
            circle.setVisible(false);
        }
        if (x == 0 || x == 8 || y == 0 || y == 10) {
            circle.setFill(Color.ORANGERED);
            listVisited.add(String.valueOf("" + x + y));
        }
        if (x == 4) {
            circle.setFill(Color.ORANGE);
            listVisited.remove(String.valueOf("" + x + y));
        }
        if (x == 4 && y == 5) {
            circle.setFill(Color.ORANGERED);
            circle.setRadius(8);
            listVisited.add(String.valueOf("" + x + y));
        }
    }

    void setStartTurn() {
        gracz1aktywnosc.setVisible(true);
        gracz2aktywnosc.setVisible(false);
        listVisited.add("45");
    }

    void setTurn(Circle currentCircle) {
        String color = String.valueOf(currentCircle.getFill());
        if (turnComputer.equals(true)) {
            if (color.equals("0xff4500ff")) {
                turnComputer = true;
                gracz1aktywnosc.setVisible(false);
                gracz2aktywnosc.setVisible(true);
            } else {
                turnComputer = false;
                gracz1aktywnosc.setVisible(true);
                gracz2aktywnosc.setVisible(false);
            }
        } else {
            if (color.equals("0xff4500ff")) {
                turnComputer = false;
                gracz1aktywnosc.setVisible(true);
                gracz2aktywnosc.setVisible(false);
            } else {
                turnComputer = true;
                gracz1aktywnosc.setVisible(false);
                gracz2aktywnosc.setVisible(true);
            }
        }
    }

    void setColorVisited() {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 10; j++) {
                if (listVisited.contains(String.valueOf("" + String.valueOf(i) + String.valueOf(j)))) {
                    Circle circle = (Circle) mainGame.lookup('#' + String.valueOf(i) + String.valueOf(j));
                    circle.setFill(Color.ORANGERED);
                }
            }
        }
    }

    void computerPoint(Circle currentCircle, Circle newCircle, String lineID) {
        Circle nC = (Circle) mainGame.lookup('#' + circleActualID);
        drawline(nC, newCircle);
        circleActualID = newCircle.getId();
        circleLastID = newCircle.getId();
        enablePoint(newCircle);
        setTurn(newCircle);
        listVisited.add(newCircle.getId());
        listLine.add(lineID);
        setColorVisited();
        newCircle.setFill(Color.AQUA);
    }

    void computerEngine() {
        Circle currentCircle = (Circle) mainGame.lookup('#' + circleActualID);
        Integer idCR = Integer.valueOf(circleActualID) + 10;
        Integer idCL = Integer.valueOf(circleActualID) - 10;
        Integer idCU = Integer.valueOf(circleActualID) - 1;
        Integer idCD = Integer.valueOf(circleActualID) + 1;
        Integer idCS1 = Integer.valueOf(circleActualID) + 9;
        Integer idCS2 = Integer.valueOf(circleActualID) - 11;
        Integer idCS3 = Integer.valueOf(circleActualID) - 9;
        Integer idCS4 = Integer.valueOf(circleActualID) + 11;
        Circle CR = null;
        Circle CL = null;
        Circle CS1 = null;
        Circle CS2 = null;
        Circle CS3 = null;
        Circle CS4 = null;
        Circle CU = null;
        Circle CD = null;
        Integer actualID = Integer.valueOf(currentCircle.getId());
        if (actualID < 20 && actualID > 10) {
            CL = (Circle) mainGame.lookup('#' + "0" + String.valueOf(idCL));
            CU = (Circle) mainGame.lookup('#' + String.valueOf(idCU));
            CD = (Circle) mainGame.lookup('#' + String.valueOf(idCD));
            CR = (Circle) mainGame.lookup('#' + String.valueOf(idCR));
            CS2 = (Circle) mainGame.lookup('#' + "0" + String.valueOf(idCS2));
            CS3 = (Circle) mainGame.lookup('#' + "0" + String.valueOf(idCS3));
            CS1 = (Circle) mainGame.lookup('#' + String.valueOf(idCS1));
            CS4 = (Circle) mainGame.lookup('#' + String.valueOf(idCS4));

        } else if (actualID <= 10) {
            CL = (Circle) mainGame.lookup('#' + "0" + String.valueOf(idCL));
            CU = (Circle) mainGame.lookup('#' + "0" + String.valueOf(idCU));
            CD = (Circle) mainGame.lookup('#' + "0" + String.valueOf(idCD));
            CR = (Circle) mainGame.lookup('#' + String.valueOf(idCR));
            CS2 = (Circle) mainGame.lookup('#' + "0" + String.valueOf(idCS2));
            CS3 = (Circle) mainGame.lookup('#' + "0" + String.valueOf(idCS3));
            CS1 = (Circle) mainGame.lookup('#' + String.valueOf(idCS1));
            CS4 = (Circle) mainGame.lookup('#' + String.valueOf(idCS4));

        } else {
            CL = (Circle) mainGame.lookup('#' + String.valueOf(idCL));
            CU = (Circle) mainGame.lookup('#' + String.valueOf(idCU));
            CD = (Circle) mainGame.lookup('#' + String.valueOf(idCD));
            CR = (Circle) mainGame.lookup('#' + String.valueOf(idCR));
            CS2 = (Circle) mainGame.lookup('#' + String.valueOf(idCS2));
            CS3 = (Circle) mainGame.lookup('#' + String.valueOf(idCS3));
            CS1 = (Circle) mainGame.lookup('#' + String.valueOf(idCS1));
            CS4 = (Circle) mainGame.lookup('#' + String.valueOf(idCS4));

        }
        String lR = null;
        String lU = null;
        String lL = null;
        String lD = null;
        String lS1 = null;
        String lS2 = null;
        String lS3 = null;
        String lS4 = null;

        if (Integer.valueOf(currentCircle.getId()) < 10) {
            lR = String.valueOf("" + Integer.valueOf(currentCircle.getId() + CR.getId()));
            lS1 = String.valueOf("" + Integer.valueOf(currentCircle.getId() + CS1.getId()));
            lS4 = String.valueOf("" + Integer.valueOf(currentCircle.getId() + CS4.getId()));
        } else if (Integer.valueOf(currentCircle.getId()) == 10 || Integer.valueOf(currentCircle.getId()) == 20) {
            lD = String.valueOf("" + Integer.valueOf(currentCircle.getId() + CD.getId()));
            lS4 = String.valueOf("" + Integer.valueOf(currentCircle.getId() + CS4.getId()));
            lS3 = String.valueOf("" + CS3.getId() + Integer.valueOf(currentCircle.getId()));
        } else if (Integer.valueOf(currentCircle.getId()) > 80 && Integer.valueOf(currentCircle.getId()) < 91) {
            lL = String.valueOf("" + CL.getId() + Integer.valueOf(currentCircle.getId()));
            lS2 = String.valueOf("" + CS2.getId() + Integer.valueOf(currentCircle.getId()));
            lS3 = String.valueOf("" + CS3.getId() + Integer.valueOf(currentCircle.getId()));
        } else {
            lR = String.valueOf("" + Integer.valueOf(currentCircle.getId() + CR.getId()));
            lU = String.valueOf("" + CU.getId() + Integer.valueOf(currentCircle.getId()));
            lL = String.valueOf("" + CL.getId() + Integer.valueOf(currentCircle.getId()));
            lD = String.valueOf("" + Integer.valueOf(currentCircle.getId() + CD.getId()));
            lS1 = String.valueOf("" + Integer.valueOf(currentCircle.getId() + CS1.getId()));
            lS2 = String.valueOf("" + CS2.getId() + Integer.valueOf(currentCircle.getId()));
            lS3 = String.valueOf("" + CS3.getId() + Integer.valueOf(currentCircle.getId()));
            lS4 = String.valueOf("" + Integer.valueOf(currentCircle.getId() + CS4.getId()));
        }

        if (turnComputer.equals(true)) {
            if (Integer.valueOf(currentCircle.getId()) < 10) {
                if (listVisited.contains(CS1.getId()) && !listLine.contains(lS1)) {
                    computerPoint(currentCircle, CS1, lS1);
                    computerEngine();
                } else if (listVisited.contains(CR.getId()) && !listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                    computerEngine();
                } else if (!listLine.contains(lS1)) {
                    computerPoint(currentCircle, CS1, lS1);
                    computerEngine();
                } else if (!listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                    computerEngine();
                } else if (listVisited.contains(CS4.getId()) && !listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                    computerEngine();
                } else if (!listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                    computerEngine();
                } else {
                    System.out.println("Wygrał gracz 1");
                }
            }
            if (Integer.valueOf(currentCircle.getId()) == 19) {
                if (listVisited.contains(CS1.getId()) && !listLine.contains(lS1)) {
                    computerPoint(currentCircle, CS1, lS1);
                    computerEngine();
                } else if (listVisited.contains(CU.getId()) && !listLine.contains(lU)) {
                    computerPoint(currentCircle, CU, lU);
                    computerEngine();
                } else if (listVisited.contains(CS2.getId()) && !listLine.contains(lS2)) {
                    computerPoint(currentCircle, CS2, lS2);
                    computerEngine();
                } else if (listVisited.contains(CR.getId()) && !listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                    computerEngine();
                } else if (!listLine.contains(lS1)) {
                    computerPoint(currentCircle, CS1, lS1);
                } else if (!listLine.contains(lU)) {
                    computerPoint(currentCircle, CU, lU);
                } else if (!listLine.contains(lS2)) {
                    computerPoint(currentCircle, CS2, lS2);
                } else if (!listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                } else if (listVisited.contains(CL.getId()) && !listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lL);
                    computerEngine();
                } else if (!listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lL);
                } else if (listVisited.contains(CD.getId()) && !listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                    computerEngine();
                } else if (!listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                } else if (listVisited.contains(CS4.getId()) && !listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                    computerEngine();
                } else if (!listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                } else {
                    System.out.println("Wygrał gracz 1");
                }
            }
            if (Integer.valueOf(currentCircle.getId()) == 71) {
                if (listVisited.contains(CS2.getId()) && !listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS2, lS2);
                    computerEngine();
                } else if (listVisited.contains(CU.getId()) && !listLine.contains(lU)) {
                    computerPoint(currentCircle, CU, lU);
                    computerEngine();
                } else if (listVisited.contains(CL.getId()) && !listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lL);
                    computerEngine();
                } else if (listVisited.contains(CS3.getId()) && !listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                    computerEngine();
                } else if (!listLine.contains(lS2)) {
                    computerPoint(currentCircle, CS2, lS2);
                } else if (!listLine.contains(lU)) {
                    computerPoint(currentCircle, CU, lU);
                } else if (!listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                } else if (!listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                } else if (listVisited.contains(CR.getId()) && !listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                    computerEngine();
                } else if (!listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                } else if (listVisited.contains(CD.getId()) && !listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                    computerEngine();
                } else if (!listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                } else if (listVisited.contains(CS4.getId()) && !listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                    computerEngine();
                } else if (!listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                } else {
                    System.out.println("Wygrał gracz 1");
                }
            }
            if (Integer.valueOf(currentCircle.getId()) == 79) {
                if (listVisited.contains(CS2.getId()) && !listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS2, lS2);
                    computerEngine();
                } else if (!listLine.contains(lS2)) {
                    computerPoint(currentCircle, CS2, lS2);
                } else if (listVisited.contains(CS3.getId()) && !listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                    computerEngine();
                } else if (listVisited.contains(CU.getId()) && !listLine.contains(lU)) {
                    computerPoint(currentCircle, CU, lU);
                    computerEngine();
                } else if (listVisited.contains(CR.getId()) && !listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                    computerEngine();
                } else if (!listLine.contains(lS2)) {
                    computerPoint(currentCircle, CS2, lS2);
                } else if (!listLine.contains(lU)) {
                    computerPoint(currentCircle, CU, lU);
                } else if (!listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                } else if (listVisited.contains(CL.getId()) && !listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lL);
                    computerEngine();
                } else if (!listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lL);
                } else if (listVisited.contains(CD.getId()) && !listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                    computerEngine();
                } else if (!listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                } else if (listVisited.contains(CS4.getId()) && !listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS1, lS1);
                    computerEngine();
                } else if (!listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS1, lS1);
                } else {
                    System.out.println("Wygrał gracz 1");
                }
            }
            if (Integer.valueOf(currentCircle.getId()) < 40 && Integer.valueOf(currentCircle.getId()) > 30
                    || Integer.valueOf(currentCircle.getId()) < 30 && Integer.valueOf(currentCircle.getId()) > 19
                    || Integer.valueOf(currentCircle.getId()) < 19 && Integer.valueOf(currentCircle.getId()) > 11) {
                if (listVisited.contains(CS1.getId()) && !listLine.contains(lS1)) {
                    computerPoint(currentCircle, CS1, lS1);
                    computerEngine();
                } else if (listVisited.contains(CU.getId()) && !listLine.contains(lU)) {
                    computerPoint(currentCircle, CU, lU);
                    computerEngine();
                } else if (listVisited.contains(CS2.getId()) && !listLine.contains(lS2)) {
                    computerPoint(currentCircle, CS2, lS2);
                    computerEngine();
                } else if (listVisited.contains(CR.getId()) && !listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                    computerEngine();
                } else if (!listLine.contains(lS1)) {
                    computerPoint(currentCircle, CS1, lS1);
                } else if (!listLine.contains(lU)) {
                    computerPoint(currentCircle, CU, lU);
                } else if (!listLine.contains(lS2)) {
                    computerPoint(currentCircle, CS2, lS2);
                } else if (!listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                } else if (listVisited.contains(CL.getId()) && !listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lL);
                    computerEngine();
                } else if (!listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lL);
                } else if (listVisited.contains(CS3.getId()) && !listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                    computerEngine();
                } else if (!listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                } else if (listVisited.contains(CD.getId()) && !listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                    computerEngine();
                } else if (!listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                } else if (listVisited.contains(CS4.getId()) && !listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                    computerEngine();
                } else if (!listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                } else {
                    System.out.println("Wygrał gracz 1");
                }
            }
            if (Integer.valueOf(currentCircle.getId()) > 40 && (Integer.valueOf(currentCircle.getId()) < 50)) {
                if (listVisited.contains(CU.getId()) && !listLine.contains(lU)) {
                    computerPoint(currentCircle, CU, lU);
                    computerEngine();
                } else if (!listLine.contains(lU)) {
                    computerPoint(currentCircle, CU, lU);
                } else if (listVisited.contains(CS1.getId()) && !listLine.contains(lS1)) {
                    computerPoint(currentCircle, CS1, lS1);
                    computerEngine();
                } else if (listVisited.contains(CS2.getId()) && !listLine.contains(lS2)) {
                    computerPoint(currentCircle, CS2, lS2);
                    computerEngine();
                } else if (!listLine.contains(lS1)) {
                    computerPoint(currentCircle, CS1, lS1);
                } else if (!listLine.contains(lS2)) {
                    computerPoint(currentCircle, CS2, lS2);
                } else if (listVisited.contains(CR.getId()) && !listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                    computerEngine();
                } else if (listVisited.contains(CL.getId()) && !listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lR);
                    computerEngine();
                } else if (!listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                } else if (!listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lL);
                } else if (listVisited.contains(CS3.getId()) && !listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                    computerEngine();
                } else if (listVisited.contains(CS4.getId()) && !listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                    computerEngine();
                } else if (!listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                } else if (!listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                } else if (listVisited.contains(CD.getId()) && !listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                    computerEngine();
                } else if (!listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                } else {
                    System.out.println("Wygrał gracz 1");
                }
            }
            if (Integer.valueOf(currentCircle.getId()) > 50 && Integer.valueOf(currentCircle.getId()) < 60
                    || Integer.valueOf(currentCircle.getId()) > 60 && Integer.valueOf(currentCircle.getId()) < 71
                    || Integer.valueOf(currentCircle.getId()) > 71 && Integer.valueOf(currentCircle.getId()) < 80) {
                if (listVisited.contains(CS2.getId()) && !listLine.contains(lS2)) {
                    computerPoint(currentCircle, CS2, lS2);
                    computerEngine();
                } else if (listVisited.contains(CU.getId()) && !listLine.contains(lU)) {
                    computerPoint(currentCircle, CU, lU);
                    computerEngine();
                } else if (listVisited.contains(CS1.getId()) && !listLine.contains(lS1)) {
                    computerPoint(currentCircle, CS1, lS1);
                    computerEngine();
                } else if (listVisited.contains(CL.getId()) && !listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lL);
                    computerEngine();
                } else if (!listLine.contains(lS2)) {
                    computerPoint(currentCircle, CS2, lS2);
                } else if (!listLine.contains(lU)) {
                    computerPoint(currentCircle, CU, lU);
                } else if (!listLine.contains(lS1)) {
                    computerPoint(currentCircle, CS1, lS1);
                } else if (!listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lL);
                } else if (listVisited.contains(CR.getId()) && !listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                    computerEngine();
                } else if (!listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                } else if (listVisited.contains(CS3.getId()) && !listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                    computerEngine();
                } else if (!listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                } else if (listVisited.contains(CD.getId()) && !listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                    computerEngine();
                } else if (!listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                } else if (listVisited.contains(CS4.getId()) && !listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                    computerEngine();
                } else if (!listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                } else {
                    System.out.println("Wygrał gracz 1");
                }
            }
            if (Integer.valueOf(currentCircle.getId()) > 80) {
                if (listVisited.contains(CS2.getId()) && !listLine.contains(lS2)) {
                    computerPoint(currentCircle, CS2, lS2);
                    computerEngine();
                } else if (listVisited.contains(CL.getId()) && !listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lL);
                    computerEngine();
                } else if (!listLine.contains(lS2)) {
                    computerPoint(currentCircle, CS2, lS2);
                    computerEngine();
                } else if (!listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lL);
                    computerEngine();
                } else if (listVisited.contains(CS3.getId()) && !listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                    computerEngine();
                } else if (!listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                    computerEngine();
                } else {
                    System.out.println("Wygrał gracz 1");
                }
            }
            if (Integer.valueOf(currentCircle.getId()) == 40 || Integer.valueOf(currentCircle.getId()) == 20) {
                if (listVisited.contains(CS4.getId()) && !listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                    computerEngine();
                } else if (listVisited.contains(CD.getId()) && !listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                    computerEngine();
                } else if (!listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                    computerEngine();
                } else if (!listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                    computerEngine();
                } else if (listVisited.contains(CS3.getId()) && !listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                    computerEngine();
                } else if (!listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                    computerEngine();
                } else {
                    System.out.println("Wygrał gracz 1");
                }
            }
            if (Integer.valueOf(currentCircle.getId()) == 60 || Integer.valueOf(currentCircle.getId()) == 70) {
                if (listVisited.contains(CS3.getId()) && !listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                    computerEngine();
                } else if (listVisited.contains(CD.getId()) && !listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                    computerEngine();
                } else if (!listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                    computerEngine();
                } else if (!listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                    computerEngine();
                } else if (listVisited.contains(CS4.getId()) && !listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                    computerEngine();
                } else if (!listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                    computerEngine();
                } else {
                    System.out.println("Wygrał gracz 1");
                }
            }
            if (Integer.valueOf(currentCircle.getId()) == 11) {
                if (listVisited.contains(CS1.getId()) && !listLine.contains(lS1)) {
                    computerPoint(currentCircle, CS1, lS1);
                    computerEngine();
                } else if (listVisited.contains(CU.getId()) && !listLine.contains(lU)) {
                    computerPoint(currentCircle, CU, lU);
                    computerEngine();
                } else if (listVisited.contains(CR.getId()) && !listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                    computerEngine();
                } else if (!listLine.contains(lS1)) {
                    computerPoint(currentCircle, CS1, lS1);
                } else if (!listLine.contains(lU)) {
                    computerPoint(currentCircle, CU, lU);
                } else if (!listLine.contains(lR)) {
                    computerPoint(currentCircle, CR, lR);
                } else if (listVisited.contains(CL.getId()) && !listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lL);
                    computerEngine();
                } else if (!listLine.contains(lL)) {
                    computerPoint(currentCircle, CL, lL);
                } else if (listVisited.contains(CS3.getId()) && !listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                    computerEngine();
                } else if (!listLine.contains(lS3)) {
                    computerPoint(currentCircle, CS3, lS3);
                } else if (listVisited.contains(CD.getId()) && !listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                    computerEngine();
                } else if (!listLine.contains(lD)) {
                    computerPoint(currentCircle, CD, lD);
                } else if (listVisited.contains(CS4.getId()) && !listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                    computerEngine();
                } else if (!listLine.contains(lS4)) {
                    computerPoint(currentCircle, CS4, lS4);
                } else {
                    System.out.println("Wygrał gracz 1");
                }
            }
            if (Integer.valueOf(currentCircle.getId()) == 30) {
                alert("Wygrana!!", "Czy chcesz zagrać jeszcze raz?", true);
            }
            if (Integer.valueOf(currentCircle.getId()) == 50) {
                alert("Wygrana!!", "Czy chcesz zagrać jeszcze raz?", true);
            }
            if (Integer.valueOf(currentCircle.getId()) == 40 && listVisited.contains("40")) {
                alert("Wygrana!!", "Czy chcesz zagrać jeszcze raz?", true);
            }
        }

    }


    void enablePoint(Circle currentCircle) {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 10; j++) {
                String idCircle = String.valueOf("" + i + j);
                Circle disableCircle = (Circle) mainGame.lookup('#' + idCircle);
                disableCircle.setDisable(true);
                //disableCircle.setFill(Color.RED);
                int enableL = Integer.parseInt(currentCircle.getId()) - 10;
                int enableR = Integer.parseInt(currentCircle.getId()) + 10;
                int enableU = Integer.parseInt(currentCircle.getId()) - 1;
                int enableD = Integer.parseInt(currentCircle.getId()) + 1;
                int enableS1 = Integer.parseInt(currentCircle.getId()) - 11;
                int enableS2 = Integer.parseInt(currentCircle.getId()) + 11;
                int enableS3 = Integer.parseInt(currentCircle.getId()) - 9;
                int enableS4 = Integer.parseInt(currentCircle.getId()) + 9;
                int c1 = Integer.parseInt(disableCircle.getId());
                if (c1 == enableL || c1 == enableR ||
                        c1 == enableU || c1 == enableD ||
                        c1 == enableS1 || c1 == enableS2 ||
                        c1 == enableS3 || c1 == enableS4) {
                    disableCircle.setDisable(false);
                    //disableCircle.setFill(Color.ORANGE);
                }
            }
        }
    }


    void CircleEngine() {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 10; j++) {
                Circle circle = new Circle(3 + i * 50, 46 + j * 43, 5, Color.ORANGE);
                circle.setStroke(Color.BLACK);
                circle.setId("" + i + j);
                colorPoint(i, j, circle);
                mainGame.getChildren().add(circle);
                EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        circleActualID = circle.getId();
                        Circle currentCircle = (Circle) mainGame.lookup('#' + circleActualID);
                        Circle lastCircle = (Circle) mainGame.lookup('#' + circleLastID);
                        String nameLine;
                        if (Integer.valueOf(currentCircle.getId()) < Integer.valueOf(lastCircle.getId())) {
                            nameLine = String.valueOf("" + currentCircle.getId() + lastCircle.getId());
                        } else {
                            nameLine = String.valueOf("" + lastCircle.getId() + currentCircle.getId());
                        }
                        if (!listLine.contains(nameLine)) {
                            drawline(currentCircle, lastCircle);
                            enablePoint(currentCircle);
                            setTurn(currentCircle);
                            if (!listVisited.contains(currentCircle.getId())) {
                                listVisited.add(currentCircle.getId());
                            }
                            circleLastID = circle.getId();
                            listVisited.add(currentCircle.getId());
                            setColorVisited();
                            circle.setFill(Color.AQUA);
                        }
                        computerEngine();
                    }
                };
                circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setStartTurn();
        CircleEngine();
    }
}
