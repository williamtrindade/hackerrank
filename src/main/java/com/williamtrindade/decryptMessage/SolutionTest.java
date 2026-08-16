package com.williamtrindade.decryptMessage;

import java.util.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

class ResultTest {

    @Test
    void testExampleCase() {
        String input = "world hel2o";
        String expected = "hello world";
        assertEquals(expected, Result.decryptMessage(input), "O exemplo base do enunciado falhou.");
    }

    @Test
    void testSampleCase0() {
        String input = "seaside the to sent be to ne2ds army ten of team a";
        String expected = "a team of ten army needs to be sent to the seaside";
        assertEquals(expected, Result.decryptMessage(input), "Sample Case 0 falhou.");
    }

    @Test
    void testSingleWord() {
        String input = "mis2is2ip2i";
        String expected = "mississippi";
        assertEquals(expected, Result.decryptMessage(input), "Falha ao processar uma única palavra.");
    }

    @Test
    void testMaxFrequencyConstraint() {
        String input = "z9 a9 b9";
        String expected = "bbbbbbbbb aaaaaaaaa zzzzzzzzz";
        assertEquals(expected, Result.decryptMessage(input), "Falha no limite da restrição (frequência 9).");
    }

    @Test
    void testNoCompression() {
        String input = "c b a";
        String expected = "a b c";
        assertEquals(expected, Result.decryptMessage(input), "Falha em palavras sem números.");
    }

    @Test
    void testPerformance() {
        // Preparando a carga massiva de dados (100.000 caracteres)
        StringBuilder largeInputBuilder = new StringBuilder();
        StringBuilder expectedOutputBuilder = new StringBuilder();

        int numWords = 25000;
        for (int i = 0; i < numWords; i++) {
            largeInputBuilder.append("a9");
            expectedOutputBuilder.append("aaaaaaaaa");
            if (i < numWords - 1) {
                largeInputBuilder.append(" ");
                expectedOutputBuilder.append(" ");
            }
        }

        String largeInput = largeInputBuilder.toString();
        String expectedOutput = expectedOutputBuilder.toString();

        // O assertTimeout do JUnit garante que se passar de 2 segundos, o teste falha automaticamente!
        assertTimeout(Duration.ofSeconds(2), () -> {
            String actualOutput = Result.decryptMessage(largeInput);
            assertEquals(expectedOutput, actualOutput, "A saida do teste de carga massiva esta incorreta.");
        }, "O tempo de execucao excedeu 2 segundos. Reveja a performance (ex: tire o insert(0)).");
    }
}