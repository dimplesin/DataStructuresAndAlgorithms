package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 8/4/15.
 */
public class CandidateCode
{
    public static int maximumPositiveFrequency(int[] input1,int input2)
    {
        //Write code here
        int maximumPositiveFrequency[] = new int[2];
        boolean flag = true;
        int i=0;int k,l;
        for(;i<input2;i++) {
            l = i;
            k = l;
            int maxFrequencyCurrent = 0;
            while (((l + 1) < input2) && input1[l + 1] > input1[l]) {
                maxFrequencyCurrent = (input1[l + 1] - input1[k]);
                l++;
                i++;
            }
            if (flag){
                maximumPositiveFrequency[0] = maxFrequencyCurrent;
                flag = false;
            }
            if(!flag){
                maximumPositiveFrequency[1] = maxFrequencyCurrent;
            }
        }
        return maximumPositiveFrequency[0]+maximumPositiveFrequency[1];
    }
}