package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int N = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];
        int[] Soma = new int[N];

        System.out.println("Digite os valores do vetor A: ");
        for (int i = 0; i < A.length; i++){
            A[i] = sc.nextInt();
        }

        System.out.println("Digite os valores do vetor B: ");
        for (int i = 0; i < B.length; i++){
            B[i] = sc.nextInt();
        }

        for (int i = 0; i <Soma.length; i++){
            Soma[i] = A[i] + B[i];
        }

        System.out.println("VETOR RESULTANTE: ");
        for (int i = 0; i <Soma.length; i++){
            System.out.println(Soma[i]);
        }

        sc.close();
    }
}