package gui.controler;

import java.awt.event.ActionEvent;

import javax.swing.JComponent;

import com.controler.AbstractActionControler;

import gui.view.SecondView_Panel;
/**
 * 视图2控制器
 * @author gaofu
 *
 */
public class SecondViewControler extends AbstractActionControler {
	
	public SecondView_Panel view=(SecondView_Panel)super.view;
	public SecondViewControler(JComponent view) {
		super(view);
		init();
	}
	void init(){
		addEventSource(view.print,"Two_print","打印");
		addEventSource(view.change,"Two_change","转换到面板A");
		addEventSource(view.allchoose,"Two_allchoose","全选");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		switch(this.sourceName){
		case "Two_print":
			setTextContent("Second__打印");
			break;
		case "Two_change":
			setTextContent("Second__转换");
			break;
		case "Two_allchoose":
			setTextContent("Second__全选");
			break;
		}
	}
	/**
	 * 设置文本框的内容
	 * @param content
	 */
	public void setTextContent(String content){
		view.textField.setText(content);
	}
}
