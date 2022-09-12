public class Main {
    public static void main(String[] args){
        int[] arr = new int[]{ 5, 6, 8, 3, 1 };

        linearSearch(arr, 8);
        linearSearch(arr, 10);
    }

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
