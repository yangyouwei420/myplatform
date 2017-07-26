package gui.view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
/**
 * 视图2
 * @author gaofu
 *
 */
@SuppressWarnings("serial")
public class SecondView_Panel extends JPanel {
	//
	public JTextField textField;
	public JButton print;
	public JButton change;
	public JCheckBox allchoose;
	/**
	 * Create the panel.
	 */
	public SecondView_Panel() {
		setBackground(Color.PINK);
		setForeground(Color.WHITE);
		setBounds(350,0, 340, 390);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		change = new JButton("转换");
		add(change);
		
		print = new JButton("打印");
		add(print);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
		allchoose = new JCheckBox("全选");
		add(allchoose);
	}
}
