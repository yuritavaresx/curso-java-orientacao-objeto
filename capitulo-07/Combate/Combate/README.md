# ⚔️ Desafio Combate — Java Orientado a Objetos

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)

Simulador de combate por turnos entre dois campeões, feito em **Java** no console. O projeto é um desafio prático do capítulo sobre **construtores, `this`, sobrecarga e encapsulamento** do curso de Orientação a Objetos.

---

## 📋 Sobre o desafio

Em um jogo de combate, cada jogador controla um campeão com **nome**, **vida**, **ataque** e **armadura**. O combate é dividido em turnos, e em cada turno os dois campeões se atacam.

O programa deve:

1. Ler os dados dos dois campeões.
2. Perguntar quantos turnos executar.
3. Mostrar o estado de cada campeão ao fim de cada turno.
4. Encerrar o combate antes do fim se algum campeão morrer (vida igual a zero).
5. Exibir `FIM DO COMBATE` ao terminar.

### 🛡️ Regra de dano

Quando um campeão **A** recebe um ataque do campeão **B**:

1. A vida de A diminui do **ataque de B menos a armadura de A**.
2. Independente da armadura, **pelo menos 1 ponto de vida** é perdido por ataque.
3. A vida nunca fica **abaixo de zero**.

---

## 🧩 Modelo da classe

```
┌─────────────────────────────────┐
│            Champion             │
├─────────────────────────────────┤
│ - name   : String               │
│ - life   : int                  │
│ - attack : int                  │
│ - armor  : int                  │
├─────────────────────────────────┤
│ + takeDamage(other: Champion)   │
│ + status() : String             │
└─────────────────────────────────┘
```

---

## 🗂️ Estrutura do projeto

```
Combate/
└── src/
    ├── aplication/
    │   └── Program.java      # Leitura dos dados e laço dos turnos
    └── entities/
        └── Champion.java     # Classe que representa o campeão
```

---

## 🚀 Como executar

1. Clone o repositório:
   ```bash
   git clone <link-do-seu-repositorio>
   ```
2. Abra o projeto no **IntelliJ IDEA** (ou outra IDE Java).
3. Execute a classe `Program`.
4. Digite os dados pedidos no console.

> Requisito: JDK instalado (Java 8 ou superior).

---

## 🖥️ Exemplos de execução

### Exemplo 1 — nenhum campeão morre

```
Digite os dados do primeiro campeão:
Nome: Darius
Vida inicial: 50
Ataque: 8
Armadura: 1

Digite os dados do segundo campeão:
Nome: Fiora
Vida inicial: 40
Ataque: 10
Armadura: 2

Quantos turnos você deseja executar? 2

Resultado do turno 1:
Darius: 41 de vida
Fiora: 34 de vida

Resultado do turno 2:
Darius: 32 de vida
Fiora: 28 de vida

FIM DO COMBATE
```

### Exemplo 2 — um campeão morre e o combate termina antes

```
Digite os dados do primeiro campeão:
Nome: Darius
Vida inicial: 50
Ataque: 8
Armadura: 1

Digite os dados do segundo campeão:
Nome: Fiora
Vida inicial: 40
Ataque: 30
Armadura: 10

Quantos turnos você deseja executar? 4

Resultado do turno 1:
Darius: 21 de vida
Fiora: 39 de vida

Resultado do turno 2:
Darius: 0 de vida (morreu)
Fiora: 38 de vida

FIM DO COMBATE
```

---

## 💡 O que eu apliquei na prática

### 🏗️ Construtor
Os dados do campeão entram **uma única vez**, na criação do objeto. Depois disso, nenhum valor precisa ser trocado de fora.

```java
public Champion(String name, int life, int attack, int armor) {
    this.name = name;
    this.life = life;
    this.attack = attack;
    this.armor = armor;
}
```

### 👆 Palavra-chave `this`
Serve para diferenciar o **atributo do objeto** do **parâmetro** com o mesmo nome (`this.name = name`) e para deixar claro **quem está levando o dano** dentro do método `takeDamage`.

### 🔒 Encapsulamento
Todos os atributos são `private`, e só existem métodos `get` para consulta. Não criei `set` porque, pelo modelo do desafio, nome, ataque e armadura não mudam, e a vida só é alterada de dentro da própria classe, pelo `takeDamage`. Assim, ninguém de fora consegue deixar o campeão com uma vida inválida.

### 🤝 Objeto como parâmetro
O método `takeDamage(Champion other)` recebe **outro campeão** como argumento. Assim, a mesma lógica funciona para os dois lados do combate:

```java
champ2.takeDamage(champ);   // champ ataca champ2
champ.takeDamage(champ2);   // champ2 ataca champ
```

Dentro do método, `this` é quem **apanha** e `other` é quem **bate**.

### 🧮 Lógica do dano

```java
public void takeDamage(Champion other) {
    int damage = other.attack - this.armor;

    if (damage < 1) {
        damage = 1;
    }

    this.life = this.life - damage;

    if (this.life < 0) {
        this.life = 0;
    }
}
```

### 📝 Método `status()`
Retorna o texto com o nome e a vida do campeão, incluindo a palavra **"(morreu)"** quando a vida chega a zero.

```java
public String status() {
    if (this.life <= 0) {
        return this.name + ": 0 de vida (morreu)";
    }
    return this.name + ": " + this.life + " de vida";
}
```

### 🔁 Laço dos turnos
A cada turno, os dois atacam, o resultado é mostrado e o laço é interrompido com `break` se algum deles morreu.

```java
for (int i = 0; i < turn; i++) {
    champ2.takeDamage(champ);
    champ.takeDamage(champ2);

    System.out.println("Resultado do turno " + (i + 1) + ":");
    System.out.println(champ.status());
    System.out.println(champ2.status());
    System.out.println();

    if (champ.getLife() == 0 || champ2.getLife() == 0) {
        break;
    }
}

System.out.println("FIM DO COMBATE");
```

---

## 📚 Aprendizados e armadilhas que enfrentei

| Situação | Aprendizado |
|---|---|
| `Scanner` pulando a leitura do nome | Depois de um `nextInt()`, o **Enter fica sobrando** no teclado. Um `nextLine()` extra limpa esse Enter antes de ler um texto. |
| Os dois campeões saindo iguais | Cuidado ao reutilizar variáveis: usei as variáveis do primeiro campeão na criação do segundo. |
| Erro de compilação em `damage == 1;` | `=` **atribui** um valor; `==` **compara**. |
| `if` depois do `return` nunca executava | O `return` **encerra o método** na hora. O `if` precisa vir antes. |
| Vida não mudava nos turnos | Não basta criar o método: é preciso **chamá-lo** (`takeDamage`) dentro do laço. |
| `printf` ignorando o valor | O `printf` só insere valores onde há marcadores (`%d`, `%s`). Para o caso simples, concatenar com `+` funciona. |
| `status()` mostrando os dois campeões | Cada objeto deve cuidar só de si. Quem junta os dois na tela é o `Program`. |

---

## 🧠 Conceitos praticados

- Classes, objetos e atributos
- Construtores
- Palavra-chave `this`
- Encapsulamento (`private` e métodos `get`)
- Passagem de objeto como parâmetro
- Estruturas condicionais (`if`/`else`)
- Laço `for` e interrupção com `break`
- Entrada de dados com `Scanner`
- Organização do projeto em pacotes (`entities` e `aplication`)

> 📌 O capítulo também aborda **sobrecarga** de construtores e métodos. Neste desafio o modelo pedia um único construtor, mas o conceito faz parte do mesmo estudo.

---

## 👤 Autor

**Yuri**
Estudante de Análise e Desenvolvimento de Sistemas na FATEC

Feito com ☕ e muita persistência durante o curso de Java do professor Nélio Alves.
