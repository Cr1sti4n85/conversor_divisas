package org.cperez.conversor.models;

public record ConversionRecord(
        String base_code,
        String target_code,
        double conversion_rate,
        double conversion_result) {

    // private String origen;
    // private String destino;
    // private double tasaConversion;
    // private double resultadoConversion;

    public void mostrarResultado() {
        System.out.println("//////////////////////////////////////////////////////////////////");
        System.out.println("""
                La conversión de %s hacia %s, usando la converisión actual de %.4f, es de %.2f

                """.formatted(base_code(), target_code(), conversion_rate(), conversion_result()));
        System.out.println("//////////////////////////////////////////////////////////////////");

    }

}
