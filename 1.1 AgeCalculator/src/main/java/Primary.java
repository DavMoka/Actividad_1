import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Primary {
    @FXML TextField fldInput;
    @FXML Label lblResult;

    @FXML public void actionCalculate() {
        String input = fldInput.getText();
        int inDay = Integer.parseInt(input.split("/")[0]);
        int inMonth = Integer.parseInt(input.split("/")[1]);
        int inYear = Integer.parseInt(input.split("/")[2]);
        
        LocalDate date = LocalDate.now();
        int atDay = date.getDayOfMonth();
        int atMonth = date.getMonth().getValue();
        int atYear = date.getYear();

        int diffMonths = (atYear - inYear) * 12;
        if(inMonth > atMonth) diffMonths -= inMonth - atMonth;
        if(inMonth < atMonth) diffMonths += atMonth - inMonth;
        if(inMonth == atMonth && inDay > atDay) diffMonths--;
        
        int resYears = diffMonths / 12;
        int resMonths = diffMonths % 12;
        
        lblResult.setText("Tiene " + resYears + " años y " + resMonths + " meses.");
    }
    @FXML public void actionClear() {
        fldInput.setText("");
        lblResult.setText("");
    }
}
