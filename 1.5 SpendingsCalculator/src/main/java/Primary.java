import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Primary implements Initializable {

    @FXML VBox vboxTypes;
    @FXML VBox vboxValues;
    @FXML Label lblTotalSpent;
    @FXML Label lblHighestCost;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Spendings.load();
        actionClear();
        
        for(Spendings.Spending spend : Spendings.spendings) {
            vboxTypes.getChildren().addAll(new Label(spend.name));
            vboxValues.getChildren().add(new TextField());
        }
    }

    @FXML public void actionCalc() {
        for(int i = 0; i < Spendings.spendings.size(); i++) {
            TextField node = (TextField) vboxValues.getChildren().get(i);
            Spendings.spendings.get(i).cost = Integer.parseInt(node.getText());
        }
        
        lblTotalSpent.setText("Total semanal: " + Spendings.getTotal());
        lblHighestCost.setText("Gasto más alto: " + Spendings.getHighest().name);
    }

    @FXML public void actionClear() {
        lblTotalSpent.setText("Total semanal: --");
        lblHighestCost.setText("Gasto más alto: --");
        for(int i = 0; i < vboxValues.getChildren().size(); i++) {
            TextField node = (TextField) vboxValues.getChildren().get(i);
            node.setText("");
        }
    }

}