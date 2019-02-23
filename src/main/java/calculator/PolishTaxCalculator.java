package calculator;

public class PolishTaxCalculator implements TaxCalculator {
    @Override
    public int calculateTax(int amountToCalculate) {
        return (int) (amountToCalculate * 1.23);
    }
}
