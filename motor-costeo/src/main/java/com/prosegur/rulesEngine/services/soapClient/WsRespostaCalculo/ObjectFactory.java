
package com.prosegur.rulesEngine.services.soapClient.WsRespostaCalculo;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.prosegur.rulesEngine.services.soapClient.WsRespostaCalculo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.prosegur.rulesEngine.services.soapClient.WsRespostaCalculo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ComunicaPeticionFinalizada }
     * 
     */
    public ComunicaPeticionFinalizada createComunicaPeticionFinalizada() {
        return new ComunicaPeticionFinalizada();
    }

    /**
     * Create an instance of {@link PeticionFinalizadaRequest }
     * 
     */
    public PeticionFinalizadaRequest createPeticionFinalizadaRequest() {
        return new PeticionFinalizadaRequest();
    }

    /**
     * Create an instance of {@link ComunicaPeticionFinalizadaResponse }
     * 
     */
    public ComunicaPeticionFinalizadaResponse createComunicaPeticionFinalizadaResponse() {
        return new ComunicaPeticionFinalizadaResponse();
    }

    /**
     * Create an instance of {@link PeticionFinalizadaResponse }
     * 
     */
    public PeticionFinalizadaResponse createPeticionFinalizadaResponse() {
        return new PeticionFinalizadaResponse();
    }

    /**
     * Create an instance of {@link EstadoRetorno }
     * 
     */
    public EstadoRetorno createEstadoRetorno() {
        return new EstadoRetorno();
    }

}
