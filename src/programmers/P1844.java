package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 게임 맵 최단 거리 bfs *
public class P1844 {
    private int[][] visited;
    int mapSize_x;
    int mapSize_y;
    public int solution(int[][] maps) {
        mapSize_x = maps.length;
        mapSize_y = maps[0].length;
        visited = new int[mapSize_x][mapSize_y];
        for (int i = 0; i < mapSize_x; i++) {
            Arrays.fill(visited[i], -1);
        }

        return bfs(maps);
    }

    public int bfs(int[][] maps) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        visited[0][0] = 1;
        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            if(x == mapSize_x-1 && y == mapSize_y-1) {
                return visited[x][y];
            }
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0<=nx && nx<mapSize_x && 0<=ny && ny<mapSize_y) {
                    if(maps[nx][ny]==1 && visited[nx][ny] == -1) {
                        q.offer(new Point(nx, ny));
                        visited[nx][ny] = visited[x][y] + 1;
                    }
                }
            }
        }
        return -1;
    }

    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
