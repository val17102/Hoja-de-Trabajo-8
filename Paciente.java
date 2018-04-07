/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hecto
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre, sintoma, prioridad;
    
    public Paciente(String nom, String sin, String pri){
        nombre = nom;
        sintoma = sin;
        prioridad = pri;
    }
    
    
    public String getPrioridad(){
        return prioridad;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getSintoma(){
        return sintoma;
    }
    
    public int compareTo(Paciente n){
        return n.getPrioridad().compareTo(prioridad)*-1;
        
    }
    
}
