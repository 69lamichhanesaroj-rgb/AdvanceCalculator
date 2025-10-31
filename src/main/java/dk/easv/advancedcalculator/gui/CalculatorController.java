package dk.easv.advancedcalculator.gui;

import dk.easv.advancedcalculator.bll.CalculatorLogic;
import javafx.event.ActionEvent;
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
    private boolean operatorState;
    private double input1;
    private double input2;
    private String operator;

    private final CalculatorLogic Logic = new CalculatorLogic();

    /**
     * Instead of having multiple methods for each button (which resulted in having a lot of copy and pase code),
     * now we have two different methods that are handling numbers and operators accordingly.
     */
    public void numberBtnClick(ActionEvent event) { //numberBtnClick Handles the number button from range 1-9 (number 0 is special)
        Button source = (Button) event.getSource(); //Looks for the button that was clicked
        String number = source.getUserData().toString(); //The variable "number" Gets "userData" from that button

        if (txtCalculate.getLength()==1 && txtCalculate.getText().startsWith("0")) //Small check to see if there is a "starting zero"
            txtCalculate.setText(number); //Sets text with an according number
        else
            txtCalculate.setText(txtCalculate.getText()+number); //adds a number to the existing text
        highlightButton(source); //Highlights the number that was clicked
    }

    public void operatorBtnClick(ActionEvent event) { //operatorBtnClick Handles the operator buttons "+, -, *, /, %"
        Button source = (Button) event.getSource(); //Looks for the button that was clicked
        operator = source.getUserData().toString(); //The variable "operator" Gets "userData" from that button

        if (!operatorState) { //Checks to see if there already is if the operator was used
            input1 = Double.parseDouble(txtCalculate.getText()); //Takes text from TextField and puts it into input1
            txtCalculate.setText("0"); //Sets text as zero
            operatorState = true; //Informs that the operator was used
        }
        highlightOperator(source); //Highlights the operator that was clicked
    }

    /**
     * Button 0 is special. Because the calculator always shows 0 when nothing is typed, we don't want the user to type
     * multiple 0 (e.g. 000 or 0001), but we still want the user to be able to type after another number was used
     * or a coma (e.g. 1000 or 0.00001). That's why we check if there isn't any 0 and if the length of the text
     * is greater than 1.
     */
    public void btn0() {
        if (!txtCalculate.getText().startsWith("0") || txtCalculate.getLength()!=1) //Checks if there isn't a zero and the length isn't greater than 1
            txtCalculate.setText(txtCalculate.getText()+"0"); //Inserts 0
        highlightButton(b0); //Highlights button
    }

    public void btnCo() {
        if (!txtCalculate.getText().contains("."))  //Checks if there is already a comma
            txtCalculate.setText(txtCalculate.getText()+"."); //Inserts comma
        highlightOperator(Co); //Highlights button
    }

    public void btnClear() { //Clears the text field and sets everything to the default position
        txtCalculate.setText("0");
        input1 = 0;
        input2 = 0;
        operator = "";
        operatorState = false;
        highlightButton(Cl);
    }

    public void btnPM() { //Inverts the number
        if (!txtCalculate.getText().contains("-")){ //Checks if there isn't any "-"
            txtCalculate.setText("-"+txtCalculate.getText()); //Inserts "-" in front of the number
        }
        else {
            txtCalculate.setText(txtCalculate.getText().substring(1)); //Removes the first character (in this case "-")
        }
        highlightOperator(PM); //Guess what? it highlights the button

    }

    /**
     * This method actually calculates something! ... well, not really, it Calls the logic thingy that does calculations
     * which I will explain later because I'm tired.
     * Later to be expanded to other operators so that the User doesn't have to press the equal button everytime.
     */
    public void btnEq() {
        if (operatorState) { //Checks if the operatorState is true
            input2 = Double.parseDouble(txtCalculate.getText()); //Puts everything that is in TextField and inserts it into input2
            txtCalculate.setText(""); //Clears TextField
            String result = Logic.calculate(input1, input2, operator); //Calls the Calculate method from CalculatorLogic
            txtCalculate.setText(result); //Displays the results
        }
        //Sets everything to default just like the clear button
        input1 = 0;
        input2 = 0;
        operator = "";
        operatorState = false;
        ClearOperatorHighlights();
        highlightButton(Eq);
    }

    /**
     * Default colour for the buttons when the ClearButton is pressed
     * In the future to be optimised
     * !Warning! This won't change the starting colours when the program is initialised, only when the clear button is pressed.
     * In the future this needs fixing
     */
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

    /**
     * Those two are just highlighting the buttons that were clicked
     */
    public void highlightOperator(Button button) {
        ClearOperatorHighlights();
        button.setStyle("-fx-background-color: gray; -fx-text-fill: #3d1679;");
    }
    public void highlightButton(Button button) {
        ClearOperatorHighlights();
        button.setStyle("-fx-background-color: gray;");
    }
}
//Have fun adding anything later with those comments in the way
