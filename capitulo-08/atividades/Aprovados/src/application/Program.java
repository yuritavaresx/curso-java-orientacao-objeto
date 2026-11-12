package application;

import entities.Aluno;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos alunos serao digitados? ");
        int N = sc.nextInt();

        Aluno[] alunos = new Aluno[N];

        for (int i = 0; i < alunos.length; i++){
            System.out.println("Digite nome, primeira e segunda nota do " +  (i + 1) + "o aluno:");
            sc.nextLine();
            String name = sc.nextLine();
            double n1 = sc.nextDouble();
            sc.nextLine();
            double n2 = sc.nextDouble();
            alunos[i] = new Aluno(name, n1, n2);
        }

        System.out.println();
        System.out.println("Alunos aprovados: ");
        for (int i = 0; i < alunos.length; i++){
            if (alunos[i].mediaAluno() >= 6.0){
                System.out.println(alunos[i].getName());
            }
        }



        sc.close();
    }
}
