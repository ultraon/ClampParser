package com.ultraon.clamp.parser.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * Created by vitaliypopov on 10.11.14.
 */
@Root(strict = false)
public class Scan {
    @Attribute
    private String type = "";
    @Text
    private String absorbances = "";
    @Text
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
}
