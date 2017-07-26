package gui.controler;

import java.awt.event.ActionEvent;

import javax.swing.JComponent;

import com.controler.AbstractActionControler;

import gui.view.FirstView_Panel;
/**
 * 视图1控制器
 * @author gaofu
 *
 */
public class FirstViewControler extends AbstractActionControler {
	
	public FirstView_Panel view;
	public FirstViewControler(JComponent view) {
		super(view);
		try{
			this.view=(FirstView_Panel)super.view;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		addEventSources();
	}
	private void addEventSources(){
		/*addEventSource(view.print,"One_print", "打印");
		addEventSource(view.change, "One_change", "转换到面板B");
		addEventSource(view.allchoose,"One_allchoose","全选");*/
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource().equals(view.print)){
			setTextContent("First__打印");
		}
		else if(e.getSource().equals(view.change)){
			setTextContent("First__转换");
		}
		else if(e.getSource().equals(view.allchoose)){
			setTextContent("First__全选");
		}
	}
	public void setTextContent(String content){
		view.textField.setText(content);
	}
}
