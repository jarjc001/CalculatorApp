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
        String output;

        if(dao.isCurrentInputVoid()){
            output = dao.getRunningTotal().getOutputStr();
        }else{
            output = dao.getCurrentInput().getInputStr();
        }

        //limit the digits on screen
        if (output.length() >14){
            String sciForm = "";
            // if in scientific form
            if(output.contains("E")){
                int indexOfE = output.indexOf("E");
                sciForm = output.substring(indexOfE);
                return output.substring(0, 10) + sciForm ;
            }

            return output.substring(0, 14);

        }
        return output;


       // return dao.getCurrentInput().getInputStr();

        //maybe do a check for floating point
        // and may be do an operator thing at the end?
        // but keep it sepaerte from dao?
    }

    @Override
    public String getErrorMessage() {
        dao.setCurrentInput("ERROR");
        return "ERROR";
    }


    @Override
    public void addDigitToCurrentInput(String nextDigit) {
        if(dao.getCurrentInput().getInputStr().equals("ERROR")){
            ACButton();
        }
        dao.addToCurrentInput(nextDigit);
    }

    @Override
    public void ACButton() {
        if(dao.isCurrentInputVoid()){
            dao.setRunningTotal(0);  // add a string thing to it too
            dao.processRunningTotal();
            dao.setNewOperator(Operator.NOTHING);
        }
        dao.setCurrentInput("");
    }

    @Override
    public void positiveNegative(){
        dao.positiveNegativeInput();
    }

    @Override
    public void completeEquals() {
        try{
            // to check if the is an error in input
            dao.processCurrentInput();          //do if there is a running total
        } catch (CurrentInputError e) {
            if(dao.getRunningTotal().getOutputDou() == 0.0){
                getErrorMessage();
            }
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
