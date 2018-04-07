
//import java.util.PriorityQueue;
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
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    /**
     * Vector que almacena todos los elementos
     */
   protected Vector<E> data; 

   /**
    * Constructor
    * @param v vector que contiene los elementos que se van ingresar al vector heap
    */
	public VectorHeap(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
		{ // add elements to heap
			add(v.get(i));
		}
	}
        /**
         * metodo que devuelve el padre del nodo en la posicion ingresada
         * @param i nodo cuyo padre se quiere obtener
         * @return posicion del padre
         */
	protected static int parent(int i)
	{
		return (i-1)/2;
	}
        
         /**
         * metodo que devuelve el hijo izquierdo del nodo en la posicion ingresada
         * @param i nodo cuyo hijo izquierdo se quiere obtener
         * @return posicion del hijo izquierdo
         */
	protected static int left(int i)
	// pre: 0 <= i < size
	// post: returns index of left child of node at location i
	{
		return 2*i+1;
	}
        
        /**
         * metodo que devuelve el hijo derecho del nodo en la posicion ingresada
         * @param i nodo cuyo hijo derecho se quiere obtener
         * @return posicion del hijo derecho
         */
	protected static int right(int i)
	{
		return (2*i+1) + 1;
	}
        /**
         * Mueve el nodo en la posicion ingresada a su posicion adecuada hacia arriba
         * @param leaf  posicion del nodo que se quiere mover
         */
	protected void percolateUp(int leaf)
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&
		(value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}
        /**
         * Agrega un item al vectorheap
         * @param value item que se va a ingresar
         */
	public void add(E value)
	{
		data.add(value);
		percolateUp(data.size()-1);
	}
        /**
         * Mueve el nodo en la posicion igresada a su posicion adecuada hacia abajo
         * @param root posicion del nodo que se movera
         */
	protected void pushDownRoot(int root)
	// pre: 0 <= root < size
	// post: moves node at index root down
	// to appropriate position in subtree
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
				((data.get(childpos+1)).compareTo
				(data.get(childpos)) < 0))
				{
					childpos++;
				}
			// Assert: childpos indexes smaller of two children
			if ((data.get(childpos)).compareTo
				(value) < 0)
			{
				data.set(root,data.get(childpos));
				root = childpos; // keep moving down
			} else { // found right location
				data.set(root,value);
				return;
			}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}
        /**
         * quita un item del vector heap y lo devuelve
         * @return item que se quito 
         */
	public E remove()
	{
                if (!isEmpty()){
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if (data.size() > 1) 
                pushDownRoot(0);
		return minVal;
                }else
                    return null;
                
	} 
        /**
         * devuelve el primer item 
         * @return primer item
         */
        public E getFirst(){
            return data.get(0);
        }
        /**
         * vacia el vectorheap
         */
        public void clear(){
            for (int i = 0; i<data.size()-1;i++){
                remove();
            }
        }
        /**
         * devuelve el tamano del vectorheap
         * @return tamano del vectorheap
         */
        public int size(){
            return data.size()-1;
        }
        
        /**
         * devuelve si el vectorheap esta vacio
         * @return si esta vacio o no
         */
        public boolean isEmpty(){
        if (size() >= 0) return false;
                else return true;
    }
}
