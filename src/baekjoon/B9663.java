package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.abs;

public class B9663 {
    private int[] queen;
    private int cnt = 0;
    private void dfs(int col, int n) {
        if(col == n) {
            cnt++;
            return;
        }
        for(int row=0; row<n; row++) {
            queen[col] = row;
            if(check(col)) {
                dfs(col + 1, n);
            }
        }
    }

    private boolean check(int col) {
        for(int i=0; i<col; i++) {
            if(queen[col] == queen[i]) {
                return false;
            }
            if(abs(queen[col] - queen[i]) == col -i) {
                return false;
            }
        }
        return true;
    }
    private void solution(int n){
        queen = new int[n];
        dfs(0, n);
        System.out.println(cnt);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        new B9663().solution(n);
    }
}
