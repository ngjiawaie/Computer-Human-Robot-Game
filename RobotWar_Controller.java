import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

/*
 * Coded by Lee Bing Yuan and Darryl Cheng Lin Wei
 * This class implements the MVC design pattern (Controller)
 */

public class RobotWar_Controller {
	private RobotWar_View view;
	private RobotWar_Model model;
	private FileIO IO = new FileIO();
	
	RobotWar_Controller(RobotWar_Model model, RobotWar_View view){
		this.model = model;
		this.view = view;
		initializeListeners();
		initializeRobotPosition();
	}
	
	public void initializeRobotPosition(){
		view.setIcon(model.cRobot.getRobotIcon(),model.cRobot.getPosition());
		view.setIcon(model.hRobot.getRobotIcon(), model.hRobot.getPosition());
	}
	
	public void initializeListeners(){
		view.moveUp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.hRobot.addAction(ActionEnum.moveUp.getAction())){
					view.updateSequenceLabel(model.hRobot.getSequence());
				}
			}
		});
		view.moveDown.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.hRobot.addAction(ActionEnum.moveDown.getAction())){
					view.updateSequenceLabel(model.hRobot.getSequence());
				}
			}
		});
		view.moveLeft.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.hRobot.addAction(ActionEnum.moveLeft.getAction())){
					view.updateSequenceLabel(model.hRobot.getSequence());
				}	
			}
		});
		view.moveRight.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.hRobot.addAction(ActionEnum.moveRight.getAction())){
					view.updateSequenceLabel(model.hRobot.getSequence());
				}
			}
		});
		view.shootUp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.hRobot.addAction(ActionEnum.shootUp.getAction())){
					view.updateSequenceLabel(model.hRobot.getSequence());
				}
			}
		});
		view.shootRight.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.hRobot.addAction(ActionEnum.shootRight.getAction())){
					view.updateSequenceLabel(model.hRobot.getSequence());
				}	
			}
		});
		view.shootDown.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.hRobot.addAction(ActionEnum.shootDown.getAction())){
					view.updateSequenceLabel(model.hRobot.getSequence());
				}
			}
		});
		view.shootLeft.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.hRobot.addAction(ActionEnum.shootLeft.getAction())){
					view.updateSequenceLabel(model.hRobot.getSequence());
				}
			}
		});
		view.undo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int lastIndex = model.hRobot.getSequence().getSequenceCount()-1;
				if(model.hRobot.undoAction()){
					view.sequenceText[lastIndex].setText("");
				}
			}
		});
		view.execute.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(!model.hRobot.getSequence().isFull()){
					JOptionPane.showMessageDialog(null, "Please insert exactly 18 moves!");
				} else {
					model.incrementNumberOfTries();
					view.setNumberOfAttempts(model.getNumberOfTries());
					startGame();
				}
			}
		});
		view.clear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				restartCurrentGame();
			}
		});
		view.newGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Computer Sequence Changed!");
				newGame();
			}
		});
		view.moveOrShoot.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JToggleButton source = (JToggleButton)e.getSource();
				//Selected is shoot, not selected is move.
				if(source.isSelected()){
					view.actionMove.setVisible(false);
					view.actionShoot.setVisible(true);
					view.actionDirection.setText("Enter shoot direction:");
				} else {
					view.actionMove.setVisible(true);
					view.actionShoot.setVisible(false);
					view.actionDirection.setText("Enter move direction:");
				}
			}
		});
		view.saveGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Game saved to current directory. \"robotwar.sav\"");
				IO.saveFile(model);
			}
		});
		view.loadGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				RobotWar_Model newModel = IO.loadFile();
				if(newModel!=null){
					model = newModel;
					view.updateSequenceLabel(model.hRobot.getSequence());
					view.setNumberOfAttempts(model.getNumberOfTries());
				}
				
			}
		});
	}
	
	private void startGame(){
		Thread thread = new Thread(){
			public void run(){
				try {
					view.disableControls();
					//Get whole computer sequence (iterator)
					Iterator computerSequence = model.cRobot.getSequence().getIterator();
					Iterator humanSequence = model.hRobot.getSequence().getIterator();
					for(int i=0;i<18;i++){
						Action [] action = {computerSequence.next(), humanSequence.next()};
						Robot [] robot = {model.cRobot, model.hRobot};
						view.clearGameBoard();
						for(int x=0;x<2;x++){
							Action actionToRun = action[x];
							Position initialPos = robot[x].getPosition();
							
							switch(actionToRun.getActionType()){
							
							case SHOOT:
								Position attackPos = new Position(initialPos);
								attackPos = actionToRun.performAction(attackPos);
								robot[x].setFacingDirection(attackPos.getDirection());
								if(!view.hasRobot(initialPos) && !view.hasAttack(initialPos)){
									view.setIcon(robot[x].getRobotIcon() ,robot[x].getPosition());
								} else {
									model.showWinner(robot[(x+1)%2]);
									newGame();
									return;
								}
								if(!initialPos.isSamePosition(attackPos)){
									boolean hasRobot = view.hasRobot(attackPos);
									view.setIcon(Attack.image.getImage(),attackPos);
									if(hasRobot){
										model.showWinner(robot[x]);
										newGame();
										return;
									}
								}
								break;
								
							case MOVE:
								Position movingPos = new Position(initialPos);
								movingPos = actionToRun.performAction(movingPos);
								robot[x].newPosition(movingPos);
								if(view.hasRobot(movingPos) || view.hasAttack(movingPos)){
									model.showWinner(robot[(x+1)%2]);
									newGame();
									return;
								} else {
									view.setIcon(robot[x].getRobotIcon() ,movingPos);
								}
								break;
							}
						}
						Thread.sleep(500);
					}
					restartCurrentGame();
				} catch (InterruptedException e) {}
			}
		};
		thread.start();
	}
	
	public void restartCurrentGame(){
		model.restartCurrentGame();
		view.enableControls();
		view.restartInitialBoardState();
		initializeRobotPosition();
	}
	
	public void newGame(){
		restartCurrentGame();
		model.newGame();
		view.enableControls();
		view.restartInitialBoardState();
		view.setNumberOfAttempts(0);
		initializeRobotPosition();
	}

}
