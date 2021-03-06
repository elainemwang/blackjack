package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack3
{
	//add in Player instance variable
        private Player player;
	//add in Dealer instance variable
        private Dealer dealer;
        
	public BlackJack3()
	{
            player = new Player();
            dealer = new Dealer();
            
	}

	public void playGame()
	{
            Scanner keyboard = new Scanner(System.in);
            char choice;
            char play;
            do{
                player.resetHand();
                dealer.resetHand();
                dealer.shuffle();
                choice = 'Y';
                // deal the player two cards

                player.addCardToHand(dealer.deal());
                player.addCardToHand(dealer.deal());
                // deal the dealer two cards
                dealer.addCardToHand(dealer.deal());
                dealer.addCardToHand(dealer.deal());

                System.out.println("Current " + player);


                while((choice == 'Y'||choice == 'y')&&player.getHandValue()<21){
                    System.out.println("Do you want to hit? [Y/N]");
                    choice = keyboard.next().charAt(0);
                    if(choice == 'n' || choice == 'N'){
                        break;
                    }
                    player.addCardToHand(dealer.deal());
                    System.out.println("Current " + player);
                }
                while(dealer.hit()){
                    dealer.addCardToHand(dealer.deal());
                }
                System.out.println();
                System.out.println("PLAYER:  ");
                System.out.println("Hand Value: "+player.getHandValue());
                System.out.println("Hand Size: "+player.getHandSize());
                System.out.println(player);

                System.out.println();
                System.out.println("DEALER:  ");
                System.out.println("Hand Value: "+dealer.getHandValue());
                System.out.println("Hand Size: "+dealer.getHandSize());
                System.out.println(dealer);
                System.out.println();

                if(player.getHandValue()>21){
                    if(dealer.getHandValue()>21){
                        System.out.println("Player and Dealer both busted...");
                    }
                    else{
                        System.out.println("Player busted! Dealer wins.");
                        dealer.setWinCount(dealer.getWinCount()+1);
                    }
                }
                else if(dealer.getHandValue()>21){
                    System.out.println("Dealer busted! Player wins.");
                    player.setWinCount(player.getWinCount()+1);
                }
                else{
                    if(player.getHandValue()>dealer.getHandValue()){
                        System.out.println("Player has the bigger hand value! Player wins.");
                        player.setWinCount(player.getWinCount()+1);
                    }
                    else if(dealer.getHandValue()>player.getHandValue()){
                        System.out.println("Dealer has the bigger hand value! Dealer wins.");
                        dealer.setWinCount(dealer.getWinCount()+1);
                    }
                    else{
                        System.out.println("Player and Dealer have the same hand value.");
                    }
                }

                System.out.println("Wins: " + player.getWinCount());
                System.out.println("Losses: " + dealer.getWinCount());

                System.out.println("Play again? [Y/N]");
                play = keyboard.next().charAt(0);
            }while(play == 'y'||play=='Y');


	}
	
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		game.playGame();
	}
}