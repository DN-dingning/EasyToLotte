package com.dn.lotte.app;

import com.easy.common.baseapp.BaseApplication;

/**
 * Created by 丁宁
 * on 2017/5/3.
 */

public class GlobalApplication extends BaseApplication {
    private static GlobalApplication mContext;

    public static GlobalApplication getInstance() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
//        initImagePicker();
//        initEMClient();
//        IntentService intentService = new IntentService("") {
//            @Override
//            protected void onHandleIntent(@Nullable Intent intent) {
//
//            }
//        };
    }

//    /**
//     * 初始化环信
//     */
//    private void initEMClient() {
//        EMOptions options = new EMOptions();
//        // 默认添加好友时，是不需要验证的，改成需要验证
//        options.setAcceptInvitationAlways(false);
//        EaseUI.getInstance().init(mContext, options);
//    }
//
//    private void initImagePicker() {
//        ImagePicker imagePicker = ImagePicker.getInstance();
//        imagePicker.setMultiMode(false);
//        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
//        imagePicker.setShowCamera(false);                      //显示拍照按钮
//        imagePicker.setCrop(true);                           //允许裁剪（单选才有效）
//        imagePicker.setSaveRectangle(true);                   //是否按矩形区域保存
//        imagePicker.setSelectLimit(1);                       //选中数量限制
//        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
//        imagePicker.setFocusWidth(800);                       //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
//        imagePicker.setFocusHeight(800);                      //裁剪框的高度。单位像素（圆形自动取宽高最小值）
//        imagePicker.setOutPutX(1000);                         //保存文件的宽度。单位像素
//        imagePicker.setOutPutY(1000);                         //保存文件的高度。单位像素
//    }
//
//    /**
//     * 登录之后设置为true
//     *
//     * @param value
//     */
//    public void setLogin(boolean value) {
//        SPUtils.setSharedBooleanData(mContext, "ISLOGIN", value);
//    }
//
//    /**
//     * 是否登录  true登录
//     *
//     * @author 丁宁
//     * @description
//     */
//    public boolean isLogin() {
//        return SPUtils.getSharedBooleanData(mContext, "ISLOGIN");
//    }
//
//    /**
//     * 设置accesstoken
//     *
//     * @param value
//     */
//    public void setAccessToken(String value) {
//        SPUtils.setSharedStringData(mContext, "AccessToken", value);
//    }
//
//    /**
//     * 获取accesstoken
//     *
//     * @author 丁宁
//     * @description
//     */
//    public String getAccessToken() {
//        return SPUtils.getSharedStringData(mContext, "AccessToken");
//    }
//
//    /**
//     * 设置RefreshToken
//     *
//     * @param value
//     */
//    public void setRefreshToken(String value) {
//        SPUtils.setSharedStringData(mContext, "RefreshToken", value);
//    }
//
//    /**
//     * 获取RefreshToken
//     *
//     * @author 丁宁
//     * @description
//     */
//    public String getRefreshToken() {
//        return SPUtils.getSharedStringData(mContext, "RefreshToken");
//    }
//
//    /**
//     * 设置USRRID
//     *
//     * @param value userid
//     */
//    public void setUserID(String value) {
//        SPUtils.setSharedStringData(mContext, "USRRID", value);
//    }
//
//    /**
//     * 获取USRRID
//     *
//     * @author 丁宁
//     * @description
//     */
//    public String getUserID() {
//        return SPUtils.getSharedStringData(mContext, "USRRID");
//    }
//
//    private UserInfoBean.UserBean userModel;
//
//    /**
//     * 存储对象
//     *
//     * @param bean 个人信息本地数据
//     */
//    public void setUserModel(UserInfoBean.UserBean bean) {
//        if (bean != null) {
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ObjectOutputStream objectOutputStream;
//            try {
//                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//                objectOutputStream.writeObject(bean);
//                String serStr = byteArrayOutputStream.toString("ISO-8859-1");
//                serStr = java.net.URLEncoder.encode(serStr, "UTF-8");
//                SPUtils.setSharedStringData(mContext, "USER_MODEL_CLASS", serStr);
//                objectOutputStream.close();
//                byteArrayOutputStream.close();
//
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        } else {
//            SPUtils.setSharedStringData(mContext, "USER_MODEL_CLASS", null);
//        }
//        userModel = bean;
//    }
//
//    /**
//     * 获取对象
//     *
//     * @return 个人信息本地数据
//     */
//    public UserInfoBean.UserBean getUserModel() {
//        if (userModel == null) {
//            String temp = SPUtils.getSharedStringDatas(mContext, "USRRID");
//            if (temp == null) {
//                return null;
//            }
//            String redStr;
//            try {
//                redStr = java.net.URLDecoder.decode(temp, "UTF-8");
//                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(redStr.getBytes("ISO-8859-1"));
//                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//                userModel = (UserInfoBean.UserBean) objectInputStream.readObject();
//                objectInputStream.close();
//                byteArrayInputStream.close();
//            } catch (UnsupportedEncodingException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (StreamCorruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        return userModel;
//    }

}

