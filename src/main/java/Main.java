import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
//        String fxmlFile = "/fxml/DataViewWindow.fxml";
//        FXMLLoader loader = new FXMLLoader();
//        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
//        stage.setTitle("View.DataViewWindow");
//        stage.setScene(new Scene(root));
//        stage.show();
        // load main form in to VBox (Root)
        VBox mainPane = (VBox) FXMLLoader.load( getClass().getResource("/fxml/MainWindow.fxml" ) );
        // add main form into the scene
        Scene scene = new Scene(mainPane);

        stage.setTitle("Sample FX Multiple Forms");
        stage.setScene(scene);
        stage.setMaximized(true);    // make the main form fit to the screen
        stage.show();
    }
    public static void main(String[] args) throws Exception {
        launch(args);
        // Standard URI format: mongodb://[dbuser:dbpassword@]host:port/dbname
        //чисто пример
        /*
        Departure d = new Departure();
        d.addDeparture("third", "secondN", "secondH");
        d.addDeparture("fourth", "secondN", "secondH");
        d.addDeparture("fifth", "secondN", "secondHHHH");
        System.out.println("third **** " + d.findDepartureByName("third").toString());
               MongoCursor<Document> iter = d.findAllDepartures("NameOfParent", "secondN");
       while (iter.hasNext()) {
            System.out.println("exyyy *** " + iter.next());
      }*/
//        Room r = new Room();
//        r.addRoom(1, 101, 10);
//        r.addRoom(2, 201, 20);
//        r.deleteRoom(1);
    }
}
