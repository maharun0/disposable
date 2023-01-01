import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchBandController {

    @FXML private Button buttonBack; // back to menu
    @FXML private Button buttonSearch; // search_book
    @FXML private TextField outputTextField;
    @FXML private TextField textField;

    @FXML void PressedTextField(ActionEvent event) {
        
        
    }

    @FXML
    void pressedButtonBack(ActionEvent event) {

    }
    //new
    @FXML
    void outputTextFieldPressed(ActionEvent event) {
        
    }

    @FXML
    void pressedButtonSearch(ActionEvent event) {
        String s = textField.getText();

        String resultBands = DataFile.searchForBands(s);
        String resultConcerts = DataFile.searchForConcerts(s);

        outputTextField.setText(resultBands + resultConcerts);
    }

}
