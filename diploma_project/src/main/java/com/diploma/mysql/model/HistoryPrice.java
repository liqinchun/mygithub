package com.diploma.mysql.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "history_price", schema = "compareprice", catalog = "")
public class HistoryPrice {
    private String priceId;
    private double price;
    private Timestamp crateTime;

    @Id
    @Column(name = "priceId")
    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "crateTime")
    public Timestamp getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Timestamp crateTime) {
        this.crateTime = crateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoryPrice that = (HistoryPrice) o;

        if (Double.compare(that.price, price) != 0) return false;
        if (priceId != null ? !priceId.equals(that.priceId) : that.priceId != null) return false;
        if (crateTime != null ? !crateTime.equals(that.crateTime) : that.crateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = priceId != null ? priceId.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (crateTime != null ? crateTime.hashCode() : 0);
        return result;
    }
}
