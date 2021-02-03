
public class North {
   PlayerSetUp setUp = new PlayerSetUp();
   setUp.SetPlayerUp();
   //Static variable
   private static int frozensunlight;
  

  //north constructor(takes in element as parameter)
	public North(int theSunlight){
    frozensunlight = theSunlight;
  }

   //method for meeting kyoshi
  public void meetKyoshi(){
    System.out.println("---------------------------------------------------\n");
    if(frozensunlight == 0){

    
    // User meets Kyoshi
    System.out.println("You travel to Kyoshi's house");
    System.out.println();
		System.out.println("You knock on the door, but there is no response.");
    System.out.println("You start to head back, but hear the door open behind you.");
     System.out.println();
    System.out.println("'How can I help you?', you hear Kyoshi ask.");
    System.out.println("You: I'm looking for some kind of jar with sunlight? ");
    System.out.println("Kyoshi: Ah, yes! You mean this?\n He steps aside, to reveal a stunning and intricate jar\n that glowed bright in the room." );
    System.out.println("1. Next");
    choice = myScanner.nextInt();
    if(choice ==1 ){
       System.out.println("You run to it with your arms wide, but trip over a tight rope underneath your feet.");
    System.out.println("Kyoshi: Yeah, not so fast. To recieve this jar, you'll have to survive this challenge!");

      
    System.out.println("Suddenly, the ground underneath you starts to shake, and you fall through it to encounter 3 houses....");
    printPyramids();
    }else {
      System.out.println("Invalid command!");
      meetKyoshi();

    }
    }else{
      System.out.println("You have alrrady obtained this element!");
      System.out.println("You need not come back here!");
      crossRoad();
    }
    }




    public void printPyramids(){
    System.out.println("1. View pyramids"); //PRINT pyramid options
    int viewchoice = myScanner.nextInt();
      if(viewchoice == 1){
      
        int pyramid = 0;
        int rows = 5;
        while(pyramid < 3){
          System.out.println("Pyramid " + pyramid + " :");
          System.out.println();
          //print pyramid
          for (int i = 0; i < rows; i++) { // rows of pyramid (5)
        
            

            for (int j = 0; j < rows - i; j++) { // makes spaces to form the pyramid(upside down left triangle)
                System.out.print(" ");
            }
            System.out.print("  ");

            for (int k = 0; k <= i; k++) { // prints stars, from 0 to i, on each row.
                System.out.print("* ");
                
            }
 
            System.out.println("");
        }


        System.out.println("");
        System.out.println("");
        pyramid++;
      }
    

     }else{
      System.out.println("Invalid Command!");
      printPyramids();
}
   
	  //user chooses which house to enter
    System.out.println("Which house will you enter? ( 0, 1 or 2)");
    int pyramidchoice = myScanner.nextInt();
    if(pyramidchoice == 0){ // PYRAMID 0: number-guessing minigame
    System.out.println("You encounter a mathematician ! ");
    System.out.println("You need to guess the number he is thinking of!");
    
  
        // Generate the numbers 
        int number = 1 + (int)(100* Math.random()); 
        int i;
        // Given K trials 
       
        System.out.println( "A number is chosen between 1 to 100." + "Guess the number" + " within 10 trials."); 
  
        //Iterates 10 times(10 trials)
        for ( i = 0; i < 10; i++) { 
  
            System.out.println(  "Guess the number:"); 
            int guess = myScanner.nextInt(); 
  
            // If the number is guessed 
            if (number == guess) { 
                System.out.println( "Congratulations!"+ " You guessed the number."); 
                System.out.println("You have obtained the frozen sunglight!");
                frozensunlight = 1;
                collectedElements.add(" Frozen Sunlight ");
                crossRoad();
                break; 
            } else if (number > guess && i != 10 - 1) { 
                System.out.println( 
                    "The number is " + "greater than " + guess); 
            } else if (number < guess && i != 10 - 1) { 
                System.out.println("The number is"  + " less than " + guess); 
            } 
        } 
         if (i == 10) { 
            System.out.println("You have used" + " all 10 trials."); 
  
            System.out.println( "The number the mathematician was thinking of was " + number); 
            System.out.println("You return to the crossroad with shame....");
            crossRoad();
        } 
    }
    else if(pyramidchoice == 1 ){ //PYRAMID 1: weapon storage
      System.out.println("You enter a room full of weapons!");
      System.out.println("You currently have the following weapons: " + playerWeapons); // shows current weapons
      System.out.println("The scientist lets you take 2 weapons from the following options:");
      System.out.println("Press to 1 load weapon options"); //shows weapon options
      choice = myScanner.nextInt();
      if(choice == 1){

      
      System.out.println("Sword\nDagger\nTrident\nSpear\nNet");

      System.out.println("Your first selection(Type in the weapon): "); // first choice
      String firstWeaponChoice = myScanner.next();
      System.out.println("You second selection(Type in the weapon): "); // second choice
      String secondWeaponChoice = myScanner.next(); 
      playerWeapons.add(firstWeaponChoice); //adds to weapon array list
      playerWeapons.add(secondWeaponChoice); // adds to weapon array list
      System.out.println("You now have the following weapons: " + playerWeapons);

      System.out.println("\n------------------------------------------------------------------\n");
      System.out.println("You did not obtain the frozen sunlight");
      System.out.println("But you did earn new weapons which you might need!");
      System.out.println("Choose a different pyramid next time!");
      crossRoad();
      }else{
        System.out.println("You were not supposed to enter that!");
        crossRoad();
      }



    }else if(pyramidchoice == 2){ //PYRAMID 2: scientist fight/ computer vs player
          System.out.println("You encounter a scientist!");
          System.out.println("He challenges you to fight his new complex creature..");
          boolean alive = true;

          //FIGHT begins with creature in pyramid 2
          while(alive) {
          Random rand = new Random(); 
          int maxHealthofRobot = 80;
          System.out.println("\n------------------------------------------------------------------\n");
          String myArray[] = new String[1]; //creates array
           myArray = playerWeapons.toArray(myArray); // convers to array
          int creatureHealth = rand.nextInt(maxHealthofRobot); // rand num from 0 to 80;
          String creature = ("Robot"); 
          int damageMade = 25;
          int AttackFromEnemy = 25;
          System.out.println();
          
          String weaponchoice; 
          if(playerWeapons.size() > 1){
            System.out.println("Your weapons" + playerWeapons);
            weaponchoice = myArray[rand.nextInt(playerWeapons.size())]; // chooses random weapon(if multiple) for user.
          }else{
            weaponchoice = defaultPlayerWeapon; // if user does not have other weapons, they use default.
          }
          
          //player encounters creature
          System.out.println("\t# The " + creature + " appeared!! #\n");
          System.out.println();
          System.out.println("You are using a " + weaponchoice + " as your weapon");
          while(creatureHealth > 0) { //player chooses what to do
            System.out.println("\tYour HP: " + playerHP);
            System.out.println("\t" + creature + "'s HP: " + creatureHealth);
            System.out.println("\nWhat are you gonna do?");
            System.out.println("\t1.Attack");
            System.out.println("\t2.Run to another pyramid");

            String input = myScanner.nextLine();
            if(input.equals("1")) {
              int damageDealt = rand.nextInt(damageMade);// rand num from 0 to 25 for damage to creature
              int damageTaken = rand.nextInt(AttackFromEnemy); //rand num from 0 to 25 for damage to player

                creatureHealth -= damageDealt; //creature health loss
                playerHP -= damageTaken; // user health loss

                System.out.println("\t>You strike the " + creature + "for " + damageDealt + " damage.");
                System.out.println("\t You recieve " + damageTaken + " in retaliation");
                if(playerHP <= 0) {
                  System.out.println("\t> You have taken too much damage. You are to weak to go on!");
                  playerHP += 30;
                  crossRoad();
                  break;
                }
            }else if(input.equals("2")){
                System.out.println("You try to run to another pyramid, but it is too far away!");
                System.out.println("The robot tears you to pieces!");
                dead();
            }
         }  
         if(playerHP <1) {
              System.out.println("You are too weak. You did not obtain the frozen sunlight");
              break;
            }
            // this should print if the robot's health is 0(victory)
            if(creatureHealth <= 0){
              System.out.println("\n------------------------------------------------------------------\n");
          System.out.println(" # " + creature + " was defeated! # ");
          System.out.println("You obtained the frozen sunlight!");
          frozensunlight =1;
          collectedElements.add(" Frozen Sunlight ");
          crossRoad();
            }
          



       }
    }
}
    
}

