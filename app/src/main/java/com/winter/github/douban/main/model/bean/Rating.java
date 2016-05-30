package com.winter.github.douban.main.model.bean;

/**
 * Created by Winter on 2016/5/27.
 * Description 评分
 * email:huang.wqing@qq.com
 */
public class Rating {
    private int max;
    private double average;
    private String stars;
    private int min;


    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
