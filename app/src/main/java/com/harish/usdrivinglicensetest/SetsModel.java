package com.harish.usdrivinglicensetest;

public class SetsModel {
    private String name;
    private String url;
    private int set_no;
    private String explanation;

    public SetsModel() {
        //For firebase
    }

    public int getSet_no() {
        return set_no;
    }

    public void setSet_no(int set_no) {
        this.set_no = set_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
