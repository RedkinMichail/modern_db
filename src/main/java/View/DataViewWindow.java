package View;

import ViewModel.DataViewModel;
import ViewModel.RowModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DataViewWindow {
    @FXML
    private Button viewRoomsButton;
    @FXML
    private Button viewDepartmentsButton;
    @FXML
    private DataViewModel viewModel;
    @FXML
    private TableView<RowModel> tableView = new TableView<RowModel>();
    @FXML
    private TableColumn<RowModel, String> column1 = new TableColumn<RowModel, String>();
    @FXML
    private TableColumn<RowModel, String> column2 = new TableColumn<RowModel, String>();
    @FXML
    private TableColumn<RowModel, String> column3 =  new TableColumn<RowModel, String>();
    @FXML
    private TableColumn<RowModel, String> column4 = new TableColumn<RowModel, String>();
    @FXML
    void initialize(){
        viewModel = new DataViewModel();
        column1.setText("Номер корпуса");
        viewRoomsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                tableView.setEditable(true);
                column1.setText("Код подразделения");
                column1.setCellValueFactory(new PropertyValueFactory<RowModel, String>("column1"));
                column2.setText("Номер комнаты");
                column2.setCellValueFactory(new PropertyValueFactory<RowModel, String>("column2"));
                column3.setText("Количество мест");
                column3.setCellValueFactory(new PropertyValueFactory<RowModel, String>("column3"));
                column4.setText("Оборудование");
                column4.setCellValueFactory(new PropertyValueFactory<RowModel, String>("column4"));
                tableView.getColumns().removeAll(column1, column2, column3, column4);
                tableView.setItems(viewModel.getRoomsList());
                tableView.getColumns().addAll(column1, column2, column3, column4);
            }
        });

    }
}
