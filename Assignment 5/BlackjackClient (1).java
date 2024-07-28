////////////////////////////////////////////////////////
//   Kush Gandhi 
//   Z1968933
//   CSCI 470-PE1 
//   
//  I certify that this is my own work and where appropriate an extension 
//  of the starter code provided for the assignment. 
////////////////////////////////////////////////////////

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackjackClient extends Thread implements Runnable 
{
	private Socket socket;
	private Player player;
	private Scanner input;
	private static int players;
	String[] cardVals = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	String[] cardName = {"Hearts", "Clubs", "Spades", "Diamonds"};
	List<String> deck;
    
    public void populateCards()
    {
    	//adds the card to deck list like 3 of hearts
    	deck = new ArrayList<>();
    	for (String val : cardVals)
    	{
    		for (String name : cardName)
    		{
    			deck.add(val + " of " + name);
    		}
    	}
    }
    
    public String getCard() 
    {
    	//method gets a random card from the deck
    	Random rand = new Random();
		return deck.remove(rand.nextInt(deck.size()));
    	
    }
    
    public BlackjackClient(Socket socket, Player player)
    {
        this.socket = socket;
        this.player = player;
    }

    public void playerAction(Player player, int playerNumber, List<Integer> playerHands) 
    {
        int playerTotal = playerHands.get(playerNumber - 1); // Get the initial total for the player
        while (true) 
        {
            System.out.println(player.getName() + " " + playerNumber + ", choose your action: ");
            String action = input.nextLine();
            if (action.equals("hit")) 
            {
                int cardVal = 0;
                String drawCard = getCard();
                String[] split = drawCard.split(" ");
                String cardValue = split[0];
                switch (cardValue)
                {
                    case "Q": case "K": case "J":
                        cardVal = 10;
                        break;
                    case "A":
                        cardVal = 1;
                        break;
                    default:
                        cardVal = Integer.parseInt(cardValue);
                        break;
                }
                playerTotal += cardVal; // Update the total with the value of the drawn card
                
                System.out.println(player.getName() + " " + playerNumber + " hits and receives: " + drawCard + " (Total: " + playerTotal + ")");
            }
            
            if (action.equals("stand")) 
            {
                break;
            }
        }
        
        playerHands.set(playerNumber - 1, playerTotal); //Update the total for the current player
    }
    
    //Initial start of the game asking the amount of player sand printing the balances out
    public void run() 
    {
    	try
    	{
        	try 
            {
        		PrintWriter out = new PrintWriter(System.out);
        		input = new Scanner(System.in);
        		System.out.println("Welcome to Blackjack!");
        		System.out.print("Enter Number of Players: ");
                players = input.nextInt();
                
                System.out.println("\nInitial balances:");
                for (int i = 1; i <= players; i++)
                {
                    Player p = new Player("Player " + i, 1000);
                    System.out.println(p.getName() + ": " + p.getBalance());
                    
                }
                
                populateCards();
                startRound();
            }
        	finally
        	{
        		socket.close();
        	}
    	}
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    //this method that does all of the game actions etc.
    void startRound()
    {
        String repeat;
		do 
    	{
	    	int playerHandValue = 0;
	    	int newTotal = 0;
	    	int round = 1;
	    	List<String> playerHand = new ArrayList<>();
	    	List<String> dealerHand = new ArrayList<>();
	    	List<String> cardTotal = new ArrayList<>();
	        List<Integer> total = new ArrayList<>();
	    	System.out.println("\nRound 1:");
	
	    	//asks the players for the bet amount
	    	for (int i = 1; i <= players; i++)
	    	{
	    		System.out.print("Please enter your bet, " + player.getName() + " " + i + ": $");
	        	int betAmount = input.nextInt();
	        	
	        	//bet amount can't be > 1000 else they try again 
	        	if (betAmount > 1000)
	        	{
	        		System.out.print("\nBet amoumnt exceeds value 1000. try again: ");
	        		betAmount = input.nextInt();
	        	}
	        	
	        	//Calculates the remaining amount and displays it to the players
	        	int remainingAmount = player.getBalance() - betAmount;
	        	System.out.println(player.getName() + " " + i + " bets $" + betAmount + " and has $" + remainingAmount + " remaining.");	
	    	}
	    	
	    	//Now to deal cards to the player and dealer
	    	System.out.println("\nDealing cards...");
	    	
	        //Deal two cards to each player
	        for (int i = 1; i <= players; i++) 
	        {
	        	String card1 = getCard();
	        	String card2 = getCard();
	        	playerHand.add(player.getName() + " " + i + "'s hand: " + card1 + ", " + card2);
	        }
	        String dealerCard1 = getCard();
	        String dealerCard2 = getCard();
	        dealerHand.add(dealerCard1);
	        dealerHand.add(dealerCard2);
	
	    	for (String card : playerHand)
	    	{
	    		String[] split = card.split(" ");
		        String cardValue = split[3];
		        String cardValue2 = split[6];
		        cardTotal.add(cardValue); // Add extracted card value to the list
		        cardTotal.add(cardValue2);
	
	    	}
	    	for (String card : cardTotal) {
	            int value;
	
	            switch (card) {
	                case "Q": case "K": case "J":
	                    value = 10;
	                    break;
	                case "A":
	                    value = 1;
	                    break;
	                default:
	                    value = Integer.parseInt(card);
	                    
	                    break;
	            }
	
	            total.add(value);
	        }
	    	
	    	//Calculated the card values and puts into the list
	        List<Integer> playerHands = new ArrayList<>();
	        for (int i = 0; i < players; i++) 
	        {
	            int card1Value = total.get(i * 2);
	            int card2Value = total.get(i * 2 + 1);
	            playerHandValue = card1Value + card2Value;
	            playerHands.add(playerHandValue);
	        }
	        
	        //Print out the player hand and total hand
	        for (String s : playerHand)
	        {
	        	System.out.println(s + " (total: " + playerHands.get(playerHand.indexOf(s)) + ")");
	        }
	        
	        //Display the dealer card and the other is hidden
	    	System.out.println("Dealer's showing: " + dealerHand.get(0));
	    	
	    	// Looping action to get player action and perform them
	    	for (int i = 1; i <= players; i++) 
	    	{
	    	    playerAction(player, i, playerHands);
	    	}

	        System.out.println("Dealer's turn..." + "\nDealer's hidden card is a " + dealerCard2 + " (Total: " + ")");
	        	        
	        System.out.println("Results:");
	        
	        System.out.println("End of Round " + round + ".");
	        System.out.print("Would you like to play another round? Yes/No:");
	        repeat = input.next();
	        
	        if (repeat.equals("No") || repeat.equals("no"))
	        {
	        	System.out.println("Thank you for playing!");
	        }
	        else
	        {
	        	run();
	        }
    	} while(repeat.equals("Yes") || repeat.equals("yes"));
    }
}