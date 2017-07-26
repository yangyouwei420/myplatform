package com.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComponent;

import com.controler.message.InterfaceMessageGainer;
/**
 * 视图控制器
 * @author gaofu
 *
 */
abstract public class CopyOfAbstractActionControler extends ActionListenerManager
	implements ActionListener{
	/**视图*/
	protected JComponent view;
	/**接收事件的目标对象集*/
	protected ArrayList<InterfaceMessageGainer> aimObjects=new ArrayList<InterfaceMessageGainer>();
	/**
	 * 构造函数
	 * @param view 视图
	 */
	public CopyOfAbstractActionControler(JComponent view){
		this.view=view;
	}
	/**
	 * 接收Swing事件并获得且发送自定义的事件
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**产生事件的组件名称*/
		String componentName=((JComponent)e.getSource()).getName();
		/**事件的命令*/
		String command=e.getActionCommand();
		//发送信息给目标对象集由目标对象们处理事件
		publishEventToGainers(componentName,command);
	}
	/**
	 * 获得视图
	 * @return
	 */
	public JComponent getView(){
		return view;
	}
	/**
	 * 设置事件接收对象
	 * @param actionObject
	 */
	public void addEventGainer(InterfaceMessageGainer aimObject){
		aimObjects.add(aimObject);
	}
	/**
	 * 移除指定的信息接收对象
	 * @param aimObject
	 */
	public void removeEventGainer(InterfaceMessageGainer aimObject){
		aimObjects.remove(aimObject);
	}
	/**
	 * 设置信息接收集
	 * @param aimObjects 信息接收集
	 */
	public void setAllEventGainers(ArrayList<InterfaceMessageGainer> aimObjects){
		this.aimObjects=aimObjects;
	}
	/**
	 * 返回接收信息的目标对象集
	 * @return
	 */
	public ArrayList<InterfaceMessageGainer> getAllEventGainers(){
		return aimObjects;
	}
	/**
	 * 移除所有的信息接收对象
	 */
	public void removeAllEventGainers(){
		aimObjects.clear();
	}
	/**
	 * 发送信息给目标对象集由目标对象们处理事件
	 * @param componentName 产生事件的组件名称
	 * @param command 事件的命令
	 */
	protected void publishEventToGainers(String componentName,String command){
		for(InterfaceMessageGainer aimObject:aimObjects){
			aimObject.achieveMessage(componentName,command);
		}
	}
}
