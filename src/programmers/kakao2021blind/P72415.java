package programmers.kakao2021blind;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P72415 {
    int[][] board;
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};
    int size = 0;
    //카드 번호, 나온 순서, xy값
    int[][][] map = new int[9][2][2];
    int answer = Integer.MAX_VALUE;

    public int solution(int[][] board, int r, int c) {
        this.board = board;
        boolean[] visited = new boolean[9];
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(board[i][j]>0) {
                    if(!visited[board[i][j]]) {
                        map[board[i][j]][0][0] = i;
                        map[board[i][j]][0][1] = j;
                        visited[board[i][j]] = true;
                        size++;
                    } else {
                        map[board[i][j]][1][0] = i;
                        map[board[i][j]][1][1] = j;
                    }
                }
            }
        }
        dfs(r, c, 0, size, 0, new boolean[size+1]);
        return answer;
    }

    private void dfs(int r, int c, int idx, int n, int res, boolean[] visited) {
        if(idx == n) {
            answer = Math.min(answer, res);
            return;
        }

        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                int dist1 = bfs(r, c, map[i][0][0], map[i][0][1])
                        + bfs(map[i][0][0], map[i][0][1], map[i][1][0], map[i][1][1]) + 2;
                int dist2 = bfs(r, c, map[i][1][0], map[i][1][1])
                        + bfs(map[i][1][0], map[i][1][1], map[i][0][0], map[i][0][1]) + 2;
                visited[i]=true;
                board[map[i][0][0]][map[i][0][1]] = 0;
                board[map[i][1][0]][map[i][1][1]] = 0;
                if(dist1 < dist2) {
                    dfs(map[i][1][0], map[i][1][1], idx+1, n, res+dist1, visited);
                } else {
                    dfs(map[i][0][0], map[i][0][1], idx+1, n, res+dist2, visited);
                }
                board[map[i][0][0]][map[i][0][1]] = 1;
                board[map[i][1][0]][map[i][1][1]] = 1;
                visited[i]=false;
            }
        }
    }

    private int bfs(int sx, int sy, int tx, int ty) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx,sy});
        int cnt = 0;
        boolean[][] visited = new boolean[4][4];
        visited[sx][sy] = true;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int j=0; j<len; j++) {
                int[] arr = q.poll();
                int x = arr[0], y = arr[1];
                if(x==tx && y==ty) {
                    return cnt;
                }

                for(int i=0; i<4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(checkRange(nx, ny) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny});
                    }
                }

                for(int i=0; i<4; i++) {
                    int nx = x;
                    int ny = y;
                    while(true) {
                        nx += dx[i];
                        ny += dy[i];
                        if(!checkRange(nx,ny)){
                            nx -= dx[i];
                            ny -= dy[i];
                            break;
                        }
                        if(board[nx][ny] > 0) {
                            break;
                        }
                    }
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }

    private boolean checkRange(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }
}
