package aplication;

import entities.Champion;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner (System.in);



        System.out.println("Digite os dados do primeiro campeão: ");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Vida inicial: ");
        int life = sc.nextInt();
        sc.nextLine();
        System.out.print("Ataque: ");
        int attack = sc.nextInt();
        sc.nextLine();
        System.out.print("Armadura: ");
        int armor = sc.nextInt();
        sc.nextLine();

        Champion champ = new Champion (name, life, attack, armor);
        System.out.println();

        System.out.println("Digite os dados do segundo campeão: ");
        System.out.print("Nome: ");
        String name2 = sc.nextLine();
        System.out.print("Vida inicial: ");
        int life2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Ataque: ");
        int attack2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Armadura: ");
        int armor2 = sc.nextInt();
        sc.nextLine();

        Champion champ2 = new Champion (name2, life2, attack2, armor2);
        System.out.println();

        System.out.print("Quantos turnos você deseja executar? ");
        int turn = sc.nextInt();

        for (int i = 0; i < turn; i++){

            System.out.println("Resultado do turno " + (i + 1) + ":");
            champ2.takeDamage(champ);
            champ.takeDamage(champ2);
            System.out.println();
            System.out.println(champ.status());
            System.out.println(champ2.status());

            if (champ.getLife() == 0 || champ2.getLife() == 0){
                break;
            }
        }

        System.out.println("FIM DO COMBATE");



        sc.close();
    }
}
