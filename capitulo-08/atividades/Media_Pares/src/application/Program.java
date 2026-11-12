package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos elementos vai ter o vetor? ");
        int N = sc.nextInt();

        int[] numero = new int[N];

        for (int i = 0; i < numero.length; i++){
            System.out.print("Digite um numero: ");
            numero[i] = sc.nextInt();
        }


        int somaPar = 0;
        int contPar = 0;
        for (int i = 0; i < numero.length; i++){
            if (numero[i] % 2 == 0){
                somaPar += numero[i];
                contPar++;
            }
        }


        if (contPar > 0){
            double mediaPar = (double)somaPar / contPar;
            System.out.printf("MEDIA DOS PARES = %.1f%n", mediaPar);
        }
        else {
            System.out.println("NENHUM NUMERO PAR");
        }



        sc.close();
    }
}

