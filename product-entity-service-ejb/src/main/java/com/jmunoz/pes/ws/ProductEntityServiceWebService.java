/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmunoz.pes.ws;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author jmunoz
 */
@WebService(serviceName = "ProductEntityService", portName = "ProductPort", endpointInterface = "com.jmunoz.inventory.schema.productentityservice.IProduct", targetNamespace = "http://jmunoz.com/inventory/schema/productEntityService", wsdlLocation = "META-INF/wsdl/ProductEntityService.wsdl")
@Stateless
public class ProductEntityServiceWebService {

    public com.jmunoz.inventory.schema.producttype.CreateProductResponseType createProduct(com.jmunoz.inventory.schema.producttype.CreateProductRequestType parameters) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.jmunoz.inventory.schema.producttype.UpdateProductResponseType updateProduct(com.jmunoz.inventory.schema.producttype.UpdateProductRequestType parameters) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.jmunoz.inventory.schema.producttype.GetProductResponseType getProduct(com.jmunoz.inventory.schema.producttype.GetProductRequestType parameters) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.jmunoz.inventory.schema.producttype.DeleteProductResponseType deleteProduct(com.jmunoz.inventory.schema.producttype.DeleteProductRequestType parameters) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
