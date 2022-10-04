package io.scif;

import org.scijava.Context;
import org.scijava.Prioritized;
import org.scijava.service.AbstractService;

public class App extends AbstractService{
	
    public static void main( String[] args ) {
        System.out.println( "It's taken a second for me to wrap my head around why "
        		+ "an abstract class can have a main method, but I think I understand now." );
        System.out.println(new App().getClass());
    }
    
	@Override
	public Context getContext() {
		return super.getContext();
	}
	
	public static int square(int num) {
		return num * num;
	}
	
//	@Override
//	public int compareTo(Prioritized that) {
//		//If I don't have this there is an error about it.
//		//super is AbstractService though..
//		return super.compareTo(that);
//	}

}
