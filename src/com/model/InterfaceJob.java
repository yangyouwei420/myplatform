package com.model;
import java.math.BigDecimal;
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

public class InterfaceJob implements java.io.Serializable {
        //固定内容
        public table getTableInfo(){
                List<column> columns = new ArrayList<>();
                columns.add(new column("enable"      ,"有效标志"      ,"varchar",64));
                columns.add(new column("id"          ,"任务ID"        ,"int"    ,11));
                columns.add(new column("name"        ,"任务名称"      ,"varchar",64));
                columns.add(new column("total"       ,"项目总数"      ,"int"    ,11));
                columns.add(new column("succeed"     ,"项目成功数"    ,"int"    ,11));
                columns.add(new column("unexecute"   ,"项目未执数"    ,"int"    ,11));
                columns.add(new column("succeedrate" ,"项目执行百分比","float"  ,64));
                List<String> indexs = new ArrayList<>();
                table currenttable = new table("job",columns,indexs);
                return currenttable;
        }

}
