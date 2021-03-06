package com.easy.common.commonwidget.dialog;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.easy.common.R;
import com.easy.common.baseapp.BaseApplication;

import java.lang.ref.WeakReference;



/**
 * 主要功能:DialogView的辅助类
 * Created by wz on 2017/3/22
 * 修订历史:
 */
class DialogViewHelper {

    private View mDialogView=null;
    //防止泄露
    private SparseArray<WeakReference<View>> mViews;

    public DialogViewHelper(Context mContext, int mViewLayoutResId) {
        this();
        mDialogView= LayoutInflater.from(mContext).inflate(mViewLayoutResId,null);
    }

    public DialogViewHelper() {
        mViews=new SparseArray<>();
    }

    /**
     * 设置布局
     * @param mView
     * */
    public void setDialogView(View mView) {
        this.mDialogView=mView;
    }

    /**
     * 设置文本
     * @param viewId
     * @param text
     */
    public void setText(int viewId, CharSequence text) {

        TextView tv=getView(viewId);
        if(tv!=null){
            tv.setText(text==null?"":text);
        }

    }

    /**
     * 设置文本颜色
     * @param viewId
     * @param colorRes
     */
    public void setTextColor(Context context, int viewId, int colorRes) {

        TextView tv=getView(viewId);
        if(tv!=null){
            tv.setTextColor(context.getResources().getColor(colorRes==0? R.color.text_gray_normal:colorRes));
        }

    }

    /**
     * 设置图片
     * @param viewId
     * @param imgRes
     */
    public void setImage(int viewId, int imgRes) {

        ImageView iv=getView(viewId);
        if(iv!=null){
            iv.setImageResource(imgRes==0? R.drawable.ease_default_avatar :imgRes);
        }

    }

    /**
     * 设置图片
     * @param viewId
     * @param imgRes
     */
    public void setImage(int viewId, String imgRes) {

        ImageView iv=getView(viewId);
        if(iv!=null){
            Glide.with(BaseApplication.getAppContext())
                    .load(imgRes)
                    .asBitmap()
                    .skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE)
                    .error(R.drawable.ic_empty_picture)
                    .into(iv);
        }

    }
    /**
     * 设置view的显示和隐藏
     * @param viewId
     * @param visibilityMode
     */
    public void setVisiable(int viewId, int visibilityMode) {
        View v=getView(viewId);
        if(v!=null){
            v.setVisibility(visibilityMode);
        }
    }
    /**
     * 优化findViewById
     * @param viewId
     * @param <T>
     * @return
     */
    public  <T extends View> T getView(int viewId) {
        View v=null;
        WeakReference<View> viewRefrence=mViews.get(viewId);
        if(viewRefrence!=null){
            v=viewRefrence.get();
        }
        if(v==null){
            v=mDialogView.findViewById(viewId);
            if(v!=null){
                mViews.put(viewId,new WeakReference<View>(v));
            }
        }
        return (T)v;
    }

    /**
     * 设置点击事件
     * @param viewId
     * @param onClickListener
     */
    public void setOnclickListener(int viewId, View.OnClickListener onClickListener) {
        View v=getView(viewId);
        if(v!=null){
            v.setOnClickListener(onClickListener);
        }

    }

    public View getDialogView() {
        return mDialogView;
    }


}
