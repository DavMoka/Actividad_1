import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Primary implements Initializable {

    @FXML TextField fldInput;
    @FXML Button btnDisplay;
    @FXML Label lblTypes;
    @FXML Label lblResult;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.actionClear();
        MoneyTypes.load();
    }

    @FXML public void actionClear() {
        fldInput.setText("");
        lblTypes.setVisible(false);
        lblResult.setVisible(false);
    }

    @FXML public void actionDisplay() {
        ArrayList<MoneyTypes.MoneyType> sorted = MoneyTypes.sortAmount(Integer.parseInt(fldInput.getText()));
        
        String types = "";
        String result = "";
        for(MoneyTypes.MoneyType mt : sorted) {
            types += mt.getName() + "\n";
            result += "" + mt.amount + "\n";
        }
        
        lblTypes.setText(types);
        lblResult.setText(result);
        lblTypes.setVisible(true);
        lblResult.setVisible(true);
    }

}
