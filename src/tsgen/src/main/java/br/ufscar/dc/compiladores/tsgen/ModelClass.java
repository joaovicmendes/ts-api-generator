package br.ufscar.dc.compiladores.tsgen;

import java.util.ArrayList;
import java.util.List;

public class ModelClass {
    List<Field> fields;

    ModelClass() {
        this.fields = new ArrayList<>();
    }

    List<Field> fields() {
        return this.fields;
    }

    void add(Type type, String id) {
        Field newField = new Field(type, id);
        fields.add(newField);
    }

    boolean contains(String id) {
        for (var field : this.fields) {
            if (field.id.equals(id)) {
                return true;
            }
        }
        return false;
    }
}
