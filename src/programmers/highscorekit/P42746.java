package programmers.highscorekit;

import java.util.Arrays;

public class P42746 {
    public String solution(int[] numbers) {
        String[] arr = Arrays.stream(numbers).mapToObj(i -> String.valueOf(i)).toArray(String[]::new);
        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        //Arrays.sort(arr, (o1,o2) -> Integer.parseInt(o2+o1)-Integer.parseInt(o1+o2)); 도 가능하다.
        if(arr[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(i -> sb.append(i));
        return sb.toString();
    }
}
