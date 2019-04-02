package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	private int topCardIndex;
	private ArrayList<Card> stackOfCards;

	public Deck ()
	{
		//initialize data - stackOfCards - topCardIndex
		topCardIndex = 51;
                stackOfCards = new ArrayList<Card>();
		
		//loop through suits
                for(String s : SUITS){
			//loop through faces
                        for(int i = 1; i <= NUMFACES; i++){
				//add in a new card
                                stackOfCards.add(new BlackJackCard(i,s));
                        }
                }
		
	}

	//modifiers
   public void shuffle ()
	{
		//shuffle the deck
            Collections.shuffle(stackOfCards);
		//reset variables as needed
            topCardIndex = 51;
            
	}

   //accessors
	public int  size ()
	{
		return stackOfCards.size();
	}

	public int numCardsLeft()
	{
		return topCardIndex+1;
	}

	public Card nextCard()
	{
		return stackOfCards.get(topCardIndex--);
	}

	public String toString()
	{
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	} 
}