/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica8;

import java.io.FileOutputStream;
import java.io.IOException;
import nu.xom.*;
import java.util.Scanner;
/**
 *
 * @author ipgonzalez2
 */
public class Practica8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        {
            // Crear los elementos
            Element raiz = new Element("biblioteca");
            Scanner scan=new Scanner(System.in);
            String t;
            String a;
            char op;
            do{
               
                Element libro=new Element("libro");
                Element titulo=new Element("titulo");
                Element autor=new Element("autor");
                System.out.println("Titulo");
                t=scan.nextLine();
                titulo.appendChild(t);
                System.out.println("Autor");
                a=scan.nextLine();
                autor.appendChild(a);
                libro.appendChild(titulo);
                libro.appendChild(autor);
                raiz.appendChild(libro);
                 System.out.println("Añadir nuevo libro?(s/n)");
                op=scan.nextLine().toUpperCase().charAt(0);
            }while(op=='S');
            

            // Crear el documento
            Document doc = new Document(raiz);

            // Guardarlo
            try {
                FileOutputStream f = new FileOutputStream("libro.xml");
                Serializer serial = new Serializer(f);
                serial.write(doc);
                f.close();
                System.out.println("Ok");
            } catch (IOException exc) {
                System.err.println("ERROR de archivo: " + exc.getMessage());
            }
        }
    }

}
