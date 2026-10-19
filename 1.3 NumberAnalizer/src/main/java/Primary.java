import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Primary implements Initializable {

    @FXML TextField fldInput;
    @FXML Label lblStatsNames;
    @FXML Label lblStatsValues;
    @FXML Label lblDivisors;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        actionClear();
    }

    @FXML public void actionAnalize() {
        int input = Integer.parseInt(fldInput.getText());
        int numberLength = (int)Math.floor(Math.log10(input))+1;
        int[] digits = new int[numberLength];

        int inClone = input;
        for(int i = numberLength; i > 0; i--) {
            int digit = inClone / (int)Math.pow(10, i - 1);
            digits[numberLength - i] = digit;
            inClone -= digit * (int)Math.pow(10, i - 1);
        }

        String log = "";
        for(int i : digits) log += "| " + i;
        System.out.println(log);

        int oddSum = 0;
        int evenSum = 0;
        int totalSum = 0;
        int highestDigit = 0;
        int lowestDigit = 9;

        for(int d : digits) {
            if(d % 2 == 0) evenSum += d;
            else oddSum += d;
            totalSum += d;
            
            if(d > highestDigit) highestDigit = d;
            if(d < lowestDigit) lowestDigit = d;
        }

        lblStatsValues.setText("" + digits.length + "\n" + oddSum + "\n" + evenSum + "\n" + totalSum + "\n" + highestDigit + "\n" + lowestDigit);

        ArrayList<Integer> divisors = new ArrayList<>();
        for(int i = 1; i <= input; i++) if(input % i == 0) divisors.add(i);
        String divisorsStr = "";
        for(Integer i : divisors) divisorsStr += "\n" + i;

        lblDivisors.setText("Divisores:" + divisorsStr);
    }

    @FXML public void actionClear() {
        fldInput.setText("");
        lblStatsNames.setText("Cantidad de cifras:\nSuma de cifras impares:\nSuma de cifras pares:\nSuma total de cifras:\nCifra mayor:\nCifra menor:");
        lblStatsValues.setText("-\n-\n-\n-\n-\n-");
        lblDivisors.setText("Divisores:");
    }

}
