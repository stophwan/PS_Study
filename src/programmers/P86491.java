package programmers;

// 최소 직사각형, 완전탐색, 프로그래머스 고득점 Kit
public class P86491 {
    public int solution(int[][] sizes) {
        int max_w = 0;
        int max_h = 0;
        for(int[] size: sizes) {
            max_w = Math.max(max_w, Math.max(size[0],size[1]));
            max_h = Math.max(max_h, Math.min(size[0],size[1]));
        }
        return max_w * max_h;
    }
}
