package programmers.kakao2022blind;

import java.util.*;

public class P92341 {
    Map<String, Integer> in = new HashMap<>();
    Map<String, Integer> times = new HashMap<>();
    public int[] solution(int[] fees, String[] records) {
        for(String record: records) {
            String[] arr = record.split(" ");
            String state = arr[2];
            if(state.equals("IN")) {
                in.putIfAbsent(arr[1], convertString(arr[0]));
            } else {
                int diff = convertString(arr[0]) - in.get(arr[1]);
                times.put(arr[1], times.getOrDefault(arr[1], 0) + diff);
                in.remove(arr[1]);
            }
        }

        for(String key: in.keySet()) {
            int last = convertString("23:59");
            int diff = last - in.get(key);
            times.put(key, times.getOrDefault(key, 0) + diff);
        }
        List<String> cars = new ArrayList<>(times.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];
        for(int i=0; i<cars.size(); i++) {
            answer[i] = calculate(fees, times.get(cars.get(i)));
        }
        return answer;
    }

    private int calculate(int[] fees, int diff) {
        int res = fees[1];
        if(diff<fees[0]) {
            return res;
        } else {
            double d = (diff-fees[0])/(double)fees[2];
            res += Math.ceil(d) * fees[3];
        }
        return res;
    }

    private int convertString(String time) {
        String[] arr = time.split(":");
        int h = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        return 60 * h + m;
    }
}
