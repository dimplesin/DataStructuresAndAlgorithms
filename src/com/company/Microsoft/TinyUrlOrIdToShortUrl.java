package com.company.Microsoft;

/**
 * Created by v-dsindhi on 8/10/15.
 */
public class TinyUrlOrIdToShortUrl {

    // Function to generate a short url from intger ID
    static String idToShortURL(int n)
    {
        // Map to store 62 possible characters
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuilder shorturl = null;

        // Convert given integer id to a base 62 number
        while (n>=0)
        {
            // use above map to store actual character
            // in short url
            shorturl.append(map[n % 62]);
            n = n/62;
        }

        // Reverse shortURL to complete base conversion
        shorturl.reverse();

        return shorturl.toString();
    }

// Function to get integer ID back from a short url
    static int shortURLtoID(char shortURL[])
    {
        int id = 0; // initialize result

        // A simple base conversion logic
        for (int i=0; i < shortURL.length; i++)
        {
            if ('a' <= shortURL[i] && shortURL[i] <= 'z')
                id = id*62 + shortURL[i] - 'a';
            if ('A' <= shortURL[i] && shortURL[i] <= 'Z')
                id = id*62 + shortURL[i] - 'A' + 26;
            if ('0' <= shortURL[i] && shortURL[i] <= '9')
                id = id*62 + shortURL[i] - '0' + 52;
        }
        return id;
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        int n = 12345;
        String shorturl = idToShortURL(n);
        System.out.println("Generated short url is " +shorturl);
        System.out.println("Id from url is " + shortURLtoID(shorturl.toCharArray()));

    }
    /*Run on IDE
    Output:

    Generated short url is dnh
    Id from url is 12345*/
}
