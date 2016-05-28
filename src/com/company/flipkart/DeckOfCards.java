package com.company.flipkart;

/**
 * Created by v-dsindhi on 1/31/16.
 */
import java.util.Random;

public class DeckOfCards {
    /*Collections of cards*/
    private Card cards[];

    /*Remaining number of cards in the deck*/
    private int currentCount;

    /*Size of the deck which can handle cards*/
    private int size;

    private Suit suits[];

    private Value values[];

    public DeckOfCards(){
        size=52;
        currentCount=0;
        cards = new Card[size];
        suits=Suit.values();
        values=Value.values();

        for(int i =0 ; i<suits.length;i++){
            for(int j =0 ; j<values.length;j++){
                cards[currentCount++] = new Card(suits[i],values[j]);
            }

        }
    }

  /*This is to shuffle the cards in the deck with the remaining cards.
  Variable numberOftime represents the number of time need to shuffle the cards in deck*/

    public void shuffle(int numberOftime){

        Random rand= new Random();


        for(int i=0;i<numberOftime;i++){
            int m=rand.nextInt(currentCount);
            int n=rand.nextInt(currentCount);

            Card temp=cards[m];
            cards[m]=cards[n];
            cards[n]=temp;
        }

    }

    /*This function is to deal the cards whatever is on top of the deck.*/
    public void deal(){
        System.out.println(cards[--currentCount]);
    }

    /*This is to represents the String representation of the current cards inthe deck.*/
    public String toString(){

        StringBuilder sb=new StringBuilder();

        for(int i=0;i < currentCount;i++){
            sb.append(cards[i]);
            sb.append(" ");
        }

        return sb.toString();
    }

    /*  Sorting the cards based on the suit and then numbers.
        This sorting is using Bucket Sort to sort the cards runtime= O(n) space=O(n);*/
    public void sort(){

        Card bucketCards[][]= new Card[suits.length][values.length];

        for(int i=0;i<currentCount;i++){
            bucketCards[cards[i].getSuit().ordinal()][cards[i].getValue().ordinal()]=cards[i];
        }

        int pointer=0;

        for(int i=0;i<suits.length;i++){
            for(int j=0;j<values.length;j++){
                if(bucketCards[i][j]!=null)
                    cards[pointer++]=bucketCards[i][j];
            }
        }


    }

    /*This will reset the deck. i.e it will put back all the cards in the deck if it has been dealt.*/
    public void resetdesk(){
        currentCount=52;
    }

    /*Printing the stack of cards in format*/
    public void printStack(){
        int cardPointer=0;
        for(int i=0;i<suits.length;i++){

            for(int j=0;j<values.length;j++){
                System.out.print(cards[cardPointer++]+" ");
            }

            System.out.println("\n");
        }

    }

    /*Get size of the deck*/
    public int getSize() {
        return size;
    }

    /*This represents the suit of the card*/
    private enum Suit{
        CLUB,DIAMOND,SPADE,HEART
    }

    /* This represents the number of the card*/
    private enum Value{
        ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING
    }

    /* This class represents the card with specific suit and value.
     * Cannot change the value once instansiated */
    private class Card{

        private final Suit suit;

        private final Value value;

        public Card(Suit suit, Value value){
            this.suit=suit;
            this.value=value;
        }


        public Suit getSuit() {
            return suit;
        }

        public Value getValue() {
            return value;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return suit+"-"+value;
        }
    }
}

class Test {

    /**
     * @param args
     *
     */
    public static void main(String[] args) {

        int n=10; // Number of cards to deal for test
        DeckOfCards deck=new DeckOfCards();
        deck.printStack();
        deck.shuffle(10);

        System.out.println("----------------------------  After shuffle -----------------------------------------------\n");
        deck.shuffle(30);
        deck.printStack();

        System.out.println("----------------------------  Dealing 10 cards  -----------------------------------------------\n");
        for(int i=0;i<n;i++){
            deck.deal();
        }

        System.out.println("--------------------------    After Sort ---------------------------------------------\n");
        deck.sort();
        deck.printStack();

        System.out.println("----------------------------  Dealing 10 cards  -----------------------------------------------\n");
        for(int i=0;i<n;i++){
            deck.deal();
        }

        System.out.println("----------------------------  Putting back all cards  -----------------------------------------------\n");
        deck.resetdesk();

        System.out.println("--------------------------    After Sort ---------------------------------------------\n");
        deck.sort();
        deck.printStack();

        System.out.println("----------------------------  Dealing 10 cards  -----------------------------------------------\n");
        for(int i=0;i<n;i++){
            deck.deal();
        }
    }
}class Deck {
    public static void main(String[] args) {
        String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        // avoid hardwired constants
        int SUITS = suit.length;
        int RANKS = rank.length;
        int N = SUITS * RANKS;

        // initialize deck
        String[] deck = new String[N];
        for (int i = 0; i < RANKS; i++) {
            for (int j = 0; j < SUITS; j++) {
                deck[SUITS*i + j] = rank[i] + " of " + suit[j];
            }
        }

        // shuffle
        for (int i = 0; i < N; i++) {
            int r = i + (int) (Math.random() * (N-i));
            String t = deck[r];
            deck[r] = deck[i];
            deck[i] = t;
        }

        // print shuffled deck
        for (int i = 0; i < N; i++) {
            System.out.println(deck[i]);
        }
    }

}
