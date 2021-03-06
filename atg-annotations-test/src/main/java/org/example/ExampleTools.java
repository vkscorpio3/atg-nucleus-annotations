package org.example;

import atg.nucleus.GenericService;
import com.github.sdianov.atgannotations.CollectionOperation;
import com.github.sdianov.atgannotations.MapValue;
import com.github.sdianov.atgannotations.NucleusComponent;
import com.github.sdianov.atgannotations.NucleusValue;

import java.util.List;
import java.util.Map;

@NucleusComponent()
class ExampleTools extends GenericService {

    String stringValue;

    List<String> listValue;

    Map<String, String> mapValue;

    Object refValue;


    public String getStringValue() {
        return stringValue;
    }

    @NucleusValue("1234")
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }


    public List<String> getListValue() {
        return listValue;
    }

    @NucleusValue(list = {"123", "456"})
    public void setListValue(List<String> listValue) {
        this.listValue = listValue;
    }

    public Map<String, String> getMapValue() {
        return mapValue;
    }

    @NucleusValue(map = {
            @MapValue(key ="a", value="b"),
            @MapValue(key = "c", value = "d")
    },
            operation = CollectionOperation.APPEND)
    public void setMapValue(Map<String, String> mapValue) {
        this.mapValue = mapValue;

    }

    public Object getRefValue() {
        return refValue;
    }

    @NucleusValue(propertyRef = "/Constants.null")
    public void setRefValue(Object refValue) {
        this.refValue = refValue;
    }
}
