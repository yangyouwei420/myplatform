package com.controler.message;

import java.util.ArrayList;

/**
 * 消息发布器
 * @author gaofu
 *
 */
abstract public class AbstractMessagePublisher{
	/**消息的名称*/
	String messageName;
	/**消息*/
	String message;
	/**接收消息的目标对象集*/
	protected ArrayList<InterfaceMessageGainer> aimObjects=new ArrayList<InterfaceMessageGainer>();
	/**
	 * 构造函数
	 */
	public AbstractMessagePublisher(){}
	/**
	 * 构造函数:
	 * 添加一个接收消息目标
	 * @param aimObject 接收对象
	 */
	public AbstractMessagePublisher(InterfaceMessageGainer aimObject){
		addMessageGainer(aimObject);
	}
	/**
	 * 构造函数:
	 * 添加一个接收消息的对象集
	 * @param aimObjects 接收对象集
	 */
	public AbstractMessagePublisher(ArrayList<InterfaceMessageGainer> aimObjects){
		setAllMessageGainers(aimObjects);
	}
	/**
	 * 设置消息接收对象
	 * @param actionObject 接收对象
	 */
	public void addMessageGainer(InterfaceMessageGainer aimObject){
		aimObjects.add(aimObject);
	}
	/**
	 * 移除指定的消息接收对象
	 * @param aimObject 接收对象
	 */
	public void removeMessageGainer(InterfaceMessageGainer aimObject){
		aimObjects.remove(aimObject);
	}
	/**
	 * 设置消息接收对象集
	 * @param aimObjects 消息接收对象集
	 */
	public void setAllMessageGainers(ArrayList<InterfaceMessageGainer> aimObjects){
		this.aimObjects=aimObjects;
	}
	/**
	 * 返回消息的接收对象集
	 * @return  接收对象集
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
	 * 发送消息给接收对象集由接收对象们处理事件
	 * @param componentName 产生消息的组件名称
	 * @param command 消息的命令
	 */
	protected void publishMessageToGainers(String messageName,String message){
		for(InterfaceMessageGainer aimObject:aimObjects){
			aimObject.achieveMessage(messageName,message);
		}
	}
}