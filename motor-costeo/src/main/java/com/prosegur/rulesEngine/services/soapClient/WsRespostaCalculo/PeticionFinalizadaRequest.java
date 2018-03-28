
package com.prosegur.rulesEngine.services.soapClient.WsRespostaCalculo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PeticionFinalizadaRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeticionFinalizadaRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdCosteo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DireccionFichero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Retorno" type="{http://tempuri.org/}EstadoRetorno" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeticionFinalizadaRequest", propOrder = {
    "idCosteo",
    "direccionFichero",
    "retorno"
})
public class PeticionFinalizadaRequest {

    @XmlElement(name = "IdCosteo")
    protected String idCosteo;
    @XmlElement(name = "DireccionFichero")
    protected String direccionFichero;
    @XmlElement(name = "Retorno")
    protected EstadoRetorno retorno;

    /**
     * Gets the value of the idCosteo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCosteo() {
        return idCosteo;
    }

    /**
     * Sets the value of the idCosteo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCosteo(String value) {
        this.idCosteo = value;
    }

    /**
     * Gets the value of the direccionFichero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionFichero() {
        return direccionFichero;
    }

    /**
     * Sets the value of the direccionFichero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionFichero(String value) {
        this.direccionFichero = value;
    }

    /**
     * Gets the value of the retorno property.
     * 
     * @return
     *     possible object is
     *     {@link EstadoRetorno }
     *     
     */
    public EstadoRetorno getRetorno() {
        return retorno;
    }

    /**
     * Sets the value of the retorno property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoRetorno }
     *     
     */
    public void setRetorno(EstadoRetorno value) {
        this.retorno = value;
    }

}
