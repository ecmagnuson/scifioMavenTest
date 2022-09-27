package io.scif;

import org.scijava.Context;
import org.scijava.service.AbstractService;

public abstract class App extends AbstractService{
	
    public static void main( String[] args ) {
        System.out.println( "It's taken a second for me to wrap my head around why "
        		+ "an abstract class can have a main method, but I think I understand now." );
    }
    
	@Override
	public Context getContext() {
		return super.getContext();
	}
	
	public static int square(int num) {
		return num * num;
	}

}
