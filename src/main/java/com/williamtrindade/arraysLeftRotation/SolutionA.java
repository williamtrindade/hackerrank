// My Solution
package com.williamtrindade.arraysLeftRotation;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultA {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // iterating one time the arary
        // creating an aux array
        // O of n Solution in time and space complexity

        int arraySize = a.size();
        List<Integer> aux = new ArrayList<>(Collections.nCopies(arraySize, null));

        for (int i = 0; i < arraySize; i++) {
            int newPosition = ResultA.rotate(
                    i,
                    d,
                    arraySize
            );
            aux.set(newPosition, a.get(i));
        }
        return aux;
    }

    public static int rotate(int actualPosition, int rotations, int size) {
        return (actualPosition - (rotations % size) + size) % size;
    }

}

public class SolutionA {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = ResultA.rotLeft(a, d);

        String res =
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        ;
        System.out.println(res);

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
