package com.diploma.mysql.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    private String productId;
    private String producrName;
    private String productUrl;
    private double productPrice;
    private String productImgUrl;

    @Id
    @Column(name = "productId")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "producrName")
    public String getProducrName() {
        return producrName;
    }

    public void setProducrName(String producrName) {
        this.producrName = producrName;
    }

    @Basic
    @Column(name = "productUrl")
    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    @Basic
    @Column(name = "productPrice")
    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "productImgUrl")
    public String getProductImgUrl() {
        return productImgUrl;
    }

    public void setProductImgUrl(String productImgUrl) {
        this.productImgUrl = productImgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.productPrice, productPrice) != 0) return false;
        if (productId != null ? !productId.equals(product.productId) : product.productId != null) return false;
        if (producrName != null ? !producrName.equals(product.producrName) : product.producrName != null) return false;
        if (productUrl != null ? !productUrl.equals(product.productUrl) : product.productUrl != null) return false;
        if (productImgUrl != null ? !productImgUrl.equals(product.productImgUrl) : product.productImgUrl != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (producrName != null ? producrName.hashCode() : 0);
        result = 31 * result + (productUrl != null ? productUrl.hashCode() : 0);
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (productImgUrl != null ? productImgUrl.hashCode() : 0);
        return result;
    }
}
