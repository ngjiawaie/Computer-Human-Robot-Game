/*
 * Coded by Teo Yong Zheng and Ng Jia Waie
 */

public class Position implements java.io.Serializable{
	private int x;
	private int y;
	private Direction direction;

	public Position(int x, int y, Direction direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Position(Position pos) {
		x = pos.x;
		y = pos.y;
		direction = pos.direction;
	}
	
	public void setDirection(Direction direction){
		this.direction = direction;
	}

	public Direction getDirection(){
		return direction;
	}


	public int getX(){
		return x;
	}

	public boolean setX(int x){
		if (x >= 0 && x < 10) {
			this.x = x;
			return true;
		}else{
			return false;
		}
	}

	public int getY(){
		return y;
	}

	public boolean setY(int y){
		if (y >= 0 && y < 10) {
			this.y = y;
			return true;
		}else{
			return false;
		}
	}	

	public boolean isSamePosition(Position pos){
		return pos.x == x && pos.y == y;
	}

}