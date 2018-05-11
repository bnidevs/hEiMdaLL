import java.util.ArrayList;

public class ArrayPriorityQueue {
    // instance variables
    String[] list;
    int size;

    // default constructor
    public ArrayPriorityQueue() {
	list = new ArrayList();
	size = 0;
    }

    // methods
    public void add (String value) {
	if (list == null) {
	    list[0] = value;
	    size = 1;
	    return;
	}
	for (int i = 0; i < size; i++) {
	    if (value.compareTo(list.get(i)) > 0) {
		list.add(i,value);
		return;
	    }
	}
	size++;
    }
    
    public boolean isEmpty() {
	return size == 0;
    }

    public String peekMin() {
	return list.get(size - 1);
    }

    public String removeMin() {
	return list.remove(size - 1);
    }
}
