package com.yanxuwen.lib_common.Bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yanxuwen on 2017/9/20.
 */

public class HttpError {
    private final Map<String, String> httperrorMap = new ConcurrentHashMap<>();
    private static HttpError mHttpError;
    public static HttpError getInstance(){
        if(mHttpError==null){
            mHttpError=new HttpError();
            return mHttpError;

        }
        else return mHttpError;
    }
    public HttpError(){
        httperrorMap.put("ServerError", "服务器错误");
        httperrorMap.put("InvalidCredentials", "密码错误");
        httperrorMap.put("TheUsernameFieldIsRequired", "用户名不能为空");
        httperrorMap.put("TheUsernameFormatIsInvalid", "用户名格式错误");
        httperrorMap.put("TheSelectedUsernameDoesNotExist", "用户名不存在");
        httperrorMap.put("ThePasswordFieldIsRequired", "密码不能为空");
        httperrorMap.put("InvalidRequest", "refresh_token 错误");
        httperrorMap.put("TheRefreshTokenFieldIsRequired", "refresh_token 不能为空");
        httperrorMap.put("TheMobileFormatIsInvalid", "手机无效");
        httperrorMap.put("TheMobileHasAlreadyBeenTaken", "手机已存在");
        httperrorMap.put("CodeHasBeenLimited", "获取验证码次数超限");
        httperrorMap.put("TheSelectedMobileDoesNotExist", "手机不存在");
        httperrorMap.put("TheUsernameHasAlreadyBeenTaken", "用户名已存在");
        httperrorMap.put("ThePasswordMayOnlyContainLettersAndNumbersAndDashes", "密码仅能含字母、数字、破折号，下划线");
        httperrorMap.put("ThePasswordMustBeBetween6And32Characters", "密码需6-32位");
        httperrorMap.put("TheCodeFieldIsRequired", "验证码不能为空");
        httperrorMap.put("TheCodeMustBe6Characters", "验证码必须6位数");
        httperrorMap.put("AuthorizationFailed", "授权失败");
        httperrorMap.put("TheCodeFieldIsRequired", "Code 不能为空");
        httperrorMap.put("Unauthenticated", "Authorization 未提交");
        httperrorMap.put("AccessDenied", "access_token 错误或失效");
        httperrorMap.put("TheNicknameMayNotBeGreaterThan32Characters", "昵称不能超过32个字符");
        httperrorMap.put("TheSelectedGenderIsInvalid", "错误的性别");
        httperrorMap.put("TheSelectedGenerationIsInvalid", "错误年龄段");
        httperrorMap.put("TheSignatureMayNotBeGreaterThan128Characters", "个人签名不能超过128个字符");

        httperrorMap.put("CodeInvalid", "验证码错误");
    }
    public String getValue(String key){
        if(httperrorMap!=null) {
            return httperrorMap.get(key);
        }
        return "";
    }
}
