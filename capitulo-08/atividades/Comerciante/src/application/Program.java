package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Serao digitados dados de quantos produtos? ");
        int N = sc.nextInt();

        String[] nome = new String[N];
        double[] compra = new double[N];
        double[] venda = new double[N];

        for (int i = 0; i < N; i++) {
            sc.nextLine();
            System.out.println("Produto " + (i + 1) + ":");
            System.out.print("Nome: ");
            nome[i] = sc.nextLine();
            System.out.print("Preco de compra: ");
            compra[i] = sc.nextDouble();
            System.out.print("Preco de venda: ");
            venda[i] = sc.nextDouble();
        }

        System.out.println();
        System.out.println("RELATORIO: ");

        int abaixo = 0;
        int entre = 0;
        int acima = 0;
        for (int i = 0; i < N; i++) {

            double percentual = (venda[i] - compra[i]) / compra[i] * 100;

            if (percentual < 10){
                abaixo++;
            }
            else if (percentual <= 20) {
                entre++;
            }
            else {
                acima++;
            }

        }


        double totalCompra = 0.0;
        double totalVenda = 0.0;
        for (int i = 0; i < N; i++) {
            totalCompra += compra[i];
            totalVenda += venda[i];
        }

        double lucroTotal = (totalVenda - totalCompra);

        System.out.println("Lucro abaixo de 10%: " + abaixo);
        System.out.println("Lucro entre 10% e 20%: " + entre);
        System.out.println("Lucro acima de 20%: " + acima);
        System.out.printf("Valor total de compra: %.2f%n", totalCompra);
        System.out.printf("Valor total de venda: %.2f%n", totalVenda);
        System.out.printf("Lucro total: %.2f%n", lucroTotal);



        sc.close();
    }
}
