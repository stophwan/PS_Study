package programmers.highscorekit;

import java.util.HashSet;
import java.util.Set;

//해시, 전화번호 목록, 고득점 kit
public class P42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> stringSet = new HashSet<>();
        for(String s : phone_book) {
            stringSet.add(s);
        }
        for(String s: phone_book) {
            for(int i=0; i<s.length(); i++) {
                if(stringSet.contains(s.substring(0,i))){
                    answer = false;
                }
            }
        }
        return answer;
    }
}
