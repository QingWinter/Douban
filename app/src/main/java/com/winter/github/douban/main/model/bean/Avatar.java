package com.winter.github.douban.main.model.bean;

/**
 * Created by Winter on 2016/5/27.
 * Description 影人头像，分别提供420px x 600px(大)，140px x 200px(中) 70px x 100px(小)尺寸
 * email:huang.wqing@qq.com
 */
public class Avatar {
    private String small;
    private String large;
    private String medium;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
