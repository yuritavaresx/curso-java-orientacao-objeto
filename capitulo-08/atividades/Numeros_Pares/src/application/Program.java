package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int N = sc.nextInt();

        int[] numero = new int[N];

        for (int i = 0; i < N; i++){
            System.out.print("Digite um numero: ");
            numero[i] = sc.nextInt();
        }

        System.out.println();
        System.out.println("NUMEROS PARES: ");
        int contPares = 0;
        for (int i = 0; i < N; i++){
            if (numero[i] % 2 == 0){
                contPares++;
                System.out.print(numero[i] + "  ");
            }
        }

        System.out.println();
        System.out.println("QUANTIDADE DE PARES = " + contPares);

        sc.close();
    }
}

