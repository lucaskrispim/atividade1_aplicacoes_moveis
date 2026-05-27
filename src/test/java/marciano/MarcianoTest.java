package marciano;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Marciano - Regras básicas de resposta")
class MarcianoTest {

    private Marciano marciano;

    @BeforeEach
    void setUp() {
        marciano = new Marciano();
    }

    @Test
    @DisplayName("Frase vazia deve retornar 'Não me incomode'")
    void fraseVaziaRetornaNaoMeIncomode() {
        assertEquals("Não me incomode", marciano.responda(""));
    }

    @Test
    @DisplayName("Frase com apenas espaços deve retornar 'Não me incomode'")
    void fraseApenasEspacosRetornaNaoMeIncomode() {
        assertEquals("Não me incomode", marciano.responda("   "));
    }

    @Test
    @DisplayName("Frase nula deve retornar 'Não me incomode'")
    void fraseNulaRetornaNaoMeIncomode() {
        assertEquals("Não me incomode", marciano.responda(null));
    }

    @Test
    @DisplayName("Grito com pergunta deve retornar 'Relaxa, eu sei o que estou fazendo!'")
    void gritoPerguntaRetornaRelaxaEuSei() {
        assertEquals(
                "Relaxa, eu sei o que estou fazendo!",
                marciano.responda("PARA QUE ISSO?")
        );
    }

    @Test
    @DisplayName("Grito com pergunta — palavra maiúscula no meio da frase com '?'")
    void gritoPerguntaComPalavraNoMeio() {
        assertEquals(
                "Relaxa, eu sei o que estou fazendo!",
                marciano.responda("isso é SÉRIO?")
        );
    }

    @Test
    @DisplayName("Grito simples deve retornar 'Opa! Calma aí!'")
    void gritoRetornaOpaCalmaAi() {
        assertEquals("Opa! Calma aí!", marciano.responda("CUIDADO"));
    }

    @Test
    @DisplayName("Grito com palavras minúsculas misturadas deve retornar 'Opa! Calma aí!'")
    void gritoComPalavrasMinusculasMisturadas() {
        assertEquals("Opa! Calma aí!", marciano.responda("olha o BARULHO todo"));
    }

    @Test
    @DisplayName("Pergunta simples deve retornar 'Certamente'")
    void perguntaRetornaCertamente() {
        assertEquals("Certamente", marciano.responda("tudo bem?"));
    }

    @Test
    @DisplayName("Pergunta com letras minúsculas deve retornar 'Certamente'")
    void perguntaMinusculaRetornaCertamente() {
        assertEquals("Certamente", marciano.responda("você vai ajudar?"));
    }

    @Test
    @DisplayName("Frase com 'eu' deve retornar 'A responsabilidade é sua'")
    void fraseComEuRetornaResponsabilidadeESua() {
        assertEquals("A responsabilidade é sua", marciano.responda("eu fiz isso"));
    }

    @Test
    @DisplayName("Frase com 'EU' maiúsculo isolado deve retornar resposta de grito, não de 'eu'")
    void fraseComEUMaiusculoIsolado() {
        assertEquals("Opa! Calma aí!", marciano.responda("EU fiz isso"));
    }

    @Test
    @DisplayName("Palavra 'eu' embutida em outra palavra não ativa a regra")
    void palavraEuDentroDeOutraPalavra() {
        assertEquals("Tudo bem, como quiser", marciano.responda("este é o meu projeto"));
    }

    @Test
    @DisplayName("Frase genérica deve retornar 'Tudo bem, como quiser'")
    void fraseGenericaRetornaTudoBem() {
        assertEquals("Tudo bem, como quiser", marciano.responda("olá, como vai você"));
    }

    @Test
    @DisplayName("Frase sem nenhuma regra especial deve retornar 'Tudo bem, como quiser'")
    void fraseSemRegra() {
        assertEquals("Tudo bem, como quiser", marciano.responda("boa tarde"));
    }

    @Test
    @DisplayName("Frase com apenas pontuação não deve ser detectada como grito")
    void fraseComApenaspontuacaoNaoEGrito() {
        assertEquals("Tudo bem, como quiser", marciano.responda("... !!!"));
    }
}
