package com.dn.lotte.api;


import com.dn.lotte.bean.UserInfoBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * des:ApiService
 * Created by dn
 * 1234567788888888
 */
public interface ApiService {


    // 用户登录
    @FormUrlEncoded
    @POST("user/ajaxLogin.aspx?oper=login")
    Observable<UserInfoBean> getUserInfo(
//            @Field("Name") String name,
//            @Field("Pass") String pass);
            @FieldMap Map<String, String> map);
//
//
//    // 刷新token
//    @FormUrlEncoded
//    @POST("p/ReAuth?")
//    Observable<TokenBean> refreshToken(
//            @Header("Cache-Control") String cacheControl,
//            @Field("refresh_token") String token);
//
//    //
//    //    // 刷新token
//    //    @FormUrlEncoded
//    //    @POST("hr/p/SearchResume?")
//    //    Observable<SearchResumeEntity> getResumeListData(
//    //            @Header("Cache-Control") String cacheControl,
//    //            @FieldMap Map<String, String> map);
//    //个人中心数据获取
//    @FormUrlEncoded
//    @POST("hr/PersonalCenter?")
//    Observable<UserDataBean> getUserData(
//            @Header("Cache-Control") String cacheControl,
//            @FieldMap Map<String, String> map);
//
//    //备注
//    @FormUrlEncoded
//    @POST("hr/GetHistory?")
//    Observable<List<RecentBean>> getUserMarkData(
//            @Header("Cache-Control") String cacheControl,
//            @FieldMap Map<String, String> map);
//
//    // 获取个人信息
//    @FormUrlEncoded
//    @POST("hr/GetHrInfo?")
//    Observable<UserDataBean> getUserInfoData(
//            @Header("Cache-Control") String cacheControl,
//            @FieldMap Map<String, String> map);
//
//    // 个人信息
//    @FormUrlEncoded
//    @POST("hr/HrMyInfo?")
//    Observable<UserDataBean> updateUserInfoData(
//            @Header("Cache-Control") String cacheControl,
//            @FieldMap Map<String, String> map);
//
//    // 提交头像
//    @POST
//    Observable<ApiModel> uploadFiles(
//            @Url() String url,
//            @Body RequestBody body);
//
//    // home data
//    @FormUrlEncoded
//    @POST("hr/MyHomePage?")
//    Observable<HomeBean> getHomeData(
//            @Header("Cache-Control") String cacheControl,
//            @FieldMap Map<String, String> map);
//
//    // 意见反馈
//    @FormUrlEncoded
//    @POST(ApiConstants.FEEDBACK_URL)
//    Observable<HomeBean> uploadFeedBackData(
//            @Header("Cache-Control") String cacheControl,
//            @FieldMap Map<String, String> map);
//
//    // 搜索记录
//    @FormUrlEncoded
//    @POST(ApiConstants.SEARCHRECORDS)
//    Observable<List<SeachRecordsBean>> getSearchRecords(
//            @Header("Cache-Control") String cacheControl,
//            @FieldMap Map<String, String> map);
//    // 搜索记录
//    @FormUrlEncoded
//    @POST(ApiConstants.DELETESEARCHRECORDS)
//    Observable<String> deleteSearchRecords(
//            @Header("Cache-Control") String cacheControl,
//            @FieldMap Map<String, String> map);
//
//    // 收索简历列表
//    @FormUrlEncoded
//    @POST(ApiConstants.SEARCHRESUME)
//    Observable<SearchResumeBean> getSearchResumeList(
//            @Header("Cache-Control") String cacheControl,
//            @FieldMap Map<String, String> map);
//
//    // 收索简历列表
//    @FormUrlEncoded
//    @POST(ApiConstants.RESUMEDETAILDATA)
//    Observable<ResumeDetailBean> getResumeDetailData(
//            @Header("Cache-Control") String cacheControl,
//            @FieldMap Map<String, String> map);
//
//    // 判断是否可以聊天
//    @FormUrlEncoded
//    @POST(ApiConstants.REFUSEDTO)
//    Observable<ResumeChat> getIsChat(
//            @Header("Cache-Control") String cacheControl,
//            @FieldMap Map<String, String> map);
//    // 获取开关状态
//    @FormUrlEncoded
//    @POST(ApiConstants.BLACKLIST)
//    Observable<ResumeChat> getIsAllChat(
//            @Header("Cache-Control") String cacheControl,
//            @FieldMap Map<String, String> map);
//    // 设置是否可以聊天
//    @FormUrlEncoded
//    @POST(ApiConstants.REFUSE)
//    Observable<ResumeChat> setIsAllChat(
//            @Header("Cache-Control") String cacheControl,
//            @FieldMap Map<String, String> map);
//
//    // 进入注册界面 获取cookie 获取是否需要图形验证
//    @GET(ApiConstants.SWITCHSTATE)
//    Observable<CodeBean> getCookieData(
//            @Header("Cache-Control") String cacheControl,
//            @QueryMap Map<String, String> map);
//
//    // 图形验证
//    @GET(ApiConstants.CODEVERIFICATION)
//    Observable<CodeVerificationBean> getVerification(
//            @Header("Cookie") String cookeie,
//            @Header("Cache-Control") String cacheControl,
//            @QueryMap Map<String, String> map);
//
//    // 注册
//    @FormUrlEncoded
//    @POST(ApiConstants.REGISITER)
//    Observable<UserInfoBean> getRegisterData(
//            @Header("Cache-Control") String cacheControl,
//            @QueryMap Map<String, String> map);
}
