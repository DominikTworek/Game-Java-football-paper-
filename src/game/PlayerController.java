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
    private Circle point_20;

    @FXML
    private Circle point_30;

    @FXML
    private Circle point_40;

    @FXML
    private Circle Point16;

    @FXML
    private Circle Point00;

    @FXML
    private Circle Point12;

    @FXML
    private Circle point20;

    @FXML
    private Circle point30;

    @FXML
    private Circle point40;

    @FXML
    private Circle Point15;

    @FXML
    private Circle Point14;

    @FXML
    private Circle Point13;

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
    private Boolean spr12_10;
    private Boolean spr12_11;
    private Boolean spr12_19;
    private Boolean spr12_18;
    private Boolean spr12_20;
    private Boolean spr12_13;
    private Boolean spr12_14;
    private Boolean spr12_00;


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

    private Boolean sprStart;

    @FXML
    void ClickPoint20(MouseEvent event) {

    }

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

    void mainCheck(Boolean spr_laczenia, Boolean spr_laczenia2, Boolean aktywnosc, Boolean aktywnosc_po_nacisnieciu,
                   Circle c1, Circle c2,
                   Boolean c1spr, Boolean c2spr, Boolean c3spr, Boolean c4spr, Boolean c5spr, Boolean c6spr, Boolean c7spr, Boolean c8spr,
                   Boolean ustawianie_laczenia1, Boolean ustawianie_laczenia2) {
        if (!spr_laczenia && spr_laczenia2 && !aktywnosc) {
            drawLine(c1, c2);
            aktywnosc_po_nacisnieciu = false;
            spr_laczenia = true;
            spr_laczenia2 = true;
            c1spr = true;
            c2spr = true;
            c3spr = true;
            c4spr = true;
            c5spr = true;
            c6spr = true;
            c7spr = true;
            c8spr = true;
            ustawianie_laczenia1 = true;
            ustawianie_laczenia2 = true;
        }
    }


    @FXML
    void Point10Click(MouseEvent event) {
        if (!spr00_10 && !sprStart) {
            drawLine(Point00, Point10);
            spr10 = false;
            spr00_10 = true;
        }
        if (!spr12_10 && !spr12) {
            drawLine(Point12, Point10);
            spr10 = false;
            spr12_10 = true;
        }
    }

    @FXML
    void Point11Click(MouseEvent event) {
        if (!spr00_11 && !sprStart) {
            drawLine(Point00, Point11);
            spr11 = false;
            spr00_11 = true;
        }
        if (!spr12_11 && !spr12) {
            drawLine(Point12, Point11);
            spr11 = false;
            spr12_11 = true;
        }
    }

    @FXML
    void Point12Click(MouseEvent event) {
        mainCheck(spr00_12, spr12_00, sprStart, spr12, Point00, Point12, spr10, spr11, spr19, spr18, spr20, spr13, spr14, sprStart, spr12_00, spr00_12);
    }

    @FXML
    void Point13Click(MouseEvent event) {
        if (!spr00_13 && !sprStart) {
            drawLine(Point00, Point13);
            spr13 = false;
            spr00_13 = true;
        }
    }

    @FXML
    void Point14Click(MouseEvent event) {
        if (!spr00_14 && !sprStart) {
            drawLine(Point00, Point14);
            spr14 = false;
            spr00_14 = true;
        }
    }

    @FXML
    void Point15Click(MouseEvent event) {
        if (!spr00_15 && !sprStart) {
            drawLine(Point00, Point15);
            spr15 = false;
            spr00_15 = true;
        }
    }

    @FXML
    void Point16Click(MouseEvent event) {
        if (!spr00_16 && !sprStart) {
            drawLine(Point00, Point16);
            spr16 = false;
            spr00_16 = true;
        }
    }

    @FXML
    void Point17Click(MouseEvent event) {
        if (!spr00_17 && !sprStart) {
            drawLine(Point00, Point17);
            spr17 = false;
            spr00_17 = true;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sprStart = false;
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
        spr12_19 = false;
        spr12_18 = false;
        spr12_13 = false;
        spr12_10 = false;
        spr12_00 = false;
        spr12_11 = false;
        spr12_14 = false;
        spr12_20 = false;
    }

    public void Point19Click(MouseEvent mouseEvent) {
    }

    public void Point18Click(MouseEvent mouseEvent) {
    }

    public void Point20Click(MouseEvent mouseEvent) {
    }
}
