package com.easy.common.commonutils;

import android.content.Context;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.ShareContentCustomizeCallback;

/**
 * Created by 丁宁
 * on 2017/7/14.
 */

public class ShareUtils {

    /**
     *  ShareSDK分享 3.0
     * @param context 上下文
     * @param titleText 标题文字
     * @param titleUrl 链接
     * @param imageUrl 图片地址
     * @param text 辅助文字
     */
    public static void easyShowShare(final Context context,final String titleText, final String titleUrl, final String imageUrl, final String text) {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        oks.setTitle(titleText);
        oks.setTitleUrl(titleUrl); // 标题的超链接
        oks.setText(text);
        oks.setImageUrl(imageUrl);
        oks.setUrl(titleUrl);
        oks.setSilent(true);
        oks.setComment("-" + titleText + "-");
        oks.setSite(titleText);
        oks.setShareContentCustomizeCallback(new ShareContentCustomizeCallback() {

            @Override
            public void onShare(Platform platform, Platform.ShareParams paramsToShare) {
                //单独处理微博 微博图片显示规则不同 单独处理显示比较美观 没别的作用--。
                paramsToShare.setText(titleText + titleUrl + " ");
                paramsToShare.setImageUrl(imageUrl);
                paramsToShare.setUrl(null);
            }
        });
        // 启动分享GUI
        oks.show(context);
    }

}
