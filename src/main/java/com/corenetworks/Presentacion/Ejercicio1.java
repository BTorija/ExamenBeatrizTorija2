package com.corenetworks.Presentacion;

import java.io.File;

public class Ejercicio1 {
    public static void main(String[] args) {
        File ej1=new File("ejercicio1.txt");
        System.out.println("Nombre del archivo-->"+ ej1.getName());
        System.out.println("Ruta absoluta--> " +ej1.getAbsolutePath());
        System.out.println("Es una carpeta?" +ej1.isDirectory());
        System.out.println("Es un fichero? "+ ej1.isFile());
        System.out.println("Ultima modificacion-->" + ej1.lastModified());
        System.out.println("Existe?-->" +ej1.exists());
        System.out.println("Se puede leer?--> "+ej1.canRead());
        System.out.println("Se puede escribir?--> "+ej1.canWrite());

    }
}
