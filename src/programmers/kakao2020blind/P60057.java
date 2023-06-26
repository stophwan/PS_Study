package programmers.kakao2020blind;

public class P60057 {
    public int solution(String s) {
        int len = s.length();
        int answer = s.length();
        for(int i=1; i<=len/2; i++){
            StringBuilder sb = new StringBuilder();
            String word = s.substring(0,i);
            int cnt = 1;
            for(int j=i; j<=len; j+=i){
                int end = Math.min(j+i, len);
                if(word.equals(s.substring(j,end))){
                    cnt++;
                }
                else{
                    if(cnt>=2){
                        sb.append(cnt).append(word);
                    }
                    else{
                        sb.append(word);
                    }
                    word = s.substring(j,end);
                    cnt = 1;
                }
            }
            sb.append(word);
            answer = Math.min(sb.length(), answer);
        }
        return answer;
    }

}
