package com.easy.common.baserx;

/**
 *
 * 指定 API 的通用错误
 */

public class ApiException extends RuntimeException{

    public ApiException(String msg){
        super(msg);
    }

}
