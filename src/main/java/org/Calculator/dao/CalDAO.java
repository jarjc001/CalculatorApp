package org.Calculator.dao;

import org.Calculator.dto.CurrentInput;
import org.Calculator.dto.CurrentInputError;
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

    /**Process the current input to be usable as a double
     * @throws CurrentInputError if the current input is not in number format
     */
    public void processCurrentInput() throws CurrentInputError;

    /**Gets the current input as a double
     * @return current input
     */
    public CurrentInput getCurrentInput();

    /**Checks if the current input is void
     * @return true if void
     */
    public boolean isCurrentInputVoid();

    /** get the running total as a double
     * @return the current running total
     */
    public double getRunningTotal();

    /**
     * Set the running total to a new total
     * @param newTotal the new running total
     */
    public void setRunningTotal(double newTotal);

    /**Sets a new current Operator
     * @param name the new Current operator
     */
    public void setNewOperator(Operator name);

    /** get the current operator
     * @return the current operator
     */
    public Operator getCurrentOperator();


}
