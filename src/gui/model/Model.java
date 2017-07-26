package gui.model;

import com.controler.message.InterfaceMessageGainer;
/**
 * 模型
 * @author gaofu
 *
 */
public class Model implements InterfaceMessageGainer{
	@Override
	public boolean achieveMessage(String componentName, String command) {
		// TODO Auto-generated method stub
		System.out.println("Model:\n名字:"+componentName);
		System.out.println("命令:"+command+"\n");
		return true;
	}

}
