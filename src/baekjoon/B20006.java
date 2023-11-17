package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class B20006 {
	static List<List<Player>> rooms = new ArrayList<>();
	static List<Integer> startLevel = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int roomNumbers = 0;

		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int level = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Player player = new Player(level, name);
			boolean check = false;
			for(int j=0; j<roomNumbers; j++) {
				if(rooms.get(j).size() < m && checkLevel(player.level, startLevel.get(j))) {
					rooms.get(j).add(player);
					check = true;
					break;
				}
			}
			if(check) {
				continue;
			}
			rooms.add(new ArrayList<>());
			rooms.get(roomNumbers).add(player);
			startLevel.add(player.level);
			roomNumbers++;
		}

		StringBuilder sb = new StringBuilder();
		for(List<Player> room: rooms) {
			Collections.sort(room, Comparator.comparing(o -> o.name));
			int size = room.size();
			if(size == m) {
				sb.append("Started!\n");
			} else {
				sb.append("Waiting!\n");
			}
			for(int i=0; i<size; i++) {
				Player tmp = room.get(i);
				sb.append(tmp.level).append(" ").append(tmp.name).append("\n");
			}
		}
		System.out.println(sb);
	}

	static boolean checkLevel(int player, int start) {
		return start - 10 <= player && player <= start + 10;
	}

	static class Player {
		int level;
		String name;
		Player(int level, String name) {
			this.level = level;
			this.name = name;
		}
	}
}
