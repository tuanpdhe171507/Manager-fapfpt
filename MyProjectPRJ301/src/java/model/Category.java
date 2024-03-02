/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author G5 5590
 */
public class Category {
    private int CategoryID;
    private String CategoryName;
    private String Type;
    private String QuestionType;
    private String GradingGuide;

    public Category() {
    }

    public Category(int CategoryID, String CategoryName, String Type, String QuestionType, String GradingGuide) {
        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
        this.Type = Type;
        this.QuestionType = QuestionType;
        this.GradingGuide = GradingGuide;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getQuestionType() {
        return QuestionType;
    }

    public void setQuestionType(String QuestionType) {
        this.QuestionType = QuestionType;
    }

    public String getGradingGuide() {
        return GradingGuide;
    }

    public void setGradingGuide(String GradingGuide) {
        this.GradingGuide = GradingGuide;
    }

    @Override
    public String toString() {
        return "Category{" + "CategoryID=" + CategoryID + ", CategoryName=" + CategoryName + ", Type=" + Type + ", QuestionType=" + QuestionType + ", GradingGuide=" + GradingGuide + '}';
    }

    
    
}
