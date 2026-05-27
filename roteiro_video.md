# Roteiro — Vídeo 5 minutos: Robô Marciano em Java

---

## [0:00 – 0:30] Introdução

> "Nesse vídeo vou apresentar minha solução para o exercício do robô Marciano, desenvolvido em Java. O projeto implementa três versões do robô usando herança e interface, com testes unitários em JUnit 5."

Mostre a estrutura de pastas no explorador de arquivos ou terminal:

```
marciano/src/main/java/marciano/
marciano/src/test/java/marciano/
```

---

## [0:30 – 1:30] Classe `Marciano` — versão básica

Abra o arquivo `Marciano.java`.

> "Essa é a classe base. O método `responda()` avalia a frase em ordem de prioridade."

Aponte cada `if` e fale a regra:
- `isBlank()` → "Não me incomode"
- `eGrito && ePergunta` → "Relaxa, eu sei o que estou fazendo!"
- só `eGrito` → "Opa! Calma aí!"
- só `ePergunta` → "Certamente"
- `contemPalavraEu` → "A responsabilidade é sua"
- default → "Tudo bem, como quiser"

Destaque o método `eGrito()`:

> "Aqui eu separo as palavras, removo pontuação das bordas com regex e comparo com `.toUpperCase()` — isso garante que 'CUIDADO!' também seja detectado como grito."

---

## [1:30 – 2:30] Classe `MarcianoMatematico` — herança + operações

Abra `MarcianoMatematico.java`.

> "Essa classe herda de Marciano com `extends`. Ela adiciona uma sobrecarga do método `responda()` que recebe a operação e dois números."

Aponte o `switch` expression (Java 17):

> "Usei o switch expression do Java 17, que é mais limpo que o switch tradicional. Cada caso retorna o resultado direto com `->`, e no caso da divisão uso `yield` para tratar o erro de divisão por zero dentro do bloco."

---

## [2:30 – 3:15] Interface `AcaoPersonalizada` + `MarcianoPremium`

Abra `AcaoPersonalizada.java`:

> "Essa é a interface funcional — tem apenas um método `executar()`. A anotação `@FunctionalInterface` permite usá-la com lambda diretamente."

Abra `MarcianoPremium.java`:

> "Essa é a versão premium. No construtor ela recebe uma `AcaoPersonalizada`. Quando a frase contém a palavra 'agir', ela executa essa ação. Para tudo mais, chama `super.responda()` e aproveita toda a herança."

---

## [3:15 – 4:00] Programa principal — `Main.java`

Abra `Main.java`:

> "No Main eu instancio o `MarcianoPremium` passando uma lambda como ação personalizada — nesse caso, ela exibe a data e hora atual formatada."

Aponte o trecho:

```java
AcaoPersonalizada acaoDataHora = () -> {
    String agora = LocalDateTime.now().format(FORMATTER);
    System.out.println("[AÇÃO] Hora atual: " + agora);
};
```

> "Depois entra num loop que lê o teclado. O método `processarEntrada()` decide se a linha é uma operação matemática ou uma frase normal antes de chamar o robô. O loop só encerra quando o usuário digita 'FIM'."

---

## [4:00 – 4:40] Testes unitários

Abra o terminal e rode `mvn test`:

> "O projeto tem 44 testes divididos em três classes — uma pra cada versão do robô. Todos cobrem os casos do enunciado mais os casos-limite, como string vazia, grito com pontuação e divisão por zero."

Mostre o resultado no terminal:

```
Tests run: 44, Failures: 0, Errors: 0
BUILD SUCCESS
```

---

## [4:40 – 5:00] Demonstração rápida

Rode o programa: `java -jar target/marciano-1.0.jar`

Digite os comandos abaixo e mostre as respostas:

| Você digita     | Marciano responde                  |
|-----------------|------------------------------------|
| `Tudo bem?`     | Certamente                         |
| `CUIDADO!`      | Opa! Calma aí!                     |
| `some 10 3`     | Essa eu sei: 13                    |
| `agir`          | É pra já! + hora atual             |
| `FIM`           | Até logo, humano!                  |

> "É isso — três classes com herança, uma interface funcional, testes e programa interativo. Valeu!"
