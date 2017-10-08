package com.easy.common.commonutils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.easy.common.R;

import java.io.File;



/**
 *
 * Description : 图片加载工具类 使用glide框架封装
 * 中间层   方便更改
 */
public class ImageLoaderUtils {

    public static void display(Context context, ImageView imageView, String url, int loading, int error) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
//        Glide.with(context).load(url).placeholder(loading).transform(new GlideRoundTransform(context,5))
//                .error(error).crossFade().into(imageView);

        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
//                .placeholder(loading)
                .transform(new GlideRoundTransform(context,5))
                .error(error)
                .crossFade().into(imageView);
    }

    public static void display(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
//                .placeholder(R.drawable.ic_image_loading)
                .transform(new GlideRoundTransform(context,5))
                .error(R.drawable.ic_empty_picture)
                .crossFade().into(imageView);
    }

    public static void display(Context context, ImageView imageView, String url,int errorUrl) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
//                .placeholder(errorUrl)
                .transform(new GlideRoundTransform(context,5))
                .error(errorUrl)
                .crossFade().into(imageView);
    }

    public static void display(Context context, ImageView imageView, File url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
//                .placeholder(R.drawable.ic_image_loading)
                .transform(new GlideRoundTransform(context,5))
                .error(R.drawable.ic_empty_picture)
                .crossFade().into(imageView);
    }
//    public static void display(Context context, ImageView imageView,String url, int Loadingurl,int errorUrl) {
//        if (imageView == null) {
//            throw new IllegalArgumentException("argument error");
//        }
//        Glide.with(context).load(url)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .centerCrop()
//                .placeholder(R.drawable.ic_image_loading)
//                .transform(new GlideRoundTransform(context,5))
//                .error(R.drawable.ic_empty_picture)
//                .crossFade().into(imageView);
//    }
    public static void displaySmallPhoto(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url).asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new GlideRoundTransform(context,5))
//                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .thumbnail(0.5f)
                .into(imageView);
    }
    public static void displayBigPhoto(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url).asBitmap()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new GlideRoundTransform(context,5))
//                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .into(imageView);
    }
    public static void display(Context context, ImageView imageView, int url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .transform(new GlideRoundTransform(context,5))
//                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .crossFade().into(imageView);
    }
    public static void displayRound(Context context,ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.toux2)
                .centerCrop().transform(new GlideRoundTransformUtil(context)).into(imageView);
    }

}
