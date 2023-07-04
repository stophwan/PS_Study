package programmers.kakao2021blind;

public class P72414 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = convertToSeconds(play_time);
        int adv = convertToSeconds(adv_time);
        long[] times = new long[play+1];
        for(String log : logs) {
            int start = convertToSeconds(log.split("-")[0]);
            int end = convertToSeconds(log.split("-")[1]);
            times[start]++;
            times[end]--;
        }

        for(int i=1; i<=play; i++) {
            times[i] += times[i-1];
        }

        for(int i=1; i<=play; i++) {
            times[i] += times[i-1];
        }

        long sum = times[adv-1];
        int idx = 0;
        for(int i=adv; i<play; i++) {
            if(sum<times[i] - times[i-adv]){
                sum = times[i] - times[i-adv];
                idx = i-adv+1;
            }
        }

        return convertToString(idx);
    }

    private int convertToSeconds(String time) {
        String[] arr = time.split(":");
        int s = 0;
        s += Integer.parseInt(arr[0])*3600 + Integer.parseInt(arr[1])*60 + Integer.parseInt(arr[2]);
        return s;
    }

    private String convertToString(int seconds) {
        int h = seconds/3600;
        int m = (seconds%3600)/60;
        int s = seconds - 3600 * h - 60 * m;
        return addZero(h) + ":" + addZero(m) + ":" + addZero(s);
    }
    private String addZero(int n) {
        if(n<10) {
            return "0"+n;
        }
        return String.valueOf(n);
    }
}
