package com.dbmodel;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/*
* File : Hb0501.java
*
*
* @author  Yangyouwei
* @email   yangyouwei.zh@ccb.com
*
* Copyright (c) 2016-2026 CCB Co. All rights reserved.
*/

public class table implements java.io.Serializable {
        //固定内容
        private String       tablename; //表名
        private List<column> columns;    //列信息
        private List<String> indexs;       //序列
        //Get Methods
        public String       getTablename() { return this.tablename;}
        public List<column> getColumns  () { return this.columns  ;}
        public List<String> getIndexs   () { return this.indexs   ;}

        //Set Methods
        public void setTablename(String       tablename) {this.tablename =tablename;}
        public void setColumns  (List<column> columns  ) {this.columns   =columns  ;}
        public void setIndexs   (List<String> indexs   ) {this.indexs    =indexs   ;}

        //Constructors
        public table() {}

        public table(
                 String       tablename
                ,List<column> columns
                ,List<String> indexs
        ){
                setTablename(tablename);
                setColumns  (columns  );
                setIndexs   (indexs   );
        }
}
