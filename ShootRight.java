/*
 * Coded by Teo Yong Zheng and Ng Jia Waie
 * This class implements the Composite Design Pattern
 */
public class ShootRight implements Action,java.io.Serializable{
	private Types actionType = Types.SHOOT;
	public Types getActionType(){
		return actionType;
	}
	public Position performAction(Position current){
		current.setX( current.getX() + 1 );
		current.setDirection(Direction.EAST);
		return current;
	}
	public String toString(){
		return "Shoot Right";
	}
}