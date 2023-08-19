package org.Calculator.dao;

import org.Calculator.dto.CurrentInput;
import org.Calculator.dto.CurrentInputError;
import org.Calculator.dto.CurrentOutput;
import org.Calculator.dto.Operator;

public interface CalDAO {

    /**Set the current input with string
     * @param newString new input string
     */
    public void setCurrentInput(String newString);

    /**Adds a digit to the current inputStr
     * @param newDigit the new digit to add
     */
    public void addToCurrentInput(String newDigit);

    /**Process the current input to be usable as a double, then clears the input string
     * @throws CurrentInputError if the current input is not in number format
     */
    public void processCurrentInput() throws CurrentInputError;

    /**
     * Turn a double into the current input str
     * @param currentNumber the double to be set as the current input str
     */
    public void processCurrentInputToStr(Double currentNumber);

    /**Gets the current input as a double
     * @return current input
     */
    public CurrentInput getCurrentInput();

    /**Checks if the current input is void
     * @return true if void
     */
    public boolean isCurrentInputVoid();

    /**Swaps the input str to negative or positive
     */
    public void positiveNegativeInput();

    /**
     * get the running total as a double
     *
     * @return the current running total
     */
    public CurrentOutput getRunningTotal();

    /**
     * Set the running total to a new total
     * @param newTotal the new running total
     */
    public void setRunningTotal(double newTotal);

    /**Process the current total to be usable as a String
     */
    public void processRunningTotal();


    /**Sets a new current Operator
     * @param name the new Current operator
     */
    public void setNewOperator(Operator name);

    /** get the current operator
     * @return the current operator
     */
    public Operator getCurrentOperator();


}
