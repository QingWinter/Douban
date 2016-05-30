package com.winter.github.douban.main.model.bean;

import java.util.List;

/**
 * Created by Winter on 2016/5/27.
 * Description 电影条目
 * email:huang.wqing@qq.com
 */
public class MovieSubject {

    /**
     * max : 10
     * average : 7.2
     * stars : 40
     * min : 0
     */

    private Rating rating;
    /**
     * rating : {"max":10,"average":7.2,"stars":"40","min":0}
     * genres : ["喜剧","动作","动画"]
     * title : 愤怒的小鸟
     * casts : [{"alt":"https://movie.douban.com/celebrity/1049521/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/33797.jpg","large":"http://img3.doubanio.com/img/celebrity/large/33797.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/33797.jpg"},"name":"杰森·苏戴奇斯","id":"1049521"},{"alt":"https://movie.douban.com/celebrity/1305235/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/38561.jpg","large":"http://img3.douban.com/img/celebrity/large/38561.jpg","medium":"http://img3.douban.com/img/celebrity/medium/38561.jpg"},"name":"乔什·加德","id":"1305235"},{"alt":"https://movie.douban.com/celebrity/1013797/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/28522.jpg","large":"http://img3.douban.com/img/celebrity/large/28522.jpg","medium":"http://img3.douban.com/img/celebrity/medium/28522.jpg"},"name":"丹尼·麦克布耐德","id":"1013797"}]
     * collect_count : 20935
     * original_title : The Angry Birds Movie
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1357709/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"费格尔·雷利","id":"1357709"},{"alt":"https://movie.douban.com/celebrity/1288264/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1437105433.0.jpg","large":"http://img3.douban.com/img/celebrity/large/1437105433.0.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1437105433.0.jpg"},"name":"克雷·卡提斯","id":"1288264"}]
     * year : 2016
     * images : {"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2352310242.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2352310242.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2352310242.jpg"}
     * alt : https://movie.douban.com/subject/6873736/
     * id : 6873736
     */

    private String title;
    private int collect_count;
    private String original_title;
    private String subtype;
    private String year;
    /**
     * small : http://img3.douban.com/view/movie_poster_cover/ipst/public/p2352310242.jpg
     * large : http://img3.douban.com/view/movie_poster_cover/lpst/public/p2352310242.jpg
     * medium : http://img3.douban.com/view/movie_poster_cover/spst/public/p2352310242.jpg
     */

    private Images images;
    private String alt;
    private String id;
    private List<String> genres;
    /**
     * alt : https://movie.douban.com/celebrity/1049521/
     * avatars : {"small":"http://img3.doubanio.com/img/celebrity/small/33797.jpg","large":"http://img3.doubanio.com/img/celebrity/large/33797.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/33797.jpg"}
     * name : 杰森·苏戴奇斯
     * id : 1049521
     */

    private List<Cast> casts;
    /**
     * alt : https://movie.douban.com/celebrity/1357709/
     * avatars : {"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"}
     * name : 费格尔·雷利
     * id : 1357709
     */

    private List<Director> directors;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
