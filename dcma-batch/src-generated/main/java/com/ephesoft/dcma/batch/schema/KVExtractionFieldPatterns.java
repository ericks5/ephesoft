//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.05 at 06:59:16 PM ICT 
//


package com.ephesoft.dcma.batch.schema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="KVExtractionFieldPattern" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Distance" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="FetchValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="KeyPattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Length" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                   &lt;element name="NoOfWords" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="ValuePattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="XOffset" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="YOffset" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "kvExtractionFieldPattern"
})
@XmlRootElement(name = "KVExtractionFieldPatterns")
public class KVExtractionFieldPatterns
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "KVExtractionFieldPattern")
    protected List<KVExtractionFieldPatterns.KVExtractionFieldPattern> kvExtractionFieldPattern;

    /**
     * Gets the value of the kvExtractionFieldPattern property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kvExtractionFieldPattern property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKVExtractionFieldPattern().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KVExtractionFieldPatterns.KVExtractionFieldPattern }
     * 
     * 
     */
    public List<KVExtractionFieldPatterns.KVExtractionFieldPattern> getKVExtractionFieldPattern() {
        if (kvExtractionFieldPattern == null) {
            kvExtractionFieldPattern = new ArrayList<KVExtractionFieldPatterns.KVExtractionFieldPattern>();
        }
        return this.kvExtractionFieldPattern;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Distance" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="FetchValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="KeyPattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Length" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *         &lt;element name="NoOfWords" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="ValuePattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Width" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="XOffset" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="YOffset" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "distance",
        "fetchValue",
        "keyPattern",
        "length",
        "location",
        "weight",
        "noOfWords",
        "valuePattern",
        "width",
        "xOffset",
        "yOffset"
    })
    public static class KVExtractionFieldPattern
        implements Serializable
    {

        private final static long serialVersionUID = 100L;
        @XmlElement(name = "Distance", required = true)
        protected String distance;
        @XmlElement(name = "FetchValue", required = true)
        protected String fetchValue;
        @XmlElement(name = "KeyPattern", required = true)
        protected String keyPattern;
        @XmlElement(name = "Length")
        protected int length;
        @XmlElement(name = "Location", required = true)
        protected String location;
        @XmlElement(name = "Weight", defaultValue = "1")
        protected float weight;
        @XmlElement(name = "NoOfWords")
        protected int noOfWords;
        @XmlElement(name = "ValuePattern", required = true)
        protected String valuePattern;
        @XmlElement(name = "Width")
        protected int width;
        @XmlElement(name = "XOffset")
        protected int xOffset;
        @XmlElement(name = "YOffset")
        protected int yOffset;

        /**
         * Gets the value of the distance property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDistance() {
            return distance;
        }

        /**
         * Sets the value of the distance property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDistance(String value) {
            this.distance = value;
        }

        /**
         * Gets the value of the fetchValue property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFetchValue() {
            return fetchValue;
        }

        /**
         * Sets the value of the fetchValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFetchValue(String value) {
            this.fetchValue = value;
        }

        /**
         * Gets the value of the keyPattern property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKeyPattern() {
            return keyPattern;
        }

        /**
         * Sets the value of the keyPattern property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKeyPattern(String value) {
            this.keyPattern = value;
        }

        /**
         * Gets the value of the length property.
         * 
         */
        public int getLength() {
            return length;
        }

        /**
         * Sets the value of the length property.
         * 
         */
        public void setLength(int value) {
            this.length = value;
        }

        /**
         * Gets the value of the location property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocation() {
            return location;
        }

        /**
         * Sets the value of the location property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocation(String value) {
            this.location = value;
        }

        /**
         * Gets the value of the weight property.
         * 
         */
        public float getWeight() {
            return weight;
        }

        /**
         * Sets the value of the weight property.
         * 
         */
        public void setWeight(float value) {
            this.weight = value;
        }

        /**
         * Gets the value of the noOfWords property.
         * 
         */
        public int getNoOfWords() {
            return noOfWords;
        }

        /**
         * Sets the value of the noOfWords property.
         * 
         */
        public void setNoOfWords(int value) {
            this.noOfWords = value;
        }

        /**
         * Gets the value of the valuePattern property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValuePattern() {
            return valuePattern;
        }

        /**
         * Sets the value of the valuePattern property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValuePattern(String value) {
            this.valuePattern = value;
        }

        /**
         * Gets the value of the width property.
         * 
         */
        public int getWidth() {
            return width;
        }

        /**
         * Sets the value of the width property.
         * 
         */
        public void setWidth(int value) {
            this.width = value;
        }

        /**
         * Gets the value of the xOffset property.
         * 
         */
        public int getXOffset() {
            return xOffset;
        }

        /**
         * Sets the value of the xOffset property.
         * 
         */
        public void setXOffset(int value) {
            this.xOffset = value;
        }

        /**
         * Gets the value of the yOffset property.
         * 
         */
        public int getYOffset() {
            return yOffset;
        }

        /**
         * Sets the value of the yOffset property.
         * 
         */
        public void setYOffset(int value) {
            this.yOffset = value;
        }

    }

}
