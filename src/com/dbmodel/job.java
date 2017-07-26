package com.dbmodel;
import java.math.BigDecimal;
import java.util.Date;

/*
* File : Hb0501.java
*
* @author  AdlerLiu
* @email   xmkun2005@126.com
*
* And it's part of CCB (http://www.ccb.com).
*
* Copyright (c) 2016-2026 CCB Co. All rights reserved.
*/

public class job implements java.io.Serializable {
        //固定内容
        private Integer id; //唯一标识
        private Boolean inuse;
        //Get Methods 
        public Integer getId() { return this.id; }
        public Boolean getInuse() { return this.inuse;}

        //Set Methods
        public void setId(Integer id) { this.id = id; }
        public void setInuse(Boolean inuser) { this.inuse=inuse; }

        private String jobname;     /* 任务名称 */
        private String jobtip;      /* 备注描述 */
        private String status;      /* 当前状态 */
        private Date   lateststart; /* 最近一次开始执行时间   */
        private Date   latestend;   /* 最近一次结束执行时间   */
        private Date   nextstart;   /* 下一次开始执行时间     */

        public String getjobname    (){return this.jobname    ;}
        public String getjobtip     (){return this.jobtip     ;}
        public String getstatus     (){return this.status     ;}
        public Date   getlateststart(){return this.lateststart;}
        public Date   getlatestend  (){return this.latestend  ;}
        public Date   getnextstart  (){return this.nextstart  ;}

        public void setjobname    (String jobname    ) { this.jobname     = jobname    ;}
        public void setjobtip     (String jobtip     ) { this.jobtip      = jobtip     ;}
        public void setstatus     (String status     ) { this.status      = status     ;}
        public void setlateststart(Date   lateststart) { this.lateststart = lateststart;}
        public void setlatestend  (Date   latestend  ) { this.latestend   = latestend  ;}
        public void setnextstart  (Date   nextstart  ) { this.nextstart   = nextstart  ;}



        //Constructors
        public job() {}


        public job(
                 Integer id
                ,Boolean inuse
                ,String  jobname
                ,String  jobtip
                ,String  status
                ,Date    lateststart
                ,Date    latestend
                ,Date    nextstart
                ){
                setId         (id         );
                setInuse      (inuse      );
                setjobname    (jobname    );
                setjobtip     (jobtip     );
                setstatus     (status     );
                setlateststart(lateststart);
                setlatestend  (latestend  );
                setnextstart  (nextstart  );
        }

        public String toString() {
                return "job[" +
                                "id="          + id          + " " +
                                "inuse="       + inuse       + " " +
                                "jobname="     + jobname     + " " +
                                "jobtip="      + jobtip      + " " +
                                "status="      + status      + " " +
                                "lateststart=" + lateststart + " " +
                                "latestend="   + latestend   + " " +
                                "nextstart="   + nextstart   + " " +
        "]";
        }
}
