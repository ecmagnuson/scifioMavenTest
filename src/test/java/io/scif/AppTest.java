package io.scif;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.scijava.Context;
import org.scijava.display.Display;

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
	
	//creating one context
	//signleton classes 1 instance of it 
	ctx.service(App.class);
	//plugins vs services
	//ctx.getPluginIndex().get(Display.class);
	//RichPlugin superclass of many plugins
	
	appWithContext = ctx.service(App.class); //everything filled out here
	//asking cxt for service of a type. same instance of that service
	//services are singletons in a particular context
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
    //module has io
    //service access to methods. singleton utility classes
   

}
