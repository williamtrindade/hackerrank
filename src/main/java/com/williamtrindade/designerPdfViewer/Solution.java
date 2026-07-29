package com.williamtrindade.designerPdfViewer;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
        int tallestHeigth = 0;
        int wordLength = word.length();

        for (int i = 0; i < wordLength; i++) {
            char letter = word.charAt(i);
            int index = (int) letter - 97;
            if (h.get(index) > tallestHeigth) {
                tallestHeigth = h.get(index);
            }
        }

        return tallestHeigth * word.length();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();
        System.out.println(result);
        bufferedReader.close();
        // bufferedWriter.close();
    }
}
