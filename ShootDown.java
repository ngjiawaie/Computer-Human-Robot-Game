/*
 * Coded by Teo Yong Zheng and Ng Jia Waie
 * This class implements the Composite Design Pattern
 */
public class ShootDown implements Action,java.io.Serializable{
	private Types actionType = Types.SHOOT;
	public Types getActionType(){
		return actionType;
	}
	public Position performAction(Position current){
		current.setY( current.getY() + 1 );
		current.setDirection(Direction.SOUTH);
		return current;
	}
	public String toString(){
		return "Shoot Down";
	}
}