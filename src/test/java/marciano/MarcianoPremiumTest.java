package marciano;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("MarcianoPremium - Ação personalizada e herança")
class MarcianoPremiumTest {

    private MarcianoPremium marciano;
    private AtomicBoolean acaoExecutada;

    @BeforeEach
    void setUp() {
        acaoExecutada = new AtomicBoolean(false);
        marciano = new MarcianoPremium(() -> acaoExecutada.set(true));
    }

    @Test
    @DisplayName("Frase com 'agir' deve retornar 'É pra já!'")
    void fraseComAgirRetornaEPraJa() {
        String resposta = marciano.responda("pode agir agora");
        assertEquals("É pra já!", resposta);
    }

    @Test
    @DisplayName("Frase com 'agir' deve executar a ação personalizada")
    void fraseComAgirExecutaAcao() {
        marciano.responda("pode agir agora");
        assertTrue(acaoExecutada.get(), "A ação personalizada deveria ter sido executada");
    }

    @Test
    @DisplayName("Frase apenas 'agir' deve retornar 'É pra já!'")
    void fraseApenasAgirRetornaEPraJa() {
        assertEquals("É pra já!", marciano.responda("agir"));
    }

    @Test
    @DisplayName("Frase com 'AGIR' em maiúsculas deve retornar 'É pra já!' (case-insensitive)")
    void fraseComAgirMaiusculaRetornaEPraJa() {
        assertEquals("É pra já!", marciano.responda("AGIR agora"));
    }

    @Test
    @DisplayName("Frase com 'agir' deve executar ação apenas uma vez")
    void fraseComAgirExecutaAcaoUmaVez() {
        AtomicBoolean contador = new AtomicBoolean(false);
        MarcianoPremium m = new MarcianoPremium(() -> {
            if (contador.get()) {
                throw new RuntimeException("Ação executada mais de uma vez!");
            }
            contador.set(true);
        });
        m.responda("preciso agir");
        assertTrue(contador.get());
    }

    @Test
    @DisplayName("Palavra 'agir' embutida em outra não deve ativar a ação especial")
    void palavraAgirDentroDeOutraPalavraIgnorada() {
        String resposta = marciano.responda("precisamos reagir com calma");
        assertEquals("Tudo bem, como quiser", resposta);
        assertTrue(!acaoExecutada.get(), "A ação não deveria ter sido executada para 'reagir'");
    }

    @Test
    @DisplayName("(herança) Frase vazia ainda retorna 'Não me incomode'")
    void herancaFraseVazia() {
        assertEquals("Não me incomode", marciano.responda(""));
    }

    @Test
    @DisplayName("(herança) Pergunta ainda retorna 'Certamente'")
    void herancaPergunta() {
        assertEquals("Certamente", marciano.responda("tudo certo?"));
    }

    @Test
    @DisplayName("(herança) Grito ainda retorna 'Opa! Calma aí!'")
    void herancaGrito() {
        assertEquals("Opa! Calma aí!", marciano.responda("ATENÇÃO"));
    }

    @Test
    @DisplayName("(herança) Grito com pergunta ainda retorna 'Relaxa, eu sei o que estou fazendo!'")
    void herancaGritoPergunta() {
        assertEquals("Relaxa, eu sei o que estou fazendo!", marciano.responda("O QUE FOI?"));
    }

    @Test
    @DisplayName("(herança) Frase com 'eu' ainda retorna 'A responsabilidade é sua'")
    void herancaFraseComEu() {
        assertEquals("A responsabilidade é sua", marciano.responda("eu decidi assim"));
    }

    @Test
    @DisplayName("(herança) Frase genérica ainda retorna 'Tudo bem, como quiser'")
    void herancaFraseGenerica() {
        assertEquals("Tudo bem, como quiser", marciano.responda("nada especial aqui"));
    }

    @Test
    @DisplayName("(herança) Operação de soma ainda funciona")
    void herancaSoma() {
        assertEquals("Essa eu sei: 15", marciano.responda("some", 10, 5));
    }

    @Test
    @DisplayName("(herança) Divisão por zero ainda retorna mensagem de erro")
    void herancaDivisaoPorZero() {
        assertEquals("Essa eu sei: Erro! Divisão por zero", marciano.responda("divida", 9, 0));
    }

    @Test
    @DisplayName("Frase null deve retornar 'Não me incomode'")
    void fraseNulaRetornaNaoMeIncomode() {
        assertEquals("Não me incomode", marciano.responda((String) null));
    }
}
