package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas voce vai digitar? ");
        int N = sc.nextInt();

        String[] nome = new String[N];
        int[] idade = new int[N];

        for (int i = 0; i < idade.length; i++){
            System.out.println("Dados da " + (i + 1) + "a pessoa: ");
            sc.nextLine();
            System.out.print("Nome: ");
            nome[i] = sc.nextLine();
            System.out.print("Idade: ");
            idade[i] = sc.nextInt();
        }


        int maisVelho = 0;
        for (int i = 0; i < idade.length; i++){
           if (idade[i] > idade[maisVelho]){

               maisVelho = i;
           }
        }

        System.out.println();
        System.out.println("PESSOA MAIS VELHA: " + nome[maisVelho]);

        sc.close();
    }
}
