package programmers.highscorekit;

import java.util.Arrays;

public class P43163 {
    String[] words;
    boolean[] visited;
    int answer = (int)1e9;
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        boolean containsTarget = Arrays.stream(words).anyMatch(word -> word.equals(target));
        if(!containsTarget) return 0;
        visited = new boolean[words.length];
        dfs(0, begin, target);
        return answer;
    }

    public void dfs(int idx, String now, String target) {
        if(now.equals(target)) {
            answer = Math.min(answer, idx);
        }
        for(int i=0; i<words.length; i++) {
            if(!visited[i] && check(words[i], now)){
                visited[i] = true;
                dfs(idx+1, words[i], target);
                visited[i] = false;
            }
        }
    }


    public boolean check(String s1, String s2) {
        int cnt = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        if(cnt==1) return true;
        return false;
    }
}
