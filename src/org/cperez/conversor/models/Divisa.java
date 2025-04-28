package org.cperez.conversor.models;

public enum Divisa {

    USD,
    CAD,
    CLP,
    ARS,
    BRL,
    COP,
    EUR,
    PEN,
    MXN,
    GBP;

    public static String[] buscarDivisa(int inputOrigen, int inputDestino){
            String[] parDeDivisas = new String[2];

        
        for (Divisa divisa: Divisa.values()){
            if(inputOrigen == divisa.ordinal() + 1){
                parDeDivisas[0] = divisa.name();
            }
            if (inputDestino == divisa.ordinal() + 1){
                parDeDivisas[1] = divisa.name();
            }

        }
        return parDeDivisas;
    }
    
}
