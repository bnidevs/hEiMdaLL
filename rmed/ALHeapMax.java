/*****************************************************
 * class ALHeapMax
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeapMax {

    // instance vars
    public ArrayList<Integer> _heap; 
    
    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeapMax() {
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
     * Integer peekMax()
     * Returns max value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMax() { 
 	if (isEmpty()) return null;
	else return _heap.get(0); 
    } // O(1)

    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     *****************************************************/
    public void add (Integer addVal) {
	_heap.add(addVal);
	if (_heap.size() != 1) {
	    int n = _heap.size() - 1;
	    for (int r = (n - 1) / 2; addVal > _heap.get(r); r = (r - 1) / 2) {
		swap(n,r);
		n = r;
	    }
	}
    } // O(n)

    /*****************************************************
     * removeMax()  ---  means of removing an element from heap
     * Removes and returns largest element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMax() { 
	if (_heap.size() == 0)
	    return null;
	int max = peekMax();
	swap(0,_heap.size()-1);
	_heap.remove(_heap.size()-1);
	int maxChildPos = -1;
	for (int root = 0; maxChildPos(root) != -1; root = maxChildPos) {
	    maxChildPos = maxChildPos(root);
	    swap(root,maxChildPos);
	}
	return max;
    } // O(n)

    /*****************************************************
     * maxChildPos(int)  ---  helper fxn for removeMax()
     * Returns index of largest child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int maxChildPos (int pos) { 
	if (_heap.size() == 1)
	    return -1;
	int r = 2 * pos + 1;
	int l = 2 * pos + 2;
	if (r > _heap.size() - 1 || l > _heap.size() - 1) {
	    return -1;
	}
	if (_heap.get(r) == maxOf(_heap.get(r),_heap.get(l)))
	    return r;
	return l;
    } // O(n)

    //************ aux helper fxns ***************
    private Integer maxOf (Integer a, Integer b) {
	if (a.compareTo(b) > 0)
	    return a;
	else
	    return b;
    }

    // swap for an ArrayList
    private void swap (int pos1, int pos2) {
	_heap.set(pos1, _heap.set(pos2, _heap.get(pos1)));
    }
    //********************************************

    // main method for testing
    public static void main (String[] args) {
	ALHeapMax pile = new ALHeapMax();

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
	
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
    } // end main()
} // end class ALHeapMax
