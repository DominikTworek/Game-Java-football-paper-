package game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private AnchorPane tab01;

    @FXML
    private Line line;

    @FXML
    private Circle Point17;

    @FXML
    private Circle Point18;

    @FXML
    private Circle Point19;

    @FXML
    private Circle Point20;

    @FXML
    private Circle Point10;

    @FXML
    private Circle Point11;

    @FXML
    private Circle Point16;

    @FXML
    private Circle Point00;

    @FXML
    private Circle Point12;

    @FXML
    private Circle Point15;

    @FXML
    private Circle Point14;

    @FXML
    private Circle Point13;

    @FXML
    private Circle Point21;

    @FXML
    private Circle Point22;

    @FXML
    private Circle Point23;

    @FXML
    private Circle Point24;

    @FXML
    private Circle Point25;

    @FXML
    private Circle Point26;

    //true - można
    //false - aktywne

    //true - polaczone
    //false - niepolaczone
    private Boolean spr00_10;
    private Boolean spr00_11;
    private Boolean spr00_12;
    private Boolean spr00_13;
    private Boolean spr00_14;
    private Boolean spr00_15;
    private Boolean spr00_16;
    private Boolean spr00_17;

    private Boolean spr10_12;

    private Boolean spr11_12;

    private Boolean spr12_10;
    private Boolean spr12_11;
    private Boolean spr12_19;
    private Boolean spr12_18;
    private Boolean spr12_20;
    private Boolean spr12_13;
    private Boolean spr12_14;
    private Boolean spr12_00;

    private Boolean spr13_12;

    private Boolean spr14_12;

    private Boolean spr18_12;
    private Boolean spr18_21;

    private Boolean spr19_12;

    private Boolean spr20_12;

    private Boolean spr21_18;

    private Boolean spr00;
    private Boolean spr10;
    private Boolean spr11;
    private Boolean spr12;
    private Boolean spr13;
    private Boolean spr14;
    private Boolean spr15;
    private Boolean spr16;
    private Boolean spr17;
    private Boolean spr18;
    private Boolean spr19;
    private Boolean spr20;
    private Boolean spr21;
    private Boolean spr22;
    private Boolean spr23;
    private Boolean spr24;
    private Boolean spr25;
    private Boolean spr26;
    private Boolean spr27;
    private Boolean spr28;
    private Boolean spr29;
    private Boolean spr30;
    private Boolean spr31;
    private Boolean spr32;
    private Boolean spr33;
    private Boolean spr34;
    private Boolean spr35;
    private Boolean spr36;



    @FXML
    void ClickPoint30(MouseEvent event) {

    }

    @FXML
    void ClickPoint40(MouseEvent event) {

    }

    void drawLine(Circle circle, Circle circle2) {
        Line line = new Line();
        line.setStartX(circle.getLayoutX());
        line.setStartY(circle.getLayoutY());
        line.setEndX(circle2.getLayoutX());
        line.setEndY(circle2.getLayoutY());
        line.setStyle("-fx-stroke: #43ff04;");
        mainGame.getChildren().add(line);
    }

    public void Point00Click(MouseEvent mouseEvent) {
        if (!spr00_12 && !spr12_00 && !spr12) {
            drawLine(Point00, Point12);
            spr00 = false;
            spr10 = true;
            spr11 = true;
            spr19 = true;
            spr18 = true;
            spr20 = true;
            spr13 = true;
            spr14 = true;
            spr12 = true;
            spr12_00 = true;
            spr00_12 = true;
        }
    }



    @FXML
    void Point10Click(MouseEvent event) {
        if (!spr10_12 && !spr12_10 && !spr12) {
            drawLine(Point10, Point12);
            spr10 = false;
            spr00 = true;
            spr16 = true;
            spr17 = true;
            spr36 = true;
            spr27 = true;
            spr28 = true;
            spr11 = true;
            spr12 = true;
            spr10_12 = true;
            spr12_10 = true;
        }
    }

    @FXML
    void Point11Click(MouseEvent event) {
        if (!spr11_12 && !spr12_11 && !spr12) {
            drawLine(Point11, Point12);
            spr11 = false;
            spr19 = true;
            spr18 = true;
            spr00 = true;
            spr10 = true;
            spr27 = true;
            spr28 = true;
            spr29 = true;
            spr12 = true;
            spr11_12 = true;
            spr12_11 = true;
        }
    }

    @FXML
    void Point12Click(MouseEvent event) {
        if (!spr00_12 && !spr12_00 && !spr00) {
            drawLine(Point00, Point12);
            spr12 = false;
            spr10 = true;
            spr11 = true;
            spr19 = true;
            spr18 = true;
            spr20 = true;
            spr13 = true;
            spr14 = true;
            spr00 = true;
            spr12_00 = true;
            spr00_12 = true;
        }
        if (!spr12_18 && !spr18_12 && !spr18) {
            drawLine(Point12, Point18);
            spr12 = false;
            spr10 = true;
            spr11 = true;
            spr19 = true;
            spr18 = true;
            spr20 = true;
            spr13 = true;
            spr14 = true;
            spr00 = true;
            spr12_18 = true;
            spr18_12 = true;
        }
        if (!spr11_12 && !spr12_11 && !spr11) {
            drawLine(Point11, Point12);
            spr12 = false;
            spr10 = true;
            spr11 = true;
            spr19 = true;
            spr18 = true;
            spr20 = true;
            spr13 = true;
            spr14 = true;
            spr00 = true;
            spr11_12 = true;
            spr12_11 = true;
        }
        if (!spr12_19 && !spr19_12 && !spr19) {
            drawLine(Point11, Point19);
            spr12 = false;
            spr10 = true;
            spr11 = true;
            spr19 = true;
            spr18 = true;
            spr20 = true;
            spr13 = true;
            spr14 = true;
            spr00 = true;
            spr12_19 = true;
            spr19_12 = true;
        }
        if (!spr12_20 && !spr20_12 && !spr20) {
            drawLine(Point12, Point20);
            spr12 = false;
            spr10 = true;
            spr11 = true;
            spr19 = true;
            spr18 = true;
            spr20 = true;
            spr13 = true;
            spr14 = true;
            spr00 = true;
            spr12_20 = true;
            spr20_12 = true;
        }
        if (!spr12_13 && !spr13_12 && !spr13) {
            drawLine(Point12, Point13);
            spr12 = false;
            spr10 = true;
            spr11 = true;
            spr19 = true;
            spr18 = true;
            spr20 = true;
            spr13 = true;
            spr14 = true;
            spr00 = true;
            spr12_13 = true;
            spr13_12 = true;
        }
        if (!spr12_14 && !spr14_12 && !spr14) {
            drawLine(Point12, Point13);
            spr12 = false;
            spr10 = true;
            spr11 = true;
            spr19 = true;
            spr18 = true;
            spr20 = true;
            spr13 = true;
            spr14 = true;
            spr00 = true;
            spr12_14 = true;
            spr14_12 = true;
        }
        if (!spr12_10 && !spr10_12 && !spr10) {
            drawLine(Point12, Point10);
            spr12 = false;
            spr10 = true;
            spr11 = true;
            spr19 = true;
            spr18 = true;
            spr20 = true;
            spr13 = true;
            spr14 = true;
            spr00 = true;
            spr12_10 = true;
            spr10_12 = true;
        }
    }

    @FXML
    void Point13Click(MouseEvent event) {
        if (!spr13_12 && !spr12_13 && !spr12) {
            drawLine(Point13, Point12);
            spr13 = false;
            spr18 = true;
            spr20 = true;
            spr32 = true;
            spr33 = true;
            spr34 = true;
            spr14 = true;
            spr00 = true;
            spr12 = true;
            spr13_12 = true;
            spr12_13 = true;
        }
    }

    @FXML
    void Point14Click(MouseEvent event) {
        if (!spr14_12 && !spr12_14 && !spr12) {
            drawLine(Point14, Point12);
            spr14 = false;
            spr13 = true;
            spr33 = true;
            spr34 = true;
            spr35 = true;
            spr15 = true;
            spr16 = true;
            spr00 = true;
            spr12 = true;
            spr14_12 = true;
            spr12_14 = true;
        }
    }

    @FXML
    void Point15Click(MouseEvent event) {
        if (!spr00_15 && !spr00) {
            drawLine(Point00, Point15);
            spr15 = false;
            spr00_15 = true;
        }
    }

    @FXML
    void Point16Click(MouseEvent event) {
        if (!spr00_16 && !spr00) {
            drawLine(Point00, Point16);
            spr16 = false;
            spr00_16 = true;
        }
    }

    @FXML
    void Point17Click(MouseEvent event) {
        if (!spr00_17 && !spr00) {
            drawLine(Point00, Point17);
            spr17 = false;
            spr00_17 = true;
        }
    }

    @FXML
    public void Point18Click(MouseEvent mouseEvent) {
        if (!spr12_18 && !spr18_12 && !spr12) {
            drawLine(Point12, Point18);
            spr18 = false;
            spr11 = true;
            spr19 = true;
            spr22 = true;
            spr21 = true;
            spr23 = true;
            spr20 = true;
            spr13 = true;
            spr12 = true;
            spr12_18 = true;
            spr18_12 = true;
        }
    }

    @FXML
    public void Point19Click(MouseEvent mouseEvent) {
        if (!spr12_19 && !spr19_12 && !spr12) {
            drawLine(Point12, Point19);
            spr19 = false;
            spr11 = true;
            spr28 = true;
            spr29 = true;
            spr30 = true;
            spr22 = true;
            spr21 = true;
            spr18 = true;
            spr12 = true;
            spr12_19 = true;
            spr19_12 = true;
        }
    }

    @FXML
    public void Point20Click(MouseEvent mouseEvent) {
        if (!spr12_20 && !spr20_12 && !spr12) {
            drawLine(Point12, Point20);
            spr20 = false;
            spr18 = true;
            spr21 = true;
            spr23 = true;
            spr31 = true;
            spr32 = true;
            spr33 = true;
            spr13 = true;
            spr12 = true;
            spr12_20 = true;
            spr20_12 = true;
        }
    }

    @FXML
    public void Point21Click(MouseEvent mouseEvent) {
        if (!spr18_21 && !spr21_18 && !spr18) {
            drawLine(Point18, Point21);
            spr21 = false;
            spr11 = true;
            spr19 = true;
            spr22 = true;
            spr21 = true;
            spr23 = true;
            spr20 = true;
            spr13 = true;
            spr18 = true;
            spr18_21 = true;
            spr21_18 = true;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        spr00 = false;
        spr10 = true;
        spr11 = true;
        spr12 = true;
        spr13 = true;
        spr14 = true;
        spr15 = true;
        spr16 = true;
        spr17 = true;
        spr00_10 = false;
        spr00_11 = false;
        spr00_12 = false;
        spr00_13 = false;
        spr00_14 = false;
        spr00_15 = false;
        spr00_16 = false;
        spr00_17 = false;

        spr10_12 = false;

        spr11_12 = false;

        spr12_19 = false;
        spr12_18 = false;
        spr12_13 = false;
        spr12_10 = false;
        spr12_00 = false;
        spr12_11 = false;
        spr12_14 = false;
        spr12_20 = false;

        spr13_12 = false;

        spr14_12 = false;

        spr18_12 = false;
        spr18_21 = false;

        spr19_12 = false;

        spr20_12 = false;

        spr21_18 = false;

    }
}
