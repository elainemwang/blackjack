package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack2
{
	private ArrayList<Playerable> players;
        
	public BlackJack2()
	{
            players = new ArrayList<Playerable>();
            players.add(new Dealer());
            
            
	}

	public void playGame()
	{
            Dealer dealer = (Dealer) players.get(0);
            Scanner keyboard = new Scanner(System.in);
            char choice;
            char play;
            System.out.println("How many players?");
            int numPlayers = keyboard.nextInt();
            for(int i = 0; i < numPlayers; i++){
                players.add(new Player());
            }
            do{
               for(Playerable player : players){
                   player.resetHand();
               }
                dealer.resetHand();
                dealer.shuffle();
                choice = 'Y';
                
                // deal the dealer two cards
                dealer.addCardToHand(dealer.deal());
                dealer.addCardToHand(dealer.deal());
                
                while(dealer.hit()){
                    dealer.addCardToHand(dealer.deal());
                }
                
                // deal the players two cards
                for( int i = 1; i < players.size(); i++){
                    System.out.println("Current player: " + i);
                    players.get(i).addCardToHand(dealer.deal());
                    players.get(i).addCardToHand(dealer.deal());
                    
                    while((choice == 'Y'||choice == 'y')&&players.get(i).getHandValue()<21){
                        System.out.println("Do you want to hit? [Y/N]");
                        choice = keyboard.next().charAt(0);
                        if(choice == 'n' || choice == 'N'){
                            break;
                        }
                        players.get(i).addCardToHand(dealer.deal());
                        System.out.println("Current " + players.get(i));
                    }
                }
                
                
                for(int j = 1; j < players.size(); j++){
                    System.out.println();
                    System.out.println("PLAYER "+j+":  ");
                    System.out.println("Hand Value: "+players.get(j).getHandValue());
                    System.out.println("Hand Size: "+players.get(j).getHandSize());
                    System.out.println(players.get(j));
                }
                
                System.out.println();
                System.out.println("DEALER:  ");
                System.out.println("Hand Value: "+dealer.getHandValue());
                System.out.println("Hand Size: "+dealer.getHandSize());
                System.out.println(dealer);
                System.out.println();

                
                /*
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
                */
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