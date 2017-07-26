package com.controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * 鼠标事件发布器(未实现)
 * @author gaofu
 *
 */
abstract public class AbstractMouseControler implements MouseListener{
	String componentName;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(((JComponent)e.getSource()).getName());
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}