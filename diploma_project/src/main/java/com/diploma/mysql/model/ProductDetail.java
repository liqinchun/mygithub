package com.diploma.mysql.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "product_detail", schema = "compareprice", catalog = "")
public class ProductDetail {
    private String productId;
    private String catagoryId;
    private String productName;
    private String url;
    private String imageurl;
    private String productType;
    private String orignPlace;
    private Date createTime;
    private String descripton;

    @Id
    @Column(name = "productId")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "catagoryId")
    public String getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(String catagoryId) {
        this.catagoryId = catagoryId;
    }

    @Basic
    @Column(name = "productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "imageurl")
    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    @Basic
    @Column(name = "productType")
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "orignPlace")
    public String getOrignPlace() {
        return orignPlace;
    }

    public void setOrignPlace(String orignPlace) {
        this.orignPlace = orignPlace;
    }

    @Basic
    @Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "descripton")
    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductDetail that = (ProductDetail) o;

        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (catagoryId != null ? !catagoryId.equals(that.catagoryId) : that.catagoryId != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (imageurl != null ? !imageurl.equals(that.imageurl) : that.imageurl != null) return false;
        if (productType != null ? !productType.equals(that.productType) : that.productType != null) return false;
        if (orignPlace != null ? !orignPlace.equals(that.orignPlace) : that.orignPlace != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (descripton != null ? !descripton.equals(that.descripton) : that.descripton != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (catagoryId != null ? catagoryId.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (imageurl != null ? imageurl.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (orignPlace != null ? orignPlace.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (descripton != null ? descripton.hashCode() : 0);
        return result;
    }
}
