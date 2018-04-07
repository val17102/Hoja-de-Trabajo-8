/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Vector;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hecto
 */
public class VectorHeapTest {
    
    public VectorHeapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

 

 


    /**
     * Test of add method, of class VectorHeap.
     */
    @Test
    public void testAdd() {
        Vector<Paciente> a = new Vector<Paciente>(10);
        VectorHeap<Paciente> pacientes;
        a.add(new Paciente("Pedro Vila","Lupus","A"));
        pacientes = new VectorHeap<Paciente>(a);
        Paciente b = pacientes.remove();
        assertEquals("Pedro Vila,Lupus,A",b.getNombre()+","+b.getSintoma()+","+b.getPrioridad());
    }


    /**
     * Test of remove method, of class VectorHeap.
     */
    @Test
    public void testRemove() {
        Vector<Paciente> a = new Vector<Paciente>(10);
        VectorHeap<Paciente> pacientes;
        a.add(new Paciente("Pedro Vila","Lupus","B"));
        a.add(new Paciente("Pedro Vila","Lupus","A"));
        a.add(new Paciente("Pedro Vila","Lupus","C"));
        pacientes = new VectorHeap<Paciente>(a);
        Paciente b = pacientes.remove();
        assertEquals("Pedro Vila,Lupus,A",b.getNombre()+","+b.getSintoma()+","+b.getPrioridad());
    }

    /**
     * Test of getFirst method, of class VectorHeap.
     */
    @Test
    public void testGetFirst() {
        Vector<Paciente> a = new Vector<Paciente>(10);
        VectorHeap<Paciente> pacientes;
        a.add(new Paciente("Pedro Vila","Lupus","A"));
        pacientes = new VectorHeap<Paciente>(a);
        Paciente b = pacientes.getFirst();
        assertEquals("Pedro Vila,Lupus,A",b.getNombre()+","+b.getSintoma()+","+b.getPrioridad());
    }


    
}
