package com.easy.common.commonwidget;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.easy.common.R;
import com.wang.avi.AVLoadingIndicatorView;


/**
 * description:界面过度加载动画
 * Created by 丁宁
 * on 2017.05
 */
public class AnimationLoadingDialog {
    private static AVLoadingIndicatorView avi;
    /**
     * 加载数据对话框
     */
    private static Dialog mLoadingDialog;

    public static Dialog showDialogForLoading(Activity context) {
        View view = LayoutInflater.from(context).inflate(R.layout.animation_loading, null);
        avi = (AVLoadingIndicatorView) view.findViewById(R.id.aviloading);
        avi.show();
        mLoadingDialog = new Dialog(context, R.style.CustomProgressDialog);
        mLoadingDialog.setCancelable(true);
        mLoadingDialog.setCanceledOnTouchOutside(false);
        mLoadingDialog.setContentView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        mLoadingDialog.show();
        return mLoadingDialog;
    }

    /**
     * 关闭加载对话框
     */
    public static void cancelDialogForLoading() {
        if (mLoadingDialog != null) {
            avi.hide();
            mLoadingDialog.cancel();
        }
    }
}
