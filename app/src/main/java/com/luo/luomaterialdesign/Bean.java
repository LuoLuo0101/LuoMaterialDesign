package com.luo.luomaterialdesign;

/**
 * Bean by luo.
 *
 * Created by Luo on 2017/4/30 0030.
 */
public class Bean {
    private String title;
    private Class clazz;

    private Bean() {
    }

    public Bean(String title, Class clazz) {
        this.title = title;
        this.clazz = clazz;
    }

    public String getTitle() {
        return title;
    }

    public Class getClazz() {
        return clazz;
    }

}
