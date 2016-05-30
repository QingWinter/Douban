package com.winter.github.douban.main.model.bean;

/**
 * Created by Winter on 2016/5/27.
 * Description 演员
 * email:huang.wqing@qq.com
 */
public class Cast {
    private String alt;
    /**
     * small : http://img3.doubanio.com/img/celebrity/small/33797.jpg
     * large : http://img3.doubanio.com/img/celebrity/large/33797.jpg
     * medium : http://img3.doubanio.com/img/celebrity/medium/33797.jpg
     */

    private Avatar avatars;
    private String name;
    private String id;


    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Avatar getAvatars() {
        return avatars;
    }

    public void setAvatars(Avatar avatars) {
        this.avatars = avatars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
