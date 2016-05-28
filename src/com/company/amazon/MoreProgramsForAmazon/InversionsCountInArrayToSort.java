package com.company.amazon.MoreProgramsForAmazon;

public final class InversionsCountInArrayToSort {

    private InversionsCountInArrayToSort() {}

    /**
     * Returns the number of inversions in the input array
     * 
     * @param a the input array
     * @return  the number of inversions.
     */
    public static int countInversions(int[] a) {
        return mergeSort(a, 0, a.length);
    }

    private static int mergeSort (int[] a, int low, int high) {
        if (low == high - 1) return 0;

        int mid = (low + high)/2;

        return mergeSort (a, low, mid) + mergeSort (a, mid, high) + merge (a, low, mid, high);
    }

    private static int merge (int[] a, int low, int mid, int high) {
        int count = 0;
        int[] temp = new int[a.length];

       for (int i = low, lb = low, hb = mid; i < high; i++) {

            if (hb >= high || lb < mid && a[lb] <= a[hb]) {
                temp[i]  = a[lb++];
            } else {
                count = count + (mid - lb); 
                temp[i]  = a[hb++];
            } 
       }

       System.arraycopy(temp, low, a, low, high - low);

       return count;
    }
    
    int getInvCount(int arr[], int n)
    {
      int inv_count = 0;
      int i, j;
     
      for(i = 0; i < n - 1; i++)
        for(j = i+1; j < n; j++)
          if(arr[i] > arr[j])
            inv_count++;
     
      return inv_count;
    }
     
    /* Driver progra to test above functions */
   // int main(int argv, char args)
   // {
      int arr[] = {1, 20, 6, 4, 5};
      //printf(" Number of inversions are %d \n", getInvCount(arr, 5));
      //getchar();
      //return 0;
  //  }
}
