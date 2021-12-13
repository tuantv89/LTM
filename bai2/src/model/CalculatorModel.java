package model;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class CalculatorModel {

    private Double firstNumber, secondNumber;
    private char operator;

    public CalculatorModel() {
    }

    public CalculatorModel(Double firstNumber, Double secondNumber, char operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
    }

    public Double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

}
