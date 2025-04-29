package org.cperez.conversor.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.cperez.conversor.ConfigLoader;

public class ClienteHttp {

    String API_KEY;
    String url;
    HttpClient cliente;
    HttpRequest peticion;

    public ClienteHttp(String origen, String destino, double cantidad) {

        // obtencion de API_KEY desde archivo de configuración de variables de entorno
        API_KEY = ConfigLoader.get("API_KEY");

        url = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%.2f",
                API_KEY, origen, destino, cantidad);
        this.cliente = HttpClient.newHttpClient();
        this.peticion = HttpRequest.newBuilder().uri(URI.create(this.url)).build();

    }

    public String getRequest() throws IOException, InterruptedException {
        HttpResponse<String> respuesta = this.cliente.send(this.peticion,
                HttpResponse.BodyHandlers.ofString());

        return respuesta.body();

    }

}
