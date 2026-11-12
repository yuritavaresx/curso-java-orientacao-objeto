package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serao digitadas? ");
        int N = sc.nextInt();

        char[] genero = new char[N];
        double[] altura = new double[N];

        for (int i = 0; i < N; i++) {
            System.out.print("Altura da " + (i + 1) + "a pessoa: ");
            altura[i] = sc.nextDouble();
            System.out.print("Genero da " + (i + 1) + "a pessoa: ");
            genero[i] = sc.next().charAt(0);
        }


        double menor = altura[0];
        for (int i = 0; i < altura.length; i++) {
            if (altura[i] < menor) {
                menor = altura[i];
            }
        }

        double maior = altura[0];
        for (int i = 0; i < altura.length; i++) {
            if (altura[i] > maior) {
                maior = altura[i];
            }
        }

        System.out.println();
        System.out.printf("Menor altura = %.2f%n", menor);
        System.out.printf("Maior altura = %.2f%n", maior);

        double soma = 0.0;
        int contMulheres = 0;
        int contHomens = 0;
        for (int i = 0; i < genero.length; i++) {
            if (genero[i] == 'f' || genero[i] == 'F') {
                soma += altura[i];
                contMulheres++;
            }
            else {
                contHomens++;
            }
        }

        double media = soma / (double) contMulheres;

        System.out.printf("Media das alturas das mulheres = %.2f%n", media);
        System.out.print("Numero de homens = " + contHomens);

        sc.close();
    }
}
