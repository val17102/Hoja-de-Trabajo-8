
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hecto
 */
public class Hospital {
    VectorHeap<Paciente> pacientes;
    
    public Hospital(){
        String[] palabrasSeparadas;
        int i = 0;
        Vector<Paciente> a = new Vector<Paciente>(10);
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
                a.add(new Paciente(palabrasSeparadas[0],palabrasSeparadas[1],palabrasSeparadas[2]));
    }
    }catch(IOException e){
        
    }
        pacientes = new VectorHeap<Paciente>(a);
    }
    
    public String siguienteP(){
        if (!pacientes.isEmpty()){
        Paciente a = pacientes.remove();
        return a.getNombre()+","+a.getSintoma()+","+a.getPrioridad()+"\n";
        }else return"";
    }
    
}
