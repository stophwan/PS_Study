package programmers.highscorekit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P42895 {
    List<Set<Integer>> list;
    public int solution(int N, int number) {
        list = new ArrayList<>();
        for(int i=0; i<=8; i++) {
            list.add(new HashSet<Integer>());
        }
        list.get(1).add(N);
        if(number==N){
            return 1;
        }
        for(int i=2; i<9; i++) {
            for(int j=1; j<=i/2; j++){
                operate(i,j,i-j);
            }
            String n = Integer.toString(N);
            list.get(i).add(Integer.parseInt(n.repeat(i)));
            for(int res: list.get(i)){
                if(res == number){
                    return i;
                }
            }
        }
        return -1;
    }

    void operate(int c, int a, int b){
        for(int n1: list.get(a)){
            for(int n2: list.get(b)){
                list.get(c).add(n1 + n2);
                list.get(c).add(n1 - n2);
                list.get(c).add(n2 - n1);
                list.get(c).add(n1 * n2);
                if(n2 != 0) {
                    list.get(c).add(n1 / n2);
                }
                if(n1 != 0) {
                    list.get(c).add(n2 / n1);
                }
            }
        }
    }
}
