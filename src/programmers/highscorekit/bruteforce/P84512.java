package programmers.highscorekit.bruteforce;

public class P84512 {
    String[] alpha = new String[]{"A", "E", "I", "O", "U"};
    int answer = 0;
    boolean isEqual = false;
    public int solution(String word) {
        dfs(word, new StringBuilder());
        return answer;
    }

    public void dfs(String word, StringBuilder sb){
        if(word.equals(sb.toString())){
            isEqual = true;
            return;
        }

        if(sb.length() == 5){
            return;
        }

        for(int i=0; i<5; i++){
            answer++;
            sb.append(alpha[i]);
            dfs(word, sb);
            if(isEqual) return;
            sb.delete(sb.length()-1, sb.length());
        }
    }
}
