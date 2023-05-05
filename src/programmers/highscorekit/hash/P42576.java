package programmers.highscorekit.hash;

import java.util.Arrays;

public class P42576 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for(i=0; i<completion.length; i++) {
            if(!completion[i].equals(participant[i])){
                return participant[i];
            }
        }

        return participant[i];
    }
}
