import java.util.Random;

/*
 * Coded by Darryl Cheng Lin Wei
 * This enum implements the singleton design pattern
 */
public enum ActionEnum{
	moveUp(new MoveUp()),
	moveDown(new MoveDown()),
	moveLeft(new MoveLeft()),
	moveRight(new MoveRight()),
	shootUp(new ShootUp()),
	shootDown(new ShootDown()),
	shootLeft(new ShootLeft()),
	shootRight(new ShootRight());

	private static final ActionEnum[] actions = values();
	private static final int SIZE = actions.length;
	private static final Random RANDOM = new Random();
	
	public static Action getRandomAction(){
		return actions[RANDOM.nextInt(SIZE)].getAction();
	}

	Action action;
	ActionEnum(Action action){
		this.action = action;
	}
	
	public Action getAction(){
		return action;
	}
}