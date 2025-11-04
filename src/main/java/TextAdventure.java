// Jacob Stasienko
// November 4, 2025 *due
// APCS-A
// 
// just a fairly standard storyline, pick paths to get different endings. not very complex or anything (i'm lazy and overworked)
// had some ambition for a deep story with meaning, dunno how well that went given how thin i've been stretched but whateva

// there may be a number of seemingly random booleans such as "fromSeven," these change the scene descriptions depending on how you got to that scene to make the story more coherent
// apologies for the lack of consistency, reminder that i'm lazy and tired. if it works, it works, so im in "keep it simple, stupid" mode
// assuming the user provides the proper data type for each input
// also consider the various method calling an indefinitely nested conditional, it keeps going until an ending is reached

import java.util.Scanner;
import java.util.Random;

public class TextAdventure {
    // a number of variables/objects to use in the various methods
    static boolean run=true, hasKey=false, visitedEight=false;
    static boolean fromOne = true, fromThree=false, fromSeven=false, fromTen=false, fromEleven=false;
    static Scanner sc = new Scanner(System.in);
    static int search3=0, search7=0; // number of times areas 3 and 7 have been searched, respectively (limited to 3 and 5)
    static Random randInt = new Random();

    public static void main(String[] args) {
        while(run){
            System.out.println("Authenticating user...\n");

            // stolen code, waits a bit before continuing (immersion)
            // please consider this as a "creative title screen" my life depends on it
            for(int i=0; i<3; i++) {
                try {
                    Thread.sleep(790);
                } catch (InterruptedException ignored) {}
                System.out.println(".");
            }
            System.out.println("\nAuthentication complete. Access granted.\nVersion: 2.11.0\nTime: 2371ms\n");
            System.out.println("Downloading mission data...");
            try {
                Thread.sleep(1560);
            } catch (InterruptedException ignored) {}
            
            System.out.println("Data downloaded.");
            System.out.print("\nRequest mission info? y/n:  ");
            if(sc.nextLine().equalsIgnoreCase("y")){
                System.out.println("The year is 2034. Big tech corporations have gained a higher authority than most worldwide governments, and their fight for AI dominance has led to several wars between the states under their influence. \nSides have gone nuclear. Billions are gone. You and many others have taken shelter in various bunkers and shelters in secrecy from big tech. \nYou have been tasked with operating one of the few remaining rebellion bots to eliminate Grok, the assumed authority of the remaining States in the continent. If you succeed, it would provide a great advance point for the human rebellion.\nTake care, plan accordingly, and if you succeed, you will be a renowned hero for the human race. Be not concerned for failure.");
            }

            sceneOne(); // the next scene is called in each method, so i just start the sequence here (allows for returning to previous scenes to pick a different path without insanely complex if/else structures or something stupid)
            runAgain(); // runs only after one of the three endings is reached (no further scenes are called, flow of control returns to here)
        }
    }
    
    // might not work, attempt to clear the screen so you can't see the previous game in the terminal
    public static void clear(){
        System.out.print("\033[H\033[2J"); 
    }

    // run game again (thought i would need to use this multiple times, I didn't but didnt bother removing it :p)
    public static void runAgain(){
        System.out.println("Play again? (y/n): ");
        sc.nextLine(); // been having issues sometimes, the program just ends instantly without allowing user to input their choice. this line might require two inputs, the first being useless
        String s = sc.nextLine();
        if(s.equalsIgnoreCase("y")){
            clear();

            // resets variables to default for repeats
            hasKey=false;
            fromOne=true;
            fromThree=false;
            fromSeven=false;
            fromTen=false; 
            fromEleven=false;
            visitedEight=false; 

            search3=0;
            search7=0;
            return;
        }

        else{
            System.out.println("Thank you for your inputs.");
            System.out.println("Exiting simulation...");
            run=false;

            try{
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {}
            clear();
        }
    }


    // scene one: main/start
    
    public static void sceneOne(){
        // different output based on where user comes from
        if(fromOne){
            System.out.println("\n\nYour mission begins. Choose your first move.");
        }
        else{
            System.out.println("You returned to where you started.");
        }
        fromOne=false;
        System.out.println("1. Push forward, straight into Grok's domain.");
        System.out.println("2. Attempt to find a secondary path.");
        System.out.println("3. Call for assistance.");
        System.out.print("Your move:  ");

        // this while loop appears in almost every scene, it validates user input
        int choice = sc.nextInt();
        while (choice>2){
            if(choice==3){
                System.out.println("\nCalling for backup in this area would be dangerous, and you are only one of a few units left, so that would not end well.\nEnter another move: ");
            } else {
                System.out.println("\nInvalid choice. Try again:  ");
            }
            choice = sc.nextInt();
        }

        // these also appear in most scenes, switches to the next available scene at the user's request
        if(choice==1){
            sceneTwo();
        }
        else if(choice==2){
            sceneFive();
        }
    }

    // scene two: main area
    public static void sceneTwo(){
        if(!fromThree){
        System.out.println("\n\nYou push forward, down the main path. You see the remains of all the other rebellion bots littering the side of the path. No doubt the previous pilots have received their punishment for failure.");
        System.out.println("You find a small clearing, with an open path to the large palace of Grok alongside a small opening in a mostly demolished building.\nThree options face you: "); 
        }
        else{
            System.out.println("You return to the clearing.");
        }
        fromThree=false;
        System.out.println("1. Explore the building.");
        System.out.println("2. Storm the palace and confront Grok. WARNING: No turning back.");
        System.out.println("3. Return to previous scene.");
        System.out.print("Your move:  ");

        // decision based on user input
        int choice=sc.nextInt();
        while(choice>3 || choice<1){
            System.out.println("\nInvalid choice. Try again:  ");
            choice = sc.nextInt();
        }
        if(choice==1){
            sceneThree();
        } else if(choice==2){
            sceneFour();
        } else if(choice==3){
            System.out.println("Returning...\n\n");
            sceneOne();
        }
    }


    // scene three: explore building
    public static void sceneThree(){
        // like scene one, checks where the user arrived at this scene from, gives different text based on if they searched the area
        if(fromThree){
            System.out.println("\nYou sense no need to be here, unless you haven't searched enough.");
        }
        else{
            System.out.println("\n\nYou crawl into the abandoned building and scale down a hole in the floor. Ignoring all the rubble, you notice a few faint inscriptions on the wall. It appears as if this place was a former bunker much like the one you are in currently.");
            System.out.println("Your mind wanders, wondering if these people were attempting to do what you were now, as you see a number of computer terminals and transmission equipment. The thought chills you, but you must focus on the mission.");
        }

        fromThree=true;
        System.out.println("You have two options:");
        System.out.println("1. Search the area. (" + search3 + "/3 attempts)");
        System.out.println("2. Return to previous scene.");
        System.out.print("Your move:  ");

        int choice=sc.nextInt();
        while(choice>2 || choice<1){
            System.out.print("\nInvalid choice. Try again:  ");
            choice = sc.nextInt();
        }

        // search feature: probability based, attempts to find a key (1 in 5 chance, up to 3 attempts)
        while(choice==1){
            if(search3<3 && !hasKey){
                System.out.println("You search the area...");
                if(randInt.nextInt(5)==0){
                    System.out.println("Oh! You found a strange looking, rusty key. Maybe this could be used for something.");
                    hasKey = true;
                    break;
                }
                else{
                    System.out.println("You don't seem to find anything of use.");
                }
            // prevents extraneous searches (>3 or if the key has been found)
            }
            else if(hasKey){
                System.out.println("You sense no need to search the area; you already have a key.");
                break;
            }
            else if(search3>=3){
                System.out.println("Concluding from previous searches, there doesn't seem to be anything in the area.");
                break;
            }
            

            search3+=1;
            // checks if user wants to search again without showing all the enter scene 3 text
            System.out.print("Search again? (1: yes, 2: no): ");
            if(hasKey){
                break;
            }
            else if(sc.nextInt()==1){
                continue;
            }
            else{
                break;
            }
            
        }
        // returns to scene 2, or repeats scene 3 after exiting while loop
        if(choice==2){
            System.out.println("Returning...\n\n");
            sceneTwo();
        }
        else{
            sceneThree();
        }
    }


    // scene four: Grok fight

    // player moves: attack, 15-40 damage, block: ignore next damage (80%) + heal 5-15
    // boss moves: attack, 10-20 damage, slam: 35 damage (15%), EMP: insta kill (1%, good luck!). boss does not heal
    // kinda basic but again im lazy and overworked, cope harder
    public static void sceneFour(){
        // boss fight exclusive variables
        int bossHealth=150, playerHealth=100, choice, damage, heal, bossMove;
        clear();
        System.out.println("\n\nYou sense a feeling of dread encountering Grok's grotesque physical form, a gnarled pile of sharp metal scraps with a veil of wires around its exoskeleton. No human could ever produce something so horrific.");
        System.out.println("While it hasn't noticed you, you can get a hit in.");

        // fighting while loop with only two outcomes: boss death or player death
        while(bossHealth>0 && playerHealth>0){
            System.out.println("--- BOSS FIGHT ---");
            System.out.println("Your health: " + playerHealth + "| Grok's health: " + bossHealth);
            System.out.println("1. Attack   ||   2. Block");
            System.out.println("Your move: ");

            // validates input
            choice=sc.nextInt();
            while(choice>2 || choice<1){
                System.out.print("\nInvalid choice. Try again:  ");
                choice = sc.nextInt();
            }
            // attack
            if(choice==1){
                damage = 15 + randInt.nextInt(26);
                System.out.println("\n\nYou deal " + damage + " damage.");
                bossHealth-=damage;
                
                // determines boss move
                bossMove = randInt.nextInt(100);
                if(bossMove==0){
                    System.out.println("Grok unleases a large electromagnetic pulse, frying your bot's circuitry. There was no way to avoid it, but you lost. Your termination awaits."); // havent bothered checking if this actually one hits the player
                    playerHealth=0;
                }
                else if(bossMove<15){
                    System.out.println("Grok winds up and unleashes a powerful charged attack, slamming one of its makeshift limbs into the side of your bot. You sustain a large amount of damage.");
                    playerHealth-=35;
                }
                else{
                    damage = 10 + randInt.nextInt(11);
                    System.out.println("Grok strikes you, dealing " + damage + " damage.");
                    playerHealth-=damage;
                }
            }

            // block
            else if(choice==2){
                System.out.println("\n\nYou charge up your shield...");

                // success
                if(randInt.nextInt(5)>0){
                    heal = 5 + randInt.nextInt(11);
                    System.out.println("It works without failure. You block Grok's attack and heal " + heal + " HP.");
                    playerHealth+=heal;
                    // ensure player health does not exceed 100
                    if(playerHealth>100){
                        playerHealth=100;
                    }
                }
                // failure
                else{
                    System.out.println("It fails you.");
                    bossMove = randInt.nextInt(100);

                    // determines boss move, again
                    if(bossMove==0){
                        System.out.println("Grok unleases a large electromagnetic pulse, frying your bot's circuitry. There was no way to avoid it, but you lost. Your termination awaits.");
                        playerHealth=0;
                    }
                    else if(bossMove<15){
                        System.out.println("Grok winds up and unleashes a powerful charged attack, slamming one of its makeshift limbs into the side of your bot. You sustain a large amount of damage.");
                        playerHealth-=35;
                    }
                    else{
                        damage = 10 + randInt.nextInt(11);
                        System.out.println("Grok strikes you, dealing " + damage + " damage.");
                        playerHealth-=damage;
                    } 
                }
            }
        }

        System.out.println("\n--------");
        // different messages for separate battle outcomes. kinda dark ending losing the fight, but it is what it is.
        if(bossHealth<=0){
            System.out.println("Grok has sustained enough damage to cease functioning. Its deep glowing red eyes slowly dim as it loses sentience. You have won this battle, and the human rebellion now stands a fighting chance. Great work, user.");
        }
        else if(playerHealth<=0){
            System.out.println("Your poor bot has become too damaged, and Grok lands a final blow, transmission lost. As you stare into the now static monitor in front of you, the realization that humanity's last hope passing has kicked in. You likely do not have much time left. Your efforts were in vain, and humanity will likely never be able to fight back again.\n\n\nGoodbye, world.");
        } 
    }

    // scene five: secondary path from scene one, three options
    public static void sceneFive(){
        // checks origin
        if(fromOne){
        System.out.println("\n\nYou head off on a side path across the barren city you found yourself in. The sights are concerning, but you have a mission to accomplish.");
        System.out.println("You notice the path splits three separate ways. It could be worth exploring them, but you feel time may be running short. ");
        }
        
        else{
            System.out.println("\n\nYou return to the diverging paths.");
        }
        fromOne=false;

        // prompt user input
        System.out.println("Choose a path: ");
        System.out.println("1. A road littered with rubble and demolished cars out to a mysterious, burning forest.");
        System.out.println("2. Scale a building to get a better view of the area.");
        if(visitedEight){
            System.out.println("(You get a bad feeling about returning to that one)"); // previous user decision, if you know you know
        }
        System.out.println("3. Continue down the road you are already on.");
        System.out.println("4. Return to previous scene.");
        System.out.print("Your move:  ");

        // validates input
        int choice = sc.nextInt();
        while(choice>4 || choice<1){
            System.out.print("\nInvalid choice. Try again:  ");
            choice = sc.nextInt();
        }

        // next scene using switch cases!!! woo!!! (idk why i didnt do if else but it's what it's)
        switch(choice){
            case 1:{
                sceneSix();
                break;
            }
            case 2:{
                sceneEight();
                break;
            }
            case 3:{
                sceneNine();
                break;
            }
            case 4:{
                sceneOne();
                break;
            }
        }
    }

    // scene six: the first side path from scene five. discover some lore and only leads to scene seven
    public static void sceneSix(){
        if(fromSeven){
            System.out.println("\n\nYou find yourself back in the forest. The strange noises still speak from behind you.");
        }
        else{
        System.out.println("\n\nYou cautiously travel down the other road. The city lay barren and destroyed. You had to navigate around several obstacles carefully, but you eventually made it to the forest. Ashes and smoke fill the air, but your bot fortunately does not need to breathe.");
        System.out.println("A faint buzzing and chirping is heard from a small break in some thick shrubbery.");
        }

        // prompt user input
        System.out.println("1. Follow the strange noise.");
        System.out.println("2. Trace your steps back to the city.");
        System.out.print("Your move:  ");

        // validate input
        int choice = sc.nextInt();
        while(choice>2 || choice<1){
            System.out.print("\nInvalid choice. Try again:  ");
            choice = sc.nextInt();
        }

        // progress to next scene
        if(choice==1){
            sceneSeven();
        }
        else if(choice==2){
            sceneFive();
        }
    }
    
    // scene seven: present the option to join the side of the AI (does not end well). Also allows for searching for the key.
    public static void sceneSeven(){
        // checks origin
        if(fromSeven){
            System.out.println("\nYou stop searching the area.");
        }
        else{
            System.out.println("\n\nA small outpost of bots is the source of the noises. They don't appear to mind your presence, if you notice them at all. The area looks like it may have something useful.");
        }
        fromSeven=true;

        // prompts input
        System.out.println("You have three options:");
        System.out.println("1. Search the area for anything useful. (" + search7 + "/5 attempts)");
        System.out.println("2. Consult the group of enemy bots, asking if you can join their side.");
        System.out.println("3. Return to previous scene.");
        System.out.print("Your move: ");

        // validates input
        int choice = sc.nextInt();
        while(choice>3 || choice<1){
            System.out.print("\nInvalid choice. Try again:  ");
            choice = sc.nextInt();
        }
        // exactly the same search function as in scene 3, but with a 12.5% chance per attempt for a maximum of 5 attempts (spicing things up)
        // yes, that does mean both ways of getting the key could fail, softlocking the user from that ending. but thats the point of gambling, baby!
        if(choice==1)
        {
            while(search7<5 && !hasKey)
            {
                search7+=1;
                System.out.println("You search the area...");
                // success, 1 in 8 (12.5%)
                if(randInt.nextInt(8)==0){
                    System.out.println("Oh! You found a strange looking, rusty key. Maybe this could be used for something.");
                    hasKey = true;
                    break;
                }
                // failure
                else{
                    System.out.println("You didn't find anything of value.");
                    System.out.print("Search again? (1: yes, 2: no): ");
                    if(hasKey){
                        break;
                    }
                    else if(sc.nextInt()==1){
                        continue;
                    }
                    else{
                        break; // defaults to this for any integer input other than 1, i aint checking if i dont have to
                    }
                }
            
            // prevents extra searching
            }
            if(hasKey){
                System.out.println("You sense no need to search the area; you already have a key.");
                sceneSeven();
            }
            else if(search7>=5){
                System.out.println("There doesn't seem to be anything in the area.");
                sceneSeven();
            }
            else{
                sceneSeven();
            }
            
        }
        
        // move to next scenes
        if(choice==2){
            endingTwo();
        }
        else if(choice==3){
            sceneSix();            
        }
    }
    
    // scene eight: second side path from scene five: a dead end, minigame to escape
    public static void sceneEight(){
        int a, b, guess;
        if(visitedEight){
            System.out.println("\nNow, you must either really enjoy simple multiplication or are a clueless little soul to decide to return and do this again. Well, can't be mad at me; you asked for it.\n\n");
        }
        else{
        System.out.println("\nOn top of the building, a strange bug sitting on a chair confronts you. It can speak to you, telling you that you cannot leave until you correctly answer a few multiplication questions.");
        System.out.println("You feel a wave of frustration overcome you. ");
        }

        visitedEight=true;
        // 10 answers needed (i am so evil >:) )
        for(int i=1; i<11; i++){
            // generates two random numbers between 1 and 20
            a=1+randInt.nextInt(20);
            b=1+randInt.nextInt(20);

            // tortures the user by asking for the product of the two above numbers
            System.out.println(i + " out of 10");
            System.out.println("The bug asks in a mocking tone: What is " + a + " times " + b + "?");
            System.out.print("Your answer:  ");
            guess = sc.nextInt();

            // checks answer, only continues if correct
            while(guess!=a*b){
                System.out.println("Wrong!");
                System.out.println("Your hatred for arithmetic grows.");
                System.out.print("Guess again: ");
                guess = sc.nextInt();
            }
            System.out.println("Correct!\n"); 
        }       
    
        // exit once the user passes
        System.out.println("Now that ordeal is over with, you decide to get off of the building, reasonably upset at having to pull out your calculator.");
        System.out.println("Seriously, what was this bug trying to do?");
        sceneFive();
    }

    // scene nine: third side path from scene five: path splits
    public static void sceneNine(){
        if(fromTen||fromEleven){
            System.out.println("\nYou return to the intersection.");
        }
        else{
            System.out.println("\n\nThe road leads to an intersection, one path leads to an alleyway, the other to an odd building.");
        }
        

        System.out.println("You have three options:");
        System.out.println("1. Go to the alleyway.");
        if(fromTen){
            System.out.println("(You probably won't find anything here.)");
        } 
        System.out.println("2. Head towards the strange building.");
        if(fromEleven && !hasKey){
            System.out.println("(You should consider finding a key if you haven't already)");
            if(search3==3&&search7==5){System.out.println("...though you realize that there doesn't seem to be a key anywhere.");} 
        }
        
        System.out.println("3. Return back down the road.");

        fromTen=false;
        fromEleven=false;

        int choice = sc.nextInt();
        while(choice>4 || choice<1){
            System.out.print("\nInvalid choice. Try again:  ");
            choice = sc.nextInt();
        }

        if(choice==1){
            sceneTen();
        }
        else if(choice==2){
            sceneEleven();
        }
        else if(choice==3){
            sceneFive();
        }
    }

    // scene ten: full dead end, pretty useless. 
    public static void sceneTen(){
        fromTen=true;
        System.out.println("\n\nWell, there doesn't appear to be anything in the alleyway. You decide to head back.");
        sceneNine();
    }

    // scene eleven: a strange door, use the rusty key found in scene 3 or 7 to unlock secret ending (probability based)
    public static void sceneEleven(){
        fromEleven=true;
        System.out.println("\n\nEntering the building, a most odd sight greets you. A large door is present down a large flight of stairs. The door seems locked and is too sturdy to bust open.");
        if(hasKey){
            System.out.println("You could try to use the key you found to unlock the door. Do you try? (y/n)");
            sc.nextLine();
            if(sc.nextLine().equalsIgnoreCase("y")){
                System.out.println("After some fiddling, the key unlocked the door. Pushing the door opens reveals a dimly lit area: a long, foreboding hallway. It is unclear what lies at the end, but nevertheless you proceed.");
                System.out.println("After a few minutes of cautiously continuing down the dust-ridden hallway, it opens up into a large room with a lever on a wall, dimly lit by a single light above. Approaching the lever, the words \"Master Reset\" appear. It is unsure what will happen if you push the lever, but it sounds like it would take down Grok.");
                System.out.println("Do you wish to pull the lever? (y/n)");
                if(sc.nextLine().equalsIgnoreCase("y")){
                    endingThree();
                }
                else{
                    System.out.println("\nYour anxiety must have gotten the better of you, and you decide to turn back and run back out into the street.");
                    sceneNine();
                }
            }
            else{
                System.out.println("You decide against opening the door and turn back.");
                sceneNine();
            }
        }
        else{
            System.out.println("The path ahead doesn't seem accessible without this strange key. Maybe try searching a few areas to find one.\nYou decide to turn back.");
            sceneNine();
        }
    }


    // ending from scene seven, didn't bother typing it all in there
    public static void endingTwo(){
        System.out.println("\n\nFor whatever reason against your better judgement, you decide to see if you can join the enemy team. However, you must have forgotten that you are under surveillance by the Human Rebellion, and several armed guards storm the room and execute you on the spot.");
        System.out.println("The humans cannot accept submission, anyone who does is merely expendable to them. Your act of treason was a rare decision, but nonetheless intolerable. You have failed the human race.");
        System.out.println("\n\nGoodbye, world.\n\n");
    }

    public static void endingThree(){
        System.out.println("\n\nYou decide to pull the lever, and after much force, it finally budges. A click is heard, then suddenly all of the power in your room shuts off. Some screams of confusion eminate from the rooms behind you, so you get up to see what is going on.");
        System.out.println("Upon grabbing an emergency flashlight, you leave your now unguarded room to see what is going on. All of the lights in the other rooms also appear to have gone out.");
        System.out.println("You and a few guards decide to exit the bunker to examine if anything from the outside world has changed. Upon resurfacing after using the emergency staircase, you notice that none of the lights are on anywhere else.");
        System.out.println("The switch must have killed the power to the city, if not the whole world. You hear a loud clash off in the distance, and conclude it must be Grok's now powerless form crash to the ground.");
        System.out.println("You don't know what to make of it, but now the humans are free. Society must begin from a primitive state, but you no longer must hide to survive. The big tech companies are all inoperable. The humans have won in a most peculiar and unintentional way.");


        System.out.println("\n\nHello, new world.\n\n");
    }
}
/*
 * planning:
 * 
 * starting scene, branches into main and side
 * 
 * 
 *     main       start      side  
 *                  1
 *       2                    5
 *     3   4        6     8       9
 *                  7          10    11(secret)
 * 
 * endings:
 * 4: boss fight, win or lose 
 * 7: defect to the enemy team, betraying the humans. you still die
 * 11: secret, find key in one of two areas (randomized in a search feature),  discover the power source, disable all ai at the cost of the world electricity grid
 *      search locations: 3 (20%/search, 3 tries), 7 (12.5%/search, 5 tries)
 * secret ending is probability based, but its there 
 */