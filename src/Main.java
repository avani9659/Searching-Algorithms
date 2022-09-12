public class Main {
    public static void main(String[] args){
        int[] arr = new int[]{ 5, 6, 8, 3, 1 };

        linearSearch(arr, 8);
        linearSearch(arr, 10);

        int[] sortedArray = new int[] { 2, 7, 10, 21, 43, 55, 78, 81, 99, 122, 231};

        /**
         * Binary search makes use of Divide and Conquer. Here, you divide your problem statement into smaller problem statements and try to achieve your task.
         * Pre-requisite to use binary search - The given array should be sorted.
         * Time complexity = (log N)
         * 
         * The algorithms given below work if the array is sorted in ascending order.
         * If the array is sorted in descending order, then simply reverse the operations done in 'else if' and 'else' block.
         *
         * To find the middle element, make use of formula - leftIndex + (rightIndex - leftIndex) / 2
         * source: https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
         */
        binarySearchIterativeMethod(sortedArray, 0, sortedArray.length - 1, 7);
        binarySearchIterativeMethod(sortedArray, 0, sortedArray.length - 1, 20);

        binarySearchRecursiveMethod(sortedArray, 0, sortedArray.length - 1, 231);
        binarySearchIterativeMethod(sortedArray, 0, sortedArray.length - 1, 100);
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

    /**
     * Binary search algorithm using iterative method.
     * @param arr The given array
     * @param leftIndex The left index. Initial value will be 0
     * @param rightIndex The right index. Initial value will be array.length - 1
     * @param element The element to search
     */
    public static void binarySearchIterativeMethod(int[] arr, int leftIndex, int rightIndex, int element){
        while (leftIndex <= rightIndex){
            int middleIndex = (leftIndex + rightIndex) / 2; //can also use --> leftIndex + (rightIndex - leftIndex) / 2

            if(arr[middleIndex] == element){
                System.out.println("Element is at index " + middleIndex);
                return;
            }
            /**
             * This means that the element is to right of middle index. Hence, we are dividing the array from middle and updating the left index to (middleIndex + 1).
             * We will now only consider the second half of array to search for our element.
             * (For array sorted in descending order --> rightIndex = middleIndex - 1)
             */
            else if(arr[middleIndex] < element){
                leftIndex = middleIndex + 1;
            }
            /**
             * This means that the element is to left of middle index. Hence, we are dividing the array from middle and updating the right index to (middleIndex - 1).
             * We will now only consider the first half of array to search for out element.
             * (For array sorted in descending order --> leftIndex = middleIndex + 1)
             */
            else{
                rightIndex = middleIndex - 1;
            }
        }

        System.out.println("Element not found");
    }

    /**
     * Binary search algorithm using recursive method.
     * @param arr The given array
     * @param leftIndex The left index. Initial value will be 0
     * @param rightIndex The right index. Initial value will be array.length - 1
     * @param element The element to search
     */
    public static void binarySearchRecursiveMethod(int[] arr, int leftIndex, int rightIndex, int element){
        if(leftIndex > rightIndex){
            System.out.println("Element not found.");
            return;
        }
        int middleIndex = (leftIndex + rightIndex) / 2; //can also use --> leftIndex + (rightIndex - leftIndex) / 2

        if(arr[middleIndex] == element){
            System.out.println("Element is at index " + middleIndex);
        }
        /**
         * This means that the element is to right of middle index. Hence, we are dividing the array from middle and updating the left index to (middleIndex + 1).
         * We will now only consider the second half of array to search for our element.
         * (For array sorted in descending order --> rightIndex = middleIndex - 1)
         */
        else if(arr[middleIndex] < element){
            binarySearchRecursiveMethod(arr, middleIndex + 1, rightIndex, element);
        }
        /**
         * This means that the element is to left of middle index. Hence, we are dividing the array from middle and updating the right index to (middleIndex - 1).
         * We will now only consider the first half of array to search for out element.
         * (For array sorted in descending order --> leftIndex = middleIndex + 1)
         */
        else{
            binarySearchRecursiveMethod(arr, leftIndex, middleIndex - 1, element);
        }
    }
}
