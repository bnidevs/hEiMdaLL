public class RunMed {
    // instance Variables
    private ALHeapMax lilVals;
    private ALHeapMin bigVals;
    private int min;
    private int max;
	
    // default Constructor
    public RunMed() {
	lilVals = new ALHeapMax();
	bigVals = new ALHeapMin();
	min = 0;
	max = 0;
    }

    public String toString() { 
	return lilVals.toString() + "\n" + bigVals.toString();
    } // O(1)
    
    public int getMedian() {
	if (min > max)
	    return lilVals.peekMax();
	else if (max > min)
	    return bigVals.peekMin();
	else
	    return (lilVals.peekMax() + bigVals.peekMin()) / 2;
    }
    
    public void add (Integer newVal) {
	if (bigVals.peekMin() == null || lilVals.peekMax() == null) {
	    lilVals.add(newVal);
	    min++;
	}
	else if (newVal < bigVals.peekMin()) {
	    lilVals.add(newVal);
	    min++;
	}
	else {
	    bigVals.add(newVal);
	    max++;
	}
	if (min > max)
	    while (min - max > 1) {
		bigVals.add(lilVals.removeMax());
		min--;
		max++;
	    }
    	else
	    while (max - min > 1) {
		lilVals.add(bigVals.removeMin());
		max--;
		min++;
	    }
    }
} // end class
