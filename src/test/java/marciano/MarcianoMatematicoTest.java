package marciano;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("MarcianoMatematico - Operações aritméticas e herança")
class MarcianoMatematicoTest {

    private MarcianoMatematico marciano;

    @BeforeEach
    void setUp() {
        marciano = new MarcianoMatematico();
    }

    @Test
    @DisplayName("Soma de inteiros deve retornar 'Essa eu sei: 8'")
    void somaInteiraRetornaResultadoCorreto() {
        assertEquals("Essa eu sei: 8", marciano.responda("some", 3, 5));
    }

    @Test
    @DisplayName("Soma com decimais deve retornar resultado correto")
    void somaDecimalRetornaResultadoCorreto() {
        assertEquals("Essa eu sei: 3.5", marciano.responda("some", 1.5, 2.0));
    }

    @Test
    @DisplayName("Subtração deve retornar 'Essa eu sei: 3'")
    void subtracaoRetornaResultadoCorreto() {
        assertEquals("Essa eu sei: 3", marciano.responda("subtraia", 8, 5));
    }

    @Test
    @DisplayName("Subtração com resultado negativo deve funcionar")
    void subtracaoNegativaRetornaResultadoCorreto() {
        assertEquals("Essa eu sei: -2", marciano.responda("subtraia", 3, 5));
    }

    @Test
    @DisplayName("Multiplicação deve retornar 'Essa eu sei: 20'")
    void multiplicacaoRetornaResultadoCorreto() {
        assertEquals("Essa eu sei: 20", marciano.responda("multiplique", 4, 5));
    }

    @Test
    @DisplayName("Divisão inteira deve retornar 'Essa eu sei: 5'")
    void divisaoInteiraRetornaResultadoCorreto() {
        assertEquals("Essa eu sei: 5", marciano.responda("divida", 10, 2));
    }

    @Test
    @DisplayName("Divisão com resultado decimal deve retornar resultado correto")
    void divisaoDecimalRetornaResultadoCorreto() {
        assertEquals("Essa eu sei: 2.5", marciano.responda("divida", 5, 2));
    }

    @Test
    @DisplayName("Divisão por zero deve retornar mensagem de erro")
    void divisaoPorZeroRetornaMensagemDeErro() {
        assertEquals("Essa eu sei: Erro! Divisão por zero", marciano.responda("divida", 10, 0));
    }

    @Test
    @DisplayName("Divisão por zero com dividendo zero também deve retornar erro")
    void divisaoPorZeroComDividendoZero() {
        assertEquals("Essa eu sei: Erro! Divisão por zero", marciano.responda("divida", 0, 0));
    }

    @Test
    @DisplayName("Operação desconhecida deve lançar IllegalArgumentException")
    void operacaoDesconhecidaLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> marciano.responda("eleve", 2, 3));
    }

    @Test
    @DisplayName("Operação com nome em maiúsculas deve ser aceita (case-insensitive)")
    void operacaoCaseInsensitive() {
        assertEquals("Essa eu sei: 8", marciano.responda("SOME", 3, 5));
    }

    @Test
    @DisplayName("(herança) Frase vazia ainda retorna 'Não me incomode'")
    void herancaFraseVazia() {
        assertEquals("Não me incomode", marciano.responda(""));
    }

    @Test
    @DisplayName("(herança) Pergunta ainda retorna 'Certamente'")
    void herancaPergunta() {
        assertEquals("Certamente", marciano.responda("isso funciona?"));
    }

    @Test
    @DisplayName("(herança) Grito ainda retorna 'Opa! Calma aí!'")
    void herancaGrito() {
        assertEquals("Opa! Calma aí!", marciano.responda("CUIDADO"));
    }

    @Test
    @DisplayName("(herança) Frase com 'eu' ainda retorna 'A responsabilidade é sua'")
    void herancaFraseComEu() {
        assertEquals("A responsabilidade é sua", marciano.responda("eu fiz isso"));
    }

    @Test
    @DisplayName("(herança) Frase genérica ainda retorna 'Tudo bem, como quiser'")
    void herancaFraseGenerica() {
        assertEquals("Tudo bem, como quiser", marciano.responda("boa tarde"));
    }

    @Test
    @DisplayName("Soma com overflow (Infinity) deve retornar resultado formatado")
    void somaComOverflowRetornaInfinity() {
        assertEquals("Essa eu sei: Infinity", marciano.responda("some", Double.MAX_VALUE, Double.MAX_VALUE));
    }
}
