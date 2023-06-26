package programmers.kakao2020blind;

public class P60058 {

    public String solution(String p) {
        return solve(p);
    }

    public String solve(String s){
        if(s.length()==0){
            return s;
        }
        int idx = getBalanceIdx(s);
        String u = s.substring(0,idx+1);
        String v = s.substring(idx+1);
        if(isCorrect(u)){
            return u + solve(v);
        }
        u=u.substring(1,u.length()-1);
        u = u.replace("(", ".");
        u = u.replace(")", "(");
        u = u.replace(".", ")");
        return "(" + solve(v) + ")" + u;
    }

    public int getBalanceIdx(String s) {
        int lcnt = 0;
        int rcnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                lcnt++;
            }
            if(s.charAt(i)==')'){
                rcnt++;
            }
            if(lcnt==rcnt){
                return i;
            }
        }
        return s.length()-1;
    }

    private boolean isCorrect(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (right > left) {
                return false;
            }
        }
        return true;
    }
}
