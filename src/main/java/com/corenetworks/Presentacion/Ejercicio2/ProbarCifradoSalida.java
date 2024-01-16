package com.corenetworks.Presentacion.Ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProbarCifradoSalida {
    public static void main(String[] args) {
        int letra=0;
        int numero;
        String frase="";
        int letraCifrada;
        Scanner teclado = new Scanner(System.in);

        try(FileReader f1=new FileReader("origen.txt");
            FileWriter f2=new FileWriter("cifrado.txt")) {
            while (true) {
                letra = f1.read();
                frase += Character.toString((char) letra);
                System.out.println("Por favor, ingrese un númro comprendido entre el 1 y el 255");
                numero = teclado.nextInt();
                System.out.println((char) letra);
                letraCifrada= (char) (letra ^ numero);
                System.out.println(letraCifrada);
                f2.write(letraCifrada+=letraCifrada);
                f2.flush();

                System.out.println();
                if (letra == -1) {
                    break;
                }
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
