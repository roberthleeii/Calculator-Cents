package com.calculatorcents.calculatorcents;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.MenuItem;
        import javafx.scene.control.TextField;
        import javafx.scene.input.ContextMenuEvent;
        import javafx.scene.input.MouseEvent;
        import java.net.URL;
        import java.text.DecimalFormat;
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
    private TextField textFieldMainDisplay;

    CalculatorClass CalcVals = new CalculatorClass();
    @FXML
    void buttonClearClicked(MouseEvent event) {
        CalcVals.Clear();
        Display();
    }

    @FXML
    void buttonEqualClicked(MouseEvent event) {
        CalcVals.PressEnter();
        Display();
    }

    @FXML
    void buttonNumberClicked(MouseEvent event) {

        Button source = (Button)event.getSource();

        if (source.getId().equals("buttonDecimal"))
        {
            CalcVals.PressDecimal();
            Display();
            return;
        }

        int n = switch (source.getId()) {
            case "button0" -> 0;
            case "button1" -> 1;
            case "button2" -> 2;
            case "button3" -> 3;
            case "button4" -> 4;
            case "button5" -> 5;
            case "button6" -> 6;
            case "button7" -> 7;
            case "button8" -> 8;
            case "button9" -> 9;
            default -> 0;
        };
        CalcVals.PressNumber(n);
        Display();
    }

    @FXML
    void buttonOperatorClicked(MouseEvent event) {

        Button source = (Button)event.getSource();
        char n = switch (source.getId()) {
            case "buttonAdd" -> '+';
            case "buttonSubtract" -> '-';
            case "buttonMultiply" -> '*';
            case "buttonDivide" -> '/';
            default -> 'm';
        };
        CalcVals.PressOperation(n);
        Display();

    }

    @FXML
    void buttonPercentClicked(MouseEvent event) {
        CalcVals.Percent();
        Display();
    }

    @FXML
    void buttonSqrtClicked(MouseEvent event) {
        CalcVals.Sqrt();
        Display();
    }

    @FXML
    void exitApplication(ActionEvent event) {


    }

    @FXML
    void buttonPlusMinusClicked(MouseEvent event) {
        CalcVals.PlusMinus();
        Display();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //textFieldMainDisplay.setText(String.valueOf(CalcVals.DisplayNumber));
        Display();
    }

    private void Display()
    {
        textFieldMainDisplay.setText(String.valueOf(new DecimalFormat("#,##0.#######").format(CalcVals.DisplayNumber)));
    }

}
