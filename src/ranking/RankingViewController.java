package ranking;

import functions.Windows;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RankingViewController implements Initializable {

    @FXML
    private TableView<Person> tableta;

    @FXML
    private TableColumn<Person, Integer> Place;

    @FXML
    private TableColumn<Person, String> Nick;

    @FXML
    private TableColumn<Person, Integer> Win;

    @FXML
    private TableColumn<Person, Integer> Game;

    private static Boolean sprComputer = false;

    public static void setSprComputer(Boolean sprComputer) {
        RankingViewController.sprComputer = sprComputer;
    }

    public class Person {

        private SimpleStringProperty Place;
        private SimpleStringProperty Nick;
        private SimpleStringProperty Win;
        private SimpleStringProperty Game;

        public Person(String Place, String Nick, String Win, String Game) {
            this.Place = new SimpleStringProperty(Place);
            this.Nick = new SimpleStringProperty(Nick);
            this.Win = new SimpleStringProperty(Win);
            this.Game = new SimpleStringProperty(Game);

        }


        public String getPlace() {
            return Place.get();
        }

        public SimpleStringProperty placeProperty() {
            return Place;
        }

        public void setPlace(String place) {
            this.Place.set(place);
        }

        public String getNick() {
            return Nick.get();
        }

        public SimpleStringProperty nickProperty() {
            return Nick;
        }

        public void setNick(String nick) {
            this.Nick.set(nick);
        }

        public String getWin() {
            return Win.get();
        }

        public SimpleStringProperty winProperty() {
            return Win;
        }

        public void setWin(String win) {
            this.Win.set(win);
        }

        public String getGame() {
            return Game.get();
        }

        public SimpleStringProperty gameProperty() {
            return Game;
        }

        public void setGame(String game) {
            this.Game.set(game);
        }

    }


    public ObservableList<Person> getPeople() {
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("1", "Frank", "8", "15"));
        people.add(new Person("2", "Zygmunt", "7", "21"));
        return people;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Place.setCellValueFactory(new PropertyValueFactory<Person, Integer>("Place"));
        Nick.setCellValueFactory(new PropertyValueFactory<Person, String>("Nick"));
        Win.setCellValueFactory(new PropertyValueFactory<Person, Integer>("Win"));
        Game.setCellValueFactory(new PropertyValueFactory<Person, Integer>("Game"));
        tableta.setItems(getPeople());
    }

    @FXML
    void back(ActionEvent event) {
        try {
            Windows.changeScene(event, "../mainMenu/MainMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
