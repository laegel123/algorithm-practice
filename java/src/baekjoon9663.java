import java.util.Scanner;

public class baekjoon9663 {
    static int N;
    static int[] QUEEN;
    static int COUNT;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        QUEEN = new int[N];
        
        dfs(0);

        System.out.println(COUNT);
        sc.close();
    }

    static void dfs(int row) {
        if (row == N) {
            COUNT++;
            return;
        }

        for (int col = 0; col < N; col++) {
            QUEEN[row] = col;

            if (isPossible(row)) {
                dfs(row + 1);
            }
        }
    }

    static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (QUEEN[i] == QUEEN[row]) {
                return false;
            }

            if (Math.abs(row - i) == Math.abs(QUEEN[row] - QUEEN[i])) {
                return false;
            }
        }

        return true;
    }
    
}
