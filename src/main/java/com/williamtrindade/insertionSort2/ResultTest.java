package com.williamtrindade.insertionSort2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultTest {

    // Streams para interceptar o System.out.print
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testInsertionSort2_SampleInput() {
        // Arrange (Preparação)
        int n = 6;
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 4, 3, 5, 6, 2));

        String expectedOutput =
                "1 4 3 5 6 2 \n" +
                "1 3 4 5 6 2 \n" +
                "1 3 4 5 6 2 \n" +
                "1 3 4 5 6 2 \n" +
                "1 2 3 4 5 6 \n";

        // Act (Ação)
        Result.insertionSort2(n, arr);

        // Assert (Verificação)
        // Padronizamos as quebras de linha para \n para evitar falhas entre Windows (\r\n) e Linux/Mac (\n)
        String actualOutput = outContent.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testInsertionSort2_ExampleInput() {
        // Arrange
        int n = 7;
        List<Integer> arr = new ArrayList<>(Arrays.asList(3, 4, 7, 5, 6, 2, 1));

        String expectedOutput =
                "3 4 7 5 6 2 1 \n" +
                "3 4 7 5 6 2 1 \n" +
                "3 4 5 7 6 2 1 \n" +
                "3 4 5 6 7 2 1 \n" +
                "2 3 4 5 6 7 1 \n" +
                "1 2 3 4 5 6 7 \n";

        // Act
        Result.insertionSort2(n, arr);

        // Assert
        String actualOutput = outContent.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }
}