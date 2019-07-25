public class RPG
{
  
  public static void main (String args[])
  {
    new RPG();
  }
  
  public RPG()
  {
    Intro();
    Start();
    Questions();
    //TrainDesc(); //add in ascii and text
    Questions2();
    Juice();
    BlackJack();
    Night();
    Castle();
    InCastle();
    //add this game is better by reading, and asking uqestuions, also add a name ascii
  }
  
  public void Intro()
  {
    System.out.println("Howdy, the names McCree. Man these last few days have been ... interesting to say the least.");
    //ASCII MCCREE
    System.out.println("Well, I guess I should start from the beggining.");
    System.out.println("Your boy McCree, used to be a gun trafficker, in the Deadlock Gang.");
    System.out.println("Man, I never knew what I was doing or why I did it....");
    System.out.println("Recently I was caught up in a sting operation by a goverment force called Overwatch.");
    System.out.println("I expected to rot away in jail, but I guess the heavens sent me another chance to repent.");
    System.out.println("That chance, was for me to join Blackwatch a covert-ops branch of Overwatch.");
    System.out.println("That was the start of one of the greatest adventures of my life.");
    System.out.println("It all started with Commander Morrison running in the Overwatch HQ, like an idiot.");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    return;
  }
  
  public void Start()
  {
    //ASCII OF HQ
    System.out.println("Overwatch HQ, several very tall white buildings, with a giant staue of Commander Morrison");
    System.out.println("Morrison: *huffs* Those Shimada, they keep trying to assassinate several figure heads.");
    System.out.println("3 TIMES IN THE LAST WEEK REYES, I CAN'T ANYMORE");
    System.out.println("Oh, hi McCree how do you like Overwatch?");
    //choice
    System.out.println("");
    System.out.println("Regardles.... Reyes.....");
    System.out.println("TAKE THE NEWBIE AND GO GET ANY INFORMATION ON THEM YOU CAN!");
    System.out.println("");
    System.out.println("*Ana walks in*");
    System.out.println("Ana: Ah, you must be the new Blackwatch member, uh what was your name again? ");
    System.out.println("Was it McBee, wait no.... McGee, OH WAIT I GOT IT");
    System.out.println("McTree THAT'S WHAT IT WAS!");
    // choice name
    System.out.println("");
    System.out.println("Ana: Wait Reyes, I heard you're going looking for the Shimada.");
    System.out.println("A word of advice, don't stick your head where it shouldn't be.");
    System.out.println("For you newbie, just don't die *giggles*");
    System.out.println("*Ana exits room and winks at Morrison*");
    System.out.println("");
    System.out.println("Reyes: *Scoffs*, McCree we better get going *marches out of the room*");
    
  }
  public void Train()
  {
    //ascii
    System.out.println("We enter a huge over the top train");
    System.out.println("");
  }
  public void Questions()
  {
    char Questions = 'n';
    Questions = IBIO.inputChar("Reyes: So McCree, you got any questions about Overwatch? (y/n)");
    char HQ = 'N';
    char OQ = 'N';
    char AskQ ='N';
    while (Questions == 'y' || Questions == 'Y')
    {
      char Questionsp2 = IBIO.inputChar("Heros or Overwatch? (H/O)(n to quit)");
      
      if (Questionsp2 == 'n' || Questions == 'N')
      { Questions = 'n';}
      while (Questionsp2 == 'h' || Questionsp2 == 'H')
      {
        
        HQ = IBIO.inputChar("Who do you want to know about? (Ana (A)/ Reyes (R) / Morrison (M)/ Quit (n)");
        if (HQ == 'A' || HQ == 'a')
        {AskQ ='Y';
          System.out.println("Reyes: Ah, Ana, she’s a feisty one. She is currently the second in command, below me and Morrison.");
          System.out.println("She is an extremely well-known sniper who fought for the freedom fighters back in Egypt.");
          System.out.println("The scariest thing about her, is her drive to make the world a safer place…. She is not afraid to do anything as long as she is getting closer to her goal.");
          System.out.println("");
        }
        else if (HQ == 'M' || HQ == 'm')
        {AskQ ='Y';
          System.out.println("Reyes: Morrison, he was a part of the Super Soldier Program with me. We trained together and as of now he is currently my closest friend.");
          System.out.println("We had to work together in order to start Overwatch and keep it alive during the crisis.");
          System.out.println("He is a true model soldier, someone who believes in an ideal image of the world, and slowly works toward it.");
          System.out.println("He is a true model soldier, someone who believes in an ideal image of the world, and slowly works toward it.");
          System.out.println ("He is a bit of a show boat, but to be honest, he just looks pretty.");
          System.out.println ("Trust me I’m not jealous of him.");
          System.out.println("");
        }
        else if (HQ == 'R' || HQ == 'r')
        {AskQ ='Y';
          System.out.println("Reyes: Oh me? well I’m a war veteran until I was asked to join the Super Soldier Program, in which I trained hard and met Morrison. ");
          System.out.println("We were both asked to form a new organization to help save the world.");
          System.out.println("During that time, I made friends which I will never forget. I’m not as pretty as Morrison so I handle all of the “other” stuff, but I’m fine with it as long as it’s making a difference in the world.");
          System.out.println("");
          
        }
        else
        {Questionsp2 = 'n'; }
      }
      while (Questionsp2 == 'o' || Questionsp2 == 'O')
      {
        
        HQ = IBIO.inputChar("What you want to know ? (Overwatch? (O)/ Omnic Crisis (C) / Super Soldeir Program (S)/Quit (n)");
        if (HQ == 'O' || HQ == 'o')
        { AskQ ='Y';
          System.out.println("Reyes: Overwatch is an organization which is tasked in ensuring world peace. During the Omnic Crisis, there was no one to look out for the people, so Overwatch was formed.");
          System.out.println("We fought against the Omnics to keep the world safe. Even after the crisis, there was no real governing force to ensure safety of the people, so Overwatch took over.");
          System.out.println("Overwatch is split into 2 main divisions, Overwatch and Blackwatch. Morrison runs Overwatch and talks to the public, ");
          System.out.print("I on the other hand take care of the dirty work that is not seen by the public.");
          System.out.println("");
        }
        else if (HQ == 'C' || HQ == 'c')
        { AskQ ='Y';
          System.out.println("Reyes: The Omnic Crisis was a period in time in which robots created by humans, which were previously thought to be broken started working again. ");
          System.out.println("These robots started to rebel, and due to their design (Military bots), they started causing mass destruction all throughout the world. ");
          System.out.println("Due to the quality of the bots, and their intelligence it was almost as if fighting against indestructible super humans.");
          System.out.println("");
        }
        else if (HQ == 's' || HQ == 'S')
        {AskQ ='Y';
          System.out.println("Reyes: The Super soldier program was a program that took regular people and turned them into super soldiers. ");
          System.out.println("The training program was rigorous, but the results were worth it as they gained super human speed, strength, agility and stamina.");
          System.out.println("Some also got implants that made them bionic, further enhancing their powers.");
          System.out.println("");
        }
        else
        {Questionsp2 = 'n'; }
      }
    }
    if (AskQ == 'N')
    {System.out.println("Reyes: You must have read up on Overwatch HAHAHHAHAH!");}
    else
    {System.out.println("Reyes: Hope you feel a bit more informed.");}
    return;
  }
  
  public void Questions2()
  {
    char Questions2 = IBIO.inputChar("You got any questions about the mission? (y/n)");
    char AskQ2 = 'N';
    while (Questions2 == 'y' || Questions2 == 'Y')
    {
      char Questions2p2 = IBIO.inputChar("What's the plan (P)/Shimada? (S)/ What is the mission? (M)/ Quit (N)");
      if (Questions2p2 == 'P'|| Questions2p2 =='p')
      {AskQ2 = 'Y';
        System.out.println("Reyes: Well, to be honest with you I have no clue.");
        System.out.println("McCree: ...");
        System.out.println("Reyes: Well I’m sure we will find something eventually ;)");
        System.out.println("");
      }
      else if (Questions2p2 == 'S'|| Questions2p2 =='s')
      {AskQ2 = 'Y';
        System.out.println("Reyes: The Shimada clan, one of the most notorious gangs currently. They are a clan of highly trained assassins and warriors.");
        System.out.println("They specialize in assassination as well as weapon trafficking. You can tell if someone is a part of the Shimada clan as they have a dragon tattoo somewhere on their body.");
        System.out.println("We currently don’t know who their leader is or where they reside, but that’s what we are for.");
        System.out.println("");
      }
      else if (Questions2p2 == 'M'|| Questions2p2 =='m')
      {AskQ2 = 'Y';
        System.out.println("Reyes: We are looking for any clues on the Shimada. Currently we know nothing and they are a big threat to us. ");
        System.out.println("Anything we can find will be helpful in tracking them down and ending their crime spree.");
        System.out.println("");
        
      }
      else
      {Questions2 = 'n';}
    }
    if (AskQ2 == 'N')
    {System.out.println("Looks like I picked a real perceptive one AHAHAHHAHAHA!");}
    else 
    {
      System.out.println("That's all I got for you");
    }
    return;
  }
  public void Juice()
  {
    System.out.println("*Waiter walks by*");
    char WJ = IBIO.inputChar("Waiter: Would you two like some cranberry juice? (y/n)");
    if (WJ == 'Y' || WJ == 'y')
    {
      System.out.println("McCree: Yes");
      System.out.println("Reyes: I would like one too");
      System.out.println("Waiter: Here you go");
      System.out.println("");
      
    }
    else
    {
      System.out.println("Reyes: I would like one, my partner here is a bit of a mood killer");
      System.out.println("Waiter: Here you go");
      System.out.println("");
    }
    System.out.println("*McCree spots a peculiar tattoo on the waiter*");
    System.out.println("McCree: That's quite the interesting tattoo you got there.");
    System.out.println("McCree: What is your tattoo?");
    System.out.println("Waiter: *nervously* it's a drago....n fly!, from my homeland");
    System.out.println("*Waiter hurries away*");
    System.out.println("");
    System.out.println("McCree and Reyes: We better follow him!");
    System.out.println("Reyes: Looks like you will fit in just right kiddo, HAHAH!");
    System.out.println("");
    
    return;
  }
  public void BlackJack()
  {//add in game
    //add in exit
  }
  public void Night()
  { //print out banner
    System.out.println("*ALL PASSENGERS MUST GET OFF NOW, THIS IS THE LAST STOP!*");
    System.out.println("");
    System.out.println("As I gaze outside the night is pitch black, barely illuminated by the streetlights");
    System.out.println("Reyes: We better get off and follow that guy, as of now he is our only lead.");
    System.out.println("McCree: You know you could have planned it better.");
    System.out.println("Reyes: God damn it, just blame Morrison.");
    System.out.println("");
    
    char Wait = IBIO.inputChar("Damn, that guy is taking his sweet time to leave, should we go now? (y/n)");
    if (Wait == 'y'|| Wait == 'Y')
    {
      System.out.println("You both jump out preemptively, and end up warning the waiter, who starts running");
      System.out.println("As you persue the waiter, he throws a grenade"); //minus 30 health
      System.out.println("Reaper Catches up to him and knocks him out, then takes his apartment key.");
      System.out.println("");    
    }
    
    else 
    {
      System.out.println("You wait a bit and then leave and the waiter doesn't see you following him.");
      System.out.println("You stealthly follow him and knock him out and get his apartment key.");
      System.out.println("");
    }
    System.out.println("Reyes: Ok, lets go quickly, and find some leads in his apartment.");
    return ; //need to return health
  }
  
  public void Apartment() //take in health as parameter
  {
    System.out.println("McCree: Look, I found a letter.");
    System.out.println("Reyes: Go on open it.");
    System.out.println("McCree: I think we got our way in, Reyes.");
    System.out.println("Reyes: Where?");
    System.out.println("McCree: No clue I have to decipher it first.");
    System.out.println("Reyes: Great, why couldn't they just be more straightforward with these things. Whats the riddle?");
    System.out.println("McCree: With a halo of water, the tongue of wood, and stone skin, what am I?");
    System.out.println("Reyes: I was never the sharpest tool in the shed, so looks like your gonna have to do it .");
    System.out.println("");
    Riddle1();
    System.out.println("Reyes: A castle?");
    System.out.println("McCree: Ya");
    System.out.println("Reyes: WHICH ONE, DO YOU KNOW HOW MANY CASTLES THERE ARE IN THIS WORLD!");
    System.out.println("McCree: It also says it is located at the at the belly of the beast.");
    System.out.println("Reyes: How fitting for the Shimada clan, so close to us yet we look over it.");
    System.out.println("McCree: Where is it?");
    System.out.println("Reyes: The Shimada clan once owned a Castle called Shimada Castle, it must be there.");
    System.out.println("McCree: Let's get going.");
    System.out.println("Reyes: WAIT! I hear someone outside.");
    System.out.println("");
    Choice2();
    System.out.println("Reyes: Another Shimada.");
    System.out.println("McCree: Looks like he had a package on him, it says do not open.");
    System.out.println("Reyes: Really? Give it here *opens*");
    System.out.println("McCree: It's a key?");
    System.out.println("Reyes: It's just a key. I thought it would be cooler.");
    System.out.println("McCree: Can I see? *gets it* OWOWOWOW");
    System.out.println("Reyes: What? It hurts, it feels fine to me. Weird, I will keep it then.");
    System.out.println("McCree: Look there is a safe here, it says only a Shimada can open it safely. It says \"Rejuvenation Potion\" inside.");
    System.out.println("");
    Potion();
    System.out.println("Reyes: McCree stop fooling around lets go, before more goons come.");
    System.out.println("");
    return; //return health
  }
  
  public void Riddle1()
  {
    char isCorrect = 'n';
    while (isCorrect == 'n')
    {
      String guess = IBIO.inputString("Enter your guess: ");
      if (guess.equalsIgnoreCase("castle"))
      {
        isCorrect = 'y';
      }
      else
      {
        System.out.println("Reyes: I think you may want to think it over again...");
        System.out.println("");
      }
    }
    return; //add in a return tries, to see how bad player is
  }
  
  public void Choice2()//take health parameter
  {
    char Choice2 = IBIO.inputChar("Reyes: It's up to you newbie!, Fight or Hide? (F/H) ");
    
    if (Choice2 == 'f' || Choice2 == 'F')
    {
      System.out.println("McCree: We jump him as he opens the door...");
      System.out.println("McCree: 3"); //add delay
      System.out.println("McCree: 2");
      System.out.println("");
      System.out.println("McCree and Reyes pounce on the unsuspecting intruder, and knock him out");
      System.out.println("");
      
    }
    else 
    {
      System.out.println("McCree: We hide, when he leaves we jump him..");
      System.out.println("*both hide*");
      System.out.println("*Man enters room and sees opened letter, as well as no one in the room, and gets suspicious*");
      System.out.println("*Man starts looking around and finds you!*");
      System.out.println("*you get him by one hell of a punch to the gut*"); //-40 health
      System.out.println("*Reaper jumps on him while he mocks you, and knocks him out*");
      System.out.println("");
      
    }
    return; //return health
  }
  
  public void Potion() //health parameter
  {
    char wtry = IBIO.inputChar("Should I try to open it? (y/n)");
    
    if (wtry == 'y' || wtry == 'Y')
    {
      //add randomizer
      char works = 't';
      if ( works == 't')
      {
        System.out.println("To your suprise, the vault opens and you are presented with a liquid");
        System.out.println("Being the smart individual you are, you gulp it down with no hesitation"); //+ 50 health
        System.out.println("");
      }
      else
      {
        System.out.println("The vault electrocutes and cripples you."); //- 30 health
        System.out.println("You decide to leave it to prevent more brain damage to yourself.");
        System.out.println("");
      }
    }
    return; //return health
  }
  public void Castle () //take health as paramter
  {
    System.out.println("McCree: Where to, Reyes?");
    System.out.println("Reyes: The mouth of the dragon in the temple, that is the where an entrance would be if there was one around here it would be.");
    System.out.println("McCree *to himself*: That is strange, there would be no way for him to just think of the entrance. He has been acting weird since last night. ");
    System.out.println("*Reyes inspects, the dragon painting and finds a knob and opens a hidden door*");
    System.out.println("");
    Riddle2();
    System.out.println("");
    System.out.println("Shimada member: Well done, enter the dragons den. *door opens*");
    System.out.println("*Reyes jumps on the guy behind the door*");
    System.out.println("Reyes: Put the clothes on, were not getting anywhere with these clothes. Also try to hide your arm so they don't see you don't have a tattoo.");
    System.out.println("Reyes: Welcome to the Shimada Castle");
    System.out.println("");
    return; //return health
  }
  public void Riddle2()
  {
    System.out.println(" A voice on the other side, says recite the word to fill in the the Shimada creed, failure will hurt ... literally hehe");
    char ar = 'n';
    char br = 'n';
    char cr = 'n';
    char dr = 'n';
    while (ar == 'n')
    {
      String aguess = IBIO.inputString("The brain is in the body, the ____ is in the heart.");
      
      if (aguess.equalsIgnoreCase("soul"))
      {
        System.out.println("Correct...");
        ar = 'y';
      }
      else
      {System.out.println("WRONG!!");
        //-10 HEALTH
      }
    }
    
    while (br == 'n')
    {
      String bguess = IBIO.inputString("Flow like ____, stand like stone.");
      
      if (bguess.equalsIgnoreCase("water"))
      {
        System.out.println("Correct...");
        br = 'y';
      }
      else
      {System.out.println("WRONG!!");
        //-10 HEALTH
      }
      
    }
    
    while (cr == 'n')
    {
      String cguess = IBIO.inputString("True power is not through weapons, but through the ____.");
      
      if (cguess.equalsIgnoreCase("mind"))
      {
        System.out.println("Correct...");
        cr = 'y';
      }
      else
      {System.out.println("WRONG!!");
        //-10 HEALTH
      }
      
    }
    
    while (dr == 'n')
    {
      String dguess = IBIO.inputString("__n_r the fallen.");
      
      if (dguess.equalsIgnoreCase("honor"))
      {
        System.out.println("Correct...");
        dr = 'y';
      }
      else
      {System.out.println("WRONG!!");
        //-10 HEALTH
      }
      //return health
    }
  }
  
  public void InCastle() //take health as paramter
  {
    System.out.println("McCree: So what exactly are we looking for?");
    System.out.println("Reyes: Any books, training methods, information that would give us insight into the Shimada Clan.");
    System.out.println("");
    TOF();
    System.out.println("");
    System.out.println("Shimada Member: Hey Kiryu, what you doing, shouldn't be at the door waiting for the next Candidate of the dark procession?");
    System.out.println("*You both look at each other in confusion*");
    System.out.println("Shimada Member: You look bit shook, and confused. I know you are new do you need me to explain something?");
    System.out.println("Reyes: That would be appreciated");
    System.out.println("");
    Question2();
    System.out.println("Reyes: Thank you");
    System.out.println("*Clan member walks away*");
    System.out.println("Reyes: McCree we should split up to cover more ground");
    System.out.println("*Reyes leaves in an instant leaving you alone*");
    System.out.println("McCree: Odd he didn't seem like himself, he's acting as if something's possessed him, how unusual. Better go look for anything of use.");
    System.out.println("");
    Battle();
    System.out.println("McCree: Phew, close one. Hmmm whats this vial he had on him?");
    Vial();
    System.out.println("McCree: I wonder how Reyes is doing...");
    System.out.println("");
    System.out.println("*IN REYES HEAD*");
    System.out.println("Unknown Voice: The power you seek, the power you need is right in front of you. ");
    System.out.println("Reyes: Who are you?");
    System.out.println("Unknown Voice: You know you want the power, people always think of you Second to Morrison, the government, other members.... Ana.");
    System.out.println("Unknown Voice: I could give you everything you want, just accept me.");
    System.out.println("*Slowly walks toward a book which exudes a dark aura*");
    System.out.println("Unknown Voice: I only let those who know the pain use the power, you understand what it feels to be unrecognized. Accept me with the key, and you will see the downfall of Morrison.");
    System.out.println("*USES KEY*");
    System.out.println("Reyes: AHHHHHHHH");
    System.out.println(" *Reyes Gasps for air, and collapses to the ground*");
    System.out.println("*Reyes suddenly dissapears into a cloud of smoke and re-apears*");
    System.out.println("Reyes: I feel powerful and invigorated.");
    System.out.println("Unknown Voice: You are now one with the shadows... Reaper .");
    System.out.println("*Reyes now power crazy goes insane and starts destroying everything*");
    System.out.println("");
    System.out.println("*Back to McCree*");
    System.out.println("");
    System.out.println("McCree: I can't find anything, why did they have to be so secretive with their things.");
    System.out.println("*Walks down a hallway, when he hears a shriek*");
    System.out.println("Hanzo: This is for the better of the clan brother!");
    System.out.println("Genji: Hanz.... AHHhhHhHhHHHh");
    System.out.println("Elder: Well done Hanzo, you are now the new head of the Shimada Clan, do not regret, he would have only betrayed us in the end. Truly unfortunate to waste such a specimen of talent.");
    System.out.println("Young master Hanzo you are the fleeting image of your father Sojiro, I'm sure he would be proud. As for him, I'm sure he is dead, I will ask the others to collect and dispose of him later, go rest Hanzo.");
    System.out.println("*Door Closes*");
    System.out.println("*McCree walks in*");
    System.out.println("McCree: What a messed up clan, WAIT this Genji the heir to the throne of the Shimada Clan, and that must have been Hanzo. The story of the 2 brothers...");
    System.out.println("Funny how things work out. Guess Genji could be useful in Overwatch. AHH HOW CAN A NINJA BE SO HEAVY AAAAAAAAAA.");
    System.out.println("McCree: Ok, I think it is time to leave, where is Reyes.");
    System.out.println("*Crashes and loud sounds, along with screaming*");
    System.out.println("McCree: Nevermind, I know.");
    System.out.println("*McCree runs to the location*");
    System.out.println("McCree: He looks different, WAIT he looks like a shadow. What happened....");
    System.out.println("Genji: He was chosen by the book *cough*, it picks a person which it deems worthy. Someone who knows pain and suffering. Looks like he has attained the Shimada's shadow form powers. Truly a formidable foe.");
    System.out.println("McCree: I'm gonna have to stop him.");
    System.out.println("");
    Battle2();
    System.out.println("Genji: You need another Shimada to use a demon spirit to counter his inner demon. Let me try....");
    System.out.println("McCree: WAIT WAIT WAIT, your injured!");
    System.out.println("Genji: *Scoffs* as if that brother of mine could hurt me.");
    System.out.println("Genji: Taste the demon's blade!");
    System.out.println("*Genji unsheathes his sword, as a giant green dragon appears*");
    System.out.println("*He jumps into the air and it looks as if he dashed right through Reyes*");
    System.out.println("*It is as if time freezes and Reyes falls to the floor*");
    System.out.println("McCree: Remind me to never fight you...");
    System.out.println("Genji: Hurry we must go before the other co....");
    System.out.println("McCree: Bit too late now.");
    System.out.println("Genji: I must hide, they can not know I escaped, AHHA that friend of yours is truly skilled he hit me even in demon form......");
    System.out.println("Reyes: *wakes up from rampage* What happened?");
    System.out.println("McCree: Not enough time to explain right now, just get ready to fight, I'll carry this Asian guy.");
    System.out.println("McCree: Looks like we're surrounded, outnumber, but never outgunned *laughs*");
    System.out.println("McCree: I need a distraction Reyes, 5 seconds you got it.");
    System.out.println("Reyes: On it.");
    System.out.println("*Reyes disappears and replaced by a thick fog, and starts causing havoc in their forces, no one can even touch him*");
    System.out.println("McCree:  Looks like it's my turn... IT'S HIGH NOOOOON"); //high noon asciii
    System.out.println("*everybody drops to the ground except one*");
    System.out.println("McCree: Looks like we are all done here.");
    System.out.println("Last member: think again.");
    System.out.println("*Reyes appears from out of nowhere and starts spinning creating a vortex of bullets catching the last member ");
    System.out.println("Genji: *cough* Let us go quickly, ill guide you to the exit.");
    System.out.println("*The trio starts running");
    Choice3();
    System.out.println("");   
    System.out.println("McCree: That was one hell of a first mission, I think I will enjoy my time as part of Blackwatch.");  
    System.out.println("Reyes: So who is this guy?");  
    System.out.println("McCree: The brother of the current Shimada clan leader.");
    System.out.println("Reyes: *SPITS OUT WATER* WHAT");   
    System.out.println("Reyes: Looks like we got to drag him back to Overwatch, maybe Dr. Zeigler can help him.");  
    System.out.println("McCree: Great, after all that happened, I think we found ourself a new Blackwatch member too");  
    System.out.println("Reyes: AHAHHA! Welcome to Overwatch kiddo, no going back now."); 
    System.out.println("");
    System.out.println("*In Reapers Head*");   
    System.out.println("Unknown Voice: Reaper, you won't regret this choice, I will show you true power, such that the world will bend to your will."); 
    System.out.println("Morrison, Ana and that newbie will all see the power that you possess. You currently you don't fully accept me, but I'm sure that eventually, you will learn to accept me fully.");
    System.out.println("As your anger grows, our bond will get stronger as well ...");   
    System.out.println(""); 
    System.out.println("TO BE CONTINUED...");//ADD ASCII 
                    
 

  }
public void Choice3() //health as parameter
{
System.out.println(" *Genji leads them to a cross roads*");
System.out.println("Reyes: Your call newbie....");
char rchoice = IBIO.inputChar("Should we jump out the window (J) or take the stairs (S) ? ");
 if (rchoice == 'j' || rchoice == 'J')
 {System.out.println("*You jump out the window, and look spectacular doing it*");    }
 else if (rchoice == 's' || rchoice == 'S')
 {System.out.println("*You take the stair, while being assualted with spears and rock*");   
 // - 20 health
 }
 else
 {System.out.println("MCCREE THIS IS NO TIME TO EXUDE STUPDITY");    }
 return;
}
public void Battle2()
{ for (int i = 0; i <4; i++)
  {
   char move2 = IBIO.inputChar("What will you do? Shoot(S) / Flashbang(F) / Punch(P)");
     if (move2 == 's' || move2 == 'S')
   {System.out.println("You attempt to shoot him, but he is almost like a shadow and your bullet goes through him....");}
   else if (move2 == 'f' || move2 == 'F')
   {System.out.println("You attempt to flashbang him, but the light gets drowned out by his darkness....");}
   else if (move2 == 'p' || move2 == 'P')
   {System.out.println("You attempt to punch him, but your punch goes right through him....");}
   else 
   {System.out.println("Your stupidity confuses yourself");}
  } 
}
public void Battle () //take health
{}
public void Vial() //take health
{}
public void Question2() //print out ascii 
{
  char conQ = 'y';
  while (conQ == 'y')
  {
    char wQues = IBIO.inputChar("What would you like to know about? Dark Procession(D) / Leader of the clan (L) / Shimada Legend (S) / Power of the Shimada (P) / Quit (n)");
    if (wQues == 'D' || wQues == 'd')
    {
      System.out.println("Our previous clan leader just recently died, and his son wants to take the throne.");
      System.out.println("However, he is too young and immature as of now and we need someone to take care of him and teach him the ways of the Shimada.");
      System.out.println("The person who can use the Shimada shadow form is a person of pain and anguish, someone who knows the cruelty of the world. ");
      System.out.println("This person will be fit to show the young master the world and how it works.");
      System.out.println("");
    }
    else if (wQues == 'L' || wQues == 'l')
    {
      System.out.println("About 1 month ago Sojiro Shimada died, leaving his 2 kids Hanzo and Genji to take his place. ");
      System.out.println("That Hanzo, strong and serious, but Genji, I think he does not care about his fathers legacy. ");
      System.out.println("Either way those 2 will be the future of this clan for the better or the worse.");
      System.out.println("");
    }
    else if (wQues == 'S' || wQues == 's')
    {
      System.out.println("Ah, the old legends. Once there were 2 dragon who ruled the land in harmony, however love turned to quarrel as they fought for power over the land. ");
      System.out.println("After years of devastating fighting to the world below them, 1 of them fell. ");
      System.out.println("The other dragon’s pride soon turned to sorrow as he realised that power was not important.");
      System.out.println("He realised what he had done, which was ruin all that they had. One day a mysterious man appeared before the dragon and asked, “Why do you weep great dragon”. ");
      System.out.println("The dragon responded, “In a fight for power I killed my brother, and now I am left in solitude”. The stranger said that in order to heal he must walk on Earth and fix what he had done.");
      System.out.println("After this the man revealed himself as his brother, with joy in their hearts they both set out to fix the damage that they have caused to the world.");
      System.out.println("Truly a remarkable story, reminds me a bit about those 2 sons Hanzo and Genji……..");
      System.out.println("");
    }
    else if (wQues == 'P' || wQues == 'p')
    {
      System.out.println("The Shimada’s have a very unique ability… the ability to utilize demons. Although only the higher ups are able to manifest these beasts. ");
      System.out.println("I have no clue as to how they learn these techniques but, I would sure like to learn.");
      System.out.println("The Shimada also have several grimoires which contain power, but be careful obtaining one is hard, but controlling it is even harder.");
      System.out.println("");
      
    }
    else if (wQues == 'N' || wQues == 'n')
    {conQ = 'n';}
    else
    {System.out.println("Sorry, what did you say?");}
  }
  return;
}
public void TOF() //take health as parameter
{
  System.out.println("McCree: Hey Reyes, are you ok you seem a bit off since this morning.");
  System.out.println("Reyes: I'm fine just a bit sleepy, but I want to quiz you on something, just to make sure you are awake and ready to go.");
  System.out.println("McCree: Come at me!");
  char a1 ='n';
  char b1 ='n';
  char c1 ='n';
  while (a1 == 'n')
  {
    char tof1 = IBIO.inputChar("I drank mango juice on the train. True(t) or False(f)");
    if (tof1 == 'f')
    {
      System.out.println("Correct, looks like you payed attention, a trademark of a great agent!");
      a1 = 'y';
    }
    else
    {//-10 health
      System.out.println("Reyes slaps you across the face due to your incompetence, and in effort to wake you up");
      a1 = 'y';
    }
  }
  while (b1 == 'n')
  {
    
    char tof2 = IBIO.inputChar("I found a compass in the mysterious package. True(t) or False(f)");
    if (tof2 == 'f')
    {
      System.out.println("Correct, looks like you payed attention, a trademark of a great agent!");
      b1 = 'y';
    }
    else
    {//-10 health
      System.out.println("Reyes slaps you across the face due to your incompetence, and in effort to wake you up");
      b1 = 'y';
    }
  }
  while (c1== 'n')
  {
    char tof1 = IBIO.inputChar("Me and Morrison are the founders of Overwatch. True(t) or False(f)");
    if (tof1 == 't')
    {
      System.out.println("Correct, looks like you payed attention, a trademark of a great agent!");
      c1 = 'y';
    }
    else
    {//-10 health
      System.out.println("Reyes slaps you across the face due to your incompetence, and in effort to wake you up");
      c1 = 'y';
    }
  }
  System.out.println("Reyes: Now that's done, we better get moving....");
  System.out.println("");
  return; //return health
  }
}


