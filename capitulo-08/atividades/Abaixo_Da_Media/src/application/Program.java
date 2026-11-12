package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos elementos vai ter o vetor? ");
        int N = sc.nextInt();

        double[] numero = new double[N];

        for (int i = 0; i < numero.length; i++){
            System.out.print("Digite um numero: ");
            numero[i] = sc.nextDouble();
        }

        double soma = 0.0;
        for (int i = 0; i < numero.length; i++){
            soma += numero[i];
        }

        double media = soma / numero.length;
        System.out.println();
        System.out.printf("MEDIA DO VETOR = %.3f%n", media);
        System.out.println("ELEMENTOS ABAIXO DA MEDIA: ");
        for (int i = 0; i < numero.length; i++){
            if (numero[i] < media){
                System.out.println(numero[i]);
            }
        }


        sc.close();
    }
}
