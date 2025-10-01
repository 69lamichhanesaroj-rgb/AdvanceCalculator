package dk.easv.advancedcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField txtCalculate;
    private boolean state = true;
    private double input1;
    private double input2;
    private String operator;


    public void btn0(ActionEvent actionEvent) {
        txtCalculate.setText(txtCalculate.getText()+"0");
    }

    public void btn1(ActionEvent actionEvent) {
        txtCalculate.setText(txtCalculate.getText()+"1");
    }

    public void btn2(ActionEvent actionEvent) {
        txtCalculate.setText(txtCalculate.getText()+"2");
    }

    public void btn3(ActionEvent actionEvent) {
        txtCalculate.setText(txtCalculate.getText()+"3");
    }

    public void btn4(ActionEvent actionEvent) {
        txtCalculate.setText(txtCalculate.getText()+"4");
    }

    public void btn5(ActionEvent actionEvent) {
        txtCalculate.setText(txtCalculate.getText()+"5");
    }

    public void btn6(ActionEvent actionEvent) {
        txtCalculate.setText(txtCalculate.getText()+"6");
    }

    public void btn7(ActionEvent actionEvent) {
        txtCalculate.setText(txtCalculate.getText()+"7");
    }

    public void btn8(ActionEvent actionEvent) {
        txtCalculate.setText(txtCalculate.getText()+"8");
    }

    public void btn9(ActionEvent actionEvent) {
        txtCalculate.setText(txtCalculate.getText()+"9");
    }

    public void btnPl(ActionEvent actionEvent) {
        input1 = Double.parseDouble(txtCalculate.getText());
        operator = "+";
        txtCalculate.setText("");
    }

    public void btnMi(ActionEvent actionEvent) {
        input1 = Double.parseDouble(txtCalculate.getText());
        operator = "-";
        txtCalculate.setText("");
    }

    public void btnMu(ActionEvent actionEvent) {
        input1 = Double.parseDouble(txtCalculate.getText());
        operator = "*";
        txtCalculate.setText("");
    }

    public void btnDi(ActionEvent actionEvent) {
        input1 = Double.parseDouble(txtCalculate.getText());
        operator = "/";
        txtCalculate.setText("");
    }

    public void btnPr(ActionEvent actionEvent) {
        input1 = Double.parseDouble(txtCalculate.getText());
        operator = "%";
        txtCalculate.setText("");
    }

    public void btnCo(ActionEvent actionEvent) {
        txtCalculate.setText(txtCalculate.getText()+".");

    }

    public void btnClear(ActionEvent actionEvent) {
        txtCalculate.setText("");
    }

    public void btnPM(ActionEvent actionEvent) {
    }

    public void btnEq(ActionEvent actionEvent) {
        input2 = Double.parseDouble(txtCalculate.getText());
        txtCalculate.setText("");
        switch (operator) {
            case "+":
                txtCalculate.setText(String.valueOf(input1+input2));
                break;
            case "-":
                txtCalculate.setText(String.valueOf(input1-input2));
                break;
            case "*":
                txtCalculate.setText(String.valueOf(input1*input2));
                break;
            case "/":
                txtCalculate.setText(String.valueOf(input1/input2));
                break;
            case "%":
                txtCalculate.setText(String.valueOf(input1%input2));
        }
    }
}
