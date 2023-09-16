package com.calculatorcents.calculatorcents;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.MenuItem;
        import javafx.scene.control.TextArea;
        import javafx.scene.input.ContextMenuEvent;
        import javafx.scene.input.MouseEvent;

        import java.net.URL;
        import java.util.ResourceBundle;

public class BasicCalculatorViewController implements Initializable {

    @FXML
    private Button button0;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonClear;

    @FXML
    private Button buttonDecimal;

    @FXML
    private Button buttonDivide;

    @FXML
    private Button buttonEqual;

    @FXML
    private Button buttonMultiply;

    @FXML
    private Button buttonPercent;

    @FXML
    private Button buttonSqrt;

    @FXML
    private Button buttonSubtract;

    @FXML
    private MenuItem menuItemExit;

    @FXML
    private TextArea textAreaMainDisplay;

    @FXML
    void buttonClearClicked(MouseEvent event) {

    }

    @FXML
    void buttonDecimalClicked(MouseEvent event) {

    }

    @FXML
    void buttonEqualClicked(ContextMenuEvent event) {

    }

    @FXML
    void buttonNumberClicked(MouseEvent event) {

    }

    @FXML
    void buttonOperatorClicked(MouseEvent event) {

    }

    @FXML
    void buttonPercentClicked(MouseEvent event) {

    }

    @FXML
    void buttonSqrtClicked(MouseEvent event) {

    }

    @FXML
    void exitApplication(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textAreaMainDisplay.setText("0");
        CalculatorClass Calc = new CalculatorClass();
    }
}
