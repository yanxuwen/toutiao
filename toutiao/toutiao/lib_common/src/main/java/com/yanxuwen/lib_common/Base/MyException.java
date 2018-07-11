package com.yanxuwen.lib_common.Base;

/**
 * 作者：严旭文 on 2016/6/29 11:08
 * 邮箱：420255048@qq.com
 */
public class MyException extends Throwable {

    public MyException() {

        super();

    }

    public MyException(String msg) {

        super(msg);

    }

    public MyException(String msg, Throwable cause) {

        super(msg, cause);

    }

    public MyException(Throwable cause) {

        super(cause);

    }

}
