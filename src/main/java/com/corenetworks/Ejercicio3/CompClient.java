package com.corenetworks.Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDate;

public class CompClient {
    public static void main(String[] args) {
        LocalDate fechaTransaccion=LocalDate.now();
        LocalDate fechaVencimiento=LocalDate.now().plusDays(15);
        String noTarjeta="1234567891234567";
        String codCVV= "696";
        double cantidad=300;

        try (Socket solicitudOPeracion = new Socket("localhost",3000);
             PrintWriter sSalida = new PrintWriter(solicitudOPeracion.getOutputStream(),true);){
            sSalida.printf("%s%s%16s%3s%f",fechaTransaccion,fechaVencimiento,noTarjeta,codCVV,cantidad);

            try( BufferedReader bf = new BufferedReader(new InputStreamReader(solicitudOPeracion.getInputStream()));){
                System.out.println(bf.readLine());
            }

        } catch (UnknownHostException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
