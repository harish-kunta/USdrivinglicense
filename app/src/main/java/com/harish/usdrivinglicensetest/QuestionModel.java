package com.harish.usdrivinglicensetest;

public class QuestionModel {
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAns;
    private String img_url = "";
    private String explanation;
    public QuestionModel(String question, String optionA, String optionB, String optionC, String optionD, String correctAns, String img_url, String explanation, int setNo) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAns = correctAns;
        this.img_url = img_url;
        this.explanation = explanation;
        this.setNo = setNo;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    private int setNo;

    public QuestionModel() {
        //For Firebase
    }

    public String getQuestion() {
        return question.trim();
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA.trim();
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB.trim();
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC.trim();
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD.trim();
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCorrectAns() {
        return correctAns.trim();
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public int getSetNo() {
        return setNo;
    }

    public void setSetNo(int setNo) {
        this.setNo = setNo;
    }

    public String getimg_url() {
        return img_url.trim();
    }

    public void setimg_url(String img_url) {
        this.img_url = img_url;
    }


}
