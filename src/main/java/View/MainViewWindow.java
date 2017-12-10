package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainViewWindow {
    @FXML
    private Button showDataView;
    @FXML
    private VBox dataPane;
    @FXML
    void initialize() throws IOException {
        VBox v = (VBox) FXMLLoader.load(getClass().getResource("/fxml/DataViewWindow.fxml"));
        v.setVisible(true);
    }

}
