package Zalando;

/**
 * Created by v-dsindhi on 2/4/16.
 */
class PairSum
{
    private static final int MAX = 100000; // Max size of Hashmap

    static void printpairs(int arr[],int sum)
    {
        // Declares and initializes the whole array as false
        boolean[] binmap = new boolean[MAX];

        for (int i=0; i<arr.length; ++i)
        {
            int temp = sum-arr[i];

            // checking for condition
            if (temp>=0 && binmap[temp])
            {
                System.out.println("Pair with given sum " +
                        sum + " is (" + arr[i] +
                        ", "+temp+")");
            }
            binmap[arr[i]] = true;
        }
    }//O(n)

   /* public static void printSumPairs(int []input, int k){
        Map<Integer, Integer> pairs = new HashMap<>();

        for(int i=0;i<input.length;i++){

            if(pairs.containsKey(input[i]))
                System.out.println(input[i] +", "+ pairs.get(input[i]));
            else
                pairs.put(k-input[i], input[i]);
        }
        *//*Some notes about the solution :

        We iterate only once through the array --> O(n) time
        Insertion and lookup time in Hash is O(1).
                Overall time is O(n), although it uses extra space in terms of hash.*//*
    }*/

    // Main to test the above function
    public static void main (String[] args)
    {
        int A[] = {12, 4, 45, 6, 10, 8};
        int n = 16;
        printpairs(A,  n);
    }

   /* public static boolean pairs(int[] array, int sum){
        Arrays.sort(array);
        int start = 0;
        int end = array.length-1;
        while (start != end) {
            if (sum == array[start] + array[end]) {
                // found
                return true;
            } else if (sum > array[start] + array[end]) {
                start++;
            } else {
                end--;
            }
        }
// not found
        return false;
    }*/
}

