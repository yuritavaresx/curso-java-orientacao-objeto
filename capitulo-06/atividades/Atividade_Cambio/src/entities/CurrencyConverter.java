package entities;

public class CurrencyConverter {

    public static double valueDolar;
    public static double quantityDolar;

    public static double valueReal(){
        double value = valueDolar * quantityDolar;
        double valueFinal = value + value * 0.06;
        return valueFinal;
    }
}
