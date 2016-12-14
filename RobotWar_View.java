import javax.swing.*;
import java.awt.*;

/*
 * Coded by Lee Bing Yuan and Darryl Cheng Lin Wei
 * This class implements the MVC design pattern (View)
 */
public class RobotWar_View extends JFrame{
	int boardDimX, boardDimY;
	
	JLabel [][] gameGrid;
	JLabel[] sequenceText;
	JLabel attempts = new JLabel("Number of Attempts: 0");
	JLabel actionDirection;
	
	JButton shootUp = new JButton();
	JButton shootDown = new JButton();
	JButton shootLeft = new JButton();
	JButton shootRight = new JButton();
	JButton moveUp = new JButton();
	JButton moveDown = new JButton();
	JButton moveLeft = new JButton();
	JButton moveRight = new JButton();
	JButton undo = new JButton();
	JButton execute = new JButton();
	JButton clear = new JButton();
	JButton newGame = new JButton();
	JButton saveGame = new JButton();
	JButton loadGame = new JButton();
	
	JPanel actionMove;
	JPanel actionShoot;
	JToggleButton moveOrShoot;
	
 	RobotWar_View(int boardDimX, int boardDimY){
		super("RobotWar");
		this.boardDimX = boardDimX;
		this.boardDimY = boardDimY;	
		
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc;
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.weightx = 0.6;
		gbc.weighty = 1.0;
		mainPanel.add(initGamePanel(),gbc);
		
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.weightx = 0.15;
		gbc.weighty = 1.0;
		mainPanel.add(initSequencePanel(),gbc);
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.weightx = 0.15;
		gbc.weighty = 1.0;
		mainPanel.add(initControlPanel(),gbc);
		
		this.add(mainPanel);
		this.setMinimumSize(new Dimension(1200,600));
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private JPanel initControlPanel() {
		ImageIcon i_up = new ImageIcon("res/Button_Up.png"); 
		ImageIcon i_up_clicked = new ImageIcon("res/Button_Up_Clicked.png");
		ImageIcon i_down = new ImageIcon("res/Button_Down.png");
		ImageIcon i_down_clicked = new ImageIcon("res/Button_Down_Clicked.png");	
		ImageIcon i_left = new ImageIcon("res/Button_Left.png");
		ImageIcon i_left_clicked = new ImageIcon(("res/Button_Left_Clicked.png"));		
		ImageIcon i_right = new ImageIcon(("res/Button_Right.png"));
		ImageIcon i_right_clicked = new ImageIcon(("res/Button_Right_Clicked.png"));		
		ImageIcon i_move = new ImageIcon(("res/M_Normal.png"));
		ImageIcon i_move_clicked = new ImageIcon(("res/M_Clicked.png"));
		ImageIcon i_shoot = new ImageIcon(("res/S_Normal.png"));	
		ImageIcon i_shoot_clicked = new ImageIcon(("res/S_Clicked.png"));
		ImageIcon i_undo = new ImageIcon(("res/Button_Undo.png"));
		ImageIcon i_undo_clicked = new ImageIcon(("res/Button_Undo_Clicked.png"));	
		ImageIcon i_exec = new ImageIcon(("res/Button_Execute.png"));
		ImageIcon i_exec_clicked = new ImageIcon(("res/Button_Execute_Clicked.png"));			
		ImageIcon i_clear = new ImageIcon(("res/Button_Clear.png"));
		ImageIcon i_clear_clicked = new ImageIcon("res/Button_Clear_Clicked.png");	
		
		i_up = resize(i_up,50,50);
		i_up_clicked = resize(i_up_clicked,50,50);
		i_down = resize(i_down,50,50);
		i_down_clicked = resize(i_down_clicked,50,50);			
		i_left = resize(i_left,50,50);
		i_left_clicked = resize(i_left_clicked,50,50);		
		i_right = resize(i_right,50,50);
		i_right_clicked = resize(i_right_clicked,50,50);		
		i_move = resize(i_move,110,110);
		i_move_clicked = resize(i_move_clicked,110,110);
		i_shoot = resize(i_shoot,100,100);
		i_shoot_clicked = resize(i_shoot_clicked,100,100);
		i_undo = resize(i_undo, 64, 64);
		i_undo_clicked = resize(i_undo_clicked, 64, 64);		
		i_exec = resize(i_exec, 64, 64);
		i_exec_clicked = resize(i_exec_clicked, 64, 64);
		i_clear = resize(i_clear, 64, 64);
		i_clear_clicked = resize(i_clear_clicked, 64, 64);		

		moveUp.setPreferredSize(new Dimension(50,50));
		moveDown.setPreferredSize(new Dimension(50,50));
		moveLeft.setPreferredSize(new Dimension(50,50));
		moveRight.setPreferredSize(new Dimension(50,50));
		shootUp.setPreferredSize(new Dimension(50,50));
		shootDown.setPreferredSize(new Dimension(50,50));
		shootLeft.setPreferredSize(new Dimension(50,50));
		shootRight.setPreferredSize(new Dimension(50,50));
		undo.setPreferredSize(new Dimension(64,64));
		execute.setPreferredSize(new Dimension(64,64));
		clear.setPreferredSize(new Dimension(64,64));

		moveUp.setIcon(i_up);
		moveUp.setRolloverIcon(i_up_clicked);
		moveUp.setDisabledIcon(i_up_clicked);		
		moveUp.setBorderPainted(false); 
        moveUp.setContentAreaFilled(false); 
        moveUp.setFocusPainted(false); 
        moveUp.setOpaque(false);

		moveDown.setIcon(i_down);
		moveDown.setRolloverIcon(i_down_clicked);
		moveDown.setDisabledIcon(i_down_clicked);		
		moveDown.setBorderPainted(false); 
        moveDown.setContentAreaFilled(false); 
        moveDown.setFocusPainted(false); 
        moveDown.setOpaque(false);

		moveLeft.setIcon(i_left);
		moveLeft.setRolloverIcon(i_left_clicked);
		moveLeft.setDisabledIcon(i_left_clicked);		
		moveLeft.setBorderPainted(false); 
        moveLeft.setContentAreaFilled(false); 
        moveLeft.setFocusPainted(false); 
        moveLeft.setOpaque(false);

		moveRight.setIcon(i_right);
		moveRight.setRolloverIcon(i_right_clicked);
		moveRight.setDisabledIcon(i_right_clicked);		
		moveRight.setBorderPainted(false); 
        moveRight.setContentAreaFilled(false); 
        moveRight.setFocusPainted(false); 
        moveRight.setOpaque(false);	

		shootUp.setIcon(i_up);
		shootUp.setRolloverIcon(i_up_clicked);
		shootUp.setDisabledIcon(i_up_clicked);		
		shootUp.setBorderPainted(false); 
        shootUp.setContentAreaFilled(false); 
        shootUp.setFocusPainted(false); 
        shootUp.setOpaque(false);

		shootDown.setIcon(i_down);
		shootDown.setRolloverIcon(i_down_clicked);
		shootDown.setDisabledIcon(i_down_clicked);		
		shootDown.setBorderPainted(false); 
        shootDown.setContentAreaFilled(false); 
        shootDown.setFocusPainted(false); 
        shootDown.setOpaque(false);

		shootLeft.setIcon(i_left);
		shootLeft.setRolloverIcon(i_left_clicked);
		shootLeft.setDisabledIcon(i_left_clicked);		
		shootLeft.setBorderPainted(false); 
        shootLeft.setContentAreaFilled(false); 
        shootLeft.setFocusPainted(false); 
        shootLeft.setOpaque(false);

		shootRight.setIcon(i_right);
		shootRight.setRolloverIcon(i_right_clicked);
		shootRight.setDisabledIcon(i_right_clicked);		
		shootRight.setBorderPainted(false); 
        shootRight.setContentAreaFilled(false); 
        shootRight.setFocusPainted(false); 
        shootRight.setOpaque(false);	
        
        moveOrShoot = new JToggleButton();
        moveOrShoot.setIcon(i_move);
        moveOrShoot.setRolloverIcon(i_move_clicked);       
        moveOrShoot.setSelectedIcon(i_shoot);
        moveOrShoot.setRolloverSelectedIcon(i_shoot_clicked);       
 		moveOrShoot.setBorderPainted(false); 
        moveOrShoot.setContentAreaFilled(false); 
        moveOrShoot.setFocusPainted(false); 
        moveOrShoot.setOpaque(false);       
        
        undo.setIcon(i_undo);
		undo.setRolloverIcon(i_undo_clicked);
		undo.setDisabledIcon(i_undo_clicked);
		undo.setBorderPainted(false); 
        undo.setContentAreaFilled(false); 
        undo.setFocusPainted(false); 
        undo.setOpaque(false);

        execute.setIcon(i_exec);
		execute.setRolloverIcon(i_exec_clicked);
		execute.setDisabledIcon(i_exec_clicked);
		execute.setBorderPainted(false); 
        execute.setContentAreaFilled(false); 
        execute.setFocusPainted(false); 
        execute.setOpaque(false);

        clear.setIcon(i_clear);
		clear.setRolloverIcon(i_clear_clicked);
		clear.setDisabledIcon(i_clear_clicked);
		clear.setBorderPainted(false); 
        clear.setContentAreaFilled(false); 
        clear.setFocusPainted(false); 
        clear.setOpaque(false);
		
		JPanel controlpanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		attempts = new JLabel("Number of Attempts: 0");
		attempts.setHorizontalAlignment(SwingConstants.LEFT);
		attempts.setFont(new Font("Roboto",Font.BOLD,25));
		
		JLabel actionType = new JLabel("Toggle Action: ");
		actionType.setHorizontalAlignment(SwingConstants.LEFT);		
		actionType.setFont(new Font("Roboto",Font.BOLD,25));

		JPanel selectAction = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));	
		selectAction.add(moveOrShoot);

		actionDirection = new JLabel("Enter move direction:");
		actionDirection.setFont(new Font("Roboto",Font.BOLD,25));	

		actionMove = new JPanel(new GridBagLayout());
		gbc.gridx=1;
		gbc.gridy=0;
		actionMove.add(moveUp,gbc);
		gbc.gridx=1;
		gbc.gridy=2;
		actionMove.add(moveDown,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		actionMove.add(moveLeft,gbc);
		gbc.gridx=2;
		gbc.gridy=1;
		actionMove.add(moveRight,gbc);
		
		actionShoot = new JPanel(new GridBagLayout());
		gbc.gridx=1;
		gbc.gridy=0;
		actionShoot.add(shootUp,gbc);
		gbc.gridx=1;
		gbc.gridy=2;
		actionShoot.add(shootDown,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		actionShoot.add(shootLeft,gbc);
		gbc.gridx=2;
		gbc.gridy=1;
		actionShoot.add(shootRight,gbc);
		actionShoot.setVisible(false);

		JPanel operations = new JPanel(new FlowLayout());
		newGame.setText("New Game");
		saveGame.setText("Save Game");
		loadGame.setText("Load Game");
		operations.add(newGame);
		operations.add(saveGame);
		operations.add(loadGame);
		
		JPanel bottom_pane = new JPanel(new FlowLayout(FlowLayout.LEFT,25,25));
		bottom_pane.add(clear);
		bottom_pane.add(undo);
		bottom_pane.add(execute);
		gbc.insets = new Insets(0,0,10,0);
		gbc.gridx = 0;
		gbc.gridy = 1;
		controlpanel.add(attempts,gbc);	
		gbc.insets = new Insets(10,0,10,0);
		gbc.gridx = 0;
		gbc.gridy = 2;		
		controlpanel.add(actionType,gbc);
		gbc.insets = new Insets(20,0,20,0);				
		gbc.gridx = 0;
		gbc.gridy = 3;		
		controlpanel.add(selectAction,gbc);
		gbc.insets = new Insets(10,0,10,0);
		gbc.gridx = 0;
		gbc.gridy = 4;		
		controlpanel.add(actionDirection,gbc);
		gbc.insets = new Insets(20,0,20,0);		
		gbc.gridx = 0;
		gbc.gridy = 5;					
		controlpanel.add(actionMove,gbc);
		controlpanel.add(actionShoot,gbc);
		gbc.insets = new Insets(30,0,0,0);		
		gbc.gridx = 0;
		gbc.gridy = 6;									
		controlpanel.add(bottom_pane,gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;	
		controlpanel.add(operations,gbc);
		return controlpanel;
	}


	private JPanel initGamePanel() {
		JPanel gamePanel = new JPanel(new GridLayout(boardDimX,boardDimY));

		gameGrid = new JLabel[boardDimX][boardDimY];
		for(JLabel[] grids:gameGrid){
			for(int i=0;i<boardDimY;i++){
				grids[i] = new JLabel();
				grids[i].setBackground(Color.WHITE);
				grids[i].setEnabled(true);
				grids[i].setOpaque(true);
				grids[i].setPreferredSize(new Dimension(50,50));
				grids[i].setBorder(BorderFactory.createLineBorder(Color.black));
				gamePanel.add(grids[i]);
			}
		}
		return gamePanel;
	}
	
	private JPanel initSequencePanel(){
		int numberOfSequence = 18;
		JPanel seqPanel = new JPanel(new GridLayout(numberOfSequence+2,0));
		JLabel text = new JLabel("Your Sequence:");
		text.setFont(new Font("Roboto",Font.BOLD,25));
		seqPanel.add(text);
		sequenceText = new JLabel[numberOfSequence];
		for(int i=0;i<numberOfSequence;i++){
			sequenceText[i] = new JLabel();
			sequenceText[i].setFont(new Font("Roboto",Font.BOLD,15));
			seqPanel.add(sequenceText[i]);
		}
		seqPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		return seqPanel;
	}
	
	private ImageIcon resize(ImageIcon a, int dimx, int dimy){
		Image image = a.getImage();
		Image newimage = image.getScaledInstance(dimx,dimy,java.awt.Image.SCALE_SMOOTH);
		a = new ImageIcon(newimage);
		return a;
	}
	
	public void setIcon(ImageIcon icon, Position pos){
		gameGrid[pos.getY()][pos.getX()].setIcon(icon);
	}
	
	public boolean hasRobot(Position pos){
		return gameGrid[pos.getY()][pos.getX()].getIcon() != null &&  gameGrid[pos.getY()][pos.getX()].getIcon() != Attack.image.getImage();
	}
	
	public boolean hasAttack(Position pos){
		return gameGrid[pos.getY()][pos.getX()].getIcon() != null &&  gameGrid[pos.getY()][pos.getX()].getIcon() == Attack.image.getImage();
	}
	
	//Clear the whole game board
	public void clearGameBoard(){
		for(JLabel [] lbl: gameGrid){
			for(JLabel label: lbl){
				label.setIcon(null);
			}
		}
	}
	
	public void setNumberOfAttempts(int num){
		attempts.setText("Number of Attempts: "+num);
	}
	
	//Clear and game board and the user sequence printed on the UI
	public void restartInitialBoardState(){
		for(JLabel text: sequenceText){
			text.setText("");
		}
		clearGameBoard();
	}

	//Controls need to be disabled when the game is in execution. 
	//since the game is executed on a different thread.
	public void disableControls(){
		newGame.setEnabled(false);
		saveGame.setEnabled(false);
		loadGame.setEnabled(false);
		clear.setEnabled(false);
		undo.setEnabled(false);
		execute.setEnabled(false);
	}
	
	//Re-enable the controls once the game has finished executing
	public void enableControls(){
		newGame.setEnabled(true);
		saveGame.setEnabled(true);
		loadGame.setEnabled(true);
		clear.setEnabled(true);
		undo.setEnabled(true);
		execute.setEnabled(true);
	}
	
	//To show list of sequence selected by user
	public void updateSequenceLabel(Sequence sequence) {
		Iterator iterator = sequence.getIterator();
		while(iterator.hasNext()){
			int index = iterator.getIndex();
			sequenceText[index].setText((index+1) + ". " +iterator.next().toString());
		}
	}

	
}
