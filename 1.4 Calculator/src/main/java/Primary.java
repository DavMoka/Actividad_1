import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Primary implements Initializable {

    @FXML TextField fldIn;
    @FXML Label lblOut;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actionClear();
    }

    @FXML public void actionCalc() {
        int input = Integer.parseInt(fldIn.getText());
        String result = "";
        for(int i = 1; i <= 10; i++) result += "" + input + "x" + i + " = " + input * i + (i != 10 ? "\n" : "");
        
        lblOut.setText(result);
    }

    @FXML public void actionClear() {
        fldIn.setText("");
        lblOut.setText("");
    }

}
