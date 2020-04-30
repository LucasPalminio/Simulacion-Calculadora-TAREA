package com.company;

import java.util.Scanner;

public class Calculadora {
    public static Scanner teclado = new Scanner(System.in);
    private int num1;
    private int num2;
    private int resultado;

    public void menu() {
        System.out.println("=========================================");
        System.out.println("==============|Calculadora|==============");
        System.out.println("=========================================");


        String[] simbolos = {"+", "-", "*", "/", " elevado a ", "¿Cual de los dos numeros es mayor? ", "Modificar Los Numeros", "Salir"};
        System.out.println(">>>>>>Seleccione la opcion deseada<<<<<<");
        for (int i = 0; i < simbolos.length; i++) {
            System.out.print("(" + (i + 1) + ") ");
            if (i <= 4) {
                System.out.println(num1 + simbolos[i] + num2 + " = ?");
            } else {
                System.out.println(simbolos[i]);
            }


        }
        int opcion = ingresarUnNumero("Ingrese una opcion");
        switch (opcion) {
            case 1: //sumar
                resultado = suma();
                System.out.println(num1 + "+" + num2 + "=" + resultado);
                break;
            case 2:
                resultado = restar();
                System.out.println(num1 + "-" + num2 + "=" + resultado);
                break;
            case 7:
                ingresarLosNumeros();
                break;
            case 8:
                System.out.println("Hasta la proxima!");
                return;
            default:
                System.out.println("Error, la opcion ingresada es incorrecta, intentelo Nuevamete");
                menu();

        }
        menu();

    }

    private int suma() {
        return num1 + num2;
    }

    private int restar() {
        return num1 - num2;
    }

    public void ingresarLosNumeros() {
        num1 = ingresarUnNumero("Ingrese el primer Numero");
        num2 = ingresarUnNumero("Ingrese el segundo Numero");
    }

    private int ingresarUnNumero(String mensaje) {

        while (true) {
            try {

                System.out.print(mensaje + ": ");
                return teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage() + ", porfavor intentelo nuevamente");
                teclado.nextLine();
            }

        }


    }
}
