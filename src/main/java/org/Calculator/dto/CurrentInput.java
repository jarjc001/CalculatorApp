package org.Calculator.dto;

import java.util.Objects;

/**
 * Used for inputs
 */
public class CurrentInput {


    private String inputStr;

    private Double inputDou;

    public CurrentInput() {
        this.inputStr = "";
        this.inputDou = (double) 0;
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

    public void parseCurrentInputToDouble() throws CurrentInputError {
        try{
            this.inputDou = Double.parseDouble(this.inputStr);
        } catch (NumberFormatException e) {
            throw new CurrentInputError("Input not valid");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentInput that = (CurrentInput) o;
        return Double.compare(that.inputDou, inputDou) == 0 && Objects.equals(inputStr, that.inputStr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputStr, inputDou);
    }
}
