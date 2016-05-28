package com.company.flipkart.SnakeLadderGame;

/**
 * Created by v-dsindhi on 7/8/15.
 */
public final class SnakeRole extends SquareRole {
     private int transport ;

             public SnakeRole ( Square s , int t ) {
         super ( s );
         assert t <0 : "A snake shift must be negative " ;
         transport = t ;

         }

             @Override
     public Square landHereOrGoHome () {
         System . out . println (" snake from " + ( square . getPosition ()+1)
                 + " to " + ( destination (). getPosition ()+1));
         return destination (). landHereOrGoHome ();
         }

             private Square destination () {
         return square . findRelativeSquare ( transport );
         }
     }
