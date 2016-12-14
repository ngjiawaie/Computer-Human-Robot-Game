public class main {
	RobotWar_Controller controller;
	RobotWar_Model model;
	RobotWar_View view;
	
	public main(){
		model = new RobotWar_Model();
		view = new RobotWar_View(10,10);
		controller = new RobotWar_Controller(model,view);
	}
	
	public static void main(String[] args){
		new main();
	}
}
