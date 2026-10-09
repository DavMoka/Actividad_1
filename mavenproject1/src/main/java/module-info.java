module davtests.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens davtests.mavenproject1 to javafx.fxml;
    exports davtests.mavenproject1;
}
