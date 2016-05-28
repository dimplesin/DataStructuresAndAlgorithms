package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/25/15.
 */
public class SortReversingArray {

        public static void main(String[] a) {
            SortReversingArray t = new SortReversingArray();
            int[] arr = { 3,2,1,4,7,2,1,-6,14,-1 };
            for(int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + "|");
            t.sort(arr);
            System.out.println("");
            for(int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + "|");
        }

        public void sort(int[] arr){
            for(int mi = arr.length - 1; mi > 0; mi--) {
                int ci = 0;
                int cv = arr[0];
                for(int i = 0; i <= mi; i++) {
                    if(arr[i] > cv) {
                        cv = arr[i];
                        ci = i;
                    }
                }
                if(ci != mi) {
                    rev(arr, ci);
                    rev(arr, mi);
                }
            }
        }

        public void rev(int arr[], int f){
            int s = 0;
            if(arr.length == 0)
                return;
            while(s < f){
                swap(arr, s, f);
                s++;
                f--;
            }
        }

        public void swap(int arr[], int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
}
