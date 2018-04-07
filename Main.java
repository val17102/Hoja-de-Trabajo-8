
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
public class Main {
    public static void main(String[] args) {
        Hospital m = new Hospital();
        boolean x = true;
        Scanner sc = new Scanner(System.in);
        String respuesta = "";
        while(x){
            
            System.out.println("MENU");
            System.out.println("1. Siguiente Paciente");
            System.out.println("2. Salir");
            int ope =  sc.nextInt();
            if (ope == 1){
            System.out.println(m.siguienteP());
            ope = 0;
            }
            if (ope == 2){
                x = false;
                ope = 0;
                 }
        }
    }
}
