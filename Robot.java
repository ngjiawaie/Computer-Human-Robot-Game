import javax.swing.ImageIcon;

/*
 * Coded by Teo Yong Zheng and Ng Jia Waie
 * This class implements the Composite Design Pattern
 */
public abstract class Robot implements java.io.Serializable{
	protected Position pos;
	protected RobotIcon robot;
	protected Sequence sequence;
	protected int maxSequence;
	
	public Robot(Position pos, RobotIcon robot, int maxSequence){
		this.pos = pos;
		this.robot = robot;
		sequence = new Sequence(maxSequence);
		this.maxSequence = maxSequence;
	}
	public Position getPosition(){
		return pos;
	}

	public void newPosition(Position pos){
		this.pos = pos;
	}
	
	public ImageIcon getRobotIcon(){
		return robot.getIcon(pos.getDirection());
	}

	public void setFacingDirection(Direction direction){
		pos.setDirection(direction);
	}
	public Sequence getSequence(){
		return sequence;
	}
	
}