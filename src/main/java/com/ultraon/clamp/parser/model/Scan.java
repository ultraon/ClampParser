package com.ultraon.clamp.parser.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * Created by vitaliypopov on 10.11.14.
 */
@Root(strict = false)
public class Scan {
    @Attribute
    private String type = "";
    @Element
    private String absorbances = "";
    @Element
    private String wavelengths = "";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAbsorbances() {
        return absorbances;
    }

    public void setAbsorbances(String absorbances) {
        this.absorbances = absorbances;
    }

    public String getWavelengths() {
        return wavelengths;
    }

    public void setWavelengths(String wavelengths) {
        this.wavelengths = wavelengths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scan)) return false;

        Scan scan = (Scan) o;

        if (absorbances != null ? !absorbances.equals(scan.absorbances) : scan.absorbances != null) return false;
        if (type != null ? !type.equals(scan.type) : scan.type != null) return false;
        if (wavelengths != null ? !wavelengths.equals(scan.wavelengths) : scan.wavelengths != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (absorbances != null ? absorbances.hashCode() : 0);
        result = 31 * result + (wavelengths != null ? wavelengths.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Scan{" +
                "type='" + type + '\'' +
                ", absorbances='" + absorbances + '\'' +
                ", wavelengths='" + wavelengths + '\'' +
                '}';
    }
}
