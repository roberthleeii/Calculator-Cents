module com.calculatorcents.calculatorcents {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.calculatorcents.calculatorcents to javafx.fxml;
    exports com.calculatorcents.calculatorcents;
}