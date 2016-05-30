package com.winter.github.douban.main.model.bean;

import java.util.List;

/**
 * Created by Winter on 2016/5/27.
 * Description 正在热映
 * email:huang.wqing@qq.com
 */
public class OnlineMovie {
    private int start;
    private int count;
    private int total;
    private String title;
    private List<MovieSubject> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<MovieSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<MovieSubject> subjects) {
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
