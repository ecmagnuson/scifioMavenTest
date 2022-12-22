package io.scif;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import org.scijava.Context;

public class DemoServiceTest {

    // A Context finds Plugins and gets Services from the Plugins
    private Context ctx;

    private DemoService serviceWithContext; // Instance of DemoService with proper Context
    private DemoService serviceNoContext; // Instance of DemoService without proper Context

    @Before
    public void setUp() {

	// no param context looks for everything.
	// ctx = new Context();

	//// context takes Services
	// ctx.getPluginIndex().get(Display.class);
	ctx = new Context(DemoService.class);
	// ctx = new Context(DisplayPlugin.class); will fail bc it's not a Service

	serviceWithContext = ctx.service(DemoService.class); // everything filled out here
	// asking cxt for service of a type. same instance of that service
	// services are singletons in a particular context
	serviceNoContext = new DemoService(); // vs without context
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

    /*
     * Make sure different instances created when calling method
     */
    @Test(expected = NullPointerException.class)
    public void testGDPNoContext() {
	// throws NPE
	assertNotEquals(serviceNoContext.getDisplayPlugins(), serviceNoContext.getDisplayPlugins());
    }

    @Test
    // Test size is 1 when creating
    public void testPluginCount() {
	assertEquals(2, serviceWithContext.getDisplayPlugins().size());
    }

    @Test
    public void testGDPWithContext() {
	// returns []
	assertNotEquals(serviceWithContext.getDisplayPlugins(),
		serviceWithContext.getDisplayPlugins());
    }

    /**
     * testGetDisplayPlugins()
     *
     * // null 1. Understand why testGetDisplayPlugins threw NPE. It was correct to
     * do that, understand why though.
     * 
     * testGetDisplayPlugins2() 2. Check if there is anything in the
     * serviceWithContext.getDisplayPlugins() -- debugger. 2a If the list is empty
     * change how the context is created by adding your DisplayPlugin.class 2b. if
     * the list is not empty or if changes are made and test still fails then Mark
     * is wrong.
     * 
     * null when not getting from ctx. Context didnt add services and populate all
     * info and dependencies needed. NPE without anything instantiated
     * 
     *
     * //based on how Context is initialized it could change the getDisplayPlugins()
     * contents
     */

    /*
     * public static void main(String[] args) { DemoService d = new DemoService();
     * System.out.println(d); }
     */

    // context is a collection of plugins
    // service is a type of plugin
    // module look into scijava common particular type of plugin with io.
    // module has io
    // service access to methods. singleton utility classes

}
