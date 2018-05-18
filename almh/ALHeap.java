/*****************************************************
 * class ALHeap
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
	if (isEmpty()) return null;
	return _heap.get(0);
    } // O(1)
    
    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     * Algorithm: Add addVal to the end of _heap. If addVal is not the only
     *            element in _heap, swap addVal with it's parent if addVal
     *            is less than it's parent's value.
     *****************************************************/
    public void add (Integer addVal) {
	_heap.add(addVal);
	if (_heap.size() != 1) {
	    int n = _heap.size() - 1;
	    for (int r = (n - 1) / 2; addVal < _heap.get(r); r = (r - 1) / 2) {
		swap(n,r);
		n = r;
	    }
	}
    } // O(n)
    
    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     * Algorithm: If _peak is empty, return null. Otherwise, swap the first
     *            element (minVal) with the last element. Remove the last
     *            element (minVal). Set root as the first element. If root
     *            has children, swap root with the child that has the min
     *            value. Update root as the index of the min value found in
     *            previous step. Repeat until root has no children.
     *****************************************************/
    public Integer removeMin() { 
	if (_heap.size() == 0)
	    return null;
	int min = peekMin();
	swap(0,_heap.size()-1);
	_heap.remove(_heap.size()-1);
	int minChildPos = -1;
	for (int root = 0; minChildPos(root) != -1; root = minChildPos) {
	    minChildPos = minChildPos(root);
	    swap(root,minChildPos);
	}
	return min;
    } // O(n)

    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos (int pos) { 
	if (_heap.size() == 1)
	    return -1;
	int r = 2 * pos + 1;
	int l = 2 * pos + 2;
	if (r > _heap.size() - 1 || l > _heap.size() - 1)
	    return -1;
	if (_heap.get(r) == minOf(_heap.get(r),_heap.get(l)))
	    return r;
	return l;
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
