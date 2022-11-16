package io.scif;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
    //vacuum bag sucks in plugins and gives services from the plugins
    private DemoService serviceWithContext;
    private DemoService serviceNoContext;

    @Before
    public void setUp() {
    ctx = new Context(DemoService.class); //debug and look TODO 
	//ctx = new Context(DemoService.class, DisplayPlugin.class); //just getting DemoServices here
	//ctx = new Context();
    	
    
	
	
	//creating one context
	//signleton classes 1 instance of it 
	ctx.service(DemoService.class);
	//plugins vs services
	//ctx.getPluginIndex().get(Display.class);
	//RichPlugin superclass of many plugins
	
	serviceWithContext = ctx.service(DemoService.class); //everything filled out here
	//asking cxt for service of a type. same instance of that service
	//services are singletons in a particular context
	serviceNoContext = new DemoService(); // vs without context
    }

    @Test
    public void getClassName() {
	// class name is the same
	assertEquals(serviceNoContext.getClass().toString(), serviceWithContext.getClass().toString());
    }

    @Test
    public void testAppInfoNull() {
	// Info is should be null because we didn't give a context
	assertNull(serviceNoContext.getInfo());
    }

    @Test
    public void testSameInfo() {
	// should not be null because we did give it a context
	assertNotNull(serviceWithContext.getInfo());
    }
    
    
    @Test
    public void testToString() {
	//same name and priority
	assertEquals(serviceWithContext.toString(), serviceNoContext.toString());
    }
    
    //TODO debug these below methods
    
    /*
     * Make sure different instances created when calling method
     */
    @Test
    public void testGetDisplayPlugins() {
    	assertNotEquals(serviceNoContext.getDisplayPlugins(), serviceNoContext.getDisplayPlugins());
    }
    
    @Test
    public void testGetDisplayPlugins2() {
    	assertNotEquals(serviceWithContext.getDisplayPlugins(), serviceWithContext.getDisplayPlugins());
    }
    
    /**
     * testGetDisplayPlugins()
     * 1. Understand why testGetDisplayPlugins threw NPE. It was correct to do that, understand why though.
     * 
     * testGetDisplayPlugins2()
     * 2. Check if there is anything in the serviceWithContext.getDisplayPlugins() -- debugger. 
     * 	2a If the list is empty change how the context is created by adding your DisplayPlugin.class
     *  2b. if the list is not empty or if changes are made and test still fails then Mark is wrong. 
     * 
     *
     //based on how Context is initialized it could change the getDisplayPlugins() contents
     */
    
    
/*
 * 	public static void main(String[] args) {
		DemoService d = new DemoService();
		System.out.println(d);
	}
 */
    
    
    
    //context is a collection of plugins
    //service is a type of plugin
    //module look into scijava common particular type of plugin with io.
    //module has io
    //service access to methods. singleton utility classes
   

}
