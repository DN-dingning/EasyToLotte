package com.dn.lotte.app;

import android.os.Environment;

/**
 * des: chagnliang
 * Created by dn
 */
public class AppConstant {
    public static String USERCENTERREFRESH = "USERCENTERREFRESH"; //个人中心刷新
    public static String COMPANYID = "COMPANYIN"; //公司id
    public static String POPSITIONID = "POPSITIONID";//职位id
    public static String INFODATA = "INFODATA";//我的信息 昵称
    public static String INFOCOMPANYUIL = "UIL";//我的信息 公司地址
    public static String INFOCOMPANYDES = "DES";//我的信息 公司描述
    public static String INFOREFRESH = "INFOREFRESH";//刷新我的信息
    public static String INFOTITLE = "INFOTITLE";//我的信息 传递title 1 昵称  2 公司名称 3 职位
    public static String PROFESSIONTYPE = "PROFESSIONTYPE";//行业类别
    public static String ADDRESSTYPE = "ADDRESSTYPE";//工作地点
    public static String ADDRESSTYPEISHOME = "HOMEADDRESSTYPE";//工作地点
    public static String JOBTYPE = "JOBTYPE";//职位类别
    public static final String TRANSITION_ANIMATION_NEWS_PHOTOS = "transition_animation_news_photos";

    public static int WHERETOGO = 0;//确保刷新token的时候返回到正确的页面

    public static String ADDRESSALL = "全国|All Chinese Cities";
    public static String ADDRESSHOT = "热门|Hot";
    public static String ADDRESSCHINACITY = "ALLCHINESECITIES";
    public static String ADDRESSOTHER = "其他|Other";
    public static String CHINA = "全国|All Chinese Cities";
    public static String HOTLISt = "HOTLIST";
    public static String LOGINPHONE = "LONGINPHONE"; //sp 记录上次登录的手机号
    public static String DCIMPATH = Environment.getExternalStorageDirectory() + "/DCIM/";

}
