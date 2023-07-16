package programmers.highscorekit.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//여행 경로, 프로그래머스 고득점 kit, **
public class P43164 {
    boolean[] visited;
    List<String> paths = new ArrayList<>();
    String[][] tickets;
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN");
        Collections.sort(paths);
        return paths.get(0).split(" ");
    }

    public void dfs(int idx, String now, String path) {
        if(idx==tickets.length){
            paths.add(path);
            return;
        }
        for(int i=0; i<tickets.length; i++) {
            if(!visited[i] && now.equals(tickets[i][0])){
                visited[i] = true;
                dfs(idx+1, tickets[i][1], path + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}
