package org.Calculator.dao;

import org.Calculator.dto.Operator;
import org.springframework.stereotype.Repository;

@Repository
public class CalDAOImpl implements CalDAO {

    //These objects will hold the infomation needed to run the app

    /**
     * The running total, this will be show when the '=' is pressed or before any current input is inputted
     */
    private double runningTotal;
    /**
     * The current input, this is a string until a normal operator is chosen, then will be parsed into a double
     */
    private String currentInputStr;
    private double currentInputDou;
    /**
     * the current operator, this will take be performed on the running total and the current input
     * when '=' or another operator is pressed
     */
    private Operator currentOperator;


    @Override
    public void setCurrentInputStr(String newString) {

    }

    @Override
    public void addToCurrentInputStr(String newDigit) {

    }

    @Override
    public void parseCurrentInputToDouble() {

    }

    @Override
    public double getCurrentInputDouble() {
        return 0;
    }

    @Override
    public boolean isCurrentInputVoid() {
        return false;
    }

    @Override
    public double getRunningTotal() {
        return 0;
    }

    @Override
    public void setRunningTotal(double newTotal) {

    }

    @Override
    public void setNewOperator(Operator name) {

    }

    @Override
    public Operator getCurrentOperator() {
        return null;
    }
}
