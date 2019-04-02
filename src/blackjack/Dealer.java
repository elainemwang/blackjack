package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 


//define Dealer class here
class Dealer extends AbstractPlayer{
 
	
	//instance variable - Deck 
        Deck deck = new Deck();




	//constructors
        public Dealer(){
            super();
        }




	//method to shuffle
        public void shuffle(){
            deck.shuffle();
        }






	//method to deal a card
        public Card deal(){
            return deck.nextCard();
        }




	//hit method goes here
        public boolean hit(){
            return true;
        }
}