package com.company.amazon.BookKarumanchi.TicTackToe;

/**
 * Created by v-dsindhi on 4/10/15.
 */
public abstract class Player {

    protected int[] attempt = new int[2];
    protected int player;


    public Player(int player){
        this.player = player;
    }

    public abstract void play(Board board);

    public abstract void Try(Board board);

    public boolean checkTry(int[] attempt, Board board){
        if(board.getPosition(attempt) == 0)
            return true;
        else
            return false;

    }

}