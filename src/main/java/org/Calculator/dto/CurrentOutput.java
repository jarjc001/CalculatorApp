package org.Calculator.dto;

import java.util.Objects;

/**
 * Used for outputs
 */
public class CurrentOutput {

    private String outputStr;

    private Double outputDou;

    public CurrentOutput() {
        this.outputDou = (double) 0;
        this.outputStr = "";
    }

    public void setOutputStr(String outputStr) {
        this.outputStr = outputStr;
    }

    public void setOutputDou(double outputDou) {
        this.outputDou = outputDou;
    }

    public String getOutputStr() {
        return outputStr;
    }

    public double getOutputDou() {
        return outputDou;
    }

    public void parseCurrentOutputToStr() {

        this.outputStr = outputDou.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentOutput that = (CurrentOutput) o;
        return Double.compare(that.outputDou, outputDou) == 0 && Objects.equals(outputStr, that.outputStr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(outputStr, outputDou);
    }
}
