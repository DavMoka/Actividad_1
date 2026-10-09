package davtests.mavenproject1;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;


public class Responses {
    @FXML private TextField inputYear;
    @FXML private ComboBox inputMonth;
    @FXML private TextField inputDay;
    @FXML private Label result;
    @FXML private Label discYear;
    @FXML private Label discMonth;
    @FXML private Label discDay;

    private int getInt(TextField f) {
        try {
            return Integer.parseInt(f.getText());
        }
        catch(NumberFormatException ex) {
            return -1;
        }
    }

    @FXML public void actionCalc() {
        this.disclaimerClear();

        LocalDate datenow = LocalDate.now();
        int
            yearnow = datenow.getYear(),
            monthnow = datenow.getMonth().getValue(),
            daynow = datenow.getDayOfMonth(),
            yearin = this.getInt(this.inputYear),
            dayin = this.getInt(this.inputDay);
        Months.Month monthin = Months.getMonth((String)this.inputMonth.getValue());

        // Validates year
        if(yearin > yearnow || 1900 > yearin) { this.discYear.setText("Ingresa un año no menor a 1900 ni mayor al año actual."); return; }
        // Validates month
        if(monthin.getValue() == 0) { this.discMonth.setText("Selecciona un mes."); return; }
        else if(yearin == yearnow && monthnow < monthin.getValue()) { this.discMonth.setText("En el año actual, no puedes escoger un mes futuro."); return; }
        // Validates day
        if(0 >= dayin) { this.discDay.setText("Ingresa un día mayor a 0"); return; }
        else if(dayin > monthin.getDays()) { this.discDay.setText("El mes " + monthin.getName().toLowerCase() + " no tiene más de " + monthin.getDays() + " días."); return; }
        else if(yearin == yearnow && monthnow == monthin.getValue() && daynow < dayin) { this.discDay.setText("En el mes actual, no puedes escoger un día futuro"); return; }

        int accYears = yearnow - yearin;
        if(monthnow < monthin.getValue()) accYears--;
        else if(monthnow == monthin.getValue() && daynow < dayin) accYears--;

        this.result.setText("Tiene " + accYears + " años.");
    }

    @FXML public void actionClear() {
        this.inputYear.setText("");
        this.inputMonth.setValue("Enero");
        this.inputDay.setText("");
        this.result.setText("");
        this.disclaimerClear();
    }

    private void disclaimerClear() {
        this.discYear.setText("");
        this.discMonth.setText("");
        this.discDay.setText("");
    }
}
