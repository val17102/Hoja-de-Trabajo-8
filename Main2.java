
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hecto
 */
public class Main2 {
    public static void main(String[] args) {
        boolean x = true;
        Scanner sc = new Scanner(System.in);
        String respuesta = "";
        PriorityQueue<Paciente> queue = new PriorityQueue<>();
        String[] palabrasSeparadas;
        int i = 0;
	//se separan las palabras
    File listado = new File(System.getProperty("user.dir")+"\\"+"listado.txt");
    try{
        
    FileReader leer = new FileReader(listado);
    BufferedReader buff = new BufferedReader(leer);
    String linea;
    while((linea = buff.readLine()) != null)
    {
                //i++;
                //a.setSize(i);
   		palabrasSeparadas = linea.split(",");
                queue.add(new Paciente(palabrasSeparadas[0],palabrasSeparadas[1],palabrasSeparadas[2]));
    }
    }catch(IOException e){
        
    }
        while(x){
            
            System.out.println("MENU");
            System.out.println("1. Siguiente Paciente");
            System.out.println("2. Salir");
            int ope =  sc.nextInt();
            if (ope == 1 && queue.size()>0){
                Paciente a = queue.poll();
            System.out.println(a.getNombre()+","+a.getSintoma()+","+a.getPrioridad()+"\n");
            ope = 0;
            }
            if (ope == 2){
                x = false;
                ope = 0;
                 }
        }
    }
}
