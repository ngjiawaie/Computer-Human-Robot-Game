import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * Coded by Lee Bing Yuan and Darryl Cheng Lin Wei
 * This class implements the MVC design pattern (Model)
 */
public class RobotWar_Model implements java.io.Serializable{
	public HumanRobot hRobot;
	public ComputerRobot cRobot;
	private int numberOfTries;
	
	public RobotWar_Model(){
		initialize();
	}

	//First run initialize, or to re-initialize (Reset the game, and thus the computer sequence)
	public void initialize(){
		numberOfTries = 0;
		Position humanPosition = new Position(9,9,Direction.WEST);
		Position computerPosition = new Position(0,0,Direction.EAST);
		
		RobotIcon humanIcon = new RobotIcon();
		humanIcon.addIcon(Direction.NORTH, new ImageIcon("res/humanNORTH.png"));
		humanIcon.addIcon(Direction.SOUTH, new ImageIcon("res/humanSOUTH.png"));
		humanIcon.addIcon(Direction.EAST, new ImageIcon("res/humanEAST.png"));
		humanIcon.addIcon(Direction.WEST, new ImageIcon("res/humanWEST.png"));
		
		RobotIcon computerIcon = new RobotIcon();
		computerIcon.addIcon(Direction.NORTH, new ImageIcon("res/robotNORTH.png"));
		computerIcon.addIcon(Direction.SOUTH, new ImageIcon("res/robotSOUTH.png"));
		computerIcon.addIcon(Direction.EAST, new ImageIcon("res/robotEAST.png"));
		computerIcon.addIcon(Direction.WEST, new ImageIcon("res/robotWEST.png"));
		
		hRobot = new HumanRobot(humanPosition,humanIcon,18);
		cRobot = new ComputerRobot(computerPosition, computerIcon,18);
		cRobot.generateSequence(); //Generate 18 random Actions.
	}
	
	//Restart the current game by reinitializing Robot position and clearing human sequence which has failed.
	//This does not RESET the game, only restart the current game.
	public void restartCurrentGame(){ 
		Position humanPosition = new Position(9,9,Direction.WEST);
		Position computerPosition = new Position(0,0,Direction.EAST);
		
		hRobot.newPosition(humanPosition);
		hRobot.sequence.clear(); //Only need to clear human sequence
		cRobot.newPosition(computerPosition);
	}
	
	//If user requests a new game
	public void newGame(){
		initialize();
	}
	
	public void incrementNumberOfTries(){
		numberOfTries++;
	}
	
	public int getNumberOfTries(){
		return numberOfTries;
	}
	

	public void showWinner(Robot robot) {
		if(robot == hRobot){
			JOptionPane.showMessageDialog(null, "You Won!");
		}else{
			JOptionPane.showMessageDialog(null, "You Lose!");
		}
	}
}