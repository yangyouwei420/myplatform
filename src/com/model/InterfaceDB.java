package com.model;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dbmodel.column;
import com.dbmodel.table;

/*
* File : Hb0501.java
*
* @author  Yangyouwei
* @email   yangyouwei.zh@ccb.com
*
* Copyright (c) 2016-2026 CCB Co. All rights reserved.
*/

public class InterfaceDB implements java.io.Serializable {
        //固定内容
        private String dbmode   ; //数据库类型
        private String dbname   ; //数据库名字
        private String dbpath   ; //数据库路径
        private String ipaddress; //IP地址
        private int    port     ; //端口号
        private String username ; //账号
        private String password ; //密码
        private Connection connection = null;
        private Statement statement   = null;
        //Get Methods
        public String getdbmode   (){ return this.dbmode   ;}
        public String getdbname   (){ return this.dbname   ;}
        public String getdbpath   (){ return this.dbpath   ;}
        public String getipaddress(){ return this.ipaddress;}
        public int    getport     (){ return this.port     ;}
        public String getusername (){ return this.username ;}
        public String getpassword (){ return this.password ;}
        //Set Methods
        public void setdbmode   (String getdbmode   ){ this.dbmode    = dbmode   ;}
        public void setdbname   (String getdbname   ){ this.dbname    = dbname   ;}
        public void setdbpath   (String getdbpath   ){ this.dbpath    = dbpath   ;}
        public void setipaddress(String getipaddress){ this.ipaddress = ipaddress;}
        public void setport     (int    getport     ){ this.port      = port     ;}
        public void setusername (String getusername ){ this.username  = username ;}
        public void setpassword (String getpassword ){ this.password  = password ;}
        //Constructors
        public InterfaceDB() {}

        public  InterfaceDB(
                 String dbmode    //数据库类型
                ,String dbname    //数据库名字
                ,String dbpath    //数据库路径
                ,String ipaddress //IP地址
                ,int    port      //端口号
                ,String username  //账号
                ,String password  //密码
        ){
                setdbmode   (dbmode   );
                setdbname   (dbname   );
                setdbpath   (dbpath   );
                setipaddress(ipaddress);
                setport     (port     );
                setusername (username );
                setpassword (password );
        }
        public boolean connectderby(){
                try {
                        Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                        connection = DriverManager.getConnection("jdbc:derby:db;create=true");
                        statement  = connection.createStatement();
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
                        e1.printStackTrace();
                }//加载驱动
                catch (SQLException e1) {
                        e1.printStackTrace();
                }//连接数据库
                return true;
        }

        //固定内容
        public boolean connect(){
                if("derby".equals(dbmode)){
                        return connectderby();
                }
                else{
                        System.out.println("无法识别的模式"+dbmode);
                        return false;
                }
        }
        //固定内容
        public boolean disconnect(){
                if("derby".equals(dbmode)){
                        try {
                                connection.close();
                        } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                }
                else{
                        System.out.println("无法识别的模式"+dbmode);
                        return false;
                }
                return true;
        }

}
