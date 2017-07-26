package gui.view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
/**
 * 视图1
 * @author gaofu
 *
 */
@SuppressWarnings("serial")
public class FirstView_Panel extends JPanel {
	//视图组件
	public JTextField textField;
	public JButton print; 
	public JButton change;
	public JCheckBox allchoose;
	/**
	 * Create the panel.
	 */
	public FirstView_Panel() {
		setBackground(Color.GREEN);
		setSize(340, 390);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//
		print = new JButton("打印");
		add(print);
		change = new JButton("转换");
		add(change);
		//
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
		allchoose = new JCheckBox("全选");
		add(allchoose);
	}
}