package com.company.flipkart.SnakeLadderGame;

/**
 * Created by v-dsindhi on 7/8/15.
 */
public final class LastSquareRole extends SquareRole {

             public LastSquareRole ( Square s ) {
         super ( s );
         }

             @Override
     public boolean isLastSquare () {
         return true ;
         }
     }
