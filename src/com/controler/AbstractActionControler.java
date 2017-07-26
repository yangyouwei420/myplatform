package com.controler;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JComponent;

import com.controler.message.InterfaceMessageGainer;
/**
 * 视图控制器
 * @author gaofu
 */
abstract public class AbstractActionControler extends ActionListenerManager{
	/**产生消息的组件名称*/
	public String sourceName;
	/**消息的命令*/
	public String command;
	
	/**视图*/
	protected JComponent view;
	/**消息的接收对象集*/
	protected ArrayList<InterfaceMessageGainer> aimObjects=new ArrayList<InterfaceMessageGainer>();
	/**
	 * 构造函数
	 * @param view 视图
	 */
	public AbstractActionControler(JComponent view){
		this.view=view;
	}
	/**
	 * 接收Swing事件且发送自定义的消息
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		sourceName=((JComponent)e.getSource()).getName();
		command=e.getActionCommand();
		//发送信息给目标对象集由目标对象们处理事件
		publishMessageToALLGainers(sourceName,command);
	}
	/**
	 * 获得产生事件的组件名称
	 * @return 产生事件的组件名称
	 */
	public String getSourceName(){
		return sourceName;
	}
	/**
	 * 获得命令
	 * @return 命令
	 */
	public String getCommand(){
		return command;
	}
	/**
	 * 获得视图
	 * @return
	 */
	public JComponent getView(){
		return view;
	}
	/**
	 * 添加消息接收对象
	 * @param actionObject
	 */
	public void addMessageGainer(InterfaceMessageGainer aimObject){
		aimObjects.add(aimObject);
	}
	/**
	 * 移除指定的消息接收对象
	 * @param aimObject
	 */
	public void removeMessageGainer(InterfaceMessageGainer aimObject){
		aimObjects.remove(aimObject);
	}
	/**
	 * 设置消息接收集
	 * @param aimObjects 消息接收集
	 */
	public void setAllMessageGainers(ArrayList<InterfaceMessageGainer> aimObjects){
		this.aimObjects=aimObjects;
	}
	/**
	 * 返回接收消息的目标对象集
	 * @return
	 */
	public ArrayList<InterfaceMessageGainer> getAllMessageGainers(){
		return aimObjects;
	}
	/**
	 * 移除所有的消息接收对象
	 */
	public void removeAllMessageGainers(){
		aimObjects.clear();
	}
	/**
	 * 发送消息给目标对象集由目标对象们处理事件
	 * @param sourceName 产生消息的来源
	 * @param command 消息的命令
	 */
	protected void publishMessageToALLGainers(String sourceName,String command){
		for(InterfaceMessageGainer aimObject:aimObjects){
			aimObject.achieveMessage(sourceName,command);
		}
	}
	/**
	 * 发送消息给指定的目标对象由目标对象处理事件
	 * @param aimObject 指定的目标对象
	 * @param sourceName 产生消息的来源
	 * @param command 消息的命令
	 */
	protected void publishMessageToGainer(InterfaceMessageGainer aimObject,String sourceName,String command){
			aimObject.achieveMessage(sourceName,command);
	}
	/**
	 * 发送消息给指定的目标对象集由指定的目标对象集处理事件
	 * @param aimObjects 指定的目标对象集
	 * @param sourceName 产生消息的来源
	 * @param command 消息的命令
	 */
	protected void publishMessageToGainers(ArrayList<InterfaceMessageGainer> aimObjects,String sourceName,String command){
		for(InterfaceMessageGainer aimObject:aimObjects){
			aimObject.achieveMessage(sourceName,command);
		}
	}
}
