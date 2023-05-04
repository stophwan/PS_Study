package programmers.kakao2020blind;

import java.util.Stack;

public class P60058 {

    public String solution(String p) {
        if(checkRightString(p)){
            return p;
        }
        String answer = dfs(p);
        return answer;
    }

    public String dfs(String s){
        if(s.equals("")){
            return "";
        }
        String u = "";
        String v = "";
        int l = 0;
        int r = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='('){
                l++;
            }
            if(s.charAt(i)==')'){
                r++;
            }
            if(l>0 && r>0 && l==r){
                u = s.substring(0,i+1);
                v = s.substring(i+1, s.length());
                break;
            }
        }
        if(checkRightString(u)){
            return u + dfs(v);
        }
        else{
            u = u.substring(1,u.length()-1);
            u = u.replace("(", ".");
            u = u.replace(")", "(");
            u = u.replace(".", ")");
            return "(" + dfs(v) + ")" + u;
        }

    }

    public boolean checkRightString(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                stack.push('(');
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
