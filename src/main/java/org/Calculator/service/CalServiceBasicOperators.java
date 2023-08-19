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

    /**Will square the current number on screen:
     * either running total or current input
     * then set the current input as the square number
     */
    public void square();




}
