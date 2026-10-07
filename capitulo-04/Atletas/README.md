# 🏃 Desafio Atletas — Relatório de Dados Esportivos

Exercício prático em **Java** desenvolvido durante o curso de Lógica de Programação e Algoritmos (Prof. Nélio Alves). O programa lê os dados de N atletas e gera um relatório estatístico com validação de entradas.

## 📋 Descrição do problema

Dado um número N de atletas (N > 0), o programa deve ler **nome, sexo, altura e peso** de cada um e, ao final, exibir um relatório contendo:

- Peso médio dos atletas
- Nome do atleta mais alto
- Porcentagem de homens
- Altura média das mulheres

**Regras de negócio:**
- Altura e peso devem ser valores positivos (validação com repetição)
- Sexo deve ser `F` ou `M` (maiúsculo ou minúsculo)
- Caso nenhuma mulher seja cadastrada, o programa não deve calcular a média de altura (divisão por zero) — deve exibir a mensagem **"Não há mulheres cadastradas"**

## 💻 Código final

```java
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

        // Variáveis acumuladoras
        double contAltura = 0.0;
        double somaPeso = 0.0;
        String pessoaAlta = "";
        double contHomens = 0.0;
        double mulherAlt = 0.0;
        double contMulheres = 0.0;

        // Entrada de dados
        for (int i = 0; i < N; i++){
            System.out.println("Digite os dados do atleta numero " + (i+1) + ":");
            System.out.print("Nome: ");
            nome = sc.nextLine();
            System.out.print("Sexo: ");
            sexo = sc.next().charAt(0);
            while (sexo != 'M' && sexo != 'm' && sexo != 'F' && sexo != 'f'){
                System.out.println("Valor invalido! Favor digitar F ou M: ");
                sexo = sc.next().charAt(0);
            }
            if (sexo == 'M' || sexo == 'm'){
                contHomens++;
            }
            System.out.print("Altura: ");
            altura = sc.nextDouble();
            while (altura <= 0.0){
                System.out.println("Valor invalido! Favor digitar um valor positivo: ");
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
            System.out.print("Peso: ");
            peso = sc.nextDouble();
            while (peso <= 0.0){
                System.out.println("Valor invalido! Favor digitar um valor positivo: ");
                peso = sc.nextDouble();
            }
            somaPeso += peso;
            sc.nextLine();
        }

        double mediaPeso = somaPeso / N;
        double porcentHomem = (contHomens / N) * 100.0;

        System.out.println();
        System.out.println("RELATÓRIO: ");
        System.out.printf("Peso médio dos atletas: %.2f%n", mediaPeso);
        System.out.println("Atleta mais alto: " + pessoaAlta);
        System.out.printf("Porcentagem de homens: %.1f %%%n", porcentHomem);

        if (contMulheres > 0){
            double mediaAltMulheres = mulherAlt / contMulheres;
            System.out.printf("Altura média das mulheres: %.2f%n", mediaAltMulheres);
        } else {
            System.out.println("Não há mulheres cadastradas");
        }
    }
}
```

## 🧠 O que eu aprendi na prática

### 1. Precedência de operadores lógicos (`&&` vs `||`)
Minha primeira tentativa de validar o sexo usava `||` onde deveria ser `&&` (e vice-versa). Entendi que, em Java, `&&` tem precedência maior que `||`, e que a tradução literal da regra *"repetir **enquanto** for diferente de F **e** diferente de M"* precisa de `&&` entre as quatro comparações — senão a condição vira sempre verdadeira (ou sempre falsa) para qualquer entrada.

### 2. Buffer do `Scanner`: `next()` vs `nextLine()`
Usar `sc.next()` para ler o nome quebrava nomes compostos (ex: "Carlos Silva"), já que `next()` lê apenas uma palavra. Troquei para `sc.nextLine()` — mas isso expôs outro problema clássico: o `\n` deixado no buffer por um `nextInt()` anterior fazia o `nextLine()` seguinte "ler" uma linha vazia. A solução foi consumir esse `\n` pendente com um `sc.nextLine()` extra logo após o `sc.nextInt()`.

### 3. Inicialização de variáveis antes de loops condicionais
Para guardar o nome do atleta mais alto, o compilador não aceitava `pessoaAlta` sem valor inicial, pois o `if` dentro do `for` pode nunca ser executado (do ponto de vista do compilador). A solução foi inicializar com `""` (string vazia) — diferente do padrão numérico (`0`), aqui o valor inicial só "ocupa espaço" até ser substituído, sem participar de nenhuma comparação lógica.

### 4. Divisão inteira e cast para `double`
Para calcular a porcentagem de homens, usar variáveis `int` resultaria em truncamento na divisão. Declarar os contadores como `double` (ou aplicar cast) garante o resultado correto com casas decimais.

### 5. Evitar divisão por zero com validação de contexto
A lógica de "não há mulheres cadastradas" inicialmente estava **dentro do loop**, testando o sexo de cada atleta individualmente — o que fazia a mensagem repetir a cada atleta homem. Entendi que essa decisão só faz sentido **depois** que todos os atletas já foram lidos, usando o total acumulado (`contMulheres`) em um `if/else` fora do `for`, evitando a divisão por zero apenas quando necessário.

## 🛠️ Tecnologias

- Java
- Scanner (entrada de dados via console)
- Locale (padronização de separador decimal)

## ▶️ Como executar

```bash
javac Atletas.java
java Atletas
```

---
*Exercício desenvolvido como parte do curso de Java — Algoritmos e Lógica de Programação (Prof. Nélio Alves).*
