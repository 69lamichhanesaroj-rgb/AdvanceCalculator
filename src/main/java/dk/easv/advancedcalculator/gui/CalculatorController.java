package dk.easv.advancedcalculator.gui;

import dk.easv.advancedcalculator.bll.CalculatorLogic;
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
    private Button Pr;
    @FXML
    private Button PM;
    @FXML
    private Button Cl;
    @FXML
    private Button b0;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;
    @FXML
    private Button Co;
    @FXML
    private Button Eq;

    @FXML
    private TextField txtCalculate;
    private boolean state;
    private double input1;
    private double input2;
    private double result;
    private String operator;

    private CalculatorLogic Logic = new CalculatorLogic();

    public void btn0() {
        if (!txtCalculate.getText().startsWith("0") || txtCalculate.getLength()!=1)
            txtCalculate.setText(txtCalculate.getText()+"0");
        higllightButton(b0);
    }

    public void btn1() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("1");
        else
            txtCalculate.setText(txtCalculate.getText()+"1");
        higllightButton(b1);
    }

    public void btn2() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("2");
        else
            txtCalculate.setText(txtCalculate.getText()+"2");
        higllightButton(b2);
    }

    public void btn3() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("3");
        else
            txtCalculate.setText(txtCalculate.getText()+"3");
        higllightButton(b3);
    }

    public void btn4() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("4");
        else
            txtCalculate.setText(txtCalculate.getText()+"4");
        higllightButton(b4);
    }

    public void btn5() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("5");
        else
            txtCalculate.setText(txtCalculate.getText()+"5");
        higllightButton(b5);
    }

    public void btn6() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("6");
        else
            txtCalculate.setText(txtCalculate.getText()+"6");
        higllightButton(b6);
    }

    public void btn7() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("7");
        else
            txtCalculate.setText(txtCalculate.getText()+"7");
        higllightButton(b7);
    }

    public void btn8() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("8");
        else
            txtCalculate.setText(txtCalculate.getText()+"8");
        higllightButton(b8);
    }

    public void btn9() {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("9");
        else
            txtCalculate.setText(txtCalculate.getText()+"9");
        higllightButton(b9);
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
        higllightOperator(Pr);
    }

    public void btnCo() {
        if (!txtCalculate.getText().contains("."))  //Checks if there is already comma
            txtCalculate.setText(txtCalculate.getText()+".");
        higllightOperator(Co);
    }

    public void btnClear() { //Button now clears the text field and anything left in the memory
        txtCalculate.setText("0");
        input1 = 0;
        input2 = 0;
        result = 0;
        operator = "";
        state = false;
        higllightButton(Cl);
    }

    public void btnPM() {
        if (!txtCalculate.getText().contains("-")){
            txtCalculate.setText("-"+txtCalculate.getText());
        }
        else {
            txtCalculate.setText(txtCalculate.getText().substring(1));
        }
        higllightOperator(PM);

    }

    public void btnEq() {
        if (state) {
            input2 = Double.parseDouble(txtCalculate.getText());
            txtCalculate.setText("");
            String result = Logic.calculate(input1, input2, operator);
            txtCalculate.setText(result);
        }
        input1 = 0;
        input2 = 0;
        result = 0;
        operator = "";
        state = false;
        ClearOperatorHighlights();
        higllightButton(Eq);
    }

    public void ClearOperatorHighlights() {
        Pl.setStyle("-fx-background-color: #3d1679; fx-text-fill: black;");
        Mu.setStyle("-fx-background-color: #3d1679; fx-text-fill: black;");
        Mi.setStyle("-fx-background-color: #3d1679; fx-text-fill: black;");
        Di.setStyle("-fx-background-color: #3d1679; fx-text-fill: black;");
        Pr.setStyle("-fx-background-color: lightgray;");
        PM.setStyle("-fx-background-color: lightgray;");
        Cl.setStyle("-fx-background-color: lightgray;");
        b0.setStyle("-fx-background-color: lightgray;");
        b1.setStyle("-fx-background-color: lightgray;");
        b2.setStyle("-fx-background-color: lightgray;");
        b3.setStyle("-fx-background-color: lightgray;");
        b4.setStyle("-fx-background-color: lightgray;");
        b5.setStyle("-fx-background-color: lightgray;");
        b6.setStyle("-fx-background-color: lightgray;");
        b7.setStyle("-fx-background-color: lightgray;");
        b8.setStyle("-fx-background-color: lightgray;");
        b9.setStyle("-fx-background-color: lightgray;");
        Co.setStyle("-fx-background-color: lightgray;");
        Eq.setStyle("-fx-background-color: lightgray;");
    }

    public void higllightOperator(Button button) {
        ClearOperatorHighlights();
        button.setStyle("-fx-background-color: gray; -fx-text-fill: #3d1679;");
    }
    public void higllightButton(Button button) {
        ClearOperatorHighlights();
        button.setStyle("-fx-background-color: gray;");
    }

    public CalculatorLogic getLogic() {
        return Logic;
    }

    public void setLogic(CalculatorLogic logic) {
        Logic = logic;
    }
}