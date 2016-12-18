package com.jmunoz.pes.ejb.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class to represent a product.
 *
 * @author jmunoz
 */
@Entity
@Table(name = "product")
@NamedQueries({
    @NamedQuery(name = "Product.getByCode", query = "SELECT * FROM product WHERE code = :request")
})
public class Product implements Serializable
{
    public static final String GET_BY_CODE_NQ = "Product.getByCode";

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "code")
    private String code;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "fabricationDate")
    private Date fabricationDate;
    
    @Column(name = "expirationDate")
    private Date expirationDate;
    
    @Column(name = "lotNumber")
    private Integer lotNumber;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFabricationDate() {
        return fabricationDate;
    }

    public void setFabricationDate(Date fabricationDate) {
        this.fabricationDate = fabricationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(Integer lotNumber) {
        this.lotNumber = lotNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the code fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "code=" + code + ", name=" + name + ", description=" + description + ", fabricationDate=" + fabricationDate + ", expirationDate=" + expirationDate + ", lotNumber=" + lotNumber + '}';
    }
}
