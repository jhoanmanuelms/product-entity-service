/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmunoz.pes.ejb.persistence.dao;

import static com.jmunoz.pes.ejb.persistence.dao.IProductDAO.SUCCESFUL_OPERATION;

import com.jmunoz.pes.ejb.persistence.entity.Product;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author jmunoz
 */
@Stateless
public class ProductDAO implements IProductDAO
{
    private static final String INVENTORY_DS_ID = "InventoryDS";

    private final EntityManagerFactory emfactory;
    private final EntityManager emanager;

    public ProductDAO()
    {
        emfactory = Persistence.createEntityManagerFactory(INVENTORY_DS_ID);
        emanager = emfactory.createEntityManager();
    }
 
    @Override
    public Product getProduct(String code)
    {
        Query query =
            emanager.createNamedQuery(Product.GET_BY_CODE_NQ, Product.class);
        return (Product)query.getSingleResult();
    }

    @Override
    public String createProduct(Product product)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String updateProduct(Product product)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteProduct(String code)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
