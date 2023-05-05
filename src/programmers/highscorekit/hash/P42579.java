package programmers.highscorekit.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P42579 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresPlay = new HashMap<>();
        Map<String, List<Integer>> genresSong = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            genresPlay.put(genres[i], genresPlay.getOrDefault(genres[i],0) + plays[i]);

            if(!genresSong.keySet().contains(genres[i])){
                genresSong.put(genres[i], new ArrayList<>());
            }

            genresSong.get(genres[i]).add(i);
        }
        List<String> sortedGenres = new ArrayList<>(genresPlay.keySet());
        sortedGenres.sort((o1, o2) -> genresPlay.get(o2) - genresPlay.get(o1));

        List<Integer> res = new ArrayList<>();
        for(String genre: sortedGenres) {
            List<Integer> songs = genresSong.get(genre);
            songs.sort((o1,o2) -> plays[o2] - plays[o1]);
            int cnt=0;
            for(int song: songs){
                if(cnt==2){
                    break;
                }
                cnt++;
                res.add(song);
            }
        }
        int[] answer = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            answer[i] = res.get(i);
        }

        return answer;
    }
}
