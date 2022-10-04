package io.scif;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.scijava.Context;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private Context ctx;
    private App appWithContext;
    private App app;

    @Before
    public void setUp() {
	ctx = new Context(App.class);
	appWithContext = ctx.service(App.class);
	app = new App(); // vs without context
    }

    @Test
    public void getClassName() {
	// class name is the same
	assertEquals(app.getClass().toString(), appWithContext.getClass().toString());
    }

    @Test
    public void testAppInfoNull() {
	// Info is should be null because we didn't give a context
	assertNull(app.getInfo());
    }

    @Test
    public void testSameInfo() {
	// should not be null because we did give it a context
	assertNotNull(appWithContext.getInfo());
    }
    
    @Test
    public void testSquare() {
	assertEquals(appWithContext.square(5), app.square(5));
    }
    
    @Test
    public void testToString() {
	//same name and priority
	assertEquals(appWithContext.toString(), app.toString());
    }
    
    //context is a collection of plugins
    //service is a type of plugin
    //module look into scijava common particular type of plugin with io.
    //service acces to methods
    
    

}
