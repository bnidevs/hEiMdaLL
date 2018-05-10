import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{

    private ArrayList _storage;
    private int _size;

    public ArrayPriorityQueue{
	_storage = new ArrayList<String>();
	_size = 0;
    }

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
	_size++;
    }
    
    public boolean isEmpty(){
	return _size == 0;
    }
    
    public String peekMin(){
	return _storage[0];
    }
    
    public String removeMin(){
	String temp = _storage[0];
	_storage.remove(0);
	return temp;
    }
}
