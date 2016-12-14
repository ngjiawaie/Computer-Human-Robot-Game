/*
 * Coded by Teo Yong Zheng and Ng Jia Waie
 * This interface implements the Composite Design Pattern
 */
public interface Action{
	public enum Types{SHOOT,MOVE};
	public Position performAction(Position current);
	public Types getActionType();
	public String toString();
}