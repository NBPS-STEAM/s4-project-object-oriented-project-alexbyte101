import java.util.Scanner;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;


public class PlayerSetUp {
static Scanner myScanner = new Scanner(System.in);

	static int playerHP;
	static String playerName;
	static String defaultPlayerWeapon;
	static int choice;
  
  
  //Elements
	static int silverRing = 0;
  static int sacredvenom = 0;
  static int frozensunlight = 0;
  static int spiritbook = 0;

  static ArrayList<String> collectedElements = new ArrayList<String>(); //creates array list for the user's collected elements
  static ArrayList<String> playerWeapons = new ArrayList<String>(); //creates array list for the user's weapons
 

	
	public void SetPlayerUp(){
		
		
		playerHP = 90;
	

		defaultPlayerWeapon = "Knife";
    playerWeapons.add(defaultPlayerWeapon); // ended up changing it to variable 
    
    System.out.println(" >> # WELCOME TO THE GAME OF ANACONDA # <<");

		System.out.println("Your HP: "+ playerHP);
		System.out.println("Your Current Weapon: "+ defaultPlayerWeapon);
		
		System.out.println("Please enter your name:");
		
		playerName = myScanner.nextLine();
    	System.out.println("\n------------------------------------------------------------------\n");
		
    //Intro to the Game
		System.out.println("Hello " + playerName + ", \nyou are one of the Dungeon's most aclaimed and beloved \nthieves.\nYou hold masteries in many arenas -- \nIdentity Theft \nSocial Enginnering \nManipulation \nIllusion");
    	System.out.println("\n------------------------------------------------------------------\n");
		
    System.out.println("This season, the Lord of Thieves has chosen you to complete a \nstrenuous mission: Anaconda.");
    System.out.println("Press 1 to continue ");
    int first_choice = myScanner.nextInt();
    if(first_choice == 1){
      
      System.out.println("\n----------------------------------------------------------------------\n");
      System.out.println("Anaconda is known to be an impossible mission only legendary masterminds can complete it.\n >> You'll have to enter the Shorendia Castle with the identity of someone else, and ransack all the values you can find the time period...");
      System.out.println("\n----------------------------------------------------------------------\n");
      System.out.println("BUT BEFORE YOU ENTER, YOU MUST COLLECT ALL THE ELEMENTS");
      System.out.println("The reason why this mission is difficult is because the guards will not let you in the Castle unless you have all of the elements they desire.");
      System.out.println("You pack some random belongings to seem like an innocent traveller, and head to the main entrance of the KingDom");
      System.out.println("To start your mission press 1");
      first_choice = myScanner.nextInt();
      while(first_choice != 1){
        System.out.println("To start your mission press 1");
        first_choice = myScanner.nextInt();
      }
      
    }else {
      	System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Invalid input. Try again.");
        playerSetUp();
    }
		
		
	}	
}