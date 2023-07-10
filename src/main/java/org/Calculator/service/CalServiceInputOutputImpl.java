package org.Calculator.service;


import org.Calculator.dao.CalDAO;
import org.Calculator.dto.CurrentInputError;
import org.Calculator.dto.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalServiceInputOutputImpl implements CalServiceInputOutput{

    @Autowired
    CalDAO dao;



    @Override
    public String getCalScreen() {
        if(dao.isCurrentInputVoid()){
            return dao.getRunningTotal().getOutputStr();
        }
        return dao.getCurrentInput().getInputStr();
    }

    @Override
    public String getErrorMessage() {
        dao.setCurrentInput("ERROR");
        return "ERROR";
    }


    @Override
    public void addDigitToCurrentInput(String nextDigit) {
        dao.addToCurrentInput(nextDigit);
    }

    @Override
    public void ACButton() {
        if(dao.isCurrentInputVoid()){
            dao.setRunningTotal(0);
        }
        dao.setCurrentInput("");
    }

    @Override
    public void completeEquals() {
        try{
            dao.processCurrentInput();
        } catch (CurrentInputError e) {
            getErrorMessage();
            /// fix so that it skips
            return;
        }
        double total = dao.getRunningTotal().getOutputDou();
        double input = dao.getCurrentInput().getInputDou();

        switch (dao.getCurrentOperator()) {
            case ADD -> dao.setRunningTotal(total + input);
            case SUBTRACT -> dao.setRunningTotal(total - input);        // add the minius speacal case
            case MULTIPLY -> dao.setRunningTotal(total * input);
            case DIVIDE -> dao.setRunningTotal(total / input);          //add the error speacal case
            case NOTHING -> dao.setRunningTotal(input);         //maybe wrong
        }

        dao.processRunningTotal();
        dao.setNewOperator(Operator.NOTHING);

    }


}
