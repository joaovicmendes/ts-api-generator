package br.ufscar.dc.compiladores.tsgen;

public class Field {
    Type type;
    String id;

    Field(Type type, String id) {
        this.type = type;
        this.id = id;
    }

    Type type() {
        return this.type;
    }

    String id() {
        return this.id;
    }
}
