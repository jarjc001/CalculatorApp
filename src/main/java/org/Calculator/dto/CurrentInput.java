package org.Calculator.dto;

public class CurrentInput {


    private String inputStr;

    private double inputDou;

    public CurrentInput() {
        this.inputStr = "";
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }

    public void setInputDou(double inputDou) {
        this.inputDou = inputDou;
    }

    public String getInputStr() {
        return inputStr;
    }

    public double getInputDou() {
        return inputDou;
    }
}
