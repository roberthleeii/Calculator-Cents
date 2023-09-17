package com.calculatorcents.calculatorcents;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.MenuItem;
        import javafx.scene.control.TextArea;
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

    }

    @FXML
    void buttonEqualClicked(ContextMenuEvent event) {

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

        int n = 0;
        switch (source.getId())
        {
            case "button0":
                n = 0;
                break;
            case "button1":
                n = 1;
                break;
            case "button2":
                n = 2;
                break;
            case "button3":
                n = 3;
                break;
            case "button4":
                n = 4;
                break;
            case "button5":
                n = 5;
                break;
            case "button6":
                n = 6;
                break;
            case "button7":
                n = 7;
                break;
            case "button8":
                n = 8;
                break;
            case "button9":
                n = 9;
                break;
        }
        CalcVals.PressNumber(n);
        Display();
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
        //textFieldMainDisplay.setText(String.valueOf(CalcVals.DisplayNumber));
        Display();
    }

    private void Display()
    {
        textFieldMainDisplay.setText(String.valueOf(new DecimalFormat("#,##0.#######").format(CalcVals.DisplayNumber)));
    }

}
