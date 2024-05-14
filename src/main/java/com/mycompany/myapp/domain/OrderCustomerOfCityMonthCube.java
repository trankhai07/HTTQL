package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties(value = {"new"})
@Entity
@Table(name = "OrderCustomerOfCityMonthCube")
@IdClass(OrderCustomerOfCityMonthCube.class)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class OrderCustomerOfCityMonthCube implements Serializable {

    @Id
    @Column(name = "CityKey")
    private String cityKey;

    @Column(name = "CityName")
    private String cityName;
    @Id
    @Column(name = "Month")
    private Integer month;
    @Id
    @Column(name = "Year")
    private Integer year;
    @Column(name = "State")
    private String state;

    @Column(name = "OrderedQuantity")
    private Integer orderedQuantity;

    @Column(name = "OrderedCost")
    private Integer orderedCost;

    @Column(name = "Profit")
    private Integer profit;


    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Integer getMonth() {
        return month;
    }

    public String getCityKey() {
        return cityKey;
    }

    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getCityName() {
        return this.cityName;
    }

    public OrderCustomerOfCityMonthCube cityName(String cityName) {
        this.setCityName(cityName);
        return this;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getOrderedQuantity() {
        return this.orderedQuantity;
    }

    public OrderCustomerOfCityMonthCube orderedQuantity(Integer orderedQuantity) {
        this.setOrderedQuantity(orderedQuantity);
        return this;
    }

    public void setOrderedQuantity(Integer orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public Integer getOrderedCost() {
        return this.orderedCost;
    }

    public OrderCustomerOfCityMonthCube orderedCost(Integer orderedCost) {
        this.setOrderedCost(orderedCost);
        return this;
    }

    public void setOrderedCost(Integer orderedCost) {
        this.orderedCost = orderedCost;
    }

    public Integer getProfit() {
        return this.profit;
    }

    public OrderCustomerOfCityMonthCube profit(Integer profit) {
        this.setProfit(profit);
        return this;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }



    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here


    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OrderCustomerOfCityMonthCube{" +
            "cityName=" + getCityName() +
            ", month=" + getMonth() +
            ", year=" + getYear() +
            ", state=" + getState() +
            ", cityKey=" + getCityKey() +
            ", orderedQuantity=" + getOrderedQuantity() +
            ", orderedCost=" + getOrderedCost() +
            ", profit=" + getProfit() +
            "}";
    }
}
