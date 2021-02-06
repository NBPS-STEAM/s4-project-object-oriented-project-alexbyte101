import java.util.Scanner;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.ArrayList;


public class PlayerSetUp {
 static Scanner myScanner = new Scanner(System.in);

	 static int playerHP= 90;
	 static String playerName;
	 static String defaultPlayerWeapon = "Knife";
	 static int choice;
  
  
  //Elements
	 static private int silverRing = 0;
   static private int sacredvenom = 0;
   static private int frozensunlight = 0;
   static private int spiritbook = 0;

   static ArrayList<String> collectedElements = new ArrayList<String>(); //creates array list for the user's collected elements
   static ArrayList<String> playerWeapons = new ArrayList<String>(); //creates array list for the user's weapons
 

 // MODIFIERS FOR ELEMENTS

 public void changeRing(int newValue){
   silverRing = newValue;
 }
 public void changeVenom(int newValue){
   sacredvenom = newValue;
 }
 public void changeSunlight(int newValue){
   frozensunlight = newValue;
 }
 public void changeBook(int newValue){
   spiritbook = newValue;
 } 



 //GETTER METHODS FOR ELEMENTS
 public  int getRing(){
   return silverRing;
 }
 public  int getVenom(){
   return sacredvenom;
 }
 public  int getSunlight(){
   return frozensunlight;
 }
 public  int getBook(){
   return spiritbook;
 }
     //Constructor
	  public PlayerSetUp() {
    System.out.println("Please enter your name:");
		 playerName = myScanner.nextLine();
     playerHP = 90;
     defaultPlayerWeapon = "Knife";
     playerWeapons.add(defaultPlayerWeapon); 
     
  }	


	public static void printIntro(){
    playerWeapons.add(defaultPlayerWeapon); 
    
    System.out.println(" >> # WELCOME TO THE GAME OF ANACONDA # <<");

		System.out.println("Your HP: "+ playerHP);
		System.out.println("Your Current Weapon: "+ defaultPlayerWeapon);
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
        printIntro();
    }
		
		
	}
  

  public static void townGate(){
		
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are at the gate of the Kingdom.");
		System.out.println("A guard is standing in front of you.");
		System.out.println("");
		System.out.println("What do you want to do?");
		System.out.println("");
		System.out.println("1: Talk to the guard");
		System.out.println("2: Sneak past the guard");
		System.out.println("3: Leave");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();
		

		if(choice==1){
			if(silverRing > 0 && sacredvenom > 0 && frozensunlight > 0  && spiritbook > 0){ // if user collected all elements
				Endings.ending();
			}
			else{
				System.out.println("Guard: 'Hello there, stranger. So your name is " + playerName + "?'");
        System.out.println("You: 'Yes, I'm a goods trader from the Southern Tribe', you lie.");
				System.out.println("Guard: 'We cannot let you in yet, as you dont contain the items of purity \nand verification. \n These include: \n The Sacred Venom \n The Spirit Book \n The Frozen Sunlight \n and The Silver Ring'");
        System.out.println("Guard: 'Take the crossroad on the right and start searching there.'");
        System.out.println("1. Go to the crossroad");
        choice = myScanner.nextInt();
        if(choice == 1){
          crossRoad();
        }else {
          System.out.println("Invalid Command!");
          System.out.println("Try again!");
          townGate();
        }
       

			}
			
		}
		else if(choice==2){
			playerHP = playerHP-1;
			System.out.println("Guard: Wrong choice. \n\nThe guard arrests you, and shoots down your horse.\n");
      Endings.dead();
		}
		else if(choice==3){
			System.out.println("You leave in the search of crossroad to go back to your Dungeon");
      System.out.println("When you return to the Dungeon, the King of thieves is disappointed to see you empty-handed and your reputation falls.....");
      System.out.println(">># MISSION FAILED #<<");
      	
		}	
		else{
			townGate();
		}
	}

  // The crossroad
	public static void crossRoad(){
     if(silverRing > 0 && sacredvenom > 0 && frozensunlight  > 0 && spiritbook > 0) { //if user collected all elements
      System.out.println("\n----------------------CROSSROAD---------------------------------------\n");
      System.out.println("You have obtained all the elements! Head back to the gate of the kingdom!");
      System.out.println("5. Go back to the castle's entrance");
      System.out.println("\n----------------------------------------------------------------\n");
      choice = myScanner.nextInt();
      if(choice == 5){
        townGate();
      }else {
        System.out.println("Invalid command!");
        crossRoad();
      }
    }else{
      System.out.println("\n----------------------CROSSROAD---------------------------------------\n");
		System.out.println("You are at the cross road. \n You do not have all the items the guards desire, yet.\n You can return to the castle's entrance, by hitting 5\n ");


    if(collectedElements.size() == 0){ // if user has no elements
      System.out.println("You currently have obtained the following element(s): [none]");
    }else{
      System.out.println("You currently have obtained the following element(s): " + collectedElements); // print what elements user currently has
    }
    System.out.println("1: Go north, to Wizard Kyoshi's place");
		System.out.println("2: Go east, to the Cobra's Temple");
		System.out.println("3: Go south, to the underground Library");
		System.out.println("4: Go west, to the Enchanted Forest");
    System.out.println("5. Go back to the castle's entrance");
		System.out.println("\n----------------------------------------------------------------\n");
		
		choice = myScanner.nextInt();
		
		if(choice==1){ //to the north

     //creates north object
      North northOption = new North(frozensunlight);
			northOption.meetKyoshi();
		}
		else if(choice==2){ //to the east
			App.east();
		}
		else if(choice==3){ // to the south
			App.south();
		}
		else if(choice==4){ // to the west
			App.west();
		}
    else if(choice == 5){ //back to entrance of Kingdom
      townGate();
    }
		else{
      System.out.println("Invalid input!");
			crossRoad(); 
		}
    }
		}
	
	
}