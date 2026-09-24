package application;

import entities.Bill;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner (System.in);

        Bill bills = new Bill();

        System.out.print("Sexo: ");
        bills.gender = sc.next().charAt(0);
        System.out.print("Quantidade de cervejas: ");
        bills.beer = sc.nextInt();
        System.out.print("Quantidade de refrigerantes: ");
        bills.softDrink = sc.nextInt();
        System.out.print("Quantidade de espetinhos: ");
        bills.barbecue = sc.nextInt();

        System.out.println();
        System.out.println("RELATÓRIO: ");


        System.out.printf("Consumo = R$ %.2f",bills.feeding());

        System.out.println();
        if (bills.cover() == 0.0){
            System.out.println("Isento de Couvert");
        } else if (bills.cover() == 4.0) {
            System.out.printf("Couvert = R$ %.2f",bills.cover());
        }
        System.out.printf("Ingresso = R$ %.2f",bills.ticket());

        System.out.println();
        System.out.printf("Valor a pagar = R$ %.2f",bills.total());





        sc.close();
    }
}
