package functions;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Windows {

    public static void changeScene(Event event,String Path) throws IOException {
        Parent NewScene = FXMLLoader.load(Windows.class.getResource(Path));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(NewScene));
        stage.show();

    }
}

