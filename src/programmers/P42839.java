package programmers;

import java.util.HashSet;

// 소수찾기, 완전탐색, **
public class P42839 {
    static HashSet<Integer> numberSet = new HashSet<>();
    static int[] visited = new int[7];
    public int solution(String numbers) {
        int answer = 0;
        dfs("", numbers);
        for(int num : numberSet){
            if(check(num)){
                answer++;
            }
        }
        return answer;
    }

    public void dfs(String tmp, String numbers) {
        if(tmp.length() > numbers.length()){
            return;
        }
        if(!tmp.equals("")){
            numberSet.add(Integer.valueOf(tmp));
        }
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]==0){
                visited[i]=1;
                dfs(tmp + numbers.charAt(i), numbers);
                visited[i]=0;
            }
        }
    }

    public boolean check(int number) {
        if(number==0 || number ==1){
            return false;
        }
        for(int i=2; i<number; i++) {
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }
}
