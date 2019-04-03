package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
	//add in Player instance variable
        private Player player;
	//add in Dealer instance variable
        private Dealer dealer;
        
	public BlackJack()
	{
            player = new Player();
            dealer = new Dealer();
            dealer.shuffle();
	}

	public void playGame()
	{
            // deal the player two cards
     
            player.addCardToHand(dealer.deal());
            player.addCardToHand(dealer.deal());
            // deal the dealer two cards
            dealer.addCardToHand(dealer.deal());
            dealer.addCardToHand(dealer.deal());
            
            System.out.println("Current " + player);
            if(player.getHandValue()>=21){
                
            }
            System.out.println("Do you want to hit? [Y/N]");
            Scanner keyboard = new Scanner(System.in);
            char choice = keyboard.next().charAt(0);
            if(choice == 'Y'||choice == 'y'){
                player.addCardToHand(dealer.deal());
            }
            
           



	}
	
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		game.playGame();
	}
}