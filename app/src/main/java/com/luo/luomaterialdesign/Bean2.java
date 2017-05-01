package com.luo.luomaterialdesign;

import android.support.annotation.IdRes;

/**
 * Created by Administrator on 2017/5/1 0001.
 */

public class Bean2 {
    private String title;
    @IdRes
    private int resId;

    public Bean2(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
