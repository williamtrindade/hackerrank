package com.williamtrindade.balancedBrackets;

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

class ResultA {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {

        // Write your code here
        Map<Character, Character> mapClose = new HashMap<>();
        mapClose.put('}', '{');
        mapClose.put(']', '[');
        mapClose.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.size() > s.length() / 2) return "NO";
            if (mapClose.containsKey(s.charAt(i))) {
                if (stack.empty()) return "NO";

                if (mapClose.get(s.charAt(i)) != stack.peek()) {
                    return "NO";
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (!stack.empty()) return "NO";
        return "YES";
    }

}

public class SolutionA {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = ResultA.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
