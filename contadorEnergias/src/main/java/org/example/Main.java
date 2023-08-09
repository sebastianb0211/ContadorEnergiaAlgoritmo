package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        Random aleatorio=new Random();

        double tarifaKwh=0;
        String respuestaPerfil;
        int opcion=0;
        final String contrasena="admin123*";
        String contrasenaComparar;
        int I=1;
        double consumoPromedio=0;
        int contadorPicos=0;
        int factura=0;
        double facturaTotal;
        double totalPromedio=0;

        System.out.println("*** Bienvenido a EPM ***");
        System.out.print("Eres administrador: ");
        respuestaPerfil= teclado.next();

        if (respuestaPerfil.equalsIgnoreCase("si")){
            System.out.print("Perfecto por favor ingrese la contraseña: ");
            contrasenaComparar=teclado.next();

            if (contrasenaComparar.equals(contrasena)){
                System.out.println("Por favor digite el costo de los kwh");
                tarifaKwh= teclado.nextInt();
                System.out.println("Esta es su registro de consumo: ");
                while (I<=30){

                    int numeroAleatorio=aleatorio.nextInt(400)+1;
                    I++;
                    consumoPromedio+=numeroAleatorio;
                    factura+=numeroAleatorio;
                    System.out.println(numeroAleatorio);

                    if (numeroAleatorio>300){
                        contadorPicos++;
                    }
                }

            }else {
                System.out.println("por favor ingrese la contraseña bien ");
            }

        }else if (respuestaPerfil.equalsIgnoreCase("no")){
            System.out.println("Este es su promedio de valores de consumo");

            while (I<=30){
                int numeroAleatorio=aleatorio.nextInt(400);
                I++;
                consumoPromedio+=numeroAleatorio;
                factura+=numeroAleatorio;
                System.out.println(numeroAleatorio);

                if (numeroAleatorio>300){
                    contadorPicos++;
                }
            }

        }else {
            System.out.println("ingrese un valor correcto");
        }
        while (opcion!=5){
        System.out.println("1 ---- Ver tarifa");
        System.out.println("2 ---- mostrar consumo promedio");
        System.out.println("3 ---- mostrar picos consumo");
        System.out.println("4 ---- mostrar factura");
        System.out.println("5 ---- Salir");
        System.out.println("ingrese un valor para mostrar su opcion: ");
        opcion=teclado.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("su tarifa es: " + tarifaKwh);
                break;
            case 2:
                totalPromedio = consumoPromedio / 30;
                System.out.println("el consumo promedio es: " + totalPromedio);
                break;
            case 3:
                System.out.println("la cantidad de picos mayores a 300 fueron: " + contadorPicos);
                break;
            case 4:
                facturaTotal = factura * tarifaKwh;
                System.out.println("su factura total es: " + facturaTotal);
                break;
            case 5:
                System.out.println("Usted salio del sistema");
                break;
            default:
                System.out.println("ingrese un numero valido");
                break;

        }

        }

    }
}