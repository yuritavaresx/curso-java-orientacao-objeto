# 🍻 Desafio Bar — Programação Orientada a Objetos

Projeto desenvolvido como parte do curso **Java COMPLETO Programação Orientada a Objetos +Projetos**, do professor Nélio Alves (Udemy).

> Este desafio é uma releitura do exercício "Bar" do módulo de Lógica de Programação — agora resolvido aplicando conceitos de **classes e objetos**, em vez de lógica procedural pura.

---

## 📋 Descrição do problema

Em um bar, cada cliente informa seu **sexo**, a quantidade de **cervejas**, **refrigerantes** e **espetinhos** consumidos. O programa deve calcular e exibir um relatório com o valor total a pagar, considerando:

- **Ingresso:** R$ 10,00 (homens) ou R$ 8,00 (mulheres)
- **Consumo:** cerveja R$ 5,00 · refrigerante R$ 3,00 · espetinho R$ 7,00
- **Couvert artístico:** R$ 4,00, **isento** se o consumo ultrapassar R$ 30,00

### Exemplo de saída

```
Sexo: F
Quantidade de cervejas: 3
Quantidade de refrigerantes: 0
Quantidade de espetinhos: 1

RELATÓRIO:
Consumo = R$ 22.00
Couvert = R$ 4.00
Ingresso = R$ 8.00

Valor a pagar = R$ 34.00
```

---

## 🏗️ Modelagem da classe

```
Bill
├─ + gender    : char
├─ + beer      : int
├─ + barbecue  : int
├─ + softDrink : int
├─ + feeding() : double
├─ + cover()   : double
├─ + ticket()  : double
└─ + total()   : double
```

### `Bill.java`

```java
package entities;

public class Bill {

    public char gender;
    public int beer;
    public int barbecue;
    public int softDrink;

    public double feeding(){
        return (beer * 5.0) + (barbecue * 7.0) + (softDrink * 3.0);
    }

    public double cover(){
        if (feeding() >= 30.0){
            return 0.0;
        } else {
            return 4.0;
        }
    }

    public double ticket(){
        if (gender == 'F' || gender == 'f'){
            return 8.0;
        }
        else if (gender == 'M' || gender == 'm'){
            return 10.0;
        }
        else {
            return 0.0;
        }
    }

    public double total() { return feeding() + cover() + ticket(); }
}
```

### `Program.java`

```java
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Bill bills = new Bill();

        System.out.print("Sexo: ");
        bills.gender = sc.next().charAt(0);
        System.out.print("Quantidade de cervejas: ");
        bills.beer = sc.nextInt();
        System.out.print("Quantidade de refrigerantes: ");
        bills.softDrink = sc.nextInt();
        System.out.print("Quantidade de espetinhos: ");
        bills.barbecue = sc.nextInt();

        System.out.println();
        System.out.println("RELATÓRIO: ");

        System.out.printf("Consumo = R$ %.2f%n", bills.feeding());

        if (bills.cover() == 0.0){
            System.out.println("Isento de Couvert");
        } else if (bills.cover() == 4.0) {
            System.out.printf("Couvert = R$ %.2f%n", bills.cover());
        }
        System.out.printf("Ingresso = R$ %.2f%n", bills.ticket());

        System.out.println();
        System.out.printf("Valor a pagar = R$ %.2f%n", bills.total());

        sc.close();
    }
}
```

---

## 💡 O que aprendi na prática

### 1. Separação entre cálculo e exibição (regra de ouro do OO)
A classe `Bill` **não imprime nada** — ela só calcula e devolve valores (`double`). Quem decide **o que mostrar na tela** (ex: "Isento de Couvert" ou "Couvert = R$ 4.00") é o `Program.java`, interpretando o resultado de `cover()`.

```java
if (bills.cover() == 0.0){
    System.out.println("Isento de Couvert");
} else if (bills.cover() == 4.0) {
    System.out.printf("Couvert = R$ %.2f%n", bills.cover());
}
```

> 🔑 Isso evita o erro clássico de tentar `return System.out.print(...)` dentro de um método `double` — `print()` é `void` e não devolve valor nenhum para ser retornado.

### 2. `return` em todos os caminhos possíveis
O método `ticket()` precisou de um terceiro `return` (um `else` final) para cobrir **todo caminho de execução**, mesmo sabendo que, na prática, só entram valores `'F'` ou `'M'`:

```java
public double ticket(){
    if (gender == 'F' || gender == 'f'){
        return 8.0;
    }
    else if (gender == 'M' || gender == 'm'){
        return 10.0;
    }
    else {
        return 0.0; // garante retorno em QUALQUER caminho
    }
}
```

> 🔑 O compilador não sabe, em tempo de compilação, que o `else` nunca vai acontecer — por isso métodos que não são `void` exigem um `return` cobrindo 100% dos caminhos possíveis, mesmo que alguns sejam "impossíveis" na prática.

### 3. Encapsulamento das regras de negócio
Cada cálculo virou um método com responsabilidade única dentro da própria classe `Bill`:

| Método | O que calcula |
|---|---|
| `feeding()` | Soma do consumo: cerveja + espetinho + refrigerante |
| `cover()` | Define se cobra R$ 4,00 de couvert ou isenta, com base em `feeding()` |
| `ticket()` | Valor do ingresso de acordo com o sexo |
| `total()` | Soma final: `feeding() + cover() + ticket()` |

Isso elimina a necessidade de variáveis soltas e cálculos repetidos no `main` — o `Program.java` só **lê dados, cria o objeto e exibe o resultado**.

### 4. `Locale` e `printf` para formatação monetária
`Locale.setDefault(Locale.US)` garante que `%.2f` formate os valores com **ponto** como separador decimal (`34.00`), e não vírgula — importante porque o padrão do Java no Brasil usaria `34,00`.

### 5. Leitura de dados mistos com `Scanner`
Como só `sc.next().charAt(0)` e `sc.nextInt()` são usados (sem `nextLine()` no meio), não há o problema clássico de "pular" a leitura por causa do `\n` deixado no buffer.

---

## 🛠️ Tecnologias

- **Java**
- **IntelliJ IDEA**

---

## ▶️ Como executar

```bash
git clone <link-do-repositorio>
cd Desafio_Bar_OO
# compilar e rodar Program.java pela sua IDE ou via terminal
```

---

## 📚 Créditos

Desafio proposto no curso **Java COMPLETO Programação Orientada a Objetos +Projetos**, por **Nélio Alves**.
