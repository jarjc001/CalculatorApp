package org.Calculator.dao;

import org.Calculator.dto.CurrentInput;
import org.Calculator.dto.CurrentInputError;
import org.Calculator.dto.CurrentOutput;
import org.Calculator.dto.Operator;
import org.springframework.stereotype.Repository;

@Repository
public class CalDAOImpl implements CalDAO {

    //These objects will hold the infomation needed to run the app

    /**
     * The running total, this will be show when the '=' is pressed or before any current input is inputted
     */
    private CurrentOutput runningTotal = new CurrentOutput();
    /**
     * The current input, this is a string until a normal operator is chosen, then will be parsed into a double
     */
    private CurrentInput currentInput = new CurrentInput();

    /**
     * the current operator, this will take be performed on the running total and the current input
     * when '=' or another operator is pressed
     */
    private Operator currentOperator = Operator.NOTHING;

    @Override
    public CurrentInput getCurrentInput() {
        return currentInput;
    }
    @Override
    public void addToCurrentInput(String newDigit) {  // add something for null
        currentInput.setInputStr(currentInput.getInputStr()+newDigit);
    }

    @Override
    public void setCurrentInput(String newString) {
        currentInput.setInputStr(newString);
    }

    @Override
    public void processCurrentInput() throws CurrentInputError {
        currentInput.parseCurrentInputToDouble();
        currentInput.setInputStr("");
    }

    @Override
    public void processCurrentInputToStr(Double currentNumber){
        String inputStr = currentNumber.toString();
        currentInput.setInputStr(inputStr);
    }


    @Override
    public boolean isCurrentInputVoid() {
        return currentInput.getInputStr().equals("");
    }


    @Override
    public void positiveNegativeInput(){
        try {
            Character firstChar = currentInput.getInputStr().charAt(0);
            if (firstChar.equals('-')) {
                // is a negative number -> change to positive
                String[] tempArrStr = currentInput.getInputStr().split("-");
                currentInput.setInputStr(tempArrStr[1]);
                return;
            }
        }catch (StringIndexOutOfBoundsException e){ //encase there is not current input eg: just after an equals
            currentInput.setInputStr("");
        }catch (ArrayIndexOutOfBoundsException f){ // for just "-"
            currentInput.setInputStr("");
            return;
        }
        // is a positive number -> change to negative
        currentInput.setInputStr("-" + currentInput.getInputStr());
    }

    @Override
    public CurrentOutput getRunningTotal() {
        return runningTotal;
    }

    @Override
    public void setRunningTotal(double newTotal) {
        runningTotal.setOutputDou(newTotal);

    }

    @Override
    public void processRunningTotal() {
        runningTotal.parseCurrentOutputToStr();
    }

    @Override
    public void setNewOperator(Operator name) {
        currentOperator = name;
    }

    @Override
    public Operator getCurrentOperator() {
        return currentOperator;
    }
}
