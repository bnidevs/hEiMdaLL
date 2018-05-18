// Team hEiMdaLL -- Frank Chen, Bill Ni, Tania Cao
// APCS2 pd2
// HW50 -- Run Run Run
// 2018-05-17

public class RunMed
{
	// Instance Variables
	private ALHeapMin lilVals;
	private ALHeapMax bigVals;
	// More Variables b/c size() didn't work
	private int min;
	private int max;
	
	// Default Constructor
	public RunMed()
	{
		lilVals = new ALHeapMin();
		bigVals = new ALHeapMax();
		min = 0;
		max = 0;
	}
	
	// getMedian Method
	public int getMedian()
	{
		if( min > max )
		{
			return lilVals.peekMin();
		}
		else if( max > min )
		{
			return bigVals.peekMax();
		}
		else
		{
			return( lilVals.peekMin() + bigVals.peekMax() ) / 2;
		}
	}
	
	// add Method
	public void add( Integer newVal )
	{
		if( newVal < bigVals.peekMax() )
		{
			bigVals.add( newVal );
			max++;
		}
		else
		{
			lilVals.add( newVal );
			min++;
		}
		if( min > max )
		{
			while( min - max > 1 )
			{
				bigVals.add( lilVals.removeMin() );
				min--;
				max++;
			}
		}
		else
		{
			while( max - min > 1 )
			{
				lilVals.add( bigVals.removeMax() );
				max--;
				min++;
			}
		}
	}
	
} // end class