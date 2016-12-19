/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmunoz.pes.ejb.persistence.util;

import com.jmunoz.inventory.schema.producttype.GetProductResponseType;
import com.jmunoz.inventory.schema.producttype.ProductType;
import com.jmunoz.pes.ejb.persistence.entity.Product;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Utility class to perform conversion from response types to entity types and
 * vice versa.
 * 
 * @author jmunoz
 */
public class ProductResponseGenerator
{
    /**
     * Creates a {@link GetProductResponseType} with the information contained
     * in the given {@link Product} instance.
     *
     * @param product {@link Product} instance used to extract the response data
     *
     * @return A {@link GetProductResponseType}
     */
    public static GetProductResponseType getResponseFromProduct(Product product)
    {
        
        GetProductResponseType response = new GetProductResponseType();
        response.setProduct(productToProductType(product));

        return response;
    }
    
    /**
     * Converts the given {@link ProductType} to {@link Product}.
     *
     * @param productType {@link ProductType} instance used to extract the  data
     *
     * @return A {@link Product} containing the information of the given product
     *         type.
     * 
     *  @trhows NullPointerException if the given product type is null.
     */
    public static Product productTypeToProduct(ProductType productType)
    {
        Objects.requireNonNull(productType);
        Product product = new Product();
        product.setCode(productType.getCode());
        product.setName(productType.getName());
        product.setDescription(productType.getDescription());
        product.setFabricationDate(asDate(productType.getFabricationDate()));
        product.setExpirationDate(asDate(productType.getExpirationDate()));
        product.setLotNumber(productType.getLotNumber().intValue());
        
        return product;
    }

    /**
     * Converts the given {@link Product} to {@link ProductType}.
     *
     * @param product {@link Product} instance used to extract the data
     *
     * @return A {@link ProductType} containing the information of the given
     *         product.
     * 
     * @trhows NullPointerException if the given product is null.
     */
    public static ProductType productToProductType(Product product)
    {
        Objects.requireNonNull(product);
        ProductType productType = new ProductType();
        productType.setCode(product.getCode());
        productType.setName(product.getName());
        productType.setDescription(product.getDescription());
        productType.setLotNumber(BigInteger.valueOf(product.getLotNumber()));
        productType.setFabricationDate(
            asXMLGregorianCalendar(product.getFabricationDate()));
        productType.setFabricationDate(
            asXMLGregorianCalendar(product.getExpirationDate()));
        
        return productType;
    }
    
    /**
     * Creates a XML representation of the given date.
     *
     * @param date {@link Date} object to be represented as XML.
     *
     * @return a {@link XMLGregorianCalendar} representation of the given date.
     * 
     * @trhows NullPointerException if the given date is null.
     */
    public static XMLGregorianCalendar asXMLGregorianCalendar(Date date)
    {
        try
        {
            Objects.requireNonNull(date, "Date can not be null");
            DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(date.getTime());
            return dataTypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        }
        catch (DatatypeConfigurationException dce)
        {
            throw new IllegalStateException(
                "Exception while obtaining DatatypeFactory instance", dce);
        }
    }
    
    /**
     * Creates a {@link Date} object from the given {@link XMLGregorianCalendar}.
     *
     * @param xmlCal {@link XMLGregorianCalendar} to convert.
     *
     * @return A {@link Date} from the XML data.
     */
    public static Date asDate(XMLGregorianCalendar xmlCal)
    {
        LocalDate localDate =
            LocalDate.of(xmlCal.getYear(), xmlCal.getMonth(), xmlCal.getDay());
        
        return asDate(localDate);
    }
    
    /**
     * Converts the given {@link LocalDate} to {@link Date}.
     *
     * @param localDate {@link LocalDate} to convert.
     *
     * @return A {@link Date} from the given local date.
     */
    public static Date asDate(LocalDate localDate)
    {
        return Date.from(
            localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
}
