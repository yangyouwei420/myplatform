package gui.view;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.undo.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.event.UndoableEditEvent;
import javax.swing.table.TableColumn;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import com.model.InterfaceDB;
/**
 * 顶级窗口视图,在此同时也是最底层的视图
 * @author gaofu
 *
 */
@SuppressWarnings("serial")
public class HFrame extends JFrame {
        private JDesktopPane desktop;
        private JMenuBar menuBar;
        private JPopupMenu popupMenu;
        private InterfaceDB derbydb;

        //
        /*public JTabbedPane tabpane ;
        public FirstView_Panel firstView_Panel;
        public SecondView_Panel secondView_Panel;*/
        //
        public HFrame() {
                setTitle("进度运行主界面");//界面标题
                setBounds(100,100,630,400);  //设置边框范围
                buildContent();   //内容界面
                buildMenuBar(); //菜单栏
                popupMenu = buildPopupMenu();

                addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                                System.exit(0);
                         }
                }); //end of addWindowListener

                    JInternalFrame JItable = new ProgressTable();
                    desktop.add(JItable, new Integer(4));
                    try {
                         JItable.setVisible(true);
                         JItable.setSelected(true);
                    }catch (java.beans.PropertyVetoException e2) {}
        }
            public void buildContent()
            {
                desktop = new JDesktopPane();
                    getContentPane().add(desktop);

            }//end of buildContent()

            public void buildMenuBar()
            {
                String menuName;

                menuBar = new JMenuBar();
                menuName = "文件";
                String[] fileFunctions = {"新建", "打开", "关闭", "退出"};
                char[] fileMnemonic = {'N', 'O', 'L', 'X'};
                JMenu mfile = buildMenu(menuName,fileFunctions,fileMnemonic);

                menuName = "编辑";
                String[] editFunctions = {"撤销","Redo","addSeparator","Copy", "Cut", "Paste"};
                char[] editMnemonic = {'Z','Y','0','T', 'C', 'P'};
                JMenu medit = buildMenu(menuName,editFunctions,editMnemonic);

                JMenu malign = buildAlignMenu();

                menuName = "插入";
                String[] insertFunctions = {"Picture", "Object"};
                char[] insertMnemonic = null;
                JMenu minsert = buildMenu(menuName,insertFunctions,insertMnemonic);

                menuName = "Demo";
                String[] demoFunctions = {"Slider", "Tree Structure", "Table Structure", "Password"};
                char[] demoMnemonic = {'S', 'T', 'A', 'P'};
                JMenu mdemo = buildMenu(menuName,demoFunctions,demoMnemonic);

                menuName = "帮助";
                String[] helpFunctions = {"About this Program", "连接数据库", "初始化数据库"};
                char[] helpMnemonic = {'B', 'H'};
                JMenu mhelp = buildMenu(menuName,helpFunctions,helpMnemonic);

                //快捷键Hot Key Alt+'?'
                mfile.setMnemonic('F');
                medit.setMnemonic('E');
                malign.setMnemonic('A');
                minsert.setMnemonic('I');
                mdemo.setMnemonic('D');
                mhelp.setMnemonic('H');

                menuBar.add(mfile);      //盢 File 匡兜MenuBarい
                menuBar.add(medit);     //盢 Edit 匡兜MenuBarい
                menuBar.add(malign);   //盢 Align 匡兜MenuBarい
                menuBar.add(mdemo);  //盢 Demo 匡兜MenuBarい
                menuBar.add(mhelp);    //盢 Help 匡兜MenuBarい

                setJMenuBar(menuBar);
            }//end of bulidMenuBar()

            public JMenu buildMenu(String menuName, String[] functions, char[] mnemonic)
            {
                ActionSet action;
                JMenuItem item;
                JMenu menu = new JMenu(menuName);
                for (int i=0; i<functions.length; i++)
                {
                    if (functions[i].equals("addSeparator"))
                    {
                        menu.addSeparator();
                        continue;
                    }
                    item = menu.add(new ActionSet(functions[i],null));
                    item.setActionCommand(functions[i]);
                    if (mnemonic != null)
                    {
                        item.setMnemonic(mnemonic[i]);
                        item.setAccelerator( KeyStroke.getKeyStroke(mnemonic[i],java.awt.Event.CTRL_MASK,false));
                    }
                }
                return menu;
            }//end of buildMenu()

            public JMenu buildAlignMenu()
            {
                JRadioButtonMenuItem aL;
                JRadioButtonMenuItem aC;
                JRadioButtonMenuItem aR;

                JMenu malign = new JMenu("Align");

                aL = new JRadioButtonMenuItem("Align Left");
                aC = new JRadioButtonMenuItem("Align Center");
                aR = new JRadioButtonMenuItem("Align Right");

                SimpleAttributeSet attrset = new SimpleAttributeSet();
                aL.addItemListener(new HandleItemEvent("LEFT",attrset));
                aC.addItemListener(new HandleItemEvent("CENTER",attrset));
                aR.addItemListener(new HandleItemEvent("RIGHT",attrset));

                ButtonGroup buttonGroup = new ButtonGroup();
                buttonGroup.add(aL);
                buttonGroup.add(aC);
                buttonGroup.add(aR);

                JCheckBoxMenuItem demo1 = new JCheckBoxMenuItem("demo1", true);
                JCheckBoxMenuItem demo2 = new JCheckBoxMenuItem("demo2");
                JCheckBoxMenuItem demo3 = new JCheckBoxMenuItem("demo3");

                malign.add(aL);
                malign.add(aC);
                malign.add(aR);
                malign.addSeparator();
                malign.add(demo1);
                malign.add(demo2);
                malign.add(demo3);

                return malign;
            }//end of buildAlignMenu()

            class HandleItemEvent implements ItemListener
            {
                String align;
                SimpleAttributeSet attrset;

                HandleItemEvent(String align, SimpleAttributeSet attrset)
                {
                    this.align = align;
                    this.attrset = attrset;
                }

                public void itemStateChanged(ItemEvent e)
                {
                    NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                    JTextPane pane = currentFrame.getTextPane();
                    StyledDocument docs = pane.getStyledDocument();
                    int offset = pane.getSelectionStart();
                    int end    = pane.getSelectionEnd();
                    int selected_length = end - offset;

                    if(currentFrame == null) { return;}

                    if (align.equals("LEFT"))
                        StyleConstants.setAlignment(attrset, StyleConstants.ALIGN_LEFT);
                    if (align.equals("CENTER"))
                        StyleConstants.setAlignment(attrset, StyleConstants.ALIGN_CENTER);
                    if (align.equals("RIGHT"))
                        StyleConstants.setAlignment(attrset, StyleConstants.ALIGN_RIGHT);

                    docs.setParagraphAttributes(offset, selected_length, attrset, true);

                }//end of itemStateChanged()
            }//end of HandleItemEvent class

            public JPopupMenu buildPopupMenu()
            {
                JPopupMenu popupMenu = new JPopupMenu("Popup Menu");
                JMenuItem item = popupMenu.add(new ActionSet("Cut",new ImageIcon("icons/cut16.gif")));
                item.setActionCommand("Cut");
                item = popupMenu.add(new ActionSet("Copy",new ImageIcon("icons/copy16.gif")));
                item.setActionCommand("Copy");
                item = popupMenu.add(new ActionSet("Paste",new ImageIcon("icons/paste16.gif")));
                item.setActionCommand("Paste");
                return popupMenu;
            }//end of buildPopupMenu()

            class ShowPopupMenu extends MouseAdapter
            {
                JPopupMenu popupMenu;

                ShowPopupMenu(JPopupMenu popupMenu)
                {
                    this.popupMenu = popupMenu;
                }

                public void mouseReleased(MouseEvent e)
                {
                    if (e.isPopupTrigger())
                    {
                        popupMenu.show(e.getComponent(),e.getX(),e.getY());
                    }
                }
            }

            UndoManager undo;

            class ActionSet extends AbstractAction
            {
                public ActionSet(String name,Icon icon)
                {
                  super(name,icon);
                  if(name.equals("Undo") || name.equals("Redo"))
                    setEnabled(false);
                }

                public void updateUndoState() {
                    NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        undo = currentFrame.getUndoManager();
                    JMenuItem undoItem = menuBar.getMenu(1).getItem(0);
                    if (undo.canUndo()) {
                        undoItem.setEnabled(true);
                        //眤ノputValue()よ猭э跑MenuItem陪ボ﹃
                        //putValue(Action.NAME, undo.getRedoPresentationName());
                    } else {
                        undoItem.setEnabled(false);
                    }
                }

                public void updateRedoState() {
                    NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        undo = currentFrame.getUndoManager();
                    JMenuItem redoItem = menuBar.getMenu(1).getItem(1);
                    if (undo.canRedo()) {
                        redoItem.setEnabled(true);
                        //putValue(Action.NAME, undo.getUndoPresentationName());
                    } else {
                        redoItem.setEnabled(false);
                    }
                }

                public void actionPerformed(ActionEvent e)
                {
                    String command = e.getActionCommand();

                    if(command.equals("New"))
                    {
                        NewFrame internalFrame = new NewFrame();
                        desktop.add(internalFrame, new Integer(1));
                        try {
                            internalFrame.setVisible(true);
                            internalFrame.setSelected(true);
                        }catch (java.beans.PropertyVetoException e2) {}
                        JTextPane textPane = internalFrame.getTextPane();
                        textPane.addMouseListener(new ShowPopupMenu(popupMenu));
                        textPane.requestFocus();
                    }
                    if(command.equals("Open"))
                    {
                        NewFrame internalFrame = new NewFrame();
                        desktop.add(internalFrame, new Integer(1));
                        try {
                            internalFrame.setVisible(true);
                            internalFrame.setSelected(true);
                        }catch (java.beans.PropertyVetoException e2) {}

                        JTextPane textPane = internalFrame.getTextPane();
                    }
                    if(command.equals("Close"))
                    {
                        NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        else{
                            desktop.remove(currentFrame);
                            desktop.updateUI();
                        }
                    }
                    if(command.equals("Exit"))
                    {
                        System.exit(0);
                    }
                    if(command.equals("Undo"))
                    {
                        NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        undo = currentFrame.getUndoManager();
                        try {
                            undo.undo();
                        } catch (CannotUndoException ex) {
                            System.out.println("Unable Undo");
                        }
                        updateUndoState();
                        updateRedoState();
                    }

                    if(command.equals("Redo"))
                    {
                        NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        undo = currentFrame.getUndoManager();
                        try {
                            undo.redo();
                        } catch (CannotRedoException ex) {
                            System.out.println("Unable Redo");
                        }
                        updateRedoState();
                        updateUndoState();
                    }

                    if(command.equals("Copy"))
                    {
                        NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        currentFrame.getTextPane().copy();
                    }
                    if(command.equals("Cut"))
                    {
                        NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        currentFrame.getTextPane().cut();
                    }
                    if(command.equals("Paste"))
                    {
                        NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        currentFrame.getTextPane().paste();
                    }
                    if(command.equals("Bold"))
                    {
                        NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        JTextPane textPane = currentFrame.getTextPane();

                        MutableAttributeSet attrset = textPane.getInputAttributes();
                        boolean bold = (StyleConstants.isBold(attrset)) ? false : true;
                        SimpleAttributeSet sas = new SimpleAttributeSet();
                                StyleConstants.setBold(sas, bold);
                                textPane.setCharacterAttributes(sas, false);
                    }
                    if(command.equals("Italic"))
                    {
                        NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        JTextPane textPane = currentFrame.getTextPane();

                        MutableAttributeSet attrset = textPane.getInputAttributes();
                        boolean italic = (StyleConstants.isItalic(attrset)) ? false : true;
                        SimpleAttributeSet sas = new SimpleAttributeSet();
                                StyleConstants.setItalic(sas, italic);
                                textPane.setCharacterAttributes(sas, false);
                    }
                    if(command.equals("Underline"))
                    {
                        NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        JTextPane textPane = currentFrame.getTextPane();

                        MutableAttributeSet attrset = textPane.getInputAttributes();
                        boolean underline = (StyleConstants.isUnderline(attrset)) ? false : true;
                        SimpleAttributeSet sas = new SimpleAttributeSet();
                                StyleConstants.setUnderline(sas, underline);
                                textPane.setCharacterAttributes(sas, false);
                    }
                    if(command.equals("Set Color"))
                    {
                        NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        JTextPane textPane = currentFrame.getTextPane();
                        /*Color color = JColorChooser.showDialog(topFrame,"Change Font Color",Color.black);
                        if (color != null) //璝nullボㄏノCancel秙
                        {
                            SimpleAttributeSet sas = new SimpleAttributeSet();
                                    StyleConstants.setForeground(sas, color);
                                textPane.setCharacterAttributes(sas, false);
                        }*/
                    }
                    if (command.equals("Type"))
                    {
                        NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        JTextPane textPane = currentFrame.getTextPane();

                        MutableAttributeSet attrset = textPane.getInputAttributes();
                        String cstr = (((JComboBox)e.getSource()).getSelectedItem()).toString();
                        SimpleAttributeSet sas = new SimpleAttributeSet();
                            StyleConstants.setFontFamily(sas, cstr);
                            textPane.setCharacterAttributes(sas, false);
                    }
                    if (command.equals("Size"))
                    {
                        NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        JTextPane textPane = currentFrame.getTextPane();

                        MutableAttributeSet attrset = textPane.getInputAttributes();
                        int size = Integer.parseInt((((JComboBox)e.getSource()).getSelectedItem()).toString());
                        SimpleAttributeSet sas = new SimpleAttributeSet();
                        StyleConstants.setFontSize(sas, size);
                        textPane.setCharacterAttributes(sas, false);
                    }
                    if(command.equals("Picture"))
                    {
                        NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        JTextPane textPane = currentFrame.getTextPane();
                        JFileChooser fileChooser = new JFileChooser("c:\\");
                        /*int result = fileChooser.showOpenDialog(topFrame);
                        if(result == JFileChooser.APPROVE_OPTION)
                        {
                            File file = fileChooser.getSelectedFile();
                            textPane.insertIcon(new ImageIcon(file.getPath()));
                        }else if (result == fileChooser.CANCEL_OPTION){}*/
                    }
                    if(command.equals("Object"))
                    {
                        NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                        if(currentFrame == null) { return;}
                        JTextPane textPane = currentFrame.getTextPane();
                        textPane.insertComponent(new JButton("秙ン"));
                    }
                    if(command.equals("Slider"))
                    {
                    }
                    if(command.equals("Tree Structure"))
                    {

                    }
                    if(command.equals("Table Structure"))
                    {

                    }
                    if(command.equals("Password"))
                    {
                    }
                    if(command.equals("About this Program"))
                    {
                        final String AboutMsg =
                               "Written By Yangyouwei. \n"+
                               "Copyright (c) 2017 by Yangyouwei. All Rights Reserved.";
                        /*JOptionPane.showMessageDialog(topFrame, AboutMsg);*/
                    }
                    if(command.equals("连接数据库")){
                                    try {
                                        Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                                        Connection conn= DriverManager.getConnection("jdbc:derby:db;create=true");
                                        Statement st = conn.createStatement();
                                        //st.execute("create table USER_INFO (ID INT NOT NULL,NAME VARCHAR(10) NOT NULL)");//建表
                                        //st.executeUpdate("insert into USER_INFO(ID,NAME) values (2,'hermit')");//插入数据
                                        ResultSet rs = st.executeQuery("select * from USER_INFO");//读取刚插入的数据
                                        // 获取列名
                                        ResultSetMetaData metaData = rs.getMetaData();
                                        for (int i = 0; i < metaData.getColumnCount(); i++) {
                                            // resultSet数据下标从1开始
                                            String columnName = metaData.getColumnName(i + 1);
                                            System.out.print(columnName + "\t");
                                        }
                                        System.out.print("\n");
                                        while (rs.next()){
                                                for (int i = 0; i < metaData.getColumnCount(); i++) {
                                                        // resultSet数据下标从1开始
                                                        System.out.print(rs.getString(i + 1) + "\t");
                                                }
                                                System.out.print("\n");
                                         }
                                        //DriverManager.getConnection("jdbc:derby:;shutdown=true");//关闭数据库
                                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
                                        e1.printStackTrace();
                                }//加载驱动
                                catch (SQLException e1) {
                                        e1.printStackTrace();
                                }//连接数据库
                    }
                    if(command.equals("初始化数据库")){
                            try {
                                Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                                Connection conn= DriverManager.getConnection("jdbc:derby:db;create=true");
                                Statement st = conn.createStatement();
                                //st.execute("create table USER_INFO (ID INT NOT NULL,NAME VARCHAR(10) NOT NULL)");//建表
                                //st.executeUpdate("insert into USER_INFO(ID,NAME) values (2,'hermit')");//插入数据
                                ResultSet rs = st.executeQuery("select * from USER_INFO");//读取刚插入的数据
                                // 获取列名
                                ResultSetMetaData metaData = rs.getMetaData();
                                for (int i = 0; i < metaData.getColumnCount(); i++) {
                                    // resultSet数据下标从1开始
                                    String columnName = metaData.getColumnName(i + 1);
                                    System.out.print(columnName + "\t");
                                }
                                System.out.print("\n");
                                while (rs.next()){
                                        for (int i = 0; i < metaData.getColumnCount(); i++) {
                                                // resultSet数据下标从1开始
                                                System.out.print(rs.getString(i + 1) + "\t");
                                        }
                                        System.out.print("\n");
                                 }
                                //DriverManager.getConnection("jdbc:derby:;shutdown=true");//关闭数据库
                        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
                                e1.printStackTrace();
                        }//加载驱动
                        catch (SQLException e1) {
                                e1.printStackTrace();
                        }//连接数据库
            }
                }//end of actionPerformed()
            }//end of ActionSet class

            static int Count = 0;
            static final int offset = 30;

            class NewFrame extends JInternalFrame
            {
                JTextPane textPane = null;
                MyUndoManager myUndo;

                public NewFrame() {
                    super("", true, true, true, true);
                    setTitle("Untitled Document " + (Count++));
                    setSize(new Dimension(300,200));

                    JPanel panel = new JPanel();
                    panel.setBorder(new EmptyBorder(10, 10, 10, 10));
                    panel.setLayout(new BorderLayout());

                    textPane = new JTextPane();
                    textPane.setBorder( new EmptyBorder(0,5 ,0, 5) );

                    myUndo = new MyUndoManager();
                    textPane.getDocument().addUndoableEditListener(myUndo);

                    JScrollPane textScroller = new JScrollPane(textPane,
                                                   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                                   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
                    panel.add( textScroller, BorderLayout.CENTER);
                    setContentPane(panel);
                    setLocation( offset * Count, offset *Count);
                }//end of NewFrame()

                public UndoManager getUndoManager()
                {
                    return myUndo;
                }
                public JTextPane getTextPane()
                {
                    return textPane;
                }//end of getTextPane()
            }//end of NewFrame class

            class MyUndoManager extends UndoManager
            {
                public void undoableEditHappened(UndoableEditEvent e)
                {
                    NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                    if(currentFrame == null) { return;}
                    UndoManager undo = currentFrame.getUndoManager();

                    undo.addEdit(e.getEdit());
                    new ActionSet("Undo",null).updateUndoState();
                    new ActionSet("Redo",null).updateRedoState();
                }//end of undoableEditHappened()
            }//end of MyUndoManager class
/*
        void initContentPanel(){
                firstView_Panel=new FirstView_Panel();
                firstView_Panel.setBounds(0, 0, 7, 4);
                contentPane.add(firstView_Panel);

                secondView_Panel=new SecondView_Panel();
                secondView_Panel.setBounds(0, 0, 7, 4);
                contentPane.add(secondView_Panel);

                tabpane = new JTabbedPane();
                tabpane.setBounds(0, 0, 700, 400);
                JPanel excelreplace = createPanel("EXCEL替换");
                tabpane.addTab("EXCEL替换",null,excelreplace,"do noting");

                JPanel excelcopy = createPanel("EXCEL复制");
                tabpane.addTab("EXCEL复制",null,excelcopy,"do noting");




                //tabpane.setMnemonicAt(1, KeyEvent.VK_1);
                tabpane.setPreferredSize(new Dimension(500,500));
                contentPane.add(tabpane);
                tabpane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
                tabpane.setTabPlacement(JTabbedPane.LEFT);
                JPanel pane1=new JPanel();
                GridLayout grid1=new GridLayout(12,12);
                pane1.setLayout(grid1);
                Label label[][]=new Label[12][12];
                for(int i=0;i<12;i++){
                    for(int j=0;j<12;j++){
                        label[i][j]=new Label();
                        if((i+j)%2==0)
                            label[i][j].setBackground(Color.black);
                        else
                            label[i][j].setBackground(Color.white);
                       pane1.add(label[i][j]);
                    }
                }
                //add(pane1,BorderLayout.CENTER);
                add(new JButton("north"),BorderLayout.NORTH);
                add(new JButton("south"),BorderLayout.SOUTH);
                add(new JButton("west"),BorderLayout.WEST);
                add(new JButton("east"),BorderLayout.EAST);
        }*/
        private JPanel createPanel(String string) {
                 //创建一个JPanel，并为构造函数初始false
                 //表示不适用双缓冲
                 JPanel panel = new JPanel(false);
                 //设置布局
                 panel.setLayout(new GridLayout(1,1));
                 //创建一个label放到panel中
                 JLabel filler = new JLabel(string);
                 filler.setHorizontalAlignment(JLabel.CENTER);
                 panel.add(filler);
                 return panel;
        }
}
