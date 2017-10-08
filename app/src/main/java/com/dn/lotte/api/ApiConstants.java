/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.dn.lotte.api;


public class ApiConstants {

    //	public static final String URL = "http://192.168.1.212:8080/compass/";// 小丁主机IP

//      public static final String URL = "http://138.128.204.17:8081/compass/";// 测试服192.168.1.185:8092
//    public static final String URL = "https://jobtube.cn/compass/";// 秋林拍服务器
    //  public static final String URL = "http://47.93.160.142/compass/";// 秋林拍服务器

      public static final String URL = "http://123.207.44.159:50090/";// 正式服
//


    public static final String FEEDBACK_URL = "p/Feedback?";// 意见反馈
    public static final String SEARCHRECORDS = "hr/GetHistory?";// 搜索记录
    public static final String DELETESEARCHRECORDS = "hr/RemoveHistory?";// 清除搜索记录
    public static final String SEARCHRESUME = "v2/hr/p/SearchResume?";// 收索简历列表
    public static final String RESUMEDETAILDATA = "hr/p/ViewResume?";// 收索简历列表
    public static final String REFUSEDTO = "hr/GetIMReject?";//判断是否可以聊天
    public static final String REFUSE = "hr/SetIMReject?";//设置是否可以聊天
    public static final String BLACKLIST = "hr/GetIMRejectStatus";//获取开关状态
    public static final String SWITCHSTATE = "p/switch?";//获取是否需要验证码
    public static final String CODEVERIFICATION= "p/sms/code?";//验证账号
    public static final String REGISITER= "v2/hr/p/Regist?";// 注册
}
