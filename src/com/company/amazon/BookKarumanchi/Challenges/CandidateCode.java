package com.company.amazon.BookKarumanchi.Challenges;

/**
 * Created by v-dsindhi on 3/23/15.
 */

public class CandidateCode
{
    public static void main (String[] args) throws Exception {

        int count =1;
        int number = 0;
            if(1000000 >0){
                for(int i=0;i<1000000;i++){
                    for(int j=2;j<i;j++){
                        if(i%j == 0){
                            //System.out.println(i);
                            number = 0;
                            break;
                        }else{
                            number = 1;
                        }
                    }
                    if(number == 1){
                        count++;
                    }
                }
            }
        System.out.println(count);
        }

    }



        /*Scanner s = new Scanner(System.in);
        int start = s.nextInt()>2?s.nextInt():2;
        int end = 0;
        if(!s.hasNextInt()){
            end = start;
        }else{
            end = s.nextInt();
        }

        for(int i=start; i <= end; i++){
            boolean isPrime = true;
            for(int j=2; j < i ;  j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                System.out.print(i +"\n");
        }
    }


    void printbreak() throws IOException {

     java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
     String s;
     while (!(s=r.readLine()).startsWith("42")) System.out.println(s);
   }*/


