package basiccode;

import java.util.ArrayList;

//순열, 중복순열, 조합, 중복조합
public class PermutationCombination {

    static int[] arr = {1,2,3,4};
    static int n = 4, r = 2;
    static boolean[] visited = new boolean[n];

    //순열
    public static void permutation(ArrayList<Integer> list) {
        if(list.size() == r) {
            System.out.println(list);
            return;
        }
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                list.add(arr[i]);
                visited[i] = true;
                permutation(list);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }

    //중복순열
    public static void duplicatePermutation(ArrayList<Integer> list) {
        if(list.size() == r) {
            System.out.println(list);
            return;
        }
        for(int i=0; i<n; i++) {
            list.add(arr[i]);
            duplicatePermutation(list);
            list.remove(list.size()-1);
        }
    }

    //조합
    public static void combination(int idx, int cnt, ArrayList<Integer> list) {
        if(cnt == r) {
            System.out.println(list);
            return;
        }
        for(int i=idx; i<n; i++) {
            list.add(arr[i]);
            combination(i+1, cnt+1, list);
            list.remove(cnt);
        }
    }

    //중복조합
    public static void duplicateCombination(int idx, int cnt, ArrayList<Integer> list) {
        if(cnt == r) {
            System.out.println(list);
            return;
        }
        for(int i=idx; i<n; i++) {
            list.add(arr[i]);
            duplicateCombination(i, cnt+1, list);
            list.remove(cnt);
        }
    }

    public static void main(String[] args) {
        System.out.println("순열");
        permutation(new ArrayList<>());
        System.out.println("-------------------");

        System.out.println("중복순열");
        duplicatePermutation(new ArrayList<>());
        System.out.println("-------------------");

        System.out.println("조합");
        combination(0, 0, new ArrayList<>());
        System.out.println("-------------------");

        System.out.println("중복 조합");
        duplicateCombination(0, 0, new ArrayList<>());
        System.out.println("-------------------");
    }

}
