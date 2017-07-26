package com.controler;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * 监听器管理器
 * @author gaofu
 */
abstract public class ActionListenerManager implements ActionListener {
	/**
	 * 添加事件源
	 * @param jbutton 要监听的组件
	 */
	public void addEventSource(JButton jbutton){
		jbutton.addActionListener(this);
	}
	/**
	 * 添加事件源
	 * @param jbutton 要监听的组件
	 * @param componentName 产生事件的组件命名
	 * @param command 产生事件的组件发送的命令
	 */
	public void addEventSource(JButton jbutton, String componentName, String command){
		jbutton.addActionListener(this);
		jbutton.setName(componentName);//发布事件的组件的名称
		jbutton.setActionCommand(command);//事件的命令
	}
	/**
	 * 移除事件源
	 * @param jbutton 要监听的组件
	 */
	public void removeEventSource(JButton jbutton){
		jbutton.removeActionListener(this);
	}
	/**
	 * 添加事件源
	 * @param jradioButton 要监听的组件
	 */
	public void addEventSource(JRadioButton jradioButton){
		jradioButton.addActionListener(this);
	}
	/**
	 * 添加事件源
	 * @param jradioButton 要监听的组件
	 * @param componentName 产生事件的组件命名
	 * @param command 产生事件的组件发送的命令
	 */
	public void addEventSource(JRadioButton jradioButton, String componentName, String command){
		jradioButton.addActionListener(this);
		jradioButton.setName(componentName);//发布事件的组件的名称
		jradioButton.setActionCommand(command);//事件的命令
	}
	/**
	 * 移除事件源
	 * @param jradioButton 要监听的组件
	 */
	public void removeEventSource(JRadioButton jradioButton){
		jradioButton.removeActionListener(this);
	}
	/**
	 * 添加事件源
	 * @param jcheckBox 要监听的组件
	 */
	public void addEventSource(JCheckBox jcheckBox){
		jcheckBox.addActionListener(this);
	}
	/**
	 * 添加事件源
	 * @param jcheckBox 要监听的组件
	 * @param componentName 产生事件的组件命名
	 * @param command 产生事件的组件发送的命令
	 */
	public void addEventSource(JCheckBox jcheckBox, String componentName, String command){
		jcheckBox.addActionListener(this);
		jcheckBox.setName(componentName);//发布事件的组件的名称
		jcheckBox.setActionCommand(command);//事件的命令
	}
	/**
	 * 移除事件源
	 * @param jcheckBox 要监听的组件
	 */
	public void removeEventSource(JCheckBox jcheckBox){
		jcheckBox.removeActionListener(this);
	}
//	JComboBox
	/**
	 * 添加事件源
	 * @param jcomboBox 要监听的组件
	 */
	public void addEventSource(JComboBox<?> jcomboBox){
		jcomboBox.addActionListener(this);
	}
	/**
	 * 添加事件源
	 * @param jcomboBox 要监听的组件
	 * @param componentName 产生事件的组件命名
	 * @param command 产生事件的组件发送的命令
	 */
	public void addEventSource(JComboBox<?> jcomboBox, String componentName, String command){
		jcomboBox.addActionListener(this);
		jcomboBox.setName(componentName);//发布事件的组件的名称
		jcomboBox.setActionCommand(command);//事件的命令
	}
	/**
	 * 移除事件源 
	 * @param jcomboBox 要监听的组件
	 */
	public void removeEventSource(JComboBox<?> jcomboBox){
		jcomboBox.removeActionListener(this);
	}
	/**
	 * 添加事件源
	 * @param jtextField 要监听的组件
	 */
	public void addEventSource(JTextField jtextField){
		jtextField.addActionListener(this);
	}
	/**
	 * 添加事件源
	 * @param jtextField 要监听的组件
	 * @param componentName 产生事件的组件命名
	 * @param command 产生事件的组件发送的命令
	 */
	public void addEventSource(JTextField jtextField, String componentName, String command){
		jtextField.addActionListener(this);
		jtextField.setName(componentName);//发布事件的组件的名称
		jtextField.setActionCommand(command);//事件的命令
	}
	/**
	 * 移除事件源
	 * @param jtextField 要监听的组件
	 */
	public void removeEventSource(JTextField jtextField){
		jtextField.removeActionListener(this);
	}
	//JMenuItem
	/**
	 * 添加事件源
	 * @param jmenuItem 要监听的组件
	 */
	public void addEventSource(JMenuItem jmenuItem){
		jmenuItem.addActionListener(this);
	}
	/**
	 * 添加事件源
	 * @param jmenuItem 要监听的组件
	 * @param componentName 产生事件的组件命名
	 * @param command 产生事件的组件发送的命令
	 */
	public void addEventSource(JMenuItem jmenuItem, String componentName, String command){
		jmenuItem.addActionListener(this);
		jmenuItem.setName(componentName);//发布事件的组件的名称
		jmenuItem.setActionCommand(command);//事件的命令
	}
	/**
	 * 移除事件源
	 * @param jmenuItem 要监听的组件
	 */
	public void removeEventSource(JMenuItem jmenuItem){
		jmenuItem.removeActionListener(this);
	}
}
