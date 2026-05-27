package marciano;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");

    public static void main(String[] args) {
        AcaoPersonalizada acaoDataHora = () -> {
            String agora = LocalDateTime.now().format(FORMATTER);
            System.out.println("[AÇÃO] Hora atual: " + agora);
        };

        MarcianoPremium marciano = new MarcianoPremium(acaoDataHora);

        exibirMenuAjuda();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pode começar a falar com o Marciano!\n");

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();

            if (linha.equalsIgnoreCase("FIM")) {
                System.out.println("Marciano: Até logo, humano! Foi um prazer (mais ou menos).");
                break;
            }

            String resposta = processarEntrada(marciano, linha);
            System.out.println("Marciano: " + resposta);
        }

        scanner.close();
    }

    private static String processarEntrada(MarcianoPremium marciano, String linha) {
        String[] partes = linha.trim().split("\\s+");

        if (partes.length == 3) {
            String operacao = partes[0].toLowerCase();
            if (operacao.equals("some") || operacao.equals("subtraia")
                    || operacao.equals("multiplique") || operacao.equals("divida")) {
                try {
                    double a = Double.parseDouble(partes[1]);
                    double b = Double.parseDouble(partes[2]);
                    return marciano.responda(operacao, a, b);
                } catch (NumberFormatException e) {
                }
            }
        }

        return marciano.responda(linha);
    }

    private static void exibirMenuAjuda() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║           BEM-VINDO AO ROBÔ MARCIANO PREMIUM            ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║  COMANDOS DISPONÍVEIS:                                   ║");
        System.out.println("║                                                          ║");
        System.out.println("║  Conversa normal:                                        ║");
        System.out.println("║    - Digite qualquer frase e o Marciano responderá       ║");
        System.out.println("║    - Perguntas (terminar com ?)  → Certamente            ║");
        System.out.println("║    - Gritos (palavras em MAIÚSCULO) → Opa! Calma aí!    ║");
        System.out.println("║    - Frases com \"eu\"              → A resp. é sua        ║");
        System.out.println("║                                                          ║");
        System.out.println("║  Operações matemáticas:                                  ║");
        System.out.println("║    some       <a> <b>   → soma a + b                    ║");
        System.out.println("║    subtraia   <a> <b>   → subtração a - b               ║");
        System.out.println("║    multiplique <a> <b>  → multiplicação a * b           ║");
        System.out.println("║    divida     <a> <b>   → divisão a / b                 ║");
        System.out.println("║                                                          ║");
        System.out.println("║  Exemplo: some 3 5   →  Essa eu sei: 8                  ║");
        System.out.println("║           divida 10 2 → Essa eu sei: 5                  ║");
        System.out.println("║                                                          ║");
        System.out.println("║  Ação especial:                                          ║");
        System.out.println("║    - Diga \"agir\" para o Marciano mostrar a hora atual    ║");
        System.out.println("║                                                          ║");
        System.out.println("║  Encerrar:                                               ║");
        System.out.println("║    FIM  → encerra o programa                            ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println();
    }
}
