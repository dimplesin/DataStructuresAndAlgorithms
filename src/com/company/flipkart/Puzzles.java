package com.company.flipkart;

/**
 * Created by v-dsindhi on 7/14/15.
 */
public class Puzzles {

    /* Horse Race Puzzle

    The horse race puzzle is a classic interview puzzle asked by many tech companies . The puzzle is like this
Puzzle : There are 25 horses among which you need to find out the fastest 3 horses. You can conduct race among at most 5 horses in a single race to find out their relative speed. At no point you can find out the actual speed of the horse in a race. Find out minimum number of races are required to find the 3 horses.

Scratch your brain a bit before viewing the solution .

Hide Solution

Solution : The answer is 7 .Here’s how :
Divide the horses into group of 5 (A,B,C,D,E) and conduct 5 races to find 5 fastest horses .
Now conduct a race among these to find the fastest horse (Let’s say it’s from group E) .and let’s also assume that fastest horse from group D came 2nd and C came 3rd. Total 6 races done. Now the second fastest horse can be the one who came second in the group E which gave us the fastest horse or the one which came second in 6th race. Similarly the 3rd fastest horse can be
the either fastest horse from group D and C ,or the horses which came 2nd and 3rd in group E or the horse which came second in group D. Conduct a race among these 5 horses and you will get the result in final and 7th race.


Two Eggs puzzles

Two eggs puzzle is a famous puzzle asked by Google. Here’s the puzzle
Puzzle :You are given 2 eggs.And there’s 100 floor building. Eggs can be very hard or very fragile means it may break if dropped from the first floor or may not even break if dropped from 100th floor.Both eggs are identical.You have to find the highest floor from which the egg can be dropped without breaking.What is the minimum number drops you need to make. You are allowed to break 2 eggs in the process.

While I admit that the problem is bit tricky given all these constraints . But try hard before viewing the solution.

Hide Solution

Solution : If we start dropping the egg from 1st floor and try till 100 till the egg doesn’t break .We will require 100 eggs in worst case. Lets try to drop the egg from every 2nd floor .This will require 51 drops in worst case .Here’s how (100/2)=50 , let’s say the egg broke on 100 the floor now drop it from 99th floor it should not break. Similarly for dropping from every 3rd floor gives 35 drops [100/3 +3-1].Let’s say minimum number of steps required when we drops egg from every xth floor. Therefore we get
Ruby

1
2
3
d/dx(100/x+x-1) = 0 (simple differentiation)
=> x^2=100
=> x=10
There fore minimum drops required would be [(100/10)+10-1]=19



Fair Result using unfair coin Puzzle

This is an interesting puzzle .The puzzle is like this :

Puzzle : How can you get a fair coin toss if someone hands you a coin that is weighted to come up heads more often than tails?

Think it once the it’s not very tough .

Hide Solution

Solution : It will require some extra tosses, but you can get a fair result this way:
Always use two throws to determine the answer, a HH or TT throw is discarded.
HT == Heads and TH == Tails

We know that the probability of HT is the same as the probability of TH.

Coins on the table Puzzle

Coins on the table Puzzle also known as The Blind Man and Coins Puzzle . This is a famous puzzle asked in Microsoft Interviews. The puzzle is like this :

Puzzle :You’re in a completely black room. Scattered on the floor are 100 coins – 90 of these are heads up and 10 of these are tails up. You are unable to distinguish which coins are heads or tails by touch or any other method you can think up like by touching etc.How do you separate the 100 coins into 2 piles, so that both piles contain the same number of face up tails?

The solution isn’t very tough try to think .

Hide Solution

Solution : The important thing to note here is that the piles can
 be of different size .Choose any 10 coins to make one pile,
  then turn over all 10 coins in that pile. The number of tails
  in this pile is now equal to the number of tails in the other pile
   of 90 coins. To see this, suppose there were x tails in the 10-coin pile.
    Since there were initially a total of 10 tails, there must be 10-x tails in
    the pile of 90 coins. When you flip over all 10 coins in the smaller pile,
    the x tails in that pile become heads and the remaining coins, which must be 10-x heads,
     become tails. That matches the larger pile.


Bad King and Wine Bottles puzzle

Bad King and Wine Bottles puzzle
This is a very interesting interview puzzle .And requires good thought process to find the solution.Here’s the puzzle.

Puzzle : A bad king has 1000 bottles of very expensive wine. A neighbouring King plots to kill the bad king and sends a servant to
poison the wine. Unfortunately the bad king’s guards catch the servant after he has only poisoned one bottle. Alas, the guards don’t
know which bottle but know that the poison is so strong that even if diluted 1,000,000 times it would still kill the king. Furthermore,
it takes one month to have an effect. The bad king decides he will get some of the prisoners in his vast dungeons to drink the wine.
Being a clever bad king he knows he needs to murder no more than 10 prisoners – believing he can fob off such a low death rate – and
will still be able to drink the rest of the wine at his anniversary party in 5 weeks time. Explain How ?

Hint : 1000 is less than 1024.

Still not able top solve the puzzle see the solution here

Hide Solution

Solution : number the bottles 1 to 1000, and write the number in binary format.
bottle 1 = 0000000001
bottle 250 = 0011111010
bottle 1000 = 1111101000
now take your prisoner’s 1 through 10 and let prisoner 1 take asip from every bottle that has a 1 in its least significant bit.
let prisoner 10 take a sip from every bottle with a 1 in its most significant bit. etc.
prisoner

10 9 8 7 6 5 4 3 2 1
bottle 924:

1 1 1 0 0 1 1 1 0 0
For instance, bottle #924 would be sipped by 10,9,8,5,4 and 3. That way if bottle #924 was the poisoned one, only those prisoners would die. After four weeks, line the prisoners up in their bit order and read each living prisoner as a 0 bit and each dead prisoner as a 1 bit. The number that you get is the bottle of wine that was poisoned.




3 Switches and Light bulb Puzzle

This is a good puzzle not very tough to find solution of.

Puzzle : There are 3 standard on/off switches outside a room. One (and only one) controls a light bulb inside the room . The other two switches do nothing. You can only enter the room once, and cannot touch/change any switches after the door is open (or re-closed, for that matter). Damaging or disassembling the door, walls, or switches is against the rules.You can not see anything inside the room from outside in any way.Within these constraints, can you determine with certainty which switch controls the light bulb?

Hide Solution

Solution : Switch on button 1 then after some time switch it off.And Switch on switch 2.Enter the room , observe the bulb .If it’s on and giving light it means switch 2 is the switch controlling it , if it is off touch it if it’s hot it means when we pressed switch 1 it turned on for that period that’s why it is hot.If it’s cold and off it means switch 3 is the switch controlling it.




Camel and Bananas Puzzle

This a an interesting and classic puzzle asked in many tech interviews. I am confident that you will enjoy solving this puzzle.

Here’s the puzzle

Puzzle :The owner of a banana plantation has a camel. He wants to transport 3000 bananas to a market, which is located after the desert. The distance between his banana plantation and the market is about 1000 kilometer. So he decided to take his camel to carry the bananas. The camel can carry at the maximum of 1000 bananas at a time, and it eats one banana for every kilometer it travels.
Here’s what you have to find – What is the largest number of bananas that can be delivered to the market?

I understand finding the solution to this puzzle requires some thinking . SO think , otherwise there’s no point i solving a puzzle .
Still cann’t solve it .Here you go.

Hide Solution
This solution is calculated programatically. I will highly appreciate if someone can provide mathematical explanation of the points calculated here.

Initially 3000 bananas
1st mile the camel carries 1000 bananas forward and eats 1, it eats 1 banana on the way back.
Again it carries 1000 bananas forward and eats 1, eats 1 going back.
1000 bananas forward and eats 1.
After 1 mile: (1000 – 1 – 1) + (1000 – 1 – 1) + (1000 – 1) = 2995 bananas left. So for every 1 mile camel eats 5 bananas. So the camel has to travel 200 miles, when the number of bananas left will be 3000 – 200*5 = 2000

Now the camel has to make only 2 trips for every 1 mile
1st mile the camel carries 1000 bananas forward and eats 1, it eats 1 banana on the way back.
1000 bananas forward and eats 1.
After 1 mile: (1000 – 1 – 1) + (1000 – 1) = 1997 bananas left. So for every 1 mile camel eats 3 bananas.
So to consume next 1000 bananas, the camel has to travel 1000/3 = 333.33 miles.

Now the camel is left with 1000 bananas at 200 + 333.33 = 533.33 miles mark. Now
The camel has to travel 1000 bananas forward and eat 1 per mile.
The camel still has to travel 1000 – 533.33 = 466.66 miles. So the camel is going to consume another 466.66 bananas.
Therefore the final number of bananas left will be 1000 – 466.66 = 533.33 or 533 (who wants to eat a camel eaten banana anyway



Leonardo’s Leaps (Stair Case Puzzle)

By InterviewGeek | May 13, 20140 Comment
This is a classic interview puzzle asked in many interviews.
Puzzle :Given N step stair, how many number of ways can you climb if you use either 1 or 2 at a time?
For example for a stair case with 3 steps there are total 3 ways to climb it :
Way 1: 1 single step then a double step
Way 2: 1 double step and then a single step
Way 3: 3 single steps

Try to find answer for some simple cases and you will automatically find the answer .
Hint : it’s a special kind of sequence of numbers

Hide Solution

Solution :The problem is ismply calculating nth fibonacci number .
Let’s write a simple function numWays(x)
int numWays(int n){
if(n<=0)return 0;
if(n=1)return 1;
if(n==2)return 2;
else return numWays(n-1)+numWays(n-2);
}



Hourglasses puzzle

By InterviewGeek | April 27, 20140 Comment
This is puzzle asked to candidates in google interviews.The idea is somewhat similar to the burning candle puzzle.
Here’s the Puzzle :

Puzzle :You have two hourglasses. One measured 7 minutes and the other 11 minutes.
How will you measure the 15 minutes using only these two hourglasses? Now here’s the twist you are only allowed to turn the hourglasses a total two times mean you can turn any of the glass two times or both the hourglasses one time each.

The problem is not that complex as it sounds.Try to think at least how to measure 15 minutes without following respecting the last constraint.

Hide Solution

Solution: start both the hourglasses. The 7 minutes will be finished first. Immediately turn it upside down.When the hourglass with 11 minutes is finished (after 11 minutes).the second glass will still have sand for 3 minutes turn it upside down immediately .So now the sand will fall for 15 more minutes.(11+7-3).




100 prisoners and the Light Bulb Puzzle

By InterviewGeek | April 27, 20140 Comment
100 prisoners and the Light Bulb Puzzle

This is a very good interview puzzle.Good in the sense that it requires good amount of thinking if you haven’t already heard this problem.Here’s the Puzzle:

Puzzle : There are 100 prisoners are in solitary cells, unable to see, speak or communicate in any way with each other. There’s a room with one light bulb, the bulb is initially off. No prisoner can see the light bulb from his own cell. Everyday, the warden picks a prisoner at random, and that prisoner goes to the that room. While there, the prisoner can toggle the bulb if he wishes. Also, the prisoner has the option of asserting the claim that all 100 prisoners have been to the living room. If this assertion is false (that is, some prisoners still haven’t been to the living room), all 100 prisoners will be shot for their stupidity. However, if it is indeed true, all prisoners are set free. Thus, the assertion should only be made if the prisoner is 100% certain of its validity.
Before the random picking begins.All the prisoners are allowed to get together to discuss a plan.
Note that each prisoner can be selected any number of times and the process will continue till the assertion is not made.

Question: What plan should they agree on, so that eventually, someone will make a correct assertion ?

Hide Solution

Solution :The prisoners need a way to communicate with each other on who when into the cell. Therefore one person is chosen as the counter.
Every time any prisoner is selected other than counter person , they follow these steps. If they have never turned on the light bulb before and the light bulb is off, they turn it on. If not, they don’t do anything.Now if Counter person is selected and the light bulb is already on, he adds one to his count and turns off the bulb. If the bulb is off, he just sits and do nothing. The day his count reaches 99, he calls the warden and tells him “Every prisoner has been in the special room at least once”.
Easy right?



Prisoner’s and hats interview puzzle

By InterviewGeek | April 27, 20140 Comment
Prisoner’s and hats interview puzzle

This is another interesting interview puzzle asked by many tech companies.

Problem :Suppose there are 4 prisoners named W, X, Y, and Z. Prisoner W is standing on one side of a wall, and prisoners X Y and Z are standing on the other side of the wall. Prisoners X, Y, and Z are all standing in a straight line facing right – so X can see prisoner Y and Z, and Y can see prisoner Z. This is what their arrangement looks like:

W(cann’t see anything) || X(can see both Y&Z) Y(can see z) Z(cann’t see anything)
Where the “||” represents a wall. The wall has no mirrors. So, prisoner W can see the wall and nothing else.

There are 2 white hats and 2 black hats. Each prisoner has a hat on his head. Each prisoner can not see the color of his own hat, and can not remove the hat from his own head. But the prisoners do know that there are 2 white hats and 2 black hats amongst themselves.

The prison guard says that if one of the prisoners can correctly guess the color of his hat then the prisoners will be set free and released.

Question :Figure out which prisoner would know the color of his own hat?

Note that the prisoners are not allowed to signal to each other, nor speak to each other to give each other hints. But, they can all hear each other if one of them tries to answer the question. Also, you can assume that every prisoner thinks logically and knows that the other prisoners think logically as well.

The solution is not very hard to guess.Just try to think logically.Think what each prisoner is thinking in this situation.

Hide Solution

Clearly prisoners W and Z can not immediately know anything since neither of those prisoners can see any of the other prisoners. So, let’s instead focus on prisoners X and Y.
Suppose we have the following scenario with the arrangement of different hat colors:

W(B) || X(B) Y(W) Z(W)

In the scenario above, prisoner X will clearly see that Y and Z both have white hats, and logically deduce that he must have a black hat since there are 2 white hats and 2 black hats all together – and he would be correct. Very simple! And this simple logic would also apply to this scenario as well:

W(W) || X(W) Y(B) Z(B)

But let’s consider another example:

W(B) || X (W) Y(B) Z(W)

In this case Z cann’t say what colour hat he is wearing .Y also knows that if the colour’s of Y and Z hats were same he would have shouted immediately.So he will guess that he and Z are wearing opposite color hats..So Y will wait till the time is about to over and then he will shout the opposite colour which Z is wearing.




Red and Blue marbles interview puzzle

By InterviewGeek | April 27, 20140 Comment
This is a famous interview puzzle asked by companies .We’ve candidates appearing for Microsoft interviews asked this puzzle may time . Here’s the problem :

Problem: you have two jars, 50 red marbles, 50 blue marbles. you need to place
all the marbles into the jars such that when you blindly pick one marble out of
one jar, you maximize the chances that it will be red. (when picking, you’ll first
randomly pick a jar, and then randomly pick a marble out of that jar) you can
arrange the marbles however you like, but each marble must be in a jar.
Put some load on you brain solution is not much hard to think.

Hide Solution

Solution : You just have to think about various way by which you can maximize the probability of picking a red marble is maximised. Here’s one way :
Put single red marble in Jar B and all other marbles in Jar A.
so the probability of selecting a red marble is now :
P(red) = P( Jar1 ) * P( red Jar1 ) + P( Jar2 ) * P( red Jar2 )
P(red) = 0.5 * 1 + 0.5 * 49/99
P(red) = 0.7474




Crossing Bridge Interview Puzzle

By InterviewGeek | April 27, 20140 Comment
This is again a classic interview puzzle .Asked by many tech giants. Probably you have heard this puzzle earlier ,but the reason we wrote a post on this puzzle is because many candidates even who have heard this puzzle fail to answer this puzzle in the interview. Here’s the Puzzle :

Problem: Four people are on this side of the bridge. the bridge will be destroyed by a bomb in 17 minutes. everyone has to get across before that. Problem is that it’s dark and so you can’t cross the bridge without a flashlight, and they only have one flashlight. Plus the bridge is only big enough for two people to cross at once. The four people walk at different speeds: A fella is so fast it only takes him 1 minute to cross the bridge, B takes 2 minutes, C 5 minutes, the D it takes 10 minutes to cross the bridge. when two people cross the bridge together (sharing the flashlight),
they both walk at the slower person’s pace. can they all get across before the bridge blows up? Mentioning the speeds once again :
Person A: 1 minute
Person B: 2 minutes
Person C: 5 minutes
Person D:10 minutes

Hint : try different combinations and see in which kind of solutions your total time is reducing and try to improve on that.

Hide Solution

Solution: Of course its possible, otherwise it wouldn’t be a very interesting question. The only trick is in realizing that you want to get the two slowest people across together, because otherwise you are wasting too much time. Then once you get them across, how do you not make one of them walk back with the flashlight. Well, you just have one of the fast people already there waiting to sprint the flashlight back across.
1. A & B cross. total time: 2 minutes.
C ,D |==========================| A,B(flash light)

2. B comes back. total time: 4 minutes.
C,D,B(FL)|==========================| A

3. C & D cross. total time: 14 minutes.
B |==========================| A,C,D(FL)

4. A comes back. total time: 15 minutes.
B,A(FL)|==========================| C ,D

5. A & B cross. total time: 17 minutes.
|========= =============| A,B,C,D





     */
}
