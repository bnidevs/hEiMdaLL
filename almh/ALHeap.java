// Team hEiMdaLL -- Tania Cao, Frank Chen, Bill Ni
// APCS2 pd2
// HW48 -- Heap o'Trouble
// 2018-05-13

/*****************************************************
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap {

    // instance vars
    private ArrayList<Integer> _heap; 

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() { 
	_heap = new ArrayList<Integer>();
    }
    
    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (more complicated, more fun)
     *****************************************************/
    public String toString() { 
		return _heap.toString();
    } // O(1)

    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() { 
	return _heap.size() == 0;
    } // O(1)

    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin() { 
	int min = -10000;
	for (int x : _heap)
	    if( x < min )
		min = x;
	if (min == -10000)
	    return null;
	else
	    return min;
    } // O(1)
    
    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     *****************************************************/
    public void add (Integer addVal) {
	for (int i = 0; i <_heap.size(); i++)
	    if( addVal < _heap.get(i)) {
		    _heap.add(i, addVal);
		    return;
	    }
    	_heap.add(addVal);
    } // O(n)

    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin() { 
	if (peekMin() == null)
	    return null;
	int min = peekMin();
	for (int i = 0; i < _heap.size(); i++)
	    if (_heap.get(i) == min) {
		_heap.remove(min);
		return min;
	    }
    	return null;
    } // O(n)

    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos (int pos) { 
	int min = peekMin();
	if (peekMin() == null)
	    return -1;
	for (int i = 0; i < _heap.size(); i++)
	    if (_heap.get(i) == min)
		return i;
    	return -1;
    } // O(n)
  
    //************ aux helper fxns ***************
    private Integer minOf (Integer a, Integer b) {
	if (a.compareTo(b) < 0)
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap (int pos1, int pos2) {
	_heap.set(pos1, _heap.set(pos2, _heap.get(pos1)));
    }
    //********************************************

    // main method for testing
    public static void main (String[] args) {
	ALHeap pile = new ALHeap();

	pile.add(2);
	System.out.println(pile);
	pile.add(4);
	System.out.println(pile);
	pile.add(6);
	System.out.println(pile);
	pile.add(8);
	System.out.println(pile);
	pile.add(10);
	System.out.println(pile);
	pile.add(1);
	System.out.println(pile);
	pile.add(3);
	System.out.println(pile);
	pile.add(5);
	System.out.println(pile);
	pile.add(7);
	System.out.println(pile);
	pile.add(9);
	System.out.println(pile);

	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
    } // end main()
} // end class ALHeap
