package gui.controler;

import javax.swing.JFrame;

import com.controler.message.InterfaceMessageGainer;

import gui.model.Model;
import gui.view.HFrame;
/**
 * 顶级窗口视图控制器
 * @author gaofu
 *
 */
public class HFrameControler  implements InterfaceMessageGainer {
	public HFrame view;
	
	private FirstViewControler firstViewControler;
	private SecondViewControler secondViewControler;
	//
	Model model=new Model();
	public HFrameControler(JFrame view) {
		try{
			this.view=(HFrame)view;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		addEventGainers();
	}
	public void addEventGainers(){
		/*firstViewControler=new FirstViewControler(this.view.firstView_Panel);
		firstViewControler.addMessageGainer(this);
		firstViewControler.addMessageGainer(model);
		//
		secondViewControler=new SecondViewControler(this.view.secondView_Panel);
		secondViewControler.addMessageGainer(this);
		secondViewControler.addMessageGainer(model);*/
	}
	@Override
	public boolean achieveMessage(String componentName, String command) {
		// TODO Auto-generated method stub
		System.out.println("MySystem:\n名字:"+componentName);
		System.out.println("命令:"+command+"\n");
		switch(command){
		case "转换到面板B":
			firstViewControler.getView().setVisible(false);
			secondViewControler.getView().setVisible(true);
			break;
		case "转换到面板A":
			firstViewControler.getView().setVisible(true);
			secondViewControler.getView().setVisible(false);
			break;
		}
		return true;
	}
	public void startup(){
		view.setVisible(true);
	}
}
