package programmers.kakao2020blind;

public class P60062 {
    static int[][] weakCases;
    static int num;
    static int weak_len;
    static boolean[] visited;
    static int answer;
    public static int solution(int n, int[] weak, int[] dist) {
        num = n;
        answer = dist.length;
        weak_len = weak.length;
        weakCases = new int[weak.length][weak.length];
        visited = new boolean[dist.length];

        makeWeakCases(weak);
        makeDistCases(dist, 0, new int[dist.length]);

        if(answer == dist.length) {
            return -1;
        }
        return answer;
    }

    private static void makeWeakCases(int[] weak) {
        for(int i=0; i<weak_len; i++) {
            int start = weak[i];
            for(int j=0; j<weak_len; j++) {
                int w = weak[(j+i) % weak_len];
                weakCases[i][j] = w < start ? w+num : w;
            }
        }
        for(int i=0; i<weak_len; i++) {
            for(int j=0; j<weak_len; j++) {
                System.out.print(weakCases[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void makeDistCases(int[] dist, int cnt, int[] distCase) {
        if(cnt==dist.length) {
            for(int[] weakCase: weakCases) {
                check(weakCase, distCase);
            }
            return;
        }

        for(int i=0; i<dist.length; i++) {
            if(!visited[i]){
                visited[i]=true;
                distCase[cnt] = dist[i];
                makeDistCases(dist, cnt+1, distCase);
                distCase[cnt] = 0;
                visited[i]=false;
            }
        }
    }

    private static void check(int[] weakCase, int[] distCase) {
        int cnt = 0;
        int idx = 0;
        while(idx<weak_len && cnt<distCase.length) {
            int start = weakCase[idx];
            while(idx<weak_len && start + distCase[cnt]>=weakCase[idx]) {
                idx++;
            }
            cnt++;
        }
        if(idx==weak_len) {
            answer = Math.min(answer, cnt);
        }
    }

    public static void main(String[] args) {
        int n=200;
        int[] weak = new int[]{100,0};
        int[] dist = new int[]{1,1};
        System.out.println(solution(n,weak, dist));
    }
}
