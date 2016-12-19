/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmunoz.pes.rest;

import com.jmunoz.inventory.schema.producttype.ProductType;
import com.jmunoz.pes.ejb.persistence.dao.IProductDAO;
import com.jmunoz.pes.ejb.persistence.dao.MockProductDAO;
import com.jmunoz.pes.ejb.persistence.util.ProductResponseGenerator;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST interface for Product Entity Service
 *
 * @author jmunoz
 */
@Stateless
@Path("/PES")
@Produces({MediaType.APPLICATION_JSON})
public class ProductEntityServiceREST
{
    @GET
    @Path("/product/{code}")
    public ProductType getProduct(@PathParam("code") String code)
    {
        IProductDAO productDAO = new MockProductDAO();
        return ProductResponseGenerator
            .productToProductType(productDAO.getProduct(code));
    }
    
    @POST
    @Path("/product")
    public String createProduct(ProductType productType)
    {
        IProductDAO productDAO = new MockProductDAO();
        return productDAO.createProduct(
            ProductResponseGenerator.productTypeToProduct(productType));
    }
    
    @PUT
    @Path("/product")
    public String updateProduct(ProductType productType)
    {
        IProductDAO productDAO = new MockProductDAO();
        return productDAO.updateProduct(
            ProductResponseGenerator.productTypeToProduct(productType));
    }
    
    @DELETE
    @Path("/product/{code}")
    public String deleteProduct(@PathParam("code") String code)
    {
        IProductDAO productDAO = new MockProductDAO();
        return productDAO.deleteProduct(code);
    }
}
