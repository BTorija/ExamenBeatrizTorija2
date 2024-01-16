package com.corenetworks.Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.Random;

public class CompServidor {
    public static void main(String[] args) {
        BufferedReader bf;
        PrintWriter sRespuesta;
        String respuesta="";
        LocalDate fechaTransaccion=LocalDate.now();
        LocalDate fechaVencimiento=LocalDate.now().plusDays(15);
        String noTarjeta="1234567891234567";
        String codCVV= "696";
        double cantidad=300;




        try (ServerSocket servidor = new ServerSocket(3000);){
            while (true){
                System.out.println("En espera de peticiones ...");
                Socket s1 = servidor.accept();
                bf = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                respuesta=bf.readLine();
                System.out.println(respuesta);
                System.out.println(respuesta.substring(10).strip());
                int noAutorizacion =(int) Math.floor(Math.random() * 4);
                sRespuesta = new PrintWriter(s1.getOutputStream(),true);
                System.out.printf("%n");
                System.out.printf("%n");
                switch (noAutorizacion){
                    case 0:
                        sRespuesta.printf("%s,0000, Transacción Aceptada,%16s",fechaTransaccion,noTarjeta);
                        break;
                    case 1:
                        sRespuesta.printf("%s,9137, Error al intentar validar la tarjeta ,%16s",fechaTransaccion,noTarjeta);
                        break;
                    case 2:
                        sRespuesta.printf("%s,9221, El cliente no está introducindo el CVV,%16s",fechaTransaccion,noTarjeta);
                        break;
                    case 3:
                        sRespuesta.printf("%s,9677, Saldo Insuficiente,%16s",fechaTransaccion,noTarjeta);
                        break;
                }

            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
