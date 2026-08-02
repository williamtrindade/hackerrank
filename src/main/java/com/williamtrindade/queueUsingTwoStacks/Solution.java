package com.williamtrindade.queueUsingTwoStacks;

import java.io.*;
import java.util.*;

public class Solution {
    private final Stack<String> primaryStack;
    private final Stack<String> secondStack;

    public Solution() {
        this.primaryStack = new Stack<>();
        this.secondStack = new Stack<>();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            if (counter == 0) {
                counter++;
                continue;
            }

            String[] parts = line.split(" ");

            if (parts.length > 1) {
                // enquee
                solution.primaryStack.push(parts[1]);
                continue;
            }

            if (solution.secondStack.isEmpty()) {
                String stackTop;

                while (!solution.primaryStack.isEmpty()) {
                    stackTop = solution.primaryStack.pop();
                    solution.secondStack.push(stackTop);
                }
            }

            if (parts[0].equals("2")) {
                // dequeue
                solution.secondStack.pop();
            } else {
                System.out.println(solution.secondStack.peek());
            }
        }
        scanner.close();
    }
}