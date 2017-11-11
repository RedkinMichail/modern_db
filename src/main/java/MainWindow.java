import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Collections.Departure;
import Collections.Room;


public class MainWindow extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
        // Standard URI format: mongodb://[dbuser:dbpassword@]host:port/dbname
        //чисто пример
        Departure d = new Departure();
        d.addDeparture("second", "secondN", "secondH");
        Room r = new Room();
        r.addRoom(1, 101, 10);
        r.addRoom(2, 201, 20);
        r.deleteRoom(1);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/MainWindow.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("MainWindow");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
