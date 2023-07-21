package org.Calculator.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.Calculator.service.CalServiceBasicOperators;
import org.Calculator.service.CalServiceInputOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.sound.midi.Soundbank;

@Controller
public class CalController {
    @Autowired
    CalServiceInputOutput inputOutput;
    @Autowired
    CalServiceBasicOperators basicOp;

    private String numberTest = "";

    public String displayCalScreen(Model model){
        model.addAttribute("screen",inputOutput.getCalScreen());
        System.out.println(inputOutput.getCalScreen());  //testing

        return "Calculator";
    }

    @GetMapping("Calculator")
    public String showCalculator(Model model) {
        return displayCalScreen(model);
    }

    @PostMapping("numberButton")
    public String displayCal(Model model, HttpServletRequest request){
        String number = request.getParameter("number");
        //numberTest += number;        //testing
        inputOutput.addDigitToCurrentInput(number);
        return displayCalScreen(model);
    }

    @PostMapping("AC")
    public String AC(Model model){
        inputOutput.ACButton();
        return displayCalScreen(model);
    }


    @PostMapping("equals")
    public String equalsButton(Model model){
        inputOutput.completeEquals();
        return displayCalScreen(model);

    }

    @PostMapping("changeSign")
    public String changeSignButton(Model model){
        inputOutput.positiveNegative();
        return  displayCalScreen(model);
    }



    @PostMapping("operator")
    public String operatorButton(Model model , HttpServletRequest request){
        String operator = request.getParameter("operator");
        inputOutput.completeEquals();
        switch (operator) {
            case "plus" -> basicOp.plus();
            case "minus" -> basicOp.minus();
            case "multiply" -> basicOp.multiply();
            case "divide" -> basicOp.divide();
        }


        return displayCalScreen(model);
    }



    //substract

    //mutiple

    // divide


    //equals


    //square


    //sqrt


    //ac/c




}
