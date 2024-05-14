package com.mycompany.myapp.domain.Statistical;

public class StatisticalOrder {
    private String nameCompany;
    private String nameStatistical;
    private String day;
    private String month;
    private String year;
    private long sumOrderedQuantity;
    private long sumOrderedCost;
    private long sumProfit;

    public long getSumOrderedQuantity() {
        return sumOrderedQuantity;
    }

    public void setSumOrderedQuantity(long sumOrderedQuantity) {
        this.sumOrderedQuantity = sumOrderedQuantity;
    }

    public long getSumOrderedCost() {
        return sumOrderedCost;
    }

    public void setSumOrderedCost(long sumOrderedCost) {
        this.sumOrderedCost = sumOrderedCost;
    }

    public long getSumProfit() {
        return sumProfit;
    }

    public void setSumProfit(long sumProfit) {
        this.sumProfit = sumProfit;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getNameStatistical() {
        return nameStatistical;
    }

    public void setNameStatistical(String nameStatistical) {
        this.nameStatistical = nameStatistical;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
