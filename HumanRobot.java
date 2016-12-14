/*
 * Coded by Teo Yong Zheng and Ng Jia Waie
 * This class implements the Composite Design Pattern
 */
public class HumanRobot extends Robot implements java.io.Serializable {

	public HumanRobot(Position pos, RobotIcon robot, int maxSequence) {
		super(pos, robot,maxSequence);
	}

	public boolean addAction(Action action){
		return sequence.addAction(action);
	}
	
	public boolean undoAction(){
		return sequence.undoAction();
	}
}
