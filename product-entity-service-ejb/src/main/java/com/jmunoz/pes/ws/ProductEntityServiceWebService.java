/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmunoz.pes.ws;

import com.jmunoz.inventory.schema.producttype.CreateProductRequestType;
import com.jmunoz.inventory.schema.producttype.CreateProductResponseType;
import com.jmunoz.inventory.schema.producttype.DeleteProductRequestType;
import com.jmunoz.inventory.schema.producttype.DeleteProductResponseType;
import com.jmunoz.inventory.schema.producttype.GetProductRequestType;
import com.jmunoz.inventory.schema.producttype.GetProductResponseType;
import com.jmunoz.inventory.schema.producttype.UpdateProductRequestType;
import com.jmunoz.inventory.schema.producttype.UpdateProductResponseType;
import com.jmunoz.pes.ejb.persistence.dao.IProductDAO;
import com.jmunoz.pes.ejb.persistence.dao.MockProductDAO;
import com.jmunoz.pes.ejb.persistence.util.ProductResponseGenerator;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author jmunoz
 */
@WebService(serviceName = "ProductEntityService", portName = "ProductPort", endpointInterface = "com.jmunoz.inventory.schema.productentityservice.IProduct", targetNamespace = "http://jmunoz.com/inventory/schema/productEntityService", wsdlLocation = "META-INF/wsdl/ProductEntityService.wsdl")
@Stateless
public class ProductEntityServiceWebService 
{
    public CreateProductResponseType createProduct(CreateProductRequestType parameters)
    {
        CreateProductResponseType response = new CreateProductResponseType();
        String status = new MockProductDAO().createProduct(
            ProductResponseGenerator.productTypeToProduct(parameters.getProduct()));
        response.setStatus(status);
        
        return response;
    }

    public UpdateProductResponseType updateProduct(UpdateProductRequestType parameters)
    {
        UpdateProductResponseType response = new UpdateProductResponseType();
        String status = new MockProductDAO().updateProduct(
            ProductResponseGenerator.productTypeToProduct(parameters.getProduct()));
        response.setStatus(status);
        
        return response;
    }

    public GetProductResponseType getProduct(GetProductRequestType parameters)
    {
        String code = parameters.getCode();
        IProductDAO productDAO = new MockProductDAO();

        return 
            ProductResponseGenerator
                .getResponseFromProduct(productDAO.getProduct(code));
    }

    public DeleteProductResponseType deleteProduct(DeleteProductRequestType parameters)
    {
        DeleteProductResponseType response = new DeleteProductResponseType();
        String status = new MockProductDAO().deleteProduct(parameters.getCode());
        response.setStatus(status);
        
        return response;
    }
    
}
