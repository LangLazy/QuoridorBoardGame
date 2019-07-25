//GAME BY RAHUL GUDISE

//GAME QUORIDOR
//A simple and fun 2 player board game, with music animated characters and much more!
//
//***************When referring to walls in the comments it is the same as the whirlpools in the game!******************
//************* In the code red = Player 1 , blue = Player 2 **************************
package GAME;
import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JRadioButton;

public class quoridor extends JFrame {
	//GLOBAL VARIABLES
 Clip clip; //A variable which holds a "clip" or sound. This is used to play sounds in the game.
 Clip win;
 private JPanel contentPane; //Main JPannel which holds everything.
 int row = 17;//The total amount of squares in 1 row of the game, the number of movable squares for the player is row/2 (round up), and the number of whirlpool placements is row - #of player movable spaces
 //this variable allows my code to be flexible so I could have a larger/smaller game of Quoridor if I wanted to change the board size
 JButton btns[][] = new JButton[row][row]; //A button array, this button array is the one responsible for creating the board which you see on the gamescreen
 //the number of buttons made depends on the row variable stated above
 char turn = 'r'; //this keeps track of whose turn it is Player 1 (r) or Player 2 (b), I started it of at r, but it gets re-evaluated later on in the code
 int oldX; //When moving the play around the board it is necessary to know their previous position, so that we can change that spot back to a different texture
 //as well as evaluate if the players action choice (place wall or move) is a valid move in reference to their current position which is kept in these "old variables"
//we have 2 sets of X,Y old variables. Each of the 2 sets is linked to Player 1 or Player 2 respectively 
 int oldY;
 int oldX2; //Second set
 int oldY2;
 JLabel errorM; //A label which will appear on the move dash board if the player tries to make an invalid move
 int boardInt[][] = new int[17][17]; //An integer replication of the button array, this array is directly linked to that array. The button array is more for my visualization where as this integer array
 //is for the computer to be able to see where all of the walls and players and positioned across the board
 // 1 = Player 1
 // 2 = Player 2
 // 3 = Wall
 //This integer array is easier to code with, as it is much simpler to compare to elements of an integer array than it is a button array
 //This array is a major part in my move validity algorithm
 char wallF = 'y'; //During a players turn they can either place a wall or move, when placing walls they get to place 2 pieces of a wall which make 1 complete wall 
 //Players may not place a piece of a wall and try to move, this variable helps keep track of if the player has placed a wall on this turn and restricts their movement based on that
 int oWallX; //Similar to how we had "old" variables to keep track of the position of the players pieces, we have these "old" variables which keep track of the last wall placed
 //This is used to check if the 2 walls are connected as well as if the move is valid
 int oWallY;
 int checkX; //In this game, there is a rule about not being able to block a player in with walls, I have made an algorithm that deduces if the player has been trapped
 //The scanning variable I use to check possibilities and routes are these 2.
 int checkY;
 int saveX;// During a process in my algorithm it requires to save its start coordinate before starting to scan left and right, so that it can return to its original position
 //and scan the other way, these 2 variables are used to store this data
 int saveY;
 int start; //During the initialization of the board, it takes row/2 and that is equal to this value. This is the X-coordinate of the starting position of both player pieces (As they start in front of each other)
    int possibleInt[][] = new int [row][row]; //Just like how we had 2 scanner variables for my algorithm we have this array. This array is a copy of boardInt. When a user decides to place a wall
    //it needs to check if this wall will cause a break in the rules. So it copies boardInt and adds the wall in question and tests to see if that wall causes any issues
    char foundSol = 'n'; //a stopping variable as well as variable from my algorithm from infinitely looping. It also hold the data of if a wall is allowed to be placed
    char reTrace[][] = new char [row][row]; //in my algorithm there are certain scenarios where the algorithm in theory could be caught in an infinite loop
    //this char array prevents that, when the scan variables checkX and checkY move they mark the place as marked to ensure that they do not re-visit the same place again 
    //although sometimes it is needed to continue the algorithm (more on this later)
    private JPanel gameboard; //game board panel
    int turnInt = 1; //My algorithm is a series of steps, however since both players start form different sides of the board and have different end goals some parts of it
    // are different this turnInt keeps track of which players turn it is so that when the algorithm needs to check a walls validity it used the right version of the algorithm
    char redBlock = 'n'; //When placing walls you have to make sure that the player does not block the other player, but also not themselves!, these chars keep track of which of the 2 sides are blocked
    //these values are later used to give the user an error
    char blueBlock = 'n';
    int redWall = 10; //each player starts of with 10 walls, these variables keep track of how may walls a player has.
    int blueWall = 10;
    private JLabel redWallLabel; //Labels and buttons that make up the gui
    private JLabel blueWallLabel;
    private JLabel turnLabel;
    private JButton resetBtn;
    private JPanel cardHolder;
    private JPanel gameScreen;
    private JPanel instructions1;
    private JPanel WinScreen;
    private JPanel options;
    private JButton btnMenu;
    private JButton btnMenu_1;
    private JPanel Title;
    private JPanel instructions2;
    private JPanel instructions3;
    int redWin = 0; //keeps track of the wins of each player
    int blueWin = 0;
 int posR = 0; //A transfer variable
 int posY = 0; //When a button is clicked it's coordinates are taken from it's action command , these coordinates are saved in these variables
 //These variables are used to test out the validity of the players move
 int posX = 0;
 private JLabel gamePlayer1Wins; //More Gui stuff
 private JLabel gamePlayer2Wins;
 private JLabel menuPlayer2Score;
 private JLabel menuPlayer1Score;
 private JLabel winnerPlayer;
 private JLabel winnerName;
 String oneName = "Player 1"; //A string which will keep track of the players names, by default its starts as Player _
 String twoName = "Player 2";
 private JLabel scoreBoard;
 private JLabel menuWinA;//More Gui stuff
 private JLabel menuWinB;
 private JLabel gameWinBanner;
 private JLabel gameWinBanner2;
 private JPanel coinFlip;
 private JLabel rollBack;
 private JTextField getUsername;
 private JTextField getGuess;
 private JLabel winnerLabel;
 private JLabel displayCoin;
 char gameStart = 'n'; //Prevents the user from doing the coin toss again after already doing it once
 private JPanel tailsWin;//More Gui stuff
 private JPanel headWin;
 private JLabel tailBackground;
 private JLabel winnerTail;
 private JLabel winnerHead;
 private JLabel imageHeads;
 private JLabel imageTails;
 String player1Icon = "player1A"; //The way I labeled my images was strategic. The images are in the format	player_ _ .gif, the first blank is for the player number (Each player gets 2 different charachters choices)
 //The second is A or B which means the first of second choice, and the last on is F or G, G being the game board piece and F being the original gif for labels 
 String player2Icon = "player2A";
 private JLabel p1Opt1;//More Gui stuff
 private JLabel p1Opt2;
 private JLabel p2Opt1;
 private JLabel p2Opt2;
 private JTextField oneGetName;
 private JTextField twoGetName;
 private JRadioButton p1Choose1;
 private JRadioButton p1Choose2;
 private JRadioButton p2Choose1;
 private JRadioButton p2Choose2;

 /**
  * Launches the application
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     quoridor frame = new quoridor();
     frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the frame.
  */
 public quoridor() {
          
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Setting up the first frame as well as all of the others, just a lot of initialization and piece placing

  setBounds(100, 100, 1440, 726);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  cardHolder = new JPanel();
  cardHolder.setBounds(0, 0, 1424, 687);
  contentPane.add(cardHolder);
      cardHolder.setLayout(new CardLayout(0, 0));
      
      Title = new JPanel();
      cardHolder.add(Title, "name_1298808970320826");
      Title.setLayout(null);
      
      JLabel banner = new JLabel(createImageIcon("titleBanner.png"));
      banner.setBounds(410, 11, 618, 176);
      Title.add(banner);
      
      JButton playBtn = new JButton(createImageIcon("playButton.png"));
      
      playBtn.setContentAreaFilled(false);
      playBtn.setBorderPainted(false);
      
      playBtn.setActionCommand("options");//
      playBtn.addActionListener(new menu());//
      
      menuWinB = new JLabel("" + blueWin);
      menuWinB.setFont(new Font("Tahoma", Font.PLAIN, 50));
      menuWinB.setBounds(1198, 285, 168, 98);
      Title.add(menuWinB);
      
      menuWinA = new JLabel("" + redWin);
      menuWinA.setFont(new Font("Tahoma", Font.PLAIN, 50));
      menuWinA.setBounds(1198, 131, 168, 83);
      Title.add(menuWinA);
      playBtn.setBounds(1107, 565, 276, 98);
      Title.add(playBtn);
      
      menuPlayer1Score = new JLabel("Player 1");
      menuPlayer1Score.setFont(new Font("Tahoma", Font.PLAIN, 30));
      menuPlayer1Score.setBounds(1140, 61, 386, 46);
      Title.add(menuPlayer1Score);
      
      menuPlayer2Score = new JLabel("Player 2");
      menuPlayer2Score.setFont(new Font("Tahoma", Font.PLAIN, 30));
      menuPlayer2Score.setBounds(1140, 230, 369, 37);
      Title.add(menuPlayer2Score);
      
      scoreBoard = new JLabel(createImageIcon("titleWins.png"));
      scoreBoard.setBounds(937, -31, 533, 494);
      Title.add(scoreBoard);
      
      JLabel background = new JLabel(createImageIcon("menuBackground.gif"));
      background.setBounds(-8, 0, 1442, 687);
      Title.add(background);
      
      WinScreen = new JPanel();
      cardHolder.add(WinScreen, "name_1298808910613934");
      WinScreen.setLayout(null);
      
      JButton menuWinBtn = new JButton(createImageIcon("menuBtn.png"));
      menuWinBtn.setContentAreaFilled(false);
      menuWinBtn.setBorderPainted(false);
      menuWinBtn.setActionCommand("menu");
      menuWinBtn.addActionListener(new menu());
      
      winnerPlayer = new JLabel("");
      winnerPlayer.setBounds(527, 238, 372, 336);
      WinScreen.add(winnerPlayer);
      
      winnerName = new JLabel("New label");
      winnerName.setFont(new Font("Tahoma", Font.PLAIN, 50));
      winnerName.setBounds(558, 109, 341, 46);
      WinScreen.add(winnerName);
      
      JLabel winBanner = new JLabel(createImageIcon("winBanner.png"));
      winBanner.setBounds(234, -3, 957, 749);
      WinScreen.add(winBanner);
      menuWinBtn.setBounds(88, 506, 252, 77);
      WinScreen.add(menuWinBtn);
      
      JButton againWinBtn = new JButton(createImageIcon("playAgain.png"));
      againWinBtn.setContentAreaFilled(false);
      againWinBtn.setBorderPainted(false);
      againWinBtn.setActionCommand("playAgain");
      againWinBtn.addActionListener(new menu());
      againWinBtn.setBounds(85, 594, 255, 82);
      WinScreen.add(againWinBtn);
      
      JLabel Background = new JLabel(createImageIcon("gameBackground.jpg"));
      Background.setBounds(0, 0, 1424, 687);
      WinScreen.add(Background);
      
      gameScreen = new JPanel();
      cardHolder.add(gameScreen, "name_1298808830058666");
      gameScreen.setLayout(null);
      
        gameboard = new JPanel();
        gameboard.setBounds(1, 75, 1013, 612);
        gameScreen.add(gameboard);
        gameboard.setLayout(new GridLayout(17, 17, 0, 0));
        
        resetBtn = new JButton(createImageIcon("resetBtn.png"));
        resetBtn.setActionCommand("reset");
        resetBtn.setContentAreaFilled(false);
        resetBtn.setBorderPainted(false);
        resetBtn.setBounds(173, -10, 197, 85);
        resetBtn.addActionListener( new menu());
        
        gamePlayer1Wins = new JLabel("P1: 0");
        gamePlayer1Wins.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gamePlayer1Wins.setBounds(427, 11, 292, 30);
        gameScreen.add(gamePlayer1Wins);
        
        gamePlayer2Wins = new JLabel("P2:  0");
        gamePlayer2Wins.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gamePlayer2Wins.setBounds(803, 11, 315, 30);
        gameScreen.add(gamePlayer2Wins);
        
        gameWinBanner2 = new JLabel(createImageIcon("gameBannerWin.png"));
        gameWinBanner2.setBounds(191, 3, 687, 72);
        gameScreen.add(gameWinBanner2);
        
        gameWinBanner = new JLabel(createImageIcon("gameBannerWin.png"));
        gameWinBanner.setBounds(570, 3, 678, 72);
        gameScreen.add(gameWinBanner);
        gameScreen.add(resetBtn);
        
          errorM = new JLabel("");
          errorM.setBounds(1092, 453, 292, 96);
          gameScreen.add(errorM);
          errorM.setFont(new Font("Tahoma", Font.PLAIN, 14));
          
          turnLabel = new JLabel(oneName +"'s turn");
          turnLabel.setBounds(1131, 123, 217, 38);
          gameScreen.add(turnLabel);
          turnLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
          
          blueWallLabel = new JLabel(twoName +"'s whirlpools left: " + blueWall);
          blueWallLabel.setBounds(1110, 362, 258, 21);
          gameScreen.add(blueWallLabel);
          blueWallLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
          
          redWallLabel = new JLabel(oneName +"'s whirlpools left: " + redWall);
          redWallLabel.setBounds(1110, 330, 258, 21);
          gameScreen.add(redWallLabel);
          redWallLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
          
          JLabel lblQuoridor = new JLabel(createImageIcon("gameBanner.png"));
          lblQuoridor.setBounds(1016, 596, 391, 146);
          gameScreen.add(lblQuoridor);
          lblQuoridor.setFont(new Font("Tahoma", Font.BOLD, 50));
          
          JLabel textGame = new JLabel(createImageIcon("textBorder.png"));
          textGame.setBounds(1006, 64, 451, 546);
          gameScreen.add(textGame);
          
          JButton instructionBtn = new JButton(createImageIcon("instructionBtn.png"));
          instructionBtn.setContentAreaFilled(false);
          instructionBtn.setBorderPainted(false);
          instructionBtn.setActionCommand("instructions");
          instructionBtn.addActionListener( new menu ());
          instructionBtn.setBounds(-14, 3, 195, 61);
          gameScreen.add(instructionBtn);
          
          btnMenu = new JButton(createImageIcon("menuBtn.png"));
          btnMenu.setContentAreaFilled(false);
          btnMenu.setBorderPainted(false);
          btnMenu.setActionCommand("menu");
          btnMenu.addActionListener(new menu());
          btnMenu.setBounds(1109, -19, 259, 96);
          gameScreen.add(btnMenu);
          
          JLabel gameBackground = new JLabel(createImageIcon("gameBackground.png"));
          gameBackground.setBounds(0, 0, 1424, 687);
          gameScreen.add(gameBackground);
      
      options = new JPanel();
      cardHolder.add(options, "name_1298808940390760");
      options.setLayout(null);
      
      twoGetName = new JTextField();
      twoGetName.setBounds(1014, 455, 184, 20);
      options.add(twoGetName);
      twoGetName.setColumns(10);
      
      oneGetName = new JTextField();
      oneGetName.setBounds(430, 455, 187, 20);
      options.add(oneGetName);
      oneGetName.setColumns(10);
      
      p1Opt1 = new JLabel(createImageIcon("player1AF.gif"));
      p1Opt1.setBounds(231, 472, 203, 159);
      options.add(p1Opt1);
      
      p1Opt2 = new JLabel(createImageIcon("player1BF.gif"));
      p1Opt2.setBounds(471, 439, 203, 175);
      options.add(p1Opt2);
      
      p2Opt1 = new JLabel(createImageIcon("player2AF.gif"));
      p2Opt1.setBounds(754, 486, 197, 128);
      options.add(p2Opt1);
      
      p2Opt2 = new JLabel(createImageIcon("player2BF.gif"));
      p2Opt2.setBounds(984, 455, 187, 159);
      options.add(p2Opt2);
      
      JButton playGame = new JButton(createImageIcon("playButton.png"));
      playGame.setContentAreaFilled(false);
      playGame.setBorderPainted(false);
      playGame.setActionCommand("check");
      playGame.addActionListener(new menu());
      
      p1Choose1 = new JRadioButton("New radio button");
      p1Choose1.setContentAreaFilled(false);
      p1Choose1.setBorderPainted(false);
      p1Choose1.setBounds(441, 539, 18, 23);
      options.add(p1Choose1);
      
      p1Choose2 = new JRadioButton("");
      p1Choose2.setContentAreaFilled(false);
      p1Choose2.setBorderPainted(false);
      p1Choose2.setBounds(680, 539, 18, 23);
      options.add(p1Choose2);
      
      p2Choose1 = new JRadioButton("");
      p2Choose1.setContentAreaFilled(false);
      p2Choose1.setBorderPainted(false);
      p2Choose1.setBounds(957, 539, 21, 23);
      options.add(p2Choose1);
      
      p2Choose2 = new JRadioButton("");
      p2Choose2.setContentAreaFilled(false);
      p2Choose2.setBorderPainted(false);
      p2Choose2.setBounds(1177, 539, 21, 23);
      options.add(p2Choose2);
      playGame.setBounds(984, 11, 244, 100);
      options.add(playGame);
      
      btnMenu_1 = new JButton(createImageIcon("menuBtn.png"));
      btnMenu_1.setContentAreaFilled(false);
      btnMenu_1.setBorderPainted(false);
      btnMenu_1.setActionCommand("menu");
      btnMenu_1.addActionListener(new menu());

      btnMenu_1.setBounds(194, 21, 271, 73);
      options.add(btnMenu_1);
      
      JLabel optBack = new JLabel(createImageIcon("optBack.png"));
      optBack.setBounds(0, -1, 1424, 687);
      options.add(optBack);
      
      instructions1 = new JPanel();
      cardHolder.add(instructions1, "name_1396543813495887");
      instructions1.setLayout(null);
      
      JButton btnBackToThe = new JButton(createImageIcon("backBtn.png"));
      btnBackToThe.setContentAreaFilled(false);
      btnBackToThe.setBorderPainted(false);
      btnBackToThe.setActionCommand("game");
      btnBackToThe.addActionListener(new menu());
      btnBackToThe.setActionCommand("game");
      btnBackToThe.addActionListener(new menu());
      
      JButton btnNext = new JButton(createImageIcon("nextBtn.png"));
      btnNext.setContentAreaFilled(false);
      btnNext.setBorderPainted(false);
      btnNext.setActionCommand("inst1");
      btnNext.addActionListener(new menu());
      
      JButton backtoGame = new JButton(createImageIcon("returnBtn.png"));
      backtoGame.setActionCommand("game");
      backtoGame.addActionListener(new menu());
      backtoGame.setContentAreaFilled(false);
      backtoGame.setBorderPainted(false);
      backtoGame.setBounds(996, 11, 257, 89);
      instructions1.add(backtoGame);
      btnNext.setBounds(954, 520, 257, 89);
      instructions1.add(btnNext);
      btnBackToThe.setBounds(751, 530, 257, 67);
      instructions1.add(btnBackToThe);
      
      JLabel lblNewLabel_1 = new JLabel(createImageIcon("instructionWin.png"));
      lblNewLabel_1.setBounds(0, 0, 1424, 687);
      instructions1.add(lblNewLabel_1);
      
      instructions2 = new JPanel();
      cardHolder.add(instructions2, "name_1394790251434967");
      instructions2.setLayout(null);
      
      JButton nextBtn = new JButton(createImageIcon("nextBtn.png"));
      nextBtn.setContentAreaFilled(false);
      nextBtn.setBorderPainted(false);
      nextBtn.setActionCommand("inst2");
      nextBtn.addActionListener(new menu());
      
      JButton backBtn = new JButton(createImageIcon("backBtn.png"));
      backBtn.setContentAreaFilled(false);
      backBtn.setBorderPainted(false);
      backBtn.setActionCommand("back1");
      backBtn.addActionListener(new menu());
      backBtn.setBounds(973, 539, 222, 64);
      instructions2.add(backBtn);
      nextBtn.setBounds(957, 465, 264, 64);
      instructions2.add(nextBtn);
      
      JButton gameBtn = new JButton(createImageIcon("returnBtn.png"));
      gameBtn.setContentAreaFilled(false);
      gameBtn.setBorderPainted(false);
      gameBtn.setActionCommand("game");
      gameBtn.addActionListener(new menu());
      gameBtn.setBounds(1038, 11, 277, 88);
      instructions2.add(gameBtn);
      
      JLabel lblNewLabel = new JLabel(createImageIcon("instructionTurn.png"));
      lblNewLabel.setBounds(1, -1, 1422, 686);
      instructions2.add(lblNewLabel);
      
      instructions3 = new JPanel();
      cardHolder.add(instructions3, "name_1398037285743774");
      instructions3.setLayout(null);
      
      JButton btnNewButton = new JButton(createImageIcon("returnBtn.png"));
      btnNewButton.setContentAreaFilled(false);
      btnNewButton.setBorderPainted(false);
       btnNewButton.setActionCommand("game");
       btnNewButton.addActionListener(new menu());
      
      JButton back = new JButton(createImageIcon("backBtn.png"));
      back.setContentAreaFilled(false);
      back.setBorderPainted(false);
      back.setActionCommand("back2");
      back.addActionListener(new menu());
      back.setBounds(538, 498, 269, 100);
      instructions3.add(back);
      btnNewButton.setBounds(992, 23, 237, 89);
      instructions3.add(btnNewButton);
      
      JLabel lblNewLabel_2 = new JLabel(createImageIcon("instructionRule.png"));
      lblNewLabel_2.setBounds(0, 0, 1424, 687);
      instructions3.add(lblNewLabel_2);
      
      coinFlip = new JPanel();
      cardHolder.add(coinFlip, "name_117554800063098");
      coinFlip.setLayout(null);
      
      JButton btnPlay = new JButton(createImageIcon("nextBtn.png"));
      btnPlay.setActionCommand("flip");
      btnPlay.setContentAreaFilled(false);
      btnPlay.setBorderPainted(false);
      btnPlay.addActionListener(new menu());
      btnPlay.setBounds(875, 492, 304, 111);
      coinFlip.add(btnPlay);
      
      winnerLabel = new JLabel(createImageIcon("flipCoin.gif"));
      winnerLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
      winnerLabel.setBounds(604, 394, 237, 220);
      coinFlip.add(winnerLabel);
      
      displayCoin = new JLabel("");
      displayCoin.setBounds(505, 441, 369, 166);
      coinFlip.add(displayCoin);
      
      getGuess = new JTextField();
      getGuess.setBounds(857, 284, 218, 20);
      coinFlip.add(getGuess);
      getGuess.setColumns(10);
      
      getUsername = new JTextField();
      getUsername.setBounds(604, 243, 218, 20);
      coinFlip.add(getUsername);
      getUsername.setColumns(10);
      
      rollBack = new JLabel(createImageIcon("coinFlip.png"));
      rollBack.setBounds(0, 0, 1424, 687);
      coinFlip.add(rollBack);
      
      tailsWin = new JPanel();
      cardHolder.add(tailsWin, "name_189945537307436");
      tailsWin.setLayout(null);
      
      imageTails = new JLabel(createImageIcon("tails.gif"));
      imageTails.setBounds(547, 341, 291, 269);
      tailsWin.add(imageTails);
      
      winnerTail = new JLabel("New label");
      winnerTail.setFont(new Font("Tahoma", Font.PLAIN, 30));
      winnerTail.setBounds(467, 256, 649, 78);
      tailsWin.add(winnerTail);
      
      JButton tailWinPlay = new JButton(createImageIcon("nextBtn.png"));
      tailWinPlay.setContentAreaFilled(false);
      tailWinPlay.setBorderPainted(false);
      tailWinPlay.setActionCommand("game");
      tailWinPlay.addActionListener(new menu());
      tailWinPlay.setBounds(896, 505, 236, 104);
      tailsWin.add(tailWinPlay);
      
      tailBackground = new JLabel(createImageIcon("flipTailBack.png"));
      tailBackground.setBounds(0, 0, 1424, 687);
      tailsWin.add(tailBackground);
      
      headWin = new JPanel();
      cardHolder.add(headWin, "name_189990305484461");
      headWin.setLayout(null);
      
      imageHeads = new JLabel(createImageIcon("heads.gif"));
      imageHeads.setBounds(547, 331, 335, 271);
      headWin.add(imageHeads);
      
      winnerHead = new JLabel("New label");
      winnerHead.setFont(new Font("Tahoma", Font.PLAIN, 30));
      winnerHead.setBounds(523, 209, 1000, 136);
      headWin.add(winnerHead);
      
      JButton headWinPlay = new JButton(createImageIcon("nextBtn.png"));
      headWinPlay.setContentAreaFilled(false);
      headWinPlay.setBorderPainted(false);
      headWinPlay.addActionListener(new menu());
      headWinPlay.setActionCommand("game");
      headWinPlay.setBounds(892, 519, 277, 83);
      headWin.add(headWinPlay);
      
      JLabel headBackground = new JLabel(createImageIcon("flipHeadBack.png"));
      headBackground.setBounds(0, 0, 1424, 687);
      headWin.add(headBackground);

      //A for loop of initializing the button array as well as adding the images to it
  for (int y = 0; y < row; y++) {

   for (int x = 0; x < row; x++) {
    

    btns[x][y] = new JButton(createImageIcon ("water.gif"));//sets all of the buttons to water, any buttons that are not water will be changed in the if statements
    btns[x][y].setActionCommand("" + (x * 100 + y)); //Sets their action command so that the last 2 digits will be the Y value and the remaining value (divided) by 100 will be the X value
    btns[x][y].setBorderPainted(false); //hides button border

    gameboard.add(btns[x][y]);//adds the button

    if (y % 2 == 0 || y % 2 == 2) { //if the row# is even or 0, it will make a pattern of land pieces (grass) and water pieces, if not it makes a row of water peices
     if (x % 2 == 0 || x % 2 == 2) {//if the x value is even or 0 it will create a land piece
      btns[x][y].setIcon(createImageIcon ("grass.png")); //and change it from the water piece to grass           
      btns[x][y].addActionListener(new PlayerMoveBtn()); //and adds a different action listener
     }

     else {
     
      btns[x][y].addActionListener(new WallBtn()); //if the button is a wall (water) it will add a wall button action listener
     }
    } else {
  
     btns[x][y].addActionListener(new WallBtn());//if the button is a wall (water) it will add a wall button action listener
    }

   }

  }

  for (int y = 0; y < row; y++) { //fills up boardInt with 0's in all positions (nothing there) the first set of data (position of player 1 and 2 will be added shortly
   for (int x = 0; x < row; x++) {
    boardInt[x][y] = 0;
   }

  }

  start = row / 2; //gets the X starting value for both players as mentioned above
  boardInt[start][0] = 1;// sets Player 1's boardInt value to signify that is the position of player1
  btns[start][0].setIcon(createImageIcon (player1Icon + "G.gif")); //sets that position to the image with the player on it, as mention in the global variable section, I used
  //deliberate naming scheme to organize my pictures, things prefixed with G will give the gameboard piece not the original gif, this sets the players position on the button array as the appropriate gif
  oldX = start; //saves the players position into the "old values" as mentioned above
  oldY = 0;
  btns[start][row - 1].setIcon(createImageIcon (player2Icon+ "G.gif")); //sets player 2's position on the button array with a gif
  oldX2 = start;//saves player 2's position
  oldY2 = row - 1;
  boardInt[start][row-1] = 2; //sets his value on boardInt to signify his location
  PlaySound("background.wav", true); //start the background music
  
 }

 protected static ImageIcon createImageIcon(String path) // create image method
 {
  java.net.URL imgURL = quoridor.class.getResource(path);
  if (imgURL != null)
   return new ImageIcon(imgURL);
  else {
   System.err.println("Couldn't find file: " + path);
   return null;

  }
 }
 public void stop() {
   
     clip.stop();
     clip.close();
 }
 public void PlaySound (String sound, boolean play) //I have 2 methods for playing songs one for looping continuous music and one for 1 time sound effects, this is the looping one
 {//parameters are the string which has the file name and a boolean which will start or stop the music
  
  if (play == true) { //if the boolean is true it will start the music if not it will stop it
  
  try {
   AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(quoridor.class.getResource(sound));//enables sound and gets prepared, also loads the audio file (string sound holds the file name)
   clip = AudioSystem.getClip(); //gets the global clip variable
   clip.open(audioInputStream); //opens and enables the audio stream
   clip.loop(Clip.LOOP_CONTINUOUSLY); //will loop the music
   clip.start();//starts the clip
  }
  catch (Exception e) {
   System.out.println("Not found"); //if clip can not be found this error is printed
  }
 } else {
	 clip.stop();
	 clip.close();//stops the clip
 }
}
 public void PlaySoundOnce (String sound, boolean play) //same as above by the loop continuously part is removed as this is only playing once
 {
  
  if (play == true) {
  
  try {
   AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(quoridor.class.getResource(sound));
   clip = AudioSystem.getClip();
   clip.open(audioInputStream);
   clip.start();
  }
  catch (Exception e) {
   System.out.println("Not found");
  }
 } else {
  
 }
}
 
 
 class menu implements ActionListener { //for all of my menu buttons it will go to this action listener, I made it into one method to keep track of them a they were all for the most part
	 //very small things
  public void actionPerformed(ActionEvent e) {
   int numLet = 7; //the max amount of characters in a players name
   int right = 0; //used as a gateway variable
  if (e.getActionCommand().equals("instructions")) //if the instruction button is pressed
  {
	  PlaySoundOnce("menu.wav", true); //plays the button sound effect
   cardHolder.removeAll(); //gets rid of everything on the panel
   cardHolder.revalidate(); //revalidates the panel
   cardHolder.repaint(); //re-makes the panel 
   cardHolder.add(instructions1); //adds the new screen
  }
  else if (e.getActionCommand().equals("game"))//is the game/play button is clicked
  {
	  PlaySoundOnce("menu.wav", true);
   cardHolder.removeAll();
   cardHolder.revalidate();
   cardHolder.repaint();
   cardHolder.add(gameScreen);
  
  }
  
  else if (e.getActionCommand().equals("options")) //if the options button is clicked
  {
	  PlaySoundOnce("menu.wav", true);
   cardHolder.removeAll();
   cardHolder.revalidate();
   cardHolder.repaint();
   cardHolder.add(options);
  }
  else if (e.getActionCommand().equals("menu")) //if the menu button is clicked
  {
	  PlaySoundOnce("menu.wav", true);
   cardHolder.removeAll();
   cardHolder.revalidate();
   cardHolder.repaint();
   cardHolder.add(Title);
   
  }
  else if (e.getActionCommand().equals("inst1")) //if the user wishes to navigate to the next instruction page
  {
	  PlaySoundOnce("menu.wav", true);
   cardHolder.removeAll();
   cardHolder.revalidate();
   cardHolder.repaint();
   cardHolder.add(instructions2);
   
  }
  else if (e.getActionCommand().equals("inst2"))//if the user wishes to navigate to the next instruction page
  {
	  PlaySoundOnce("menu.wav", true);
   cardHolder.removeAll();
   cardHolder.revalidate();
   cardHolder.repaint();
   cardHolder.add(instructions3);
   
  }
  else if (e.getActionCommand().equals("back1"))//if the user wishes to move back an instruction page
  {
	  PlaySoundOnce("menu.wav", true);
   cardHolder.removeAll();
   cardHolder.revalidate();
   cardHolder.repaint();
   cardHolder.add(instructions1);
   
  }
  else if (e.getActionCommand().equals("back2"))//if the user wishes to move back an instruction page
  {
	  PlaySoundOnce("menu.wav", true);
   cardHolder.removeAll();
   cardHolder.revalidate();
   cardHolder.repaint();
   cardHolder.add(instructions2);
   
  }
  else if (e.getActionCommand().equals("option"))//if the option button is pressed
  {
	  PlaySoundOnce("menu.wav", true);
   cardHolder.removeAll();
   cardHolder.revalidate();
   cardHolder.repaint();
   cardHolder.add(options);
   
  }
  else if (e.getActionCommand().equals("playAgain"))// if the play again button is pressed
  {
	  PlaySoundOnce("menu.wav", true);
      Reset();
      cardHolder.removeAll();
      cardHolder.revalidate();
      cardHolder.repaint();
      cardHolder.add(gameScreen);
      PlaySound("vitory theme.wav", false);
      PlaySound("background.wav", true);
  }
  else if (e.getActionCommand().equals("reset"))// if the reset button is pressed
  {
	  PlaySoundOnce("menu.wav", true);
      Reset();
   
  }
  else if (e.getActionCommand().equals("flip")) //if the continue button on the flip a coin page is pressed
  {
   int valid = 0; //in this page the code has to check that the user actually entered something for their guess. To restrict from continuing on in the code even after not entering 
   //the needed data we have this variable, after each check we increment this variable and at the end we check if this variable is high enough it means that the player inputed all valid data
   //and can continue to the next screen, this variable is used for this purpose
   String coin;//keeps track of the value heads or tails of the coin toss
    int flipCoin = (int)(Math.random()*2 + 1); //gets a random value 1 or 2, depending on that it will be heads of Tails
    String guess = getGuess.getText(); //there is a guess box in which 1 player can enter their guess on what side the coin will land on, this value is take from the user and stored
    if (flipCoin == 1)//determines head or tales based on random integer which is 1 or 2
    {
     coin = "heads";    
    }
    else
    {
     coin = "tails";
    }
    if ( getUsername.getText().equals(oneName)||getUsername.getText().equals(twoName))//if the user name inputed for the person who is guessing matches with one of the players username
    	//it passes this check
    {
     valid++; //it increments valid if it passes the check, the use of valid was stated previously
    }
   
    else
    {
     JOptionPane.showMessageDialog(null, "Please enter your actual username!"); //if the username inputed does not match it will alert the user (using a pop up) and prompt them to input valid data next time
    }
    if ( getGuess.getText().equals("heads")||getGuess.getText().equals("tails")) //if the guess provided by the user matches with one of the 2 possibilities heads or tails it will increment the valid variable
    {
     valid++; //increments the valid variabled
    }
    else
    {
     JOptionPane.showMessageDialog(null, "Please enter an actual guess!"); //if their guess is not valid it will alert them with a pop up
    }
    //////////////
    if (oneName.equals(getUsername.getText())&& guess.equals(coin)&& valid == 2) ///if the username entered is the same as the first players, as well as the guess being right, as well as the valid being 2 ( 2 checks)
    
   {
    winnerLabel.setText(oneName + "'s turn first!"); //change a label to alert them of who gets to go first
    displayCoin.setIcon(createImageIcon(coin +".gif")); //sets up a gif to show the coin roll and the result
     turn = 'r'; //sets the global turn variable to the player who won 
     
     turnLabel.setText(oneName + "'s turn"); //updates the needed labels to alert the players of who won 
     if (coin.equals("heads"))
     winnerHead.setText(oneName + " got it, they go first!");
     else
     winnerTail.setText(oneName + " got it, they go first!");
    
   }
    else if (twoName.equals(getUsername.getText())&& guess.equals(coin)&& valid == 2) //is the same as above but for the other player
   {
    winnerLabel.setText(twoName + "'s turn first!");
    displayCoin.setIcon(createImageIcon(coin +".gif"));
    turn = 'b';
    turnLabel.setText(twoName + "'s turn");
    if (coin.equals("heads"))
        winnerHead.setText(twoName + " got it, they go first!");
    else
        winnerTail.setText(twoName + " got it, they go first!");
   
   }
   else if (oneName.equals(getUsername.getText())&& !guess.equals(coin)&& valid == 2)//If the username is the first persons but the guess is wrong, as well as valid being 2 as there were 2 checks
	   // will do the same as above but instead of doing it for player one it will do it for player two as they guessed wrong
	   
   {
    winnerLabel.setText(twoName + "'s turn first!");
    displayCoin.setIcon(createImageIcon(coin +".gif"));
    turn = 'b';
    turnLabel.setText(twoName + "'s turn");
    if (coin.equals("heads"))
        winnerHead.setText(twoName + " got it, they go first!");
    else
        winnerTail.setText(twoName + " got it, they go first!");
   }
   else if (twoName.equals(getUsername.getText())&& !guess.equals(coin)&& valid == 2) //same as above but, if player two guess but got the guess wrong
   {
    winnerLabel.setText(oneName + "'s turn first!");
    displayCoin.setIcon(createImageIcon(coin +".gif"));
    turn = 'r';
    turnLabel.setText(oneName + "'s turn");
    if (coin.equals("heads"))
        winnerHead.setText(oneName + " got it, they go first!");
    else
        winnerTail.setText(oneName + " got it, they go first!");
   }
    //////////////////////
    
    getUsername.setText(""); //resets the text fields to blank, so if the fail or return it will be fresh and clean for another crack
    getGuess.setText("");
    
   if (coin.equals("heads")&& valid == 2) //based on how I made my templates and backgrounds I have 2 different win panels based on which side the coin flip landed on heads or tails, also makes sure valid is 2 so all information inputted was valid 
	   //this just switches the scene
   {  gameStart = 'y'; //this is the heads frame
	   cardHolder.removeAll();
	    cardHolder.revalidate();
	    cardHolder.repaint();
	   cardHolder.add(headWin);
    }
   else if (valid == 2) //
   {
	   gameStart = 'y'; //this is the tails frame
	   cardHolder.removeAll();
	    cardHolder.revalidate();
	    cardHolder.repaint();
	   cardHolder.add(tailsWin);
   }
 
   
    
  }
  else if (e.getActionCommand().equals("check")) //player selection screen
  {
   int size1 = oneGetName.getText().length(); //gets the length of both player names
   int size2 = twoGetName.getText().length();
  
   if (size1 <= numLet) //checks if the size of the players name is valid (smaller than 8 characters), increments right variable if it passed this criteria
   {
    right++; //global variable which keeps track of if all of the valid information was inputed like valid from above
    if (oneGetName.getText().equals("")) //if the player left their name empty is gives them the default name of Player 1 or 2
     {
      oneName = "Player 1";
     }
    else
       {
      oneName = oneGetName.getText(); //sets the players name to what they entered
       }
   }
   else
   {
    JOptionPane.showMessageDialog(null, oneName + " you dumbo! input a name no longer than " + numLet); //alerts them to their mistake and plays a sound effect (with pop up)
    oneGetName.setText("");//clears text box
    PlaySoundOnce("messup.wav", true);
    
   }
   if (size2 <= numLet) //repeated from above, but this checks is the seconds players name is valid
   {
    right++;
    if (twoGetName.getText().equals(""))
    { twoName = "Player 2";}
   else
      { twoName = twoGetName.getText();}
   }
   else
   {
    JOptionPane.showMessageDialog(null, twoName + "you dumbo! input a name no longer than " + numLet);
    twoGetName.setText("");
    PlaySoundOnce("messup.wav", true);
   }
   
   if (p1Choose1.isSelected() && p1Choose2.isSelected()) //if player 1 selected 2 characters, increments right if it passed
   {JOptionPane.showMessageDialog(null, oneName + " please pick only 1 character!");}//alerts them if they messed up, and tells them to fix it (pop up)
   else
   {right++;}
   if (p2Choose1.isSelected() && p2Choose2.isSelected()) //same as above but for the player
   {JOptionPane.showMessageDialog(null, twoName + " please pick only 1 character!");}
   else
   {right++;}
   
   String fileName; //the string with the file name of the gif that needs to be added
   if (p1Choose2.isSelected()) //if the player selected the second options
   {
	   player1Icon = "player1B"; //it will rename the players icon prefix which was discussed on how it works in global variables
	   fileName = player1Icon + "G.gif"; //gets the gif file for the board 
	   btns[start][0].setIcon(createImageIcon (fileName));//changes the board with this new image
   }
   else //if player 1 does not pick anything
   {
	   player1Icon = "player1A"; 
	   fileName = player1Icon + "G.gif";
	   btns[start][0].setIcon(createImageIcon (fileName));
   }
	   
   if (p2Choose2.isSelected()) //same as above but for player 2
   {
	   player2Icon = "player2B";
	   fileName = player2Icon + "G.gif";
	   btns[start][row - 1].setIcon(createImageIcon (fileName));
   }
   else
   {
	   player2Icon = "player2A";
	   fileName = player2Icon + "G.gif";
	   btns[start][row - 1].setIcon(createImageIcon (fileName));
   }
  
   
	
   
   if (right == 4) //if the player passes all of the checks
   {
	   PlaySoundOnce("messup.wav", true); //plays sound effect
    menuPlayer1Score.setText(oneName); //sets all the labels with the players names to the players names which they inputed 
    menuPlayer2Score.setText(twoName);
    gamePlayer1Wins.setText(oneName + " : " + redWin);
    gamePlayer2Wins.setText(twoName + " : " + blueWin);
    redWallLabel.setText(oneName + "'s whirlpools left: " + redWall );
    blueWallLabel.setText(twoName + "'s whirlpools left: " + blueWall );
    if (turn == 'r')
    {turnLabel.setText(oneName + "'s turn");}
    else
    {turnLabel.setText(twoName + "'s turn");}
    if (gameStart == 'n') //if the game has not been played yet on this launch it will do the coin flip
    {
     oneGetName.setText(""); //resets the text box back to blank
     twoGetName.setText("");//adds the coin flip scene
     cardHolder.removeAll();
     cardHolder.revalidate();
     cardHolder.repaint();
     cardHolder.add(coinFlip);
    }
    else //if the game has been played before it will not do the coin flip and instead skip to the actual game
    {
     oneGetName.setText("");
     twoGetName.setText("");
     cardHolder.removeAll();
     cardHolder.revalidate();
     cardHolder.repaint();
     cardHolder.add(gameScreen);
    }
    
    
   }
   
  }
  }
  }

 class PlayerMoveBtn implements ActionListener { //Action listener for the grass spots (Player movable spots)
  public void actionPerformed(ActionEvent e) {

   String place = e.getActionCommand(); //Gets the position of the buttons clicked from the action command of the button
   //as the last 2 digits are the Y value and the remaining first 2 digits/100 are the X value
   posR = Integer.parseInt(place); //gets the action command and parses it into an integer
   posY = posR % 100; //mods the number by 100 to get the last 2 digits
   posX = (posR - posY) / 100; //subtracts the last 2 digits and divides that by 100 to get the 2 X digits
            int oldSpotX; // a multi-player old variable, that based on whose turn it is, it will get different coordinates from the old variable of that player 
            int oldSpotY;
            
   if (turn == 'r') //if it is player 1's turn
   {
    oldSpotX = oldX;
    oldSpotY = oldY;
    movePlayer(posX, posY, oldSpotX, oldSpotY); //calls a method which will check validity of the move as well as actually perform the move
    //the method takes in the players old spot coordinates as well as their old position 
   }
   else //if its player 2's turn, same as above
   {
    oldSpotX = oldX2;
    oldSpotY = oldY2;
    movePlayer(posX, posY, oldSpotX, oldSpotY);
     
   }
  
  }
 }
 public void Reset() //A method which will reset the game board
 {
  for (int y = 0; y < row; y++) { // 2 for loops which will refill all of the arrays used, as well as reset the board state

   for (int x = 0; x < row; x++) {

    boardInt[x][y] = 0;  //Refills boardInt to all 0's
    reTrace[x][y] = 'y'; //refills the char array to "not been there yet"
    //as well as resets all walls and the player positions on the button array
    if (y % 2 == 0 || y % 2 == 2) {
     if (x % 2 == 0 || x % 2 == 2) {
      btns[x][y].setIcon(createImageIcon("grass.png"));
      }

     else {
      btns[x][y].setIcon(createImageIcon("water.gif"));
      
     }
    } else {

     btns[x][y].setIcon(createImageIcon("water.gif"));
    }

   }

  }
  wallF = 'y'; //sets the variable that controls if on that turn there hasn't been a wall placed yet
  int start = row / 2;//gets the start value again
  boardInt[start][0] = 1; //resets player 1's starting spot on integer array replication back to 1
  btns[start][0].setIcon(createImageIcon(player1Icon + "G.gif"));//resets the players icon on the proper spot on the board
  oldX = start; //saves the X and Y of the starting position of Player 1
  oldY = 0;
  btns[start][row - 1].setIcon(createImageIcon(player2Icon+ "G.gif")); //resets player 2's position on the board
  oldY2 = row - 1; 
  boardInt[start][row-1] = 2;//adds player 2's spot on the integer array
  turn = 'r'; //resets the turn back to default and turn int
  turnInt = 1;
     redBlock = 'n';//resets a variable which checks if the respective side is blocked
     blueBlock = 'n';
     redWall = 10; //resets each players wall counter
     blueWall = 10;
     turnLabel.setText(oneName + "'s turn"); //resets all needed labels
     blueWallLabel.setText(twoName +"'s whirlpool left: 10");
     redWallLabel.setText(oneName + "'s whirlpool left: 10");
 }
 
  
 public void movePlayer (int posX, int posY, int oldSpotX, int oldSpotY) //the method which was called from before
 //this method validates the players move as well as moves the player to their respective spot if the move is valid
 //the parameters taken in are the co-ordinates of the button click (where the player wants to move) and their current position which is stored in (oldSpot_ )
 {
     if (wallF == 'y') //this makes sure that the player did not place a wall and is trying to move, if they have placed a wall it will alert them
     {
  char isWin = 'n'; // a character which keeps track of whether this move won the game, depending on the state of this variable it will do different things
  if ((posX ==  oldX && posY == oldY)||(posX ==  oldX2 && posY == oldY2)) //if the button clicked is the same spot as another player or themselves it it will  alert them that their move is irrelevant
  {errorM.setText("Another player is on that spot!");} //sets the label
  else //if the player is not moving on a spot which has already has a player on it
  {
	  //THE NEXT 4 CONNECTED IF/ ELSE IF STATEMENTS REPRESENT EACH DIRECTION THE PLAYER CAN MOVE 
	  
	  //IF THE PLAYER MOVES RIGHT
   if (posX == oldSpotX + 2 && oldSpotY == posY) { //in the game the player can only move up, down or sideways, no diagonals
	   //******* It is + 2 not +1 because the player moves across the player moves from land piece to land piece and jumps over the water in each turn
	   //in the array from any grass spot is + or -2 from any other grass spot , therefore we check if the player choose a spot that is +2 in any direction as opposed to one
	   //this means that no matter which direction they move in one of the 2 (X or Y), will stay the same
	   //this just checks that the place the the player is trying to reach is plausible within the movement rules of the game
   if (boardInt[oldSpotX][oldSpotY] > boardInt[oldSpotX + 1][oldSpotY]) { //the previous check only checks for if the player is moving to a valid spot
	   //it doesn't check if the spot is blocked
	   //that is what this check does
	   //since the button array and boardInt array are the same but represented in different ways, we can check if there is a wall there by adding 1 for the x-value, this will show 
	   //the value of the spot which would hold a wall ( 3 if it is placed), the check is getting the players value on the int array (either 2 or 1) and if that is larger than the 
	   //spot  + or -1 in that direction that means there is no wall in that place permitting the move 
    playerMove(posX, posY); // a method which will move the players piece on the button array
    PlaySoundOnce("click", true); //plays a sound effect for the button click
    boardInt[oldSpotX][oldSpotY] = 0; //sets the old position of the button back to 0, as the player has moved from that spot 
    if (turn == 'r') //switches the turns
    {
     turn = 'b';
     
    }
    else
    {
     turn = 'r';
     
       
    }
    changeTurn(); //a method which resets all of the labels which change depending on whose turn it is
   }

   else {
    errorM.setText("A whirlpool blocks your path!"); //if there is a wall blocking the players move, it will alert them
    PlaySoundOnce("messup.wav", true);//plays a sound effect

   }

  }
   //IF THE PLAYER MOVES LEFT
  else if (posX == oldSpotX - 2 && oldSpotY == posY) { //same as above however this time it checks if the player is moving left, so instead of checking the +1 position
	  // on the int array it will check the -1 position as that is the only one which can restrict the movement 
	  //the rest is the same as the above, and will be the same for the next 2
   if (boardInt[oldSpotX][oldSpotY] > boardInt[oldSpotX - 1][oldSpotY]) {
    playerMove(posX, posY);
    PlaySoundOnce("click.wav", true);
    boardInt[oldSpotX][oldSpotY] = 0;
    if (turn == 'r')
    {
     turn = 'b';
     
    }
    else
    {
     turn = 'r';
     
       
    }
    changeTurn();
   }

   else {
    errorM.setText("A whirlpool blocks your path!");
    PlaySoundOnce("messup.wav", true);

   }

  }
   //IF THE PLAYER MOVES UP
  else if (posY == oldSpotY + 2 && oldSpotX == posX) { //the same as the above but instead of X, it checks +1 in the Y coordinate, same as above 
   if (boardInt[oldSpotX][oldSpotY] > boardInt[oldSpotX][oldSpotY + 1]) {
    playerMove(posX, posY);
    boardInt[oldSpotX][oldSpotY] = 0;
    isWin = winGame(posY); // A player can only win by moving up or down (depending on which player it is)
    //so when ever a player moves up/down it calls this method to check if it was a winning move
    PlaySoundOnce("click.wav", true);
    if (isWin == 'n') //if the player did not win, it will continue like regular 
    {
     if (turn == 'r')
     {
      turn = 'b';
      
     }
     else
     {
      turn = 'r';
     
        
     }
     changeTurn();
    }
    
   }

   else {
    errorM.setText("A whirlpool blocks your path!");
    PlaySoundOnce("messup.wav", true);

   }

  }
   //IF THE PLAYER MOVES DOWN
  else if (posY == oldSpotY - 2 && oldSpotX == posX) { //same code but it check -1 in the Y coordinate , but the other code is the same as the above
   if (boardInt[oldSpotX][oldSpotY] > boardInt[oldSpotX][oldSpotY - 1]) {
    playerMove(posX, posY);
    boardInt[oldSpotX][oldSpotY] = 0;
    isWin = winGame(posY);
    PlaySoundOnce("click.wav", true);
    if (isWin == 'n')
    {
     if (turn == 'r')
     {
      turn = 'b';
      
     }
     else
     {
      turn = 'r';
     
        
     }
     changeTurn();
    }
   }
   

   else {
    errorM.setText("A whirlpool blocks your path!");
    PlaySoundOnce("messup.wav", true);

   }

  }

  else { //if the player chooses a spot which is not accessible (with out checking for wall blocks), it will alert them to their mistake
   errorM.setText("Pick a valid spot!");
   PlaySoundOnce("messup.wav", true);

  }
 if (turn == 'r') //sets the new position of the player to the appropriate value on the int array  
 {
  boardInt[posX][posY] = 1;
 }
 else
 {
  boardInt[posX][posY] = 2;
 }
 }
     } 
     else //if the player has placed 1 wall before, it will not allow you to move and alert you to your mistake
     {
     errorM.setText("You have placed a wall, you can't move, please place the wall!");
     PlaySoundOnce("messup.wav", true);
     }
 }
 public void changeTurn() //This method is called when the turn is changed, it changes the needed labels to keep the game GUI consistant
 {
  if (turn == 'r')
  {turnLabel.setText(oneName +"'s Turn");}
  else
  {turnLabel.setText(twoName + "'s Turn");}
 }
 public char winGame(int posY) //Called when a player moves either up or down
 {   //this method will only be called once the move has been validated
	 //takes in the parameter of the Y coordinate of the button that was clicked
  Object[] options = {"OK"}; //used as a parameter to create a pop up which will alert the user they won
  //set win to proper thing
  char isWon = 'n';//sets the variable which keeps track of whether the game is won or not to no at the start of each iteration of this method
  if (turn == 'r' && posY == row -1) //if it is player 1's turn and the button that was clicked is the row - 1 (as arrays start from 0), it will make the you win screen and alert them
  {
   turnLabel.setText("Red WINS!");
         isWon = 'y'; //sets the win variable to true, this will prevent things like changing turns and stuff as the game is over
         redWin++; //increments player 1's win counter
         gamePlayer1Wins.setText("P1: " + redWin); //sets labels to alert the players
         menuWinA.setText("" + redWin);
         
         int n = JOptionPane.showOptionDialog(null, //creates a pop up that alerts the players as well
                        oneName +" wins! ", twoName + " is bad",
                        JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
         //int n gets the players choice clicked, however since I made it so that it only has 1 button it will only return a value of 0
         // as in the JOptionPane code, the OK option returns a value of 0, the other options also have different values
         //that how you differentiate which button was clicked on
         if (n == 0) //if the button was clicked it will create the win screen, and sets the labels 
   {
       cardHolder.removeAll();
    cardHolder.revalidate();
    cardHolder.repaint();
    cardHolder.add(WinScreen);
    winnerName.setText(oneName +" wins!");
    //PlaySound("background.wav", false);

    winnerPlayer.setIcon(createImageIcon(player1Icon+ "F.gif"));
   }
         
  }
  else if (turn == 'b'&& posY == 0) //if its player 2's turn and they reach y = 0, which means they reached the other side of the board which means they win
  { //the inside code is the same as above but for player 2 this time
  turnLabel.setText("Blue WINS!");
  isWon = 'y';
  blueWin++;
  gamePlayer2Wins.setText("P2: " + blueWin);
  menuWinB.setText("" + blueWin);
   int n = JOptionPane.showOptionDialog(null,
       twoName +" wins! ", oneName + " is bad",
                 JOptionPane.PLAIN_MESSAGE,
                 JOptionPane.QUESTION_MESSAGE,
                 null,
                 options,
                 options[0]);
   if (n == 0)
   {
       cardHolder.removeAll();
    cardHolder.revalidate();
    cardHolder.repaint();
    cardHolder.add(WinScreen);
    winnerName.setText(twoName + " wins!");
    winnerPlayer.setIcon(createImageIcon(player2Icon+ "F.gif"));
   }
  }
  return isWon; //returns the isWon char to check if it needs to update other labels 
 }
 
 class WallBtn implements ActionListener { //if the player decides to place a wall button
  public void actionPerformed(ActionEvent e) 
  {
   
     
   String place = e.getActionCommand(); //gets the X and Y just like in the player move button

   int posR = Integer.parseInt(place);
   int posY = posR % 100;
   int posX = (posR - posY) / 100;
  
   for (int x = 0; x < row; x++) //copies all values in boardInt to possible int, this as mentioned in the global int section is the duplication of boardInt
	   //this array will get the wall which the player wants to add and adds it to this "test" array and tests if this wall causes any issues, it if doesn't it will add it to the real
	   //Array 
   {
     for (int y = 0; y < row; y++)
     {
      possibleInt[x][y] =  boardInt[x][y];
     }
   }
   
   possibleInt[posX][posY] = 3; //adds the wall to the test array
   saveX = 0;//resets the key variables for this array to run
   foundSol = 'n'; //the variable which will be used to stop infinite looping, as well as used to check the validity of the players move
 
   
      redBlock = isRedBlock(); //checks if Player 1 is blocked, and saves in a variable
      //uses my algorithm to check if the player is blocked, more on this later
      blueBlock = isBlueBlock();//checks if Player 2 is blocked and saves in a variable
     //found sol in that iteration of the method is passed into these chars, so y = there is a solution and n = no solution
      if (redBlock == 'y' && blueBlock == 'y') //if both players are not blocked by the wall it will set foundSol to yes which allows the player to place the row
      {
       foundSol = 'y';
      }
      else  //if one of the 2 players is blocked it will not allow the player to place the wall
      {
       foundSol = 'n';
      }
      if ((turn == 'r' && redBlock != 'y')||(turn == 'b' && blueBlock != 'y')) //if the player whose turn it is, as well as their blocking variable end up being blocked it will alert them
    	  //that they are blocking themselves with that wall
    	  {errorM.setText("You're blocking yourself!");}
       
   if (foundSol == 'y') //if the wall that is trying to be placed is not causing any issues by blocking themselves or the other player, we still have to check if the actual spot of the wall
	   //has a place for another wall to be placed, as on a wall turn you need to place 2 connected walls, so if it is the first wall being placed by the player on that turn
	   //we have to make sure there is room for the other wall piece, so that it does not glitch out
 {
	  //This giant if statement checks if there is any space on any side of the wall that is trying to be placed, it looks at the integer array and uses that to determine if there is space for 2 walls to be placed
  if(wallF == 'y' && (((posY != 0 && posY != row -1 && posX != 0 && posX != row -1) && (boardInt[posX + 1][posY] == 0||boardInt[posX - 1][posY] == 0 ||boardInt[posX][posY +1] == 0||boardInt[posX][posY - 1] == 0))
    ||(posY == 0 && boardInt[posX][posY + 1] == 0)||(posY == row - 1 && boardInt[posX][posY - 1] == 0)||(posX == row - 1 && boardInt[posX - 1][posY] == 0)||(posX == 0 && boardInt[posX+1][posY] == 0)))
  {
  if ((turn == 'r'&& redWall > 0)||(turn == 'b'&& blueWall > 0)) //even if the wall is valid, and has enough space for both parts, if the player does not have any more walls left
	  //they won't be able to place the wall, it looks at which player's turn it is as well as their walls to see if they can place the wall
  {
   if(wallF=='y') //if its the first wall being placed in that turn 
	//now that all of the situations have been acounted for the wall in question is valid, so we can add it to the main int array and set its spot on the actual button array   
   {
    btns[posX][posY].setIcon(createImageIcon ("wall.gif")); 
    boardInt[posX][posY] = 3; //sets the spot on the int array to 3, as stated above walls are represented by the number 3
    oWallX = posX; //saves the coordinates of this wall as it is the first wall being placed on this turn, and it needs this coordinate to check the validity for the next wall that is placed
    oWallY = posY;
    wallF = 'f';//sets the first wall variable to false, as this was their first wall being placed
   }
   else //if its the second wall being placed 
   {
	   //this checks if the wall being placed is in any way connected to the one previously placed, to check this it uses the save values which it saves on the placement of the first wall
	   
    if (((posX == oWallX + 1 || posX == oWallX - 1) && oWallY == posY) 
      || ((posY == oWallY + 1 || posY == oWallY - 1) && oWallX == posX)) {
    	//resets the first wall char to false, as this is the second wall that is placed
     wallF = 'y';
     btns[posX][posY].setIcon(createImageIcon ("wall.gif")); //sets the appropriate label on the button array
     boardInt[posX][posY] = 3; // sets the value of the wall that was placed to 3 which is a wall on the int array
     oWallX = posX;
     oWallY = posY;
     if (turn == 'r') //Depending on which player's turn it is it will switch the turn and de-increment the players number of walls
     {
      redWall--;
      redWallLabel.setText(oneName + "'s whirlpools left: " + redWall);
      turn = 'b';
      
     }
     else
     {
     blueWall--;
     blueWallLabel.setText(twoName +"'s whirlpools left: " + blueWall);
     turn = 'r';
     
     }
     changeTurn(); //change turn method
     
    } else { //if the wall is not connected to the previous wall placed
     errorM.setText("Please place the whirlpool in the correct spot!");
    }

   }
  }
  else if (turn == 'r') //if the player does not have any walls left 
  {errorM.setText("Red you're out of walls!");}
  else
  {errorM.setText("Blue you're out of walls!");}
 }
  else if (wallF != 'y') //if it is not the first wall placed
  {
   if ((turn == 'r'&& redWall > 0)||(turn == 'b'&& blueWall > 0))//checks that the player who is placing the wall has enough walls in order to place down this wall
   {
	   //same as above if statement, it checks the validity of the move in reference to the player's amount of walls left, as well as if it is connected to the last wall which had its 
	   //Position recorded in the previous loop where it was the first wall placed
    if(wallF=='y')

    {
     btns[posX][posY].setIcon(createImageIcon ("wall.gif"));
     boardInt[posX][posY] = 3; // walls = 3, player 1 = 1, player 2 = 2
     oWallX = posX;
     oWallY = posY;
     wallF = 'f';
    }
    else
    {
     if (((posX == oWallX + 1 || posX == oWallX - 1) && oWallY == posY)
       || ((posY == oWallY + 1 || posY == oWallY - 1) && oWallX == posX)) {
      wallF = 'y';
      btns[posX][posY].setIcon(createImageIcon ("wall.gif")); //Background(new Color(0, 0, 0));
      boardInt[posX][posY] = 3; // walls = 3, player 1 = 1, player 2 = 2
      oWallX = posX;
      oWallY = posY;
      if (turn == 'r')
      {
       redWall--;
       redWallLabel.setText(oneName +"'s whirlpools left: " + redWall);
       turn = 'b';
       
      }
      else
      {
      blueWall--;
      blueWallLabel.setText(twoName + "'s whirlpools left: " + blueWall);
      turn = 'r';
      
      }
      changeTurn();
      
     } else {
      errorM.setText("Please place the whirlpool in the correct spot!");
     }

    }
   }
   else if (turn == 'r')
   {errorM.setText("Red you're out of walls!");}
   else
   {errorM.setText("Blue you're out of walls!");}
  }
  else //if there is no space for the wall to be placed as well as the player not placing a wall this turn, it will alert the player 
  {
   errorM.setText("No other whirlpool can be placed!"); 
  }
 }
 else if ((turn == 'r' && redBlock != 'y')||(turn == 'b' && blueBlock != 'y')) //if the turn is the same as a person who is blocked as determined above when I called the 2 methods
 {
  errorM.setText("You're blocking yourself!"); //will alert the player that they are blocking themselves
  
 }
 else //if the player is blocking themselves it will alert them
 {errorM.setText("Stop blocking the other player!");}
 }


 }
 public char isRedBlock() //2 methods which each check for if 1 player is blocked in by walls by the wall that is trying to be placed
 {
  char isSwitch = 'n'; //when a wall is placed we need to "simulate" a turn switch so that we can run the algorithm for both parties  
  if (turn != 'r') //since this is the red block method which checks for if Player 1 is blocked, so if it is not player 1's turn
	  //it will switch the turn and change isSwitch so that it makes sure to change the turn back to what it started as
   {
   turn = 'r'; //temporarily switches the turn
   isSwitch = 'y'; //changes this variable to make sure it changes the turn back to what it was
   }
  turnInt = 1; //sets the variable turnInt this is used to alter the algorithm so that it works for that situation, the steps are the same however it just changes the way it scans board and looks for a way out
  for (int i = 0; i < row; i++) //sets the global array reTarce to all y's so that when it starts scanning it starts fresh, more on the use of this variable in the global variable section above
  { 
   Arrays.fill(reTrace[i], 'y');
  }
  checkX = oldX; //sets the scan variables equal to the actual position of the player, so that it can look for a way out
  checkY = oldY;
  redBlock = isEscape(); //calls a method which will look for a way to the other side of the board (win side), will get a char and save it in the char redBlock this is used later on to make sure that no player is blocked
  if (isSwitch == 'y') //switches the turn back if needed 
  {
   turn = 'b';
  }
  return redBlock;//finishes the method
  
  
 }
//same thing repeated above for the second player
 public char isBlueBlock()
 {
  char isSwitch = 'n';
  if (turn != 'b')
   {
   turn = 'b';
   isSwitch = 'y';
   }
  turnInt = -1;
  for (int i = 0; i < row; i++)
  { 
   Arrays.fill(reTrace[i], 'y');
  }
  
  checkX = oldX2;
  checkY = oldY2;
  blueBlock = isEscape(); 
  if (isSwitch == 'y')
  {
   turn = 'r';
  }
  return blueBlock;
 }
 //this is the method which will 
 public void playerMove (int posX, int posY) //it takes in the position of the button which is clicked and sets the new button with the gif of the player and sets the old place back to the dfualt texture
 {
  if (turn == 'r')
  {
  btns[oldX][oldY].setIcon(createImageIcon("grass.png"));
  btns[posX][posY].setIcon(createImageIcon(player1Icon + "G.gif"));
  oldX = posX; //saves the players position for later
  oldY = posY;
  }
  else //same as above
  {
   btns[oldX2][oldY2].setIcon(createImageIcon("grass.png"));
   btns[posX][posY].setIcon(createImageIcon(player2Icon + "G.gif"));
   oldX2 = posX;
   oldY2 = posY;
  }
 }
//*****************ALGROITHM AND HOW IT WORKS*******************************
 // in the game Quroidor players are allowed to place walks to annoy and slow down the other player
 //however they are not allowed to block them entirely. Making sure that when a wall is placed, that they don't block themselves or the other player
 //there is no easy way to do this, so what I had to do was create an algorithm which will be able to navigate all of the mazes created by the players.
 //The main algorithm is the same for each of the players, but they move in opposite directions on the board so the algorithm is slightly different for each player which is why I require turnInt
 //as because of this I am able to use 1 set of code twice and save space
 // THE ALGORITHM:
 // 1) Move as far straight as you can go. (Up or down depends on which player you are), this is what turnInt is used for. It control which direction the checkX and CheckY values move in, as it depends on which player is being tested
 // 2) Once you hit a wall and can't move straight, scan the entirety of the X-axis and looks for a way up, if it finds a way up, the algorithm will call itself and repeats the steps until that "branch" reaches a dead end or reaches the goal
 // 3)If none of the "branches" on that row yield a way to the end  it will move backwards 1 unit (can be seen as forward or backward depending on which player it is), another use of turnInt
 // 4)It will move down until it hits a wall, it will then scan sideways and look for a way down, for each way down it will look for a way up in that "branch", and see if can reach the goal
 // 5)It will continue looking for ways down until it can't find a way down. If it can not find a way down it will return that there is no way out of the maze, and return its result
 //This algorithm works for all cases however there are some which it will get caught in an infinite loop, however that is why we have reTrace, to make sure that it does not get stuck in infinite loops
 //retrace will make sure that all places visited by checkX and checkY will not be returned too, UNLESS it is moving backwards, as in that case it has no ways to go up it has to go back. 
 //For a flowchart of the algorithm: https://drive.google.com/file/d/1E6unzNgaPzQ1Km4c-0OwsL2YziF7QsRB/view?usp=sharing
 public char isEscape() //the method which is my algorithm
 {
 
  foundSol ='n'; //starts foundSol at 'n', for every iteration of the method 
 
   
  reTrace[checkX][checkY] = 'n'; //sets the starting spot on reTrace as been to
  
  //while there is no wall in front move forwards (depends on which player, which is why the +1 and +2 are multiplied by turnint, as for one player it is + 2 and for the other -2, turn int can either be 1 or -1, so it keeps track of which way that player moves when looking for  a way out)
  //will only move up as long as the space in front of it  y + 2, has not already been marked in reTrace
  while (foundSol == 'n' && possibleInt[checkX][checkY + 1*turnInt] == 0 && reTrace[checkX][checkY + 2*turnInt] == 'y' ) //there is space to go up, solution has not been discovered, space above has not been visted yet
  {
   checkY = checkY + 2*turnInt; //moves the Y value of checkY depending on which player you are it will be +2 or -2
   reTrace[checkX][checkY] = 'n';//sets the new place as marked
   if ((checkY == row - 1 && turn == 'r' )||(checkY == 0 && turn == 'b' ))      //checks if it has reached the goal, Player 1 - row -1 , Player 2 = 0
   {
    foundSol = 'y';
   }
  }
  
  if (foundSol == 'n')// if the solution has not been found, and you can not move up anymore as the loop above stopped it will scan side ways
  {
   scanSide(); //method which scans side ways
  }
  
  if (foundSol == 'n') //if none of the ways up yield a way to the goal it will de-increment and scan
  {
   while ( checkY != 0 && checkY != row -1 &&  possibleInt[checkX][checkY -1*turnInt] == 0 )//while it is not blocked from moving backwards
   {  
    checkY = checkY -2*turnInt; //move back (or forward depends on player)
    scanSide(); //after moving down it will scan the sides for anyway to go up
   }
  }
  if (foundSol == 'n' && (checkY == 0 || checkY == row -1 )) //if it reached the wrong end of the board it will scan the side and see if it can go up again, as this possibility is not covered in the next loop
  {
   scanSide();
  }
  if (checkY != 0 && checkY != row -1  && foundSol == 'n'  && possibleInt[checkX][checkY -1*turnInt] == 3  ) 
  {//makes sure it is not at any edges (so no array out of bounds errors happen), as well as there being a wall that prevents the player from moving straight backwards anymore
   saveX = checkX; //when moving sideways, the scan variables moves right all the way until it hits a wall or reaches the edge, they then go back to these save values and move in the other direction, if that does not bear fruit it returns to this spot and continues the algorithm
   saveY = checkY;//these save values are important so that scan does not waste time, and is more organized
   while (checkX < row && possibleInt[checkX + 1][checkY] == 0 ) //scans the right side and looks for a way down
   {   
    checkX = checkX + 2;//moves right
    reTrace[checkX][checkY] = 'n';//sets retrace for this spot to marked
    if ( possibleInt[checkX][checkY - 1*turnInt] == 0) //if there is space to move down
    {
     checkY = checkY -2*turnInt; //it will move down
     reTrace[checkX][checkY] = 'n';//set that space to marked 
     scanSide();//and scan for a way up
    }
    
   }
   checkX = saveX; //after scanning right it will return to its save values and scan left, and do the same thing as above but for the left this time
   checkY = saveY;
   while (checkX > 0 && possibleInt[checkX - 1][checkY] == 0 )
   {
    checkX = checkX - 2;
    reTrace[checkX][checkY] = 'n';
    if ( possibleInt[checkX][checkY - 1*turnInt] == 0)
    {
     checkY = checkY -2*turnInt;
     reTrace[checkX][checkY] = 'n';
     scanSide();
    }
   }
  }
  
  return foundSol;//returns foundSol which contains the result of whether there is a way out of the maze
}
 
 public void scanSide() //The scan side code was used so many times that I made it into a method so it was cleaner
 {
  saveX = checkX; //just like how we had to scan side ways, and look for a way down, we know try to do the same but look for a way up
  saveY = checkY; //it uses the same save variables so that it has a place to return after it's done moving in that direction, so it can go in the other direction
  
  while (checkX < row && checkX != row -1 && possibleInt[checkX + 1][checkY] == 0 && foundSol == 'n' && reTrace[checkX + 2][checkY]== 'y') //While there is no wall blocking the movement of moving right, it as well as it not being visited already by reTrace
  {
   checkX = checkX + 2; //if it meets the conditions it will move right
   reTrace[checkX][checkY] = 'n'; //set the place as marked
   
   
   if (possibleInt[checkX][checkY+1*turnInt] == 0 && reTrace[checkX][checkY + 2*turnInt]== 'y') //check if there is a way up if there is it will call the method again to perform the algorithm on the "branch"
   {
    foundSol = isEscape(); //calls itself
   }
   
   if (checkX == row -1 && foundSol == 'y') //if it has found a solution of if reach the max it can on that side it will leave this while loops
   {break;}
  }
  checkX = saveX; //will return to the save variables and move left 
  checkY = saveY;
  while (checkX > 0 && possibleInt[checkX - 1][checkY] == 0 && foundSol == 'n' && reTrace[checkX - 2][checkY]== 'y') //will do the same thing as as above but this time it is for the left side
  {
   checkX = checkX - 2;
   reTrace[checkX][checkY] = 'n';
   if (possibleInt[checkX][checkY+1*turnInt] == 0 && reTrace[checkX][checkY + 2*turnInt]== 'y')
   {
    foundSol = isEscape();
   }
   
   if (checkX == 0 && foundSol == 'y')//if it reaches the edge or it finds the solution it will break
   {break;}
  }
  
  
 }
}
 
