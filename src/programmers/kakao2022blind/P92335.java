package programmers.kakao2022blind;

public class P92335 {
    public int solution(int n, int k) {
        String number = convert(n,k);
        return count(number);
    }

    private int count(String number) {
        int cnt = 0;
        String[] arr = number.split("0");
        for(String s: arr) {
            if(s.equals("")){
                continue;
            }
            if(prime(Long.parseLong(s))) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean prime(long num) {
        int count = 0;
        if(num<2){
            return false;
        }

        for(long i = 2; i*i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    private String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n>0) {
            sb.append(n%k);
            n /= k;
        }
        return sb.reverse().toString();
    }
}
