package org.cperez.conversor.models;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {


    public static void ejecutarMenu(){
        Scanner sc = new Scanner(System.in);
        String url;

        System.out.println("#################################");
        System.out.println("""
                    1 -> Dólar americano (USD)
                    2 -> Dólar canadiense (CAD)
                    3 -> Peso chileno (CLP)
                    4 -> Peso argentino (ARS)
                    5 -> Real brasileño (BRL)
                    6 -> Peso colombiano (COP)
                    7 -> Euro (EUR)
                    8 -> Sol Peruano (PEN)
                    9 -> Peso mexicano (MXN)
                    10 -> Libra esterlina (GBP)
                    
                """);
        
        try {
            System.out.println("Elija la divisa de origen: ");
        int inputOrigen = sc.nextInt();
        System.out.println("Elija la divisa de destino: ");
        int inputDestino = sc.nextInt();
        System.out.println("Ahora indica la cantidad que deseas convertir: ");

        double cantidadOrigen = sc.nextDouble();

        String[] divisasAConvertir = Divisa.buscarDivisa(inputOrigen, inputDestino);
        url = String.format("https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/%s/%s/%.2f",
         divisasAConvertir[0], divisasAConvertir[1], cantidadOrigen);
        System.out.println(url);
        sc.close();
        } catch (InputMismatchException e) {
            // TODO: handle exception
            System.out.println("ARgumento malo" + e);
        }
        
    }
    
}
