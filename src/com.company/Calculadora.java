package com.company;

import java.util.Scanner;

public class Calculadora {
    public static Scanner teclado = new Scanner(System.in);
    private double num1;
    private double num2;
    private double resultado;
    public Calculadora(){
        //(Lucas Palminio)
        //Este constructor sirve si se instancia un objeto de clase Calculadora sin parametros
        //esta llama al metodo a que ingrese los numeros por terminal.
        ingresarLosNumeros();
    }

    public Calculadora(double num1, double num2) {
        //(Lucas Palminio)
        //Este constructo contiene dos parametros que estas se usan para inicializar num1 y num2.
        this.num1 = num1;
        this.num2 = num2;
    }


    public void menu() {
        /*Menu: diseño por Lorenzo Devia y algoritmo por Lucas Palminio*/
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
        int opcion = (int) ingresarUnNumero("Ingrese una opcion");
        switch (opcion) {
            case 1: //sumar
                resultado = suma();
                System.out.println(num1 + "+" + num2 + "=" + resultado);
                break;
            case 2: //resta
                resultado = restar();
                System.out.println(num1 + "-" + num2 + "=" + resultado);
                break;
            case 3: /*Multiplicacion
                    (Fernando Robles)
                    */
                resultado = multiplicacion();
                System.out.println(num1 + "*" + num2 + "=" + resultado);
                break;
            case 4: //Division
                // (Lorenzo Devia Rubio)
                // Para evitar altercados con la division por 0, se restringe su uso y se devuelve al menu
                if (num2 != 0) {
                    resultado = dividir();
                    System.out.println(num1 + "/" + num2 + "=" + resultado);
                } else {
                    System.out.println("Error, el divisor es 0");
                }
                break;
            case 5: /* Potencia
                    (Fernando Robles)
                    evita que al ingresar como base y exponente el número “0” entregue como resultado el “1”                    */
                if(num1==0 && num2==0) {
                    System.out.println("Se indefine,ya que la base y el exponente son 0");
                }else{
                    resultado=potencia();
                    System.out.println(num1 + "^" + num2 + "=" + resultado);
                }

                break;
            case 6: //Comparacion
                System.out.println(comparar());
                break;
            case 7: //Ingresar los Numeros
                ingresarLosNumeros();
                break;
            case 8: //Salir
                System.out.println("Hasta la proxima!");
                return; //Se rompe la recursividad
            default://En caso que el usuario ingrese una opcion invalida
                System.out.println("Error, la opcion ingresada es incorrecta, intentelo Nuevamente");
                menu();

        }
        menu();//Una vez realizada una de las operaciones (excepto salir), se ejecutara de nuevo el menu (Funcion recursiva)

    }

    /*A continuacion una lista de setters y getters si llega a ser necesario (Lucas Palminio)*/
    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double suma() {
        //(Lucas Palminio)
        //Este metodo retorna la suma de los atributos num1 y num2
        return num1 + num2;
    }

    public double restar() {
        //(Lucas Palminio)
        //Este metodo retorna la resta de los atributos num1 y num2
        return num1 - num2;
    }

    public String comparar() {
        // (Lorenzo Devia rubio)
        // Primero verifica si ambos numeros son iguales, si es verdadero retorna el mensaje correspondiente en String,
        // si es falso verifica si el primer numero es mayor que el segundo, si es verdadero retorna el mensaje correspondiente en String,
        // finalmente si es falso se asume que el segundo numero es mayor que el primero y se retorna el mensaje correspondiente en String
        if (num1 == num2) {
            return "Ambos numeros son iguales";
        } else {
            if (num1 > num2) {
                return num1 + " es mayor que " + num2;
            } else {
                return num2 + " es mayor que " + num1;
            }
        }
    }

    public double dividir() {
        return num1 / num2;
        // (Lorenzo Devia rubio)
        //Este metodo retorna la division de los atributos de num1 entre num2
    }

    public double multiplicacion(){
        /*Fernando Robles
         Este método toma las variables “num1” y “num2” como los  factores  de la multiplicación
         y asigna el resultado(producto) a la variable “resultado” .

        */
        return num1 * num2;

    }

    public double potencia(){
        /*Fernando Robles
        Utiliza el método de  "Math.pow" haciendo que la variable "num1" sea la base y "num2" el exponente.

         */

        return Math.pow(num1, num2);

    }

    public void ingresarLosNumeros() {
        //(Lucas Palminio)
        //Metodo para modificar los atributos num1 y num2
        //que mas tarde se utilizara para realizar operaciones aritmeticas

        num1 = ingresarUnNumero("Ingrese el primer Numero");
        num2 = ingresarUnNumero("Ingrese el segundo Numero");
    }

    //
    public double ingresarUnNumero(String mensaje) {
        //(Lucas Palminio)
        //Este metodo retorna un numero de tipo Double ingresado por teclado,
        //Primero muestra un mensaje en pantalla al usuario que numero debe ingresar y luego
        //esta entrada es validada para que se ingrese solamente un valor numerico.
        //En caso de que ocurra una excepcion el sistema preguntara nuevamente

        while (true) {
            try {

                System.out.print(mensaje + ": ");
                return teclado.nextDouble();
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage() + ", porfavor intentelo nuevamente");
                teclado.nextLine();
            }

        }


    }
}
