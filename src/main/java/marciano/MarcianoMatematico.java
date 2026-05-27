package marciano;

public class MarcianoMatematico extends Marciano {

    public String responda(String operacao, double a, double b) {
        return switch (operacao.toLowerCase().trim()) {
            case "some"        -> "Essa eu sei: " + formatarResultado(a + b);
            case "subtraia"    -> "Essa eu sei: " + formatarResultado(a - b);
            case "multiplique" -> "Essa eu sei: " + formatarResultado(a * b);
            case "divida"      -> {
                if (b == 0) {
                    yield "Essa eu sei: Erro! Divisão por zero";
                }
                yield "Essa eu sei: " + formatarResultado(a / b);
            }
            default -> throw new IllegalArgumentException("Operação desconhecida: " + operacao);
        };
    }

    private String formatarResultado(double valor) {
        if (valor == Math.floor(valor) && !Double.isInfinite(valor)) {
            return String.valueOf((long) valor);
        }
        return String.valueOf(valor);
    }
}
