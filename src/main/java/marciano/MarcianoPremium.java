package marciano;

public class MarcianoPremium extends MarcianoMatematico {

    private final AcaoPersonalizada acao;

    public MarcianoPremium(AcaoPersonalizada acao) {
        this.acao = acao;
    }

    @Override
    public String responda(String frase) {
        if (contemPalavraAgir(frase)) {
            System.out.println("É pra já!");
            acao.executar();
            return "É pra já!";
        }
        return super.responda(frase);
    }

    private boolean contemPalavraAgir(String frase) {
        if (frase == null) return false;
        return frase.toLowerCase().matches(".*\\bagir\\b.*");
    }
}
