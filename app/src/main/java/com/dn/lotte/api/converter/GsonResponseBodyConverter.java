/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dn.lotte.api.converter;

import com.dn.lotte.api.exception.TokenNotExistException;
import com.dn.lotte.bean.ApiModel;
import com.easy.common.baserx.ApiException;
import com.google.gson.TypeAdapter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;


final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, Object> {

    private final TypeAdapter<T> adapter;

    GsonResponseBodyConverter(TypeAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override
    public Object convert(ResponseBody value) throws IOException {
        try {
            ApiModel apiModel = (ApiModel) adapter.fromJson(value.charStream());
            if (apiModel.code == 0) {
                return apiModel.table;
            } else if (apiModel.code == 3) {
//                throw new TokenInvalidException();
//                AppManager.getAppManager()
//                        .currentActivity()
//                        .startActivity(new Intent(AppManager.getAppManager().currentActivity(), LoginActivity.class));
//                EMClient.getInstance().logout(true);
//                AppManager.getAppManager().currentActivity().finish();
                throw new TokenNotExistException("账户过期，请重新登录，我的弟弟");
            } else {
                throw new ApiException("错误码：" + apiModel.code);
            }
//            else if (apiModel.errorCode == ErrorCode.TOKEN_INVALID) {
//                throw new TokenInvalidException();
//            } else
//            if (!apiModel.success) {
//                // 特定 API 的错误，在相应的 Subscriber 的 onError 的方法中进行处理
//                throw new ApiException();
//            } else if (apiModel.success) {
//                return apiModel.data;
//            }
        } finally {
            value.close();
        }
    }
}
