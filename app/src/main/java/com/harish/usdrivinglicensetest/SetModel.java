package com.harish.usdrivinglicensetest;

public class SetModel {
    private String name;
    private String url;
    private int sets;
    private int set_no;

    public SetModel() {
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

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public SetModel(String name, String url, int sets, int set_no) {
        this.name = name;
        this.url = url;
        this.sets = sets;
        this.set_no = set_no;
    }
}
