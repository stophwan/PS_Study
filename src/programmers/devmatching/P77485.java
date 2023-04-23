package programmers.devmatching;

public class P77485 {
    int[][] graph;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        graph = new int[rows][columns];
        int s = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                graph[i][j]=s;
                s++;
            }
        }
        for(int i=0; i<queries.length; i++){
            answer[i]=rotate(queries[i], rows, columns);
        }

        return answer;
    }

    public int rotate(int[] querie, int rows, int columns){
        int start_x = querie[0]-1;
        int start_y = querie[1]-1;
        int end_x = querie[2]-1;
        int end_y = querie[3]-1;
        int min = rows*columns+1;
        int tmp = graph[start_x][start_y];
        for(int i=start_x; i<end_x; i++){
            min = Math.min(graph[i][start_y], min);
            graph[i][start_y] = graph[i+1][start_y];
        }
        for(int i=start_y; i<end_y; i++) {
            min = Math.min(graph[end_x][i], min);
            graph[end_x][i] = graph[end_x][i+1];
        }
        for(int i=end_x; i>start_x; i--) {
            min = Math.min(graph[i][end_y], min);
            graph[i][end_y] = graph[i-1][end_y];

        }
        for(int i=end_y; i>start_y; i--) {
            min = Math.min(graph[start_x][i], min);
            graph[start_x][i] = graph[start_x][i-1];
        }
        graph[start_x][start_y+1] = tmp;

        return min;
    }
}
