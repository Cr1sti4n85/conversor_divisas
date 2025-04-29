package org.cperez.conversor.models;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.cperez.conversor.services.ClienteHttp;
import org.cperez.conversor.services.ConvertidorJson;

public class Menu {

    public static void ejecutarMenu() {
        Scanner sc = new Scanner(System.in);
        String opcion = "1";

        while (opcion.equals("1")) {
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

                // input de datos requeridos
                System.out.println("Elija la divisa de origen: ");
                int inputOrigen = sc.nextInt();
                String divisaOrigen = Divisa.buscarDivisa(inputOrigen);
                System.out.println("Elija la divisa de destino: ");
                int inputDestino = sc.nextInt();
                String divisaDestino = Divisa.buscarDivisa(inputDestino);
                System.out.println("Ahora indica la cantidad que deseas convertir: ");
                double cantidadOrigen = sc.nextDouble();

                // peticion a api
                ClienteHttp clienteHttp = new ClienteHttp(divisaOrigen, divisaDestino, cantidadOrigen);
                String respuesta = clienteHttp.getRequest();

                // Convertir json a record
                ConversionRecord conversion = ConvertidorJson.convertirDeJson(respuesta);
                conversion.mostrarResultado();

            } catch (InputMismatchException e) {
                System.out.println("#################################\n");
                System.out.println("La opción ingresada no es válida");
                System.out.println("#################################\n");

            } catch (IOException e) {
                System.out.println("#################################\n");
                System.out.println(e.getMessage());
                System.out.println("#################################\n");

            } catch (InterruptedException e) {
                System.out.println("#################################\n");
                System.out.println(e.getMessage());
                System.out.println("#################################\n");

            } catch (Exception e) {
                System.out.println("#################################\n");
                System.out.println(e.getMessage());
                System.out.println("#################################\n");

            }

            System.out.print("""
                    ##############################################
                    REALIZAR NUEVA CONSULTA -> PRESIONA 1 Y ENTER

                    FINALIZAR PROGRAMA -> PRESIONA ENTER
                    ##############################################

                    """);

            sc.nextLine();
            opcion = sc.nextLine();

            if (!opcion.equals("1")) {
                sc.close();
            }

        }

    }

}
