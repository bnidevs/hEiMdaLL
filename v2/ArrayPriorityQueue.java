import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{

	//container
    private ArrayList _storage;

    //constructor
    public ArrayPriorityQueue(){
	_storage = new ArrayList<String>();
    }

    //add()
    //takes String s
    //inserts into proper position in container
    public void add(String s){
	if (isEmpty()){
	    _storage.add(s);
	}
	else{
	    for(int i = 0; i < _size; i++){
		if (s.compareTo(_storage[i]) > 0)
		    _storage.add(i,s);
	    }
	}
    }
    
    //isEmpty()
    //takes nothing
    //returns true if container is empty, false otherwise
    public boolean isEmpty(){
	return _storage.size() == 0;
    }
    
    //peekMin()
    //takes nothing
    //returns the highest priority element
    public String peekMin(){
	return _storage[0];
    }
    
    //remove()
    //takes nothing
    //removes and returns the highest priority element
    public String removeMin(){
	String temp = _storage[0];
	_storage.remove(0);
	return temp;
    }
}
