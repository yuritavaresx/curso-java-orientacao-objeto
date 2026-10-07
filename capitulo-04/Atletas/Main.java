import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Renda anual com salário: ");
        double salarioAnual = sc.nextDouble();

        System.out.print("Renda anual com prestação de serviço: ");
        double servicos = sc.nextDouble();

        System.out.print("Renda anual com ganho de capital: ");
        double ganhoCapital = sc.nextDouble();

        System.out.print("Gastos médicos: ");
        double gastosMedicos = sc.nextDouble();

        System.out.print("Gastos educacionais: ");
        double gastosEducacionais = sc.nextDouble();


        // =========================================
        // 1. IMPOSTO SOBRE O SALÁRIO
        // =========================================

        // Calcula o salário mensal
        double salarioMensal = salarioAnual / 12;

        double impostoSalario;

        if (salarioMensal < 3000.0) {
            // Abaixo de 3000: isento
            impostoSalario = 0.0;

        } else if (salarioMensal < 5000.0) {
            // De 3000 até abaixo de 5000: 10%
            impostoSalario = salarioMensal * 0.10 * 12;

        } else {
            // 5000 ou acima: 20%
            impostoSalario = salarioMensal * 0.20 * 12;
        }


        // =========================================
        // 2. IMPOSTO SOBRE SERVIÇOS
        // =========================================

        double impostoServicos = servicos * 0.15;


        // =========================================
        // 3. IMPOSTO SOBRE GANHO DE CAPITAL
        // =========================================

        double impostoCapital = ganhoCapital * 0.20;


        // =========================================
        // 4. IMPOSTO BRUTO TOTAL
        // =========================================

        double impostoBruto = impostoSalario
                + impostoServicos
                + impostoCapital;


        // =========================================
        // 5. DEDUÇÕES
        // =========================================

        // Soma dos gastos médicos e educacionais
        double gastosDedutiveis = gastosMedicos + gastosEducacionais;

        // O máximo que pode ser abatido é 30% do imposto bruto
        double maximoDedutivel = impostoBruto * 0.30;

        // O abatimento será o menor entre:
        // - gastos dedutíveis
        // - máximo permitido
        double abatimento;

        if (gastosDedutiveis < maximoDedutivel) {
            abatimento = gastosDedutiveis;
        } else {
            abatimento = maximoDedutivel;
        }


        // =========================================
        // 6. IMPOSTO DEVIDO
        // =========================================

        double impostoDevido = impostoBruto - abatimento;


        // =========================================
        // 7. RELATÓRIO
        // =========================================

        System.out.println();
        System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
        System.out.println();

        System.out.println("CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: %.2f%n", impostoSalario);
        System.out.printf("Imposto sobre serviços: %.2f%n", impostoServicos);
        System.out.printf("Imposto sobre ganho de capital: %.2f%n", impostoCapital);

        System.out.println();
        System.out.println("DEDUÇÕES:");
        System.out.printf("Máximo dedutível: %.2f%n", maximoDedutivel);
        System.out.printf("Gastos dedutíveis: %.2f%n", gastosDedutiveis);

        System.out.println();
        System.out.println("RESUMO:");
        System.out.printf("Imposto bruto total: %.2f%n", impostoBruto);
        System.out.printf("Abatimento: %.2f%n", abatimento);
        System.out.printf("Imposto devido: %.2f%n", impostoDevido);


        sc.close();
    }
}
