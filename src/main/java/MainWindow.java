import Units.Room;
import ViewModel.MainWindowViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainWindow {
    @FXML
    private Button viewRoomsButton;
    @FXML
    private MainWindowViewModel viewModel;
    @FXML
    private TableView<Room> roomTableView = new TableView<Room>();
    @FXML
    private TableColumn<Room, Integer> corpusNumberColumn = new TableColumn<Room, Integer>("Номер корпуса");
    @FXML
    private TableColumn<Room, Integer> roomNumberColumn = new TableColumn<Room, Integer>("Номер комнаты");
    @FXML
    private TableColumn<Room, Integer> maxPeopleColumn =  new TableColumn<Room, Integer>("Количество мест");
    @FXML
    private TableColumn<Room, String> equipmentsColumn = new TableColumn<Room, String>("Оборудование");
    @FXML
    void initialize(){
        viewModel = new MainWindowViewModel();
        corpusNumberColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>("num"));
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>("num"));
        maxPeopleColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>("num"));
        equipmentsColumn.setCellValueFactory(new PropertyValueFactory<Room, String>("num"));
        viewRoomsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                roomTableView.setEditable(true);
                roomTableView.setItems(viewModel.getRoomsList());
                roomTableView.getColumns().addAll(corpusNumberColumn,roomNumberColumn,maxPeopleColumn,equipmentsColumn);
            }
        });
    }
}
