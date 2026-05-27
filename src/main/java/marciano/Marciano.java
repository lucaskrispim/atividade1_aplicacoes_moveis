package marciano;

public class Marciano {

    public String responda(String frase) {
        if (frase == null || frase.isBlank()) {
            return "Não me incomode";
        }

        boolean eGrito = eGrito(frase);
        boolean ePergunta = ePergunta(frase);

        if (eGrito && ePergunta) {
            return "Relaxa, eu sei o que estou fazendo!";
        }
        if (eGrito) {
            return "Opa! Calma aí!";
        }
        if (ePergunta) {
            return "Certamente";
        }
        if (contemPalavraEu(frase)) {
            return "A responsabilidade é sua";
        }
        return "Tudo bem, como quiser";
    }

    protected boolean eGrito(String frase) {
        String[] palavras = frase.trim().split("\\s+");
        for (String palavra : palavras) {
            String apenasLetras = palavra.replaceAll("[^a-zA-ZÀ-ú]", "");
            if (!apenasLetras.isEmpty() && apenasLetras.equals(apenasLetras.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    protected boolean ePergunta(String frase) {
        return frase.trim().endsWith("?");
    }

    protected boolean contemPalavraEu(String frase) {
        return frase.toLowerCase().matches(".*\\beu\\b.*");
    }
}
