package com.company.flipkart;

/**
 * Created by v-dsindhi on 7/11/15.
 */
public class NextPalindromeNumberOfAnumber {
    int NextPalindromeNum( int num )
    {
        int start, end;
        int startRem, endRem;
        int flag=0;

        start = end = 1;
        while( start < num )
        {
            start *= 10;
        }
        start /= 10;

        if( checkPalindrome(num))
        {
            while ( (start != end ) && (start != 10 * end))
            {
                start /= 10;
                end *= 10;
            }
            if( start != end )
            {
                num = num + ((num / end) % 10 ) * end ;
            }
            else
            {
                startRem = ( num / start ) % 10;
                endRem  = ( num / end ) % 10;

                if( startRem == endRem )
                {
                    num = num + (startRem + 1)*start + (endRem + 1)*end ;
                }

            }
        }// end of if()
        else
        {
            while( ( start != end ) && ( start != 10 * end ))
            {
                flag = 1;
                startRem = (num/start ) % 10;
                endRem = (num/end ) %10;

                if( startRem > endRem )
                {
                    num = num + (startRem - endRem ) * end;
                }
                else
                {
                    num = num + ((startRem - endRem) % 10 ) * end;
                }
                start /= 10;
                end *= 10;
            } // end of while
            if( start!= 10 * end )
            {
                startRem = (num/start) % 10;
                endRem = (num/end) % 10;
                if( startRem > endRem )
                {
                    num = num + (startRem - endRem ) * end;
                }
                else if ( startRem < endRem )
                {
                    num = num + ((startRem - endRem) % 10 + 1 ) * end;
                }
                else if( flag == 0 )
                {
                    num = num  + startRem * start + endRem*end ;
                }
            }
        }// end of else

        return num;
    }

    private boolean checkPalindrome(int num) {
        return true;
    }
    // If you find any bug , please let me know .

   // Time Complexity O(n) , here n is number of digits in number .
}
