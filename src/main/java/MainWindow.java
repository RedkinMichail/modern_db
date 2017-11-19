import Collections.Room;
import ViewModel.MainWindowViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainWindow {
    @FXML
    private Button viewRoomsButton;
    @FXML
    private MainWindowViewModel viewModel;
    @FXML
    private TableView<Room> roomTableView;
    @FXML
    private TableColumn<Room, String> corpusNumberColumn;
    @FXML
    private TableColumn<Room, String> roomNumberColumn;
    @FXML
    private TableColumn<Room, String> maxPeopleColumn;
    @FXML
    void initialize(){
        viewModel = new MainWindowViewModel();
        viewRoomsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.viewRooms();
            }
        });
    }
}
