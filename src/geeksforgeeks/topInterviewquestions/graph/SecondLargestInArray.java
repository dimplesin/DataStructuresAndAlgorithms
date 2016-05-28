package geeksforgeeks.topInterviewquestions.graph;

/**
 * Created by v-dsindhi on 12/16/15.
 */
public class SecondLargestInArray {

    public static void main(String args[]){
        int a[] = {1,2,6,7,55,43,2,1,22,3},i,max1,max2;
        max1=a[0];
        max2=a[1];

        for(i=1;i<a.length;i++)
        {
            if(a[i]>max1)
            {
                max2=max1;
                max1=a[i];
            }
            else if(a[i]>max2 &&a[i]!=max1)
                max2=a[i];
            else if(max1==max2)
                max2=a[i];
        }

        System.out.println(max1+"    "+max2);
    }
}
