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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for row complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="row">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RowCoordinates" type="{}coordinates"/>
 *         &lt;element name="MannualExtraction" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isRuleValid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="RuleViolated" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Columns">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Column" type="{}column" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "row", propOrder = {
    "rowCoordinates",
    "mannualExtraction",
    "isRuleValid",
    "ruleViolated",
    "columns"
})
public class Row
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "RowCoordinates", required = true)
    protected Coordinates rowCoordinates;
    @XmlElement(name = "MannualExtraction")
    protected boolean mannualExtraction;
    @XmlElement(defaultValue = "true")
    protected boolean isRuleValid;
    @XmlElement(name = "RuleViolated", required = true)
    protected String ruleViolated;
    @XmlElement(name = "Columns", required = true)
    protected Row.Columns columns;

    /**
     * Gets the value of the rowCoordinates property.
     * 
     * @return
     *     possible object is
     *     {@link Coordinates }
     *     
     */
    public Coordinates getRowCoordinates() {
        return rowCoordinates;
    }

    /**
     * Sets the value of the rowCoordinates property.
     * 
     * @param value
     *     allowed object is
     *     {@link Coordinates }
     *     
     */
    public void setRowCoordinates(Coordinates value) {
        this.rowCoordinates = value;
    }

    /**
     * Gets the value of the mannualExtraction property.
     * 
     */
    public boolean isMannualExtraction() {
        return mannualExtraction;
    }

    /**
     * Sets the value of the mannualExtraction property.
     * 
     */
    public void setMannualExtraction(boolean value) {
        this.mannualExtraction = value;
    }

    /**
     * Gets the value of the isRuleValid property.
     * 
     */
    public boolean isIsRuleValid() {
        return isRuleValid;
    }

    /**
     * Sets the value of the isRuleValid property.
     * 
     */
    public void setIsRuleValid(boolean value) {
        this.isRuleValid = value;
    }

    /**
     * Gets the value of the ruleViolated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuleViolated() {
        return ruleViolated;
    }

    /**
     * Sets the value of the ruleViolated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuleViolated(String value) {
        this.ruleViolated = value;
    }

    /**
     * Gets the value of the columns property.
     * 
     * @return
     *     possible object is
     *     {@link Row.Columns }
     *     
     */
    public Row.Columns getColumns() {
        return columns;
    }

    /**
     * Sets the value of the columns property.
     * 
     * @param value
     *     allowed object is
     *     {@link Row.Columns }
     *     
     */
    public void setColumns(Row.Columns value) {
        this.columns = value;
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
     *         &lt;element name="Column" type="{}column" maxOccurs="unbounded" minOccurs="0"/>
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
        "column"
    })
    public static class Columns
        implements Serializable
    {

        private final static long serialVersionUID = 100L;
        @XmlElement(name = "Column")
        protected List<Column> column;

        /**
         * Gets the value of the column property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the column property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getColumn().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Column }
         * 
         * 
         */
        public List<Column> getColumn() {
            if (column == null) {
                column = new ArrayList<Column>();
            }
            return this.column;
        }

    }

}