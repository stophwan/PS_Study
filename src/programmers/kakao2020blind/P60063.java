package programmers.kakao2020blind;

import java.util.LinkedList;
import java.util.Queue;

public class P60063 {
    int[][][] visited;
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};
    int len;
    public int solution(int[][] board) {
        len = board.length;
        visited = new int[2][len][len];
        int answer = bfs(board);
        return answer;
    }

    public int bfs(int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        q.offer(new int[]{0, 0, 0, 1, 0});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] arr = q.poll();
                int ax = arr[0], ay = arr[1], bx = arr[2], by = arr[3], state = arr[4];
                if(!checkBoard(ax,ay,bx,by,state,board)) {
                    continue;
                }
                visited[state][ax][ay]=1;

                if(bx==len-1 && by==len-1) {
                    return cnt;
                }

                for(int j=0; j<4; j++) {
                    int n_ax = ax + dx[j];
                    int n_ay = ay + dy[j];
                    int n_bx = bx + dx[j];
                    int n_by = by + dy[j];
                    q.offer(new int[]{n_ax, n_ay, n_bx, n_by, state});
                }

                if(state==0) {
                    if(ax<len-1 && board[ax+1][ay]==0 && board[ax+1][by]==0){
                        q.offer(new int[]{ax, ay, ax+1, ay, 1-state});
                        q.offer(new int[]{ax, by, ax+1, by, 1-state});
                    }
                    if(ax>0 && board[ax-1][ay]==0 && board[ax-1][by]==0){
                        q.offer(new int[]{ax-1, ay, ax, ay, 1-state});
                        q.offer(new int[]{ax-1, by, ax, by, 1-state});
                    }
                } else {
                    if(ay<len-1 && board[ax][ay+1]==0 && board[bx][ay+1]==0){
                        q.offer(new int[]{ax, ay, ax, ay+1, 1-state});
                        q.offer(new int[]{bx, ay, bx, ay+1, 1-state});
                    }
                    if(ay>0 && board[ax][ay-1]==0 && board[bx][ay-1]==0){
                        q.offer(new int[]{bx, ay-1, bx, ay, 1-state});
                        q.offer(new int[]{ax, ay-1, ax, ay, 1-state});
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }

    public boolean checkBoard(int ax, int ay, int bx, int by, int state, int[][] board) {
        if(ax<0 || ay<0 || ax>=len || ay>=len) {
            return false;
        }
        if(bx<0 || by<0 || bx>=len || by>=len) {
            return false;
        }
        if(board[ax][ay]==1 || board[bx][by]==1) {
            return false;
        }
        if(visited[state][ax][ay]==1){
            return false;
        }
        return true;
    }
}
