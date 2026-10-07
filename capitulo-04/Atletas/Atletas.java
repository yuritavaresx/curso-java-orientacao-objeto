import java.util.Locale;
import java.util.Scanner;

public class Atletas {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual a quantidade de atletas? ");
        int N = sc.nextInt();
        sc.nextLine();

        String nome;
        char sexo;
        double altura, peso;

        //Variaveis contadores;
        double contAltura = 0.0;
        double somaPeso = 0.0;
        String pessoaAlta = "";
        double contHomens = 0.0;
        double mulherAlt = 0.0;
        double contMulheres = 0.0;

        // Entrada de Dados;
        for (int i = 0; i < N; i++){
            System.out.println ("Digite os dados do atleta numero " + (i+1) + ":");
            System.out.print ("Nome: ");
            nome = sc.nextLine();
            System.out.print ("Sexo: ");
            sexo = sc.next().charAt(0);
            while (sexo != 'M' && sexo != 'm' && sexo != 'F' && sexo != 'f'){
                System.out.println ("Valor invalido! Favor digitar F ou M: ");
                sexo = sc.next().charAt(0);
            }
            if (sexo == 'M' || sexo == 'm'){
                contHomens++;
            }
            System.out.print ("Altura: ");
            altura = sc.nextDouble();
            while (altura <= 0.0){
                System.out.println ("Valor invalido! Favor digitar um valor positivo: ");
                altura = sc.nextDouble();
            }
            if (sexo == 'F' || sexo == 'f'){
                mulherAlt += altura;
                contMulheres++;
            }
            if (altura > contAltura){
                contAltura = altura;
                pessoaAlta = nome;
            }
            System.out.print ("Peso: ");
            peso = sc.nextDouble();
            while (peso <= 0.0){
                System.out.println ("Valor invalido! Favor digitar um valor positivo: ");
                peso = sc.nextDouble();
            }
            somaPeso += peso;
            sc.nextLine();
        }

        double mediaPeso = somaPeso / N;
        double porcentHomem = (contHomens / N) * 100.0;

        System.out.println ();
        System.out.println ("RELATÓRIO: ");
        System.out.printf ("Peso médio dos atletas: %.2f%n", mediaPeso);
        System.out.println ("Atleta mais alto: "+ pessoaAlta);
        System.out.printf ("Porcentagem de homens: %.1f %%%n", porcentHomem);

        if (contMulheres > 0){
            double mediaAltMulheres = mulherAlt / contMulheres;
            System.out.printf ("Altura média das mulheres: %.2f%n", mediaAltMulheres);
        } else {
            System.out.println ("Não há mulheres cadastradas");
        }
    }
}