import UnitModels.RoomModel;
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
    private TableView<RoomModel> roomTableView = new TableView<RoomModel>();
    @FXML
    private TableColumn<RoomModel, Integer> corpusNumberColumn = new TableColumn<RoomModel, Integer>("Номер корпуса");
    @FXML
    private TableColumn<RoomModel, Integer> roomNumberColumn = new TableColumn<RoomModel, Integer>("Номер комнаты");
    @FXML
    private TableColumn<RoomModel, Integer> maxPeopleColumn =  new TableColumn<RoomModel, Integer>("Количество мест");
    @FXML
    private TableColumn<RoomModel, String> equipmentsColumn = new TableColumn<RoomModel, String>("Оборудование");
    @FXML
    void initialize(){
        viewModel = new MainWindowViewModel();
        corpusNumberColumn.setCellValueFactory(new PropertyValueFactory<RoomModel, Integer>("corpusNumber"));
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<RoomModel, Integer>("roomNumber"));
        maxPeopleColumn.setCellValueFactory(new PropertyValueFactory<RoomModel, Integer>("maxPeople"));
        equipmentsColumn.setCellValueFactory(new PropertyValueFactory<RoomModel, String>("equipments"));
        viewRoomsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                roomTableView.setEditable(true);
                roomTableView.getColumns().removeAll(corpusNumberColumn,roomNumberColumn,maxPeopleColumn,equipmentsColumn);
                roomTableView.setItems(viewModel.getRoomsList());
                roomTableView.getColumns().addAll(corpusNumberColumn,roomNumberColumn,maxPeopleColumn,equipmentsColumn);
            }
        });
    }
}
