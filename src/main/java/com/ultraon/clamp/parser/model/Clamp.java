package com.ultraon.clamp.parser.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by vitaliypopov on 10.11.14.
 */
@Root(strict = false)
public class Clamp {
    @Attribute
    private String id = "";
    @Attribute
    private String name = "";
    @Attribute
    private Date created;
    @ElementList
    private List<Reading> readings = new ArrayList<Reading>();

    public List<Reading> getReadings() {
        return readings;
    }

    public void setReadings(List<Reading> readings) {
        this.readings = readings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clamp)) return false;

        Clamp clamp = (Clamp) o;

        if (created != null ? !created.equals(clamp.created) : clamp.created != null) return false;
        if (id != null ? !id.equals(clamp.id) : clamp.id != null) return false;
        if (name != null ? !name.equals(clamp.name) : clamp.name != null) return false;
        if (readings != null ? !readings.equals(clamp.readings) : clamp.readings != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (readings != null ? readings.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Clamp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", readings=" + readings +
                '}';
    }
}
