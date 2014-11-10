package com.ultraon.clamp.parser.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by vitaliypopov on 10.11.14.
 */
@Root(strict = false)
public class Reading {
    @Attribute
    private String id = "";
    @Attribute
    private Date created;
    @Attribute
    private boolean basedOnPreviousResult;
    @Text
    private String productType = "";
    @Text
    private String spectrometer = "";
    @ElementList
    private List<Scan> scans = Collections.emptyList();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isBasedOnPreviousResult() {
        return basedOnPreviousResult;
    }

    public void setBasedOnPreviousResult(boolean basedOnPreviousResult) {
        this.basedOnPreviousResult = basedOnPreviousResult;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSpectrometer() {
        return spectrometer;
    }

    public void setSpectrometer(String spectrometer) {
        this.spectrometer = spectrometer;
    }

    public List<Scan> getScans() {
        return scans;
    }

    public void setScans(List<Scan> scans) {
        this.scans = scans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reading)) return false;

        Reading reading = (Reading) o;

        if (basedOnPreviousResult != reading.basedOnPreviousResult) return false;
        if (created != null ? !created.equals(reading.created) : reading.created != null) return false;
        if (id != null ? !id.equals(reading.id) : reading.id != null) return false;
        if (productType != null ? !productType.equals(reading.productType) : reading.productType != null) return false;
        if (scans != null ? !scans.equals(reading.scans) : reading.scans != null) return false;
        if (spectrometer != null ? !spectrometer.equals(reading.spectrometer) : reading.spectrometer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (basedOnPreviousResult ? 1 : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (spectrometer != null ? spectrometer.hashCode() : 0);
        result = 31 * result + (scans != null ? scans.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", basedOnPreviousResult=" + basedOnPreviousResult +
                ", productType='" + productType + '\'' +
                ", spectrometer='" + spectrometer + '\'' +
                ", scans=" + scans +
                '}';
    }
}
