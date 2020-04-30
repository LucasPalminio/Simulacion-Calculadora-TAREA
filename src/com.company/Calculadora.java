package com.company;

import java.util.Scanner;

public class Calculadora {
    public static Scanner teclado = new Scanner(System.in);
    private int num1;
    private int num2;

    public void menu() {
        System.out.println("=========================================");
        System.out.println("==============|Calculadora|==============");
        System.out.println("=========================================");
        num1 = ingresarUnNumero("Ingrese el primer Numero");
        num2 = ingresarUnNumero("Ingrese el segundo Numero");

        System.out.println("\nLos numeros que usted ingreso son el "+num1+" y "+num2);
        String[] opciones = {"Sumar dos numeros", "Restar dos numeros","Multiplicar dos numeros","Dividir dos números","Potencia de un numero","Salir"};
        System.out.println(">>>>>>Seleccione la opcion deseada<<<<<<");
        for (int i = 0; i < opciones.length ; i++) {
            System.out.println("("+i+")"+opciones[i]);
        }
    }
    private int ingresarUnNumero(String mensaje) {

        while (true) {
            try {

                System.out.print(mensaje+": ");
                int numero = teclado.nextInt();
                return numero;
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage() + ", porfavor intentelo nuevamente");
            }

        }


    }
}
