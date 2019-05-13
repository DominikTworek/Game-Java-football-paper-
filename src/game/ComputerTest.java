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

import java.awt.*;
import java.awt.event.InputEvent;
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

    private Boolean turnComputer=false;
    private Boolean turnPlayer=true;

     private String circleLastID = "45";
     private String circleActualID = "";

     private Boolean gameStatus = true;

     void drawline(Circle circle, Circle circle2){
         Line line = new Line();
         line.setStartX(circle.getCenterX());
         line.setStartY(circle.getCenterY());
         line.setEndX(circle2.getCenterX());
         line.setEndY(circle2.getCenterY());
         line.setId("");
         if (turnComputer.equals(true))
             line.setStyle("-fx-stroke: #0efffc");
         else
             line.setStyle("-fx-stroke: #43ff04");
         test.getChildren().add(line);
     }


     void colorPoint(int x, int y, Circle circle){
         if(x==0 && y==0 || x==8 && y==10 || x==0 && y==10 || x==8 && y==0){
             circle.setDisable(true);
             circle.setVisible(false);
         }
         if(x==0 || x==8 || y== 0 || y == 10){
             circle.setFill(Color.ORANGERED);
         }
         if(x==4){
             circle.setFill(Color.ORANGE);
         }
         if(x==4 && y==5){
             circle.setFill(Color.ORANGERED);
             circle.setRadius(8);
         }
     }

     void setStartTurn() {
         gracz1aktywnosc.setVisible(true);
         gracz2aktywnosc.setVisible(false);
     }

     void setTurn(Circle currentCircle, Circle lastCircle){
         String color = String.valueOf(currentCircle.getFill());
         if(turnComputer.equals(true)){
             if(color.equals("0xff4500ff")){
                 turnComputer = true;
                 gracz1aktywnosc.setVisible(false);
                 gracz2aktywnosc.setVisible(true);
             } else {
                 turnComputer = false;
                 gracz1aktywnosc.setVisible(true);
                 gracz2aktywnosc.setVisible(false);
             }
         }
         else{
             if(color.equals("0xff4500ff")) {
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

     void computerEngine(Circle currentCircle, Circle lastCircle){
         Integer idCR = Integer.valueOf(circleActualID) +10;
         Circle CR = (Circle) mainGame.lookup('#'+String.valueOf(idCR));
         int x = (int) currentCircle.getCenterX();
         int y = (int) currentCircle.getCenterY();
         System.out.println(x);
         System.out.println(y);
         String color = String.valueOf(CR.getFill());
         if(Integer.valueOf(currentCircle.getId()) < 40) {
             if (color.equals("0xff4500ff")) {
                 try {
                     Robot bot = null;
                     bot = new Robot();
                     bot.mouseMove(x, y);
                     bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                     bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                 } catch (AWTException e) {
                     e.printStackTrace();
                 }

             }
         }
         if(Integer.valueOf(currentCircle.getId()) > 50){

         }
     }

     void enablePoint(Circle currentCircle){
         for(int i = 0; i <= 8; i++){
             for(int j = 0; j <= 10; j++) {
                 String idCircle = String.valueOf(""+i+j);
                 Circle disableCircle = (Circle) mainGame.lookup('#'+idCircle);
                 disableCircle.setDisable(true);
                 int checkLeft=
                 int c1 = Integer.parseInt(disableCircle.getId());
                 if()
             }
             }
     }



    void CircleEngine(){
        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 10; j++){
                Circle circle = new Circle(3+i*50, 46+j*43, 5, Color.ORANGE);
                circle.setStroke(Color.BLACK);
                circle.setId(""+i+j);
                colorPoint(i, j, circle);
                mainGame.getChildren().add(circle);

                EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        circleActualID = circle.getId();
                        Circle currentCircle = (Circle) mainGame.lookup('#'+circleActualID);
                        Circle lastCircle = (Circle) mainGame.lookup('#'+circleLastID);
                        drawline(lastCircle, currentCircle);
                        setTurn(currentCircle, lastCircle);
                        circle.setFill(Color.AQUA);
                        lastCircle.setFill(Color.ORANGERED);
                        enablePoint(currentCircle);
                        //computerEngine(currentCircle, lastCircle);
                        circleLastID = circle.getId();

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
