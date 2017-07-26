package com.controler.message;

import java.util.ArrayList;
/**
 * 框架默认的消息发布器
 * <p>提示:消息发布器可以根据具体的情况重写,以使得执行效率更高
 * @author gaofu
 *
 */
public class MessagePublisher extends AbstractMessagePublisher{
	public MessagePublisher(){}
	public MessagePublisher(InterfaceMessageGainer eventGainer){
		super(eventGainer);
	}
	public MessagePublisher(ArrayList<InterfaceMessageGainer> eventGainer){
		super(eventGainer);
	}

}
