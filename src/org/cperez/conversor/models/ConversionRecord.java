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

    public void mostrarResultado(double base) {
        System.out.println("//////////////////////////////////////////////////////////////////");
        System.out.println("""

                La conversión de %s %.2f hacia %s, usando la conversión actual de %.4f, es de %s %.2f

                """.formatted(
                base_code(),
                base,
                target_code(),
                conversion_rate(),
                target_code(),
                conversion_result()));
        System.out.println("//////////////////////////////////////////////////////////////////\n");

    }

}
