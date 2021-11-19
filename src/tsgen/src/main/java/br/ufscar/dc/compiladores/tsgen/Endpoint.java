package br.ufscar.dc.compiladores.tsgen;

import java.util.ArrayList;
import java.util.List;

public class Endpoint {
    List<Route> routes;

    Endpoint() {
        this.routes = new ArrayList<>();
    }

    List<Route> routes() {
        return this.routes;
    }

    void add(Route.Method method, String uri) {
        Route route = new Route(method, uri);
        this.routes.add(route);
    }

    void add(Route.Method method, String uri, String id) {
        Route route = new Route(method, uri, id);
        this.routes.add(route);
    }

    boolean contains(Route.Method method, String uri) {
        for (var route : this.routes) {
            if (route.uri.equals(uri) && route.method == method) {
                return true;
            }
        }
        return false;
    }
}
