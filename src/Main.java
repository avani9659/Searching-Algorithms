public class Main {
    public static void main(String[] args){
        int[] arr = new int[]{ 5, 6, 8, 3, 1 };

        linearSearch(arr, 8);
        linearSearch(arr, 10);
    }

    /**
     * Linear search algorithm. Here the element is searched by going through the array elements one by one.
     * If the element is found, loop is terminated.
     * The time complexity for this algorithm is O(N). (worst case scenario)
     * Best case here would be - if the element is found in the start of array.
     * Worst case here would be - if the element is at the end of the array or the element is not present in array.
     * @param arr The given array
     * @param element The element to find
     */
    public static void linearSearch(int[] arr, int element){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == element){
                System.out.println("Element present at index " + arr[i]);
                return;
            }
        }

        System.out.println("Element not found");
    }
}
