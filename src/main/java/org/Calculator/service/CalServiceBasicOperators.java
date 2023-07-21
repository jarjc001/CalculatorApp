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
     * will give an error if divide by zero
     */
    public void divide();




}
