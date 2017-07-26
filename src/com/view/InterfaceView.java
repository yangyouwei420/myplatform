package com.view;

import com.controler.AbstractActionControler;
import com.controler.message.AbstractMessagePublisher;
/**
 * 视图接口
 * @author gaofu
 *
 */
public interface InterfaceView{
	/**
	 * 设置消息发布器
	 * @param eventPublisher
	 */
	public void setMessagePublisher(AbstractMessagePublisher eventPublisher);
	/**
	 * 设置视图控制器
	 * @param actionControler
	 */
	public void setActionControler(AbstractActionControler actionControler);
}
