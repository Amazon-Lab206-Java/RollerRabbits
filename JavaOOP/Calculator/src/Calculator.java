import org.omg.SendingContext.RunTime;

public class Calculator {
    private double operandOne;
    private String operation;
    private double operandTwo;
    private double results;

    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }

    public void performOperation() {
        switch (operation) {
            case "+":
                results = operandOne + operandTwo;
                break;
            case "-":
                results = operandOne - operandTwo;
                break;
            default:
                throw new RuntimeException("Unexpected operand");
        }
    }

    public double getResults() {
        return results;
    }
}
