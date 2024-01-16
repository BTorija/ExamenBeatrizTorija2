package com.corenetworks.Presentacion.Ejercicio2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProbarEntradaFichero {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);




        try(FileWriter f1=new FileWriter("origen.txt" );) {
            System.out.println("Por favor, introduzca el texto");
            f1.write(teclado.nextLine());
            f1.flush();
        } catch (IOException e) {
            System.out.println(e.toString());
        }


    }

}

