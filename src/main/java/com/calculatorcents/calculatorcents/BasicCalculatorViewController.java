package com.calculatorcents.calculatorcents;

        import javafx.application.Platform;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.MenuItem;
        import javafx.scene.control.TextField;
        import javafx.scene.input.ContextMenuEvent;
        import javafx.scene.input.KeyEvent;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.GridPane;

        import java.net.URL;
        import java.text.DecimalFormat;
        import java.util.Objects;
        import java.util.ResourceBundle;

public class BasicCalculatorViewController implements Initializable {

    @FXML
    private GridPane gridPane;

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
    private Button buttonEqualInvisable;

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
    void buttonEqualEntered(ActionEvent event) {
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
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void buttonPlusMinusClicked(MouseEvent event) {
        CalcVals.PlusMinus();
        Display();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Display();
    }

    private void Display()
    {
        textFieldMainDisplay.setText(String.valueOf(new DecimalFormat("#,##0.#######").format(CalcVals.DisplayNumber)));
    }

    @FXML
    void keyPressed(KeyEvent event) {
        String key = String.valueOf(event.getCode());
        if (Objects.equals(key, "NUMPAD1") || Objects.equals(key, "1") || Objects.equals(key, "DIGIT1"))
        {
            CalcVals.PressNumber(1);
            Display();
        }
        else if (Objects.equals(key, "NUMPAD2") || Objects.equals(key, "2") || Objects.equals(key, "DIGIT2"))
        {
            CalcVals.PressNumber(2);
            Display();
        }
        else if (Objects.equals(key, "NUMPAD3") || Objects.equals(key, "3") || Objects.equals(key, "DIGIT3"))
        {
            CalcVals.PressNumber(3);
            Display();
        }
        else if (Objects.equals(key, "NUMPAD4") || Objects.equals(key, "4") || Objects.equals(key, "DIGIT4"))
        {
            CalcVals.PressNumber(4);
            Display();
        }
        else if (Objects.equals(key, "NUMPAD5") || Objects.equals(key, "5") || Objects.equals(key, "DIGIT5"))
        {
            CalcVals.PressNumber(5);
            Display();
        }
        else if (Objects.equals(key, "NUMPAD6") || Objects.equals(key, "6") || Objects.equals(key, "DIGIT6"))
        {
            CalcVals.PressNumber(6);
            Display();
        }
        else if (Objects.equals(key, "NUMPAD7") || Objects.equals(key, "7") || Objects.equals(key, "DIGIT7"))
        {
            CalcVals.PressNumber(7);
            Display();
        }
        else if (Objects.equals(key, "NUMPAD8") || Objects.equals(key, "8") || Objects.equals(key, "DIGIT8"))
        {
            CalcVals.PressNumber(8);
            Display();
        }
        else if (Objects.equals(key, "NUMPAD9") || Objects.equals(key, "9") || Objects.equals(key, "DIGIT9"))
        {
            CalcVals.PressNumber(9);
            Display();
        }
        else if (Objects.equals(key, "NUMPAD0") || Objects.equals(key, "0") || Objects.equals(key, "DIGIT0"))
        {
            CalcVals.PressNumber(0);
            Display();
        }
        else if (Objects.equals(key, "ADD") || (Objects.equals(key, "EQUALS") && event.isShiftDown()))
        {
            CalcVals.PressOperation('+');
            Display();
        }
        else if (Objects.equals(key, "SUBTRACT") || Objects.equals(key, "MINUS"))
        {
            CalcVals.PressOperation('-');
            Display();
        }
        else if (Objects.equals(key, "MULTIPLY"))
        {
            CalcVals.PressOperation('*');
            Display();
        }
        else if (Objects.equals(key, "DIVIDE") || Objects.equals(key, "SLASH"))
        {
            CalcVals.PressOperation('/');
            Display();
        }
        else if (Objects.equals(key, "ENTER"))
        {
            CalcVals.PressEnter();
            Display();
        }
        else if (Objects.equals(key, "BACK_SPACE") || Objects.equals(key, "DELETE"))
        {
            CalcVals.Clear();
            Display();
        }
        else if (Objects.equals(key, "%") || Objects.equals(key, "p") || Objects.equals(key, "P") || (key == "DIGIT5" && event.isShiftDown()))
        {
            CalcVals.Percent();
            Display();
        }
        else if (Objects.equals(key, "R") || Objects.equals(key, "r"))
        {
            CalcVals.Sqrt();
            Display();
        }

    }
    @FXML
    void textFieldAction(ActionEvent event) {
        gridPane.requestFocus();
    }


}
