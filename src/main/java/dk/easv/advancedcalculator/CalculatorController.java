package dk.easv.advancedcalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private Button Pl;
    @FXML
    private Button Mi;
    @FXML
    private Button Mu;
    @FXML
    private Button Di;

    @FXML
    private TextField txtCalculate;
    private boolean state;
    private double input1;
    private double input2;
    private double result;
    private String operator;

    public void btn0() {
        if (!txtCalculate.getText().startsWith("0"))
            txtCalculate.setText(txtCalculate.getText()+"0");
    }

    public void btn1() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("1");
        else
            txtCalculate.setText(txtCalculate.getText()+"1");
    }

    public void btn2() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("2");
        else
            txtCalculate.setText(txtCalculate.getText()+"2");
    }

    public void btn3() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("3");
        else
            txtCalculate.setText(txtCalculate.getText()+"3");
    }

    public void btn4() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("4");
        else
            txtCalculate.setText(txtCalculate.getText()+"4");
    }

    public void btn5() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("5");
        else
            txtCalculate.setText(txtCalculate.getText()+"5");
    }

    public void btn6() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("6");
        else
            txtCalculate.setText(txtCalculate.getText()+"6");
    }

    public void btn7() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("7");
        else
            txtCalculate.setText(txtCalculate.getText()+"7");
    }

    public void btn8() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("8");
        else
            txtCalculate.setText(txtCalculate.getText()+"8");
    }

    public void btn9() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("9");
        else
            txtCalculate.setText(txtCalculate.getText()+"9");
    }

    public void ClearOperatorHighlights() {
        Pl.setStyle("-fx-background-color: #E4983C; fx-text-fill: black;");
        Mi.setStyle("-fx-background-color: #E4983C; fx-text-fill: black;");
        Mu.setStyle("-fx-background-color: #E4983C; fx-text-fill: black;");
        Di.setStyle("-fx-background-color: #E4983C; fx-text-fill: black;");
    }

    public void higllightOperator(Button button) {
        ClearOperatorHighlights();
        button.setStyle("-fx-background-color: black; -fx-text-fill: #E4983C;");
    }

    public void btnPl() {
        if (input1 == 0) {
            input1 = Double.parseDouble(txtCalculate.getText());
            operator = "+";
            txtCalculate.setText("0");
            state = true;
        }
        else {
            operator = "+";
        }
        higllightOperator(Pl);
    }

    public void btnMi() {
        if (input1 == 0) {
            input1 = Double.parseDouble(txtCalculate.getText());
            operator = "-";
            txtCalculate.setText("0");
            state = true;
        }
        else {
            operator = "-";
        }
        higllightOperator(Mi);
    }

    public void btnMu() {
        if (input1 == 0) {
            input1 = Double.parseDouble(txtCalculate.getText());
            operator = "*";
            txtCalculate.setText("0");
            state = true;
        }
        else {
            operator = "*";
        }
        higllightOperator(Mu);
    }

    public void btnDi() {
        if (input1 == 0) {
            input1 = Double.parseDouble(txtCalculate.getText());
            operator = "/";
            txtCalculate.setText("0");
            state = true;
        }
        else {
            operator = "/";
        }
        higllightOperator(Di);
    }

    public void btnPr() {
        if (input1 == 0) {
            input1 = Double.parseDouble(txtCalculate.getText());
            operator = "%";
            txtCalculate.setText("0");
            state = true;
        }
        else {
            operator = "%";
        }
    }

    public void btnCo() {
        if (!txtCalculate.getText().contains("."))  //Checks if there is already comma
            txtCalculate.setText(txtCalculate.getText()+".");
    }

    public void btnClear() { //Button now clears the text field and anything left in the memory
        txtCalculate.setText("0");
        input1 = 0;
        input2 = 0;
        result = 0;
        operator = "";
        state = false;
        ClearOperatorHighlights();
    }

    public void btnPM() {
        if (!txtCalculate.getText().contains("-")){
            txtCalculate.setText("-"+txtCalculate.getText());
        }
        else {
            txtCalculate.setText(txtCalculate.getText().substring(1));
        }

    }
    public void btnEq() {
        if (state) {
            input2 = Double.parseDouble(txtCalculate.getText());
            txtCalculate.setText("");
            switch (operator) {
                case "+":
                    result = input1 + input2;
                    break;
                case "-":
                    result = input1 - input2;
                    break;
                case "*":
                    result = input1 * input2;
                    break;
                case "/":
                    if (input2 == 0) {
                        txtCalculate.setText("Cannot divide by zero");
                        input1 = 0;
                        input2 = 0;
                        operator = "";
                        state = false;
                    }
                    else {
                    result = input1 / input2;
                    }
                    break;
                case "%":
                    result = input1 % input2;
                    break;
            }
            if (result == (long) result) {
                txtCalculate.setText(String.format("%d", (long) result));
            }
            else {
                txtCalculate.setText(String.valueOf(result));
            }
        }
        input1 = 0;
        input2 = 0;
        result = 0;
        operator = "";
        state = false;
        ClearOperatorHighlights();
    }
}