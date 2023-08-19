package org.Calculator.service;

/**
 * The operations are here:
 * plus
 * minis
 * multiply
 * divide
 */
public interface CalServiceBasicOperators {

    /**Sets the new operator as plus
     */
    public void plus();

    /**Sets the new operator as minus
     */
    public void minus();

    /**Sets the new operator as multiply
     */
    public void multiply();

    /**Sets the new operator as divide,
     * will give infinity for divide zero
     */
    public void divide();

    /**Will check which number (current input or running total) to use the special
     * op on (square or sqrt).
     * If running total, will set the running total to zero.
     * If currnt input is an error, will show an error sign.
     * @return the number to do the special op on or null if error
     */
    public Double specialOpCheck();

    /**Will square the current number on screen:
     * either running total or current input
     * then set the current input as the square number
     */
    public void square();

    /**Will sqrt the current number on screen:
     * either running total or current input
     * then set the current input as the sqrt number.
     * if the current number is < 0, will produce an error message
     */
    public void sqrt();


}
