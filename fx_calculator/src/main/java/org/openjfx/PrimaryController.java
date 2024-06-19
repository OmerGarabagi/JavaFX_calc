package org.openjfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrimaryController implements Initializable {

    public Button btn_3;
    public Button btn_A;
    public Button btn_B;
    public Button btn_C;
    public Button btn_D;
    public Button btn_E;
    public Button btn_F;
    public Button btn_4;
    public Button btn_7;
    public Button btn_2;
    public Button btn_5;
    public Button btn_8;
    public Button btn_6;
    public Button btn_9;
    public Button btn_0;
    public Button btn_1;
    @FXML
    private TextField textField;
    @FXML
    private ComboBox<String> comboBase;
    private String[] bases = {"HEX","DEC","OCT","BIN"};
    int combo_base_int=16;
    int combo_base_int_prev=combo_base_int;
    String currentNumber = "";
    int status=0;         // 0=expression is being typed, 1=expression calculated

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBase.getItems().addAll(bases);
        comboBase.setValue(bases[0]);
    }

    public void addNumberToTextField(String number) {
        currentNumber += number;
        updateTextField();
    }

    public void updateTextField() {
        textField.setText(currentNumber);
    }

    public void comboBoxChange(){
        String combo_base_str = comboBase.getSelectionModel().getSelectedItem();
        if (combo_base_str == "HEX") {
            combo_base_int_prev=combo_base_int;
            combo_base_int = 16;
            btn_A.setDisable(false);
            btn_B.setDisable(false);
            btn_C.setDisable(false);
            btn_D.setDisable(false);
            btn_E.setDisable(false);
            btn_F.setDisable(false);
            btn_9.setDisable(false);
            btn_8.setDisable(false);
            btn_7.setDisable(false);
            btn_6.setDisable(false);
            btn_5.setDisable(false);
            btn_4.setDisable(false);
            btn_3.setDisable(false);
            btn_2.setDisable(false);
            btn_1.setDisable(false);
            btn_0.setDisable(false);
        }
        else if (combo_base_str == "DEC") {
            combo_base_int_prev=combo_base_int;
            combo_base_int = 10;
            btn_A.setDisable(true);
            btn_B.setDisable(true);
            btn_C.setDisable(true);
            btn_D.setDisable(true);
            btn_E.setDisable(true);
            btn_F.setDisable(true);
            btn_9.setDisable(false);
            btn_8.setDisable(false);
            btn_7.setDisable(false);
            btn_6.setDisable(false);
            btn_5.setDisable(false);
            btn_4.setDisable(false);
            btn_3.setDisable(false);
            btn_2.setDisable(false);
            btn_1.setDisable(false);
            btn_0.setDisable(false);
        }
        else if (combo_base_str == "OCT") {
            combo_base_int_prev=combo_base_int;
            combo_base_int = 8;
            btn_A.setDisable(true);
            btn_B.setDisable(true);
            btn_C.setDisable(true);
            btn_D.setDisable(true);
            btn_E.setDisable(true);
            btn_F.setDisable(true);
            btn_9.setDisable(true);
            btn_8.setDisable(true);
            btn_7.setDisable(false);
            btn_6.setDisable(false);
            btn_5.setDisable(false);
            btn_4.setDisable(false);
            btn_3.setDisable(false);
            btn_2.setDisable(false);
            btn_1.setDisable(false);
            btn_0.setDisable(false);
        }
        else if (combo_base_str == "BIN") {
            combo_base_int_prev=combo_base_int;
            combo_base_int = 2;
            btn_A.setDisable(true);
            btn_B.setDisable(true);
            btn_C.setDisable(true);
            btn_D.setDisable(true);
            btn_E.setDisable(true);
            btn_F.setDisable(true);
            btn_9.setDisable(true);
            btn_8.setDisable(true);
            btn_7.setDisable(true);
            btn_6.setDisable(true);
            btn_5.setDisable(true);
            btn_4.setDisable(true);
            btn_3.setDisable(true);
            btn_2.setDisable(true);
            btn_1.setDisable(false);
            btn_0.setDisable(false);
        }
        if (status == 0) {
            currentNumber=convertBaseExpression(currentNumber,combo_base_int_prev,combo_base_int);
            textField.setText(currentNumber);
        }
        else if (status == 1) {
            textField.setText(convertBaseExpression(textField.getText(), combo_base_int_prev,combo_base_int));
        }

    }

    @FXML
    public void zero(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("0");
    }

    @FXML
    public void one(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("1");
    }

    @FXML
    public void two(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("2");
    }

    @FXML
    public void three(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("3");
    }

    @FXML
    public void four(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("4");
    }

    @FXML
    public void five(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("5");
    }

    @FXML
    public void six(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("6");
    }

    @FXML
    public void seven(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("7");
    }

    @FXML
    public void eight(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("8");
    }

    @FXML
    public void nine(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("9");
    }

    @FXML
    public void A(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("A");
    }

    @FXML
    public void B(ActionEvent event) throws IOException {
        checkStatus();
       addNumberToTextField("B");
    }

    @FXML
    public void C(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("C");
    }

    @FXML
    public void D(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("D");
    }

    @FXML
    public void E(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("E");
    }

    @FXML
    public void F(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("F");
    }

    @FXML
    public void plus(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("+");
    }

    @FXML
    public void minus(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("-");
    }

    @FXML
    public void mul(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("*");
    }

    @FXML
    public void div(ActionEvent event) throws IOException {
        checkStatus();
        addNumberToTextField("/");
    }

    public void clear(ActionEvent event) throws IOException {
        textField.clear();
        currentNumber="";
        status=0;
    }

    @FXML
    public void equal(ActionEvent event) throws IOException {
        addNumberToTextField("=");
        String combo_base_str = comboBase.getSelectionModel().getSelectedItem();
        if (combo_base_str == "HEX") {
            combo_base_int_prev=combo_base_int;
            combo_base_int = 16;
        }
        else if (combo_base_str == "DEC") {
            combo_base_int_prev=combo_base_int;
            combo_base_int = 10;
        }
        else if (combo_base_str == "OCT") {
            combo_base_int_prev=combo_base_int;
            combo_base_int = 8;
        }
        else if (combo_base_str == "BIN") {
            combo_base_int_prev=combo_base_int;
            combo_base_int = 2;
        }
        status=1;
        calcAction(textField.getText(),combo_base_int);
    }

    public void checkStatus (){
        if (status==1){
            status=0;
            currentNumber="";
            textField.clear();
        }
    }

    public static String convertBaseExpression(String expression, int baseFrom, int baseTo) {
        StringBuilder result = new StringBuilder();
        String[] tokens = expression.split("(?=[-+/*=])|(?<=[-+/*=])");

        for (String token : tokens) {
            if (isOperator(token)) {
                result.append(token);
            } else {
                int decimal = Integer.parseInt(token, baseFrom);
                result.append(Integer.toString(decimal, baseTo).toUpperCase());
            }
        }

        return result.toString();
    }

    // Helper function to check if a string is an operator
    private static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("=");
    }

    public static String convertBase(String input, int base) {
        // Convert input string to BigInteger using base 16
        BigInteger value = new BigInteger(input, base);

        // Convert BigInteger to the specified base
        String result = value.toString(10);

        return result;
    }

    public static String[] splitExpression(String expression) {
        List<String> tokens = new ArrayList<>();
        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                // Build a string of alphanumeric characters (operand)
                StringBuilder operand = new StringBuilder();
                while (i < expression.length() && (Character.isLetterOrDigit(ch) || ch == '.')) {
                    operand.append(ch);
                    i++;
                    if (i < expression.length()) {
                        ch = expression.charAt(i);
                    }
                }
                tokens.add(operand.toString());
            } else {
                // Add the operator as a separate token
                tokens.add(String.valueOf(ch));
                i++;
            }
        }
        return tokens.toArray(new String[tokens.size()]);
    }

    public static String[] convertEvenIndexesToBase10(String[] splitArray, int base) {
        String[] convertedArray = new String[splitArray.length];
        for (int i = 0; i < splitArray.length; i++) {
            if (i % 2 == 0) { // Check if index is even
                convertedArray[i] = convertBase(splitArray[i], base);
            } else {
                convertedArray[i] = splitArray[i]; // Leave operators unchanged
            }
        }
        return convertedArray;
    }

    public static String convertToExpression(String[] tokens) {
        StringBuilder expression = new StringBuilder();
        for (String token : tokens) {
            expression.append(token);
        }
        return expression.toString();
    }

    public static String convertToBase(int number, int base) {
        return Integer.toString(number, base).toUpperCase(); // Convert to uppercase for bases larger than 10
    }

    private static boolean isValidExpression(String expression) {
        for (int i = 0; i < expression.length() - 1; i++) {
            char current = expression.charAt(i);
            char next = expression.charAt(i + 1);
            if ((current == '+' || current == '-' || current == '*' || current == '/') &&
                    (next == '+' || next == '-' || next == '*' || next == '/')) {
                return false; // Consecutive operators found
            }
        }
        return true; // No consecutive operators found
    }

    public static int evaluateExpression(String expression) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == ' ') {
                continue;
            } else if (Character.isDigit(ch)) {
                int operand = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    operand = operand * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--;
                operands.push(operand);
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    processOperator(operands, operators);
                }
                operators.pop(); // Remove '('
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    processOperator(operands, operators);
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            processOperator(operands, operators);
        }

        return operands.pop();
    }

    private static void processOperator(Stack<Integer> operands, Stack<Character> operators)
            throws ArithmeticException {
        char operator = operators.pop();
        int operand2 = operands.pop();
        int operand1 = operands.pop();
        int result;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException(
                            "Error: trying to divide by 0 (evaluated: \"" + operand2 + "\")");

                }
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
        operands.push(result);
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private void calcAction(String expression, int base) {

        String noSpacesExpression = expression.replaceAll("\\s+", "");
        String newExpression = "";

        newExpression = convertToExpression(convertEvenIndexesToBase10(splitExpression(noSpacesExpression), base));
        try {
            Integer calcRes = evaluateExpression(newExpression);
            textField.setText("");
            addNumberToTextField(String.valueOf(convertToBase(calcRes,combo_base_int)));
        }
        catch (ArithmeticException e) {
            textField.setText(e.getMessage());
        }
    }

}
