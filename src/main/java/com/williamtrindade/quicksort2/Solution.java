package com.williamtrindade.quicksort2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static void quickSort(int[] ar) {
        quickSort(ar, 0, ar.length-1);
    }

    static int[] quickSort(int[] ar, int left, int right) {
        if (left >= right) return ar;
        int pivot = ar[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (ar[j] <= pivot) {
                i++;
                int aux = ar[j]; ar[j] = ar[i]; ar[i] = aux;
            }
        }
        i++;
        int aux = ar[right]; ar[right] = ar[i]; ar[i] = aux;
        ar = quickSort(ar, left, i - 1);
        ar = quickSort(ar, i + 1, right);
        return ar;
    }

    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        quickSort(ar);
    }
}
