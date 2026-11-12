package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serao digitadas? ");
        int N = sc.nextInt();

        String[] Nome = new String[N];
        int[] Idade = new int[N];
        double[] Altura = new double[N];

        for (int i = 0; i < N; i++){
            System.out.println("Dados da " + (i + 1) + "a pessoa: ");
            sc.nextLine();
            System.out.print("Nome: ");
            Nome[i] = sc.nextLine();
            System.out.print("Idade: ");
            Idade[i] = sc.nextInt();
            System.out.print("Altura: ");
            Altura[i] = sc.nextDouble();
        }

        double soma = 0.0;
        for (int i = 0; i < Idade.length; i++){
            soma += Altura[i];
        }

        System.out.println();
        double mediaAltura = soma / Idade.length;
        System.out.printf("Altura média: %.2f%n", mediaAltura);


        int contMenor = 0;
        for (int i = 0; i < Idade.length; i++){
            if (Idade[i] < 16){
                contMenor++;
            }
        }

        double porcentagem = ((double)contMenor / Idade.length) * 100.0;
        System.out.printf("Pessoas com menos de 16 anos: %.1f%n%%", porcentagem);
        for (int i = 0; i < Idade.length; i++){
            if (Idade[i] < 16){
                System.out.println(Nome[i]);
            }
        }


        sc.close();
    }
}
