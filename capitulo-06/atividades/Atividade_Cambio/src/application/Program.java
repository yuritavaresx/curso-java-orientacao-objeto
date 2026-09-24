package application;


import entities.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner (System.in);

        System.out.print("Qual o valor do dólar? ");
        CurrencyConverter.valueDolar = sc.nextDouble();
        System.out.println();
        System.out.print("Quantos dólares serão comprados? ");
        CurrencyConverter.quantityDolar = sc.nextDouble();
        System.out.println();
        System.out.printf("Valor a ser pago em reais = %.2f", CurrencyConverter.valueReal());



        sc.close();
    }
}
