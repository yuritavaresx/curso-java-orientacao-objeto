package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int N = sc.nextInt();

        double[] numero = new double[N];

        for (int i = 0; i < N; i++){
            System.out.print("Digite um numero: ");
            numero[i] = sc.nextDouble();
        }

        double maior = 0;
        int posicao = 0;
        for (int i = 0; i < N; i++){
           if (numero[i] > maior){
               maior = numero[i];
               posicao = i;
           }
        }


        System.out.println();
        System.out.printf("MAIOR VALOR = %.1f%n", maior);
        System.out.println("POSICAO DO MAIOR VALOR = " + posicao);

        sc.close();
    }
}
