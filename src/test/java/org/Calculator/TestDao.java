package org.Calculator;

import org.Calculator.dao.CalDAO;
import org.Calculator.dao.CalDAOImpl;
import org.Calculator.dto.CurrentInputError;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class TestDao {

    @Autowired
    CalDAO dao = new CalDAOImpl();


   //need to test:
   //add to current input
   // process current input
    // is current input void
    // positive/ negative


    // before each
    @BeforeEach
    public void setUp() {
        dao.setCurrentInput(""); // set the current input as empty
        dao.setRunningTotal(0.0);// set running total as 0.0
    }

    @Test
    public void testAddDigit(){
        // starting with empty current input
        // adds a 2 -> 2
        // then a 5 -> 25
        // then a . -> 25.
        // then a 3 -> 25.3
        // each is a string

        // the string it should be
        String shouldBeInput;

        //2
        dao.addToCurrentInput("2");
        shouldBeInput = "2";
        Assertions.assertEquals(shouldBeInput,dao.getCurrentInput().getInputStr());

        //25
        dao.addToCurrentInput("5");
        shouldBeInput = "25";
        Assertions.assertEquals(shouldBeInput,dao.getCurrentInput().getInputStr());

        dao.addToCurrentInput(".");
        shouldBeInput = "25.";
        Assertions.assertEquals(shouldBeInput,dao.getCurrentInput().getInputStr());

        dao.addToCurrentInput("3");
        shouldBeInput = "25.3";
        Assertions.assertEquals(shouldBeInput,dao.getCurrentInput().getInputStr());

    }

    @Test
    public void testProcessCurrentInput(){

        double actualInput;


        // = 13 -> 13
        //test the string part as well, check it is "" after process
        dao.getCurrentInput().setInputStr("13");
        try {
            dao.processCurrentInput();
        }catch (CurrentInputError ignored){}
        actualInput = 13.0;
        Assertions.assertEquals(actualInput, dao.getCurrentInput().getInputDou());
        Assertions.assertEquals("", dao.getCurrentInput().getInputStr());


        // = 45.6 -> 45.6
        dao.getCurrentInput().setInputStr("45.6");
        try {
            dao.processCurrentInput();
        }catch (CurrentInputError ignored){}
        actualInput = 45.6;
        Assertions.assertEquals(actualInput, dao.getCurrentInput().getInputDou());


        // = -55.10 -> -55.10
        dao.getCurrentInput().setInputStr("-55.10");
        try {
            dao.processCurrentInput();
        }catch (CurrentInputError ignored){}
        actualInput = -55.1;
        Assertions.assertEquals(actualInput, dao.getCurrentInput().getInputDou());


        // = 11..55 -> exception
        dao.getCurrentInput().setInputStr("11..55");
        try {
            dao.processCurrentInput();
        }catch (CurrentInputError e){
            dao.getCurrentInput().setInputStr("failed");
        }
        Assertions.assertEquals("failed", dao.getCurrentInput().getInputStr());


    }

    @Test
    public void testCurrentInputVoid(){
        // is void
        dao.getCurrentInput().setInputStr("");
        Assertions.assertTrue(dao.isCurrentInputVoid());

        // is not void
        dao.getCurrentInput().setInputStr("1234");
        Assertions.assertFalse(dao.isCurrentInputVoid());

        // is spaces instead
        dao.getCurrentInput().setInputStr("     ");
        Assertions.assertFalse(dao.isCurrentInputVoid());

    }


    @Test
    public void testCurrentInputNegativePositive(){
        //change from positive to negative
        dao.getCurrentInput().setInputStr("12.4");
        dao.positiveNegativeInput();
        Assertions.assertEquals("-12.4", dao.getCurrentInput().getInputStr());

        // change to negative to positive
        dao.getCurrentInput().setInputStr("-34.5");
        dao.positiveNegativeInput();
        Assertions.assertEquals("34.5", dao.getCurrentInput().getInputStr());

    }





    }





}
