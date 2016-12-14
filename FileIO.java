import java.io.*;
import javax.swing.*;

import javax.swing.JFileChooser;

/*
 * Coded by Chin Teck Hao
 * This class is used for saving and loading the game
 */
public class FileIO extends JPanel{
	//The saving operation saves the whole RobotWar_Model instance.
	
	public RobotWar_Model loadFile() {
		JFileChooser c = new JFileChooser();
		// Demonstrate "Open" dialog:
		int rVal = c.showOpenDialog(FileIO.this);
		if (rVal == JFileChooser.APPROVE_OPTION) {
			File file = c.getSelectedFile();
			RobotWar_Model model = null;
			try {
				FileInputStream loadfile = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(loadfile);
				model = (RobotWar_Model) in.readObject();
				in.close();
				loadfile.close();
				return model;
			}catch(Exception e ){
				JOptionPane.showMessageDialog(null, "Invalid save file");
			}
		}
		return null;
	}
	
	public void saveFile(RobotWar_Model toSave) {
		try {
			FileOutputStream savefile = new FileOutputStream("robotwar.sav");
			ObjectOutputStream out = new ObjectOutputStream(savefile);
			out.writeObject(toSave);
			out.close();
			savefile.close();
		}catch(IOException i) {
			i.printStackTrace();
		}
	}
}