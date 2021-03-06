# PRODUCT ENTITY SERVICE
Entity service to provide CRUD capabilities related to products. The ***Product*** entity has the following attributes:

![Product Entity Diagram](documentation/diagrams/Entity.png)

## SERVICES DEFINITIONS
This service implements two protocols to access the service capabilities: *SOAP* and *REST*.
In order to keep the services standardized, both of them receive and produce data in XML format.

### STANDARDIZATION
#### REST
The REST protocol used for CRUD operations at Entity level services must follow this specification:

OP | HTTP Method | Path | Request Body
---|-------------|------|-------------
C |POST | /entity | XML based on entity's XSD
R |GET | /entity/{id} | None
U |PUT | /entity | XML based on entity's XSD
D |DELETE | /entity/{id} | None

**WILDCARDS** <br />
During implementation, the wildcards in the above table should be replaced as follows:
 * **"entity"** should be replaced by the entity name in lowercase
 * **"id"** should be replaced by the name of the entity's identifier in lowercase

### IMPLEMENTATION
#### SOAP

The SOAP protocol for Product Entity Service follow this specification:<br />
**Design:**<br /> ![SOAP Diagram](documentation/diagrams/SOAP.png)<br/>
**Receives:** XML<br />
**Produces:** XML<br />
**Contract:** [product-entity-service-ejb/src/main/resources/META-INF/ProductEntityService.wsdl](product-entity-service-ejb/src/main/resources/META-INF/ProductEntityService.wsdl)<br />


#### REST
The REST protocol for Product Entity Service follow this specification:<br />
**Design:**<br /> ![REST Diagram](documentation/diagrams/REST.png) <br/>
**Receives:** JSON based on [Product XSD](product-entity-service-ejb/src/main/resources/META-INF/Product.xsd)<br/>
**Produces:** JSON<br />
**Contract:** <br />

OP | HTTP Method | Path | Request Body
---|-------------|------|-------------
C |POST | /product | JSON based on [Product XSD](product-entity-service-ejb/src/main/resources/META-INF/Product.xsd)
R |GET | /product/{id} | None
U |PUT | /product | JSON based on [Product XSD](product-entity-service-ejb/src/main/resources/META-INF/Product.xsd)
D |DELETE | /product/{id} | None

### TOOLS
* Maven
* Netbeans IDE 8.2
* GlassFish Server 4.1.1
* Jersey-bundle 1.19
