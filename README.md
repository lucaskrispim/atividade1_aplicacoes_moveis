# Robô Marciano — Exercício de Linguagens de Programação Móvel

Projeto desenvolvido em Java 17 como atividade da disciplina de Aplicações Móveis. Implementa três versões evolutivas de um robô conversacional chamado **Marciano**, explorando os conceitos de herança, interfaces funcionais e lambdas.

---

## Estrutura do projeto

```
marciano/
├── pom.xml
└── src/
    ├── main/java/marciano/
    │   ├── Marciano.java            # Versão básica — 6 regras de resposta
    │   ├── MarcianoMatematico.java  # Herda Marciano + operações aritméticas
    │   ├── AcaoPersonalizada.java   # Interface funcional para ação customizada
    │   ├── MarcianoPremium.java     # Herda MarcianoMatematico + comando "agir"
    │   └── Main.java                # Programa interativo (loop até "FIM")
    └── test/java/marciano/
        ├── MarcianoTest.java
        ├── MarcianoMatematicoTest.java
        └── MarcianoPremiumTest.java
```

---

## Hierarquia de classes

```
Marciano
└── MarcianoMatematico
    └── MarcianoPremium
```

---

## Funcionalidades

### Marciano — versão básica

Responde a frases via `responda(String frase)` seguindo prioridade:

| Situação | Resposta |
|---|---|
| Frase vazia ou nula | `"Não me incomode"` |
| Grito + pergunta (`PALAVRA?`) | `"Relaxa, eu sei o que estou fazendo!"` |
| Grito (alguma palavra toda em maiúsculas) | `"Opa! Calma aí!"` |
| Pergunta (termina com `?`) | `"Certamente"` |
| Contém a palavra `"eu"` (qualquer case) | `"A responsabilidade é sua"` |
| Qualquer outra frase | `"Tudo bem, como quiser"` |

### MarcianoMatematico — versão matemática

Herda todas as regras anteriores e adiciona suporte a operações aritméticas:

```
responda("some", 3, 5)        → "Essa eu sei: 8"
responda("subtraia", 10, 4)   → "Essa eu sei: 6"
responda("multiplique", 3, 7) → "Essa eu sei: 21"
responda("divida", 10, 2)     → "Essa eu sei: 5"
responda("divida", 10, 0)     → "Essa eu sei: Erro! Divisão por zero"
```

### MarcianoPremium — versão premium

Herda todas as funcionalidades anteriores. Recebe uma `AcaoPersonalizada` no construtor (interface funcional — compatível com lambda). Quando a palavra `"agir"` aparece na frase, responde `"É pra já!"` e executa a ação.

A ação implementada no programa exibe a **data e hora atual** formatada.

---

## Como executar

### Pré-requisitos

- Java 17+
- Maven 3.6+

### Rodar os testes

```bash
mvn test
```

### Gerar o JAR e executar o programa interativo

```bash
mvn package -q
java -jar target/marciano-1.0-SNAPSHOT.jar
```

### Exemplo de uso

```
Pode começar a falar com o Marciano!

> tudo bem?
Marciano: Certamente

> EU NÃO ACREDITO!
Marciano: Opa! Calma aí!

> ISSO É VERDADE?
Marciano: Relaxa, eu sei o que estou fazendo!

> some 10 3
Marciano: Essa eu sei: 13

> agir
É pra já!
[AÇÃO] Hora atual: 18:45:00 27/05/2026
Marciano: É pra já!

> FIM
Marciano: Até logo, humano! Foi um prazer (mais ou menos).
```

---

## Testes

47 testes unitários com **100% de cobertura** nas classes de negócio (JaCoCo).

| Classe de teste | Testes | Cobertura |
|---|---|---|
| `MarcianoTest` | 15 | 100% |
| `MarcianoMatematicoTest` | 17 | 100% |
| `MarcianoPremiumTest` | 15 | 100% |

---

## Tecnologias

- Java 17
- JUnit Jupiter 5.10.0
- JaCoCo 0.8.11
- Maven 3.6+

---

## Autor

**Lucas Wilman da Silva Crispim**
