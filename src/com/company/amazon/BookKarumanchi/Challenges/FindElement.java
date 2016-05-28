package com.company.amazon.BookKarumanchi.Challenges;

/**
 * Created by v-dsindhi on 6/18/15.
 */
public class FindElement {

        public int findValue(int[] input, int v) throws Exception
        {
            if(input==null||input.length==0)
            {
                throw new Exception("The input array cannot be empty or null");
            }
            int searchResult=0;//searchValue(input, (v,0+v-1)/2,0,v-1);
            return searchResult;
        }

        private int searchValue(int[] input, int idx,int value,int start, int end)
        {
            if(idx<start||idx>end)
            {
                return -1;
            }
            if(input[idx]==value)
            {
                return idx;
            }
            int diff=Math.abs(input[idx]-value);
            int leftSearchResult=searchValue(input,idx-diff,value,start,idx-1);
            if(leftSearchResult!=-1)
            {
                return leftSearchResult;
            }
            return (searchValue(input,idx+diff,value));

        }

    private int searchValue(int[] ints, int i, int value) {
        return 0;
    }
}
