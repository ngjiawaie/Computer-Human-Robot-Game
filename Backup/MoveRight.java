/*
 * Coded by Teo Yong Zheng and Ng Jia Waie
 * This class implements the Composite Design Pattern
 */
public class MoveRight implements Action,java.io.Serializable{
	private Types actionType = Types.MOVE;
	public Types getActionType(){
		return actionType;
	}
	public Position performAction(Position current){
		current.setX( current.getX() + 1 );
		current.setDirection(Direction.EAST);
		return current;
	}
	public String toString(){
		return "Move Right";
	}
}