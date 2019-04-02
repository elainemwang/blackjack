package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 


public abstract class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;

  	//constructors
        public Card(){
            setSuit("ZERO");
            setFace(0);
        }
        public Card(String s){
            setSuit(s);
            setFace(0);
        }
        public Card(int f){
            setSuit("ZERO");
            setFace(f);
        }
        public Card(int f, String s){
            setSuit(s);
            setFace(f);
        }


	// modifiers
        public void setSuit(String suit){
            this.suit = suit;
        }
        public void setFace(int face){
            this.face = face;
        }

 

  	//accessors
        public String getSuit(){
            return suit;
        }
        public int getFace(){
            return face;
        }

  	public abstract int getValue();

	public boolean equals(Card obj)
	{
            if(getSuit().equals(obj.getSuit())){
                if(getFace() == obj.getFace()){
                    return true;
                }
            }
            return false;
	}

  	//toString
        public String toString(){
            return FACES[face] + " of " + getSuit() + " | value = " + getValue();
        }
  	
 }