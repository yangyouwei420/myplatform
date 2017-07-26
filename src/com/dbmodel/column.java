package com.dbmodel;
import java.math.BigDecimal;
import java.util.Date;

/*
* File : Hb0501.java
*
* @author  Yangyouwei
* @email   yangyouwei.zh@ccb.com
*
* Copyright (c) 2016-2026 CCB Co. All rights reserved.
*/

public class column implements java.io.Serializable {
        //固定内容
        private String    name;  //名称
        private String    desciption; //中文名
        private String    type;    //类型
        private int         length; //长度

        //Get Methods
        public String getName()   { return this.name; }
        public String getDesciption()   { return this.desciption; }
        public String getType()   { return this.type; }
        public int    getLength() { return this.length; }

        //Set Methods
        public void setName  (String name  ){ this.name   = name; }
        public void setDesciption  (String desciption  ){ this.desciption   = desciption; }
        public void setType  (String type  ){ this.type   = type; }
        public void setLength(int    length){ this.length = length; }

        //Constructors
        public column() {}

        public column(
                 String name
                ,String desciption
                ,String type
                ,int    length
        ){
                setName  (name   );
                setDesciption(desciption);
                setType  (type   );
                setLength(length );
        }
}
