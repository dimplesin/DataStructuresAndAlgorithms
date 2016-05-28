package geeksforgeeks.Algorithms.Arrays;

import java.util.Scanner;

/**
 * Created by v-dsindhi on 8/3/15.
 */
public class Main {

    /*public int[] reverse3(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        return nums;
    }

    *//*public static void main(String args[]){
        int nums[] = {2, 11, 3};

        int arr[] = maxEnd3(nums);

        System.out.println(arr[0] + "   " + arr[1] + "  "+arr[2]);

    }*//*


    public static int[] maxEnd3(int[] nums) {
        int max = 0;
        int arr[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            arr[i] = max;
        }
        return arr;
    }


    public static void main(String args[]){
        Employee e1 =new Employee();
        e1.setId(10);
        e1.setName("ANB");

        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("DIMPL");

        HashMap map = new HashMap();
        map.put(e1, "d");
        map.put(e2, "e");

        //e1.setId(20);
        System.out.println(map.get(e1));
    }*/
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int lengthOfArray = sc.nextInt();
        int array[] = new int[lengthOfArray];
        int sum = 0;
        for(int i=0;i<lengthOfArray;i++){
            array[i] = sc.nextInt();
        }
        for(int j=0;j<array.length;j++){
            sum += factorialSum(array[j]);
        }
        System.out.println(sum);
    }

    public static int factorialSum(int num){
        long result = 1;
        int count = 0;
        if(num == 0) {
            return 1;
        }
        else {
            for(int i = 2; i <= num; i++) {
                result *= i;
                count++;
            }
            return count;
        }
    }

}
