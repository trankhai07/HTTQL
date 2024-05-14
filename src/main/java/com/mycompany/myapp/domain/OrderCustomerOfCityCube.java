package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.springframework.data.domain.Persistable;

/**
 * A OrderCustomerOfCityCube.
 */
@JsonIgnoreProperties(value = { "new" })
@Entity
@Table(name = "OrderCustomerOfCityCube")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class OrderCustomerOfCityCube implements Serializable, Persistable<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CityName")
    private String cityName;

    @Column(name = "OfficeAddress")
    private String officeAddress;

    @Column(name = "OrderedQuantity")
    private Integer orderedQuantity;

    @Column(name = "OrderedCost")
    private Integer orderedCost;

    @Column(name = "Profit")
    private Integer profit;

    @Transient
    private boolean isPersisted;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getCityName() {
        return this.cityName;
    }

    public OrderCustomerOfCityCube cityName(String cityName) {
        this.setCityName(cityName);
        return this;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getOfficeAddress() {
        return this.officeAddress;
    }

    public OrderCustomerOfCityCube officeAddress(String officeAddress) {
        this.setOfficeAddress(officeAddress);
        return this;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public Integer getOrderedQuantity() {
        return this.orderedQuantity;
    }

    public OrderCustomerOfCityCube orderedQuantity(Integer orderedQuantity) {
        this.setOrderedQuantity(orderedQuantity);
        return this;
    }

    public void setOrderedQuantity(Integer orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public Integer getOrderedCost() {
        return this.orderedCost;
    }

    public OrderCustomerOfCityCube orderedCost(Integer orderedCost) {
        this.setOrderedCost(orderedCost);
        return this;
    }

    public void setOrderedCost(Integer orderedCost) {
        this.orderedCost = orderedCost;
    }

    public Integer getProfit() {
        return this.profit;
    }

    public OrderCustomerOfCityCube profit(Integer profit) {
        this.setProfit(profit);
        return this;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    @Override
    public String getId() {
        return this.cityName;
    }

    @Transient
    @Override
    public boolean isNew() {
        return !this.isPersisted;
    }

    public OrderCustomerOfCityCube setIsPersisted() {
        this.isPersisted = true;
        return this;
    }

    @PostLoad
    @PostPersist
    public void updateEntityState() {
        this.setIsPersisted();
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrderCustomerOfCityCube)) {
            return false;
        }
        return cityName != null && cityName.equals(((OrderCustomerOfCityCube) o).cityName);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OrderCustomerOfCityCube{" +
            "cityName=" + getCityName() +
            ", officeAddress='" + getOfficeAddress() + "'" +
            ", orderedQuantity=" + getOrderedQuantity() +
            ", orderedCost=" + getOrderedCost() +
            ", profit=" + getProfit() +
            "}";
    }
}
