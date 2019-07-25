package game;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JList;
import javax.swing.JTextField;

public class Quridor extends JFrame {

	private JPanel contentPane;
	int row = 17;
	JButton btns[][] = new JButton[row][row];
	char turn = 'r';
	int oldX;
	int oldY;
	int oldX2;
	int oldY2;
	JLabel errorM;
	int boardInt[][] = new int[17][17];
	char wallF = 'y';
	int oWallX;
	int oWallY;
	int checkX;
	int checkY;
	int saveX;
	int saveY;
    int possibleInt[][];
    char foundSol = 'n';
    char reTrace[][];
    private JPanel gameboard;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    int turnInt = 1;
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quridor frame = new Quridor();
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
	public Quridor() {
		        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel cardHolder = new JPanel();
		cardHolder.setBounds(0, 0, 1424, 687);
		contentPane.add(cardHolder);
						cardHolder.setLayout(null);
						
						JPanel gameScreen = new JPanel();
						gameScreen.setBounds(0, 0, 1426, 686);
						cardHolder.add(gameScreen);
						gameScreen.setLayout(null);
						
								gameboard = new JPanel();
								gameboard.setBounds(21, 64, 984, 602);
								gameScreen.add(gameboard);
								gameboard.setLayout(new GridLayout(17, 17, 0, 0));
								
										errorM = new JLabel("New label");
										errorM.setBounds(1054, 513, 327, 153);
										gameScreen.add(errorM);
										errorM.setFont(new Font("Tahoma", Font.PLAIN, 15));
										
										JLabel lblsTurn = new JLabel("_______'s turn");
										lblsTurn.setBounds(1120, 15, 232, 43);
										gameScreen.add(lblsTurn);
										lblsTurn.setFont(new Font("Tahoma", Font.PLAIN, 35));
										
										JLabel lblsWalls = new JLabel("__________ 's Walls left: ___");
										lblsWalls.setBounds(1044, 266, 258, 21);
										gameScreen.add(lblsWalls);
										lblsWalls.setFont(new Font("Tahoma", Font.BOLD, 17));
										
										JLabel lblsWalls_1 = new JLabel("__________ 's Walls left: ___");
										lblsWalls_1.setBounds(1044, 214, 258, 21);
										gameScreen.add(lblsWalls_1);
										lblsWalls_1.setFont(new Font("Tahoma", Font.BOLD, 17));
										
										JLabel lblStats = new JLabel("Stats:");
										lblStats.setBounds(1054, 121, 69, 28);
										gameScreen.add(lblStats);
										lblStats.setFont(new Font("Tahoma", Font.BOLD, 23));
										
										JLabel lblQuoridor = new JLabel("Quoridor!");
										lblQuoridor.setBounds(274, 0, 240, 61);
										gameScreen.add(lblQuoridor);
										lblQuoridor.setFont(new Font("Tahoma", Font.BOLD, 50));
										
										JLabel lblNewLabel = new JLabel("Error Message:");
										lblNewLabel.setBounds(1054, 449, 233, 43);
										gameScreen.add(lblNewLabel);
										lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
										lblNewLabel.setForeground(Color.RED);
						
						JPanel Instructions = new JPanel();
						Instructions.setBounds(0, 0, 10, 10);
						cardHolder.add(Instructions);
						
						JPanel WinScreen = new JPanel();
						WinScreen.setBounds(0, 0, 1426, 686);
						cardHolder.add(WinScreen);
						WinScreen.setLayout(null);
						
						JLabel lblPlayerWins = new JLabel("Player _____ WINS!");
						lblPlayerWins.setFont(new Font("Tahoma", Font.BOLD, 53));
						lblPlayerWins.setBounds(389, 142, 815, 336);
						WinScreen.add(lblPlayerWins);
						
						JButton btnNewButton_1 = new JButton("Menu");
						btnNewButton_1.setBounds(443, 418, 89, 23);
						WinScreen.add(btnNewButton_1);
						
						JButton btnNewButton_2 = new JButton("Play Again?");
						btnNewButton_2.setBounds(699, 418, 89, 23);
						WinScreen.add(btnNewButton_2);
						
						JPanel Options = new JPanel();
						Options.setBounds(0, 0, 1426, 686);
						cardHolder.add(Options);
						Options.setLayout(null);
						
						JLabel lblPlayer_2 = new JLabel("Player 1:");
						lblPlayer_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
						lblPlayer_2.setBounds(24, 57, 308, 90);
						Options.add(lblPlayer_2);
						
						JLabel lblChooseAColour = new JLabel("Choose a colour to represent yourself:");
						lblChooseAColour.setFont(new Font("Tahoma", Font.BOLD, 20));
						lblChooseAColour.setBounds(24, 147, 411, 100);
						Options.add(lblChooseAColour);
						
						JList list = new JList();
						list.setBounds(435, 147, 164, 100);
						Options.add(list);
						
						JLabel lblChooseYourUsername = new JLabel("Choose your username:");
						lblChooseYourUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
						lblChooseYourUsername.setBounds(24, 273, 336, 28);
						Options.add(lblChooseYourUsername);
						
						textField = new JTextField();
						textField.setBounds(291, 281, 208, 20);
						Options.add(textField);
						textField.setColumns(10);
						
						JLabel lblNewLabel_3 = new JLabel("Player 2:");
						lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
						lblNewLabel_3.setBounds(757, 85, 196, 63);
						Options.add(lblNewLabel_3);
						
						JLabel lblNewLabel_4 = new JLabel("Choose a colour to represent yourself:");
						lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
						lblNewLabel_4.setBounds(748, 174, 411, 46);
						Options.add(lblNewLabel_4);
						
						JList list_1 = new JList();
						list_1.setBounds(1136, 147, 238, 100);
						Options.add(list_1);
						
						JLabel lblNewLabel_5 = new JLabel("Choose your username:");
						lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
						lblNewLabel_5.setBounds(753, 269, 255, 36);
						Options.add(lblNewLabel_5);
						
						textField_1 = new JTextField();
						textField_1.setBounds(1103, 281, 271, 20);
						Options.add(textField_1);
						textField_1.setColumns(10);
						
						JLabel lblNewLabel_6 = new JLabel("Game Options:");
						lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 35));
						lblNewLabel_6.setBounds(444, 11, 750, 82);
						Options.add(lblNewLabel_6);
						
						JLabel lblNewLabel_7 = new JLabel("Board Options:");
						lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 25));
						lblNewLabel_7.setBounds(477, 364, 342, 90);
						Options.add(lblNewLabel_7);
						
						JLabel lblBoardSize = new JLabel("Board Size:");
						lblBoardSize.setFont(new Font("Tahoma", Font.PLAIN, 20));
						lblBoardSize.setBounds(291, 448, 196, 46);
						Options.add(lblBoardSize);
						
						textField_2 = new JTextField();
						textField_2.setBounds(435, 460, 308, 20);
						Options.add(textField_2);
						textField_2.setColumns(10);
						
						JPanel Title = new JPanel();
						Title.setBounds(0, 0, 1426, 686);
						cardHolder.add(Title);
						Title.setLayout(null);
						
						JLabel lblNewLabel_1 = new JLabel("Quoridor");
						lblNewLabel_1.setBounds(472, 83, 528, 207);
						lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 71));
						Title.add(lblNewLabel_1);
						
						JLabel lblOnline = new JLabel("Online");
						lblOnline.setFont(new Font("Tahoma", Font.BOLD, 47));
						lblOnline.setBounds(705, 223, 463, 88);
						Title.add(lblOnline);
						
						JButton reset = new JButton("Reset");
						reset.setBounds(1284, 11, 121, 37);
						Title.add(reset);
						
						JButton btnNewButton = new JButton("Play!");
						btnNewButton.setBackground(Color.RED);
						btnNewButton.setForeground(Color.RED);
						btnNewButton.setBounds(507, 538, 280, 120);
						Title.add(btnNewButton);
						
						JLabel lblNewLabel_2 = new JLabel("By: Rahul.G");
						lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
						lblNewLabel_2.setBounds(1293, 636, 133, 50);
						Title.add(lblNewLabel_2);
						
						JLabel lblPlayer = new JLabel("Player 1 # of wins : ____");
						lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 30));
						lblPlayer.setBounds(420, 346, 386, 46);
						Title.add(lblPlayer);
						
						JLabel lblPlayer_1 = new JLabel("Player 2 # of wins: ___");
						lblPlayer_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
						lblPlayer_1.setBounds(420, 429, 369, 37);
						Title.add(lblPlayer_1);

		for (int y = 0; y < row; y++) {

			for (int x = 0; x < row; x++) {

				btns[x][y] = new JButton(""); // + boardInt[x][y]
				btns[x][y].setActionCommand("" + (x * 100 + y));

				gameboard.add(btns[x][y]);

				if (y % 2 == 0 || y % 2 == 2) {
					if (x % 2 == 0 || x % 2 == 2) {
						btns[x][y].setBackground(Color.cyan);
						btns[x][y].addActionListener(new PlayerMoveBtn());
					}

					else {
						btns[x][y].setBackground(new Color(192, 192, 192));
						btns[x][y].addActionListener(new WallBtn());
					}
				} else {

					btns[x][y].setBackground(new Color(192, 192, 192));
					btns[x][y].addActionListener(new WallBtn());
				}

			}

		}

		for (int y = 0; y < row; y++) {
			for (int x = 0; x < row; x++) {
				boardInt[x][y] = 0;
			}

		}

		int start = row / 2;
		boardInt[start][0] = 1;
		btns[start][0].setBackground(new Color(255, 0, 0));
		oldX = start;
		oldY = 0;
		btns[start][row - 1].setBackground(new Color(0, 255, 0));
		oldX2 = start;
		oldY2 = row - 1;
		boardInt[start][row-1] = 2;
	}

	protected static ImageIcon createImageIcon(String path) // create image method
	{
		java.net.URL imgURL = Quridor.class.getResource(path);
		if (imgURL != null)
			return new ImageIcon(imgURL);
		else {
			System.err.println("Couldn't find file: " + path);
			return null;

		}
	}

	class PlayerMoveBtn implements ActionListener { //somewhere because of oldX oldY FIX REALLY SOON
		public void actionPerformed(ActionEvent e) {

			String place = e.getActionCommand();
			int posR = Integer.parseInt(place);
			int posY = posR % 100;
			int posX = (posR - posY) / 100;
            int oldSpotX;
            int oldSpotY;
            
			if (turn == 'r')
			{
				oldSpotX = oldX;
				oldSpotY = oldY;
				movePlayer(posX, posY, oldSpotX, oldSpotY);
				
			}
			else
			{
				oldSpotX = oldX2;
				oldSpotY = oldY2;
				movePlayer(posX, posY, oldSpotX, oldSpotY);
					
			}
		
		}
	}
	
	public void movePlayer (int posX, int posY, int oldSpotX, int oldSpotY)
	{
	 if ((posX ==  oldX && posY == oldY)||(posX ==  oldX2 && posY == oldY2))
	 {errorM.setText("Another player is on that spot!");}
	 else
	 {if (posX == oldSpotX + 2 && oldSpotY == posY) {
			if (boardInt[oldSpotX][oldSpotY] > boardInt[oldSpotX + 1][oldSpotY]) {
				playerMove(posX, posY);
				boardInt[oldSpotX][oldSpotY] = 0;
				if (turn == 'r')
				{
					turn = 'b';
					turnInt = -1;
				}
				else
				{
					turn = 'r';
					turnInt = 1;
							
				}

			}

			else {
				errorM.setText("A wall blocks your path!");

			}

		}

		else if (posX == oldSpotX - 2 && oldSpotY == posY) {
			if (boardInt[oldSpotX][oldSpotY] > boardInt[oldSpotX - 1][oldSpotY]) {
				playerMove(posX, posY);
				boardInt[oldSpotX][oldSpotY] = 0;
				if (turn == 'r')
				{
					turn = 'b';
					turnInt = -1;
				}
				else
				{
					turn = 'r';
					turnInt = 1;
							
				}
			}

			else {
				errorM.setText("A wall blocks your path!");

			}

		}

		else if (posY == oldSpotY + 2 && oldSpotX == posX) {
			if (boardInt[oldSpotX][oldSpotY] > boardInt[oldSpotX][oldSpotY + 1]) {
				playerMove(posX, posY);
				boardInt[oldSpotX][oldSpotY] = 0;
				if (turn == 'r')
				{
					turn = 'b';
					turnInt = -1;
				}
				else
				{
					turn = 'r';
					turnInt = 1;
							
				}

			}

			else {
				errorM.setText("A wall blocks your path!");

			}

		}

		else if (posY == oldSpotY - 2 && oldSpotX == posX) {
			if (boardInt[oldSpotX][oldSpotY] > boardInt[oldSpotX][oldSpotY - 1]) {
				playerMove(posX, posY);
				boardInt[oldSpotX][oldSpotY] = 0;
				if (turn == 'r')
				{
					turn = 'b';
					turnInt = -1;
				}
				else
				{
					turn = 'r';
					turnInt = 1;
							
				}

			}

			else {
				errorM.setText("A wall blocks your path!");

			}

		}

		else {
			errorM.setText("Pick a valid spot!");

		}
	if (turn == 'r')
	{
		boardInt[posX][posY] = 1;
	}
	else
	{
		boardInt[posX][posY] = 2;
	}
	}
	 		
	}

	class WallBtn implements ActionListener {
		public void actionPerformed(ActionEvent e) 
		{
			
			char selfOut = 'f';
			char enemyOut = 'f';
			String place = e.getActionCommand();

			int posR = Integer.parseInt(place);
			int posY = posR % 100;
			int posX = (posR - posY) / 100;
		
			possibleInt = boardInt.clone();
			possibleInt[posX][posY] = 3;
			saveX = 0;
			foundSol = 'n';
			possibleInt = boardInt.clone();
			reTrace = new char [row][row];
						
		   	for (int i = 0; i < row; i++)
			{ 
				Arrays.fill(reTrace[i], 'y');
			}
					
	        		
	        if (turn == 'r')
			{
				checkX = oldX;
				checkY = oldY;
				selfOut = isEscape();
				checkX = oldX2;
				checkY = oldY2;
				turnInt = -1;
				enemyOut = isEscape();
				turnInt = 1;
			}
			else 
			{
				checkX = oldX2;
				checkY = oldY2;
				selfOut = isEscape();
				checkX = oldX;
				checkY = oldY;
				turnInt = 1;
				enemyOut = isEscape();
				turnInt = -1;
			}	
	        
	        if (selfOut == 'y'&& enemyOut == 'y')
	        {
	        	foundSol = 'y';
	        }
	        else
	        {foundSol = 'n';}
	        if (selfOut == 'n')
	        { errorM.setText("You're blocking yourself!");}
		
			
			
			
	if (foundSol == 'y')
	{
			if(wallF=='y')

			{
				btns[posX][posY].setBackground(new Color(0, 0, 0));
				possibleInt[posX][posY] = 1; // walls = 3, player 1 = 1, player 2 = 2
				oWallX = posX;
				oWallY = posY;
				wallF = 'f';
			}
			else
			{
				if (((posX == oWallX + 1 || posX == oWallX - 1) && oWallY == posY)
						|| ((posY == oWallY + 1 || posY == oWallY - 1) && oWallX == posX)) {
					wallF = 'y';
					btns[posX][posY].setBackground(new Color(0, 0, 0));
					possibleInt[posX][posY] = 1; // walls = 3, player 1 = 1, player 2 = 2
					oWallX = posX;
					oWallY = posY;
				} else {
					errorM.setText("Please place the wall in the correct spot!");
				}

			}
	}
	else 
	{
		errorM.setText("Stop blocking the other player!");
		
	}
	}


	}
	public void playerMove (int posX, int posY)
	{
	 if (turn == 'r')
	 {
		btns[oldX][oldY].setBackground(Color.cyan);
		btns[posX][posY].setBackground(new Color (255,0,0));
		oldX = posX;
		oldY = posY;
	 }
	 else 
	 {
		 btns[oldX2][oldY2].setBackground(Color.cyan);
		 btns[posX][posY].setBackground(new Color (0,255,0));
		 oldX2 = posX;
		 oldY2 = posY;
	 }
	}

	public char isEscape()
	{
	
		foundSol ='n'; //MOVE BACK TO OG METHOD BUTN
		possibleInt[checkX][checkY] = 3;//may have to change to somethig else VOLATILE
	  
		reTrace[checkX][checkY] = 'n'; //volatile
		
		while (foundSol == 'n' && possibleInt[checkX][checkY + 1*turnInt] == 0 && reTrace[checkX][checkY + 2*turnInt] == 'y' ) //there is space to go up, has not been discovered, ssolution is not found
		{
			checkY = checkY + 2*turnInt;
			reTrace[checkX][checkY] = 'n';
			if ((checkY == row - 1 && turn == 'r' )||(checkY == 0 && turn == 'b' ))      
			{
				foundSol = 'y';
			}
		}
		
		if (foundSol == 'n')// move sideways code
		{
			scanSide();
		}
		
		if (foundSol == 'n') //move 1 down and scan
		{
			while ( checkY != 0 && checkY != row -1 &&  possibleInt[checkX][checkY -1*turnInt] == 0 )
			{		
				checkY = checkY -2*turnInt;
				scanSide();
			}
		}
		if (foundSol == 'n' && (checkY == 0 || checkY == row -1 ))
		{
			scanSide();
		}
		if (checkY != 0 && checkY != row -1  && foundSol == 'n'  && possibleInt[checkX][checkY -1*turnInt] == 3  ) //hit dead end, look for way down, look for way up
		{
			saveX = checkX;
			saveY = checkY;
			while (checkX < row && possibleInt[checkX + 1][checkY] == 0 )
			{			
				checkX = checkX + 2;
				reTrace[checkX][checkY] = 'n';
				if ( possibleInt[checkX][checkY - 1*turnInt] == 0)
				{
					checkY = checkY -2*turnInt;
					reTrace[checkX][checkY] = 'n';
					scanSide();
				}
				
			}
			checkX = saveX;
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
		
		return foundSol;//add in the check is things is solved code
	}
	
	public void scanSide()
	{
		saveX = checkX;
		saveY = checkY; //VOLATILE
		
		while (checkX < row && checkX != row -1 && possibleInt[checkX + 1][checkY] == 0 && foundSol == 'n' && reTrace[checkX + 2][checkY]== 'y') //checkX < row && possibleInt[checkX + 1][checkY] == 0 && foundSol == 'n' && reTrace[checkX + 2][checkY]== 'y'
		{
			checkX = checkX + 2;
			reTrace[checkX][checkY] = 'n';
			
			
			if (possibleInt[checkX][checkY+1*turnInt] == 0 && reTrace[checkX][checkY + 2*turnInt]== 'y')
			{
				foundSol = isEscape();
			}
			
			if (checkX == row -1 && foundSol == 'y')
			{break;}
		}
		checkX = saveX;
		checkY = saveY;//VOLATILE
		while (checkX > 0 && possibleInt[checkX - 1][checkY] == 0 && foundSol == 'n' && reTrace[checkX - 2][checkY]== 'y')
		{
			checkX = checkX - 2;
			reTrace[checkX][checkY] = 'n';
			if (possibleInt[checkX][checkY+1*turnInt] == 0 && reTrace[checkX][checkY + 2*turnInt]== 'y')
			{
				foundSol = isEscape();
			}
			
			if (checkX == 0 && foundSol == 'y')
			{break;}
		}
		
		
	}
	
	
}
	
