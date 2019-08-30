package hacker;

import java.util.Scanner;

class Hack {
    public static void main(String args[] ) throws Exception {
        try(Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] input = new int[N];
 
            for(int idx = 0; idx < N; ++idx) {
                switch (scanner.next().charAt(0)) {
                    case 'G': input[idx] = 0; break;
                    case 'R': input[idx] = 1; break;
                    case 'Y': input[idx] = 2; break;
                }
            }
 
            int[] temp = new int[N];
            int offset = 0, result = 0;
 
            for(int idx = 0; idx < N; ++idx) {
                input[idx] += offset;
 
                switch (input[idx] % 3) {
                    case 1: temp[idx] = 2; result += 2; offset += 2; break;
                    case 2: temp[idx] = 1; result += 1; offset += 1; break;
                    default: temp[idx] = 0; break;
                }
 
                if ((idx+1)-K >= 0) offset -= temp[idx+1-K];
            }
            System.out.println(result);
        }
    }
}