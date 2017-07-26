package gui;
import gui.controler.HFrameControler;
import gui.view.HFrame;
/**
 * 程序入口
 * @author gaofu
 *
 */
public class Progrem {
	public static void main(String[] args) {
		HFrameControler hcontroler = new HFrameControler(new HFrame());
		hcontroler.startup();
	}
}
