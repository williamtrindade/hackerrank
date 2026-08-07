package com.williamtrindade.quicksort2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

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
    public void testQuickSortSampleInput() {
        int[] input = {5, 8, 1, 3, 7, 9, 2};

        // Expected result based on the Sample Output from the problem statement
        String expectedOutput =
                "2 3\n" +
                "1 2 3\n" +
                "7 8 9\n" +
                "1 2 3 5 7 8 9\n";

        // Execute the method to be implemented by the candidate
        Solution.quickSort(input);

        // Verify if the console output matches the expected output
        assertEquals(expectedOutput, outContent.toString().replace("\r\n", "\n"));
    }
}