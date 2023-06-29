package programmers.highscorekit.dfsbfs;

import java.util.*;

// dfs/bfs 퍼즐조각 채우기
public class P84021 {
    static List<List<Point>> empty = new ArrayList<>();
    static List<List<Point>> puzzle = new ArrayList<>();
    static int[][] visited;
    static int[] dx = {-1, 0 , 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        visited = new int[table.length][table.length];
        for(int i=0; i<table.length; i++) {
            for(int j=0; j<table.length; j++) {
                if(game_board[i][j] == 0 && visited[i][j] == 0) {
                    empty.add(check(game_board, i, j, 0));
                }
            }
        }

        visited = new int[table.length][table.length];

        for(int i=0; i<table.length; i++) {
            for(int j=0; j<table.length; j++) {
                if(table[i][j] == 1 && visited[i][j] ==0) {
                    puzzle.add(check(table, i, j, 1));
                }
            }
        }

        int[] visitedTable = new int[puzzle.size()];
        for(int i=0; i<empty.size(); i++) {
            List<Point> emptyPlace = empty.get(i);
            for(int j=0; j<puzzle.size(); j++) {
                List<Point> puzzlePlace = puzzle.get(j);
                if(emptyPlace.size() == puzzlePlace.size() && visitedTable[j] == 0) {
                    if(checkRotate(emptyPlace, puzzlePlace)) {
                        answer += emptyPlace.size();
                        visitedTable[j] = 1;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public boolean checkRotate(List<Point> emptyPlace, List<Point> puzzlePlace) {

        for(int i=0; i<4; i++) {
            int zeroX = puzzlePlace.get(0).x;
            int zeroY = puzzlePlace.get(0).y;

            for(int j=0; j<puzzlePlace.size(); j++) {
                puzzlePlace.get(j).x -= zeroX;
                puzzlePlace.get(j).y -= zeroY;
            }

            boolean isCollect = true;
            for(int j=0; j<puzzlePlace.size(); j++) {
                if(!emptyPlace.get(j).equals(puzzlePlace.get(j))) {
                    isCollect = false;
                    break;
                }
            }

            if(isCollect){
                return true;
            }
            else {
                for (int j = 0; j < puzzlePlace.size(); j++) {
                    int tmp = puzzlePlace.get(j).x;
                    puzzlePlace.get(j).x = puzzlePlace.get(j).y;
                    puzzlePlace.get(j).y = -tmp;
                }
                Collections.sort(puzzlePlace);
            }
        }
        return false;
    }

    public List<Point> check(int[][] board, int a, int b, int type) {
        Queue<int[]> q = new LinkedList<>();
        List<Point> l = new ArrayList<>();
        l.add(new Point(0,0));
        q.offer(new int[] {a,b});

        visited[a][b] = 1;
        while(!q.isEmpty()) {
            int[] e = q.poll();
            int x = e[0];
            int y = e[1];
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(checkBoundary(board.length, nx ,ny) && board[nx][ny] == type && visited[nx][ny] == 0 ) {
                    visited[nx][ny] = 1;
                    q.offer(new int[]{nx,ny});
                    l.add(new Point(nx-a, ny-b));
                }
            }
        }

        Collections.sort(l);

        return l;
    }

    public boolean checkBoundary(int len, int x, int y) {
        if(x<0 || x>=len || y<0 || y>=len) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        P84021 p84021 = new P84021();
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
        System.out.println(p84021.solution(game_board,table));
    }

    class Point implements Comparable<Point>{

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }

            return this.x - o.x;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    }


}
