package com.williamtrindade.decryptMessage;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

class Result {
    public static String decryptMessage(String encryptedMessage) {
        StringBuilder sb = new StringBuilder();

        // split
        String[] splittedString = encryptedMessage.split(" ");

        // PERCORRENDO DE TRÁS PARA FRENTE
        for(int i = splittedString.length - 1; i >= 0; i--) {
            String word = splittedString[i];
            String reverted = Result.revert(word);

            sb.append(reverted);

            if (i > 0) {
                sb.append(" "); // Adiciona o espaço, exceto na última palavra
            }
        }
        return sb.toString();

    }

    public static String revert(String s) {
        StringBuilder sb = new StringBuilder();
        Character last = ' ';
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c) && !Character.isDigit(last)) {
                long qtt = Character.getNumericValue(c) - 1;
                while (qtt > 0) {
                    sb.append(last);
                    qtt--;
                }
            } else {
                sb.append(c);
            }
            last = c;
        }
        return sb.toString();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String encryptedMessage = bufferedReader.readLine();

        String result = Result.decryptMessage(encryptedMessage);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}