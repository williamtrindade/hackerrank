package com.williamtrindade.quicksort1Partition;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ResultTest {

    @Test
    void testSampleCase() {
        // Arrange (Preparação)
        List<Integer> arr = new ArrayList<>(Arrays.asList(4, 5, 3, 7, 2));
        List<Integer> expected = Arrays.asList(3, 2, 4, 5, 7); // Saída exata gerada pelo seu algoritmo

        // Act (Ação)
        List<Integer> result = Result.quickSort(arr);

        // Assert (Verificação)
        assertEquals(expected, result, "Deve particionar corretamente com o pivô no meio.");
    }

    @Test
    void testAlreadySortedArray() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // O algoritmo mantém a ordem quando o array já está ordenado,
        // pois os ponteiros i e j coincidem.
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> result = Result.quickSort(arr);
        assertEquals(expected, result, "Deve lidar com arrays já ordenados.");
    }

    @Test
    void testWithNegativeNumbers() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(0, -3, 6, 4, -10, 8));

        // Pivô = 0.
        // Saída real do seu algoritmo com base nas trocas dos índices.
        List<Integer> expected = Arrays.asList(-10, -3, 0, 6, 4, 8);

        List<Integer> result = Result.quickSort(arr);
        assertEquals(expected, result, "Deve particionar corretamente com números negativos.");
    }
    @Test
    void testReverseSortedArray() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));

        // O pivô é 5. Como todos são menores, o pivô vai para o final.
        List<Integer> expected = Arrays.asList(1, 4, 3, 2, 5);

        List<Integer> result = Result.quickSort(arr);
        assertEquals(expected, result, "Deve lidar com arrays em ordem decrescente.");
    }

    @Test
    void testValidationRuleLeftAndRight() {
        // Este teste verifica a regra de negócio real do HackerRank,
        // onde a ordem não importa, contanto que menores fiquem à esquerda e maiores à direita.
        List<Integer> arr = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 10, 1, 8));
        int pivot = arr.get(0); // 6

        List<Integer> result = Result.quickSort(arr);

        // Encontra onde o pivô foi parar
        int pivotIndex = result.indexOf(pivot);

        // Verifica se tudo à esquerda é menor que o pivô
        for (int i = 0; i < pivotIndex; i++) {
            assertTrue(result.get(i) < pivot, "Elemento à esquerda do pivô deve ser menor que o pivô.");
        }

        // Verifica se tudo à direita é maior que o pivô
        for (int i = pivotIndex + 1; i < result.size(); i++) {
            assertTrue(result.get(i) > pivot, "Elemento à direita do pivô deve ser maior que o pivô.");
        }
    }
}