package programmers.summercoding;

// 멀쩡한 사각형, Summer Coding 2019
public class P62048 {
    public long solution(int w, int h) {
        int s = 1;
        int min = w;
        if(w>h){
            min = h;
        }
        for(int i=1; i<=min; i++) {
            if(w%i==0 && h%i==0){
                s = i;
            }
        }

        long remove = ((w/s)+(h/s) - 1) * s;
        long answer = (long)w*h - remove;
        return answer;
    }
}
