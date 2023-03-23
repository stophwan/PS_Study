package programmers;

// 그리디, 큰 수 만들기 **
public class P42883 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int max;
        for(int i=0; i<number.length()-k; i++) {
            max = 0;
            for(int j=idx; j<=i+k; j++) {
                if(number.charAt(j)-'0' > max){
                    max = number.charAt(j)-'0';
                    idx=j+1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }
}
