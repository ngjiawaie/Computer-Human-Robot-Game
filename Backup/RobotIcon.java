import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.HashMap;

/*
 * Coded by Darryl Cheng Lin Wei
 */
public class RobotIcon implements java.io.Serializable{
	//Returns icon based on direction (EG. Direction.WEST)
	private HashMap<Direction,ImageIcon> robotIcons = new HashMap<Direction,ImageIcon>();

	public void addIcon(Direction direction, ImageIcon icon){
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(70, 55, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon( newimg );
		robotIcons.put(direction, icon);
	}

	public ImageIcon getIcon(Direction direction){
		return robotIcons.get(direction);
	}

}