package com.company;
public class Main {


    /*
    (Lucas Palminio)
    * Cuando el programa inicia su ejecución, este  crea un objeto de la clase calculadora (calc)
    * usando el constructor que no tiene parámetros, al usar este constructor este inicia la rutina de preguntar los números
    * por consola, luego el objeto calc ejecuta el método menú ( calc.menu() )
    * */
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        calc.menu();

    }
}
