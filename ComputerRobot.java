/*
 * Coded by Teo Yong Zheng and Ng Jia Waie
 * This class implements the Composite Design Pattern
 */
public class ComputerRobot extends Robot implements java.io.Serializable{

	public ComputerRobot(Position pos, RobotIcon robot, int maxSequence) {
		super(pos, robot, maxSequence);
	}

	public void generateSequence(){
		for(int i=0;i< maxSequence ;i++){
			sequence.addAction(ActionEnum.getRandomAction());
		}
		
	}

}
