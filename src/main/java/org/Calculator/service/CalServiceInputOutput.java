package org.Calculator.service;

/**
 * For Number, decimal inputs
 * And the equals, error output
 * and the Clear (AC/C) input
 */
public interface CalServiceInputOutput {

    /**If current input is null, returns running total as String,
     * If not nul, will return current input as String
     * @return current input or running total
     */
    public String getCalScreen();

    /** returns a basic error message for calculator
     * and sets the current input as error
     * @return error message
     */
    public String getErrorMessage();

    /**
     * Adds a digit or decimal point to the right of the current input
     * @param nextDigit the new digit to the current input
     */
    public void addDigitToCurrentInput(String nextDigit);


    /**If there is a current input, it will only clear current input,
     * If there isn't a current input, it will clear running total
     */
    public void ACButton();

    /**Swaps the current input negative or positive
     *
     */
    public void positiveNegative();

    /**Will process the current input.
     * Will cause an error message to appear if it can't process properly on the cal screen
     * @return true if no error happens, otherwise will return false
     */
    public boolean processCurrentInputSuccess();


    /**Will proccess the current
     *
     */
    public void completeEquals();





}
