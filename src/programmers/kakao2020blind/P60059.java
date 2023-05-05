package programmers.kakao2020blind;

public class P60059 {
    int m;
    int n;
    public boolean solution(int[][] key, int[][] lock) {
        m = key.length;
        n = lock.length;
        int[][] extended = new int[2*m+n][2*m+n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                extended[i+m][j+m] = lock[i][j];
            }
        }
        int[][] rotated = key;
        for(int k=0; k<4; k++) {
            for(int i=1; i<m+n; i++) {
                for(int j=1; j<m+n; j++) {
                    attached(i, j, rotated, extended);
                    if(check(extended)){
                        return true;
                    }
                    detached(i, j, rotated, extended);
                }
            }
            rotated = rotate(rotated);
        }
        return false;
    }

    public int[][] rotate(int[][] key){
        int[][] move = new int[key.length][key.length];
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++) {
                move[i][j] = key[key.length-1-j][i];
            }
        }
        return move;
    }

    public void attached(int x, int y, int[][] key, int[][] extended){
        for(int i=0; i<m; i++) {
            for(int j=0; j<m; j++) {
                extended[i+x][j+y] += key[i][j];
            }
        }
    }

    public void detached(int x, int y, int[][] key, int[][] extended){
        for(int i=0; i<m; i++) {
            for(int j=0; j<m; j++) {
                extended[i+x][j+y] -= key[i][j];
            }
        }
    }

    public boolean check(int[][] extended){
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(extended[i+m][j+m] != 1){
                    return false;
                }
            }
        }
        return true;
    }
}
