package org.Calculator.service;

import org.Calculator.dao.CalDAO;
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
        if(dao.isCurrentInputVoid()){
            dao.addToCurrentInput("-");
        }else{
            dao.setNewOperator(Operator.SUBTRACT);
        }

    }

    @Override
    public void multiply() {
        dao.setNewOperator(Operator.MULTIPLY);
    }

    @Override
    public void divide() {
        if(dao.isCurrentInputVoid()) {
           inputOutput.getErrorMessage();
        }else {
            dao.setNewOperator(Operator.DIVIDE);
        }

    }
}
