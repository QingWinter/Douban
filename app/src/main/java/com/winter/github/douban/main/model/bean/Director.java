package com.winter.github.douban.main.model.bean;

/**
 * Created by Winter on 2016/5/27.
 * Description 导演
 * email:huang.wqing@qq.com
 */
public class Director {
    private String alt;
    /**
     * small : http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png
     * large : http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png
     * medium : http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png
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

    public void setAvatars(Avatar avatars) {
        this.avatars = avatars;
    }

    public Avatar getAvatars() {
        return avatars;
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
