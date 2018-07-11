package com.yanxuwen.lib_common.Proxy;

import retrofit2.http.POST;

/**
 * @Path .Subject2.java
 * @Author 严旭文
 * @Date 2016-8-31 上午11:13:34
 * @Company 蓝海（福建）信息技术有限公司
 * @Description
 * 委托类2
 */
public interface Subject2 {
  @POST("地址2")
  public void request2();
}

