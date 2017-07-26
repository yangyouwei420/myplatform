package gui.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;


/*
作者：杨有为
用途：显示任务执行情况
*/
public class ProgressTable extends JInternalFrame{
	private static final long serialVersionUID = 2907082087525095572L;
	private String data[][]={ 
            {"有效","Erick","70.0","65.2","92.4","67.6","67.6"},
            {"无效","Tom"  ,"80.0","75.2","82.4","87.6","67.6"},
            {"有效","Su"   ,"60.0","75.2","72.4","77.6","67.6"},
            {"无效","Jimmy","50.0","65.2","82.4","47.6","67.6"},
            {"有效","Jack" ,"90.0","85.2","62.4","67.6","67.6"}
    }; 
	private List<String> datanew = new ArrayList<>();
	private List<String> titlenew = new ArrayList<>();
	
	public ProgressTable(){
	    super("执行进度", true, true, true, true);
	    TableModel tm = new AbstractTableModel(){
		      String headers[] ={"有效标志","任务ID","任务名称","项目总数","项目成功数","项目未执数","项目执行百分比"};
		      public int getColumnCount(){return headers.length;}
		      public int getRowCount(){return data.length;}
		      public String getColumnName(int col){return headers[col];}
		      public boolean isCellEditable(int row,int col){return true;}
		      public Object getValueAt(int row,int col){return data[row][col];}
		      public void setValueAt(Object value,int row,int col){
		              data[row][col] = (String)value;
		              fireTableRowsUpdated(row,row);
		      }
	    };//end of TableModel
	
	    JTable jt = new JTable(tm);
	    JScrollPane jsp = new JScrollPane(jt);
	
	    setContentPane(jsp);
	    setSize( 350, 150);
	    setLocation( 150, 20);
	  }//end of DemoTable()
}//end of class DemoTable
