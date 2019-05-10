package game;

import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ResourceBundle;

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

    private Line line = new Line();

     private String circleLastID = "Cicle10";

    void CircleEngine(){
        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 10; j++){
                Circle circle = new Circle(3+i*50, 46+j*43, 5, Color.ORANGE);
                circle.setStroke(Color.BLACK);
                circle.setId("Cicle"+i+j);
                if(i==0 && j==0 || i==8 && j==10 || i==0 && j==10 || i==8 && j==0){
                    circle.setDisable(true);
                    circle.setVisible(false);
                }
                if(i==0 || i==8 || j== 0 || j == 10){
                    circle.setFill(Color.ORANGERED);
                }
                if(i==4){
                    circle.setFill(Color.ORANGE);
                }
                mainGame.getChildren().add(circle);

                EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {

                        circle.setFill(Color.AQUA);
                        Circle circle2 = (Circle) mainGame.lookup('#'+circleLastID);
                        circle2.setFill(Color.ORANGERED);
                        Line line = new Line();
                        line.setStartX(circle.getLayoutX());
                        line.setStartY(circle.getLayoutY());
                        line.setEndX(circle.getLayoutX());
                        line.setEndY(circle.getLayoutY());
                        circleLastID = circle.getId();

                    }
                };
                circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CircleEngine();
    }
}
