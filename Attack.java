import java.awt.Image;

import javax.swing.ImageIcon;

/*
 * Coded by Darryl Cheng Lin Wei
 * This enum implements the singleton design pattern
 */
public enum Attack {
	image(new ImageIcon("res/explode.png"));
	
	ImageIcon icon;
	Attack(ImageIcon icon){
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(70, 55, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon( newimg );
		this.icon = icon;
	}
	
	ImageIcon getImage(){
		return icon;
	}
}
