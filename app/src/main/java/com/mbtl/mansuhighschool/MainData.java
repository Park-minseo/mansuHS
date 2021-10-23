package com.mbtl.mansuhighschool;

import android.content.Context;

public class MainData {

    private String iv_profile;
    private String tv_name;
    private String tv_content;
    private String bon_moon;

    public MainData(String iv_profile, String tv_name, String tv_content , String bon_moon) {
        this.iv_profile = iv_profile;
        this.tv_name = tv_name;
        this.tv_content = tv_content;
        this.bon_moon = bon_moon;
    }

    public String getIv_profile() { return iv_profile; }

    public void setIv_profile(String iv_profile) { this.iv_profile = iv_profile; }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_content() {
        return tv_content;
    }

    public void setTv_content(String tv_content) {
        this.tv_content = tv_content;
    }


    public String getBon_moon() {
            return bon_moon;
    }

    public void setBon_moon(String bon_moon) {
        this.bon_moon = bon_moon;
    }
}
