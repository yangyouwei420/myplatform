package com.controler.message;
/**
 * 消息接收者
 * @author gaofu
 *
 */
public interface InterfaceMessageGainer{
	/**
	 * 接收消息
	 * @param sourceName 产生消息的来源
	 * @param command 产生消息(命令)
	 * @return 是否正确接收消息和处理消息
	 */
	public boolean achieveMessage(String sourceName,String command);
}
