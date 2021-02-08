import java.util.Scanner;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

import java.util.ArrayList;

public class App {

  static Scanner myScanner = new Scanner(System.in);
  //creates Player object

	static PlayerSetUp player = new PlayerSetUp(); 
	public static void main(String[] args) {
     
     
     
	  // calls Intro method from PlayerSetUp class
    player.printIntro();
    // townGate method from PlayerSetUp class
		player.townGate();
	}
	
// To the east
	public static void east(){
    Scanner riddle = new Scanner(System.in);
    //encounters cobra
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("It is very dark when you enter the Temple.");
    System.out.println("You hear hisses from the corner and draw your weapon");
    System.out.println("Cobra: That's not a very nice way to visit an old friend...");
    System.out.println("");
    System.out.println("FLASHBACK: You used to fight with the Cobra, back in the days, but you had to betray the creature due to the King's requests");
    System.out.println("");
    System.out.println("'You do not scare me,' you tell the Cobra."); 
    System.out.println("");   
    System.out.println("Cobra: Is that so? Then I challenge you to a game of logic!");
    System.out.println("You: BUT LOGIC IS NOT MY STRENGTH!");
    System.out.println("Cobra: Exactly!");
    System.out.println("");
    System.out.println("Cobra: Here is the logic riddle!");
    System.out.println("Cobra: YOU HAVE LIMITED TRIES AND HINTS");
    System.out.println("Press 1 to load the logic riddle..."); // LOGIC riddle game
    int firstchoice = riddle.nextInt();
    if(firstchoice == 1){
      int hints = 4;
      int tries = 0;

      System.out.println("\n-------------------RIDDLE------------------------------------------\n");
          // user answers or asks for hint
      System.out.println(" I am not alive, but I grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?");
      System.out.println("\n-------------------------------------------------------------------\n");
      
      //user answers or asks for hint on riddle
      while(tries < 3){
      System.out.println("Would you like to answer or ask for a hint?");
      System.out.println("1. I have my answer\n2. I need a hint");
      int puzzlechoice = myScanner.nextInt();

       if(puzzlechoice == 1){ // user guesses
         tries++;
         System.out.println("Your answer: ");
         String userAnswer = myScanner.next();
          if(userAnswer.equals("Fire") || userAnswer.equals("fire")){ // if guess is correct
           System.out.println("That is correct!");
           System.out.println("The answer was FIRE! You obtained the sacred venom!!");
           player.getVenom();
           player.changeVenom(1);
           player.collectedElements.add(" Sacred Venom ");
           player.crossRoad();
           break;
           
         }
        else{
           System.out.println("That is wrong!"); // if guess is wrong
         }
       }else if(puzzlechoice == 2){ // user asks for hints
         hints--;
         askHints(hints);
         if(hints < 1){
           System.out.println("You return to the crossroad with shame");
           player.crossRoad();
         }
       }else{
         System.out.println("Invalid command!");
       }
  }// end of while loop
     if(tries > 3){
        System.out.println("\n-------------------------------------------------------------------\n");
      System.out.println("You have run out of tries!"); // over 3 tries
      System.out.println("The Cobra laughs and you exit the temple in shame");
      System.out.println("You did not recieve the sacred venom");
      player.crossRoad();
     }
      
    
    }
  }
	public static void askHints(int hints){
     if(hints == 3){
       hints--;
       System.out.println("The word contains 4 letters");
     }
     else if(hints == 2){
       hints--;
       System.out.println("F _ _ _");
     }
     else if(hints == 1){
       hints--;
       System.out.println("F _ r _");
     }
     else{
       System.out.println("You have run out of hints!");
       }
        }


   
   
   
   //To the west
	public static void west(){
		System.out.println("\n------------------------------------------------------------------\n");
	 
    Random rand = new Random(); // rand num generator for enemies.

    //enemy variables
    String[] enemies = { "Monster", "Goblin", "Assassin"};
    int maxHealthE = 80;
    int AttackfromEnemy = 25;

    //user variables
    player.playerHP = 90;
    int damageMade = 25;
    int healthPotions = 2;
    int potionsHealing = 20;
    int potionsFromEnemies = 40; // There is a 40 percent chance for the enemy to drop a healing potion

    boolean running = true;
    FIGHT: // labeled code to refer back to it
    while(running) {
          System.out.println("\n------------------------------------------------------------------\n");
          int enemyHealth = rand.nextInt(maxHealthE); // rand num from 0 to 80;
          String enemy = enemies[rand.nextInt(enemies.length)]; // selects rand enemy from array
          System.out.println("     You enter the enchanted forest.....     ");
          System.out.println();
          //player encounters enemy
          System.out.println("\t# A " + enemy + " appeared!! #\n");

          while(enemyHealth > 0) { //player chooses what to do
            System.out.println("\tYour HP: " + player.playerHP);
            System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
            System.out.println("\nWhat are you gonna do?");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Drink a health potion");
            System.out.println("\t3.Run");

            String input = myScanner.nextLine();
            if(input.equals("1")) {//CHOICE 1
               int damageDealt = rand.nextInt(damageMade);// rand num from 0 to 25 for damage to enemy
               int damageTaken = rand.nextInt(AttackfromEnemy); //rand num from 0 to 25 for damage to player

                enemyHealth -= damageDealt; //enemy health
                player.playerHP -= damageTaken; // user health

                System.out.println("\t>You strike the " + enemy + "for " + damageDealt + " damage.");
                System.out.println("\t You recieve " + damageTaken + " in retaliation");
                if(player.playerHP <= 0) {
                  System.out.println("\t> You have taken too much damage. You are to weak to go on!");
                  player.crossRoad();
                  break;
                }

            }else if(input.equals("2")){ // CHOICE 2
                    if(healthPotions > 0){
                      player.playerHP += potionsHealing;
                      healthPotions--;
                      System.out.println("You drink a health potion, healing yourself for "+ potionsHealing + ".\n\t> You now have" + player.playerHP + " HP."
                      + "\n\t> You have " + healthPotions + "left.\n");
                    }else {
                        System.out.println("\t> You have no health potions left \n Defeat enemies for a chance to earn one");
                    }
                    
            }else if(input.equals("3")){ // CHOICE 3
                     System.out.println("\t You run away from the" + enemy + "!");
                     continue FIGHT;
            }else{
              System.out.println("\tInvalid Command!");

            }
          }

              
            if(player.playerHP <1) {
              System.out.println("You limp out in the forest, unable to get obtain the Silver Ring ");
              break;
            }
                  System.out.println("\n------------------------------------------------------------------\n");
                  System.out.println(" # " + enemy + " was defeated! # ");
                  System.out.println("You obtained the silver Ring");
                  player.getRing();
                  player.changeRing(1);
                  player.collectedElements.add(" Silver Ring ");
            if(rand.nextInt(100) < potionsFromEnemies) {
              healthPotions++;
              System.out.println(" # The " + enemy + " dropped a health potion! # ");
              System.out.println(" # You now have " + healthPotions + " health potion(s) left");
            }

            // 2ND CHOICE OPTIONS (AFTER 1ST FIGHT)
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue Fighting to obtain the Silver Ring, if you havent yet obtained it");
            System.out.println("2. Go back to the crossroad");
            String input = myScanner.nextLine();
            while(!input.equals("1") && !input.equals("2")) {
              System.out.println("Invalid command!");
              input = myScanner.nextLine();
            }

            if(input.equals("1")) { //option 1
              System.out.println("You continue fighting!");
            }else if ( input.equals("2")) { //option 2
              System.out.println("You return to the cross road");
              player.crossRoad();
              break;
              
            }
 
    }
    


	}


  //TO the south
  public static void south(){
    Random rand = new Random();
    //intro to the library
    System.out.println("\n------------------------------------------------------------------\n");
    System.out.println("The underground library of KingDom Shorendia used to be a hidden temple/base for the Royal Guard of Shorendia, but was later tranformed into a huge collectory of books about the ancient histories of the Shorendia Battles.");
    System.out.println("");
    System.out.println("Luckily, you were the only one in here...or so you thought.");
    System.out.println("Rumour had it that spirits of the royal soldies roamed around the endless hallways of the library, and whatever you touch, you became...");
    System.out.println("Surely you don't wanna turn into a book of ancient pages....");
    System.out.println("");
    System.out.println("Press 1 to continue");
    int ochoice = myScanner.nextInt();

    //encounter spirit
    if(ochoice == 1){
      System.out.println("After carefully examining the books, without any contact, you encounter a spirit");
    }else {
      System.out.println("Invalid Command!");
      ochoice = myScanner.nextInt();

    }
    System.out.println("Spirit of Books: 'When I usually meet suspensful intruders like you, I would have them executed.' ");
    System.out.println("You consider the threat of the Spirit. Will you run, trust them and negotiate, or steal the Spirit Book and go?");
    System.out.println("1. Run cowardly\n2.Negotiate for the book\n3. Steal the book and go");
    int librarychoice = myScanner.nextInt();
    if(librarychoice == 1){ //choice 1 (run)
      System.out.println("you attempt to escape through the exit, but the spirit just laughs, and terminates the oxygen in the library, leading to your suffocation");
      Endings.dead();
    }else if(librarychoice == 2){ //choice 2(talk with the spirit)
      System.out.println("Instead of running, you speak to spirit.");
      System.out.println("You: 'I am a Royal Guard serving the King of Sostesia, I have come here to retrieve the Spriit Book in His Highness's request', you lie.");
      System.out.println("");
      System.out.println("Spirit: I mean, I don't believe you, but I haven't had guests in a while so what would be so bad about your presence?");
      System.out.println("");
      System.out.println("Thank you!, you say as you reach for the wanted book");
      System.out.println("\n------------------------------------------------------------------\n");
      System.out.println("'HA HA HA!', the spirit laughs. 'In my world, you don't get everything you want with such ease... ");
      System.out.println("");

      //HANGMAN
       System.out.println(" Spirit: TO obtain this book, you shall complete the following challenge.\nGuess the word I am thinking of! ");
       System.out.println("Remember! You have limited tries.....");

        int chances = 0;
        Set<String> prevGuesses = new HashSet<>();
       
        String[] words = { "Computers", "California", "Mathematics", "Underground", "Mindspace", "Mysterious"};
        String wordToGuess = words[rand.nextInt(words.length)].toUpperCase();
        int length = wordToGuess.length();
        char[] wordToGuessChars = wordToGuess.toCharArray(); //creates character array of strings
        char[] censor = wordToGuess.toCharArray();
        System.out.println("The Spirit's word is: "); 
         for (int index = 0; index < length; index++) // for loop to print secret work in underscore
       {
            censor[index] = '_';
        }
         while (!String.valueOf(censor).equals(wordToGuess)) 
        {
            //Initialize all variables in loop
            boolean correct = false; //lets the user know if the letter is in the word or not
            boolean repeated = false; //check if user guessed the same letter twice
            for (int a = 0; a < length; a++) 
            {
                System.out.print(censor[a]);//prints the censored secret word
            }
            System.out.println();
            System.out.println("Guess a letter: ");
            String currentGuess = myScanner.next().toUpperCase().substring(0, 1);
            char currentGuessChar = currentGuess.charAt(0); //gets char data from scanner
            if (prevGuesses.contains(currentGuess)) //checks if user already guessed the letter previously
            {
                System.out.println("You already guessed this letter! Try again. Your previous guesses were: ");
                System.out.println(prevGuesses.stream().reduce("", String::concat));
                repeated = true;
            }
            prevGuesses.add(currentGuess);
            //if the guess is not a duplicated guess, it checks if the guessed letter is in the word
            if (!repeated) 
            {
                int times = 0; //number of times a letter is in the word
                for ( int index = 0; index < length; index++) 
                {
                    if (wordToGuessChars[index] == currentGuessChar)  // if the user guessed correctly
                    {
                        censor[index] = currentGuessChar;  //replaces _ with guessed letter in caps
                        correct = true;
                        times++;
                    }
                }
                if (correct) 
                {
                    System.out.println("The letter " + currentGuessChar + " is in the secret word! There are " + times + " " + currentGuessChar + " 's in the word. Revealing the letter(s): ");
                } 
                else 
                {
                    System.out.println("Sorry, the letter is not in the word. The Spirit's secret word:  ");
                }
                System.out.println();
            }
            chances++;
            
        }
        if(chances > 15) {
          System.out.println("You took over the 15 chances the Spirit gave YOU!, and didn't guess the word!\n The Spirit turns you into stone as a result of your stupidity!");
          Endings.dead();
        }else {
            System.out.println("You guessed the entire word " + wordToGuess.toUpperCase() + " correctly! It took you " + chances + " attempts!");
            System.out.println("The Spirit proudly hands you the Spirit book and you leave the deadly library, obtaining another element!");
            System.out.println("You head back to the crossroad, don't come back to the library, as you already have the spritbook!");
            
            player.getBook();
            player.changeBook(1);
            player.collectedElements.add(" Spirit Book ");
            player.crossRoad();
        }
      
    }
    else if(librarychoice == 3){
       
      System.out.println("\n------------------------------------------------------------------\n");
      System.out.println("You touch the book and it turns out the rumours are true!");
      System.out.println("You turn into the book of pages and the spirit places 'you' onto the wooden shelf where you will remain for eternity!");
      Endings.dead();
    }else{
      System.out.println("Invalid Command!");
      Endings.dead();
    }
}
}


 
