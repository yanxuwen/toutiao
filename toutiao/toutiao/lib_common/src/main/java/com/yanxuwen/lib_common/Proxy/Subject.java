package com.yanxuwen.lib_common.Proxy;

import retrofit2.http.POST;

/**
 * @Path .Subject.java
 * @Author 严旭文
 * @Date 2016-8-31 上午10:29:27
 * @Company 蓝海（福建）信息技术有限公司
 * @Description
 * 委托类
 */
public interface Subject {
  @POST("地址")
  public void request();
}
