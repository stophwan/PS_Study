package programmers.highscorekit.greedy;

// 그리디, 조이스틱, **
// 경우를 나누는 것이 매우 중요
public class P42860 {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1; //오른쪽으로 쭉 가기
        int index; //A가 끝나는 지점의 Index
        for(int i=0; i<name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            index = i+1;
            while(index < name.length() && name.charAt(index) == 'A') {
                index++;
            }
            move = Math.min(move, i*2 + name.length()-index); //오른쪽으로 갔다 왼쪽으로 가기(오른쪽이 0일경우 왼쪽으로만 가는것포함)
            move = Math.min(move, i + (name.length()-index)*2); //왼쪽으로 갔다 오른쪽으로 가기
        }

        return answer + move;
    }

}
