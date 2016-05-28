package Zalando;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by v-dsindhi on 2/4/16.
 */
public class PrimeNumbersUptoN {

    public static void main(String[] args) throws IOException {
       // printPrimes(100);

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,r,i,j;
        System.out.print("Enter the n value");
        n=Integer.parseInt(br.readLine());
        for(i=1;i<=n;i++)
        {
            for(j=2;j<=i;j++)
            {
                r=i%j;
                if(r==0)
                    break;
            }
            if(i==j)
                System.out.println("Prime Number"+i);
        }
    }

    public static void printPrimes(int range) {
        for (int iCounter=1; iCounter<=range; ++iCounter) {
            if (iCounter <= 1) continue;
            if (iCounter == 2 || iCounter == 3) {
                System.out.println(iCounter);
                continue;
            }
            if (iCounter%2 == 0) continue;
            int iCounterSqrt = (int) Math.sqrt(iCounter);

            boolean bPrime = true;
            for (int iDenom=3; iDenom <= iCounterSqrt; iDenom += 2) {
                if (iCounter % iDenom == 0)
                    bPrime = false;
            }

            if (bPrime) {
                System.out.println(iCounter);
            }
        }
    }

    class PrimeNumber
    {
        public void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter a number: ");
            int num = scanner.nextInt();

            if ( num < 2 ) {
                System.out.println("\n There are no Prime Numbers available");
                System.exit(0);
            }
            System.out.printf("\n The Prime Numbers from 1 to %d are: \n 2", num);
            PrimeNumber primeNum = new PrimeNumber();

            for (int i = 3; i <= num; i++) {
                if ( primeNum.isPrime(i) ) {
                    System.out.print(", " + i);
                }
            }
        }

        // Method to check whether the number is prime or not
        public boolean isPrime(int num) {
            if ( num < 2 ) return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if ( num % i == 0 ) {
                    return false;
                }
            }
            return true;
        }
    }
}


/*
for (Map.Entry<String, Integer> entry : theMap.entrySet()) {
        entry.getKey(); // gives you the 'Character' key
        entry.getValue(); // gives you the 'Frequencies' value
        }*/
