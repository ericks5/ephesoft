//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.05 at 06:59:16 PM ICT 
//


package com.ephesoft.dcma.batch.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for batchStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="batchStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Locked"/>
 *     &lt;enumeration value="Ready"/>
 *     &lt;enumeration value="Running"/>
 *     &lt;enumeration value="ReadyForReview"/>
 *     &lt;enumeration value="Reviewed"/>
 *     &lt;enumeration value="ReadyForValidation"/>
 *     &lt;enumeration value="Validated"/>
 *     &lt;enumeration value="Transferred"/>
 *     &lt;enumeration value="Error"/>
 *     &lt;enumeration value="Finished"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "batchStatus", namespace = "http://www.ephesoft.com/batch/batchStatus")
@XmlEnum
public enum BatchStatus {

    @XmlEnumValue("Locked")
    LOCKED("Locked"),
    @XmlEnumValue("Ready")
    READY("Ready"),
    @XmlEnumValue("Running")
    RUNNING("Running"),
    @XmlEnumValue("ReadyForReview")
    READY_FOR_REVIEW("ReadyForReview"),
    @XmlEnumValue("Reviewed")
    REVIEWED("Reviewed"),
    @XmlEnumValue("ReadyForValidation")
    READY_FOR_VALIDATION("ReadyForValidation"),
    @XmlEnumValue("Validated")
    VALIDATED("Validated"),
    @XmlEnumValue("Transferred")
    TRANSFERRED("Transferred"),
    @XmlEnumValue("Error")
    ERROR("Error"),
    @XmlEnumValue("Finished")
    FINISHED("Finished");
    private final String value;

    BatchStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BatchStatus fromValue(String v) {
        for (BatchStatus c: BatchStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
