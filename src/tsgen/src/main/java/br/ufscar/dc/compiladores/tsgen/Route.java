package br.ufscar.dc.compiladores.tsgen;

public class Route {
    public enum Method {
        GET,
        POST,
        PUT,
        DELETE,
        Invalid,
    }

    Route(Method method, String uri) {
        this.method = method;
        this.uri = uri;
    }

    Route(Method method, String uri, String id) {
        this.method = method;
        this.uri = uri;
        this.id = id;
    }

    Method method;
    String uri;
    String id;
}
