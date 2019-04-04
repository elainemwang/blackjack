package blackjack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack
{
	private ArrayList<Playerable> players;
        
	public BlackJack()
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
            System.out.println();
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
                    System.out.println(players.get(i));
                    while((choice == 'Y'||choice == 'y')&&players.get(i).getHandValue()<21){
                        System.out.println("Do you want to hit? [Y/N]");
                        choice = keyboard.next().charAt(0);
                        System.out.println();
                        if(choice == 'n' || choice == 'N'){
                            break;
                        }
                        players.get(i).addCardToHand(dealer.deal());
                        System.out.println("Current " + players.get(i));
                    }
                    choice = 'y';
                    System.out.println();
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

                //checking who wins
                int max = 0;
                for(int i = 0; i < players.size(); i++){
                    if(players.get(i).getHandValue()<=21){
                        if(players.get(i).getHandValue()>max){
                            max = players.get(i).getHandValue();
                        }
                    }
                    else{
                        if (i == 0){
                            System.out.println("Dealer busted!");
                        }
                        else{
                            System.out.println("Player " + i + " busted!");
                        }
                    }
                }
                ArrayList<Playerable> winners = new ArrayList<Playerable>();
                ArrayList<Integer> winNum = new ArrayList<Integer>();
                for(int i = 0; i < players.size(); i++){
                    if(players.get(i).getHandValue()<=21){
                        if(players.get(i).getHandValue()==max){
                           winners.add(players.get(i));
                           winNum.add(i);
                        }
                    }
                }
                if(winners.size()>0){
                    for(int i = 0; i < winners.size(); i++){
                        if(winNum.get(i) == 0){
                            System.out.println("Dealer " + " wins!");
                        }
                        else{
                            System.out.println("Player " + winNum.get(i) + " wins!");
                        }
                        winners.get(i).setWinCount(winners.get(i).getWinCount()+1);
                    }
                    
                }
                else{
                    System.out.println("No one wins...");
                }
                
                System.out.println();
                System.out.println("Dealer - " + players.get(0).getWinCount()+" win(s)");
                for(int i = 1; i < players.size(); i++){
                    System.out.println("Player " + i + " - " + players.get(i).getWinCount()+" win(s)");
                }
                
                
                System.out.println("Play again? [Y/N]");
                play = keyboard.next().charAt(0);
                System.out.println();
            }while(play == 'y'||play=='Y');


	}
	
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		game.playGame();
	}
}