/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmunoz.pes.ejb.persistence.dao;

import com.jmunoz.pes.ejb.persistence.entity.Product;
import javax.ejb.Local;

/**
 * Interface to expose the methods related to CRUD operations over Product
 * entity.
 *
 * @author jmunoz
 */
@Local
public interface IProductDAO
{
    public static String SUCCESFUL_OPERATION = "Success";

    /**
     * Retrieves the information of the product with the given code.
     *
     * @param code Code of the product to be retrieved.
     *
     * @return A {@link Product} instance containing the information of the
     *         product with the given code.
     */
    Product getProduct(String code);
    
    /**
     * Stores in the database the information contained on the given instance of
     * {@link Product}.
     * 
     * 
     * @param product {@link Product} instance containing the information to
     *        store.
     *
     * @return {@link #SUCCESFUL_OPERATION} if the operation is successful. If
     *         there's any error the error string will be returned.
     */
    String createProduct(Product product);
    
    /**
     * Updates the given product.
     *
     * @param product {@link Product} instance containing the information to
     *        update.
     * 
     * @return {@link #SUCCESFUL_OPERATION} if the operation is successful. If
     *         there's any error the error string will be returned.
     */
    String updateProduct(Product product);
    
    /**
     * Deletes the product with the given code.
     *
     * @param code Code of the product to delete.
     * 
     * @return {@link #SUCCESFUL_OPERATION} if the operation is successful. If
     *         there's any error the error string will be returned.
     */
    String deleteProduct(String code);
}
