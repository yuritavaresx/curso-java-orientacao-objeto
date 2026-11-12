package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int N = sc.nextInt();

        double[] vect = new double[N];

        for (int i = 0; i < N; i++){
            System.out.print("Digite um numero: ");
            vect[i] = sc.nextDouble();
        }

        System.out.print("VALORES = ");
        for (int i = 0; i < N; i++){
            System.out.print(vect[i] + "  ");
        }

        double soma = 0.0;
        for (int i = 0; i < N; i++){
            soma += vect[i];
        }

        double media = soma / N;

        System.out.println();
        System.out.printf("SOMA = %.2f%n", soma);
        System.out.printf("MEDIA = %.2f%n", media);


        sc.close();
    }
}
