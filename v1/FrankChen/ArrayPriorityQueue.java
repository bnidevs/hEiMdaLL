// Frank Chen
// APCS2 pd2
// HW46 -- Arrr, There Be Priorities Here Matey
// 2018-05-09

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue
{
	
	// instance variables
	private ArrayList<String> _data = new ArrayList<String>();
	
	
	// isEmpty method
	public boolean isEmpty()
	{
		return ( _data.size() == 0 );
	}
	
	
	// add method
	public void add( String str )
	{
		_data.add( str );
	}
	
	
	// peekMin method
	public String peekMin()
	{
		int min = 0;
		for( int i = 0; i < _data.size(); i++ )
		{
			if( ( _data.get( min ) ).compareTo( _data.get( i ) ) > 0 )
			{
				min = i;
			}
		}
		return _data.get( min );
	}
	
	
	// removeMin method
	public String removeMin() 
	{
		String min = peekMin();
		for( int i = 0; i < _data.size(); i++ )
		{
			if( min == _data.get( i ) )
			{
				_data.remove( i );
				break;
			}
		}
		return min;
	}
	
	
	// toString method
	public String toString()
	{
		return _data.toString();
	}
	
	
	// main method
	public static void main( String[] args )
	{
		ArrayPriorityQueue test = new ArrayPriorityQueue();
		
		test.add( "foo" );
		test.add( "moo" );
		
		System.out.println( test ); // foo moo
		
		test.removeMin();
		
		System.out.println( test ); // moo
		
		test.add( "goo" );
		test.add( "hoo" );
		test.add( "doo" );
		
		System.out.println( test ); // moo goo hoo doo
		
		test.removeMin();
		
		System.out.println( test ); // moo goo hoo 
	}
	
} // end class