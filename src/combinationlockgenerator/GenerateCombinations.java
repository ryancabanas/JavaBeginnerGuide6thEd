/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinationlockgenerator;

import java.util.Arrays;

public class GenerateCombinations {

    public static void main(String[] args) {
        final int n = 5;

        int[] current = new int[n];
        for (int i = 1; i <= n; i++) {
            current[i - 1] = i;
        }

        int total = 0;
        for (;;) {
            total++;

            boolean[] used = new boolean[n + 1];
            Arrays.fill(used, true);

            for (int i = 0; i < n; i++) {
                System.out.print(current[i] + " ");
            }

            System.out.println();

            used[current[n - 1]] = false;

            int pos = -1;
            for (int i = n - 2; i >= 0; i--) {              
                used[current[i]] = false;

                if (current[i] < current[i + 1]) {
                    pos = i;
                    break;
                }
            }

            if (pos == -1) {
                break;
            }               

            for (int i = current[pos] + 1; i <= n; i++) {
                if (!used[i]) {
                    current[pos] = i;
                    used[i] = true;
                    break;
                }
            }

            for (int i = 1; i <= n; i++) {
                if (!used[i]) {
                    current[++pos] = i;
                }
            }
        }

        System.out.println(total);
    }       
}