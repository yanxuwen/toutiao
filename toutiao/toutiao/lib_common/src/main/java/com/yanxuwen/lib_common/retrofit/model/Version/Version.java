package com.yanxuwen.lib_common.retrofit.model.Version;


import com.yanxuwen.lib_common.retrofit.MyBaseModel;

/**
 * 作者：严旭文 on 2016/7/4 17:26
 * 邮箱：420255048@qq.com
 * 版本更新
 */
public class Version extends MyBaseModel {
    public int platform;
    public int latest;
    public String channel;
    public String version;

    /** 是否强制升级 */
    public int force_update;
    public String download_url;
    /**修改记录text*/
    public String description;

    public boolean isUpdata() {
        return latest == 1 ? true : false;
    }

    public boolean isForce() {
        return force_update == 1 ? true : false;
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getforce_update() {
        return force_update;
    }

    public void setforce_update(int force_update) {
        this.force_update = force_update;
    }

    public String getURL() {
        return download_url;
    }

    public void setURL(String download_url) {
        this.download_url = download_url;
    }


    public String getDescription() {
        return this.description ;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
