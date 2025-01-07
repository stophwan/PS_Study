package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//틀렸던 문제. 디버깅을 통해 해결
//겹치는 상어들을 3차원으로 해결했지만, 큐에 담아놓고 맵을 초기화한 후 큐에서 꺼내면서 다시 세팅을 하는 것도 방법
//https://minhamina.tistory.com/65 해당 블로그에 방법이 설명
//가장 어려웠던 부분은 많이 움직일 수 있는 것을 왕복횟수의 나머지로 줄이느냐가 포인트
public class BJ17143_낚시왕 {

	static Shark[][][] graph;
	static int r;
	static int c;
	static int[] dx = new int[]{-1, 1, 0, 0};
	static int[] dy = new int[]{0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new Shark[r+1][c+1][c+1];

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			graph[sr][sc][1] = new Shark(s, d-1 , z);
		}

		int sum = 0;

		for(int i=1; i<=c; i++) {
			sum += catchFish(i);
			if(i==c) continue;
			next(i);
		}
		System.out.println(sum);
	}

	public static int catchFish(int now) {
		int res = 0;
		for(int i=1; i<=r; i++) {
			if(graph[i][now][now] != null) {
				res = graph[i][now][now].z;
				graph[i][now][now] = null;
				break;
			}
		}
		return res;
	}

	public static void next(int now) {
		for(int i=1; i<=r; i++) {
			for(int j=1; j<=c; j++) {
				if(graph[i][j][now] != null) {
					Shark shark = graph[i][j][now];
					int ns = calculateSpeed(shark.s, shark.d);
					int nx = i;
					int ny = j;
					for(int s=0; s<ns; s++) {
						nx += dx[shark.d];
						ny += dy[shark.d];
						if(checkRange(nx, ny)) {
							nx -= 2 * dx[shark.d];
							ny -= 2 * dy[shark.d];
							if(shark.d == 0 || shark.d == 1) shark.d = 1 - shark.d;
							if(shark.d == 2 || shark.d == 3) shark.d = 5 - shark.d;
						}
					}
					if(graph[nx][ny][now+1] == null || (graph[nx][ny][now+1] != null && shark.z >= graph[nx][ny][now+1].z)) {
						graph[nx][ny][now+1] = shark;
					}
				}
			}
		}
	}

	static boolean checkRange(int x, int y) {
		return x<1 || x>r || y<1 || y>c;
	}

	static int calculateSpeed(int speed, int d) {
		if(d==0 || d==1) return speed%((r-1)*2);
		return speed%((c-1)*2);
	}

	static class Shark {
		int s; //속력
		int d; //이동방향
		int z; //크기

		Shark(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
