/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmunoz.pes.ejb.persistence.dao;

import static com.jmunoz.pes.ejb.persistence.util.ProductResponseGenerator.asDate;

import com.jmunoz.pes.ejb.persistence.entity.Product;
import java.time.LocalDate;
import java.time.Month;

/**
 * Mock implementation for {@link IProductDAO} which will always retrieve a mock
 * object with the given code and test data. For the create, update and delete
 * operation it'll always return {@link IProductDAO#SUCCESFUL_OPERATION}.
 *
 * @author jmunoz
 */
public class MockProductDAO implements IProductDAO
{

    @Override
    public Product getProduct(String code)
    {
        LocalDate fabricationDate = LocalDate.of(2016, Month.MARCH, 21);
        Product mockProduct = new Product();
        mockProduct.setCode(code);
        mockProduct.setName("Eraseble Marker 424");
        mockProduct.setDescription("Black marker for use on white boards");
        mockProduct.setFabricationDate(asDate(fabricationDate));
        mockProduct.setExpirationDate(asDate(fabricationDate.plusYears(2)));
        mockProduct.setLotNumber(1);

        return mockProduct;
    }

    @Override
    public String createProduct(Product product)
    {
        return IProductDAO.SUCCESFUL_OPERATION;
    }

    @Override
    public String updateProduct(Product product)
    {
        return IProductDAO.SUCCESFUL_OPERATION;
    }

    @Override
    public String deleteProduct(String code)
    {
        return IProductDAO.SUCCESFUL_OPERATION;
    }
}
