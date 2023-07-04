package org.Calculator.dao;

import org.Calculator.dto.Operator;

public class CalDAO {

    //These objects will hold the infomation needed to run the app

    /** The running total, this will be show when the '=' is pressed or before any current input is inputted */
    double runningTotal;
    /** The current input, this is a string until a normal operator is chosen, then will be parsed into a double*/
    String currentInputStr;
    double currentInputDou;
    /** the current operator, this will take be performed on the running total and the current input
     *  when '=' or another operator is pressed */
    Operator currentOperator;




}
