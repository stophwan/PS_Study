package programmers.kakao2021blind;

public class P72410 {
    public String solution(String new_id) {
        String answer = "";
        String step1 = new_id.toLowerCase();

        char[] c_arr = step1.toCharArray();
        String step2 = "";
        for(char c: c_arr){
            if((c>='a' && c<='z') || (c>='0' && c<='9') || c=='-' || c=='_' || c=='.') {
                step2 += c;
            }
        }

        String step3 = step2.replace("..", ".");
        while(step3.contains("..")){
            step3 = step3.replace("..", ".");
        }

        String step4 = step3;
        if(step4.length()>0) {
            if(step4.charAt(0) == '.') {
                step4 = step4.substring(1, step4.length());
            }
        }
        if(step4.length()>0) {
            if(step4.charAt(step4.length()-1) == '.') {
                step4 = step4.substring(0, step4.length()-1);
            }
        }

        String step5 = step4;
        if(step5.length() == 0) {
            step5 = "a";
        }

        String step6 = step5;
        if(step6.length() >= 16) {
            step6 = step6.substring(0, 15);
            if(step6.charAt(step6.length()-1)=='.') {
                step6 = step6.substring(0, step6.length()-1);
            }
        }

        String step7 = step6;
        if(step7.length() < 3){
            char c = step7.charAt(step7.length()-1);
            while(step7.length() < 3) {
                step7 += c;
            }
        }
        return step7;
    }
}
