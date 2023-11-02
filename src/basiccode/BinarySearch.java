package basiccode;

public class BinarySearch {

    public static int lowerBound(int[] arr, int start, int end, int target) {
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = (low + high)/2;
            if(target <= arr[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int upperBound(int[] arr, int start, int end, int target) {
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = (low + high)/2;
            if(target < arr[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return high;
    }


    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5};
        int end = arr.length;
        System.out.println("lowerBound is " + lowerBound(arr, 0, end, 3));
        System.out.println("upperBound is " + upperBound(arr, 0, end, 3));
    }
}
