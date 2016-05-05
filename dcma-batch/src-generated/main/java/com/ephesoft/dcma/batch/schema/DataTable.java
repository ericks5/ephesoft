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
 * <p>Java class for dataTable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataTable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RuleName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HeaderRow" type="{}headerRow"/>
 *         &lt;element name="Rows">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Row" type="{}row" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "dataTable", propOrder = {
    "name",
    "ruleName",
    "headerRow",
    "rows"
})
public class DataTable
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "RuleName", required = true)
    protected String ruleName;
    @XmlElement(name = "HeaderRow", required = true)
    protected HeaderRow headerRow;
    @XmlElement(name = "Rows", required = true)
    protected DataTable.Rows rows;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the ruleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * Sets the value of the ruleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuleName(String value) {
        this.ruleName = value;
    }

    /**
     * Gets the value of the headerRow property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderRow }
     *     
     */
    public HeaderRow getHeaderRow() {
        return headerRow;
    }

    /**
     * Sets the value of the headerRow property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderRow }
     *     
     */
    public void setHeaderRow(HeaderRow value) {
        this.headerRow = value;
    }

    /**
     * Gets the value of the rows property.
     * 
     * @return
     *     possible object is
     *     {@link DataTable.Rows }
     *     
     */
    public DataTable.Rows getRows() {
        return rows;
    }

    /**
     * Sets the value of the rows property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataTable.Rows }
     *     
     */
    public void setRows(DataTable.Rows value) {
        this.rows = value;
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
     *         &lt;element name="Row" type="{}row" maxOccurs="unbounded" minOccurs="0"/>
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
        "row"
    })
    public static class Rows
        implements Serializable
    {

        private final static long serialVersionUID = 100L;
        @XmlElement(name = "Row")
        protected List<Row> row;

        /**
         * Gets the value of the row property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the row property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRow().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Row }
         * 
         * 
         */
        public List<Row> getRow() {
            if (row == null) {
                row = new ArrayList<Row>();
            }
            return this.row;
        }

    }

}
