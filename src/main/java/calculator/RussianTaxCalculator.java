package calculator;

public class RussianTaxCalculator implements TaxCalculator {
    @Override
    public int calculateTax(int amountToCalculate) {
        return (int)(amountToCalculate*1.1);
    }
}
