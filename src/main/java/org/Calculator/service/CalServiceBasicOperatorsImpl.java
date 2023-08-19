package org.Calculator.service;

import org.Calculator.dao.CalDAO;
import org.Calculator.dto.CurrentInputError;
import org.Calculator.dto.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalServiceBasicOperatorsImpl implements CalServiceBasicOperators {
    @Autowired
    CalDAO dao;

    @Autowired
    CalServiceInputOutput inputOutput;

    @Override
    public void plus() {
        dao.setNewOperator(Operator.ADD);
    }

    @Override
    public void minus() {
        dao.setNewOperator(Operator.SUBTRACT);
    }

    @Override
    public void multiply() {
        dao.setNewOperator(Operator.MULTIPLY);
    }

    @Override
    public void divide() {
        dao.setNewOperator(Operator.DIVIDE);
    }

    @Override
    public Double specialOpCheck() {

        if (dao.isCurrentInputVoid()) {
            Double currentNumber = dao.getRunningTotal().getOutputDou();
            dao.setRunningTotal(0.0);
            return currentNumber;
        }
        if (inputOutput.processCurrentInputSuccess()) {
            return dao.getCurrentInput().getInputDou();
        }

        return null;

    }


    @Override
    public void square() {

        //  check if input is null or not
        // if current input is void, use running total -> set running total as zero
        // if not use current output
        Double currentNumber = specialOpCheck();

        // if there was an error in getting the current number
        if(currentNumber == null){
            return;
        }

        currentNumber = Math.pow(currentNumber,2);

        //then set as current input
        dao.processCurrentInputToStr(currentNumber);
    }

    @Override
    public void sqrt() {
        //sqrt the current number on screen

        //  check if input is null or not
        // if current input is void, use running total -> set running total as zero
        // if not use current output
        Double currentNumber = specialOpCheck();

        // if there was an error in getting the current number
        if(currentNumber == null){
            return;
        }

        //checks if the number is less than zero -> don't do imaginary numbers
        // will set the running total back to itself again
        if(currentNumber < 0.0){
            inputOutput.getErrorMessage();
            dao.setRunningTotal(currentNumber);
            return;
        }

        currentNumber = Math.pow(currentNumber,0.5);

        //then set as current input
        dao.processCurrentInputToStr(currentNumber);
    }


}
