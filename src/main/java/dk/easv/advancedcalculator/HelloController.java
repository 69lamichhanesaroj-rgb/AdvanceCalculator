package dk.easv.advancedcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField txtCalculate;
    private boolean state;
    private double input1;
    private double input2;
    private String operator;


    public void btn0(ActionEvent actionEvent) {
        if (!txtCalculate.getText().startsWith("0"))
            txtCalculate.setText(txtCalculate.getText()+"0");
    }

    public void btn1(ActionEvent actionEvent) {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("1");
        else
            txtCalculate.setText(txtCalculate.getText()+"1");
    }

    public void btn2(ActionEvent actionEvent) {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("2");
        else
            txtCalculate.setText(txtCalculate.getText()+"2");
    }

    public void btn3(ActionEvent actionEvent) {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("3");
        else
            txtCalculate.setText(txtCalculate.getText()+"3");
    }

    public void btn4(ActionEvent actionEvent) {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("4");
        else
            txtCalculate.setText(txtCalculate.getText()+"4");
    }

    public void btn5(ActionEvent actionEvent) {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("5");
        else
            txtCalculate.setText(txtCalculate.getText()+"5");
    }

    public void btn6(ActionEvent actionEvent) {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("6");
        else
            txtCalculate.setText(txtCalculate.getText()+"6");
    }

    public void btn7(ActionEvent actionEvent) {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("7");
        else
            txtCalculate.setText(txtCalculate.getText()+"7");
    }

    public void btn8(ActionEvent actionEvent) {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("8");
        else
            txtCalculate.setText(txtCalculate.getText()+"8");
    }

    public void btn9(ActionEvent actionEvent) {
        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0"))
            txtCalculate.setText("9");
        else
            txtCalculate.setText(txtCalculate.getText()+"9");
    }

    public void btnPl(ActionEvent actionEvent) {
        if (input1 == 0) {
            input1 = Double.parseDouble(txtCalculate.getText());
            operator = "+";
            txtCalculate.setText("0");
            state = true;
        }
        else {
            operator = "+";
        }
    }

    public void btnMi(ActionEvent actionEvent) {
        if (input1 == 0) {
            input1 = Double.parseDouble(txtCalculate.getText());
            operator = "-";
            txtCalculate.setText("0");
            state = true;
        }
        else {
            operator = "-";
        }
    }

    public void btnMu(ActionEvent actionEvent) {
        if (input1 == 0) {
            input1 = Double.parseDouble(txtCalculate.getText());
            operator = "*";
            txtCalculate.setText("0");
            state = true;
        }
        else {
            operator = "*";
        }
    }

    public void btnDi(ActionEvent actionEvent) {
        if (input1 == 0) {
            input1 = Double.parseDouble(txtCalculate.getText());
            operator = "/";
            txtCalculate.setText("0");
            state = true;
        }
        else {
            operator = "/";
        }
    }

    public void btnPr(ActionEvent actionEvent) {
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

    public void btnCo(ActionEvent actionEvent) {
        if (!txtCalculate.getText().contains("."))  //Checks if there is already comma
            txtCalculate.setText(txtCalculate.getText()+".");
    }

    public void btnClear(ActionEvent actionEvent) { //Button now clears the textfield and anything left in the memory
        txtCalculate.setText("0");
        input1 = 0;
        input2 = 0;
        operator = "";
        state = false;
    }

    public void btnPM(ActionEvent actionEvent) {
        if (!txtCalculate.getText().contains("-")){
            txtCalculate.setText("-"+txtCalculate.getText());
        }
        else {
            txtCalculate.setText(txtCalculate.getText().substring(1));
        }

    }
    public void btnEq(ActionEvent actionEvent) {
        if (state) {
            input2 = Double.parseDouble(txtCalculate.getText());
            txtCalculate.setText("");
            switch (operator) {
                case "+":
                    txtCalculate.setText(String.valueOf(input1 + input2));
                    break;
                case "-":
                    txtCalculate.setText(String.valueOf(input1 - input2));
                    break;
                case "*":
                    txtCalculate.setText(String.valueOf(input1 * input2));
                    break;
                case "/":
                    if (input2 == 0) {
                        txtCalculate.setText("Cannot divide by zero");
                    }
                    else {
                        txtCalculate.setText(String.valueOf(input1 / input2));
                    }
                    break;
                case "%":
                    txtCalculate.setText(String.valueOf(input1 % input2));
                    break;
            }
        }
        input1 = 0;
        input2 = 0;
        operator = "";
        state = false;
    }
}