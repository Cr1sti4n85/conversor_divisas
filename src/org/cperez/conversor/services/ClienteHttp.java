package org.cperez.conversor.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {

    String API_KEY = "4580ef046f9b0738fda5a49e";
    String url;
    HttpClient cliente;
    HttpRequest peticion;

    public ClienteHttp(String origen, String destino, double cantidad){
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
