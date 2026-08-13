package com.williamtrindade.QHEAP1;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int q = Integer.parseInt(reader.readLine());
        for (int i = 0; i < q; i++) {
            String op = reader.readLine();
            String[] parts = op.split(" ");
            if (parts.length > 1) {
                int opCode = Integer.parseInt(parts[0]);
                int number = Integer.parseInt(parts[1]);

                if (opCode == 1) {
                    heap.add(number);
                } else {
                    heap.remove(number);
                }
            } else {
                System.out.println(heap.peek());
            }

        }
    }
}
